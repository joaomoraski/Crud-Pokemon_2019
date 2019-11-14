package CrudPokemon;

import java.util.ArrayList;
import java.util.List;

public class PokemonControle {

    private List<CrudPokemon> lista = new ArrayList<>();

    public PokemonControle() {

    }

    public void limparLista() {
        lista.clear();
    }

    public void adicionar(CrudPokemon crudpokemon) {
        lista.add(crudpokemon);
    }

    public List<CrudPokemon> listar() {
        return lista;
    }

    public CrudPokemon buscar(String Id) {
        for (int i = 0; i < lista.size(); i++) {
            if (String.valueOf(lista.get(i).getId()).equals(Id)) {
                return lista.get(i);
            }
        }
        return null;
    }

    public void alterar(CrudPokemon crudpokemon, CrudPokemon crudpokemonAntigo) {
        lista.set(lista.indexOf(crudpokemonAntigo), crudpokemon);

    }

    public void excluir(CrudPokemon crudpokemon) {
        lista.remove(crudpokemon);
    }

    public List<String> listStrings() {
        List<String> ls = new ArrayList<>();
        for (CrudPokemon t : lista) {//converto trabalhador para uma lista de strings
            ls.add(t.toString());
        }
        return ls;
    }

}
