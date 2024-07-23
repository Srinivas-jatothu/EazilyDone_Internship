
package com.example.eazilydone.backend;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.logging.HttpLoggingInterceptor;
public class FlaskClient {
    private static Retrofit getRetrofit(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        String st= "https://4000-01j3d742q16v6kx9btss3c2c9a.cloudspaces.litng.ai/";
        Retrofit r = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(st)
                .build();
        return r;
    }
    public static FlaskService Service(){
        return getRetrofit().create(FlaskService.class);
    }
}
