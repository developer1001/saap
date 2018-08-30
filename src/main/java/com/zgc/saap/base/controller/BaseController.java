package com.zgc.saap.base.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 *controller的父类，子类可以继承
 */
@Controller
public class BaseController {

    /**
     * 对象转json
     * @param object
     * @param response
     */
    public void writeJson(Object object, HttpServletResponse response){
        String json = JSONObject.toJSONString(object);
        System.out.print(json);
        response.setContentType("text/html;charset=UTF-8");
        try {
            Writer writer = response.getWriter();
            writer.write(json);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
	
	  /**
   * 对象转json,将io流读取的字符串处理后，response给视图
   * @param object
   * @param response
   */
   public void ioToJson(Object ioString, HttpServletResponse response){
  	  net.sf.json.JSONObject json = net.sf.json.JSONObject.fromObject(ioString);
      System.out.print(json);
      response.setContentType("text/html;charset=UTF-8");
      try {
          Writer writer = response.getWriter();
          writer.write(json.toString());
          writer.flush();
          writer.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
  }

   /**
    * 根据url，io流读取接口数据，返回字符串数据
    * @param response
    * @param url
    */
	public void getInfo(HttpServletResponse response,String url) {
          String result = "";
          OutputStreamWriter out = null;
          BufferedReader in = null;         
          try {
              URL realUrl = new URL(url);
              // 打开和URL之间的连接
              URLConnection conn = realUrl.openConnection();
              HttpURLConnection httpUrl = (HttpURLConnection) (conn);
              httpUrl.setRequestProperty("Accept", "application/json");
              httpUrl.setRequestProperty("Content-Type", "application/json;charset=utf-8");
//              httpUrl.setRequestMethod("POST");
              httpUrl.connect();
              BufferedReader input = new BufferedReader(new InputStreamReader(httpUrl.getInputStream(), "utf-8"));
              String line;
              while ((line = input.readLine()) != null) {
                  result += line;
              }
          } catch (Exception e) {
              e.printStackTrace();
          }
          finally {
              try {
                  if (out != null) {
                      out.close();
                  }
                  if (in != null) {
                      in.close();
                  }
              } catch (IOException ex) {
                  ex.printStackTrace();
              }
          }       
          ioToJson(result, response);
	}
  
}
