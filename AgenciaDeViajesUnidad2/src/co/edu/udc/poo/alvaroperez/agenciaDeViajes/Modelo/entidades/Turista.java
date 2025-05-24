package co.edu.udc.poo.alvaroperez.agenciaDeViajes.Modelo.entidades;


public class Turista {
    private String codigo;
    private String nombreCompleto;
    private String id;
    private String direccion;
    private String telefono;
    private Sucursal sucursal;

    public Turista(String codigo, String nombreCompleto,String id, String direccion, String telefono, Sucursal sucursal){
    this.codigo = codigo;
    this.nombreCompleto = nombreCompleto;
    this.id = id;
    this.direccion = direccion;
    this.telefono = telefono;
    this.sucursal = sucursal;
    }

    public String getCodigo(){
    return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreCompleto(){
        return nombreCompleto;
    }
    
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getId(){
        return id;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public String getDireccion(){
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono(){
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
       
    public void setSucursal(Sucursal sucursal){
        this.sucursal = sucursal;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }
    

    
    public void mostrarInformacion(){
        System.out.printf("%-35s: %s\n", "Codigo Turista", codigo);
        System.out.printf("%-35s: %s\n", "Nombre Completo", nombreCompleto);
        System.out.printf("%-35s: %s\n", "Cedula", id);
        System.out.printf("%-35s: %s\n", "Direccion", direccion);
        System.out.printf("%-35s: %s\n", "Telefono", telefono);
        System.out.printf("%-35s: %s\n", "Registrado en la sucursal", sucursal.getCodigo());
                   

    }








}

