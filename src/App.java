import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        Papeleria LaSierra = new Papeleria();/*Declaración del objeto de tipo papelería 
        que necesitamos para relizar nuestros metodos  */
        byte opcion = 0; /*Variable opción para que el usuario por medio de numeros determine que quiere hacer */
        byte tipoProducto =0; /*Variable para determinar el tipo del producto limitado a 5 tipos */
        byte seleccionInventario = 0; /*Variable para determinar el tipo de inventario según los tipos de productos */
        double ingresosPapelería=0;/*Variable que almacena todos los ingresos de ganancias de articulos de papelería */
        double saldoRecargas=0;/*Variable que almacena el saldo de las ganancias*/
        double ingresosRecargas=0; /*Variable que almacena el ingreso total de las recargas */
        
        do {
            try {
                /*Añadimos un try catch en todo nuestro programa 
                 * con tal de evitar que alguna excepción lo haga reiniciarse
                 */
            opcion=Byte.parseByte(JOptionPane.showInputDialog("Ingrese el NUMERO correspondiente a la opción"+"\n"+"1.Gestion de inventario"+"\n"+"2.Gestion de clientes"+"\n"+"3.Realizar una venta"+"\n"+"4.Sistema de recargas"+"\n"+"5.Visualizar las ganancias de lo que lleva del día"+"\n"+"6.Cerrar la papelería"));
            switch (opcion) {
                case 1://Elección de los 5 distintos menus de acciones
                    opcion=Byte.parseByte(JOptionPane.showInputDialog("BIENVENIDO A GESTION DE INVENTARIO"+"\n"+"ingrese el NUMERO correspondiente a su acción"+"\n"+"1.Agregar nuevo producto"+"\n"+"2.Agregar unidades a un producto existente"+"\n"+"3.Visualizar el inventario"));
                    switch (opcion) {
                        case 1://Creación de un nuevo objeto de la clase Productos
                        if (LaSierra.MensajeUnidades()) {
                            JOptionPane.showMessageDialog(null, LaSierra.ComprobarUnidades());
                        }
                        //Esta alerta comprueba que no haya ningun obejto con bajas unidades (Existencias es un atributo) SIEMPRE APARECERA
                                String nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del nuevo producto");
                                if (LaSierra.EncontrarProducto(nombreProducto)) {
                                    //Atraves del nombre(Nombre es un atributo), se comprueba que el nuevo objeto no haya sido creado antes 
                                    JOptionPane.showMessageDialog(null, "El producto YA EXISTE");
                                }else{
                                         double precioProducto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto"));
                                         //Se solicita el precio del producto (Otro atributo del objeto)
                                do {
                                    tipoProducto = Byte.parseByte(JOptionPane.showInputDialog("Ingrese un NUMERO para indicar el tipo de producto" + "\n"+
                                    "1. Papeles"+ "\n"+
                                    "2. Utiles escolares"+ "\n"+
                                    "3. Adhesivos"+ "\n"+
                                    "4. Cosmeticos"+ "\n"+
                                    "5. Dulces"));
                                    /*Se solicita el tipo del objeto (Otro atributo)
                                     * Si el usuario inserta un numero superior al 5 le volvera a pedir este dato
                                     */
                                 } while(tipoProducto>5);
                                 int existencias = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las unidades del nuevo producto"));
                                 //Se ingresan las existencias del producto (Otro atributo)
                                JOptionPane.showMessageDialog(null, LaSierra.NuevoProducto(nombreProducto, precioProducto, tipoProducto, existencias));
                                //Se crea finalmente el nuevo producto que se almacena en un ArrayList
                                }
                               
                            break;


                        case 2:
                        if (LaSierra.MensajeUnidades()) {
                            JOptionPane.showMessageDialog(null, LaSierra.ComprobarUnidades());
                        }//misma alerta mencionada anteriormente
                                nombreProducto=JOptionPane.showInputDialog("Ingrese el nombre del producto al que le sumara unidades");
                                if (LaSierra.EncontrarProducto(nombreProducto)) {
                                    //Se comprueba si el producto ya existe, pues no puedes agregarle unidades a algo que no existe
                                    int nuevasExistencias=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de unidades que desea agregar"));
                                    JOptionPane.showMessageDialog(null, LaSierra.AgregarExistencias(nombreProducto, nuevasExistencias));
                                    /*Se inserta el número de unidades que se van a almacenar y se agregan al producto */
                                }else{
                                    JOptionPane.showMessageDialog(null, "El producto NO EXISTE o lo escribio mal");
                                }
                        break;



                        case 3:
                        if (LaSierra.MensajeUnidades()) {
                            JOptionPane.showMessageDialog(null, LaSierra.ComprobarUnidades());
                        }
                            do {
                                seleccionInventario = Byte.parseByte(JOptionPane.showInputDialog("Ingrese un NUMERO para indicar el tipo de inventario que desea visualizar" + "\n"+
                                "1. Papeles"+"\n"+
                                "2. Utiles escolares"+"\n"+
                                "3. Adhesivos"+"\n"+
                                "4. Cosmeticos"+"\n"+
                                "5. Dulces"));
                JOptionPane.showMessageDialog(null, LaSierra.Inventario(seleccionInventario));
                opcion=0;
                } while (seleccionInventario>5);
                        break;
                    
                        default:
                        JOptionPane.showMessageDialog(null, "INGRESE UN VALOR VALIDO PORFAVOR");
                            break;
                    }
                    
                    break;








                case 2:
                opcion=Byte.parseByte(JOptionPane.showInputDialog("BIENVENIDO A GESTION DE CLIENTES"+"\n"+"ingrese el NUMERO correspondiente a su acción"+"\n"+"1.Agregar nuevo cliente"+"\n"+"2.Visualizar la lista de clientes"));
                switch (opcion) {
                    case 1:
                    if (LaSierra.MensajeUnidades()) {
                            JOptionPane.showMessageDialog(null, LaSierra.ComprobarUnidades());
                        }
                    String id = JOptionPane.showInputDialog("Ingrese la id del nuevo cliente");
                    if (LaSierra.EncontrarCliente(id)) {
                        JOptionPane.showMessageDialog(null, "El usuario YA existe");
                    }else{
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del nuevo cliente");
                    String apellido = JOptionPane.showInputDialog("Ingrese el apellido del nuevo cliente");
                    JOptionPane.showMessageDialog(null,LaSierra.NuevoCliente(nombre,apellido,id));
                    }
                        break;

                    case 2:
                    if (LaSierra.MensajeUnidades()) {
                            JOptionPane.showMessageDialog(null, LaSierra.ComprobarUnidades());
                        }
                    JOptionPane.showMessageDialog(null, LaSierra.MostrarClientes());
                    break;
                    default:
                        break;
                }
                break;









                case 3:
                opcion=Byte.parseByte(JOptionPane.showInputDialog("BIENVENIDO AL SISTEMA DE VENTAS"+"\n"+"ingrese el NUMERO correspondiente a su acción"+"\n"+"1.Hacer nueva venta"+"\n"+"2.Saldar una deuda"));
                switch (opcion) {

                    case 1:
                    if (LaSierra.MensajeUnidades()) {
                            JOptionPane.showMessageDialog(null, LaSierra.ComprobarUnidades());
                        }
                    int cantidadComprar=0;
                    String nombreProducto="";
                    double costoInicial=0;
                        String id = JOptionPane.showInputDialog("Ingrese la id del cliente");
                        if (LaSierra.EncontrarCliente(id)) {
                            if(LaSierra.DeterminarDeudor(id)){
                                JOptionPane.showMessageDialog(null, "ATENCIÓN"+"\n"+"El usuaro tiene un deuda de: "+LaSierra.DeterminarDeduda(id));
                            }
                            do {
                                 nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto a comprar");
                            if (LaSierra.EncontrarProducto(nombreProducto)) {
                                cantidadComprar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de unidades a comprar"));
                                if (LaSierra.UnidadesSuficientes(nombreProducto, cantidadComprar)==false) {
                                    JOptionPane.showMessageDialog(null, "NO hay UNIDADES SUFICIENTES");
                                    cantidadComprar=0;
                                }else{
                                    costoInicial+=LaSierra.CalcularCosto(nombreProducto, cantidadComprar);
                                }
                                
                            }else{
                                JOptionPane.showMessageDialog(null,"No se encontro el producto en el inventario");
                            }
                            opcion=Byte.parseByte(JOptionPane.showInputDialog("¿Desea seguir añadiendo articulos a la compra?"+"\n"+"ingrese el NUMERO correspondiente a su acción"+"\n"+"1.Si"+"\n"+"2.No"));
                            } while (opcion!=2);
                        JOptionPane.showMessageDialog(null,"El costo de su compra es: " + costoInicial);
                        double presupuestoUsuario= Double.parseDouble(JOptionPane.showInputDialog("Ingrese el presupuesto del usuario(Con cuanto le paga)"));
                        if (presupuestoUsuario<costoInicial) {
                            JOptionPane.showMessageDialog(null,"No le alcanza"+"\n"+"Si confirma la compra a continuación se le añadira a su deuda");
                        }
                        opcion=Byte.parseByte(JOptionPane.showInputDialog("¿Confirma la compra?"+"\n"+"ingrese el NUMERO correspondiente a su acción"+"\n"+"1.Si"+"\n"+"2.No"));
                            if (opcion==1) {
                            JOptionPane.showMessageDialog(null,LaSierra.AgregarExistencias(nombreProducto, cantidadComprar*-1));
                               if (presupuestoUsuario<costoInicial) {
                            double deuda = costoInicial-presupuestoUsuario;
                            ingresosPapelería+=presupuestoUsuario;
                            JOptionPane.showMessageDialog(null, LaSierra.ModificarDeuda(id,deuda));
                                }else{
                            ingresosPapelería+=costoInicial;
                            JOptionPane.showMessageDialog(null, "Sus vueltas son: "+(presupuestoUsuario-costoInicial));
                                } 
                            }
                            JOptionPane.showMessageDialog(null, "Tenga un lindo día, a la ORDEN");
                        }else{
                            JOptionPane.showMessageDialog(null, "No se encontro a un cliente con es ID, vuelva al menú y agreguelo");
                        }
                        if (LaSierra.MensajeUnidades()) {
                            JOptionPane.showMessageDialog(null, LaSierra.ComprobarUnidades());
                        }
                        break;

                    case 2:
                    if (LaSierra.MensajeUnidades()) {
                            JOptionPane.showMessageDialog(null, LaSierra.ComprobarUnidades());
                        }
                    id=JOptionPane.showInputDialog("Ingrese la id del usuario");
                    if (LaSierra.EncontrarCliente(id)) {
                        if (LaSierra.DeterminarDeudor(id)) {
                            JOptionPane.showMessageDialog(null, "La deuda de este cliente es de: "+LaSierra.DeterminarDeduda(id));
                            double saldarDeuda=Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad que quiere abonar paraa saldar la deuda"));
                            JOptionPane.showMessageDialog(null, LaSierra.ModificarDeuda(id, saldarDeuda*-1));
                            ingresosPapelería+=saldarDeuda;
                        }else{
                            JOptionPane.showMessageDialog(null, "El usuario no presenta deuda");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "NO EXISTE EL CLIENTE, añadalo al vovler al menú");
                    }

                    break;
                    default:
                        break;
                }
                break;







                case 4:
                if (LaSierra.MensajeUnidades()) {
                            JOptionPane.showMessageDialog(null, LaSierra.ComprobarUnidades());
                        }
                    opcion=Byte.parseByte(JOptionPane.showInputDialog("BIENVENIDO AL SISTEMA DE RECARGAS"+"\n"+"ingrese el NUMERO correspondiente a su acción"+"\n"+"1.Hacer nueva venta"+"\n"+"2.Añadir saldo"));
                    switch (opcion) {
                    case 1:
                    if (LaSierra.MensajeUnidades()) {
                            JOptionPane.showMessageDialog(null, LaSierra.ComprobarUnidades());
                        }
                        opcion=Byte.parseByte(JOptionPane.showInputDialog(null, "ATENCIÓN"+"\n"+"Su saldo es de"+saldoRecargas+"\n"+"¿Seguro desea continuar?"+"1.Si"+"2.No"));
                        if (opcion==1) {
                            double costoRecarga=Double.parseDouble(JOptionPane.showInputDialog("Ingrese a continuación la cantidad a recargar"));
                            if (saldoRecargas>=costoRecarga) {
                                saldoRecargas-=costoRecarga;
                                ingresosRecargas+=costoRecarga;
                                JOptionPane.showMessageDialog(null, "RECARGA REALIZADA CORRECTAMENTE"+"\n"+"El saldo restante es"+saldoRecargas);
                            }else{
                                JOptionPane.showMessageDialog(null,"Ocurrio un error, el saldo no es suficiente");
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Regresando al menú");
                        }
                        break;

                    case 2:
                        double recargaSaldo= Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto que desea depositar al saldo de las recargas"));
                        saldoRecargas+=recargaSaldo;
                        JOptionPane.showMessageDialog(null, "Saldo añadido correctamente"+"\n"+"Su saldo actual es de: "+saldoRecargas);
                    break;
                        
                    default:
                        break;
                }
                break;
                case 5:
                if (LaSierra.MensajeUnidades()) {
                            JOptionPane.showMessageDialog(null, LaSierra.ComprobarUnidades());
                        }
                    JOptionPane.showMessageDialog(null,"BIENVENIDO A VISUALIZAR GANANCIAS"+"\n"+"Los ingresos de papelería son: "+ingresosPapelería+"\n"+"Sus beneficios son: "+ (ingresosPapelería*0.3)+"\n"+"Los ingresos por recargas son: "+ingresosRecargas+"\n"+"Sus beneficios son: "+ (ingresosRecargas*0.06)+"\n"+"Sus ingresos totales son: "+(ingresosPapelería+ingresosRecargas)+"\n"+"Sus beneficios son"+((ingresosPapelería*0.3)+(ingresosRecargas*0.06)));
                break;
                
                default:
                    break;
            }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"ERROR 220"+"\n"+ "por favor ingrese un valor valido");
            }
        } while (opcion !=6);
        JOptionPane.showMessageDialog(null,"CERRANDO PAPELERÍA"+"\n"+"Los ingresos de papelería fueron: "+ingresosPapelería+"\n"+"Sus beneficios fueron: "+ (ingresosPapelería*0.3)+"\n"+"Los ingresos por recargas fueron: "+ingresosRecargas+"\n"+"Sus beneficios fueron: "+ (ingresosRecargas*0.06)+"\n"+"Sus ingresos totales fueron: "+(ingresosPapelería+ingresosRecargas)+"\n"+"Sus beneficios fueron"+((ingresosPapelería*0.3)+(ingresosRecargas*0.06)));
        JOptionPane.showMessageDialog(null,"ADIOOOOOS");
    }
    }

