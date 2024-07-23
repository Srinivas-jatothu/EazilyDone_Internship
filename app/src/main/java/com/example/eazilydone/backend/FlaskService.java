package com.example.eazilydone.backend;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
public interface FlaskService {
    @POST("bot/response")
    Call<Map<String, String>> getBotResponse(@Body Map<String, String> req);
}