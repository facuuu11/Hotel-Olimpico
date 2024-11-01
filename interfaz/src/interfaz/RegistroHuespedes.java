package interfaz;

import javax.swing.JOptionPane;

import BLL.Huesped;
import BLL.HuespedOlimpico;

import java.util.LinkedList;

public class RegistroHuespedes {
    public static void registrarHuesped(LinkedList<Huesped> huespedes) {
        String[] tipos = {"Huesped Comun", "Huesped Olimpico"};
        int tipoSeleccionado = JOptionPane.showOptionDialog(null,
                "Seleccione el tipo de huésped:",
                "Registro de Huéspedes",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                tipos,
                tipos[0]);

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del huésped:");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del huésped:");
        String telefono = JOptionPane.showInputDialog("Ingrese el teléfono del huésped:");

        if (tipoSeleccionado == 0) {
            Huesped huespedComun = new Huesped(nombre, apellido, telefono);
            huespedes.add(huespedComun);
            JOptionPane.showMessageDialog(null, "Huésped común registrado exitosamente.");
        } else if (tipoSeleccionado == 1) {
            String[] roles = {"Atleta", "Staff"};
            int rolSeleccionado = JOptionPane.showOptionDialog(null,
                    "Seleccione el rol del huésped olímpico:",
                    "Registro de Huéspedes Olímpicos",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    roles,
                    roles[0]);

            String rol = roles[rolSeleccionado];
            String pais = JOptionPane.showInputDialog("Ingrese el país del huésped olímpico:");
            HuespedOlimpico huespedOlimpico = new HuespedOlimpico(nombre, apellido, telefono, rol, pais);
            huespedes.add(huespedOlimpico.getHuespedOlimpico());
            JOptionPane.showMessageDialog(null, "Huésped olímpico registrado exitosamente.");
        }
    }
}
