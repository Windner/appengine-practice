package com.appengine.practice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@WebServlet(name = "Send_challengeEngine", value = "/send_challenge")
public class Send_challengeEngine extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO:send challenge to backend
        //Fake:Redirect action
        //resp.sendRedirect("http://www.google.com");
        //resp.setContentType("text/html;charset=UTF-8");

        // 要重定向的新位置
        //String site = new String("http://www.runoob.com");

        //resp.setStatus(resp.SC_MOVED_TEMPORARILY);
        //resp.setHeader("Location", site);
      URL url = new URL("https://us-central1-express-1122.cloudfunctions.net/function-1");
      HttpURLConnection connection = (HttpURLConnection)url.openConnection();

      // set http method if required
      connection.setRequestMethod("POST");

      // set request header if required
      connection.setRequestProperty("X-Goog-IAP-JWT-Assertion", "eyJhbGciOiJFUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6ImlicDA5ZyJ9.eyJpc3MiOiJodHRwczovL2Nsb3VkLmdvb2dsZS5jb20vaWFwIiwic3ViIjoiYWNjb3VudHMuZ29vZ2xlLmNvbToxMTE0MTE2ODA0NjI2NTY1NjU2NjAiLCJlbWFpbCI6ImNhbmRpY2VmZW5nQGdtYWlsLmNvbSIsImF1ZCI6Ii9wcm9qZWN0cy8yMjE1MzA5NjUzMzAvYXBwcy9leHByZXNzLTExMjIiLCJleHAiOjE1MjI3NTAxMjAsImlhdCI6MTUyMjc0OTUyMH0.3qeHXEZT54bBM07KCRktceQns6CiVt3Sk-n7gKZrKsmNhrIPNQIZa-G2X67AQv7o5pZSrEah9lckZNGt_UZdlQ");
      connection.setRequestProperty("X-Goog-Authenticated-User-ID", "accounts.google.com:111411680462656565660");
     
      // check status code
      if(connection.getResponseCode() == 200) {

         InputStream is = connection.getInputStream();
         //transfer is to the required output stream
      } else {
         //write error
      }
      resp.sendRedirect("/");
        
    }
}