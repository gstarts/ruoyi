package com.ruoyi.stations_management.Confirmation;

import com.ruoyi.stations_management.mt.domain.Head;
import com.ruoyi.stations_management.mt.service.IHeadService;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service

public class confirmationXML {
    //自动装配 Head业务类
    @Autowired
    private IHeadService iHeadService;

    //计时器注解 5秒执行一次
//    @Scheduled(cron = "*/5 * * * * ? ")
    //控制查询确报XML/生成XML方法
    public void Confirmation() {
        //查询空载确报数据
        List<Head> heads = iHeadService.selectConfirmation();
        //判断是否为空
        if (heads.size() > 0) {
            //遍历所有集合
            for (Head head : heads) {
                iHeadService.ConfirmationXML(head);
            }
        }
    }
//   @Scheduled(cron = "*/6 * * * * ? ")
    public void  Status() throws IOException, DocumentException {
        iHeadService.addQBXml();
    }
}
