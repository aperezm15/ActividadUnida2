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
public class TuristaReservaHotel {
    private Turista turista;
    private TipoPension tipoPension;
    private Hotel hotel;
    private Date fechaLlegada;
    private Date fechaSalida;
    
    public TuristaReservaHotel(Turista turista, TipoPension tipoPension,Hotel hotel, Date fechaLlegada, Date fechaSalida) {
        this.turista = turista;
        this.tipoPension = tipoPension;
        this.hotel = hotel;
        this.fechaLlegada = fechaLlegada;
        this.fechaSalida = fechaSalida;
    }      
        
    //getters
    public Turista getTurista() {
        return turista;
    }
    public TipoPension getTipoPension() {
        return tipoPension;
    }
    public Hotel getHotel() {
        return hotel;
    }
    public Date getFechaLlegada() {
        return fechaLlegada;
    }
    public Date getFechaSalida() {
        return fechaSalida;
    }
    //setters
    public void setTurista(Turista turista) {
        this.turista = turista;
    }
    public void setTipoPension(TipoPension tipoPension) {
        this.tipoPension = tipoPension;
    }
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }  
    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
        
        
        
        
        
    public void mostrarInformacion(){
        System.out.printf("%-35s: %s\n", "Codigo Turista", turista.getCodigo());
        System.out.printf("%-35s: %s\n", "Nombre Completo", turista.getNombreCompleto());
        System.out.printf("%-35s: %s\n", "Cedula", turista.getId());
        System.out.printf("%-35s: %s\n", "Direccion", turista.getDireccion());
        System.out.printf("%-35s: %s\n", "Telefono", turista.getTelefono());
        System.out.printf("%-35s: %s\n", "Tipo de pension", tipoPension);
        System.out.printf("%-35s: %s\n", "Registrado en la sucursal", turista.getSucursal().getCodigo());
        System.out.println("===============Informacion de Reserva del hotel==================");
        System.out.printf("%-35s: %s\n", "Hotel Reservado", hotel.getCodigo());
        System.out.printf("%-35s: %s\n", "Fecha de llegada", fechaLlegada);
        System.out.printf("%-35s: %s\n", "Fecha salida", fechaSalida);
        
    if (this.tipoPension == tipoPension.MEDIO_PENSIONADO) {
        System.out.println("Medio Pensionado");
    }else if (this.tipoPension == tipoPension.PENSIONADO_COMPLETO) {
        System.out.println("Pensionado Completo");
    }else {
        System.out.println("Sin Pension");        
        
        
    }
    }
}
