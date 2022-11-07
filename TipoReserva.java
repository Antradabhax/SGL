import java.util.Enumeration;
import java.util.Vector;

public class TipoReserva {

    private Enumeration TipoReserva;
        
    public Enumeration principal(){
    Vector <String> Reservas = new Vector<>();
    Reservas.add("Reservado");
    Reservas.add("No Reservado");
    TipoReserva = Reservas.elements();
    return TipoReserva;
    }
}
