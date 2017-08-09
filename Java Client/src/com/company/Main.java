package com.company;

// The fucking json library is here https://mvnrepository.com/artifact/org.json/json/20160810

import org.json.JSONObject;

import java.net.URL;
import java.net.HttpURLConnection;


import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.DataOutputStream;


public class Main {

    public static void main(String args[]) {
        System.out.println("This shit kinda works");
        JSONObject json_object = new JSONObject();

        json_object.put("email", "ladd@toor.com");
        json_object.put("password", "Trump_hates_foreigners");
        StringWriter out = new StringWriter();
        //json_object.writeJSONString(out);
        String jsonText = json_object.toString();


        System.out.println(executePost("http://localhost:9000/login", jsonText));
    }

    public static String executePost(String targetURL, String urlParameters) {
        HttpURLConnection connection = null;

        try {
            //Create connection
            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/json");

            connection.setRequestProperty("Content-Length",
                    Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches(false);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream(
                    connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.close();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                //System.out.println(line);
                response.append('\n');
            }
            rd.close();
            //System.out.println(response);
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }


}
