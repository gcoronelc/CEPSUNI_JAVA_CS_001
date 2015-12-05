package pe.ld.ventas.dto;

import pe.ld.ventas.entity.Empleado;

public class LogonDto {

	private String usuario;
	private String clave;

	public LogonDto() {
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
