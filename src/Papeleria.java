import java.util.ArrayList;

public class Papeleria {
    private ArrayList<Clientes> clientes;
    private ArrayList<Productos> productos;
    public Papeleria(){
        this.clientes=new ArrayList<Clientes>();
        this.productos=new ArrayList<Productos>();
    }
public String NuevoCliente(String nombre,String id, double presupuesto){
    /*Se crea un nuevo cliente,
     * 
     */
    clientes.add(new Clientes(nombre, id, presupuesto));
    return "Se agrego el cliente exitosamente";   
    }
public String MostrarClientes(){
    /*Muestra todos los clientes existentes,
     sirve principalmente para identificar deudores
     * 
     */
    String listaClientes="";
    for (int i = 0; i < clientes.size(); i++) {
        listaClientes+=clientes.get(i).getNombre()+" "+clientes.get(i).getId()+" "+(clientes.get(i).getDineroDeduda()>0?"EL CLIENTE ES DEUDOR, y su deuda es de"+clientes.get(i).getDineroDeduda():"EL CLIENTE NO ES DEUDOR")+"\n";
    }
    return listaClientes;
}
public String NuevoProducto(String nombreProducto, double precio, byte tipoProducto, int existencias){
    /*Se ingresa un nuevo produco al inventario */
    productos.add(new Productos(nombreProducto, precio, tipoProducto, existencias) );
    return "Se agrego el producto exitosamente";   
    }
public String Inventario( byte tipoProducto){
    
    String inventario="";
    for (int i = 0; i < productos.size(); i++) {
        if (tipoProducto==productos.get(i).getTipoProducto()) {
            inventario+=" "+productos.get(i).getNombreProducto() +"          "+productos.get(i).getExistencias()+"          "+productos.get(i).getPrecio() + "\n";
        }
        
}
return "Nombre:          existencias:               precio "+"\n"+inventario;
}
}
