package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmMenuPrincipal extends JFrame {
    
    private JPanel pnlPrincipal;
    private FrmMenuPrincipal self;

    public FrmMenuPrincipal()
    {

        
        super("Menu principal aplicacion SWING");
        setSize(800,800);
        //Centrar la pantalla
        this.pnlPrincipal = new JPanel();
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        this.self=this;

    }

}
