package com.epam.tver.u2668.security;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class SecurityFilter implements Filter {

//    @Autowired
//    private UserContext userContext;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        System.out.println("--------========= filter");
//        System.out.println(userContext);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}

}
