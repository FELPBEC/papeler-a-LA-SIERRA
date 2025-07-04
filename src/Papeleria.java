import java.util.ArrayList;

public class Papeleria {
    private ArrayList<Clientes> clientes;
    private ArrayList<Productos> productos;
    public Papeleria(){
        this.clientes=new ArrayList<Clientes>();
        this.productos=new ArrayList<Productos>();
    }
public boolean EncontrarCliente(String id){
    boolean seEncontro= false;
    for (int i = 0; i < clientes.size(); i++) {
        /*Se comprueba por medio de la ID 
        que no se trate de un cliente duplicado
         * pues cad ID es unica
         */
        if (id.equals(clientes.get(i).getId())) {
            seEncontro=true;
        }
    }
    return seEncontro;
}
public boolean EncontrarProducto(String nombreProducto){
    boolean seEncontro= false;
   for (int i = 0; i < productos.size(); i++) {
        if (nombreProducto.equalsIgnoreCase(productos.get(i).getNombreProducto())) {
           seEncontro=true;
        }
   }
   return seEncontro;
}
public boolean DeterminarDeudor(String id){
    boolean deudor = false;
    for (int i = 0; i < clientes.size(); i++) {
        if (id.equalsIgnoreCase(clientes.get(i).getId())&& clientes.get(i).getDineroDeduda()>0) {
            deudor=true;
        }
    }
    return deudor;
}
public double DeterminarDeduda(String id){
    double deuda = 0;
    for (int i = 0; i < clientes.size(); i++) {
        if (id.equalsIgnoreCase(clientes.get(i).getId())&& clientes.get(i).getDineroDeduda()>0) {
            deuda=clientes.get(i).getDineroDeduda();
        }
    }
    return deuda;
}
public boolean UnidadesSuficientes(String nombreProducto,int cantidadComprar){
    boolean alcanzan=false;
    for (int i = 0; i < productos.size(); i++) {
        if (nombreProducto.equalsIgnoreCase(productos.get(i).getNombreProducto())) {
            if (cantidadComprar<productos.get(i).getExistencias()) {
                alcanzan=true;
            }
        }
    }
    return alcanzan;
}
public String NuevoCliente(String nombre,String apellido,String id){
    //Se crea un nuevo cliente con su nombre apellido e id
    clientes.add(new Clientes(nombre, apellido, id));
    return "cliente agregado exitosamente";   
    }
public String MostrarClientes(){
    /*Muestra todos los clientes existentes,
     sirve principalmente para identificar deudores
     * 
     */
    String listaClientes="";
    /*Muestra la lista de clientes en orden de ingreso al sistema */
    for (int i = 0; i < clientes.size(); i++) {
        listaClientes+=clientes.get(i).getNombre()+" "+clientes.get(i).getApellido()+"               "+clientes.get(i).getId()+"           "+(clientes.get(i).getDineroDeduda()>0?"EL CLIENTE ES DEUDOR, y su deuda es de"+clientes.get(i).getDineroDeduda():"EL CLIENTE NO ES DEUDOR")+"\n";
    }
    return "Nombre:          id               ¿es deudor? "+"\n"+listaClientes;
}
public String NuevoProducto(String nombreProducto, double precio, byte tipoProducto, int existencias){
    /*Se ingresa un nuevo produco al inventario
     * se usa su nombre, precio, 
     * el tipo de producto que son 5 tipos y que sirve para clacificarlo en el inventario
     * y las existencias que permitiran definir si el articulo esta disponible
     * y advertir al usuario si hay bajas unidades
     */
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
public String AgregarExistencias(String nombreProducto, int nuevasExistencias){
    for (int i = 0; i < productos.size(); i++) {
            int unidadesExistentes = productos.get(i).getExistencias();
            unidadesExistentes+=nuevasExistencias;
            productos.get(i).setExistencias(unidadesExistentes);
        }
    return "Unidades modificadas correctamente";
}
public double CalcularCosto(String nombreProducto, int cantidadComprar){
    double costoParcial=0;
    for (int i = 0; i < productos.size(); i++) {
        if (nombreProducto.equalsIgnoreCase(productos.get(i).getNombreProducto())) {
            costoParcial+=productos.get(i).getPrecio()*cantidadComprar;
        }else{
            costoParcial+=0;
        }
    }
    return costoParcial;
}
public String ModificarDeuda(String id,double deuda){
    double deudaTotal=0;
    for (int i = 0; i < clientes.size(); i++) {
        if (id.equalsIgnoreCase(clientes.get(i).getId())) {
            deudaTotal=clientes.get(i).getDineroDeduda()+deuda;
            clientes.get(i).setDineroDeduda(deudaTotal);
        }
    }
    return "Deuda modificada correctamente,ahora es de: "+deudaTotal;
}
public String ComprobarUnidades(){
    String pocasUnidades="";
    for (int i = 0; i < productos.size(); i++) {
        if (productos.get(i).getTipoProducto()==1) {
            if (productos.get(i).getExistencias()<=5) {
                pocasUnidades+=""+productos.get(i).getNombreProducto()+ " tiene solo "+productos.get(i).getExistencias()+"\n";
            }
        }else if (productos.get(i).getTipoProducto()==2) {
            if (productos.get(i).getExistencias()<=5) {
                pocasUnidades+=""+productos.get(i).getNombreProducto()+ " tiene solo "+productos.get(i).getExistencias()+"\n";
            }
        }else if (productos.get(i).getTipoProducto()==3) {
            if (productos.get(i).getExistencias()<=2) {
                pocasUnidades+=""+productos.get(i).getNombreProducto()+ " tiene solo "+productos.get(i).getExistencias()+"\n";
            }
        }else if (productos.get(i).getTipoProducto()==4) {
            if (productos.get(i).getExistencias()<=1) {
                pocasUnidades+=""+productos.get(i).getNombreProducto()+ " tiene solo "+productos.get(i).getExistencias()+"\n";
            }
        }else{
            if (productos.get(i).getExistencias()<=10) {
                pocasUnidades+=""+productos.get(i).getNombreProducto()+ " tiene solo "+productos.get(i).getExistencias()+"\n";
            }
        }
    }
    return "ATENCIÓN"+"\n"+"Los siguientes productos tienen pocas unidades"+"\n"+pocasUnidades;
}
public boolean MensajeUnidades(){
    boolean problemasSolucionar=false;
    for (int i = 0; i < productos.size(); i++) {
        if (productos.get(i).getTipoProducto()==1) {
            if (productos.get(i).getExistencias()<=5) {
                 problemasSolucionar=true;
            }
        }else if (productos.get(i).getTipoProducto()==2) {
            if (productos.get(i).getExistencias()<=5) {
                problemasSolucionar=true;
            }
        }else if (productos.get(i).getTipoProducto()==3) {
            if (productos.get(i).getExistencias()<=2) {
                problemasSolucionar=true;
            }
        }else if (productos.get(i).getTipoProducto()==4) {
            if (productos.get(i).getExistencias()<=1) {
                problemasSolucionar=true;
            }
        }else{
            if (productos.get(i).getExistencias()<=10) {
                problemasSolucionar=true;
            }
        }
    }
    return problemasSolucionar;
}
}
