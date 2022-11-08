import java.util.List;

public class SucursalController {
    private List<Integer> practicasInhabilitadas;

    public List<Integer> getPracticasInhabilitadas() {
        return this.practicasInhabilitadas;
    }

    public void setPracticasInhabilitadas(List<Integer> practicasInhabilitadas) {
        this.practicasInhabilitadas = practicasInhabilitadas;
    }

    public void addPracticaInhabilidata(int idPractica) {
        this.practicasInhabilitadas.add(idPractica);
    }

    public String eliminarPractica(int idPra, int idSuc, PeticionesController a) {
        List<Peticion> peticiones = a.obtenerListaPeticiones();
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
        a.cambiarListaPeticiones(peticiones);
        return "Finalizado";
    }
}