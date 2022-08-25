import java.util.Scanner;

//Estudios que puede hacer el laboratorio
public class Practicas {
    public static void main(String[] args) {
        Practicas[] listaPracticas = new Practicas[40];
        crearPractica(listaPracticas);
    }

    private int Codigo;
    private String Nombre;
    private String Grupo;
    private int ValorCritico;
    private int ValorReservado;
    private String FechaEstimadaFinalizacion;

    public Practicas(int Codigo, String Nombre, String Grupo, int ValorCritico, int ValorReservado,
            String FechaEstimadaFinalizacion) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Grupo = Grupo;
        this.ValorCritico = ValorCritico;
        this.ValorReservado = ValorReservado;
        this.FechaEstimadaFinalizacion = FechaEstimadaFinalizacion;
    }

    public static void crearPractica(Practicas[] listaPracticas) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el CODIGO deseado para asignarle a la practica:");
        System.out.println("");
        int Codigo = Integer.parseInt(sc.nextLine());
        System.out.println("");

        System.out.println("Ingrese el NOMBRE deseado para asignarle a la practica");
        System.out.println("");
        String Nombre = sc.nextLine();
        System.out.println("");

        String Grupo = "Grupo 3";

        System.out.println("Ingrese el VALOR critico deseado para asignarle a la practica");
        System.out.println("");
        int ValorCritico = Integer.parseInt(sc.nextLine());
        System.out.println("");

        System.out.println("Ingrese el VALOR RESERVADO deseado para asignarle a la practica");
        System.out.println("");
        int ValorReservado = Integer.parseInt(sc.nextLine());
        System.out.println("");

        System.out.println("Ingrese la FECHA DE FINALIZACION ESPERADA (use el formato XX/XX/XXXX) de la practica");
        System.out.println("");
        String FechaEstimadaFinalizacion = sc.nextLine();
        System.out.println("");

        listaPracticas[0] = new Practicas(Codigo, Nombre, Grupo, ValorCritico, ValorReservado,
                FechaEstimadaFinalizacion);
        System.out.println(listaPracticas[0].Codigo);
        sc.close();
    }

    public int getCodigo() {
        return this.Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getGrupo() {
        return this.Grupo;
    }

    public void setGrupo(String Grupo) {
        this.Grupo = Grupo;
    }

    public int getValorCritico() {
        return this.ValorCritico;
    }

    public void setValorCritico(int ValorCritico) {
        this.ValorCritico = ValorCritico;
    }

    public int getValorReservado() {
        return this.ValorReservado;
    }

    public void setValorReservado(int ValorReservado) {
        this.ValorReservado = ValorReservado;
    }

    public String getFechaEstimadaFinalizacion() {
        return this.FechaEstimadaFinalizacion;
    }

    public void setFechaEstimadaFinalizacion(String FechaEstimadaFinalizacion) {
        this.FechaEstimadaFinalizacion = FechaEstimadaFinalizacion;
    }

}