package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameMenuPrincipal {

    public FrameMenuPrincipal() { // listeners
        ingresarSucursalButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"FUCK YOU MAX MARTIN");
                JFrame frame = new JFrame("FrameSucursales");
                frame.setContentPane(new FrameMenuPrincipal().menuSucursales);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        buscarSucursalButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

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

    private JPanel menuSucursales;
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

    public static void main(String[] args) {
        JFrame frame = new JFrame("FrameMenuPrincipal");
        frame.setContentPane(new FrameMenuPrincipal().menu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
