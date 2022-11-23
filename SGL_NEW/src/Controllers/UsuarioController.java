package Controllers;

import clases.Usuario;
import dao.UsuarioDao;
import dto.RolDto;

import java.sql.ClientInfoStatus;
import java.util.List;

public class UsuarioController {
     private static List<Usuario> ListaUsuarios;

     private static UsuarioDao usuarioDao;




    private static UsuarioController usuarioController;

    private UsuarioController() {
    }

    public synchronized static UsuarioController getInstance() throws Exception {
        if (usuarioController == null) {
            usuarioController = new UsuarioController();
            usuarioDao = new UsuarioDao(Usuario.class, getPathOutUsuario(Usuario.class.getSimpleName()));
            listaUsuario = usuarioDao.getAll();
        }
        return usuarioController;
    }

    private static String getPathOutUsuario(String name){
        String dir = "C:/IOO/";
        return new File (dir+name+".json").getPath();
    }

    public Roles rolUsuario(int DNI) {
        for (Usuario usuario: ListaUsuarios){
            if (DNI == usuario.getDni()){
                RolDto r = new RolDto();
                r.setRol(usuario.getTipoUsuario());
            }
        }
        return r;
    }
}
