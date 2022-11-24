package vista;

import Controllers.SucursalController;
import dto.SucursalDto;
import vista.modelos.SucursalModeloIngreso;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameBuscarSucursal extends JDialog {
    private JPanel pnlPrincipal;
    private JSpinner idSucursal;
    private JTable tabla;
    private JButton botonBuscar;

    private SucursalModeloIngreso modelo = new SucursalModeloIngreso();

    public FrameBuscarSucursal(Window owner, String titulo)
    {
        super(owner, titulo);
        setSize(400,400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        asignarDatosTabla();
        AsignarEventos();
    }

    private void AsignarEventos() {
        botonBuscar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SucursalDto c;
                try {
                    SucursalController sucursalContol = SucursalController.getInstance();
                    c = sucursalContol.buscarSucursal(Integer.parseInt(idSucursal.getValue().toString()));
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                modelo.addSucursal(c);
            }

        });
    }
    private void asignarDatosTabla(){
        tabla.setModel(modelo);
    }

}


