package com.example.mysplash.json;

import java.io.Serializable;

public class MyInfo implements Serializable {

    private String nombre;
    private String contrasena;
    private  String correo_usuario;
    private String telefono;
    private String fecha;
    private String descripcion;
    private float altura;
    private String terminos;
    private String politicas, radio_si, radio_no;
    private boolean enfermedad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo_usuario() {
        return correo_usuario;
    }

    public void setCorreo_usuario(String correo_usuario) {
        this.correo_usuario = correo_usuario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public boolean isEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(boolean enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getTerminos() {
        return terminos;
    }

    public void setTerminos(String terminos) {
        this.terminos = terminos;
    }

    public String getPoliticas() {
        return politicas;
    }

    public void setPoliticas(String politicas) {
        this.politicas = politicas;
    }

    public String getRadio_si() {
        return radio_si;
    }

    public void setRadio_si(String radio_si) {
        this.radio_si = radio_si;
    }

    public String getRadio_no() {
        return radio_no;
    }

    public void setRadio_no(String radio_no) {
        this.radio_no = radio_no;
    }
}
