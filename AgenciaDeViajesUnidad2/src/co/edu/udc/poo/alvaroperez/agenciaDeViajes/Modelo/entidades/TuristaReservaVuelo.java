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
public class TuristaReservaVuelo {
    private Turista turista;
    private TipoPlaza tipoPlaza;
    private Vuelo vuelo;
    
    
    public TuristaReservaVuelo(Turista turista, TipoPlaza tipoPlaza,Vuelo vuelo) {
        this.turista = turista;
        this.tipoPlaza = tipoPlaza;
        this.vuelo = vuelo;

        
    
      
    }
    
    //getters
    public Turista getTurista() {
        return turista;
    }
    public TipoPlaza getTipoPlaza() {
        return tipoPlaza;
    }
    public Vuelo getVuelo() {
        return vuelo;
    }
    //setters
    public void setTurista(Turista turista) {
        this.turista = turista;
    }
    public void setTipoPlaza(TipoPlaza tipoPlaza) {
        this.tipoPlaza = tipoPlaza;
    }
    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }
    
    public void mostrarInformacion(){
        System.out.printf("%-35s: %s\n", "Codigo Turista", turista.getCodigo());
        System.out.printf("%-35s: %s\n", "Nombre Completo", turista.getNombreCompleto());
        System.out.printf("%-35s: %s\n", "Cedula", turista.getId());
        System.out.printf("%-35s: %s\n", "Direccion", turista.getDireccion());
        System.out.printf("%-35s: %s\n", "Telefono", turista.getTelefono());
        System.out.printf("%-35s: %s\n", "Registrado en la sucursal", turista.getSucursal().getCodigo());
        System.out.println("===============Informacion de Reserva del vuelo==================");
        System.out.printf("%-35s: %s\n", "Asiento", tipoPlaza);
        System.out.printf("%-35s: %s\n", "Vuelo", vuelo.getNumeroVuelo());
        
        
    if (this.tipoPlaza == tipoPlaza.TURISTA) {
        
    }else if(this.tipoPlaza == tipoPlaza.PRIMERA_CLASE) {
        
    }      
        
        
    }
    
    
}
