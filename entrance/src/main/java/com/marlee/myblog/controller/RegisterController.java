package com.marlee.myblog.controller;

import com.marlee.myblog.common.CodeCaptchaServlet;
import com.marlee.myblog.common.OperateMessage;
import com.marlee.myblog.entity.User;
import com.marlee.myblog.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RegisterController {
    private final static Logger log = Logger.getLogger(RegisterController.class);
    @Autowired
    private UserService userService;

    @RequestMapping("/checkPhone")
    @ResponseBody
    public OperateMessage checkPhone(Model model, @RequestParam(value = "phone", required = false) String phone){
        //Map<String,Object> map=new HashMap<>();
        log.debug("注册-判断手机号" + phone + "是否可用");
        User user=userService.findByPhone(phone);

        if (user==null) {
            //未注册
            return  OperateMessage.success("该手机号未注册！");
        } else {
            //已注册
            return  OperateMessage.error("该手机号已经注册！");
        }

    }


    /**
     * 判断邮箱是否已经被注册
     *
     * @param model
     * @param email
     * @return
     */
    @RequestMapping("/checkEmail")
    @ResponseBody
    public Map<String, Object> checkEmail(Model model, @RequestParam(value = "email", required = false) String email) {
        log.debug("注册-判断邮箱" + email + "是否可用");
        Map map = new HashMap<String, Object>();
        User user = userService.findByEmail(email);
        if (user == null) {
            //未注册
            map.put("message", "success");
        } else {
            //已注册
            map.put("message", "fail");
        }

        return map;
    }


    /**
     * 判断验证码是否正确
     *
     * @param model
     * @param code
     * @return
     */
    @RequestMapping("/checkCode")
    @ResponseBody
    public Map<String, Object> checkCode(Model model, @RequestParam(value = "code", required = false) String code) {
        log.debug("注册-判断验证码" + code + "是否可用");
        Map map = new HashMap<String, Object>();
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String vcode = (String) attrs.getRequest().getSession().getAttribute(CodeCaptchaServlet.VERCODE_KEY);

        if (code.equals(vcode)) {
            //未注册
            map.put("message", "success");
        } else {
            //已注册
            map.put("message", "fail");
        }

        return map;
    }


}
