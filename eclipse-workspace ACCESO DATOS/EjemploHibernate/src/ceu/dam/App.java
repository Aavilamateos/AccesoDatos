package ceu.dam;

import java.util.ArrayList;
import java.util.List;

import ceu.dam.modelo.Equipo;
import ceu.dam.modelo.Estadio;
import ceu.dam.modelo.Jugador;
import ceu.dam.modelo.Socio;
import ceu.dam.service.EquipoService;

public class App {

	public static void main(String[] args) {
	Equipo e =new Equipo();
	Socio s=new Socio();
	EquipoService service=new EquipoService();
	List<Socio>socios=new ArrayList<Socio>();
	s.setNombre("AbelSoft");
	e.setSocios(socios);
	e.getSocios().add(s);
	e.setNombre("Abelinos");
	e.setNumJugadores(18);
	Estadio estadio=new Estadio();
	estadio.setNombre("Abel Metropolitano");
	estadio.setDireccion("Calle Antropofilosofía nºInformática" );
	e.setEstadio(estadio);
	List<Jugador>jugadores=new ArrayList<Jugador>();
	for (int i = 0; i < e.getNumJugadores(); i++) {
		Jugador j=new Jugador();
		j.setCodigo("E"+i);
		j.setDorsal(10+1);
		j.setEquipo(e);
		j.setNombre("Abel "+i+" EY");
		j.setPosicion("P"+i);
		jugadores.add(j);
	}
	e.setJugadores(jugadores);
	service.insertarEquipo(e);
	}

}
