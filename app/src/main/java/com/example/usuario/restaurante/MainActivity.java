package com.example.usuario.restaurante;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;


import com.example.usuario.restaurante.api.Datos;
import com.example.usuario.restaurante.models.Restaurante;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private int offset;
    private boolean aptoParaCargar;
    private ListaRestaurante listaRestaurante;

    // crear el objeto retrofit**************

    private Retrofit retrofit;
    public static final String TAG="Datos abiertos Colombia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        listaRestaurante = new ListaRestaurante(this);
        recyclerView.setAdapter(listaRestaurante);



/*
Cuando se obtiene la instancia del recycler se usa el método setHasFixedSize()
 para optimizar las operaciones con los ítems. Con esta característica le
 estamos diciendo al recycler que el adaptador no variará su tamaño en toda
  la ejecución del programa.
 */
        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                    if (aptoParaCargar) {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                            Log.i(TAG, " Fin.");

                            aptoParaCargar = false;
                            offset += 20;
                            obtenerDatosReportesVehiculos();
                        }
                    }
                }
            }
        });




        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        aptoParaCargar = true;
        offset = 0;

        obtenerDatosReportesVehiculos();

    }



    private void obtenerDatosReportesVehiculos() {
        Datos service = retrofit.create(Datos.class);
        Call<ArrayList<Restaurante>> reporteRespuestaCall = service.obtenerListaRestaurante();

        reporteRespuestaCall.enqueue(new Callback<ArrayList<Restaurante>>() {
            @Override
            public void onResponse(Call<ArrayList<Restaurante>> call, Response<ArrayList<Restaurante>> response) {
                if(response.isSuccessful()){
                    ArrayList listado = response.body();
                    listaRestaurante.agregarRestaurante(listado);
                }
                else
                {
                    Log.e(TAG, "onResponse: "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Restaurante>> call, Throwable t) {
                Log.e(TAG," onFailure: "+t.getMessage());
            }
        });
    }
    public void acercaDe(View v) {
        Intent i =new Intent(this,acercaDe.class);
        startActivity(i);
    }

}
