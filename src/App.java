import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        Papeleria LaSierra = new Papeleria();
        byte opcion = 0;
        byte tipoProducto =0;
        byte seleccionInventario = 0;
        
        do {
            try {
            opcion=Byte.parseByte(JOptionPane.showInputDialog("Ingrese el NUMERO correspondiente a la opción"+"\n"+"1.Gestion de inventario"+"\n"+"2.Gestion de clientes"+"\n"+"3.Realizar una venta"+"\n"+"4.Sistema de recargas"+"\n"+"5.Visualizar las ganancias de lo que lleva del día"+"\n"+"6.Cerrar la papelería"));
            switch (opcion) {
                case 1:
                    opcion=Byte.parseByte(JOptionPane.showInputDialog("BIENVENIDO A GESTION DE INVENTARIO"+"\n"+"ingrese el NUMERO correspondiente a su acción"+"\n"+"1.Agregar nuevo producto"+"\n"+"2.Agregar unidades a un producto existente"+"\n"+"3.Visualizar el inventario"));
                    switch (opcion) {
                        case 1:
                                String nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del nuevo producto");
                                if (LaSierra.EncontrarProducto(nombreProducto)) {
                                    JOptionPane.showMessageDialog(null, "El producto YA EXISTE");
                                }else{
                                         double precioProducto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto"));
                                do {
                                    tipoProducto = Byte.parseByte(JOptionPane.showInputDialog("Ingrese un NUMERO para indicar el tipo de producto" + "\n"+
                                    "1. Papeles"+ "\n"+
                                    "2. Utiles escolares"+ "\n"+
                                    "3. Adhesivos"+ "\n"+
                                    "4. Cosmeticos"+ "\n"+
                                    "5. Dulces"));
                                 } while(tipoProducto>5);
                                 int existencias = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las unidades del nuevo producto"));
                                JOptionPane.showMessageDialog(null, LaSierra.NuevoProducto(nombreProducto, precioProducto, tipoProducto, existencias));
                                }
                               
                            break;


                        case 2:
                                nombreProducto=JOptionPane.showInputDialog("Ingrese el nombre del producto al que le sumara unidades");
                                if (LaSierra.EncontrarProducto(nombreProducto)) {
                                    int nuevasExistencias=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de unidades que desea agregar"));
                                    JOptionPane.showMessageDialog(null, LaSierra.AgregarExistencias(nombreProducto, nuevasExistencias));
                                }else{
                                    JOptionPane.showMessageDialog(null, "El producto NO EXISTE o lo escribio mal");
                                }
                        break;



                        case 3:
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
                    int cantidadComprar=0;
                    String nombreProducto="";
                    double costoInicial=0;
                        String id = JOptionPane.showInputDialog("Ingrese la id del cliente");
                        if (LaSierra.EncontrarCliente(id)) {
                            do {
                                 nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto a comprar");
                            if (LaSierra.EncontrarProducto(nombreProducto)) {
                                cantidadComprar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de unidades a comprar"));
                                costoInicial+=LaSierra.CalcularCosto(nombreProducto, cantidadComprar);
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
                            JOptionPane.showMessageDialog(null, LaSierra.AñadirDeuda(id,deuda));
                                } 
                            }
                            JOptionPane.showMessageDialog(null, "Tenga un lindo día, a la ORDEN");
                        }else{
                            JOptionPane.showMessageDialog(null, "No se encontro a un cliente con es ID, vuelva al menú y agreguelo");
                        }
                        break;
                    case 2:

                    break;
                    default:
                        break;
                }
                break;
                default:
                    break;
            }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"ERROR 220"+"\n"+ "por favor ingrese un valor valido");
            }
        } while (opcion !=6);
    }
    }

