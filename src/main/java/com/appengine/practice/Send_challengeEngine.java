package com.appengine.practice;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Send_challengeEngine", value = "/send_challenge")
public class Send_challengeEngine extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //TODO:send challenge to backend
      if (req.getParameter("challenge") != null)
        System.out.println("Challenge: " + req.getParameter("challenge").toString());
      else {
        ServletInputStream istream =  req.getInputStream();
        
        if (istream != null) 
        {
          System.out.println("challenge is not empty.");
       // Set response content type
          resp.setContentType("text/html");

         
          String title = "Using GET Method to Read Form Data";
          String docType =
             "<!doctype html public \"-//w3c//dtd html 4.0 " +
             "transitional//en\">\n";
             
          resp.getWriter().println(docType +
             "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                   "<h1 align = \"center\">" + title + "</h1>\n" +
                   "<ul>\n" +
                      "  <li><b>Challenge</b>: "
                      + req.getPart("challenge").toString() + "\n" +
                   "</ul>\n" +
                "</body> \n" +
             "</html>"
          );
        }
      }
   
    
   
      //Fake:Redirect action
      /*  
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
        System.out.println("can't connect to endpoint. Code: " + connection.getResponseCode());
      }
      //req.getRequestDispatcher("/").forward(req, resp);
       * 
      
      resp.getWriter().println(connection.getResponseMessage().toString());
*/
      
    }
}
