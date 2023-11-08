package ejerciciosPracticos.ej5.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
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

import ejerciciosPracticos.ej5.dao.CityDao;
import ejerciciosPracticos.ej5.db.OpenConnection;
import ejerciciosPracticos.ej5.exception.NotFoundException;
import ejerciciosPracticos.ej5.exception.ServerErrorException;
import ejerciciosPracticos.ej5.modelo.City;

@RestController
public class CityServiceImp implements CityService {

	private CityDao cityDao;
	private OpenConnection openConnection;
	private City city2;

	public CityServiceImp() {
		openConnection = new OpenConnection();
	}

	@Override
	@GetMapping("/city")
	public List<City> getCities(@RequestParam String filtroDescripcion) throws NotFoundException, ServerErrorException {
		List<City> listaCiudadConDesc = new ArrayList<City>();
		Connection conn = null;
		try {
			conn = openConnection.getConection();
			if (filtroDescripcion==null) {
				filtroDescripcion="";
			}
			cityDao = new CityDao();
			listaCiudadConDesc = cityDao.getCities(conn, filtroDescripcion);
			if (listaCiudadConDesc.isEmpty()) {
				throw new NotFoundException("No se han encontrado coincidencias en la bbdd");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new ServerErrorException("Error consultando ciudades ", e);
			
		} finally {
			try {
				conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return listaCiudadConDesc;

	}

	@Override
	@GetMapping("/city/{id}")
	public City getCity(@PathVariable Long id) throws NotFoundException {
		Connection conn = null;
		city2 = new City();
		try {
			conn = openConnection.getConection();
			cityDao = new CityDao();
			city2 = cityDao.getCity(conn, id);
			if (city2.getId() == null) {
				throw new NotFoundException("El id de la ciudad es null");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new NotFoundException("El id de la ciudad es null", e);

		} finally {
			try {
				conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

		return city2;
	}

	@Override
	@PostMapping("/city")
	public City createCity(@RequestBody City city) throws ServerErrorException {
		Connection conn = null;
		try {
			conn = openConnection.getConection();
			cityDao = new CityDao();
			cityDao.createCity(conn, city);
			return city;
		} catch (Exception e) {
			throw new ServerErrorException("", e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	@PutMapping("/city")
	public void updateCity(@RequestBody City city) throws NotFoundException {
		Connection conn = null;
		try {
			conn = openConnection.getConection();
			cityDao = new CityDao();
			cityDao.updateCity(conn, city);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	@PatchMapping("/city")
	public City updateSelectiveCity(@RequestBody City city) throws NotFoundException {
		Connection conn = null;
		try {
			conn = openConnection.getConection();
			cityDao = new CityDao();
			city = cityDao.updateSelectiveCity(conn, city);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return city;
	}

	@Override
	@DeleteMapping("/city/{id}")
	public void deleteCity(@PathVariable Long id) throws NotFoundException {
		Connection conn = null;
		try {
			conn = openConnection.getConection();
			cityDao = new CityDao();
			cityDao.deleteCity(conn, id);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
}
