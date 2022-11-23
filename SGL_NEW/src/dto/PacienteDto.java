package dto;


public class PacienteDto {
    private int dni;
    private String nombre;
    private String domicilio;
    private String mail;
    private String sexo;
    private int edad;
    private SucursalDto sucursalPeticion;
    private SucursalDto sucursalRetiro;

    public PacienteDto() {
    }

    public PacienteDto(int dni, String nombre, String domicilio, String mail, String sexo, int edad, SucursalDto sucursalPeticion, SucursalDto sucursalRetiro) {
        this.dni = dni;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.mail = mail;
        this.sexo = sexo;
        this.edad = edad;
        this.sucursalPeticion = sucursalPeticion;
        this.sucursalRetiro = sucursalRetiro;
    }

    public SucursalDto getSucursalPeticion() {
        return this.sucursalPeticion;
    }

    public void setSucursalPeticion(SucursalDto sucursalPeticion) {
        this.sucursalPeticion = sucursalPeticion;
    }

    public SucursalDto getSucursalRetiro() {
        return this.sucursalRetiro;
    }

    public void setSucursalRetiro(SucursalDto sucursalRetiro) {
        this.sucursalRetiro = sucursalRetiro;
    }

    public int getDni() {
        return this.dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return this.domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
