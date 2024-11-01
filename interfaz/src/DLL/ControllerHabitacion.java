package DLL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import BLL.Habitacion;
import BLL.Usuario;

public class ControllerHabitacion {
private static Connection con = conexion.getInstance().getConection();
	
	public static void agregarHabitacion(Habitacion habitacion) {
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("INSERT INTO `habitaciones`(`numero`, `tipo`, `disponible`) VALUES ('?,?,?')");
			statement.setInt(1, habitacion.getNumero());
			statement.setString(2, habitacion.getTipo());
			statement.setBoolean(3, habitacion.isDisponible());
			int filas = statement.executeUpdate();
			if(filas>0) {
				JOptionPane.showMessageDialog(null, "Se agregó");
			}

			
		} catch (Exception e) {
System.out.println("No se agregó");		}

}
	public static LinkedList<Habitacion> MostraHabitacion() {
		LinkedList<Habitacion> habitacion = new LinkedList<Habitacion>();
		try {
			PreparedStatement statement = (PreparedStatement) con.prepareStatement("SELECT * FROM `habitaciones`");
			ResultSet resultados = statement.executeQuery();
			while (resultados.next()) {
				habitacion.add(new Habitacion(
						resultados.getInt("numero"),
						resultados.getString("tipo"),
						resultados.getBoolean("disponible")
						));
				
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error");		
			}
		return habitacion;
	}
}