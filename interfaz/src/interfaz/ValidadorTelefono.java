package interfaz;

public class ValidadorTelefono implements Validador {

    @Override
    public boolean validar(String entrada) {
        if (entrada.length() < 10 || entrada.length() > 12) {
            return false;
        }
        for (char c : entrada.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
