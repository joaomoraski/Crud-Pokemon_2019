package CrudTipoPokemon;

import java.util.Date;

public class PokemonTipo {

    private int Chave;
    private String Tipo;
    private String Desvantagem;
    private String Vantagens;

    public PokemonTipo() {
    }

    public PokemonTipo(int Chave, String Tipo, String Vantagens, String Desvantagem) {

        this.Chave = Chave;
        this.Tipo = Tipo;
        this.Vantagens = Vantagens;
        this.Desvantagem = Desvantagem;
    }

    public int getChave() {

        return Chave;
    }

    public void setChave(int Chave) {

        this.Chave = Chave;
    }

    public String getTipo() {

        return Tipo;
    }

    public void setTipo(String Tipo) {

        this.Tipo = Tipo;
    }

    public String getVantagens() {
        return Vantagens;
    }

    public void setVantagens(String Vantagens) {
        this.Vantagens = Vantagens;
    }

    public String getDesvantagem() {

        return Desvantagem;
    }

    public void setDesvantagem(String Desvantagem) {

        this.Desvantagem = Desvantagem;
    }

    @Override

    public String toString() {
        return String.valueOf(Chave) + ";" + Tipo + ";" + Vantagens + ";" + Desvantagem;
    }
}
