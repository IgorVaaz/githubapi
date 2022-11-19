package com.igor.nvpc;

import com.igor.nvpc.api.models.ApiDto;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class NvpcApplication extends ApiDto {

    public static void main(String[] args) throws IOException, InterruptedException, JSONException {
        SpringApplication.run(NvpcApplication.class, args);

        //System.out.println("Hello World!");
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api.github.com/users/igorvaaz/repos"))
                .headers("Accept", "application/vnd.github+json")
                .headers("Authorization", "Bearer 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")
                .build();

        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
        System.out.println(response.statusCode());
        }
    }
















