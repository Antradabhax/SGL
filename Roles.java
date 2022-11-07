import java.util.Enumeration;
import java.util.Vector;



public class Roles{
   private Enumeration Roles;

    public Enumeration principal(){
    Vector <String> TodosLosRoles = new Vector<>();
    TodosLosRoles.add("administrador");
    TodosLosRoles.add("recepcion");
    TodosLosRoles.add("laboratorista");
    Roles = TodosLosRoles.elements();
    return Roles;
    }
}