package com.example.usuario.restaurante.api;

import com.example.usuario.restaurante.models.Restaurante;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by usuario on 12/10/2017.
 */

public interface Datos
{


        @GET("6uk7-fep3.json")
        Call<ArrayList<Restaurante>> obtenerListaRestaurante();


}
