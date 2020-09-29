package com.ruoyi.stations_management.report.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.stations_management.report.domain.*;
import com.ruoyi.stations_management.report.mapper.MtHeadMapper;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class Mt4406CreateMessage {

    @Autowired
    private MtHeadMapper mtHeadMapper;
    //空箱确报路径地址
    @Value("${XML.OutBox}")
    private String OutBox;
    @Value("${XML.Inbox}")
    private String Inbox;
    @Value("${XML.SentBox}")
    private String SentBox;




    @Async("ThreadPoolConfig")
    // 每5秒 查询一次 进行上传
//    @Scheduled(cron = "*/5 * * * * ? ")
    public void run() {
        List<Rmft4406Head> mtHead = mtHeadMapper.selectXml();
        for (Rmft4406Head Head1 : mtHead) {
            createThreeXml(Head1);
            mtHeadMapper.updateRmft4406Statementcode(Head1);
        }
    }

    //  公路出口空集装箱（器） 运输工具承运确报（装载舱单） 申请

    public String createThreeXml(Rmft4406Head rmft4406Head) {

        try {


            // 创建一个Document实例
            Document doc = DocumentHelper.createDocument();
            Element root = doc.addElement("Manifest","urn:Declaration:datamodel:standard:CN:MT4406:1");
                    root.addNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
                    root.addAttribute("xmlns:xsd", "http://www.w3.org/2001/XMLSchema");



            // 在根节点下添加第一个子节点
            Element oneChildElement = root.addElement("Head");
            oneChildElement.addElement("MessageID")
                    .addText(StringUtils.replaceNullString(rmft4406Head.getMessageId()));
            oneChildElement.addElement("FunctionCode")
                    .addText(StringUtils.replaceNullString(rmft4406Head.getFunctionCode()));
            oneChildElement.addElement("MessageType")
                    .addText(StringUtils.replaceNullString((rmft4406Head.getMessageType())));
            oneChildElement.addElement("SenderID")
                    .addText(StringUtils.replaceNullString(rmft4406Head.getSenderId()));
            oneChildElement.addElement("ReceiverID")
                    .addText(StringUtils.replaceNullString(rmft4406Head.getReceiverId()));
            oneChildElement.addElement("SendTime")
                    .addText(StringUtils.replaceNullString(rmft4406Head.getSendTime()));
            oneChildElement.addElement("Version")
                    .addText(StringUtils.replaceNullString(rmft4406Head.getVersion()));

            Element twoChildElement = root.addElement("Declaration");
            twoChildElement.addElement("DeclarationOfficeID")
                    .addText(StringUtils.replaceNullString(rmft4406Head.getDeclarationOfficeId()));
            twoChildElement.addElement("ID")
                    .addText(StringUtils.replaceNullString(rmft4406Head.getId()));

            Element twoOneChildElement = twoChildElement.addElement("AdditionalInformation");
            twoOneChildElement.addElement("Content")
                    .addText(StringUtils.replaceNullString(rmft4406Head.getAdditionalInformation()));

            Element twoTwoChildElement = twoChildElement.addElement("Carrier");
            twoTwoChildElement.addElement("ID")
                    .addText(StringUtils.replaceNullString(rmft4406Head.getCarrier()));

            Element twoThreeChildElement = twoChildElement.addElement("Consignment");
            // 2-3-1 的子节点
            Element twoThreeOneChildElement = twoThreeChildElement.addElement("BorderTransportMeans");
            twoThreeOneChildElement.addElement("ArrivalDateTime")
                    .addText(StringUtils.replaceNullString(rmft4406Head.getBorderTransportMeans().getArrivalDateTime()));
            twoThreeOneChildElement.addElement("ID")
                    .addText(StringUtils.replaceNullString(rmft4406Head.getBorderTransportMeans().getBorderId()));
            twoThreeOneChildElement.addElement("Name")
                    .addText(StringUtils.replaceNullString(rmft4406Head.getBorderTransportMeans().getName()));
            twoThreeOneChildElement.addElement("TypeCode")
                    .addText(StringUtils.replaceNullString(rmft4406Head.getBorderTransportMeans().getTypeCode()));
            // 2-3-2 的节点
            Element twoThreeTwoChildElement = twoThreeOneChildElement.addElement("Master");
            twoThreeTwoChildElement.addElement("ID")
                    .addText(StringUtils.replaceNullString(rmft4406Head.getBorderTransportMeans().getMasterId()));
            twoThreeTwoChildElement.addElement("Name")
                    .addText(StringUtils.replaceNullString(rmft4406Head.getBorderTransportMeans().getMasterName()));

            for (Rmft4406Bordertransportequipment mt : rmft4406Head.getBorderTransportEquipment()) {
                Element twoThreeThreeChildElement = twoThreeOneChildElement.addElement("TransportEquipment");
                twoThreeThreeChildElement.addElement("ID")
                        .addText(StringUtils.replaceNullString(mt.getTransportId()));
                twoThreeThreeChildElement.addElement("TareWeight")
                        .addAttribute("unitCode", "KGM")
                        .addText(StringUtils.replaceNullString(mt.getTareWeight()));
                twoThreeThreeChildElement.addElement("TypeCode")
                        .addText(StringUtils.replaceNullString(mt.getTypeCode()));

            }
            // 2-3-3 的节点


            // 2-3-6 的节点
            Element twoThreeSixChildElement = twoThreeChildElement.addElement("GovernmentProcedure");
            twoThreeSixChildElement.addElement("CurrentCode")
                    .addText(StringUtils.replaceNullString(rmft4406Head.getConsignment().getGovernmentProcedure()));

            for (Rmft4406Transportequipment coal : rmft4406Head.getTransportEquipment()) {
                // 2-3-7 的节点
                Element twoThreeSevenChildElement = twoThreeChildElement.addElement("TransportEquipment");
                twoThreeSevenChildElement.addElement("CharacteristicCode")
                        .addText(StringUtils.replaceNullString(coal.getCharacteristicCode()));
                twoThreeSevenChildElement.addElement("ID")
                        .addText(StringUtils.replaceNullString(coal.getTransportEquipmentId()));
                twoThreeSevenChildElement.addElement("SupplierPartyTypeCode")
                        .addText(StringUtils.replaceNullString(coal.getSupplierPartyTypeCode()));
                twoThreeSevenChildElement.addElement("TareWeight")
                        .addAttribute("unitCode", "KGM")
                        .addText(StringUtils.replaceNullString(coal.getTareWeight()));
            }


            // 2-4的节点
            Element twoFourChildElement = twoChildElement.addElement("LoadingLocation");
            twoFourChildElement.addElement("ID")
                    .addText(StringUtils.replaceNullString(rmft4406Head.getLoadingLocation()));
            // 2-5的节点
            Element twoFiveChildElement = twoChildElement.addElement("RepresentativePerson");
            twoFiveChildElement.addElement("Name")
                    .addText(StringUtils.replaceNullString(rmft4406Head.getRepresentativePerson()));


            OutputFormat format = new OutputFormat();
            format.setIndentSize(2);  // 行缩进
            format.setNewlines(true); // 一个结点为一行
            format.setTrimText(true); // 去重空格
            format.setPadText(true);
            format.setNewLineAfterDeclaration(false); // 放置xml文件中第二行为空白行


            Date date = new Date();
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
            String Times = sf.format(date);
            String time = Times.replaceAll("[[\\s-:punct:]]", "");


            // 判断是否有当前文件夹
            File folder = new File(OutBox);
            if (!folder.exists() && !folder.isDirectory()) {
                folder.mkdirs();
            }

            // 自定义xml样式
            OutputFormat oFormat = OutputFormat.createPrettyPrint ();
            oFormat.setEncoding ("UTF-8");
            StringWriter sWriter = new StringWriter ();
            XMLWriter xWriter = new XMLWriter (sWriter, oFormat);
            try {
                xWriter.write (doc);
                xWriter.flush ();
                xWriter.close ();
            } catch (IOException e) {
                System.err.println ("转换xml异常！");
            }
            String stringXml = sWriter.toString ();

            /*
             * 生成你的xml数据，存在String xml中。
             */
            //声明ZipOutputStream，用来输出zip文件。
            ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(OutBox + "\\" + "CN_MT4406_1p0_" + rmft4406Head.getSenderId() + time + ".zip"));
            //声明ZipEntry
            ZipEntry entry = new ZipEntry("CN_MT4406_1p0_" + rmft4406Head.getSenderId() + time + ".xml");

            zipOut.setEncoding("UTF-8");
            //将entry加入到zipOut中。
            zipOut.putNextEntry(entry);
            zipOut.write(stringXml.getBytes());
            //利用DataOutputStream对ZipOutputStream进行包装。
            DataOutputStream dataOs = new DataOutputStream(zipOut);
            //输出zip文件。
            zipOut.close();
            //dataOs.writeUTF(doc.asXML());
            //关闭流
            //dataOs.close();

//            File file = new File("d:\\xml\\" + "CN_MT4406" + rmft4406Head.getSenderid() + time + ".xml");
//            XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
//            writer.write(doc);

            System.out.println("dom4j CreateDom4j success!");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Async("ThreadPoolConfig")
    // 每6秒执行一次
//    @Scheduled(cron = "*/6 * * * * ? ")
    //解析确报XML
    public void ADDQBXML() throws IOException, DocumentException {
        //创建dom4j解析器
        SAXReader sax = new SAXReader();
        //新建一个File对象 接收 文件夹路径
        File xmlfile = new File(Inbox);
        //创建 File数组 接收xmlfile路径下的文件名
        File[] fs = xmlfile.listFiles();
        //遍历路径下的所有文件名 循环放入document
        for (File e : fs) {
            //加载document对象
            Document document = sax.read(e);
            //得到根节点
            Element root = document.getRootElement();
            Rmft4406Head rmft4406Head = new Rmft4406Head();
            //把根节点给到下面方法参数内
            getNodes(root, rmft4406Head);
            //判断是否有当前文件夹 格式为当前时间 YYYY_MM_DD
            File folder = new File(SentBox+"\\"+ DateUtils.getDate());
            if (!folder.exists() && !folder.isDirectory()) {
                folder.mkdirs();
            }
            //判断是否有当前文件 没有则创建
            File folders = new File(SentBox+"\\"+DateUtils.getDate()+e);
            if(!folders.exists() && !folders.isDirectory()){
                folders.mkdirs();
            }
            //原始文件路径
            String oldfilePath=e.toString();
            //目标文件路径
            File file =new File(SentBox+"\\"+DateUtils.getDate()+"\\"+e.getName());
            FileOutputStream output = new FileOutputStream(file);
            //原始文件写入到目标文件
            FileUtils.writeBytes(oldfilePath,output);
            //删除相应文件
            e.delete();
        }
    }
    private void getNodes(Element node, Rmft4406Head rmft4406Head) {
        //将messageid 赋值到iRmft4404Head中
        if (node.getName().equals("MessageID") ) {
            rmft4406Head.setMessageId(node.getTextTrim());
        }
        //将状态值 StatmentCode 赋值到iRmft4404Head中
        if (node.getName().equals("StatementCode") ) {
            if(node.getTextTrim().equals("0")){
                rmft4406Head.setStatementCode("3");
            }else {
                rmft4406Head.setStatementCode("4");
            }
        }
        //将调用状态 StatmentDescription赋值到iRmft4404Head中
        if (node.getName().equals("StatementDescription")) {
            rmft4406Head.setStatementDescription(node.getTextTrim());
            mtHeadMapper.updateRmft4406(rmft4406Head);

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
            this.getNodes(e, rmft4406Head);//递归
        }
    }




}
