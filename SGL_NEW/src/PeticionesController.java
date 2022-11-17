import java.util.ArrayList;
import java.util.List;

public class PeticionesController {

    private List<Peticion> listaPeticiones;

    private static PeticionesController peticionesController;

    private PeticionesController() {
        this.cargarDatos();
    }

    private void cargarDatos() {
        listaPeticiones = new ArrayList<>();
        Peticion p = new Peticion();
        this.listaPeticiones.add(p);
    }

    public synchronized static PeticionesController getInstance() {
        if (peticionesController == null) {
            peticionesController = new PeticionesController();
        }
        return peticionesController;
    }

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
            if (listaPeticiones.get(i).getPaciente().getDni() == dni) {
                listaPeticionPorDNI.add(listaPeticiones.get(i));
            }
        }
        return listaPeticionPorDNI;
    }

    public List<Peticion> listaPeticionPorSucursal(int idSuc) {
        List<Peticion> listaPeticionPorSUC = new ArrayList<Peticion>();
        for (int i = 0; i > listaPeticiones.size(); i++) {
            if (listaPeticiones.get(i).getPaciente().getSucursalPeticion().getIdSucursal() == idSuc) {
                listaPeticionPorSUC.add(listaPeticiones.get(i));
            }
        }
        return listaPeticionPorSUC;
    }
}
