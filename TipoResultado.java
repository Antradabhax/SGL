import java.util.Enumeration;
import java.util.Vector;

public class TipoResultado {
    
    private Enumeration TipoResultado;
        
    public Enumeration principal(){
    Vector <String> Resultados = new Vector<>();
    Resultados.add("En Proceso");
    Resultados.add("Finalizado");
    TipoResultado = Resultados.elements();
    return TipoResultado;
    }

}
