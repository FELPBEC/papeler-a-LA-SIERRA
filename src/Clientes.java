public class Clientes{
    private String nombre;
    private String id;
    private double presupuesto;
    private double dineroDeduda;
    
    public Clientes(String nombre,String id, double presupuesto) {
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.dineroDeduda = 0;
        this.id=id;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPresupuesto() {
        return presupuesto;
    }
    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
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


}