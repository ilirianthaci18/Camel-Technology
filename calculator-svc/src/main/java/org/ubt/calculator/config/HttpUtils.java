package org.ubt.calculator.config;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Collections;

public class HttpUtils {

    private static String apiHost="currency-converter13.p.rapidapi.com";
    private static String apiKey="150fc90da7msh399544eb4f87a28p1b2a36jsn4e2a39b6f27e";

    public static HttpEntity<String> getHttpEntity(){
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("X-RapidAPI-Host",apiHost);
        headers.set("X-RapidAPI-Key",apiKey);

        return new HttpEntity<>(null,headers);
    }
}
