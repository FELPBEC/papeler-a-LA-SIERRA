public class Productos {
    private String nombreProducto;
    private double precio;
    private byte tipoProducto;
    private int existencias;
    public Productos(String nombreProducto, double precio, byte tipoProducto, int existencias) {
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
    public int getExistencias() {
        return existencias;
    }
    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }
    public byte getTipoProducto() {
        return tipoProducto;
    }
    public void setTipoProducto(byte tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

}
