public class Paciente {
    private int dni = 44;
    private String nombre;
    private String domicilio;
    private String mail;
    private String sexo;
    private int edad;

    public int getdni() {
        int dni = this.dni;
        return dni;
    }

    public static void main(String args[]) {
        Paciente zero = new Paciente();
        System.out.println(zero.getdni());
    }
}