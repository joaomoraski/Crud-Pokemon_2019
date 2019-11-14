package CrudPokemon;

import java.util.Date;

public class CrudPokemon {

    private int Id;
    private String Nome;
    private Date DatadeNasc;
    private boolean Evoluiu;
    private int Caracteristicas;
    private float Peso;

    public CrudPokemon() {
    }

    public CrudPokemon(int Id, String Nome, Date DatadeNasc, boolean Evoluiu, int Caracteristicas, float Peso) {

        this.Id = Id;
        this.Nome = Nome;
        this.DatadeNasc = DatadeNasc;
        this.Evoluiu = Evoluiu;
        this.Caracteristicas = Caracteristicas;
        this.Peso = Peso;
    }

    public int getId() {

        return Id;
    }

    public void setId(int Id) {

        this.Id = Id;
    }

    public String getNome() {

        return Nome;
    }

    public void setNome(String Nome) {

        this.Nome = Nome;
    }

    public Date getDatadeNasc() {

        return DatadeNasc;
    }

    public void setDatadeNasc(Date DatadeNasc) {

        this.DatadeNasc = DatadeNasc;
    }

    public boolean getEvoluiu() {

        return Evoluiu;
    }

    public void setEvoluiu(boolean Evoluiu) {

        this.Evoluiu = Evoluiu;
    }

    public int getCaracteristicas() {

        return Caracteristicas;
    }

    public void setCaracteristicas(int Caracteristicas) {

        this.Caracteristicas = Caracteristicas;
    }

    public float getPeso() {

        return Peso;
    }

    public void setPeso(float Peso) {

        this.Peso = Peso;
    }

    @Override

    public String toString() {

        return String.valueOf(Id) + ";" + Nome + ";" + String.valueOf(DatadeNasc) + ";" + String.valueOf(Evoluiu) + ";" + String.valueOf(Caracteristicas) + ";" + String.valueOf(Peso);
    }
}
