package BLL;

public class Habitacion {
    private int numero;
    private String tipo;
    private boolean disponible;

    public Habitacion(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
        this.disponible = true;
    }

    public Habitacion(int numero, String tipo, boolean disponible) {
		super();
		this.numero = numero;
		this.tipo = tipo;
		this.disponible = disponible;
	}

	public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void asignar() {
        this.disponible = false;
    }

    public void liberar() {
        this.disponible = true;
    }
}
