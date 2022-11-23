package dao;

import GenericDAO.GenericDAO;
import clases.Peticion;

public class PeticionesDao extends GenericDAO<Peticion> {
    public PeticionesDao(Class <Peticion> clase, String file) throws Exception {
        super(clase, file);
    }
}
