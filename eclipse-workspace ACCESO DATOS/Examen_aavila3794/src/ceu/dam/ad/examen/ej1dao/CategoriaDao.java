package ceu.dam.ad.examen.ej1dao;

import java.sql.Connection;
import java.sql.SQLException;

import ceu.dam.ad.examen.modelo.Categoria;

public interface CategoriaDao {

	/** Inserta en la BBDD una nueva categoría con el nombre indicado que se recibe por parámetro. 
	 * Se debe insertar en la tabla "category". Las dos columnas restantes de la tabla (id y last_update)
	 * las completa automáticamente la bbdd. 
	 * 
	 * Tras la inserción, si todo ha ido bien, se debe devolver el ID de la categoría insertarda (el que ha
	 * generado la bbdd). Si por alguna razón no es puede obtener dicho ID, se lanzará SQLException.
	 * 
	 * La conexión a la bbdd deberá realizarse con el connection recibido por parámetro
	 * Si hay cualquier error con la BBDD se lanzará SQLException	 */
	public Long insertarCategoria(Connection conn, String nombreCategoria) throws SQLException;

	
	
	
	
	/** Consulta en la BBDD la categoría con el ID indicado que se recibe por parámetro. 
	 * Se debe consultar en la tabla "category", filtrando por el campo category_id. Se devolverá un objeto
	 * de la clase Categoria. El ID recibido no será NULL nunca (no hace falta comprobarlo).
	 * Si no existe ningún objeto con ese ID, se devolverá NULL
	 *  
	 * La conexión a la bbdd deberá realizarse con el connection recibido por parámetro
	 * Si hay cualquier error con la BBDD se lanzará SQLException	 */
	public Categoria consultarCategoria(Connection conn, Long id) throws SQLException;

	
}
