package interfaz;

import javax.swing.JOptionPane;

import BLL.Huesped;

import java.util.LinkedList;

public class RegistroEntradaSalida {
    private static LinkedList<String> historial = new LinkedList<>();

    public static void registrarEntradaSalida(LinkedList<Huesped> huespedes) {
        if (huespedes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay huéspedes registrados.");
            return;
        }

        String[] opciones = {"Entrada", "Salida"};
        int seleccion = JOptionPane.showOptionDialog(null,
                "Seleccione la acción:",
                "Registro de Entrada/Salida",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]);

        if (seleccion < 0) return;

        StringBuilder listaHuespedes = new StringBuilder();
        for (int i = 0; i < huespedes.size(); i++) {
            listaHuespedes.append(i).append(". ").append(huespedes.get(i).getInfo()).append("\n");
        }

        String indiceStr = JOptionPane.showInputDialog("Seleccione el número del huésped:\n" + listaHuespedes);
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
        String accion = seleccion == 0 ? "Entrada" : "Salida";
        String registro = accion + " de " + huespedSeleccionado.getInfo();
        historial.add(registro);
        JOptionPane.showMessageDialog(null, "Registro de " + accion + " exitoso para " + huespedSeleccionado.getInfo());
    }

    public static void mostrarHistorial() {
        if (historial.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay registros de entrada/salida.");
            return;
        }

        StringBuilder historialStr = new StringBuilder();
        for (String registro : historial) {
            historialStr.append(registro).append("\n");
        }

        JOptionPane.showMessageDialog(null, "Historial de Entrada/Salida:\n" + historialStr);
    }
}
