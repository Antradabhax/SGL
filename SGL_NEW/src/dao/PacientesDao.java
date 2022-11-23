package dao;

import clases.Paciente;

public class PacientesDao extends GenericDAO<Paciente> {

    public PacienteDao(Class<Paciente> clase, String file) throws Exception {
        super(clase, file);
    }
}