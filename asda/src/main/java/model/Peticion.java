package model;

import java.util.ArrayList;
import java.util.List;

import com.kiuwan.client.model.Application;
import com.kiuwan.client.model.management.users.UserBean;

public class Peticion {
	private List<Aplicacion> listAplicaciones = new ArrayList<Aplicacion>();
	private List<Usuario> listUsuarios = new ArrayList<Usuario>();
	
	public Peticion() {
		super();
	}

	public List<Aplicacion> getListAplicaciones() {
		return listAplicaciones;
	}

	public void setListAplicaciones(List<Aplicacion> listAplicaciones) {
		this.listAplicaciones = listAplicaciones;
	}

	public List<Usuario> getListUsuarios() {
		return listUsuarios;
	}

	public void setListUsuarios(List<Usuario> listUsuarios) {
		this.listUsuarios = listUsuarios;
	}



	
	
	
	
	
}
