import java.util.Enumeration;
import java.util.Vector;

public class TipoResultado {
    
    private Enumeration TipoResultado;
        
    public Enumeration principal(){
    Vector <String> Resultados = new Vector<>();
    Resultados.add("Criticos");
    Resultados.add("Booleanos");
    Resultados.add("Cadena");
    TipoResultado = Resultados.elements();
    return TipoResultado;
    }

}
