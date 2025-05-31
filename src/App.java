import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        Papeleria LaSierra = new Papeleria();
        int opcion = 0;
        do {
            try {
            opcion=Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opción"+"\n"+"1.Agregar un nuevo producto"+"\n"+"2.Visualizar el inventario"));
            switch (opcion) {
                case 1:
                    String nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del nuevo producto");
                    double precioProducto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto"));
                    String tipoProducto = JOptionPane.showInputDialog("Ingrese el tipo de producto");
                    int existencias = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las unidades del nuevo producto"));
                    JOptionPane.showMessageDialog(null, LaSierra.NuevoProducto(nombreProducto, precioProducto, tipoProducto, existencias));
                    break;
                case 2:
                JOptionPane.showMessageDialog(null, LaSierra.Inventario());
                break;
                default:
                    break;
            }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"ERROR 220"+"\n"+ "por favor ingrese un valor valido");
            }
        } while (opcion !=3);
    }
    }

