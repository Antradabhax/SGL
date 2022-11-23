package dao;

import GenericDAO.GenericDAO;
import clases.Usuario;

public class UsuarioDao extends GenericDAO<Usuario> {
    public UsuarioDao(Class<Usuario> clase , String file) throws Exception {
        super(clase, file);
    }
}
