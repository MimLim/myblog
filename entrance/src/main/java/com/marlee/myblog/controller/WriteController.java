package com.marlee.myblog.controller;

import com.marlee.myblog.entity.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: Liming
 * @Date: 2018/8/17 10:33
 * @Description:
 */
@Controller
public class WriteController extends BaseController{
    private final static Logger log = Logger.getLogger(WriteController.class);
    @RequestMapping("/writedream")
    public String writedream(Model model) {
        User user = (User) getSession().getAttribute("user");
        model.addAttribute("user", user);
        return "write/writedream";
    }
}
