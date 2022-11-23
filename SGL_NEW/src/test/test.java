package test;

import Controllers.PeticionesController;
import clases.Peticion;

public class test {
    public static void main(String[] args) throws Exception {
        PeticionesController peticionesController = PeticionesController.getInstance();
        for (Peticion peticion : peticionesController.obtenerListaPeticiones()) {
            System.out.println(peticion.getFechaCalculadaEntrega());
        }
    }
}
