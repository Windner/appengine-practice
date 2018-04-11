package com.appengine.practice;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Send_challengeEngine", value = "/send_challenge")
public class Send_challengeEngine extends HttpServlet {
private ServletInputStream  istream = null;
  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {
    if (istream != null)
    {
      System.out.println("challenge is not empty.");
   // Set response content type
      resp.setContentType("text/html; charset=UTF-8");


      String title = "Using GET Method to Read Form Data";
      String docType =
         "<!doctype html public \"-//w3c//dtd html 4.0 " +
         "transitional//en\">\n";

      resp.getWriter().println( docType +
         "<html>\n" +
            "<head><title>" + title + "</title></head>\n" +
            "<body bgcolor = \"#f0f0f0\">\n" +
               "<h1 align = \"center\">" + title + "</h1>\n" +
               "<ul>\n" +
                  "  <li><b>Challenge</b>: "
                   + "\n" +
               "</ul>\n" +
            "</body> \n" +
         "</html>"
      );
    }

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //TODO:send challenge to backend
      if (req.getParameter("challenge") != null)
        System.out.println("Challenge: " + req.getParameter("challenge").toString());
      else {
          istream =  req.getInputStream();


      }


   /*
      //Send parameter and file to gRPC client
      URL url = new URL("https://us-central1-express-1122.cloudfunctions.net/function-1");
      URLConnection con = url.openConnection();
      HttpURLConnection http = (HttpURLConnection)con;
      http.setRequestMethod("POST"); // PUT is another valid option
      http.setDoOutput(true);

      Map<String,String> arguments = new HashMap<>();
      arguments.put("X-Goog-IAP-JWT-Assertion", "https://us-central1-express-1122.cloudfunctions.net/function-1");
      arguments.put("X-Goog-Authenticated-User-ID", "accounts.google.com:111411680462656565660");

      StringJoiner sj = new StringJoiner("&");
      for(Map.Entry<String,String> entry : arguments.entrySet())
          sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "="
               + URLEncoder.encode(entry.getValue(), "UTF-8"));

      byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
      int length = out.length;
      http.setFixedLengthStreamingMode(length);
      http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
      http.connect();
      try(OutputStream os = http.getOutputStream()) {
          os.write(out);
      }*/

      /*Pass UnlockTocken to client
       *Reference https://stackoverflow.com/questions/5180375/sending-and-receiving-binary-data-in-servlets
       *
       */
      /*
      InputStream is = http.getInputStream();
      if(is != null){
        OutputStream os=resp.getOutputStream();
        byte[] buf = new byte[1000];
        for (int nChunk = is.read(buf); nChunk!=-1; nChunk = is.read(buf))
        {
            os.write(buf, 0, nChunk);
        }
      } */
    }
}
