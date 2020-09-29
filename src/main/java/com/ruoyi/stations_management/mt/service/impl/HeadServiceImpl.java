package com.ruoyi.stations_management.mt.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.stations_management.common.domain.StationInfo;
import com.ruoyi.stations_management.common.mapper.StationInfoMapper;
import com.ruoyi.stations_management.mt.domain.BorderTransportEquipment;
import com.ruoyi.stations_management.mt.domain.BorderTransportMeans;
import com.ruoyi.stations_management.mt.domain.Consignment;
import com.ruoyi.stations_management.mt.domain.Head;
import com.ruoyi.stations_management.mt.mapper.IBorderTransportMeansMapper;
import com.ruoyi.stations_management.mt.mapper.IConsignmentMapper;
import com.ruoyi.stations_management.mt.mapper.IHeadMapper;
import com.ruoyi.stations_management.mt.service.IHeadService;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 报文头信息Service业务层处理
 *
 * @author lanzhenyuan
 * @date 2020-07-27
 */
@Service
public class HeadServiceImpl implements IHeadService {
    @Resource
    private IHeadMapper iHeadMapper;
    @Resource
    private StationInfoMapper stationInfoMapper;
    @Resource
    private IBorderTransportMeansMapper iBorderTransportMeansMapper;
    @Resource
    private IConsignmentMapper iConsignmentMapper;
    //    #空载确报路径地址
    @Value("${XML.OutBox}")
    private String OutBox;
    @Value("${XML.Inbox}")
    private String Inbox;
    @Value("${XML.SentBox}")
    private String SentBox;

    /**
     * 查询空载信息列表
     *
     * @param head 报文头信息
     * @return 空载信息列表
     */
    @Override
    public List<Head> selectHeadList(Head head) {
        return iHeadMapper.selectHeadList(head);
    }

    /**
     * 查询异常车辆信息
     *
     * @param head 运输工具信息
     * @return 异常车辆信息 集合
     */
    @Override
    public List<Head> selectErrList(Head head) {

        return iHeadMapper.selectErrList(head);
    }

    /**
     * @param messageId 唯一标识
     * @return 报文头信息
     */
    public Head selectIMtHead06ById(String messageId) {
        StationInfo stationInfo = stationInfoMapper.init();
        Head head = iHeadMapper.selectHeadById(messageId);
        // 将属性值赋值
        BeanUtils.copyBeanProp(head, stationInfo);
        return head;
    }

    /**
     * 新增页面 初始化
     */
    public Head init() {
        StationInfo stationInfo = stationInfoMapper.init();
        Head head = new Head();
        // 将属性值赋值
        head.setCustomsMaster(stationInfo.getCustomsmaster());
        head.setStationPersonName(stationInfo.getStationPersonName());
        head.setContractorCodeScc(stationInfo.getContractorcodescc());
        return head;
    }

    /**
     * 新增报文头信息
     *
     * @param head 报文头信息
     * @return 结果
     */
    @Override
    @Transactional
    public Map<String, String> insertHead(Head head) {
        //17位时间值
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String orderNo = dateFormat.format(new Date());
        //stationinfo 场站数据
        StationInfo stationInfo = stationInfoMapper.init();
        //给到iRmft4404Head中相应的set方法
        head.setFunctionCode("2");
        head.setMessageType("MT4404");
        head.setSendTime(orderNo);
        head.setVersion(stationInfo.getVersion());
        head.setRepresentativePerson(stationInfo.getStationPersonName());
        head.setDeclarationOfficeId(stationInfo.getCustomsmaster());
        head.setContractorCodeScc(stationInfo.getContractorcodescc());
        head.setReceiverId(stationInfo.getReceiverid());
        //拼接messageId值
        head.setMessageId("CN_MT4404_1P0" + stationInfo.getCustomsmaster() + stationInfo.getContractorcode() + "_" + orderNo);
        //拼接senderID
        head.setSenderId(stationInfo.getCustomsmaster() + stationInfo.getContractorcode() + "_" + stationInfo.getSenderid());
        // 相应值给到iRmft4404Consignment实体类中
        Consignment consignment = head.getConsignment();
        //set 进相应关联条件
        consignment.setMessageId(head.getMessageId());
        //相应值给到iRmft4404Bordertransportmeans实体类中
        BorderTransportMeans borderTransportMeans = head.getBorderTransportMeans();
        iHeadMapper.insertHead(head);
        iConsignmentMapper.insertConsignment(consignment);
        //set进相应关联条件
        borderTransportMeans.setConsignmentId(consignment.getId());
        borderTransportMeans.setTypeCode("4");
        iBorderTransportMeansMapper.insertBorderTransportMeans(borderTransportMeans);
        //声明一个map 接收到与挂车数据库关联条件数据
        Map map = new HashMap();
        map.put("id", consignment.getId());
        map.put("messageid", head.getMessageId());
        return map;
    }

    /**
     * 修改报文头信息
     *
     * @param head 报文头信息
     * @return 结果
     */
    @Override
    @Transactional
    public int updateHead(Head head) {
        BorderTransportMeans borderTransportMeans = head.getBorderTransportMeans();
        borderTransportMeans.setConsignmentId(Long.valueOf(head.getMessageId()));
        Consignment consignment = head.getConsignment();
        consignment.setMessageId(head.getMessageId());
        int row = 0;
        row = iHeadMapper.updateConsignment(consignment);
        row = iHeadMapper.updateHead(head);
        row = iHeadMapper.updateBorderTransportMeans(borderTransportMeans);
        return row;
    }

    /**
     * 修改报文申报状态
     *
     * @param head
     * @return
     */
    @Override
    public int updateCode(Head head) {
        return iHeadMapper.updateCode(head);
    }

    /**
     * 查询空载列表
     *
     * @param bordertransportmeansId
     * @return
     */
    public List<BorderTransportEquipment> selectCarById(Long bordertransportmeansId) {
        return iHeadMapper.selectCarById(bordertransportmeansId);
    }

    /**
     * 查询空载详细
     *
     * @param id
     * @return
     */
    public BorderTransportEquipment selectCarAllById(Long id) {
        return iHeadMapper.selectCarAllById(id);
    }

    /**
     * 修改空车信息
     *
     * @param borderTransportEquipment
     * @return
     */
    public int updateCarById(BorderTransportEquipment borderTransportEquipment) {
        return iHeadMapper.updateCarById(borderTransportEquipment);
    }

    /**
     * 批量删除报文头信息
     *
     * @param messageids 需要删除的报文头信息ID
     * @return 结果
     */
    @Override
    public int deleteHeadByIds(String[] messageids) {
        return iHeadMapper.deleteHeadByIds(messageids);
    }

    /**
     * 查询空载XML数据
     *
     * @return
     */
    public List<Head> selectConfirmation() {
        return iHeadMapper.ConfirmationXML();
    }

    /**
     * 生成空载确报XML
     *
     * @param head
     */
    public void ConfirmationXML(Head head) {
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar calendar = Calendar.getInstance();
        String dateName = df.format(calendar.getTime());
        try {
            //创建实例
            Document doc = DocumentHelper.createDocument();
            //头部报文
            Element root = doc.addElement("Manifest", "urn:Declaration:datamodel:standard:CN:MT4404:1");
            root.addNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
            root.addAttribute("xmlns:xsd", "http://www.w3.org/2001/XMLSchema");


            //创建一个子节点
            Element OneHead = root.addElement("Head");
            OneHead.addElement("MessageID").addText(StringUtils.replaceNullString(head.getMessageId()));
            OneHead.addElement("FunctionCode").addText(StringUtils.replaceNullString(head.getFunctionCode()));
            OneHead.addElement("MessageType").addText(StringUtils.replaceNullString(head.getMessageType()));
            OneHead.addElement("SenderID").addText(StringUtils.replaceNullString(head.getSenderId()));
            OneHead.addElement("ReceiverID").addText(StringUtils.replaceNullString(head.getReceiverId()));
            OneHead.addElement("SendTime").addText(StringUtils.replaceNullString(head.getSendTime()));
            OneHead.addElement("Version").addText(StringUtils.replaceNullString(head.getVersion()));

            Element IDeclaration = root.addElement("Declaration");
            IDeclaration.addElement("DeclarationOfficeID").addText(StringUtils.replaceNullString(head.getDeclarationOfficeId()));
            IDeclaration.addElement("ID").addText(StringUtils.replaceNullString(head.getId()));

            Element IIDeclaration = IDeclaration.addElement("AdditionalInformation");
            IIDeclaration.addElement("Content").addText(StringUtils.replaceNullString(head.getAdditionalInformation()));

            Element IIIDeclaration = IDeclaration.addElement("Carrier");
            IIIDeclaration.addElement("ID").addText(StringUtils.replaceNullString(head.getCarrier()));

            Element IConsignment = IDeclaration.addElement("Consignment");

            Element IBorderTransportMeans = IConsignment.addElement("BorderTransportMeans");
            IBorderTransportMeans.addElement("ArrivalDateTime").addText(StringUtils.replaceNullString(head.getBorderTransportMeans().getArrivalDateTime()));
            IBorderTransportMeans.addElement("ID").addText(StringUtils.replaceNullString(head.getBorderTransportMeans().getBorderId()));
            IBorderTransportMeans.addElement("Name").addText(StringUtils.replaceNullString(head.getBorderTransportMeans().getName()));
            IBorderTransportMeans.addElement("TypeCode").addText(StringUtils.replaceNullString(head.getBorderTransportMeans().getTypeCode()));

            Element IIborderTransportMeans = IBorderTransportMeans.addElement("Master");
            IIborderTransportMeans.addElement("ID").addText(StringUtils.replaceNullString(head.getBorderTransportMeans().getMasterId()));
            IIborderTransportMeans.addElement("Name").addText(StringUtils.replaceNullString(head.getBorderTransportMeans().getMasterName()));
            //遍历当前包装类数据 循环增加XML子节点
            for (BorderTransportEquipment sport : head.getBorderTransportEquipments()) {
                Element IIIborderTransportMeans = IBorderTransportMeans.addElement("TransportEquipment");
                IIIborderTransportMeans.addElement("ID").addText(StringUtils.replaceNullString(sport.getTransportId()));
                IIIborderTransportMeans.addElement("TareWeight").addAttribute("unitCode", "KGM").addText(StringUtils.replaceNullString(sport.getTareWeight()));
                IIIborderTransportMeans.addElement("TypeCode").addText(StringUtils.replaceNullString(sport.getTypeCode()));
            }

            Element IRepresentativePerson = IDeclaration.addElement("RepresentativePerson");
            IRepresentativePerson.addElement("Name").addText(StringUtils.replaceNullString(head.getRepresentativePerson()));

            //xml样式
            OutputFormat format = new OutputFormat();
            format.setIndentSize(2);//行缩进
            format.setNewlines(true);//一个结点为一行
            format.setTrimText(true);//去除空格
            format.setPadText(true);
            format.setNewLineAfterDeclaration(false);//放置xml文件中第二行为空白行

            // 自定义xml样式
            OutputFormat oFormat = OutputFormat.createPrettyPrint();
            oFormat.setEncoding("UTF-8");
            StringWriter sWriter = new StringWriter();
            XMLWriter xWriter = new XMLWriter(sWriter, oFormat);
            try {
                xWriter.write(doc);
                xWriter.flush();
                xWriter.close();
            } catch (IOException e) {
                System.err.println("转换xml异常！");
            }
            String stringXml = sWriter.toString();

            //判断是否有当前文件夹
            File folder = new File(OutBox);
            if (!folder.exists() && !folder.isDirectory()) {
                folder.mkdirs();
                System.out.println("创建成功");
            }
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(OutBox + "\\" + "CN_MT4404_1p0_" + head.getSenderId() + dateName + ".zip"));
            //XML
            ZipEntry entry = new ZipEntry("CN_MT4404_1p0_" + head.getSenderId() + dateName + ".xml");
            //设定压缩编码
            zipOutputStream.setEncoding("UTF-8");
            //XML放入到zip中
            zipOutputStream.putNextEntry(entry);
            //写入xml
            zipOutputStream.write(stringXml.getBytes());
            //关闭流
            zipOutputStream.close();
            System.out.println("dom4j 输出成功");
            iHeadMapper.updateEmptyCarCode(head.getMessageId());
            System.out.println("确报状态修改成功,修改目标MessageId为:" + head.getMessageId());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //解析确报XML
    public void addQBXml() throws IOException, DocumentException {
        //创建dom4j解析器
        SAXReader sax = new SAXReader();
        //新建一个File对象 接收 文件夹路径
        File xmlfile = new File(Inbox);
        //判断接收文件夹是否存在 不存在则创建
        if (!xmlfile.exists() && !xmlfile.isDirectory()) {
            xmlfile.mkdirs();
        }
        //创建 File数组 接收xmlfile路径下的文件名
        File[] fs = xmlfile.listFiles();
        //遍历路径下的所有文件名 循环放入document
        for (File e : fs) {
            //加载document对象
            System.err.println(e.getName());
            Document document = sax.read(e);
            //得到根节点
            Element root = document.getRootElement();
            Head head = new Head();
            //把根节点给到下面方法参数内
            getNodes(root, head);
            //判断是否有当前文件夹 格式为当前时间 YYYY_MM_DD
            File folder = new File(SentBox + "\\" + DateUtils.getDate());
            if (!folder.exists() && !folder.isDirectory()) {
                folder.mkdirs();
            }
            //判断是否有当前文件 没有则创建
            File folders = new File(SentBox + "\\" + DateUtils.getDate() + e);
            if (!folders.exists() && !folders.isDirectory()) {
                folders.mkdirs();
            }
            //原始文件路径
            String oldfilePath = e.toString();
            //目标文件路径
            File file = new File(SentBox + "\\" + DateUtils.getDate() + "\\" + e.getName());
            FileOutputStream output = new FileOutputStream(file);
            //原始文件写入到目标文件
            FileUtils.writeBytes(oldfilePath, output);
            //删除相应文件
            e.delete();
        }
    }

    private void getNodes(Element node, Head head) {
        //将messageid 赋值到iRmft4404Head中
        if (node.getName().equals("MessageID")) {
            head.setMessageId(node.getTextTrim());
        }
        //将状态值 StatmentCode 赋值到iRmft4404Head中
        if (node.getName().equals("StatementCode")) {
            if (node.getTextTrim().equals("0")) {
                head.setStatementCode("3");
            } else {
                head.setStatementCode("4");
            }
        }
        //将调用状态 StatmentDescription赋值到iRmft4404Head中
        if (node.getName().equals("StatementDescription")) {
            head.setStatementDescription(node.getTextTrim());
            iHeadMapper.updateStatus(head);
        }
        //当前节点所有属性的list
        List<Attribute> attlist = node.attributes();
        //遍历所有的list
        for (Attribute attr : attlist) {
            //获取当前属性名
            String name = attr.getName();
            //获取当前属性值
            String value = attr.getValue();
        }
        //递归遍历
        List<Element> listElement = node.elements();
        for (Element e : listElement) {//遍历所有一级子节点
            this.getNodes(e, head);//递归
        }
    }
}
