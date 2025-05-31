public class Clientes{
    private String nombre;
    private Productos productoAComprar;
    private double presupuesto;
    private double dineroDeduda;
    private int cantidadAComprar;
    
    public Clientes(String nombre, Productos productoAComprar, double presupuesto, double dineroDeduda, int cantidadAComprar) {
        this.nombre = nombre;
        this.productoAComprar = productoAComprar;
        this.presupuesto = presupuesto;
        this.dineroDeduda = dineroDeduda;
        this.cantidadAComprar = cantidadAComprar;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Productos getProductoAComprar() {
        return productoAComprar;
    }
    public void setProductoAComprar(Productos productoAComprar) {
        this.productoAComprar = productoAComprar;
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

    public int getCantidadAComprar() {
        return cantidadAComprar;
    }

    public void setCantidadAComprar(int cantidadAComprar) {
        this.cantidadAComprar = cantidadAComprar;
    }


}