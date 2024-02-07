package ceu.dam.ad.examen.ej2services;

import java.sql.Connection;
import java.sql.SQLException;

import ceu.dam.ad.examen.ej1dao.CategoriaDaoImpl;
import ceu.dam.ad.examen.exceptions.AccessDatabaseException;
import ceu.dam.ad.examen.exceptions.InvalidParamException;
import ceu.dam.ad.examen.exceptions.NotFoundException;
import ceu.dam.ad.examen.modelo.Categoria;


public class CategoriaServiceImpl implements CategoriaService {
	private OpenConnection openConnection;
	private CategoriaDaoImpl cateDao;
	private Categoria cate;
	
	public CategoriaServiceImpl() {
		openConnection = new OpenConnection();
		cateDao=new CategoriaDaoImpl();
		cate=new Categoria();
	}

	@Override
	public Categoria crearCategoria(String nombre) throws InvalidParamException, AccessDatabaseException {
		Connection conn = null;
		try {
			conn = openConnection.getConection();
			cate.setId(cateDao.insertarCategoria(conn, nombre));
			
			if (nombre == null) {
				throw new InvalidParamException("El nombre indicado es null");
			} else if (nombre.length()>25) {
				throw new InvalidParamException("El nombre es mayor a 25 caracteres");
			} else {
				return cate;
			}
		} catch (SQLException e) {
			System.out.println("Ha habido un error en la base de datos" + e.getMessage());
			e.printStackTrace();
			throw new AccessDatabaseException("Error al obtener la categoria de la base de datos", e);
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}

	@Override
	public Categoria consultarCategoria(Long id)
			throws InvalidParamException, NotFoundException, AccessDatabaseException {
		Connection conn = null;
		try {
			conn = openConnection.getConection();
			cate=cateDao.consultarCategoria(conn, id);
			if (id == null) {
				throw new InvalidParamException("El id indicado es null");
			} else if (cate.getId()==null) {
				throw new NotFoundException("No existe esa categoria");
			} else {
				return cate;
			}
		} catch (SQLException e) {
			System.out.println("Ha habido un error en la base de datos" + e.getMessage());
			e.printStackTrace();
			throw new AccessDatabaseException("Error al obtener la categoria de la base de datos", e);
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
		
	}


}
