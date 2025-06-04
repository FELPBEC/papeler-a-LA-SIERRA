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
                                "5. Dulces"));//Se solicita al usuario un número de 1 a 5 para identificar que inventario desea ver
                JOptionPane.showMessageDialog(null, LaSierra.Inventario(seleccionInventario));//Se muestra el inventario seleccionado
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
                            JOptionPane.showMessageDialog(null, LaSierra.ComprobarUnidades());/*Alerta que solo aparecera
                            si es necesario solucionar un problema de inventario */
                        }
                    String id = JOptionPane.showInputDialog("Ingrese la id del nuevo cliente");
                    /*Se solicita la ID del nuevo cliente */
                    if (LaSierra.EncontrarCliente(id)) {
                        /*Se comprueba por medio de esta que no haya otra igual 
                         * y que por lo tanto el usuario no exista
                         */
                        JOptionPane.showMessageDialog(null, "El usuario YA existe");
                    }else{
                        /*Si no esta registrado se proceden a preguntar los demas datos registrando al nuevo usuario */
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del nuevo cliente");
                    String apellido = JOptionPane.showInputDialog("Ingrese el apellido del nuevo cliente");
                    JOptionPane.showMessageDialog(null,LaSierra.NuevoCliente(nombre,apellido,id));
                    }
                        break;

                    case 2:
                    if (LaSierra.MensajeUnidades()) {
                            JOptionPane.showMessageDialog(null, LaSierra.ComprobarUnidades());//Alerta molesta
                        }
                    /*Muestra la lista de todos los clientes registrados con su nombre, apellido id y muestra si son deudores o no */
                    JOptionPane.showMessageDialog(null, LaSierra.MostrarClientes());
                    break;
                    default:
                        break;
                }
                break;









                case 3:/*OPCIÓN 3: Sistema de ventas */
                opcion=Byte.parseByte(JOptionPane.showInputDialog("BIENVENIDO AL SISTEMA DE VENTAS"+"\n"+"ingrese el NUMERO correspondiente a su acción"+"\n"+"1.Hacer nueva venta"+"\n"+"2.Saldar una deuda"));
                switch (opcion) {

                    case 1:
                    if (LaSierra.MensajeUnidades()) {
                            JOptionPane.showMessageDialog(null, LaSierra.ComprobarUnidades());//Alerta molesta
                        }
                    int cantidadComprar=0; //Variable que almacena cuantas unidades se quieren comprar
                    String nombreProducto=""; //Variable que almacena el nombre del producto que se quiere comprar
                    double costoInicial=0; //Variable que indica el costo de la venta en general (No se porque lo llame costoInicial)
                        String id = JOptionPane.showInputDialog("Ingrese la id del cliente");
                        /*Se ingresa la id del cliente con la que 
                         * 1)se comprueba si esta registrado 
                         * 2)Se comprueba si es o no deudor, enviando un mensaje de alertaa en caso de serlo
                          */
                        if (LaSierra.EncontrarCliente(id)) {
                            if(LaSierra.DeterminarDeudor(id)){
                                JOptionPane.showMessageDialog(null, "ATENCIÓN"+"\n"+"El usuaro tiene un deuda de: "+LaSierra.DeterminarDeduda(id));
                            }
                                /*Se solicita el nombre del producto para confirmar su registro en el inventario */
                                 nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto a comprar");
                            if (LaSierra.EncontrarProducto(nombreProducto)) {
                                /*Si se encontro el producto en el inventario
                                se solicitan las unidades que se van a comprar
                                y se comprueba que sean menores a las existencias disponiibles del producto */
                                cantidadComprar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de unidades a comprar"));
                                if (LaSierra.UnidadesSuficientes(nombreProducto, cantidadComprar)==false) {
                                    /*En caso de no ser así se envia un mensaje que indicara el problema */
                                    JOptionPane.showMessageDialog(null, "NO hay UNIDADES SUFICIENTES");
                                    cantidadComprar=0;
                                    //Se reinicia la cantidad a comprar para que si sigue la compra no se resten esas unidades
                                }else{
                                    /*De otro modo se calcula el costo de la venta de ese producto
                                     * y se suma al costoInicial 
                                     */
                                    costoInicial+=LaSierra.CalcularCosto(nombreProducto, cantidadComprar);
                                }
                                
                            }else{
                                JOptionPane.showMessageDialog(null,"No se encontro el producto en el inventario");
                            }
                            /*En caso contrario se muestra un mensaje con el costo total de la compra */
                        JOptionPane.showMessageDialog(null,"El costo de su compra es: " + costoInicial);
                        /*Se solicita al usuario el presupuesto del cliente */
                        double presupuestoUsuario= Double.parseDouble(JOptionPane.showInputDialog("Ingrese el presupuesto del usuario(Con cuanto le paga)"));
                            /* Se comprueba si le alcanza o no */
                        if (presupuestoUsuario<costoInicial) {
                            /*En caso de que no se envia un mensaje de advertencia */
                            JOptionPane.showMessageDialog(null,"No le alcanza"+"\n"+"Si confirma la compra a continuación se le añadira a su deuda");
                        }
                        /*luego se envia un mensaje de confirmación  */
                        opcion=Byte.parseByte(JOptionPane.showInputDialog("¿Confirma la compra?"+"\n"+"ingrese el NUMERO correspondiente a su acción"+"\n"+"1.Si"+"\n"+"2.No"));
                            if (opcion==1) {
                                /*En caso de que se confirme la compra
                                 * se modificaran las unidades respectivamente
                                 */
                            JOptionPane.showMessageDialog(null,LaSierra.AgregarExistencias(nombreProducto, cantidadComprar*-1));
                               if (presupuestoUsuario<costoInicial) {
                                /*En caso de que se haya confirmado y el presupuesto no alcance
                                 * Se le sumara a la deuda del usuario
                                 y se mostrara en pantalla
                                 ademas se sumara lo que pago el usuario a los ingresos de Papelería*/
                            double deuda = costoInicial-presupuestoUsuario;
                            ingresosPapelería+=presupuestoUsuario;
                            JOptionPane.showMessageDialog(null, LaSierra.ModificarDeuda(id,deuda));
                                }else{
                            ingresosPapelería+=costoInicial;
                            /*En caso de si alcanzarle se le mostraran las vueltas */
                            JOptionPane.showMessageDialog(null, "Sus vueltas son: "+(presupuestoUsuario-costoInicial));
                                } 
                            }
                            JOptionPane.showMessageDialog(null, "Tenga un lindo día, a la ORDEN");
                        }else{
                            JOptionPane.showMessageDialog(null, "No se encontro a un cliente con es ID, vuelva al menú y agreguelo");
                        }
                        if (LaSierra.MensajeUnidades()) {
                            JOptionPane.showMessageDialog(null, LaSierra.ComprobarUnidades());//Alerta molesta
                        }
                        break;

                    case 2://Saldar una deuda
                    if (LaSierra.MensajeUnidades()) {
                            JOptionPane.showMessageDialog(null, LaSierra.ComprobarUnidades());//Alerta molesta
                        }
                    id=JOptionPane.showInputDialog("Ingrese la id del usuario");
                    //Se solicita la ID del usuario para determinar si esta registrado y si es deudor
                    if (LaSierra.EncontrarCliente(id)) {
                        if (LaSierra.DeterminarDeudor(id)) {
                            /*En caso de cumplir las condiciones se le mostrara al usuario la cantidad almacenada en la deuda
                             * luego se pedira el abono a la deuda
                             * este abono se restara al valor de la deuda
                             * finalmente se muestra el nuevo valor de la deuda
                             */
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
                    case 1://Hacer una nueva recarga
                    if (LaSierra.MensajeUnidades()) {
                            JOptionPane.showMessageDialog(null, LaSierra.ComprobarUnidades());
                        }
                        opcion=Byte.parseByte(JOptionPane.showInputDialog(null, "ATENCIÓN"+"\n"+"Su saldo es de"+saldoRecargas+"\n"+"¿Seguro desea continuar?"+"\n"+"1.Si"+"\n"+"2.No"));
                        //Se muestra el saldo para las recargas
                        if (opcion==1) {
                            //Se solicita el costo de la recarga
                            double costoRecarga=Double.parseDouble(JOptionPane.showInputDialog("Ingrese a continuación la cantidad a recargar"));
                            if (saldoRecargas>=costoRecarga) {
                                //Si el costo de la recarga s mayor o igual al saldo se resta con normalidad
                                saldoRecargas-=costoRecarga;
                                ingresosRecargas+=costoRecarga;
                                //Se muestra un mensaje con el saldo restante
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
                        //Se solicita un monto de dinero para agregarlo al saldo
                        saldoRecargas+=recargaSaldo;
                        //Se muestra un mensaje con el nuevo saldo
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
                        //Se muestran los ingresos de papelería, recargas con sus respectivos beneficios 
                    JOptionPane.showMessageDialog(null,"BIENVENIDO A VISUALIZAR GANANCIAS"+"\n"+"Los ingresos de papelería son: "+ingresosPapelería+"\n"+"Sus beneficios son: "+ (ingresosPapelería*0.3)+"\n"+"Los ingresos por recargas son: "+ingresosRecargas+"\n"+"Sus beneficios son: "+ (ingresosRecargas*0.06)+"\n"+"Sus ingresos totales son: "+(ingresosPapelería+ingresosRecargas)+"\n"+"Sus beneficios son"+((ingresosPapelería*0.3)+(ingresosRecargas*0.06)));
                break;
                
                default:
                    break;
            }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"ERROR 220"+"\n"+ "por favor ingrese un valor valido");
            }
        } while (opcion !=6);
        //Se cierra la papelería mostrando los datos anteriormente mencionados
        JOptionPane.showMessageDialog(null,"CERRANDO PAPELERÍA"+"\n"+"Los ingresos de papelería fueron: "+ingresosPapelería+"\n"+"Sus beneficios fueron: "+ (ingresosPapelería*0.3)+"\n"+"Los ingresos por recargas fueron: "+ingresosRecargas+"\n"+"Sus beneficios fueron: "+ (ingresosRecargas*0.06)+"\n"+"Sus ingresos totales fueron: "+(ingresosPapelería+ingresosRecargas)+"\n"+"Sus beneficios fueron"+((ingresosPapelería*0.3)+(ingresosRecargas*0.06)));
        JOptionPane.showMessageDialog(null,"ADIOOOOOS");
    }
    }

