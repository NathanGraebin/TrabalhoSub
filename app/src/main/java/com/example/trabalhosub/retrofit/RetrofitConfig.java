package com.example.trabalhosub.retrofit;

import com.example.trabalhosub.service.IPaisService;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


public class RetrofitConfig {
    private Retrofit retrofit;

    private static final String BASE_URL = "https://falabr.cgu.gov.br/";

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)  //definindo a url base
                .addConverterFactory(JacksonConverterFactory.create())
                .build();            //criando o retrofit
    }

    public IPaisService paisService() {
        return this.retrofit.create(IPaisService.class);
    }
}
