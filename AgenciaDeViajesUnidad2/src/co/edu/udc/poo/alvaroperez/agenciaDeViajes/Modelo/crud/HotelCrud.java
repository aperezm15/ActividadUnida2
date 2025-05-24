package co.edu.udc.poo.alvaroperez.agenciaDeViajes.Modelo.crud;



import co.edu.udc.poo.alvaroperez.agenciaDeViajes.Modelo.entidades.Hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator; // Para eliminar de forma segura

public class HotelCrud {

    // Colección para almacenar los objetos Hotel en memoria
    private List<Hotel> hoteles;

    // Constructor
    public HotelCrud() {
        this.hoteles = new ArrayList<>();
    }

    // =========================================================
    // C - CREATE (Crear un Hotel)
    // =========================================================

    public boolean agregarHotel(Hotel hotel) {
        if (hotel == null) {
            System.err.println("Error: No se puede agregar un hotel nulo.");
            return false;
        }
        // Verificar si ya existe un hotel con el mismo código
        if (obtenerHotelPorCodigo(hotel.getCodigo()) != null) {
            System.out.println("Error: Ya existe un hotel con el codigo: " + hotel.getCodigo());
            return false;
        }
        this.hoteles.add(hotel);
        System.out.println("Hotel " + hotel.getNombreHotel() + " agregado con exito.");
        return true;
    }

    // =========================================================
    // R - READ (Leer/Consultar Hoteles)
    // =========================================================

    public List<Hotel> obtenerTodosLosHoteles() {
        return new ArrayList<>(this.hoteles); // Devolver una copia para evitar modificaciones externas directas
    }


    public Hotel obtenerHotelPorCodigo(String codigo) {
        for (Hotel h : this.hoteles) {
            if (h.getCodigo().equals(codigo)) { // Usar .equals() para comparar Strings
                return h;
            }
        }
        return null; // No se encontró el hotel
    }

    // =========================================================
    // U - UPDATE (Actualizar un Hotel)
    // =========================================================

    public boolean actualizarHotel(Hotel hotelActualizado) {
        if (hotelActualizado == null) {
            System.err.println("Error: No se puede actualizar con un hotel nulo.");
            return false;
        }

        for (int i = 0; i < this.hoteles.size(); i++) {
            if (this.hoteles.get(i).getCodigo().equals(hotelActualizado.getCodigo())) {
                this.hoteles.set(i, hotelActualizado); // Reemplaza el objeto existente
                System.out.println("Hotel con codigo " + hotelActualizado.getCodigo() + " actualizado con exito.");
                return true;
            }
        }
        System.out.println("Error: Hotel con codigo " + hotelActualizado.getCodigo() + " no encontrado para actualizar.");
        return false;
    }

    // =========================================================
    // D - DELETE (Eliminar un Hotel)
    // =========================================================

    public boolean eliminarHotel(String codigo) {
        Iterator<Hotel> iterator = this.hoteles.iterator();
        while (iterator.hasNext()) {
            Hotel h = iterator.next();
            if (h.getCodigo().equals(codigo)) {
                iterator.remove(); // Elimina el elemento actual de la colección
                System.out.println("Hotel con codigo " + codigo + " eliminado con exito.");
                return true;
            }
        }
        System.out.println("Error: Hotel con codigo " + codigo + " no encontrado para eliminar.");
        return false;
    }

    // Método para verificar la existencia de un hotel por su código
    public boolean existeHotel(String codigo) {
        return obtenerHotelPorCodigo(codigo) != null;
    }
}