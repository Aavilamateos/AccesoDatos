package ejemplo1dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ejemplo1modelo.Actor;

public class ActoresDao {

	public List<Actor> consultarActores(Connection conn) throws SQLException{
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			List<Actor> listActores = new ArrayList<Actor>();
			String sql = "SELECT * FROM ACTOR";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {

				Actor actor = new Actor();

				actor.setId(rs.getInt("actor_id"));

				actor.setNombre(rs.getString("first_name"));

				actor.setApellidos(rs.getString("last_name"));

				listActores.add(actor);
			}
			
			return listActores;
			
		} 
		finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
			
	}
}}
