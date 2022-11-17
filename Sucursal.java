public class Sucursal {
    private int idSucursal;
    private String direccion;
    private Usuario respTecnico;

    public Sucursal() {
    }

    public Sucursal(int idSucursal, String direccion, Usuario respTecnico) {
        this.idSucursal = idSucursal;
        this.direccion = direccion;
        this.respTecnico = respTecnico;
    }

    public int getIdSucursal() {
        return this.idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Usuario getRespTecnico() {
        return this.respTecnico;
    }

    public void setRespTecnico(Usuario respTecnico) {
        this.respTecnico = respTecnico;
    }

}
