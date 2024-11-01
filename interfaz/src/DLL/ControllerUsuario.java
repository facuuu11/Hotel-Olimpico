package DLL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import BLL.Usuario;

public class ControllerUsuario {
	private static Connection con = conexion.getInstance().getConection();
	
	public static void agregarUsuario(Usuario usuario) {
		try {
			
			PreparedStatement statement = (PreparedStatement) 
			con.prepareStatement("INSERT INTO `usuarios`(`mail`, `contrasena`) VALUES (?,?)");
			statement.setString(1, usuario.getMail());
			statement.setString(2, usuario.getContrasena());
			int filas = statement.executeUpdate();
			if(filas>0) {
				JOptionPane.showMessageDialog(null, "Se agregó");
			}

			
		} catch (Exception e) {
System.out.println("No se agregó");		}
		
		
	}
	public static LinkedList<Usuario> MostraUsuario() {
		LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
		try {
			PreparedStatement statement = (PreparedStatement) con.prepareStatement("SELECT * FROM `usuarios`");
			ResultSet resultados = statement.executeQuery();
			while (resultados.next()) {
				usuarios.add(new Usuario(
						resultados.getString("mail"),
						resultados.getString("contrasena")
						
						));
				
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error");		
			}
		return usuarios;
	}

}
