package BLL;

public class HuespedOlimpico extends Huesped {
    private String rol; 
    private String pais;

    public HuespedOlimpico(String nombre, String apellido, String telefono, String rol, String pais) {
        super(nombre, apellido, telefono);
        this.rol = rol;
        this.pais = pais;
    }

    public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
    public String getInfo() {
        return super.getInfo() + ", Rol: " + rol + ", País: " + pais;
    }
    public Huesped getHuespedOlimpico() {
    	return getHuespedOlimpico();
    }

}