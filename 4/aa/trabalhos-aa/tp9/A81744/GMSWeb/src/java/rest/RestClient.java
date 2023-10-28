/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import aa.GMS;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 *
 * @author Ricardo Petronilho
 */
public class RestClient {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        // Apresentar o menu pela 1ª vez
        System.out.println(">> 0 - list all games");
        System.out.println(">> 1 - search a game"); 
        
        while(sc.hasNextLine()) {
            
            switch(sc.nextLine()) {
                
                case "0":
                    try {
                        String data = doGet("http://localhost:8080/GMSWeb/GamesRest");
                        System.out.println(data);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }                 
                    break;
                    
                case "1":
                    try {
                        System.out.println("Enter game's name:");
                        if (sc.hasNextLine()) {
                            String gameName = sc.nextLine();
                            String data = doPost("http://localhost:8080/GMSWeb/GamesRest", "{ \"gamename\": \"" + gameName + "\" }");
                            System.out.println(data);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }                 
                    break;
            }
            
            System.out.println(">> 0 - list all games");
            System.out.println(">> 1 - search a game");
        }
        
    }
    
    public static String doPost(String url, String json) throws IOException {
        
        OkHttpClient client = new OkHttpClient();
        
        // Request
        MediaType JSON = MediaType.get("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
            .url(url)
            .post(body) //post request
            .addHeader("content-type", "application/JSON")
            .build();
        
        // Response
        Response response = client.newCall(request).execute();
        Scanner sc = new Scanner(response.body().byteStream());
        StringBuilder sb = new StringBuilder();
        while(sc.hasNextLine()) {
            sb.append(sc.nextLine());
        }
        
        // data from response
        return sb.toString();
    }
    
    public static String doGet(String url) throws IOException {
        
        OkHttpClient client = new OkHttpClient();
        
        // Request
        Request request = new Request.Builder() 
            .url(url)
            .get()
            .build();

        // Response
        Response response = client.newCall(request).execute();       
        Scanner sc = new Scanner(response.body().byteStream());
        StringBuilder sb = new StringBuilder();
        while(sc.hasNextLine()) {
            sb.append(sc.nextLine());
        }
        
        // data from response
        return sb.toString();   
    }
}
