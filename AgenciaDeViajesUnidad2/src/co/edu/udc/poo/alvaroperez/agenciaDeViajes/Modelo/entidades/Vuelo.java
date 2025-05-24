/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udc.poo.alvaroperez.agenciaDeViajes.Modelo.entidades;

import java.util.Date;

/**
 *
 * @author Mitzuke
 */
public class Vuelo {
    private String numeroVuelo;
    private Date fechaHoraVuelo;
    private String origen;
    private String destino;
    private int plazasDisponibles;
    private int plazasDisponiblesTurista;
    
    public Vuelo(String numeroVuelo, Date fechaHoraVuelo, String origen, String destino, int plazasDisponibles, int plazasDisponiblesTurista){
        this.numeroVuelo = numeroVuelo;
        this.fechaHoraVuelo = fechaHoraVuelo;
        this.origen = origen;
        this.destino = destino;
        this.plazasDisponibles = plazasDisponibles;
        this.plazasDisponiblesTurista = plazasDisponiblesTurista;
    }
    
    //getters
    public String getNumeroVuelo(){
        return numeroVuelo;
    }
    public Date getFechaHoraVuelo(){
        return fechaHoraVuelo;
    }
    public String getOrigen(){
        return origen;
    }
    public String getDestino(){
        return destino;
    }
    public int getPlazasDisponibles(){
        return plazasDisponibles;
    }
    public int getPlazasDisponiblesTurista(){
        return plazasDisponiblesTurista;
    }
    //Setters
    public void setNumeroVuelo(String numeroVuelo){
        this.numeroVuelo = numeroVuelo;
    }
    public void setFechaHoraVuelo(Date fechaHoraVuelo){
        this.fechaHoraVuelo = fechaHoraVuelo;
    }
    public void setOrigen(String origen){
        this.origen = origen;
    }
    public void setDestino(String destino){
        this.destino = destino;
    }
    public void setPlazaDisponiblesTurista(int plazasDisponiblesTurista){
        this.plazasDisponiblesTurista = plazasDisponiblesTurista;
    }
    public void setPlazaDisponibles(int plazasDisponibles){
        this.plazasDisponibles = plazasDisponibles;
    }
    
    public void mostrarInformacion(){
        System.out.printf("%-35s: %s\n", "Numero de vuelo", numeroVuelo);
        System.out.printf("%-35s: %s\n", "Hora de vuelo", fechaHoraVuelo);
        System.out.printf("%-35s: %s\n", "Origen", origen);
        System.out.printf("%-35s: %s\n", "Destino", destino);
        System.out.printf("%-35s: %s\n", "Plazas Disponibles", plazasDisponibles);
        System.out.printf("%-35s: %s\n", "Plazas Disponibles(Turistas)", plazasDisponiblesTurista);
            int plazasPrimeraClase = this.plazasDisponibles - this.plazasDisponiblesTurista;
        System.out.printf("%-35s: %s\n", "Plazas Disponibles(Primera clase)", plazasPrimeraClase);
    }
    
    
}
