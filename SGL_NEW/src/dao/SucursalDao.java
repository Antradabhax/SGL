package dao;

import GenericDAO.GenericDAO;
import clases.Paciente;
import clases.Sucursal;

public class SucursalDao extends GenericDAO<Sucursal> {

    public SucursalDao(Class<Sucursal> clase, String file) throws Exception {
        super(clase, file);
    }
}
