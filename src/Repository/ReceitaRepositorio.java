package Repository;


import Entidades.Receita;
import Interfaces.ReceitaRepository;
import java.util.ArrayList;
import java.util.List;

public class ReceitaRepositorio implements ReceitaRepository {
    private final List<Receita> receitas = new ArrayList<>();

    @Override
    public void salvarReceita(Receita receita) {
        if (!receitas.contains(receita)) {
            receitas.add(receita);
        }
    }

    @Override
    public Receita buscarReceitaPorId(long id) {
        return receitas.stream()
                .filter(r -> r.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public double calcularTotalReceitas() {
    return receitas.stream()
            .mapToDouble(Receita::getValor)
            .sum();
}

}
