package co.edu.udc.poo.alvaroperez.agenciaDeViajes.Modelo.crud;



import co.edu.udc.poo.alvaroperez.agenciaDeViajes.Modelo.entidades.TuristaReservaHotel;
import co.edu.udc.poo.alvaroperez.agenciaDeViajes.Modelo.entidades.Turista;
import co.edu.udc.poo.alvaroperez.agenciaDeViajes.Modelo.entidades.Hotel;
import co.edu.udc.poo.alvaroperez.agenciaDeViajes.Modelo.entidades.TipoPension; // Si es necesario para actualización

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;
import java.util.Objects; // Para usar Objects.equals() y hash en una clave compuesta

public class TuristaReservaHotelCrud {

    private List<TuristaReservaHotel> reservasHotel;

    public TuristaReservaHotelCrud() {
        this.reservasHotel = new ArrayList<>();
    }

    // =========================================================
    // C - CREATE (Crear una Reserva de Hotel)
    // =========================================================
    /**
     * Agrega una nueva reserva de hotel a la lista.
     * La unicidad se basa en la combinación de ID de turista, código de hotel y fecha de llegada.
     * @param reserva La objeto TuristaReservaHotel a agregar.
     * @return true si la reserva fue agregada exitosamente (no existe ya con la misma clave), false en caso contrario.
     */
    public boolean agregarReservaHotel(TuristaReservaHotel reserva) {
        if (reserva == null) {
            System.err.println("Error: No se puede agregar una reserva nula.");
            return false;
        }
        // Verificar si ya existe una reserva con la misma combinación de turista, hotel y fecha de llegada
        if (obtenerReservaPorClave(reserva.getTurista().getId(), reserva.getHotel().getCodigo(), reserva.getFechaLlegada()) != null) {
            System.out.println("Error: Ya existe una reserva para el turista '" + reserva.getTurista().getNombreCompleto() +
                               "' en el hotel '" + reserva.getHotel().getNombreHotel() +
                               "' con fecha de llegada '" + reserva.getFechaLlegada() + "'.");
            return false;
        }
        this.reservasHotel.add(reserva);
        System.out.println("Reserva de hotel agregada con exito para " + reserva.getTurista().getNombreCompleto() + " en " + reserva.getHotel().getNombreHotel());
        return true;
    }

    // =========================================================
    // R - READ (Leer/Consultar Reservas de Hotel)
    // =========================================================
    /**
     * Obtiene una lista de todas las reservas de hotel.
     * @return Una lista de objetos TuristaReservaHotel.
     */
    public List<TuristaReservaHotel> obtenerTodasLasReservasHotel() {
        return new ArrayList<>(this.reservasHotel); // Devolver una copia para evitar modificaciones externas directas
    }

    /**
     * Obtiene una reserva de hotel por su clave compuesta (ID de turista, código de hotel y fecha de llegada).
     * @param turistaId El ID del turista asociado a la reserva.
     * @param hotelCodigo El código del hotel asociado a la reserva.
     * @param fechaLlegada La fecha de llegada de la reserva.
     * @return El objeto TuristaReservaHotel si se encuentra, o null si no existe.
     */
    public TuristaReservaHotel obtenerReservaPorClave(String turistaId, String hotelCodigo, Date fechaLlegada) {
        for (TuristaReservaHotel r : this.reservasHotel) {
            // Se usa Objects.equals para manejar nulos de forma segura en las fechas
            if (r.getTurista().getId().equals(turistaId) &&
                r.getHotel().getCodigo().equals(hotelCodigo) &&
                Objects.equals(r.getFechaLlegada(), fechaLlegada)) {
                return r;
            }
        }
        return null; // No se encontró la reserva
    }

    /**
     * Obtiene todas las reservas de hotel para un turista específico.
     * @param turistaId El ID del turista.
     * @return Una lista de reservas del turista.
     */
    public List<TuristaReservaHotel> obtenerReservasPorTurista(String turistaId) {
        List<TuristaReservaHotel> reservasDelTurista = new ArrayList<>();
        for (TuristaReservaHotel r : this.reservasHotel) {
            if (r.getTurista().getId().equals(turistaId)) {
                reservasDelTurista.add(r);
            }
        }
        return reservasDelTurista;
    }

    /**
     * Obtiene todas las reservas de hotel para un hotel específico.
     * @param hotelCodigo El código del hotel.
     * @return Una lista de reservas en ese hotel.
     */
    public List<TuristaReservaHotel> obtenerReservasPorHotel(String hotelCodigo) {
        List<TuristaReservaHotel> reservasEnHotel = new ArrayList<>();
        for (TuristaReservaHotel r : this.reservasHotel) {
            if (r.getHotel().getCodigo().equals(hotelCodigo)) {
                reservasEnHotel.add(r);
            }
        }
        return reservasEnHotel;
    }

    // =========================================================
    // U - UPDATE (Actualizar una Reserva de Hotel)
    // =========================================================
    /**
     * Actualiza la información de una reserva de hotel existente.
     * Se busca la reserva original por su clave compuesta (ID de turista, código de hotel y fecha de llegada original).
     * Luego se reemplaza por la reserva actualizada.
     * @param reservaOriginalTuristaId El ID del turista de la reserva original.
     * @param reservaOriginalHotelCodigo El código del hotel de la reserva original.
     * @param reservaOriginalFechaLlegada La fecha de llegada de la reserva original.
     * @param reservaActualizada El objeto TuristaReservaHotel con la nueva información.
     * @return true si la reserva fue actualizada exitosamente, false si no se encontró la reserva original.
     */
    public boolean actualizarReservaHotel(String reservaOriginalTuristaId, String reservaOriginalHotelCodigo, Date reservaOriginalFechaLlegada, TuristaReservaHotel reservaActualizada) {
        if (reservaActualizada == null) {
            System.err.println("Error: No se puede actualizar con una reserva nula.");
            return false;
        }

        for (int i = 0; i < this.reservasHotel.size(); i++) {
            TuristaReservaHotel r = this.reservasHotel.get(i);
            if (r.getTurista().getId().equals(reservaOriginalTuristaId) &&
                r.getHotel().getCodigo().equals(reservaOriginalHotelCodigo) &&
                Objects.equals(r.getFechaLlegada(), reservaOriginalFechaLlegada)) {

                // También se debería verificar que la "clave" de la reserva actualizada
                // no colisione con otra reserva existente si se cambió el turista, hotel o fecha de llegada
                // (esto es más complejo y para una BD real, pero en memoria se puede ignorar si ya se encontró el original)

                this.reservasHotel.set(i, reservaActualizada); // Reemplaza el objeto existente
                System.out.println("Reserva de hotel (Turista: " + reservaOriginalTuristaId +
                                   ", Hotel: " + reservaOriginalHotelCodigo +
                                   ", Llegada: " + reservaOriginalFechaLlegada + ") actualizada con exito.");
                return true;
            }
        }
        System.out.println("Error: Reserva de hotel (Turista: " + reservaOriginalTuristaId +
                           ", Hotel: " + reservaOriginalHotelCodigo +
                           ", Llegada: " + reservaOriginalFechaLlegada + ") no encontrada para actualizar.");
        return false;
    }

    // =========================================================
    // D - DELETE (Eliminar una Reserva de Hotel)
    // =========================================================
    /**
     * Elimina una reserva de hotel de la lista por su clave compuesta.
     * @param turistaId El ID del turista asociado a la reserva a eliminar.
     * @param hotelCodigo El código del hotel asociado a la reserva a eliminar.
     * @param fechaLlegada La fecha de llegada de la reserva a eliminar.
     * @return true si la reserva fue eliminada exitosamente, false si no se encontró.
     */
    public boolean eliminarReservaHotel(String turistaId, String hotelCodigo, Date fechaLlegada) {
        Iterator<TuristaReservaHotel> iterator = this.reservasHotel.iterator();
        while (iterator.hasNext()) {
            TuristaReservaHotel r = iterator.next();
            if (r.getTurista().getId().equals(turistaId) &&
                r.getHotel().getCodigo().equals(hotelCodigo) &&
                Objects.equals(r.getFechaLlegada(), fechaLlegada)) {
                iterator.remove();
                System.out.println("Reserva de hotel (Turista: " + turistaId + ", Hotel: " + hotelCodigo + ", Llegada: " + fechaLlegada + ") eliminada con exito.");
                return true;
            }
        }
        System.out.println("Error: Reserva de hotel (Turista: " + turistaId + ", Hotel: " + hotelCodigo + ", Llegada: " + fechaLlegada + ") no encontrada para eliminar.");
        return false;
    }
}