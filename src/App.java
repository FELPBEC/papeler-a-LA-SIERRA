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
                            break;
                        case 2:
                                nombreProducto=JOptionPane.showInputDialog("Ingrese el nombre del producto al que le sumara unidades");
                                int nuevasExistencias=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de unidades que desea agregar"));
                                JOptionPane.showMessageDialog(null, LaSierra.AgregarExistencias(nombreProducto, nuevasExistencias));
                        
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
                opcion=Byte.parseByte(JOptionPane.showInputDialog("BIENVENIDO A GESTION DE INVENTARIO"+"\n"+"ingrese el NUMERO correspondiente a su acción"+"\n"+"1.Agregar nuevo cliente"+"\n"+"2.Visualizar la lista de clientes"));
                switch (opcion) {
                    case 1:
                    String id = JOptionPane.showInputDialog("Ingrese la id del nuevo cliente");
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del nuevo cliente");
                    String apellido = JOptionPane.showInputDialog("Ingrese el apellido del nuevo cliente");
                    JOptionPane.showMessageDialog(null,LaSierra.NuevoCliente(nombre,apellido,id));
                        
                        break;
                    case 2:
                    JOptionPane.showMessageDialog(null, LaSierra.MostrarClientes());
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

