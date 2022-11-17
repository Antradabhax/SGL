public class Practica {
    private int codigoPractica;
    private String nombrePractica;
    private String grupo;
    private int cantidadHorasResultado;
    private EstadoPractica estado;
    private float valorCriticoMinimo;
    private float valorCriticoMaximo;
    private TipoResultado Resultado;
    private boolean usada;

    public EstadoPractica getEstado() {
        return this.estado;
    }

    public void setEstado(EstadoPractica estado) {
        this.estado = estado;
    }

    public int getCodigoPractica() {
        return this.codigoPractica;
    }

    public void setCodigoPractica(int codigoPractica) {
        this.codigoPractica = codigoPractica;
    }

    public String getNombrePractica() {
        return this.nombrePractica;
    }

    public void setNombrePractica(String nombrePractica) {
        this.nombrePractica = nombrePractica;
    }

    public String getGrupo() {
        return this.grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int getCantidadHorasResultado() {
        return this.cantidadHorasResultado;
    }

    public void setCantidadHorasResultado(int cantidadHorasResultado) {
        this.cantidadHorasResultado = cantidadHorasResultado;
    }

    public float getValorCriticoMinimo() {
        return this.valorCriticoMinimo;
    }

    public void setValorCriticoMinimo(float valorCriticoMinimo) {
        this.valorCriticoMinimo = valorCriticoMinimo;
    }

    public float getValorCriticoMaximo() {
        return this.valorCriticoMaximo;
    }

    public void setValorCriticoMaximo(float valorCriticoMaximo) {
        this.valorCriticoMaximo = valorCriticoMaximo;
    }

    public TipoResultado getResultado() {
        return this.Resultado;
    }

    public void setResultado(TipoResultado Resultado) {
        this.Resultado = Resultado;
    }

    public boolean isUsada() {
        return this.usada;
    }

    public void setUsada(boolean usada) {
        this.usada = usada;
    }

}