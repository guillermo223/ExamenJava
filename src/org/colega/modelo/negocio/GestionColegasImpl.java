package org.colega.modelo.negocio;

import java.sql.SQLException;
import java.util.Collection;

import org.colega.modelo.entidades.Colega;

import org.colega.persistencia.ColegasDao;

public class GestionColegasImpl implements GestionColegas {

	
	private ColegasDao colegaDao;
	
	
	
	public GestionColegasImpl(ColegasDao colegaDao) {
		super();
		this.colegaDao = colegaDao;
	}
	
	
	
	
	

	

	@Override
	public void darDeAltaUnNuevoColegaEnLaAplicacion(Colega colega) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizarColegaEnLaAplicacion(Colega colega) {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrarColegaEnLaAplicacion(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<Colega> visualizarTodosColegasEnLaAplicacion(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Colega visualizarUnCandidatoPorIdEnLaAplicacion(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
