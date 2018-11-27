package cn.appsys.controller.backend;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guanli")
public class BackUserController {
    private Logger logger = Logger.getLogger(BackUserController.class);

    @RequestMapping("/login")
     String login(){
        logger.debug("======================");
       return "backendlogin";
    }
}
