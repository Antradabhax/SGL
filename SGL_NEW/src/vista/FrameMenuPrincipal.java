package vista;

import Controllers.PacienteController;
import Controllers.SucursalController;
import Controllers.UsuarioController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameMenuPrincipal extends JFrame {

    public FrameMenuPrincipal() { // listeners

        super("Menu principal aplicacion SWING");
        setSize(800,800);
        //Centrar la pantalla
        setLocationRelativeTo(null);
        setContentPane(menu);
        this.self=this;
        ingresarSucursalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameTablaSucursal dialog = new FrameTablaSucursal(self, "Ingreso sucursales");
                dialog.setVisible(true);

            }
        });
        buscarSucursalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameBuscarSucursal a = new FrameBuscarSucursal(self, "Ingreso sucursales");
                a.setVisible(true);
            }
        });
        eliminarSucursalButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        ingresarPacienteButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buscarPacienteButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        eliminarPacienteButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        listaPeticionesConResultadosButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        ingresarPracticaButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        eliminarPracticaButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


    private JPanel menu;

    private JTextField sistemaDeGestionDeTextField;
    private JButton ingresarPacienteButton;
    private JButton buscarPacienteButton;
    private JButton eliminarPacienteButton;
    private JButton listaPeticionesConResultadosButton;
    private JButton buscarSucursalButton;
    private JButton eliminarPracticaButton;
    private JButton eliminarSucursalButton;
    private JButton ingresarPracticaButton;
    private JButton ingresarSucursalButton;
    private FrameMenuPrincipal self;

    @Override
    public void dispose(){
        try{
            PacienteController.getInstance().close();
            SucursalController.getInstance().close();
            PacienteController.getInstance().close();
            UsuarioController.getInstance().close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
       super.dispose();
    }

}
