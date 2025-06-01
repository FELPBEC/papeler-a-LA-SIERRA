public class Clientes{
    private String nombre;
    private String apellido;
    private String id;
    private double dineroDeduda;
    
    public Clientes(String nombre,String apellido,String id) {
        this.nombre = nombre;
        this.apellido= apellido;
        this.id=id;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getDineroDeduda() {
        return dineroDeduda;
    }

    public void setDineroDeduda(double dineroDeduda) {
        this.dineroDeduda = dineroDeduda;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


}