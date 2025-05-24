package co.edu.udc.poo.alvaroperez.agenciaDeViajes.Modelo.crud;

import co.edu.udc.poo.alvaroperez.agenciaDeViajes.Modelo.entidades.Sucursal;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator; // Para eliminar de forma segura

public class SucursalCrud {

    // Colección para almacenar los objetos Sucursal en memoria
    private List<Sucursal> sucursales;

    // Constructor
    public SucursalCrud() {
        this.sucursales = new ArrayList<>();
    }
        //Create
    public boolean agregarSucursal(Sucursal sucursal) {
        if (sucursal == null) {
            System.err.println("Error: No se puede agregar una sucursal nula.");
            return false;
        }
        // Verificar si ya existe una sucursal con el mismo código
        if (obtenerSucursalPorCodigo(sucursal.getCodigo()) != null) {
            System.out.println("Error: Ya existe una sucursal con el codigo: " + sucursal.getCodigo());
            return false;
        }
        this.sucursales.add(sucursal);
        System.out.println("Sucursal " + sucursal.getNombreSucursal() + " agregada con exito.");
        return true;
    }

    // READ
    public List<Sucursal> obtenerTodasLasSucursales() {
        return new ArrayList<>(this.sucursales); // 
    }

    
    public Sucursal obtenerSucursalPorCodigo(String codigo) {
        for (Sucursal s : this.sucursales) {
            if (s.getCodigo().equals(codigo)) { 
                return s;
            }
        }
        return null; 
    }

    // Update
    public boolean actualizarSucursal(Sucursal sucursalActualizada) {
        if (sucursalActualizada == null) {
            System.err.println("Error: No se puede actualizar con una sucursal nula.");
            return false;
        }

        for (int i = 0; i < this.sucursales.size(); i++) {
            if (this.sucursales.get(i).getCodigo().equals(sucursalActualizada.getCodigo())) {
                this.sucursales.set(i, sucursalActualizada); // Reemplaza el objeto existente
                System.out.println("Sucursal con codigo " + sucursalActualizada.getCodigo() + " actualizada con exito.");
                return true;
            }
        }
        System.out.println("Error: Sucursal con codigo " + sucursalActualizada.getCodigo() + " no encontrada para actualizar.");
        return false;
    }

    // Delete
    public boolean eliminarSucursal(String codigo) {
        Iterator<Sucursal> iterator = this.sucursales.iterator();
        while (iterator.hasNext()) {
            Sucursal s = iterator.next();
            if (s.getCodigo().equals(codigo)) {
                iterator.remove(); // Elimina el elemento actual de la colección
                System.out.println("Sucursal con codigo " + codigo + " eliminada con exito.");
                return true;
            }
        }
        System.out.println("Error: Sucursal con codigo " + codigo + " no encontrada para eliminar.");
        return false;
    }

    // Método para verificar la existencia de una sucursal por su código
    public boolean existeSucursal(String codigo) {
        return obtenerSucursalPorCodigo(codigo) != null;
    }
}