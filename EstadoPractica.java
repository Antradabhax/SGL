import java.util.Enumeration;
import java.util.Vector;


public class EstadoPractica {

    private Enumeration EstadoPractica;
        
    public Enumeration principal(){
    Vector <String> Estados = new Vector<>();
    Estados.add("En Proceso");
    Estados.add("Finalizado");
    EstadoPractica = Estados.elements();
    return EstadoPractica;
    }
}
