package CrudTipoPokemon;

import java.util.ArrayList;
import java.util.List;

public class PokemonTipoControle {

    private List<PokemonTipo> lista = new ArrayList<>();

    public PokemonTipoControle() {

    }

    public void limparLista() {
        lista.clear();
    }

    public void adicionar(PokemonTipo pokemontipo) {
        lista.add(pokemontipo);
    }

    public List<PokemonTipo> listar() {
        return lista;
    }

    public PokemonTipo buscar(String Chave) {
        for (int i = 0; i < lista.size(); i++) {
            if (String.valueOf(lista.get(i).getChave()).equals(Chave)) {
                return lista.get(i);
            }
        }
        return null;
    }

    public void alterar(PokemonTipo pokemontipo, PokemonTipo pokemontipoAntigo) {
        lista.set(lista.indexOf(pokemontipoAntigo), pokemontipo);

    }

    public void excluir(PokemonTipo pokemontipo) {
        lista.remove(pokemontipo);
    }

    public List<String> listStrings() {
        List<String> ls = new ArrayList<>();
        for (PokemonTipo t : lista) {//converto trabalhador para uma lista de strings
            ls.add(t.toString());
        }
        return ls;
    }

}
