package org.colega.persistencia;

import java.sql.SQLException;
import java.util.Collection;

import org.colega.modelo.entidades.Colega;

public interface ColegasDao {
	
	//insercion de un colega
	void nuevoColega (Colega colega) throws SQLException;
	
	//actualizacion de un coolega
	void actualizarColega (Colega colega) throws SQLException;
	
	//borrar colega
	void borrarColega (int id) throws SQLException;
	
	
	//visualizacion todos
	Collection<Colega> todosLosColegas() throws SQLException;
	
	
	//visualizacion de uno
	Colega consulta (int id) throws SQLException;
	
	

}
