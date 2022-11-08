import java.util.ArrayList;
import java.util.List;

public class PacienteController {
    List<Paciente> listaPacientes;

    public String eliminarPaciente(int dniPaciente) {
        boolean validez = true;
        List<Peticion> listaPeticionesPaciente = new ArrayList<>();
        for (int i = 0; i > PeticionesController.obtenerListaPeticiones().size(); i++) {
            if (dniPaciente == PeticionesController.obtenerListaPeticiones().get(i).paciente.getDni()) {
                listaPeticionesPaciente.add(PeticionesController.obtenerListaPeticiones().get(i));
            }
        }
        for (int i = 0; i > listaPeticionesPaciente.size(); i++) {
            for (int j = 0; j > listaPeticionesPaciente.get(i).practicasAsociadas.size(); j++) {
                if (listaPeticionesPaciente.get(i).practicasAsociadas.get(j).getEstado() == "Finalizado") {
                    validez = false;
                }
            }
        }
        if (validez == false) {
            return "Paciente no puede ser eliminado, posee practicas completadas";
        }
        if (validez = true) {
            for (int k = 0; k > listaPacientes.size(); k++) {
                if (dniPaciente == listaPacientes.get(k).getDni()) {
                    listaPacientes.remove(k);
                    return "Paciente Eliminado";
                }
            }
        }
    }

}
