package Repository;


import Entidades.Receita;
import Interfaces.ReceitaRepository;
import java.util.ArrayList;
import java.util.List;

public class ReceitaRepositorio implements ReceitaRepository {
        private final List<Receita> listaReceitas;
    
        public ReceitaRepositorio() {
            this.listaReceitas = new ArrayList<>();
        }
    @Override
    public void salvarReceita(Receita receita) {
        listaReceitas.add(receita);
        }
    

    @Override
    public Receita buscarReceitaPorId(long id) {
        return listaReceitas.stream()
                .filter(r -> r.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public double obterTotalReceitas(Receita receita) {
        double total = 0.0;
        for (Receita r : listaReceitas) {
            total += r.getValor();
        }
        return total;
    }
 
}
