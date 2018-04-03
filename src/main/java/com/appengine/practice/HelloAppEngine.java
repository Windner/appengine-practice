package com.appengine.practice;

import com.google.appengine.api.utils.SystemProperty;
import java.io.IOException;
import java.util.*;
import java.util.Enumeration;
import java.util.Properties;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloAppEngine", value = "/hello")
public class HelloAppEngine extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    Properties properties = System.getProperties();
    Enumeration<String> headerNames = request.getHeaderNames();
    response.setContentType("text/html;charset=UTF-8");
    response.getWriter().println("<!DOCTYPE html> \n" +
            "<html>\n" +
            "<head><meta charset=\"utf-8\"><title> HIHI </title></head>\n"+
            "<table width=\"100%\" border=\"1\" align=\"center\">\n" +
            "<tr bgcolor=\"#949494\">\n" +
            "<th>Header 名称</th><th>Header 值</th>\n"+
            "</tr>\n");
    if(headerNames != null) {

      while(headerNames.hasMoreElements()) {
        String paramName = headerNames.nextElement();
        response.getWriter().print("<tr><td>" + paramName + "</td>\n");
        String paramValue = request.getHeader(paramName);
        response.getWriter().println("<td> " + paramValue + "</td></tr>\n");
      }

    }

    response.getWriter().println("Hello App Engine - Standard using "
        + SystemProperty.version.get() + " Java " + properties.get("java.specification.version"));
    response.getWriter().println("</table>\n</body></html>");

  }

  public static String getInfo() {
    return "Version: " + System.getProperty("java.version")
          + " OS: " + System.getProperty("os.name")
          + " User: " + System.getProperty("user.name");
  }

}
