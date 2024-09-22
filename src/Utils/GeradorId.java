package Utils;

public class GeradorId {
    private static int idCounter = 1;

    public static int gerarIdUsuario() {
        return idCounter++;
    }

    public static int gerarIdDespesa() {
        return idCounter++;
    }

    public static int gerarIdReceita() {
        return idCounter++;
    }
}
