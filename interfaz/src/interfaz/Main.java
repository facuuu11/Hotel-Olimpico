package interfaz;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Validador validadorEmail = new ValidadorEmail();
        Validador validadorTelefono = new ValidadorTelefono();
        Validador validadorContrasena = new ValidadorContrasena();

        String email;
        boolean emailValido;
        do {
            email = JOptionPane.showInputDialog(null, "Ingrese su correo electrónico:");
            emailValido = validadorEmail.validar(email);
            if (!emailValido) {
                JOptionPane.showMessageDialog(null, "El correo electrónico no es válido. Intente de nuevo.");
            }
        } while (!emailValido);

        JOptionPane.showMessageDialog(null, "El correo electrónico es válido.");

        String telefono;
        boolean telefonoValido;
        do {
            telefono = JOptionPane.showInputDialog(null, "Ingrese su número de teléfono:");
            telefonoValido = validadorTelefono.validar(telefono);
            if (!telefonoValido) {
                JOptionPane.showMessageDialog(null, "El número de teléfono no es válido. Intente de nuevo.");
            }
        } while (!telefonoValido);

        JOptionPane.showMessageDialog(null, "El número de teléfono es válido.");

        String contrasena;
        boolean contrasenaValida;
        do {
            contrasena = JOptionPane.showInputDialog(null, "Ingrese su contraseña:");
            contrasenaValida = validadorContrasena.validar(contrasena);
            if (!contrasenaValida) {
                JOptionPane.showMessageDialog(null, "La contraseña no es válida. Intente de nuevo.");
            }
        } while (!contrasenaValida);

        JOptionPane.showMessageDialog(null, "La contraseña es válida.");
    }
}

