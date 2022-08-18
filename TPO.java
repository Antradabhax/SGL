//**HACER INTERFAZ**

//Administracion de pacientes (DNI, Nombre, Domicilio, Mail, Sexo, Edad)
class Pacientes {
    private int DNI;
    private String Nombre;
    private String Domicilio;
    private String Mail;
    private String Sexo;
    private int Edad;
    private Peticiones[] peticionesPaciente;// CREAR CODIGO RELACIONADO

    public Pacientes(int DNI, String Nombre, String Domicilio, String Mail, String Sexo, int Edad,
            Peticiones[] peticionesPaciente) {
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.Domicilio = Domicilio;
        this.Mail = Mail;
        this.Sexo = Sexo;
        this.Edad = Edad;
    }

    public void eliminarPaciente() {
        DNI = 0;
        Nombre = "-";
        Domicilio = "-";
        Mail = "-";
        Sexo = "-";
        Edad = 0;
    }

    public int getDNI() {
        return this.DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
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

    public String getMail() {
        return this.Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    public String getSexo() {
        return this.Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public int getEdad() {
        return this.Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

}