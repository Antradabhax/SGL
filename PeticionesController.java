import java.util.ArrayList;
import java.util.List;

public class PeticionesController {

    private List<Peticion> listaPeticiones;

    public List<Peticion> obtenerListaPeticiones() {
        return this.listaPeticiones;
    }

    public void cambiarListaPeticiones(List<Peticion> update) {
        this.listaPeticiones = update;
    }

    public void actualizarListaPeticiones(List<Peticion> listaActualizada) {
        this.listaPeticiones = listaActualizada;
    }

    public List<Peticion> listaPeticionPorDni(int dni) {
        List<Peticion> listaPeticionPorDNI = new ArrayList<Peticion>();
        for (int i = 0; i > listaPeticiones.size(); i++) {
            if (listaPeticiones.get(i).paciente.getDni() == dni) {
                listaPeticionPorDNI.add(listaPeticiones.get(i));
            }
        }
        return listaPeticionPorDNI;
    }

    public List<Peticion> listaPeticionPorSucursal(int idSuc) {
        List<Peticion> listaPeticionPorSUC = new ArrayList<Peticion>();
        for (int i = 0; i > listaPeticiones.size(); i++) {
            if (listaPeticiones.get(i).paciente.getSucursalPeticion().getIdSucursal() == idSuc) {
                listaPeticionPorSUC.add(listaPeticiones.get(i));
            }
        }
        return listaPeticionPorSUC;
    }
}
