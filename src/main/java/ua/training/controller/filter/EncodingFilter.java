package ua.training.controller.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Filter sets the request body character encoding
 * @author Pavel Denisenko
 * @since 05.03.2019
 */
public class EncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

}
