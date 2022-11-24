package vista.modelos;

import Controllers.SucursalController;
import dto.SucursalDto;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class SucursalModeloIngreso extends AbstractTableModel {

    ArrayList<SucursalDto> listaSucursales = new ArrayList<>();

    protected String[] nombreColumnas = new String[] {"Sucursal" , "Direccion", "DNI responsable"};

    protected Class[] claseColumna = new Class[] { Integer.class, String.class, Integer.class};

    public String getColumnName (int col) {return nombreColumnas[col];}

    public Class getColumnClass (int col) {return claseColumna[col];}

    @Override
    public int getRowCount() {
        return listaSucursales.size();
    }

    @Override
    public int getColumnCount() {
        return this.nombreColumnas.length; }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listaSucursales.get(rowIndex).getIdSucursal();
            case 1:
                return listaSucursales.get(rowIndex).getDireccion();
            case 2:
                return listaSucursales.get(rowIndex).getRespTecnico();
            default:
                return null;
        }
    }

    public int addSucursal(SucursalDto c)
    {
        listaSucursales.add(c);
        fireTableDataChanged();
        return listaSucursales.size()-1;
    }
}
