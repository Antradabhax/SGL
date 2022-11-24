package vista;

import Controllers.SucursalController;
import dto.SucursalDto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameEliminarSucursal extends JDialog {
    private JPanel panelPrincip;
    private JSpinner IdSucursal;
    private JButton botonEliminar;
    private JTextArea textArea1;

    public FrameEliminarSucursal(Window owner, String titulo)
    {
        super(owner, titulo);
        setSize(400,400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(panelPrincip);
        AsignarEventos();
    }

    private void AsignarEventos(){
        botonEliminar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SucursalDto sucursalABorrar = new SucursalDto();
                String devolucion;
                try {
                    SucursalController sC = SucursalController.getInstance();
                    sucursalABorrar.setIdSucursal(Integer.parseInt(IdSucursal.getValue().toString()));
                    System.out.println(Integer.parseInt(IdSucursal.getValue().toString()));
                    devolucion = sC.eliminarSucursal(sucursalABorrar.getIdSucursal());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

                textArea1.append(devolucion);

            }

        });
    }
}
