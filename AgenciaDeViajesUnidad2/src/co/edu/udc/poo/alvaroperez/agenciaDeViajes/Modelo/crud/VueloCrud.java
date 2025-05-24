package co.edu.udc.poo.alvaroperez.agenciaDeViajes.Modelo.crud;



import co.edu.udc.poo.alvaroperez.agenciaDeViajes.Modelo.entidades.Vuelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;
import java.util.Objects; // Para usar Objects.equals() con Date

public class VueloCrud {

    // Colección para almacenar los objetos Vuelo en memoria
    private List<Vuelo> vuelos;

    // Constructor
    public VueloCrud() {
        this.vuelos = new ArrayList<>();
    }

    // =========================================================
    // C - CREATE (Crear un Vuelo)
    // =========================================================
    /**
     * Agrega un nuevo vuelo a la lista.
     * La unicidad se basa en la combinación de numeroVuelo y fechaHoraVuelo.
     * @param vuelo El objeto Vuelo a agregar.
     * @return true si el vuelo fue agregado exitosamente (no existe ya con la misma clave), false en caso contrario.
     */
    public boolean agregarVuelo(Vuelo vuelo) {
        if (vuelo == null) {
            System.err.println("Error: No se puede agregar un vuelo nulo.");
            return false;
        }
        // Verificar si ya existe un vuelo con el mismo número y fecha/hora
        if (obtenerVueloPorClave(vuelo.getNumeroVuelo(), vuelo.getFechaHoraVuelo()) != null) {
            System.out.println("Error: Ya existe un vuelo con el numero '" + vuelo.getNumeroVuelo() +
                               "' y fecha/hora '" + vuelo.getFechaHoraVuelo() + "'.");
            return false;
        }
        this.vuelos.add(vuelo);
        System.out.println("Vuelo " + vuelo.getNumeroVuelo() + " (" + vuelo.getOrigen() + " - " + vuelo.getDestino() + ") agregado con exito.");
        return true;
    }

    // =========================================================
    // R - READ (Leer/Consultar Vuelos)
    // =========================================================
    /**
     * Obtiene una lista de todos los vuelos.
     * @return Una lista de objetos Vuelo.
     */
    public List<Vuelo> obtenerTodosLosVuelos() {
        return new ArrayList<>(this.vuelos); // Devolver una copia para evitar modificaciones externas directas
    }

    /**
     * Obtiene un vuelo por su clave compuesta (numeroVuelo y fechaHoraVuelo).
     * @param numeroVuelo El número del vuelo a buscar.
     * @param fechaHoraVuelo La fecha y hora del vuelo a buscar.
     * @return El objeto Vuelo si se encuentra, o null si no existe.
     */
    public Vuelo obtenerVueloPorClave(String numeroVuelo, Date fechaHoraVuelo) {
        for (Vuelo v : this.vuelos) {
            if (v.getNumeroVuelo().equals(numeroVuelo) &&
                Objects.equals(v.getFechaHoraVuelo(), fechaHoraVuelo)) { // Usar Objects.equals() para Date
                return v;
            }
        }
        return null; // No se encontró el vuelo
    }

    /**
     * Obtiene todos los vuelos con un número de vuelo específico (ignorando la fecha/hora).
     * Útil si se quiere ver "todas las instancias" de un vuelo regular.
     * @param numeroVuelo El número de vuelo a buscar.
     * @return Una lista de vuelos con ese número.
     */
    public List<Vuelo> obtenerVuelosPorNumero(String numeroVuelo) {
        List<Vuelo> vuelosEncontrados = new ArrayList<>();
        for (Vuelo v : this.vuelos) {
            if (v.getNumeroVuelo().equals(numeroVuelo)) {
                vuelosEncontrados.add(v);
            }
        }
        return vuelosEncontrados;
    }

    // =========================================================
    // U - UPDATE (Actualizar un Vuelo)
    // =========================================================
    /**
     * Actualiza la información de un vuelo existente.
     * Se busca el vuelo original por su clave compuesta (numeroVuelo y fechaHoraVuelo original).
     * @param vueloOriginalNumeroVuelo El número de vuelo del vuelo original.
     * @param vueloOriginalFechaHoraVuelo La fecha y hora del vuelo original.
     * @param vueloActualizado El objeto Vuelo con la nueva información.
     * @return true si el vuelo fue actualizado exitosamente, false si no se encontró el vuelo original.
     */
    public boolean actualizarVuelo(String vueloOriginalNumeroVuelo, Date vueloOriginalFechaHoraVuelo, Vuelo vueloActualizado) {
        if (vueloActualizado == null) {
            System.err.println("Error: No se puede actualizar con un vuelo nulo.");
            return false;
        }

        for (int i = 0; i < this.vuelos.size(); i++) {
            Vuelo v = this.vuelos.get(i);
            if (v.getNumeroVuelo().equals(vueloOriginalNumeroVuelo) &&
                Objects.equals(v.getFechaHoraVuelo(), vueloOriginalFechaHoraVuelo)) {
                
                // Si el número de vuelo o la fecha/hora cambian en vueloActualizado,
                // esto podría crear una "nueva" entrada en el manager o colisionar.
                // Para simplificar, asumimos que la CLAVE de la actualización es la original,
                // y los campos cambiados son otros (origen, destino, plazas, etc.).
                this.vuelos.set(i, vueloActualizado); // Reemplaza el objeto existente
                System.out.println("Vuelo (Numero: " + vueloOriginalNumeroVuelo +
                                   ", Fecha/Hora: " + vueloOriginalFechaHoraVuelo + ") actualizado con exito.");
                return true;
            }
        }
        System.out.println("Error: Vuelo (Numero: " + vueloOriginalNumeroVuelo +
                           ", Fecha/Hora: " + vueloOriginalFechaHoraVuelo + ") no encontrado para actualizar.");
        return false;
    }

    // =========================================================
    // D - DELETE (Eliminar un Vuelo)
    // =========================================================
    /**
     * Elimina un vuelo de la lista por su clave compuesta.
     * @param numeroVuelo El número del vuelo a eliminar.
     * @param fechaHoraVuelo La fecha y hora del vuelo a eliminar.
     * @return true si el vuelo fue eliminado exitosamente, false si no se encontró.
     */
    public boolean eliminarVuelo(String numeroVuelo, Date fechaHoraVuelo) {
        Iterator<Vuelo> iterator = this.vuelos.iterator();
        while (iterator.hasNext()) {
            Vuelo v = iterator.next();
            if (v.getNumeroVuelo().equals(numeroVuelo) &&
                Objects.equals(v.getFechaHoraVuelo(), fechaHoraVuelo)) {
                iterator.remove();
                System.out.println("Vuelo (Numero: " + numeroVuelo + ", Fecha/Hora: " + fechaHoraVuelo + ") eliminado con exito.");
                return true;
            }
        }
        System.out.println("Error: Vuelo (Numero: " + numeroVuelo + ", Fecha/Hora: " + fechaHoraVuelo + ") no encontrado para eliminar.");
        return false;
    }

    // Método para verificar la existencia de un vuelo por su clave
    public boolean existeVuelo(String numeroVuelo, Date fechaHoraVuelo) {
        return obtenerVueloPorClave(numeroVuelo, fechaHoraVuelo) != null;
    }
}