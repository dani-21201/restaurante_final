package com.example.usuario.restaurante;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.usuario.restaurante.models.Restaurante;

import java.util.ArrayList;

/**
 * Created by usuario on 12/10/2017.
 */

public class ListaRestaurante extends RecyclerView.Adapter<ListaRestaurante.ViewHolder> {
    private ArrayList<Restaurante> dataset;

    private Context context;

    public ListaRestaurante(Context context) {
        this.context = context;
        dataset = new ArrayList<>();

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_lista_restaurante, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Restaurante a=dataset.get(position);
        holder.contactoTelefNico.setText(a.getContactoTelefNico().toString());
        holder.direcciN.setText(a.getDirecciN().toString());
        holder.nombreDelHotel.setText(a.getNombreDelHotel().toString());


    }

    @Override
    public int getItemCount() {

        return dataset.size();
    }

    public void agregarRestaurante(ArrayList<Restaurante> list) {
        dataset.addAll(list);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {



        private TextView contactoTelefNico;
        private TextView direcciN;
        private TextView nombreDelHotel;


        public ViewHolder(View itemView) {
            super(itemView);


            contactoTelefNico=(TextView)itemView.findViewById(R.id.contactoTelefNico);
            direcciN=(TextView)itemView.findViewById(R.id.direcciN);
            nombreDelHotel=(TextView)itemView.findViewById(R.id.nombreDelHotel);
        }
    }
}
