package org.colega.persistencia;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;

import org.colega.modelo.entidades.Colega;


public class TestMySqlColegasDao {

	
		@Test
		public void test() {
			
			new Date ();
			
			//datos de entrada
			Colega colega = new Colega (455,"pedro", "granvia", new Date());
			
			
			//datos esperados de salida
			BasicDataSource  ds= new BasicDataSource();
			ds.setUrl("jdbc:mysql://localhost:3306/colegajdbc");//CADENA DE CONEXION
			ds.setUsername("root");
			ds.setPassword("root");
			ds.setDriverClassName("com.mysql.jdbc.Driver");
			
			//sut
			MySqlColegasDao sut = new MySqlColegasDao (ds);
			
			//ejecucion
			
			
					try {
						sut.nuevoColega(colega);
						Colega colegaObtenido = sut.consulta(colega.getId());
						
						//asertos
						assertEquals(colega,colegaObtenido);
						
						
					} catch (SQLException e) {
						
						e.printStackTrace();
						fail("se produce un SQLException y no debería" + e.getMessage());
					}
					
					
				
				}

			}
