package Controllers;

import clases.Paciente;
import clases.Peticion;
import clases.Practica;
import clases.Sucursal;
import dao.PracticasInhabilitadasDao;
import dao.SucursalDao;
import dto.PacienteDto;
import dto.SucursalDto;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SucursalController {
    private static List<Sucursal> listaSucursales;

    private static List<Integer> practicasInhabilitadas;

    private PacienteController pacienteController;

    private static SucursalDao sucursalDao;
    private static PracticasInhabilitadasDao practicasInhabilitadasDao;

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
            practicasInhabilitadasDao = new PracticasInhabilitadasDao(Integer.class,getPathOutPracticaInhabil(Integer.class.getSimpleName()));
            practicasInhabilitadas = practicasInhabilitadasDao.getAll();
        }
        return sucursalController;
    }

    private static String getPathOutSucursal(String name){
        String dir = "C:/IOO/";
        return  new File(dir+name+".json").getPath();
    }

    private static String getPathOutPracticaInhabil(String name){
        return new File("C:/IOO/"+name+".json").getPath();
    }

    public static Sucursal toSucursal(SucursalDto dto){
        return new Sucursal(dto.getIdSucursal(),dto.getDireccion(), dto.getRespTecnico());
    }

    public static SucursalDto toDto(Sucursal S){
        return new SucursalDto(S.getIdSucursal(),S.getDireccion(),S.getRespTecnico());
    }

    public ArrayList<SucursalDto> getListaSucursales() {
        ArrayList<SucursalDto> A = new ArrayList<>();
        for(Sucursal sucursal : listaSucursales){
            A.add(toDto(sucursal));
        }
        return A;
    }

    public SucursalDto buscarSucursal(int idSuc) {
        SucursalDto buscada = new SucursalDto();
        for (Sucursal Sucursale : listaSucursales) {
            if (Sucursale.getIdSucursal() == idSuc) {
                buscada = toDto(Sucursale);
                break;
            }
        }
        return buscada;
    }

    public void agregarSucursal(SucursalDto s) {
        Sucursal sN = toSucursal(s);
        boolean existe = false;
        for (Sucursal sucursal: listaSucursales) {
            if (sucursal.getIdSucursal() == sN.getIdSucursal()) {
                existe = true;
                break;
            }
        }
        if (!existe){
            listaSucursales.add(sN);
        }
    }

    public List<Integer> getPracticasInhabilitadas() {
        return practicasInhabilitadas;
    }

    public void setPracticasInhabilitadas(List<Integer> practicasInhabilitadas) {
        SucursalController.practicasInhabilitadas = practicasInhabilitadas;
    }

    public void addPracticaInhabilidata(int idPractica) {
        practicasInhabilitadas.add(idPractica);
    }

    public String eliminarPractica(int idPra, int idSuc) {
        List<Peticion> peticiones = peticionesController.obtenerListaPeticiones();
        for (Peticion peticion : peticiones) {
            if (peticion.getPaciente().getSucursalPeticion().getIdSucursal() == idSuc) {
                for (int j = 0; j < peticion.getPracticasAsociadas().size(); j++) {
                    if (peticion.getPracticasAsociadas().get(j).getCodigoPractica() == idPra)
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

    public String eliminarSucursal(int idSuc) {
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
        int contador = Integer.MAX_VALUE;

        Sucursal SucursalPasaje = new Sucursal();
        if (!peticionesAptas) {
            return "Hay pacientes con peticiones con resultados finalizados, no es posible borrar la sucursal";
        }else{
            for (Sucursal sucursal : listaSucursales){
                int contador2 = 0;
                for (Paciente p : pacienteController.getListaPacientes()){
                    contador2++;
                }
                if (contador2 < contador){
                    SucursalPasaje = sucursal;//la sucursal que tiene menos pacientes
                }
            }
            for (Integer integer : dnisAPasar) {
                PacienteDto pacienteACambiar = pacienteController.buscarPaciente(integer);
                pacienteController.eliminarPaciente(integer);
                SucursalDto nuevaSuc = this.buscarSucursal(SucursalPasaje.getIdSucursal());
                pacienteACambiar.setSucursalPeticion(nuevaSuc);
                pacienteController.agregarPaciente(pacienteACambiar);
            }
            for (int l = 0; l<listaSucursales.size();l++){
                if (listaSucursales.get(l).getIdSucursal() == idSuc){
                    listaSucursales.remove(l);
                    break;
                }
            }

            return "Finalizado, sucursal eliminada y pacientes traspasados";
        }

    }

    public void close() throws Exception {
        sucursalDao.saveAll(listaSucursales);
        practicasInhabilitadasDao.saveAll(practicasInhabilitadas);
    }
}