package ceu.dam.service;

import org.hibernate.Session;

import ceu.dam.jpa.HibernateUtil;
import ceu.dam.modelo.Equipo;
import ceu.dam.modelo.Estadio;
import jakarta.persistence.PersistenceException;

public class EquipoService {

	public void insertarEquipo(Equipo equipo) {

		Session session = null;
		try {
			session = HibernateUtil.getSessionFactoy().openSession();
			session.getTransaction().begin();
			//aqui hacemos la insercion
			session.persist(equipo);
			session.getTransaction().commit();
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			//aqui vemos que hacemos con la excepcion
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}
	public void actualizarEquipo(Equipo equipo) {
		Session session=null;
		try {
			session=HibernateUtil.getSessionFactoy().openSession();
			session.getTransaction().begin();
			session.merge(equipo);
			session.getTransaction().commit();
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			throw e;
		}finally {
			if (session != null) {
				session.close();
			}
		}
	}
	public void eliminarEquipo(Equipo equipo) {
		Session session=null;
		try {
			session=HibernateUtil.getSessionFactoy().openSession();
			session.getTransaction().begin();
			session.remove(equipo);
			session.getTransaction().commit();
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			throw e;
		}finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Equipo consultarEquipo(Long id) {
		Session session=null;
		try {
			
			session=HibernateUtil.getSessionFactoy().openSession();
			Equipo e1=session.get(Equipo.class, id);
			return e1;
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			throw e;
		}finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public Estadio consultarEstadio(Long id) {
		Session session=null;
		try {
			
			session=HibernateUtil.getSessionFactoy().openSession();
			Estadio e1=session.get(Estadio.class, id);
			return e1;
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			throw e;
		}finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
