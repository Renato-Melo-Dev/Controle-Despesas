package Utils;

public class GeradorId {
    // Contadores separados para cada tipo
    private static int idCounterUsuario = 1;
    private static int idCounterDespesa = 1;
    private static int idCounterReceita = 1;

    // Método para gerar ID de Usuário
    public static int gerarIdUsuario() {
        return idCounterUsuario++;
    }

    // Método para gerar ID de Despesa
    public static int gerarIdDespesa() {
        return idCounterDespesa++;
    }

    // Método para gerar ID de Receita
    public static int gerarIdReceita() {
        return idCounterReceita++;
    }
}
