package com.eleapp.intercepters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by ʤ�� on 2016/10/2. �������е�½�û�
 */
public class loginIntercepter implements HandlerInterceptor {
    /*@Autowired
    RbacService rbacService;
    @Autowired
    AdminUserService adminUserService;*/

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*HttpSession session=request.getSession();
        YbsRbacUser ybsRbacUser = (YbsRbacUser) session.getAttribute("ybsRbacUser");
        if(ybsRbacUser ==null){
            String servletPath=request.getServletPath();
            System.out.println(">>>session�޵�¼��Ϣ,���Զ�ȡcokie---->�����ַ��"+servletPath);
            response.sendRedirect("login");
            return false;
        }*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub

    }

}

