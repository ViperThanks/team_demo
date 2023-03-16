package com.team.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * author  : wl
 * email   : vieper0714@outlook.com
 * date     : 2023/3/15 18:14
 * desc     :
 */
@WebFilter(filterName = "loginFilter", urlPatterns = "/*")
@Slf4j
public class LoginFilter implements Filter {

    private static final String[] ignoreUrl =
            {
                    "/backend/**",
                    "/front/**",
                    "/common/**",
                    "/user/logout",
                    "/user/login",
            };

    private static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestURI = request.getRequestURI();

        log.info("Current Thread id is : " + Thread.currentThread().getId());
        //枚举所有不需要拦截的URI
        log.info("拦截到请求 : {}", requestURI);
        //检查这次request 的 uri 是否在urls里如果在就直接放行
        if (checkIsIgnore(requestURI)) {
            filterChain.doFilter(request, response);
            return;
        }
    }

    private boolean checkIsIgnore(String thisURI) {
        for (String url : ignoreUrl) {
            boolean match = PATH_MATCHER.match(url, thisURI);
            if (match) return true;
        }
        return false;
    }
}
