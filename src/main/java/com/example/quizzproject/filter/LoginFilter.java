package com.example.quizzproject.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns= "/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession oldSession = ((HttpServletRequest)servletRequest).getSession(false);
        if (oldSession == null || oldSession.getAttribute("user") == null) {
            servletRequest.setAttribute("exception", "Please login");
            servletRequest.setAttribute("url", ((HttpServletRequest)servletRequest).getRequestURL());
            servletRequest.getRequestDispatcher(((HttpServletRequest)servletRequest).getContextPath() + "/error.jsp").forward(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
    }
}
