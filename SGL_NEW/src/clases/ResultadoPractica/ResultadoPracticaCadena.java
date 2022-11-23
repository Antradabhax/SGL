package clases.ResultadoPractica;

public class ResultadoPracticaCadena extends ResultadoPractica {
    private String valorResultado;
    private boolean mostrarValorCritico;

    public String getValorResultado() {
        return this.valorResultado;
    }

    public void setValorResultado(String valorResultado) {
        this.valorResultado = valorResultado;
    }

    public boolean sePuedeMostrar() {
        return this.mostrarValorCritico;
    }

    public void cambiarMostrarValorCritico(boolean mostrar) {
        this.mostrarValorCritico = mostrar;
    }

}