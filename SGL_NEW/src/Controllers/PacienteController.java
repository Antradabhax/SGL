package Controllers;

import clases.Paciente;
import clases.Peticion;
import clases.Sucursal;
import dao.PacientesDao;
import dto.PacienteDto;
import dto.SucursalDto;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static Controllers.SucursalController.toSucursal;

public class PacienteController {
    private static List<Paciente> listaPacientes;

    private static PacienteController pacienteController;

    private static PacientesDao pacientesDao;

    private static PeticionesController peticionesController;

    private PacienteController() {
        peticionesController = PeticionesController.getInstance();
    }

    public synchronized static PacienteController getInstance() throws Exception {
        if (pacienteController == null) {
            pacienteController = new PacienteController();
            pacientesDao = new PacientesDao(Paciente.class,getPathOutPaciente(Paciente.class.getSimpleName()));
            listaPacientes = pacientesDao.getAll();
        }
        return pacienteController;
    }

    private static String getPathOutPaciente(String name){
        String dir = "C:/IOO/";
        return  new File(dir+name+".json").getPath();
    }

    public List<Paciente> getListaPacientes() {

        return new ArrayList<Paciente>(listaPacientes);
    }

    public void crearPaciente(int dni, String nombre, String domicilio, String mail, String sexo, int edad,
                              SucursalDto sucursalPeticion, SucursalDto sucursalRetiro ) {

        for (Paciente pac : listaPacientes){
            if (pac.getDni() != dni){
                PacienteDto p = null;
                p = new PacienteDto(dni, nombre, domicilio, mail, sexo, edad, sucursalPeticion, sucursalRetiro);
                agregarPaciente(p);
            }

        }

    }

    public void setListaPacientes(List<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }

    public void agregarPaciente(PacienteDto pac/*paciente dto*/) {


        this.listaPacientes.add(toPaciente(pac) );
    }

    public static Paciente toPaciente(PacienteDto dto){
        return new Paciente(dto.getDni(), dto.getNombre(), dto.getDomicilio(), dto.getMail(), dto.getSexo(), dto.getEdad(),toSucursal(dto.getSucursalPeticion()), toSucursal(dto.getSucursalRetiro()));
    }

    public static PacienteDto toDto(Paciente paciente){
        return new PacienteDto(paciente.getDni(),paciente.getNombre(),paciente.getDomicilio(),paciente.getMail(),paciente.getSexo(),paciente.getEdad(),paciente.getSucursalPeticion(),paciente.getSucursalRetiro());
    }

    public PacienteDto buscarPaciente(int dniPac) {
        Paciente buscado = new Paciente();
        for (Paciente listaPaciente : this.listaPacientes) {
            if (listaPaciente.getDni() == dniPac) {
                buscado = listaPaciente;
            }
        }
        return (toDto(buscado));
    }

    public void cambiarPacienteDeSucursal(int dniPac, int newSucursal) {
        for (Paciente listaPaciente : this.listaPacientes) {
            if (listaPaciente.getDni() == dniPac) {
                listaPaciente.setSucursalPeticion(null);
            }
        }
    }

    public String eliminarPaciente(int dniPaciente) {
        boolean validez = true;
        List<Peticion> listaPeticionesPaciente = new ArrayList<>();
        for (int i = 0; i < peticionesController.obtenerListaPeticiones().size(); i++) {
            if (dniPaciente == peticionesController.obtenerListaPeticiones().get(i).getPaciente().getDni()) {
                listaPeticionesPaciente.add(peticionesController.obtenerListaPeticiones().get(i));
            }
        }
        for (Peticion peticion : listaPeticionesPaciente) {
            for (int j = 0; j < peticion.getPracticasAsociadas().size(); j++) {
                if (peticion.getPracticasAsociadas().get(j).getEstado()
                        .toString() == "Finalizado") {
                    validez = false;
                }
            }
        }

        if (validez) {
            for (int k = 0; k < listaPacientes.size(); k++) {
                if (dniPaciente == listaPacientes.get(k).getDni()) {
                    listaPacientes.remove(k);
                    return "clases.Paciente Eliminado";
                }
            }
        }
        return "Paciente no puede ser eliminado, posee practicas completadas";

    }

    public List<Peticion> listarPeticionesConCriticos(int dniPac) {
        List<Peticion> peticionesDni = peticionesController.listaPeticionPorDni(dniPac);
        List<Peticion> peticionesCriticas = new ArrayList<>();
        for (Peticion peticion : peticionesDni) {
            boolean todosCriticos = true;
            for (int j = 0; j < peticion.getPracticasAsociadas().size(); j++) {
                if (peticion.getPracticasAsociadas().get(j).getResultado().toString() == "Critico") {
                    todosCriticos = false;
                }
            }
            if (todosCriticos) {
                peticionesCriticas.add(peticion);
            }
        }
        return peticionesCriticas;
    }

}