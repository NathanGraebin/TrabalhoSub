package com.example.trabalhosub.service;

import com.example.trabalhosub.dto.PaisDTO;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IPaisService {
    @GET ("api/paises")
    Call<ArrayList<PaisDTO>> getPaises();
}
