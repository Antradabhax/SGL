package Controllers;

import clases.Paciente;
import clases.Peticion;
import clases.Sucursal;

import java.util.ArrayList;
import java.util.List;

public class PacienteController {
    List<Paciente> listaPacientes;

    private static PacienteController pacienteController;

    private static PeticionesController peticionesController;

    private PacienteController() {
        peticionesController = PeticionesController.getInstance();
    }

    public synchronized static PacienteController getInstance() {
        if (pacienteController == null) {
            pacienteController = new PacienteController();
        }
        return pacienteController;
    }

    public List<Paciente> getListaPacientes() {
        return this.listaPacientes;
    }

    public void crearPaciente(int dni, String nombre, String domicilio, String mail, String sexo, int edad,
                              Sucursal sucursalPeticion, Sucursal sucursalRetiro ) {
        Paciente p = null;
        p = new Paciente(dni, nombre, domicilio, mail, sexo, edad, sucursalPeticion, sucursalRetiro);
        agregarPaciente(p);
    }

    public void setListaPacientes(List<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }

    public void agregarPaciente(Paciente pac) {
        this.listaPacientes.add(pac);
    }

    public Paciente buscarPaciente(int dniPac) {
        Paciente buscado = new Paciente();
        for (Paciente listaPaciente : this.listaPacientes) {
            if (listaPaciente.getDni() == dniPac) {
                buscado = listaPaciente;
            }
        }
        return buscado;
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