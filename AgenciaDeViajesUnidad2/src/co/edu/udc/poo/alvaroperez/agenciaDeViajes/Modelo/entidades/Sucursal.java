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
public class Sucursal {
    private String codigo;
    private String nombreSucursal;
    private String ciudad;
    private String direccion;
    private String telefono;
    
        public Sucursal(String codigo, String nombreSucursal,String ciudad, String direccion, String telefono) {
        this.codigo = codigo;
        this.nombreSucursal = nombreSucursal;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
        }
        //Getters
        public String getCodigo() {
            return codigo;
        }
        public String getNombreSucursal() {
            return nombreSucursal;
        }
        public String getCiudad() {
            return ciudad;
        }
        public String getDireccion() {
            return direccion;
        } 
        public String getTelefono() {
            return telefono;
        }
        //Setters
        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }
        public void setNombreSucursal(String nombreSucursal) {
            this.nombreSucursal = nombreSucursal;
        }
        public void setCiudad(String ciudad){
            this.ciudad = ciudad;
        }
        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }
        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }
    
    
    public void mostrarInformacion() {
        System.out.printf("%-35s: %s\n", "Codigo Sucursal", codigo);
        System.out.printf("%-35s: %s\n", "Nombre de la Sucursal", nombreSucursal);
        System.out.printf("%-35s: %s\n", "Sucursal sede", ciudad);
        System.out.printf("%-35s: %s\n", "Direccion", direccion);
        System.out.printf("%-35s: %s\n", "Contacto", telefono);
    }
    
    public TuristaReservaHotel realizarReserva(Turista turista, TipoPension tipoPension, Hotel hotel, Date fechaLlegada, Date fechaSalida){
        System.out.println("Procesando reserva en la sucursal " + nombreSucursal + ", Codigo: " + codigo);
        return new TuristaReservaHotel(turista, tipoPension, hotel, fechaLlegada, fechaSalida);      
    }
    
    
    public TuristaReservaVuelo realizarReserva(Turista turista, TipoPlaza tipoPlaza, Vuelo vuelo){
        System.out.println("Procesando reserva en la sucursal " + nombreSucursal + ", Codigo: " + codigo);
        return new TuristaReservaVuelo(turista, tipoPlaza, vuelo);
    }
}
