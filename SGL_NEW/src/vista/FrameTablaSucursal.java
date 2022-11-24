package vista;

import Controllers.SucursalController;
import dto.SucursalDto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameTablaSucursal extends JDialog {

    private JPanel panelPrincipal;
    private JTable table1;
    private JButton agregarButton;
    private JSpinner sucursal;
    private JTextField Direccion;
    private JTextField DNI;

    private SucursalModeloIngreso modelo = new SucursalModeloIngreso();


    public FrameTablaSucursal(Window owner, String titulo)
    {
        super(owner, titulo);
        setSize(400,400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(panelPrincipal);
        asignarDatosTabla();
        AsignarEventos();
    }

    private void AsignarEventos()
    {
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SucursalDto c = new SucursalDto(Integer.parseInt(sucursal.getValue().toString()), Direccion.getText(), Integer.parseInt(DNI.getText()));
                modelo.addSucursal(c);
                try {
                    SucursalController sucursalContol = SucursalController.getInstance();
                    sucursalContol.agregarSucursal(c);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
    private void asignarDatosTabla()
    {
        table1.setModel(modelo);
    }

}