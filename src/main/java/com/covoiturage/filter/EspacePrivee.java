package com.covoiturage.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EspacePrivee implements Filter {
    private static final String ATT_SESSION_USERID = "userId";
    private static final String VUE_AUTHENTIFICATION = "/authentification" ;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession();

        if(session.getAttribute(ATT_SESSION_USERID) == null ){
            resp.sendRedirect(req.getContextPath()+VUE_AUTHENTIFICATION);
        } else {
            chain.doFilter(req,resp);
        }
    }

    @Override
    public void destroy() {

    }
}
