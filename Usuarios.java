//Crear, modificar y eliminar usuarios

//Roles:
//Recepcion: Recibe pacientes y carga peticiones, consulta pero no modifica resultados (Nivel 1)
//Laboratorista: procesa muestras y carga resultados (Nivel 2)
//Administrador: SuperUser (Nivel 3)

public class Usuario{
    private String NombreUsuario;
    private String Mail;
    private String Contrasena;
    private String Nombre;
    private String Domicilio;
    private int DNI;
    private String Nacimiento;
    private int Nivel;

    public Usuario(String NombreUsuario, String Mail, String Contrasena, String Nombre, String Domicilio, int DNI, String Nacimiento, int Nivel){
        this.NombreUsuario = NombreUsuario;

    }

    public String getNombreUsuario() {
        return this.NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getMail() {
        return this.Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    public String getContrasena() {
        return this.Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDomicilio() {
        return this.Domicilio;
    }

    public void setDomicilio(String Domicilio) {
        this.Domicilio = Domicilio;
    }

    public int getDNI() {
        return this.DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getNacimiento() {
        return this.Nacimiento;
    }

    public void setNacimiento(String Nacimiento) {
        this.Nacimiento = Nacimiento;
    }

    public int getNivel() {
        return this.Nivel;
    }

    public void setNivel(int Nivel) {
        this.Nivel = Nivel;
    }

}