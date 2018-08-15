package com.marlee.myblog.controller;

import com.marlee.myblog.common.PageHelper;
import com.marlee.myblog.entity.User;
import com.marlee.myblog.entity.UserContent;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController extends BaseController{
    private final static Logger log = Logger.getLogger(IndexController.class);


    @RequestMapping("/index_list")
    public String findAllList(Model model, @RequestParam(value = "id",required = false) String id ,
                              @RequestParam(value = "pageNum",required = false) Integer pageNum ,
                              @RequestParam(value = "pageSize",required = false) Integer pageSize) {

        log.info( "===========进入index_list=========" );
        User user = (User)getSession().getAttribute("user");
        if(user!=null){
            model.addAttribute( "user",user );
        }
        PageHelper.Page<UserContent> page =  findAll(null,pageNum,  pageSize);
        model.addAttribute( "page",page );
        return "../index";
    }
}
