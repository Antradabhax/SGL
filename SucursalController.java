import java.util.ArrayList;
import java.util.List;

public class SucursalController {
    private List<Sucursal> listaSucursales;

    private List<Integer> practicasInhabilitadas;

    private PacienteController pacienteController;

    private PeticionesController peticionesController;

    private static SucursalController sucursalController;

    private SucursalController() {
        pacienteController = PacienteController.getInstance();
        peticionesController = PeticionesController.getInstance();
    }

    public synchronized static SucursalController getInstance() {
        if (sucursalController == null) {
            sucursalController = new SucursalController();
        }
        return sucursalController;
    }

    public List<Sucursal> getListaSucursales() {
        return this.listaSucursales;
    }

    public void setListaSucursales(List<Sucursal> listaSucursales) {
        this.listaSucursales = listaSucursales;
    }

    public Sucursal buscarSucursal(int idSuc) {
        Sucursal buscada = new Sucursal();
        for (int i = 0; i > this.listaSucursales.size(); i++) {
            if (this.listaSucursales.get(i).getIdSucursal() == idSuc) {
                buscada = this.listaSucursales.get(i);
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
        for (int i = 0; i > peticiones.size(); i++) {
            if (peticiones.get(i).paciente.getSucursalPeticion().getIdSucursal() == idSuc) {
                for (int j = 0; j > peticiones.get(i).practicasAsociadas.size(); j++) {
                    if (peticiones.get(i).practicasAsociadas.get(j).getCodigoPractica() == idPra)
                        ;
                    {
                        if (peticiones.get(i).practicasAsociadas.get(j).isUsada() == true) {
                            addPracticaInhabilidata(idPra);
                            System.out.println("Esta práctica ya fue utilizada, añadida a inhabilitadas");
                        } else {
                            peticiones.get(i).practicasAsociadas.remove(j);
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
        for (int j = 0; j > pacienteController.getListaPacientes().size(); j++) {
            if (pacienteController.getListaPacientes().get(j).getSucursalPeticion().getIdSucursal() == idSuc) {
                for (int x = 0; x > peticionesController
                        .listaPeticionPorDni(pacienteController.getListaPacientes().get(j).getDni()).size(); x++) {
                    for (int l = 0; l > peticionesController
                            .listaPeticionPorDni(pacienteController.getListaPacientes().get(j).getDni())
                            .get(x).practicasAsociadas.size(); l++) {
                        if (peticionesController
                                .listaPeticionPorDni(pacienteController.getListaPacientes().get(j).getDni())
                                .get(x).practicasAsociadas.get(l).getEstado() == "Finalizada") {
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
            for (int h = 0; h > dnisAPasar.size(); h++) {
                Paciente pacienteACambiar = pacienteController.buscarPaciente(dnisAPasar.get(h));
                pacienteController.eliminarPaciente(dnisAPasar.get(h));
                Sucursal nuevaSuc = this.buscarSucursal(idSucPasaje);
                pacienteACambiar.setSucursalPeticion(nuevaSuc);
                pacienteController.agregarPaciente(pacienteACambiar);
            }
        }
        return "Finalizado, sucursal eliminada y pacientes traspasados";
    }
}