/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udc.poo.alvaroperez.agenciaDeViajes.Modelo.entidades;

/**
 *
 * @author Mitzuke
 */
public class Hotel {
    private String codigo;
    private String nombreHotel;
    private String direccion;
    private String ciudad;
    private String telefono;
    private int plazasDisponibles;
    
        public Hotel(String codigo, String nombreHotel, String direccion, String ciudad, String telefono, int plazasDisponibles) {
            this.codigo = codigo;
            this.nombreHotel = nombreHotel;
            this.direccion = direccion;
            this.ciudad = ciudad;
            this.telefono = telefono;
            this.plazasDisponibles = plazasDisponibles;
        }
        
            //getters
            public String getCodigo() {
                return codigo;
            }
            public String getNombreHotel() {
                return nombreHotel;
            }            
            public String getDireccion() {
                return direccion;
            }
            public String getCiudad() {
                return ciudad;
            }
            public String gettelefono() {
                return telefono;
            }
            public int getPlazasDisponibles() {
                return plazasDisponibles;
            }
            
            //Setters
            public void setCodigo(String codigo) {
                this.codigo = codigo;
            }
            public void setNombreHotel(String nombreHotel) {
                this.nombreHotel = nombreHotel;
            }
            public void setDireccion(String direccion) {
                this.direccion = direccion;
            }
            public void setCiudad(String ciudad) {
                this.ciudad = ciudad;
            }
            public void setTelefono(String telefono) {
                this.telefono = telefono;
            }
            public void setPlazasDisponibles(int plazasDisponibles) {
                this.plazasDisponibles = plazasDisponibles;
            }

        public void mostrarInformacion() {
            System.out.printf("%-35s: %s\n", "Codigo Hotel", codigo);
            System.out.printf("%-35s: %s\n", "Nombre del Hotel", nombreHotel);
            System.out.printf("%-35s: %s\n", "Direccion", direccion);
            System.out.printf("%-35s: %s\n", "Ciudad", ciudad);
            System.out.printf("%-35s: %s\n", "Contacto", telefono);
            System.out.printf("%-35s: %d\n", "Plazas Disponibles", plazasDisponibles);
        }
}
