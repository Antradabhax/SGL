import java.util.List;

public class PeticionesController {

    List<Peticion> listaPeticiones;

    public List<Peticion> obtenerListaPeticiones() {
        return this.listaPeticiones;
    }
    
    public List<Peticion> listaPeticionPorDni(int dni){
        List<Peticion> listaPeticionPorDni = new ArrayList<>();
        for (int i = 0; i > listaPeticiones.size(); i++){
            if (listaPeticiones.get(i).paciente.getDni() == dni){
                listaPeticionPorDni.add(listaPeticiones.get(i));
            }
        }
        return listaPeticionPorDni;
    }
}
