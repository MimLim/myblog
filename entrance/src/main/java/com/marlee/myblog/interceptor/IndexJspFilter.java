package com.marlee.myblog.interceptor;

import com.marlee.myblog.common.PageHelper;
import com.marlee.myblog.controller.BaseController;
import com.marlee.myblog.dao.UserContentDao;
import com.marlee.myblog.entity.User;
import com.marlee.myblog.entity.UserContent;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import java.io.IOException;
import java.util.List;

public class IndexJspFilter extends BaseController implements Filter{

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        User user = getCurrentUser();
        request.setAttribute("user",user);
        System.out.println("===========自定义过滤器==========");
        ServletContext servletContext = request.getServletContext();
        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        UserContentDao userContentDao = applicationContext.getBean(UserContentDao.class);
        PageHelper.startPage(null, null);//开始分页
        List<UserContent> list = userContentDao.findByJoin(null);
        PageHelper.Page endPage = PageHelper.endPage();//分页结束
        request.setAttribute("page", endPage );
        chain.doFilter(request, response);
    }

    public void destroy() {

    }

}
