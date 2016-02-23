package org.colega.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.sql.DataSource;

import org.colega.modelo.entidades.Colega;





public class MySqlColegasDao implements ColegasDao {
	
	
	
	private static final String INSERT_COLEGA = "INSERT INTO colega (id,nombre,calle,fecha) "
			+ "VALUES (?,?,?,?)"; 
	
	
	private static final String UPDATE_COLEGA = "UPDATE colega " + "SET id=?,nombre =?,calle=?, fecha=? "
			+ "WHERE colega=? ";
	
	
	
	private static final String DELETE_COLEGA = "DELETE FROM colega " + "WHERE id=? ";
	
	
	private static final String SELECT_COLEGA = "SELECT* FROM colega";
	
	
	private static final String SELECT_COLEGA_BY_ID = "SELECT* " + "FROM colega " + "WHERE id=? ";
	
	
private DataSource ds;
	
	

	public MySqlColegasDao(DataSource ds) {
		super();
		this.ds = ds;
		
		
		
	}

	@Override
	public void nuevoColega(Colega colega) throws SQLException {
		
		// 1-Obtener la conexion
		Connection connection =null;
		//PASO A PASO
				Date fechaQueTengo =new Date();//Hoy utildate
				long milisegundosDesde1970=fechaQueTengo.getTime();
				java.sql.Date fechaQueQuiero= new java.sql.Date(milisegundosDesde1970);// para llegar al sqldate, 
																						//QUE ES lo que quiero y lo que pide setDate
				
				
				
				
				// 1-Obtener la conexion
					
						try {
							connection = ds.getConnection();
							// 2- Obtener el statement
							PreparedStatement ps = connection.prepareStatement(INSERT_COLEGA);
							ps.setInt(1, colega.getId());
							ps.setString(2, colega.getNombre());
							ps.setString(3, colega.getCalle());
							ps.setDate(4, new java.sql.Date(colega.getFecha().getTime()));
							
							// 3-Ejecutar la sentencia
							ps.executeUpdate();
							// 4- (opcional solo cuando sea una sentencia de tipo executeQuery)
							// procesado de los resultados.
						} finally {
							// 5-cerrar la conexion
							if (connection != null) {
								connection.close();
							}

						}
						

					}

			


	

	@Override
	public void actualizarColega(Colega colega) throws SQLException {
		// 1-Obtener la conexion
		Connection connection = null;
		try {
			connection = ds.getConnection();
			// 2- Obtener el statement
			PreparedStatement ps = connection.prepareStatement(UPDATE_COLEGA);
			ps.setInt(1, colega.getId());
			ps.setString(2, colega.getNombre());
			ps.setString(3, colega.getCalle());
			ps.setDate(4, new java.sql.Date(colega.getFecha().getTime()));
			
			
			// 3-Ejecutar la sentencia
			ps.executeUpdate();
			// 4- (opcional solo cuando sea una sentencia de tipo executeQuery)
			// procesado de los resultados.
		} finally {
			// 5-cerrar la conexion
			if (connection != null) {
				connection.close();
			}

		}

	}



	@Override
	public void borrarColega(int id) throws SQLException {
		// 1-Obtener la conexion
		Connection connection = null;
		try {
			connection = ds.getConnection();
			// 2- Obtener el statement
			PreparedStatement ps = connection.prepareStatement(DELETE_COLEGA);
			ps.setInt(1, id);

			// 3-Ejecutar la sentencia
			ps.executeUpdate();
			// 4- (opcional solo cuando sea una sentencia de tipo executeQuery)
			// procesado de los resultados.
		} finally {
			// 5-cerrar la conexion
			if (connection != null) {
				connection.close();
			}

		}

	}

	

	@Override
	public Collection<Colega> todosLosColegas() throws SQLException {
		Collection<Colega> resultado = new HashSet<>();

		Connection connection = null;
		try {
			connection = ds.getConnection();
			// 2- Obtener el statement
			PreparedStatement ps = connection.prepareStatement(SELECT_COLEGA);

			// 3-Ejecutar la sentencia
			ResultSet rs = ps.executeQuery();
			// 4- (opcional solo cuando sea una sentencia de tipo executeQuery)
			// procesado de los resultados.

			// me posiciono en el primero
			if (rs.first()) {

				// proceso el libro hasta que no haya siguiente

				do {

					// Procesar el libro

					Colega colega = new Colega( 
												
							rs.getInt("id"), rs.getString("nombre"),rs.getString("calle") ,rs.getDate("fecha"));
					resultado.add(colega);

				} while (rs.next());

			}

			return resultado;

		} finally {
			// 5-cerrar la conexion
			if (connection != null) {
				connection.close();
			}

		}

	}

	@Override
	public Colega consulta(int id) throws SQLException {
		

// 1-Obtener la conexion
		Connection connection = null;
		try {
			connection = ds.getConnection();
			// 2- Obtener el statement
			PreparedStatement ps = connection.prepareStatement(SELECT_COLEGA_BY_ID);
			ps.setInt(1, id);

			// 3-Ejecutar la sentencia
			ResultSet rs = ps.executeQuery();
			// 4- (opcional solo cuando sea una sentencia de tipo executeQuery)
			// procesado de los resultados.

			if (rs.first()) { // rs apunta al primer registro

				return new Colega( // este es el mapeo entre sql y java
						id, rs.getString("nombre"), rs.getString("fecha"), rs.getDate("fecha"));

			}

			return null;
		} finally {
			// 5-cerrar la conexion
			if (connection != null) {
				connection.close();
			}

		}

	}

	}
	


