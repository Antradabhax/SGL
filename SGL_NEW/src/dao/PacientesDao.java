package dao;

import GenericDAO.GenericDAO;
import clases.Paciente;

public class PacientesDao extends GenericDAO<Paciente> {

    public PacientesDao(Class<Paciente> clase, String file) throws Exception {
        super(clase, file);
    }
}