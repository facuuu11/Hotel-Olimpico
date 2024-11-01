package GUI;

import java.util.LinkedList;
import javax.swing.JOptionPane;

import BLL.Huesped;
import BLL.Usuario;
import DLL.ControllerHuesped;
import DLL.ControllerUsuario;
import DLL.conexion;
import interfaz.AsignarHabitacion;
import interfaz.RegistroEntradaSalida;
import interfaz.RegistroHuespedes;
import interfaz.ValidadorEmail;

public class Main {

    public static void main(String[] args) {
    	
    	conexion.getInstance();
    	
    	ControllerUsuario.agregarUsuario(new Usuario("enzocavs@gmail.com","c123"));
    	
    	
    	
        LinkedList<Huesped> huespedes =ControllerHuesped.MostraHuesped();

        
        ValidadorEmail validadorEmail = new ValidadorEmail();

        String mail = JOptionPane.showInputDialog("Ingrese mail");

        if (!validadorEmail.validar(mail)) {
            JOptionPane.showMessageDialog(null, "Error: El correo electrónico ingresado no es válido.");
            return;
        }

        String contrasena = JOptionPane.showInputDialog("Ingrese contraseña");

        Usuario usuarioLogueado = Usuario.Login( mail, contrasena);

        if (usuarioLogueado != null) {
            JOptionPane.showMessageDialog(null, "Bienvenido al sistema de DaVinci Hotel.");

            boolean salir = false;
            while (!salir) {
                String[] opciones = {"Registro Huespedes", "Observar Habitaciones", "Registro Entrada/Salida","Mostrar historial Entrada/Salida","Asignar Habitacion", "Salir"};
                int seleccion = JOptionPane.showOptionDialog(null,
                        "Seleccione una opción:",
                        "Menú",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        opciones,
                        opciones[0]);

                switch (seleccion) {
                    case 0:
                        RegistroHuespedes.registrarHuesped(huespedes);
                      
                        break;
                    case 1:
                     JOptionPane.showMessageDialog(null, "Código para observar habitaciones");
                        break;
                    case 2:
                        RegistroEntradaSalida.registrarEntradaSalida(huespedes);
                        break;
                    case 3:
                        RegistroEntradaSalida.mostrarHistorial();
                        break;
                    case 4:
                    	AsignarHabitacion.asignarHabitacion(huespedes);
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "Saliendo del sistema DV Hotel.");
                        salir = true;
                        break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error: Contraseña incorrecta.");
        }
    }
}