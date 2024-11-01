package DLL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import BLL.Huesped;
import BLL.HuespedOlimpico;
import BLL.Usuario;

public class ControllerHuesped {
private static Connection con = conexion.getInstance().getConection();
	
	public static void agregarHuesped(Huesped HuespedComun) {
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("INSERT INTO `huespedes`(`nombre`, `apellido`, `telefono`, `tipo`, `rol`, `pais`) VALUES (?,?,?,?,?,?)");
			statement.setString(1, HuespedComun.getNombre());
			statement.setString(2, HuespedComun.getApellido());
			statement.setString(3, HuespedComun.getTelefono());
			statement.setString(4,"COMUN");
			statement.setString(5, "NO ASIGNADO");
			statement.setString(6, "NO ASIGNADO");
			int filas = statement.executeUpdate();
			if(filas>=0) {
				JOptionPane.showMessageDialog(null, "Se agregó");
			}

			
		} catch (Exception e) {
System.out.println("No se agregó");		}

}
	public static void agregarHuespedOlimpico(HuespedOlimpico huespedolimpico) {
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("INSERT INTO `huespedes`(`nombre`, `apellido`, `telefono`, `tipo`, `rol`, `pais`) VALUES (?,?,?'?,?,?')");
			statement.setString(1, huespedolimpico.getNombre());
			statement.setString(2, huespedolimpico.getApellido());
			statement.setString(3, huespedolimpico.getTelefono());
			statement.setString(4, "Olimpico");
			statement.setString(5, huespedolimpico.getRol());
			statement.setString(6, huespedolimpico.getPais());
			int filas = statement.executeUpdate();
			if(filas>0) {
				JOptionPane.showMessageDialog(null, "Se agregó");
			}

			
		} catch (Exception e) {
System.out.println("No se agregó");		}

}
public static LinkedList<Huesped> MostraHuesped() {
	LinkedList<Huesped> huesped = new LinkedList<Huesped>();
	try {
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("SELECT * FROM `huespedes`");
		ResultSet resultados = statement.executeQuery();
		while (resultados.next()) {
			huesped.add(new Huesped(
					resultados.getString("nombre"),
					resultados.getString("apellido"),
					resultados.getString("telefono")
					));
			
		}
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "Error");		
		}
	return huesped;
}
public static LinkedList<HuespedOlimpico> MostraHuespedOlimpico() {
	LinkedList<HuespedOlimpico> huespedolimpico = ControllerHuesped.MostraHuespedOlimpico();
	try {
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("SELECT * FROM `huespedes`");
		ResultSet resultados = statement.executeQuery();
		while (resultados.next()) {
			huespedolimpico.add(new HuespedOlimpico(
					resultados.getString("nombre"),
					resultados.getString("apellido"),
					resultados.getString("telefono"),
					resultados.getString("rol"),
					resultados.getString("pais")
					));
			
		}
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "Error");		
		}
	return huespedolimpico;
}
}