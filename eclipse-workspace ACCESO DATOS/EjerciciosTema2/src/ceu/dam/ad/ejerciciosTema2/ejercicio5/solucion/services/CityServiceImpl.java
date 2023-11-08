package ceu.dam.ad.ejerciciosTema2.ejercicio5.solucion.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ceu.dam.ad.ejerciciosTema2.ejercicio5.solucion.dao.CityDao;
import ceu.dam.ad.ejerciciosTema2.ejercicio5.solucion.modelo.City;

@RestController
public class CityServiceImpl implements CityService{

	private OpenConnection openConn;
	private CityDao dao;
	
	public CityServiceImpl() {
		openConn = new OpenConnection();
		dao = new CityDao();
	}

	@Override
	@GetMapping("/city")
	public List<City> getCities(@RequestParam(required = false) String filtroDescripcion) throws NotFoundException, ServerErrorException {
		Connection conn = null;
		try {
			System.out.println("Consultando ciudades con filtro " + filtroDescripcion);
			conn = openConn.abrirConexion();
			if (filtroDescripcion == null) {
				filtroDescripcion = "";
			}
			List<City> ciudades = dao.buscarCiudades(conn, filtroDescripcion);
			if (ciudades.isEmpty()) {
				throw new NotFoundException("No se han encontrado ciudades con los filtros indicados");
			}
			return ciudades;
		}
		catch(SQLException e) {
			System.err.println("Error consultando ciudades");
			e.printStackTrace();
			throw new ServerErrorException("Error consultando ciudades");
		}
		finally {
			try {
				conn.close();
			}
			catch(Exception ignore) {}
		}
	}

	@Override
	@GetMapping("/city/{id}")
	public City getCity(@PathVariable Long id) throws NotFoundException, ServerErrorException {
		Connection conn = null;
		try {
			System.out.println("Consultando ciudad con id " + id);
			conn = openConn.abrirConexion();
			City ciudad = dao.consultarCiudad(conn, id);
			if (ciudad == null) {
				throw new NotFoundException("No se ha encontrado la ciudad con id " + id);
			}
			return ciudad;
		}
		catch(SQLException e) {
			System.err.println("Error consultando ciudad");
			e.printStackTrace();
			throw new ServerErrorException("Error consultando ciudad");
		}
		finally {
			try {
				conn.close();
			}
			catch(Exception ignore) {}
		}
	}

	@Override
	@PostMapping("/city")
	public City createCity(@RequestBody City city) throws ServerErrorException {
		Connection conn = null;
		try {
			System.out.println("Creando ciudad " + city);
			conn = openConn.abrirConexion();
			dao.insertarCiudad(conn, city);
			return city;
		}
		catch(SQLException e) {
			System.err.println("Error creando ciudad");
			e.printStackTrace();
			throw new ServerErrorException("Error creando ciudad");
		}
		finally {
			try {
				conn.close();
			}
			catch(Exception ignore) {}
		}
	}

	@Override
	@PutMapping("/city")
	public void updateCity(@RequestBody City city) throws NotFoundException, ServerErrorException {
		Connection conn = null;
		try {
			System.out.println("Actualizando ciudad " + city);
			conn = openConn.abrirConexion();
			Integer numActualizados = dao.updateCiudad(conn, city);
			if (numActualizados == 0) {
				throw new NotFoundException("No se ha podido borrar la ciudad con id " + city.getId());
			}
		}
		catch(SQLException e) {
			System.err.println("Error actualizando ciudad");
			e.printStackTrace();
			throw new ServerErrorException("Error actualizando ciudad");
		}
		finally {
			try {
				conn.close();
			}
			catch(Exception ignore) {}
		}
	}

	@Override
	@PatchMapping("/city")
	public City updateSelectiveCity(@RequestBody City city) throws NotFoundException, ServerErrorException {
		Connection conn = null;
		try {
			System.out.println("Actualizando ciudad (selectivo) " + city);
			if (city.getCountryId() != null && city.getDescripcion()!=null) {
				updateCity(city); // si vienen todos los datos, actualizamos normal
				return city; // y devolvemos la misma ciudad porque ya tiene todos los datos completos
			}
			
			conn = openConn.abrirConexion();
			if (city.getCountryId() != null || city.getDescripcion()!=null) {
				Integer numActualizados = dao.updateSelectivoCiudad(conn, city);
				if (numActualizados == 0) {
					throw new NotFoundException("No se ha podido borrar la ciudad con id " + city.getId());
				}
			}
			City ciudad = dao.consultarCiudad(conn, city.getId());
			return ciudad;
		}
		catch(SQLException e) {
			System.err.println("Error actualizando ciudad");
			e.printStackTrace();
			throw new ServerErrorException("Error actualizando ciudad");
		}
		finally {
			try {
				conn.close();
			}
			catch(Exception ignore) {}
		}
	}

	@Override
	@DeleteMapping("/city/{id}")
	public void deleteCity(@PathVariable Long id) throws NotFoundException, ServerErrorException {
		Connection conn = null;
		try {
			System.out.println("Borrando ciudad con id " + id);
			conn = openConn.abrirConexion();
			Integer numActualizados = dao.deleteCiudad(conn, id);
			if (numActualizados == 0) {
				throw new NotFoundException("No se ha podido borrar la ciudad con id " + id);
			}
		}
		catch(SQLException e) {
			System.err.println("Error borrando ciudad");
			e.printStackTrace();
			throw new ServerErrorException("Error borrando ciudad");
		}
		finally {
			try {
				conn.close();
			}
			catch(Exception ignore) {}
		}
	}

}
