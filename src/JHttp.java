/* Copyright 2019  
 * The Author of this Java Client is Javier Vargas. 
 * The JLightning library is created by Rene Pickhardt
 * licensed with a BSD-style license. 
 * @author Javiervargas
 */

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ListIterator;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.List;
import java.io.*;
import java.util.Properties;
import java.util.Objects;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class JHttp {
    static JLightningClient cln;

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
	      cln = new JLightningClient(args[0]);
	      cln.getConnection();
	      System.out.println("Connected to c-lightning.  Listening on 8000");
        server.createContext("/lightning", new MyHandler());
        server.setExecutor(java.util.concurrent.Executors.newCachedThreadPool());
        server.start();
    }


    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            StringBuilder response = new StringBuilder();
            long threadId = Thread.currentThread().getId();
            Map <String,String> parms = this.queryToMap(t.getRequestURI().getQuery());
            response.append(cln.processCommand(parms.get("query")));
            this.writeResponse(t, response.toString());          
        }
	
	public static JSONObject parseQuery(Hashtable hashtable)
        {
                JSONObject json = new JSONObject();
                Enumeration e = null;
                try{
                        e = hashtable.elements();
                }
                catch(NoSuchElementException nosuchelementexception){
                        System.out.println(nosuchelementexception.getMessage());
                }
                  if (e!=null){
                       while (e.hasMoreElements()){
                        }
                  }
                 return json;
        }

        public static void writeResponse(HttpExchange httpExchange, String response) throws IOException {
            httpExchange.sendResponseHeaders(200, response.length());
            OutputStream os = httpExchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
          }
        
        public static Map<String, String> queryToMap(String query){
            Map<String, String> result = new HashMap<String, String>();
            for (String param : query.split("&")) {
                String pair[] = param.split("=");
                if (pair.length>1) {
                    result.put(pair[0], pair[1]);
                }else{
                    result.put(pair[0], "");
                }
            }
            return result;
       }
        
    }
}
