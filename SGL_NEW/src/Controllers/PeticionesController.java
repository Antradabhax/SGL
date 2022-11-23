package Controllers;

import clases.Peticion;
import dao.PeticionesDao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PeticionesController {

    private static List<Peticion> listaPeticiones;

    private static PeticionesDao peticionesDao;

    private static PeticionesController peticionesController;

    private PeticionesController() {

    }

    /*
    private void cargarDatos() {
        listaPeticiones = new ArrayList<>();
        Peticion p = new Peticion();
        this.listaPeticiones.add(p);
    }
    */

    public synchronized static PeticionesController getInstance() throws Exception {
        if (peticionesController == null) {
            peticionesController = new PeticionesController();
            peticionesDao = new PeticionesDao(Peticion.class, getPathOutPeticion(Peticion.class.getSimpleName()));
        }
        return peticionesController;
    }

    private static String getPathOutPeticion(String name) {
        return new File("C:/IOO/"+name+".json").getPath();
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
        for (Peticion listaPeticione : listaPeticiones) {
            if (listaPeticione.getPaciente().getDni() == dni) {
                listaPeticionPorDNI.add(listaPeticione);
            }
        }
        return listaPeticionPorDNI;
    }

    public List<Peticion> listaPeticionPorSucursal(int idSuc) {
        List<Peticion> listaPeticionPorSUC = new ArrayList<Peticion>();
        for (Peticion listaPeticione : listaPeticiones) {
            if (listaPeticione.getPaciente().getSucursalPeticion().getIdSucursal() == idSuc) {
                listaPeticionPorSUC.add(listaPeticione);
            }
        }
        return listaPeticionPorSUC;
    }
}
