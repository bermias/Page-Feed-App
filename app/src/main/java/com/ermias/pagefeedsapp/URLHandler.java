package com.ermias.pagefeedsapp;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class URLHandler {

    public String getJson(String reqUrl) {
        String response = null;
        //System.out.println("Started here require");
        HttpURLConnection conn = null;
        try {
            URL url = new URL(reqUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            // read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());

            response = convertStreamToString(in);
        } catch (MalformedURLException e) {
            System.out.println("MalformedURLException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            System.out.println("JSON Finally Close");
            conn.disconnect();
        }
        return response;
    }

    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        //System.out.println("Start here Input");
        try {
            while ((line = reader.readLine()) != null) {
                //System.out.println(line);
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            System.out.println(e.toString());
            //e.printStackTrace();
        } finally {
            try {
                System.out.println("Read Finally Close");
                is.close();
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        }
        return sb.toString();
    }
}
