package cn.appsys.controller.backend;

import cn.appsys.pojo.BackendUser;
import cn.appsys.service.backend.BackendUserService;
import cn.appsys.tools.Constants;
import jdk.nashorn.internal.ir.IfNode;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/guanli")
public class BackUserController {
    private Logger logger = Logger.getLogger(BackUserController.class);
    @Resource
    private BackendUserService backendUserService;

    @RequestMapping("/login")
     String login(){
        logger.debug("======================");
       return "backendlogin";
    }

    @RequestMapping("/dologin")
    String dologin(@RequestParam String userCode, @RequestParam String userPassword, HttpServletRequest request, HttpSession session){
        logger.debug("===================================");
        BackendUser user = null;
        try {
            user=backendUserService.login(userCode,userPassword);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (null != user) {
            session.setAttribute(Constants.USER_SESSION,user);
            return "redirect:/guanli/backend/main";
        }else {
            //页面跳转（login.jsp）带出提示信息--转发
            request.setAttribute("error", "用户名或密码不正确");
            return "backendlogin";
        }
    }

    @RequestMapping("backend/main")
    String main(HttpSession session){
        if(session.getAttribute(Constants.USER_SESSION)==null){
            return "redirect:/guanli/login";
        }
        return "backend/main";
    }


    @RequestMapping(value="/logout")
    public String logout(HttpSession session){
        //清除session
        session.removeAttribute(Constants.USER_SESSION);
        return "backendlogin";
    }
}
