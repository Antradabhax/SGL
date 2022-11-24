package dto;

import clases.Usuario;

public class SucursalDto {
    private int idSucursal;
    private String direccion;
    private int respTecnico;

    public SucursalDto() {
    }

    public SucursalDto(int idSucursal, String direccion, int respTecnico) {
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

    public int getRespTecnico() {
        return this.respTecnico;
    }

    public void setRespTecnico(int respTecnico) {
        this.respTecnico = respTecnico;
    }

}
