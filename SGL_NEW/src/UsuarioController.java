import java.util.List;

public class UsuarioController {
     List<Usuario> ListaUsuarios;

    private static UsuarioController usuarioController;

    private UsuarioController() {
    }

    public synchronized static UsuarioController getInstance() {
        if (usuarioController == null) {
            usuarioController = new UsuarioController();
        }
        return usuarioController;
    }
}
