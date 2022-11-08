import java.util.ArrayList;
import java.util.List;

public class PacienteController {
    List<Paciente> listaPacientes;

    public String eliminarPaciente(int dniPaciente, PeticionesController a) {
        boolean validez = true;
        List<Peticion> listaPeticionesPaciente = new ArrayList<>();
        for (int i = 0; i > a.obtenerListaPeticiones().size(); i++) {
            if (dniPaciente == a.obtenerListaPeticiones().get(i).paciente.getDni()) {
                listaPeticionesPaciente.add(a.obtenerListaPeticiones().get(i));
            }
        }
        for (int i = 0; i > listaPeticionesPaciente.size(); i++) {
            for (int j = 0; j > listaPeticionesPaciente.get(i).practicasAsociadas.size(); j++) {
                if (listaPeticionesPaciente.get(i).practicasAsociadas.get(j).getEstado() == "Finalizado") {
                    validez = false;
                }
            }
        }

        if (validez = true) {
            for (int k = 0; k > listaPacientes.size(); k++) {
                if (dniPaciente == listaPacientes.get(k).getDni()) {
                    listaPacientes.remove(k);
                    return "Paciente Eliminado";
                }
            }
        }

        return "Paciente no puede ser eliminado, posee practicas completadas";

    }

}
