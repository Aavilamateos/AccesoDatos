package ceu.dam.ad.examen.ej2services;

import ceu.dam.ad.examen.exceptions.AccessDatabaseException;
import ceu.dam.ad.examen.exceptions.InvalidParamException;
import ceu.dam.ad.examen.exceptions.NotFoundException;
import ceu.dam.ad.examen.modelo.Categoria;

public interface CategoriaService {

	/** Este servicio debe crear una categoría con el nombre indicado por parámetro. 
	 * Lo hará utilizando el DAO creado en el ejercicio anterior. 
	 * Devolverá un objeto categoría completo (con todos sus atributos llenos) que corresponderá a la categoría recién creada
	 * (puedes usar para ello también el DAO del ejercicio anterior para consultar la categoría).
	 * 
	 * Si el nombre de la categoría recibido es NULL, vacío o sólo tiene espacios, devolverá un InvalidParamException
	 * Si el nombre de la categoría recibido tiene una longitud mayor a 25 caracteres, devolverá un InvalidParamException
	 * Si hay algún error al conectar o trabajar con la bbdd, lanzará un AccessDataBaseException
	 */
	public Categoria crearCategoria(String nombre) throws InvalidParamException, AccessDatabaseException;


	
	
	/** Este servicio debe devolver una categoría que tenga el id indicado por parámetro. 
	 * Lo hará utilizando el DAO creado en el ejercicio anterior. 
	 * Devolverá un objeto categoría completo (con todos sus atributos llenos).
	 * 
	 * Si el id indicado es NULL, devolverá un InvalidParamException
	 * Si no existe una categoría con el id indicado, devolverá un NotFoundException
	 * Si hay algún error al conectar o trabajar con la bbdd, lanzará un AccessDataBaseException
	 */
	public Categoria consultarCategoria(Long id) throws InvalidParamException, NotFoundException, AccessDatabaseException;

	
	
}
