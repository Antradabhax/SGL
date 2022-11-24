import Controllers.PacienteController;
import Controllers.PeticionesController;
import Controllers.SucursalController;
import Controllers.UsuarioController;
import vista.FrameMenuPrincipal;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws Exception {

        SucursalController.getInstance();
        UsuarioController.getInstance();
        PeticionesController.getInstance();
        PacienteController.getInstance();
        FrameMenuPrincipal win = new FrameMenuPrincipal();
        win.setVisible(true);
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //ON DISPOSE TO SAVE ALL THE LISTS FROM THE CONTROLLERS TO THE GSON FILES


    }
};