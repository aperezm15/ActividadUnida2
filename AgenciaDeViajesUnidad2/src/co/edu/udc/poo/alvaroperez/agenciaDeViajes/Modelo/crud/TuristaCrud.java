package co.edu.udc.poo.alvaroperez.agenciaDeViajes.Modelo.crud;

import co.edu.udc.poo.alvaroperez.agenciaDeViajes.Modelo.entidades.Turista;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Mitzuke
 */
public class TuristaCrud {
    //Creamos coleccion para almacenar los objetos Turistas en memoria
    private List<Turista> turista;
    
    //Constructor
    public TuristaCrud() {
        this.turista = new ArrayList<>();
    }
    
    
    //Create Crear
    
    public boolean agregarTurista(Turista turista) {
        if (turista == null) {
            System.err.println("Error: No se puede agregar un turista nulo.");
            return false;
        }
        if (obtenerTuristaPorId(turista.getId()) != null) {
            System.err.println("Error: Ya existe un turista con el ID " + turista.getId());
            return false;
        }
        this.turista.add(turista);
        System.out.println("Turista " + turista.getNombreCompleto() + " Agregado con exito.");
        return true;
    }
    
    
    //read Leer
    
    public List<Turista> obtenerTodosLosTuristas() {
        return new ArrayList<>(this.turista);
    }

    public Turista obtenerTuristaPorId(String id) {
        for (Turista t : this.turista) {
            if (t.getId().equals(id)) {
                return t;
            }
        
        }
        return null;
    }
    
    
    //Update Editar Actualizar
    public boolean actualizarTurista(Turista turistaActualizado) {
        if (turistaActualizado == null) {
            System.err.println("Error: no se puede actualizar con un turista nulo");
            return false;
        }
        
        for (int i = 0; i < this.turista.size(); i++) {
            if (this.turista.get(i).getId().equals(turistaActualizado.getId())) {
                this.turista.set(i, turistaActualizado);
                System.out.println("Turista con ID " + turistaActualizado.getId() + " Agregado con exito.");
                return true;
            }
        }
        System.out.println("Error: Turista con ID " + turistaActualizado.getId() + " no encontrado para actualizar");
        return false;
    }
    
    
    //Delete Eliminar
    public boolean eliminarTurista(String id) {
        // Usamos Iterator para eliminar elementos de una colección de forma segura durante la iteración
        Iterator<Turista> iterator = this.turista.iterator();
        while (iterator.hasNext()) {
            Turista t = iterator.next();
            if (t.getId().equals(id)) {
                iterator.remove(); // Elimina el elemento actual de la colección
                System.out.println("Turista con ID " + id + " eliminado con exito.");
                return true;
            }
        }
        System.out.println("Error: Turista con ID " + id + " no encontrado para eliminar.");
        return false;
    }
    // Otros métodos útiles (ejemplo: para verificar duplicados)
    public boolean existeTurista(String id) {
        return obtenerTuristaPorId(id) != null;
    }
    
}
