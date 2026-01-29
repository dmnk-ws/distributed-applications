package com.example.dist_app.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

/**
 * Servlet filter that enforces API key authentication for protected endpoints.
 */
@Component
public class ApiKeyFilter extends GenericFilterBean {

    /**
     * The expected API key value, injected from application.properties.
     */
    @Value("${app.api.key}")
    private String apiKey;

    /**
     * Filters incoming requests and enforces API key authentication for protected endpoints.
     *
     * @param servletRequest  the incoming servlet request
     * @param servletResponse the servlet response
     * @param filterChain     the filter chain for passing the request to the next filter
     * @throws IOException      if an I/O error occurs during filtering
     * @throws ServletException if a servlet error occurs during filtering
     */
    @Override
    public void doFilter(
        ServletRequest servletRequest,
        ServletResponse servletResponse,
        FilterChain filterChain
    ) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        String path = httpRequest.getRequestURI();

        if (path.startsWith("/saas") && httpRequest.getMethod().equals("GET")) {
            String requestApiKey = httpRequest.getHeader("X-API-KEY");

            if (!this.apiKey.equals(requestApiKey)) {
                httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                httpResponse.getWriter().write("Unauthorized");

                return;
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
