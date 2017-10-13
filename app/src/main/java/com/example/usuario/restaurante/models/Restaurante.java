package com.example.usuario.restaurante.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by usuario on 12/10/2017.
 */

public class Restaurante {

    @SerializedName("contacto_telef_nico")
    @Expose
    private String contactoTelefNico;
    @SerializedName("direcci_n")
    @Expose
    private String direcciN;
    @SerializedName("nombre_del_hotel")
    @Expose
    private String nombreDelHotel;

    public String getContactoTelefNico() {
        return contactoTelefNico;
    }

    public void setContactoTelefNico(String contactoTelefNico) {
        this.contactoTelefNico = contactoTelefNico;
    }

    public String getDirecciN() {
        return direcciN;
    }

    public void setDirecciN(String direcciN) {
        this.direcciN = direcciN;
    }

    public String getNombreDelHotel() {
        return nombreDelHotel;
    }

    public void setNombreDelHotel(String nombreDelHotel) {
        this.nombreDelHotel = nombreDelHotel;
    }

}

