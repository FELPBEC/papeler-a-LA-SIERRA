public class Clientes{
    private String nombre;
    private Productos productoAComprar;
    private double presupuesto;
    private boolean esDeudor;
    private int Cantidad;
    
    public Clientes(String nombre, Productos productoAComprar, double presupuesto, boolean esDeudor, int Cantidad) {
        this.nombre = nombre;
        this.productoAComprar = productoAComprar;
        this.presupuesto = presupuesto;
        this.esDeudor = esDeudor;
        this.Cantidad = Cantidad;
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
    public boolean isEsDeudor() {
        return esDeudor;
    }
    public void setEsDeudor(boolean esDeudor) {
        this.esDeudor = esDeudor;
    }

}