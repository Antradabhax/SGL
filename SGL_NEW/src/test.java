public class test {
    public static void main(String[] args) {
        PeticionesController peticionesController = PeticionesController.getInstance();
        for (Peticion peticion : peticionesController.obtenerListaPeticiones()) {
            System.out.println(peticion.getFechaCalculadaEntrega());
        }
    }
}
