import java.util.List;

public class Peticion {
    private Paciente paciente;
    private String obraSocial;
    private String fechaCarga;
    private List<Practica> practicasAsociadas;
    private String fechaCalculadaEntrega;

    public Peticion() {
    }

    public Peticion(Paciente paciente, String obraSocial, String fechaCarga, List<Practica> practicasAsociadas,
            String fechaCalculadaEntrega) {
        this.paciente = paciente;
        this.obraSocial = obraSocial;
        this.fechaCarga = fechaCarga;
        this.practicasAsociadas = practicasAsociadas;
        this.fechaCalculadaEntrega = fechaCalculadaEntrega;
    }

    public Paciente getPaciente() {
        return this.paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getObraSocial() {
        return this.obraSocial;
    }

    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }

    public String getFechaCarga() {
        return this.fechaCarga;
    }

    public void setFechaCarga(String fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public List<Practica> getPracticasAsociadas() {
        return this.practicasAsociadas;
    }

    public void setPracticasAsociadas(List<Practica> practicasAsociadas) {
        this.practicasAsociadas = practicasAsociadas;
    }

    public String getFechaCalculadaEntrega() {
        return this.fechaCalculadaEntrega;
    }

    public void setFechaCalculadaEntrega(String fechaCalculadaEntrega) {
        this.fechaCalculadaEntrega = fechaCalculadaEntrega;
    }

}
