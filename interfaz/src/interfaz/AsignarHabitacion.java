package interfaz;

import javax.swing.JOptionPane;

import BLL.Habitacion;
import BLL.Huesped;
import BLL.HuespedOlimpico;

import java.util.LinkedList;

public class AsignarHabitacion {
    private static LinkedList<Habitacion> habitaciones = new LinkedList<>();

    static {
        for (int i = 1; i <= 20; i++) {
            habitaciones.add(new Habitacion(i, "Cuádruple"));
        }
        for (int i = 21; i <= 30; i++) {
            habitaciones.add(new Habitacion(i, "Doble"));
        }
        for (int i = 31; i <= 40; i++) {
            habitaciones.add(new Habitacion(i, "Individual"));
        }
    }

    public static void asignarHabitacion(LinkedList<Huesped> huespedes) {
        if (huespedes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay huéspedes registrados.");
            return;
        }

        StringBuilder listaHuespedes = new StringBuilder();
        for (int i = 0; i < huespedes.size(); i++) {
            listaHuespedes.append(i).append(". ").append(huespedes.get(i).getInfo()).append("\n");
        }

        String indiceStr = JOptionPane.showInputDialog("Seleccione el número del huésped para asignar habitación:\n" + listaHuespedes);
        int indiceHuesped;
        try {
            indiceHuesped = Integer.parseInt(indiceStr);
            if (indiceHuesped < 0 || indiceHuesped >= huespedes.size()) {
                JOptionPane.showMessageDialog(null, "Índice de huésped inválido.");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida.");
            return;
        }

        Huesped huespedSeleccionado = huespedes.get(indiceHuesped);

        String tipoHabitacion = "";
        if (huespedSeleccionado instanceof HuespedOlimpico) {
            String[] tiposHabitacion = {"Cuádruple", "Doble", "Individual"};
            int tipoSeleccionado = JOptionPane.showOptionDialog(null,
                    "Seleccione el tipo de habitación:",
                    "Asignación de Habitaciones",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    tiposHabitacion,
                    tiposHabitacion[0]);
            if (tipoSeleccionado < 0) {
                return;
            }
            tipoHabitacion = tiposHabitacion[tipoSeleccionado];
        } else if (huespedSeleccionado instanceof Huesped) {
            tipoHabitacion = "Individual";
        }

        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getTipo().equals(tipoHabitacion) && habitacion.isDisponible()) {
                habitacion.asignar();
                JOptionPane.showMessageDialog(null, "Habitación " + habitacion.getNumero() + " asignada al huésped.");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "No hay habitaciones disponibles de este tipo.");
    }
}
