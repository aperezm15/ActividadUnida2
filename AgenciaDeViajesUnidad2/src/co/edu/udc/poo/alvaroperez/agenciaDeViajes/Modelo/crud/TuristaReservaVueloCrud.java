package co.edu.udc.poo.alvaroperez.agenciaDeViajes.Modelo.crud;



import co.edu.udc.poo.alvaroperez.agenciaDeViajes.Modelo.entidades.TuristaReservaVuelo;
import co.edu.udc.poo.alvaroperez.agenciaDeViajes.Modelo.entidades.Turista;
import co.edu.udc.poo.alvaroperez.agenciaDeViajes.Modelo.entidades.Vuelo;
import co.edu.udc.poo.alvaroperez.agenciaDeViajes.Modelo.entidades.TipoPlaza; // Si es necesario para actualización

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;
import java.util.Objects; // Para usar Objects.equals() y hash en una clave compuesta

public class TuristaReservaVueloCrud {

    private List<TuristaReservaVuelo> reservasVuelo;

    public TuristaReservaVueloCrud() {
        this.reservasVuelo = new ArrayList<>();
    }

    // =========================================================
    // C - CREATE (Crear una Reserva de Vuelo)
    // =========================================================
    /**
     * Agrega una nueva reserva de vuelo a la lista.
     * La unicidad se basa en la combinación de ID de turista, número de vuelo y fecha/hora del vuelo.
     * @param reserva La objeto TuristaReservaVuelo a agregar.
     * @return true si la reserva fue agregada exitosamente (no existe ya con la misma clave), false en caso contrario.
     */
    public boolean agregarReservaVuelo(TuristaReservaVuelo reserva) {
        if (reserva == null) {
            System.err.println("Error: No se puede agregar una reserva de vuelo nula.");
            return false;
        }
        // Verificar si ya existe una reserva con la misma combinación
        if (obtenerReservaPorClave(reserva.getTurista().getId(), reserva.getVuelo().getNumeroVuelo(), reserva.getVuelo().getFechaHoraVuelo()) != null) {
            System.out.println("Error: Ya existe una reserva para el turista '" + reserva.getTurista().getNombreCompleto() +
                               "' en el vuelo '" + reserva.getVuelo().getNumeroVuelo() +
                               "' en la fecha/hora '" + reserva.getVuelo().getFechaHoraVuelo() + "'.");
            return false;
        }
        this.reservasVuelo.add(reserva);
        System.out.println("Reserva de vuelo agregada con éxito para " + reserva.getTurista().getNombreCompleto() + " en vuelo " + reserva.getVuelo().getNumeroVuelo());
        return true;
    }

    // =========================================================
    // R - READ (Leer/Consultar Reservas de Vuelo)
    // =========================================================
    /**
     * Obtiene una lista de todas las reservas de vuelo.
     * @return Una lista de objetos TuristaReservaVuelo.
     */
    public List<TuristaReservaVuelo> obtenerTodasLasReservasVuelo() {
        return new ArrayList<>(this.reservasVuelo); // Devolver una copia para evitar modificaciones externas directas
    }

    /**
     * Obtiene una reserva de vuelo por su clave compuesta (ID de turista, número de vuelo y fecha/hora del vuelo).
     * @param turistaId El ID del turista asociado a la reserva.
     * @param numeroVuelo El número del vuelo asociado a la reserva.
     * @param fechaHoraVuelo La fecha y hora del vuelo.
     * @return El objeto TuristaReservaVuelo si se encuentra, o null si no existe.
     */
    public TuristaReservaVuelo obtenerReservaPorClave(String turistaId, String numeroVuelo, Date fechaHoraVuelo) {
        for (TuristaReservaVuelo r : this.reservasVuelo) {
            if (r.getTurista().getId().equals(turistaId) &&
                r.getVuelo().getNumeroVuelo().equals(numeroVuelo) &&
                Objects.equals(r.getVuelo().getFechaHoraVuelo(), fechaHoraVuelo)) {
                return r;
            }
        }
        return null; // No se encontró la reserva
    }

    /**
     * Obtiene todas las reservas de vuelo para un turista específico.
     * @param turistaId El ID del turista.
     * @return Una lista de reservas de vuelo del turista.
     */
    public List<TuristaReservaVuelo> obtenerReservasPorTurista(String turistaId) {
        List<TuristaReservaVuelo> reservasDelTurista = new ArrayList<>();
        for (TuristaReservaVuelo r : this.reservasVuelo) {
            if (r.getTurista().getId().equals(turistaId)) {
                reservasDelTurista.add(r);
            }
        }
        return reservasDelTurista;
    }

    /**
     * Obtiene todas las reservas de vuelo para un vuelo específico.
     * @param numeroVuelo El número del vuelo.
     * @return Una lista de reservas en ese vuelo.
     */
    public List<TuristaReservaVuelo> obtenerReservasPorVuelo(String numeroVuelo) {
        List<TuristaReservaVuelo> reservasEnVuelo = new ArrayList<>();
        for (TuristaReservaVuelo r : this.reservasVuelo) {
            if (r.getVuelo().getNumeroVuelo().equals(numeroVuelo)) {
                reservasEnVuelo.add(r);
            }
        }
        return reservasEnVuelo;
    }

    // =========================================================
    // U - UPDATE (Actualizar una Reserva de Vuelo)
    // =========================================================
    /**
     * Actualiza la información de una reserva de vuelo existente.
     * Se busca la reserva original por su clave compuesta (ID de turista, número de vuelo y fecha/hora del vuelo original).
     * Luego se reemplaza por la reserva actualizada.
     * @param reservaOriginalTuristaId El ID del turista de la reserva original.
     * @param reservaOriginalNumeroVuelo El número de vuelo de la reserva original.
     * @param reservaOriginalFechaHoraVuelo La fecha y hora del vuelo original.
     * @param reservaActualizada El objeto TuristaReservaVuelo con la nueva información.
     * @return true si la reserva fue actualizada exitosamente, false si no se encontró la reserva original.
     */
    public boolean actualizarReservaVuelo(String reservaOriginalTuristaId, String reservaOriginalNumeroVuelo, Date reservaOriginalFechaHoraVuelo, TuristaReservaVuelo reservaActualizada) {
        if (reservaActualizada == null) {
            System.err.println("Error: No se puede actualizar con una reserva de vuelo nula.");
            return false;
        }

        for (int i = 0; i < this.reservasVuelo.size(); i++) {
            TuristaReservaVuelo r = this.reservasVuelo.get(i);
            if (r.getTurista().getId().equals(reservaOriginalTuristaId) &&
                r.getVuelo().getNumeroVuelo().equals(reservaOriginalNumeroVuelo) &&
                Objects.equals(r.getVuelo().getFechaHoraVuelo(), reservaOriginalFechaHoraVuelo)) {

                this.reservasVuelo.set(i, reservaActualizada); // Reemplaza el objeto existente
                System.out.println("Reserva de vuelo (Turista: " + reservaOriginalTuristaId +
                                   ", Vuelo: " + reservaOriginalNumeroVuelo +
                                   ", Fecha/Hora: " + reservaOriginalFechaHoraVuelo + ") actualizada con éxito.");
                return true;
            }
        }
        System.out.println("Error: Reserva de vuelo (Turista: " + reservaOriginalTuristaId +
                           ", Vuelo: " + reservaOriginalNumeroVuelo +
                           ", Fecha/Hora: " + reservaOriginalFechaHoraVuelo + ") no encontrada para actualizar.");
        return false;
    }

    // =========================================================
    // D - DELETE (Eliminar una Reserva de Vuelo)
    // =========================================================
    /**
     * Elimina una reserva de vuelo de la lista por su clave compuesta.
     * @param turistaId El ID del turista asociado a la reserva a eliminar.
     * @param numeroVuelo El número del vuelo asociado a la reserva a eliminar.
     * @param fechaHoraVuelo La fecha y hora del vuelo de la reserva a eliminar.
     * @return true si la reserva fue eliminada exitosamente, false si no se encontró.
     */
    public boolean eliminarReservaVuelo(String turistaId, String numeroVuelo, Date fechaHoraVuelo) {
        Iterator<TuristaReservaVuelo> iterator = this.reservasVuelo.iterator();
        while (iterator.hasNext()) {
            TuristaReservaVuelo r = iterator.next();
            if (r.getTurista().getId().equals(turistaId) &&
                r.getVuelo().getNumeroVuelo().equals(numeroVuelo) &&
                Objects.equals(r.getVuelo().getFechaHoraVuelo(), fechaHoraVuelo)) {
                iterator.remove();
                System.out.println("Reserva de vuelo (Turista: " + turistaId + ", Vuelo: " + numeroVuelo + ", Fecha/Hora: " + fechaHoraVuelo + ") eliminada con éxito.");
                return true;
            }
        }
        System.out.println("Error: Reserva de vuelo (Turista: " + turistaId + ", Vuelo: " + numeroVuelo + ", Fecha/Hora: " + fechaHoraVuelo + ") no encontrada para eliminar.");
        return false;
    }
}