package interfaz;

import java.util.LinkedList;

public class Usuario {
	private String mail;
	private String contrasena;
	
	
	public Usuario(String mail, String contrasena) {
		super();
		this.mail = mail;
		this.contrasena = contrasena;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	@Override
	public String toString() {
		return "Usuario [mail=" + mail + ", contrasena=" + contrasena + "]";
	}
	public static Usuario Login(LinkedList<Usuario> usuarios, String mail, String contrasena ) {
	
		for (Usuario usuario : usuarios) {
			if (usuario.getMail().equals(mail) && usuario.getContrasena().equals(contrasena)) {
				return usuario;
			}
		}
		return null;
	}
	public void menu() {
		
	}
	
	
}
