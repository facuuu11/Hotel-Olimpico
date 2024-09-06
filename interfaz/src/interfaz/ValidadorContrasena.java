package interfaz;

public class ValidadorContrasena implements Validador {

    @Override
    public boolean validar(String entrada) {
        if (entrada.length() < 8) {
            return false;
        }
        boolean tieneMayuscula = false;
        boolean tieneMinuscula = false;
        boolean tieneDigito = false;

        for (char c : entrada.toCharArray()) {
            if (Character.isUpperCase(c)) {
                tieneMayuscula = true;
            } else if (Character.isLowerCase(c)) {
                tieneMinuscula = true;
            } else if (Character.isDigit(c)) {
                tieneDigito = true;
            }
        }

        return tieneMayuscula && tieneMinuscula && tieneDigito;
    }
}
