package Controllers;

import clases.Paciente;
import clases.Peticion;
import clases.Sucursal;
import dao.PacientesDao;
import dao.SucursalDao;
import dto.PacienteDto;
import dto.SucursalDto;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SucursalController {
    private static List<Sucursal> listaSucursales;

    private List<Integer> practicasInhabilitadas;

    private PacienteController pacienteController;

    private static SucursalDao sucursalDao;

    private PeticionesController peticionesController;

    private static SucursalController sucursalController;

    private SucursalController() throws Exception {
        pacienteController = PacienteController.getInstance();
        peticionesController = PeticionesController.getInstance();
    }


    public synchronized static SucursalController getInstance() throws Exception {
        if (sucursalController == null) {
            sucursalController = new SucursalController();
            sucursalDao = new SucursalDao(Sucursal.class,getPathOutSucursal(Sucursal.class.getSimpleName()));
            listaSucursales = sucursalDao.getAll();
        }
        return sucursalController;
    }

    private static String getPathOutSucursal(String name){
        String dir = "C:/IOO/";
        return  new File(dir+name+".json").getPath();
    }

    public static Sucursal toSucursal(SucursalDto dto){
        return new Sucursal(dto.getIdSucursal(),dto.getDireccion(), dto.getRespTecnico());
    }

    public static SucursalDto toDto(Sucursal S){
        return new SucursalDto(S.getIdSucursal(),S.getDireccion(),S.getRespTecnico());
    }

    public List<Sucursal> getListaSucursales() {
        return new ArrayList<Sucursal>(listaSucursales);
    }

    public Sucursal buscarSucursal(int idSuc) {
        Sucursal buscada = new Sucursal();
        for (Sucursal listaSucursale : listaSucursales) {
            if (listaSucursale.getIdSucursal() == idSuc) {
                buscada = listaSucursale;
            }
        }
        return buscada;
    }

    public List<Integer> getPracticasInhabilitadas() {
        return this.practicasInhabilitadas;
    }

    public void setPracticasInhabilitadas(List<Integer> practicasInhabilitadas) {
        this.practicasInhabilitadas = practicasInhabilitadas;
    }

    public void addPracticaInhabilidata(int idPractica) {
        this.practicasInhabilitadas.add(idPractica);
    }

    public String eliminarPractica(int idPra, int idSuc) {
        List<Peticion> peticiones = peticionesController.obtenerListaPeticiones();
        for (Peticion peticion : peticiones) {
            if (peticion.getPaciente().getSucursalPeticion().getIdSucursal() == idSuc) {
                for (int j = 0; j < peticion.getPracticasAsociadas().size(); j++) {
                    if (peticion.getPracticasAsociadas().get(j).getCodigoPractica() == idPra)
                        ;
                    {
                        if (peticion.getPracticasAsociadas().get(j).isUsada()) {
                            addPracticaInhabilidata(idPra);
                            System.out.println("Esta práctica ya fue utilizada, añadida a inhabilitadas");
                        } else {
                            peticion.getPracticasAsociadas().remove(j);
                            System.out.println("Práctica Eliminada");
                        }
                    }
                }
            }
        }
        peticionesController.cambiarListaPeticiones(peticiones);
        return "Finalizado";
    }

    public String eliminarSucursal(int idSuc, int idSucPasaje) {
        boolean peticionesAptas = true;
        List<Integer> dnisAPasar = new ArrayList<>();
        for (int j = 0; j < pacienteController.getListaPacientes().size(); j++) {
            if (pacienteController.getListaPacientes().get(j).getSucursalPeticion().getIdSucursal() == idSuc) {
                for (int x = 0; x < peticionesController.listaPeticionPorDni(pacienteController.getListaPacientes().get(j).getDni()).size(); x++) {
                    for (int l = 0; l < peticionesController.listaPeticionPorDni(pacienteController.getListaPacientes().get(j).getDni()).get(x).getPracticasAsociadas().size(); l++) {
                        if (peticionesController.listaPeticionPorDni(pacienteController.getListaPacientes().get(j).getDni()).get(x).getPracticasAsociadas().get(l).getEstado().toString() == "Finalizada") {
                            peticionesAptas = false;
                        } else {
                            dnisAPasar.add(pacienteController.getListaPacientes().get(j).getDni());
                        }
                    }
                }
            }
        }
        if (peticionesAptas == false) {
            return "Hay pacientes con peticiones con resultados finalizados, no es posible borrar la sucursal";
        }
        if (peticionesAptas == true) {
            for (int h = 0; h < dnisAPasar.size(); h++) {
                PacienteDto pacienteACambiar = pacienteController.buscarPaciente(dnisAPasar.get(h));
                pacienteController.eliminarPaciente(dnisAPasar.get(h));
                SucursalDto nuevaSuc = this.buscarSucursal(idSucPasaje);
                pacienteACambiar.setSucursalPeticion(nuevaSuc);
                pacienteController.agregarPaciente(pacienteACambiar);
            }
        }
        return "Finalizado, sucursal eliminada y pacientes traspasados";
    }
}