import java.lang.reflect.Array;

//Peticiones que se procesaran en el laboratorio (paciente, obra social, fecha de carga, practicas asociadas, fecha de entrega aprox)
public class Peticiones {
    private String Paciente;
    private int Obra_Social;
    private int Fecha_de_carga;
    private Practicas[] Practicas_Asociadas;
    private int Fecha_calculada_entrega;

    public Peticiones(String Paciente, int Obra_Social, int Fecha_de_carga, Practicas[] Practicas_Asociadas,
            int Fecha_calculada_entrega) {
        this.Paciente = Paciente;
        this.Obra_Social = Obra_Social;
        this.Fecha_de_carga = Fecha_de_carga;
        this.Practicas_Asociadas = Practicas_Asociadas; // **CREAR PRACTICAS**/
        this.Fecha_calculada_entrega = Fecha_calculada_entrega;
    }

    public String getPaciente() {
        return this.Paciente;
    }

    public void setPaciente(String Paciente) {
        this.Paciente = Paciente;
    }

    public int getObra_Social() {
        return this.Obra_Social;
    }

    public void setObra_Social(int Obra_Social) {
        this.Obra_Social = Obra_Social;
    }

    public int getFecha_de_carga() {
        return this.Fecha_de_carga;
    }

    public void setFecha_de_carga(int Fecha_de_carga) {
        this.Fecha_de_carga = Fecha_de_carga;
    }

    public Practicas[] getPracticas_Asociadas() {
        return this.Practicas_Asociadas;
    }

    public void setPracticas_Asociadas(Practicas[] Practicas_Asociadas) {
        this.Practicas_Asociadas = Practicas_Asociadas;
    }

    public int getFecha_calculada_entrega() {
        return this.Fecha_calculada_entrega;
    }

    public void setFecha_calculada_entrega(int Fecha_calculada_entrega) {
        this.Fecha_calculada_entrega = Fecha_calculada_entrega;
    }

}
