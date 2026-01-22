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
import java.util.ArrayList;
import java.util.List;

@Component
public class TenantFilter extends GenericFilterBean {

    @Value("${app.allowed.tenants}")
    private String allowedTenants;

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
            String tenant = httpRequest.getHeader("TENANT-ID");

            if (!this.containsTenant(tenant)) {
                httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                httpResponse.getWriter().write("Unauthorized");

                return;
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private Boolean containsTenant(String tenant) {
        return new ArrayList<>(
            List.of(this.allowedTenants.split(","))
        ).contains(tenant);
    }
}
