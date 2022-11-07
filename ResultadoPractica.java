public class ResultadoPractica {
    private tipoReserva confidencialidad;
}

public class ResultadoPracticaCritico extends ResultadoPractica{
    private float resultado;
}

public class ResultadoPracticaBooleano extends ResultadoPractica{
    private boolean valorResultado;
}

public class ResultadoPracticaCadena extends ResultadoPractica{
    private String valorResultado;
    private boolean  mostrarValorCritico;
}