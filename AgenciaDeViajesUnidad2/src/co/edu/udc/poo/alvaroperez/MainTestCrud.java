 
package co.edu.udc.poo.alvaroperez;

import co.edu.udc.poo.alvaroperez.agenciaDeViajes.Modelo.entidades.*;
import co.edu.udc.poo.alvaroperez.agenciaDeViajes.Modelo.crud.*; // Importa todos los managers CRUD

import java.util.Date;
import java.util.Calendar;
import java.util.List;

public class MainTestCrud {
    public static void main(String[] args) {

        //INSTANCIAMOS LOS CRUD  <-------------
        SucursalCrud sucursalCrud = new SucursalCrud();
        TuristaCrud turistaCrud = new TuristaCrud();
        HotelCrud hotelCrud = new HotelCrud();
        VueloCrud vueloCrud = new VueloCrud();
        TuristaReservaHotelCrud reservaHotelCrud = new TuristaReservaHotelCrud();
        TuristaReservaVueloCrud reservaVueloCrud = new TuristaReservaVueloCrud();
        System.out.println("Managers CRUD inicializados.");


        System.out.println("\n================================================================");
        System.out.println("                 PRUEBAS CRUD: SUCURSALES                       ");
        System.out.println("================================================================");

        // C - CREATE
        System.out.println("\n--- C: Agregando Sucursales ---");
        Sucursal suc1 = new Sucursal("SUC001", "Sede Cartagena", "Cartagena", "Calle xx, Carrera xx", "3001234567");
        Sucursal suc2 = new Sucursal("SUC002", "Sede Barranquilla", "Barranquilla", "Calle xx, Carrera xx", "3109876543");
        sucursalCrud.agregarSucursal(suc1);
        sucursalCrud.agregarSucursal(suc2);
       

        // R - READ
        System.out.println("\n--- R: Listado de todas las sucursales ---");
        List<Sucursal> todasLasSucursales = sucursalCrud.obtenerTodasLasSucursales();
        if (todasLasSucursales.isEmpty()) System.out.println("No hay sucursales registradas.");
        for (Sucursal s : todasLasSucursales) { s.mostrarInformacion(); System.out.println("-----"); }

        System.out.println("\n--- R: Buscando sucursal por Codigo (SUC002) ---");
        Sucursal sucursalEncontrada = sucursalCrud.obtenerSucursalPorCodigo("SUC002");
        if (sucursalEncontrada != null) sucursalEncontrada.mostrarInformacion();
        else System.out.println("Sucursal SUC002 no encontrada.");

        // U - UPDATE
        System.out.println("\n--- U: Actualizando Sucursal SUC001 ---");
        Sucursal suc1Actualizada = new Sucursal("SUC001", "Sede Cartagena", "Cartagena", "Nueva Calle xx, Carrera xx", "3000000000");
        sucursalCrud.actualizarSucursal(suc1Actualizada);
        System.out.println("\n--- U: Verificando actualizacion de SUC001 ---");
        sucursalCrud.obtenerSucursalPorCodigo("SUC001").mostrarInformacion();

        // D - DELETE
        System.out.println("\n--- D: Eliminando Sucursal SUC002 ---");
        sucursalCrud.eliminarSucursal("SUC002");
        System.out.println("\n--- D: Listado de sucursales despues de la eliminacion ---");
        todasLasSucursales = sucursalCrud.obtenerTodasLasSucursales();
        if (todasLasSucursales.isEmpty()) System.out.println("No hay sucursales registradas.");
        for (Sucursal s : todasLasSucursales) { s.mostrarInformacion(); System.out.println("-----"); }



        System.out.println("\n================================================================");
        System.out.println("                  PRUEBAS CRUD: TURISTAS                        ");
        System.out.println("================================================================");

        // Asegurarse de que tenemos una sucursal para asignar a los turistas
        Sucursal sucursalParaTurista = sucursalCrud.obtenerSucursalPorCodigo("SUC001");
        if (sucursalParaTurista == null) {
            System.err.println("No se encontró la sucursal SUC001 para las pruebas de Turista. Creándola...");
            sucursalParaTurista = new Sucursal("SUC001", "Sede Cartagena", "Cartagena", "Calle 10 # 5-20", "3001234567");
            sucursalCrud.agregarSucursal(sucursalParaTurista);
        }

        // C - CREATE
        System.out.println("\n--- C: Agregando Turistas ---");
        Turista t1 = new Turista("TUR001", "Bella Botello", "123456789", "Tierra donde fluye leche y miel <3", "3109876543", sucursalParaTurista);
        Turista t2 = new Turista("TUR002", "Alvaro Perez", "987654321", "Calle xx, Carrera xx", "3201112233", sucursalParaTurista);
        turistaCrud.agregarTurista(t1);
        turistaCrud.agregarTurista(t2);
        turistaCrud.agregarTurista(t1); // Intentar agregar ya uno existente

        // R - READ
        System.out.println("\n--- R: Listado de todos los turistas ---");
        List<Turista> todosLosTuristas = turistaCrud.obtenerTodosLosTuristas();
        if (todosLosTuristas.isEmpty()) System.out.println("No hay turistas registrados.");
        for (Turista t : todosLosTuristas) { t.mostrarInformacion(); System.out.println("-----"); }

        System.out.println("\n--- R: Buscando turista por ID (987654321) ---");
        Turista turistaEncontrado = turistaCrud.obtenerTuristaPorId("987654321");
        if (turistaEncontrado != null) turistaEncontrado.mostrarInformacion();
        else System.out.println("Turista con ID 987654321 no encontrado.");

        // U - UPDATE
        System.out.println("\n--- U: Actualizando Turista TUR001 (Bella Botello) ---");
        Turista t1Actualizado = new Turista("TUR001", "Bella Botello", "123456789", "Tierra donde fluye leche y miel <3", "Sin numero", sucursalParaTurista);
        turistaCrud.actualizarTurista(t1Actualizado);
        System.out.println("\n--- U: Verificando actualizacion de TUR001 ---");
        turistaCrud.obtenerTuristaPorId("123456789").mostrarInformacion();

        // D - DELETE
        System.out.println("\n--- D: Eliminando Turista TUR002 (Alvaro Perez) ---");
        turistaCrud.eliminarTurista("987654321");
        System.out.println("\n--- D: Listado de turistas despues de la eliminacion ---");
        todosLosTuristas = turistaCrud.obtenerTodosLosTuristas();
        if (todosLosTuristas.isEmpty()) System.out.println("No hay turistas registrados.");
        for (Turista t : todosLosTuristas) { t.mostrarInformacion(); System.out.println("-----"); }



        System.out.println("\n================================================================");
        System.out.println("                    PRUEBAS CRUD: HOTELES                       ");
        System.out.println("================================================================");

        // C - CREATE
        System.out.println("\n--- C: Agregando Hoteles ---");
        Hotel h1 = new Hotel("HOT001", "Hotel Cartagena", "calle xx, carrera xx", "Cartagena", "6051112233", 50);
        Hotel h2 = new Hotel("HOT002", "Resort Santa Marta", "calle xx, carrera xx", "Santa Marta", "6054445566", 75);
        hotelCrud.agregarHotel(h1);
        hotelCrud.agregarHotel(h2);
       

        // R - READ
        System.out.println("\n--- R: Listado de todos los hoteles ---");
        List<Hotel> todosLosHoteles = hotelCrud.obtenerTodosLosHoteles();
        if (todosLosHoteles.isEmpty()) System.out.println("No hay hoteles registrados.");
        for (Hotel h : todosLosHoteles) { h.mostrarInformacion(); System.out.println("-----"); }

        System.out.println("\n--- R: Buscando hotel por Codigo (HOT002) ---");
        Hotel hotelEncontrado = hotelCrud.obtenerHotelPorCodigo("HOT002");
        if (hotelEncontrado != null) hotelEncontrado.mostrarInformacion();
        else System.out.println("Hotel HOT002 no encontrado.");

        // U - UPDATE
        System.out.println("\n--- U: Actualizando Hotel HOT001 ---");
        Hotel h1Actualizado = new Hotel("HOT001", "Hotel Cartagena Plaza", "Calle xx, Carrera xx", "Cartagena", "6051112233", 45);
        hotelCrud.actualizarHotel(h1Actualizado);
        System.out.println("\n--- U: Verificando actualizacion de HOT001 ---");
        hotelCrud.obtenerHotelPorCodigo("HOT001").mostrarInformacion();

        // D - DELETE
        System.out.println("\n--- D: Eliminando Hotel HOT002 ---");
        hotelCrud.eliminarHotel("HOT002");
        System.out.println("\n--- D: Listado de hoteles despues de la eliminacion ---");
        todosLosHoteles = hotelCrud.obtenerTodosLosHoteles();
        if (todosLosHoteles.isEmpty()) System.out.println("No hay hoteles registrados.");
        for (Hotel h : todosLosHoteles) { h.mostrarInformacion(); System.out.println("-----"); }



        System.out.println("\n================================================================");
        System.out.println("                     PRUEBAS CRUD: VUELOS                       ");
        System.out.println("================================================================");

        // Fechas para vuelos
        Calendar calV1 = Calendar.getInstance(); calV1.set(2025, Calendar.JULY, 1, 10, 30, 0); Date fechaHoraVuelo1 = calV1.getTime();
        Calendar calV2 = Calendar.getInstance(); calV2.set(2025, Calendar.AUGUST, 15, 8, 0, 0); Date fechaHoraVuelo2 = calV2.getTime();
        Calendar calV3 = Calendar.getInstance(); calV3.set(2025, Calendar.JULY, 1, 14, 0, 0); Date fechaHoraVuelo3 = calV3.getTime();

        // C - CREATE
        System.out.println("\n--- C: Agregando Vuelos ---");
        Vuelo v1 = new Vuelo("VUELO001", fechaHoraVuelo1, "Cartagena", "Bogota", 180, 150);
        Vuelo v2 = new Vuelo("VUELO002", fechaHoraVuelo2, "Bogota", "Medellin", 100, 80);
        Vuelo v3 = new Vuelo("VUELO001", fechaHoraVuelo3, "Cartagena", "Cali", 120, 100);
        vueloCrud.agregarVuelo(v1);
        vueloCrud.agregarVuelo(v2);
        vueloCrud.agregarVuelo(v3);
        vueloCrud.agregarVuelo(v1); // Intentar agregar duplicado

        // R - READ
        System.out.println("\n--- R: Listado de todos los vuelos ---");
        List<Vuelo> todosLosVuelos = vueloCrud.obtenerTodosLosVuelos();
        if (todosLosVuelos.isEmpty()) System.out.println("No hay vuelos registrados.");
        for (Vuelo v : todosLosVuelos) { v.mostrarInformacion(); System.out.println("-----"); }

        System.out.println("\n--- R: Buscando vuelo por clave (VUELO001, 01/Jul 10:30) ---");
        Vuelo vueloEncontrado = vueloCrud.obtenerVueloPorClave("VUELO001", fechaHoraVuelo1);
        if (vueloEncontrado != null) vueloEncontrado.mostrarInformacion();
        else System.out.println("Vuelo VUELO001 (01/Jul 10:30) no encontrado.");

        // U - UPDATE
        System.out.println("\n--- U: Actualizando Vuelo VUELO002 (15/Ago 08:00) ---");
        Vuelo v2Actualizado = new Vuelo("VUELO002", fechaHoraVuelo2, "Bogota", "Cancun", 100, 70);
        vueloCrud.actualizarVuelo("VUELO002", fechaHoraVuelo2, v2Actualizado);
        System.out.println("\n--- U: Verificando actualizacion de VUELO002 ---");
        vueloCrud.obtenerVueloPorClave("VUELO002", fechaHoraVuelo2).mostrarInformacion();

        // D - DELETE
        System.out.println("\n--- D: Eliminando Vuelo VUELO001 (01/Jul 14:00) ---");
        vueloCrud.eliminarVuelo("VUELO001", fechaHoraVuelo3);
        System.out.println("\n--- D: Listado de vuelos despues de la eliminacion ---");
        todosLosVuelos = vueloCrud.obtenerTodosLosVuelos();
        if (todosLosVuelos.isEmpty()) System.out.println("No hay vuelos registrados.");
        for (Vuelo v : todosLosVuelos) { v.mostrarInformacion(); System.out.println("-----"); }



        System.out.println("\n================================================================");
        System.out.println("             PRUEBAS CRUD: RESERVAS DE HOTEL                    ");
        System.out.println("================================================================");

        // Asegurarse de que tenemos un turista y un hotel para las reservas
        Turista turistaReservaHotel = turistaCrud.obtenerTuristaPorId("123456789");
        Hotel hotelReservaHotel = hotelCrud.obtenerHotelPorCodigo("HOT001");
        if (turistaReservaHotel == null || hotelReservaHotel == null) {
            System.err.println("No se pudo realizar pruebas de reserva de hotel: Turista o Hotel no encontrados.");
            System.err.println("Asegúrate de que 'Bella Botello' (ID 123456789) y 'Hotel Cartagena' (HOT001) existan después de sus pruebas CRUD.");
        } else {
            // Fechas para reservas de hotel
            Calendar calRH1 = Calendar.getInstance(); calRH1.set(2025, Calendar.JULY, 20); Date fechaLlegadaRH1 = calRH1.getTime();
            Calendar calRS1 = Calendar.getInstance(); calRS1.set(2025, Calendar.JULY, 25); Date fechaSalidaRH1 = calRS1.getTime();

            Calendar calRH2 = Calendar.getInstance(); calRH2.set(2025, Calendar.AUGUST, 1); Date fechaLlegadaRH2 = calRH2.getTime();
            Calendar calRS2 = Calendar.getInstance(); calRS2.set(2025, Calendar.AUGUST, 7); Date fechaSalidaRH2 = calRS2.getTime();

            // C - CREATE
            System.out.println("\n--- C: Agregando Reservas de Hotel ---");
            TuristaReservaHotel resH1 = new TuristaReservaHotel(turistaReservaHotel, TipoPension.PENSIONADO_COMPLETO, hotelReservaHotel, fechaLlegadaRH1, fechaSalidaRH1);
            reservaHotelCrud.agregarReservaHotel(resH1);
            // Simular otra reserva con un nuevo turista o en un nuevo hotel si se hubieran creado
            // TuristaReservaHotel resH2 = new TuristaReservaHotel(otroTurista, TipoPension.MEDIO_PENSIONADO, otroHotel, fechaLlegadaRH2, fechaSalidaRH2);
            // reservaHotelManager.agregarReservaHotel(resH2);
            reservaHotelCrud.agregarReservaHotel(resH1); // Intentar agregar duplicado

            // R - READ
            System.out.println("\n--- R: Listado de todas las reservas de hotel ---");
            List<TuristaReservaHotel> todasLasReservasHotel = reservaHotelCrud.obtenerTodasLasReservasHotel();
            if (todasLasReservasHotel.isEmpty()) System.out.println("No hay reservas de hotel registradas.");
            for (TuristaReservaHotel r : todasLasReservasHotel) { r.mostrarInformacion(); System.out.println("----------"); }

            System.out.println("\n--- R: Buscando reserva específica (Bella, HOT001, 20/Jul) ---");
            TuristaReservaHotel reservaHEncontrada = reservaHotelCrud.obtenerReservaPorClave(turistaReservaHotel.getId(), hotelReservaHotel.getCodigo(), fechaLlegadaRH1);
            if (reservaHEncontrada != null) reservaHEncontrada.mostrarInformacion();
            else System.out.println("Reserva de hotel no encontrada.");

            // U - UPDATE
            System.out.println("\n--- U: Actualizando reserva de hotel de Bella (HOT001, 20/Jul) ---");
            // Nueva fecha de salida y tipo de pensión
            Calendar calRS1Actualizada = Calendar.getInstance(); calRS1Actualizada.set(2025, Calendar.JULY, 28); Date fechaSalidaRH1Actualizada = calRS1Actualizada.getTime();
            TuristaReservaHotel resH1Actualizada = new TuristaReservaHotel(turistaReservaHotel, TipoPension.MEDIO_PENSIONADO, hotelReservaHotel, fechaLlegadaRH1, fechaSalidaRH1Actualizada);
            reservaHotelCrud.actualizarReservaHotel(turistaReservaHotel.getId(), hotelReservaHotel.getCodigo(), fechaLlegadaRH1, resH1Actualizada);
            System.out.println("\n--- U: Verificando actualización de la reserva de hotel de Bella ---");
            reservaHotelCrud.obtenerReservaPorClave(turistaReservaHotel.getId(), hotelReservaHotel.getCodigo(), fechaLlegadaRH1).mostrarInformacion();

            // D - DELETE
            System.out.println("\n--- D: Eliminando reserva de hotel de Bella (HOT001, 20/Jul) ---");
            reservaHotelCrud.eliminarReservaHotel(turistaReservaHotel.getId(), hotelReservaHotel.getCodigo(), fechaLlegadaRH1);
            System.out.println("\n--- D: Listado de reservas de hotel después de la eliminación ---");
            todasLasReservasHotel = reservaHotelCrud.obtenerTodasLasReservasHotel();
            if (todasLasReservasHotel.isEmpty()) System.out.println("No hay reservas de hotel registradas.");
            for (TuristaReservaHotel r : todasLasReservasHotel) { r.mostrarInformacion(); System.out.println("----------"); }
        }

        // ---------------------------------------------------------
        // 7. PRUEBAS CRUD PARA TURISTARESERVAVUELO
        // ---------------------------------------------------------
        System.out.println("\n================================================================");
        System.out.println("                PRUEBAS CRUD: RESERVAS DE VUELO                 ");
        System.out.println("================================================================");

        // Asegurarse de que tenemos un turista y un vuelo para las reservas
        Turista turistaReservaVuelo = turistaCrud.obtenerTuristaPorId("123456789");
        Vuelo vueloReservaVuelo = vueloCrud.obtenerVueloPorClave("VUELO001", fechaHoraVuelo1); // Usar el vuelo que no fue eliminado

        if (turistaReservaVuelo == null || vueloReservaVuelo == null) {
            System.err.println("No se pudo realizar pruebas de reserva de vuelo: Turista o Vuelo no encontrados.");
            System.err.println("Asegúrate de que 'Bella Botello' (ID 123456789) y 'VUELO001' (01/Jul 10:30) existan.");
        } else {
            // C - CREATE
            System.out.println("\n--- C: Agregando Reservas de Vuelo ---");
            TuristaReservaVuelo resV1 = new TuristaReservaVuelo(turistaReservaVuelo, TipoPlaza.TURISTA, vueloReservaVuelo);
            reservaVueloCrud.agregarReservaVuelo(resV1);
            reservaVueloCrud.agregarReservaVuelo(resV1); // Intentar agregar duplicado

            // R - READ
            System.out.println("\n--- R: Listado de todas las reservas de vuelo ---");
            List<TuristaReservaVuelo> todasLasReservasVuelo = reservaVueloCrud.obtenerTodasLasReservasVuelo();
            if (todasLasReservasVuelo.isEmpty()) System.out.println("No hay reservas de vuelo registradas.");
            for (TuristaReservaVuelo r : todasLasReservasVuelo) { r.mostrarInformacion(); System.out.println("----------"); }

            System.out.println("\n--- R: Buscando reserva específica (Bella, VUELO001, 01/Jul 10:30) ---");
            TuristaReservaVuelo reservaVEncontrada = reservaVueloCrud.obtenerReservaPorClave(turistaReservaVuelo.getId(), vueloReservaVuelo.getNumeroVuelo(), vueloReservaVuelo.getFechaHoraVuelo());
            if (reservaVEncontrada != null) reservaVEncontrada.mostrarInformacion();
            else System.out.println("Reserva de vuelo no encontrada.");

            // U - UPDATE
            System.out.println("\n--- U: Actualizando reserva de vuelo de Bella (VUELO001, 01/Jul 10:30) ---");
            TuristaReservaVuelo resV1Actualizada = new TuristaReservaVuelo(turistaReservaVuelo, TipoPlaza.PRIMERA_CLASE, vueloReservaVuelo);
            reservaVueloCrud.actualizarReservaVuelo(turistaReservaVuelo.getId(), vueloReservaVuelo.getNumeroVuelo(), vueloReservaVuelo.getFechaHoraVuelo(), resV1Actualizada);
            System.out.println("\n--- U: Verificando actualización de la reserva de vuelo de Bella ---");
            reservaVueloCrud.obtenerReservaPorClave(turistaReservaVuelo.getId(), vueloReservaVuelo.getNumeroVuelo(), vueloReservaVuelo.getFechaHoraVuelo()).mostrarInformacion();

            // D - DELETE
            System.out.println("\n--- D: Eliminando reserva de vuelo de Bella (VUELO001, 01/Jul 10:30) ---");
            reservaVueloCrud.eliminarReservaVuelo(turistaReservaVuelo.getId(), vueloReservaVuelo.getNumeroVuelo(), vueloReservaVuelo.getFechaHoraVuelo());
            System.out.println("\n--- D: Listado de reservas de vuelo después de la eliminación ---");
            todasLasReservasVuelo = reservaVueloCrud.obtenerTodasLasReservasVuelo();
            if (todasLasReservasVuelo.isEmpty()) System.out.println("No hay reservas de vuelo registradas.");
            for (TuristaReservaVuelo r : todasLasReservasVuelo) { r.mostrarInformacion(); System.out.println("----------"); }
        }

        System.out.println("\n================================================================");
        System.out.println("            FIN DE PRUEBAS CRUD PARA AGENCIA DE VIAJES          ");
        System.out.println("================================================================");
    }
}