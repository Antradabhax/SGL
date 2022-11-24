package dao;

import GenericDAO.GenericDAO;
import clases.Practica;

public class PracticasInhabilitadasDao extends GenericDAO<Integer> {

    public PracticasInhabilitadasDao(Class<Integer> clase, String file) throws Exception {
        super(clase, file);
    }
}
