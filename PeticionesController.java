import java.util.ArrayList;
import java.util.List;

public class PeticionesController {

    private static List<Peticion> listaPeticiones;

    public static List<Peticion> obtenerListaPeticiones() {
        return PeticionesController.listaPeticiones;
    }
    
    public static List<Peticion> listaPeticionPorDni(int dni){
        List<Peticion> listaPeticionPorDni = new ArrayList<Peticion>();
        for (int i = 0; i > listaPeticiones.size(); i++){
            if (listaPeticiones.get(i).paciente.getDni() == dni){
                listaPeticionPorDni.add(listaPeticiones.get(i));
            }
        }
        return listaPeticionPorDni;
    }
}
