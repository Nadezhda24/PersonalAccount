package com.example.personalaccount.controller;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HTTPHandler {

    public HTTPHandler() {
    }

    public String getData(String reqUrl, String method) {
        URL url;
        String response = "";
        HttpURLConnection urlConnection = null;
        try {
                url = new URL(reqUrl);

                urlConnection = (HttpURLConnection) url
                        .openConnection();
                urlConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:221.0) Gecko/20100101 Firefox/31.0");
                urlConnection.connect();

                InputStream in = urlConnection.getInputStream();

                InputStreamReader isw = new InputStreamReader(in);

                int data = isw.read();
                while (data != -1) {
                    char current = (char) data;
                    data = isw.read();
                    System.out.print(current);
                    response = response + current;
                }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return response;
    }

/*
    public String setData(String reqUrl, String method, String params) {
        URL url;
        String response = "";
        byte[] data = null;
        InputStream is = null;
        HttpURLConnection urlConnection = null;
        try {
                url = new URL(reqUrl);

                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("POST");
                urlConnection.setDoOutput(true);
                urlConnection.setDoInput(true);

            urlConnection.setRequestProperty("Content-Length", "" + Integer.toString(params.getBytes().length));
            OutputStream os = urlConnection.getOutputStream();
            data = params.getBytes("UTF-8");
            os.write(data);
            data = null;
            urlConnection.connect();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return response;
    }

*/

    public String setData(String reqUrl, String method, byte[] out) {
        URL url ;
        HttpURLConnection httpURLConnection;
        OutputStream os  = null;
        InputStreamReader isR = null;
        BufferedReader bfR = null;
        StringBuilder stringBuilder = new StringBuilder();

        try{
            url =  new URL(reqUrl);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            httpURLConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:221.0) Gecko/20100101 Firefox/31.0");
            httpURLConnection.addRequestProperty("Content-Type", "application/x-www-from-urlencoded");

            httpURLConnection.setConnectTimeout(200);
            httpURLConnection.setReadTimeout(200);
            httpURLConnection.connect();

            try{
                os = httpURLConnection.getOutputStream();
                os.write(out);
            } catch (Exception e){
                System.err.print(e.getMessage());
            }

            if (HttpURLConnection.HTTP_OK == httpURLConnection.getResponseCode()){
                isR =  new InputStreamReader(httpURLConnection.getInputStream());
                if (isR == null)  System.out.print("ERROR");
                bfR = new BufferedReader(isR);
                String line;
                while ((line=bfR.readLine()) != null){
                    stringBuilder.append(line);
                }
            }

            System.out.print(stringBuilder);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.err.print(e.getMessage());
        } finally {
            try {
                isR.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bfR.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        return reqUrl;
    }
}
