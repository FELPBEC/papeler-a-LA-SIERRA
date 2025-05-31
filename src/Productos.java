public class Productos {
    private String nombreProducto;
    private double precio;
    private String tipoProducto;
    private int existencias;
    public Productos(String nombreProducto, double precio, String tipoProducto, int existencias) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
        this.existencias = existencias;
    }
    public String getNombreProducto() {
        return nombreProducto;
    }
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getTipoProducto() {
        return tipoProducto;
    }
    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
    public int getExistencias() {
        return existencias;
    }
    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

}
