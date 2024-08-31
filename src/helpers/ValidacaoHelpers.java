package helpers;

public final class ValidacaoHelpers {
    public static Boolean validarDouble(Double input) {
        if (input < 1) {
            return false;
        }

        return true;
    }

    public static Boolean validarInt(Integer input) {
        if (input < 1) {
            return false;
        }

        return true;
    }
}
