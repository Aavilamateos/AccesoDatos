package ceu.dam.ad.ejerciciosTema2.ejercicio5.enunciado.services;

import java.util.List;

import ceu.dam.ad.ejerciciosTema2.ejercicio5.enunciado.modelo.City;

public interface CityService { 

	/** Devuelve la lista de ciudades de la bbdd filtrando por la descripcián indicada. 
	 * - El filtro se debe aplicar como un contiene. Es decir, si se filtra por 
	 *   "ara", resultados válidos seráan: "arak", "okara", "caracas", etc.
	 * - Se debe invocar mediante un GET a la URL /city?filtroDescripcion=valor 
	 * - El parámetro filtroDescripcián es opcional. Si no llega, no se aplicará filtro.
	 * - Tendrá que devolver un 404 si la lista de resultados es vacáa
	 * - Si hay cualquier error, lanzará un 500
	 * @param filtroDescripcion - El parámetro se pasará con este nombre 
	 * @return
	 * @throws NotFoundException, ServerErrorException
	 */
	public List<City> getCities(String filtroDescripcion) throws NotFoundException, ServerErrorException;
	
	
	
	
	
	/** Devuelve la ciudad con el id indicado. 
	 * - Se debe invocar mediante un GET a la URL /city/id (siendo "id" el parámetro) 
	 * - Tendrá que devolver un 404 si no existe ciudad con ese id
	 * - Si hay cualquier error, lanzará un 500
	 * @param id - formará parte de la URL
	 * @return
	 * @throws NotFoundException, ServerErrorException
	 */
	public City getCity(Long id) throws NotFoundException, ServerErrorException;
	
	
	
	
	/** Creará en base de datos la ciudad indicada por parámetro. Despuás
	 * devolverá esa ciudad como respuesta.
	 * - Se debe invocar mediante un POST a la URL /city
	 * - El parámetro city vendrá en body de la peticián
	 * - Si hay cualquier error, lanzará un 500
	 * @param city
	 * @return ServerErrorException
	 */
	public City createCity(City city) throws ServerErrorException;
	
	
	
	
	
	/** Actualizará en base de datos la ciudad indicada por parámetro. 
	 * Actualizará todos los valores que lleguen en el objeto, aunque están a null
	 * - Se debe invocar mediante un PUT a la URL /city
	 * - El parámetro city vendrá en body de la peticián
	 * - Tendrá que devolver un 404 si no existe ciudad con ese id
	 * - Si hay cualquier error, lanzará un 500
	 * @param city
	 * @throws NotFoundException, ServerErrorException
	 */
	public void updateCity(City city) throws NotFoundException, ServerErrorException;
	
	
	
	
	/** Actualizará en base de datos la ciudad indicada por parámetro. 
	 * Actualizará sálo los valores que lleguen informados en el objeto, es decir,
	 * los atributos que vengan a NULL, no se actualizan 
	 * - Se debe invocar mediante un PATCH a la URL /city
	 * - El parámetro city vendrá en body de la peticián
	 * - Tendrá que devolver un 404 si no existe ciudad con ese id
	 * - Si la actualizacián es correcta, devolverá el objeto city actualizado y completo
	 * - Si hay cualquier error, lanzará un 500
	 * @param city
	 * @return
	 * @throws NotFoundException, ServerErrorException
	 */
	public City updateSelectiveCity(City city) throws NotFoundException, ServerErrorException;

	
	
	
	
	/** Borrará en base de datos la ciudad indicada por parámetro. 
	 * - Se debe invocar mediante un DELETE a la URL /city/id (siendo "id" el parámetro)
	 * - Tendrá que devolver un 404 si no existe ciudad con ese id
	 * - Si hay cualquier error, lanzará un 500
	 * @param id
	 * @throws NotFoundException, ServerErrorException
	 */
	public void deleteCity(Long id) throws NotFoundException, ServerErrorException;
	
}
