package cn.appsys.controller.develop;

import cn.appsys.service.backend.BackendUserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/dev")
public class DevUserController {
    @Resource
    private BackendUserService backendUserService;
    private Logger logger = Logger.getLogger(DevUserController.class);

    @RequestMapping("/login")
    String login(){
        logger.debug("==================================>");
        return "devlogin";
    }
}
