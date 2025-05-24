package co.edu.udc.poo.alvaroperez; 

import co.edu.udc.poo.alvaroperez.agenciaDeViajes.Modelo.entidades.*; // Importa todas tus clases
import java.util.Date;
import java.util.Calendar; // Para manejar fechas de forma más cómoda

public class Main {
    public static void main(String[] args) {

        System.out.println("--- PRUEBA DE LA AGENCIA DE VIAJES ---");

        // 1. Creamos sucursales
        Sucursal sucursalCartagena = new Sucursal(
            "SUC001",
            "Sede Cartagena",
            "Cartagena",
            "Calle xx, Carrera xx",
            "3001234567"
        );
        Sucursal sucursalMedellin = new Sucursal(
            "SUC002",
            "Sede Medellin",
            "Medelllin",
            "Calle xx, Carrera xx",
            "3021234265"
        );
        System.out.println("\n--- Información de Sucursales ---");
        sucursalCartagena.mostrarInformacion();
        System.out.println("-----------------------------------------");
        sucursalMedellin.mostrarInformacion();

        // 2. Crear algunos turistas
        Turista turista1 = new Turista(
            "TUR001",
            "Bella Botello",
            "123456789",
            "Tierra donde fluye leche y miel <3",
            "3109876543",
            sucursalCartagena // Asociamos el turista a la sucursal
        );
        Turista turista2 = new Turista(
            "TUR002",
            "Alvaro Perez",
            "987654321",
            "Calle xx, Carrera xx",
            "3201112233",
            sucursalMedellin // Asociamos el turista a la sucursal
        );

        System.out.println("\n--- Información de los Turistas Creados ---");
        turista1.mostrarInformacion();
        System.out.println("----------------------------------------");
        turista2.mostrarInformacion();


        // 3. Crear un hotel
        Hotel hotelParaiso = new Hotel(
            "HOT001",
            "Hotel El Paraíso",
            "Calle xx, Carrera xx",
            "Santa Marta",
            "6054445566",
            100
        );
        System.out.println("\n--- Información del Hotel Creado ---");
        hotelParaiso.mostrarInformacion();

        // 4. Crear un vuelo
        Calendar calVuelo = Calendar.getInstance();
        calVuelo.set(2025, Calendar.JULY, 1, 10, 30); // 1 de Julio de 2025, 10:30 AM
        Date fechaHoraVuelo1 = calVuelo.getTime();

        Vuelo vueloNacional = new Vuelo(
            "VUELO001",
            fechaHoraVuelo1,
            "Cartagena",
            "Bogotá",
            180,
            150
        );
        System.out.println("\n--- Información del Vuelo Creado ---");
        vueloNacional.mostrarInformacion();

        
        // PRUEBA DE RESERVAS A TRAVÉS DE LA SUCURSAL
        

        System.out.println("\n\n--- REALIZANDO RESERVAS ---");

        // Reserva de Hotel para Bella botello
        Calendar calLlegadaBella = Calendar.getInstance();
        calLlegadaBella.set(2025, Calendar.AUGUST, 10); // 10 de Agosto de 2025
        Date fechaLlegadaBella = calLlegadaBella.getTime();

        Calendar calSalidaBella = Calendar.getInstance();
        calSalidaBella.set(2025, Calendar.AUGUST, 15); // 15 de Agosto de 2025
        Date fechaSalidaBella = calSalidaBella.getTime();

        System.out.println("\n*** Realizando reserva de hotel para Bella Botello ***");
        TuristaReservaHotel reservaBellaHotel = sucursalCartagena.realizarReserva(
            turista1,
            TipoPension.PENSIONADO_COMPLETO,
            hotelParaiso,
            fechaLlegadaBella,
            fechaSalidaBella
        );
        System.out.println("\n--- Detalles de la Reserva de Hotel de Bella ---");
        reservaBellaHotel.mostrarInformacion();


        // Reserva de Vuelo para Alvaro Perez
        System.out.println("\n*** Realizando reserva de vuelo para Alvaro Perez ***");
        TuristaReservaVuelo reservaAlvaroVuelo = sucursalMedellin.realizarReserva(
            turista2,
            TipoPlaza.PRIMERA_CLASE,
            vueloNacional
        );
        System.out.println("\n--- Detalles de la Reserva de Vuelo de Alvaro ---");
        reservaAlvaroVuelo.mostrarInformacion();


        // Otro ejemplo: Vuelo para Bella Botello (si quisiera solo vuelo)
        System.out.println("\n*** Realizando reserva de vuelo para Bella ***");
        TuristaReservaVuelo reservaBellaVuelo = sucursalCartagena.realizarReserva(
            turista1,
            TipoPlaza.TURISTA,
            vueloNacional
        );
        System.out.println("\n--- Detalles de la Reserva de Vuelo de Bella ---");
        reservaBellaVuelo.mostrarInformacion();


    }
}