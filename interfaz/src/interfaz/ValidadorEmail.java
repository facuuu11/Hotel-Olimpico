package interfaz;

public class ValidadorEmail implements Validador {

    @Override
    public boolean validar(String entrada) {
        return entrada.contains("@") && entrada.contains(".");
    }
}
