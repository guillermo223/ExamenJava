package org.colega.modelo.negocio;

import java.sql.SQLException;
import java.util.Collection;

import org.colega.modelo.entidades.Colega;
import org.colega.persistencia.ColegasDao;



public interface GestionColegas {
	
	
	
	
	
	
	public void darDeAltaUnNuevoColegaEnLaAplicacion(Colega colega);
	public void actualizarColegaEnLaAplicacion(Colega colega);
	public void borrarColegaEnLaAplicacion(int id);
	public Collection<Colega> visualizarTodosColegasEnLaAplicacion(Integer id);
	public Colega visualizarUnCandidatoPorIdEnLaAplicacion( int id);

}