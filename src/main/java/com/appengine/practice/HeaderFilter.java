package com.appengine.practice;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import com.appengine.practice.VerifyIapRequestHeader;


public class HeaderFilter implements Filter  {
    @Override
    public void  init(FilterConfig config) throws ServletException {
        // 获取初始化参数
        String site = config.getInitParameter("Site");

        // 输出初始化参数
        System.out.println("Site Name: " + site);
    }
    @Override
    public void  doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws java.io.IOException, ServletException {

        // 输出站点名称
        System.out.println("Site Name：I won't tell you.");
        HttpServletRequest httpServleRequest = (HttpServletRequest)request;
        Enumeration<String> headerNames = httpServleRequest.getHeaderNames();
        String jwt = null;
        System.out.println("Path: " + httpServleRequest.getRequestURI());
        System.out.println("Request Header: ");
        if(headerNames != null) {

            while(headerNames.hasMoreElements()) {
                String paramName = headerNames.nextElement();
                System.out.print(paramName + " ");
                String paramValue = httpServleRequest.getHeader(paramName);
                System.out.print(paramValue + ",");
                if ( paramName.equals("X-Goog-IAP-JWT-Assertion")) {
                  
                  jwt = paramValue;
                }
            }

        }
        else
            System.out.println("no value.");
        
        ///projects/221530965330/apps/express-1122
        long projectNum = 221530965330L;
        String projectID = "express-1122";
        boolean VerifyResult = false;
        VerifyIapRequestHeader verifyHeader = new VerifyIapRequestHeader();
        try {
          VerifyResult = verifyHeader.verifyJwtForAppEngine(jwt, projectNum, projectID);
        } catch (Exception e) {
          // TODO(candicefeng): Auto-generated catch block
          e.printStackTrace();
        }
        System.out.println("Verify Result: " + VerifyResult);
        // 把请求传回过滤链
        chain.doFilter(request,response);
    }
    @Override
    public void destroy( ){
        /* 在 Filter 实例被 Web 容器从服务移除之前调用 */
    }
}
