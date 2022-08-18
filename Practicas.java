import java.util.ArrayList;

//Estudios que puede hacer el laboratorio
public class Practicas {
    private int CodigoPractica;
    private String NombrePractica;
    private String Grupo;
    private String ValorCritico;
    private String ValorReservado;
    private int CantidadHoras;

    public Practicas(int CodigoPractica, String NombrePractica, String Grupo, String ValorCritico,
            String ValorReservado, int CantidadHoras) {
        this.CodigoPractica = CodigoPractica;
        this.NombrePractica = NombrePractica;
        this.Grupo = Grupo;
        this.ValorCritico = ValorCritico;
        this.ValorReservado = ValorReservado;
        this.CantidadHoras = CantidadHoras;
    }

    public int getCodigoPractica() {
        return this.CodigoPractica;
    }

    public void setCodigoPractica(int CodigoPractica) {
        this.CodigoPractica = CodigoPractica;
    }

    public String getNombrePractica() {
        return this.NombrePractica;
    }

    public void setNombrePractica(String NombrePractica) {
        this.NombrePractica = NombrePractica;
    }

    public String getGrupo() {
        return this.Grupo;
    }

    public void setGrupo(String Grupo) {
        this.Grupo = Grupo;
    }

    public String getValorCritico() {
        return this.ValorCritico;
    }

    public void setValorCritico(String ValorCritico) {
        this.ValorCritico = ValorCritico;
    }

    public String getValorReservado() {
        return this.ValorReservado;
    }

    public void setValorReservado(String ValorReservado) {
        this.ValorReservado = ValorReservado;
    }

    public int getCantidadHoras() {
        return this.CantidadHoras;
    }

    public void setCantidadHoras(int CantidadHoras) {
        this.CantidadHoras = CantidadHoras;
    }

}