package ceufct.test;

import java.math.BigDecimal;
import java.time.LocalDate;

import ceufct.exception.UsuariosServiceException;
import ceufct.modelo.Registro;
import ceufct.modelo.Usuario;
import ceufct.service.FechasService;
import ceufct.service.RegistrosService;
import ceufct.service.UsuariosService;

public class App {
	public static void main(String[] args) throws UsuariosServiceException {

		Usuario u1 = new Usuario();
		Registro r1 = new Registro();
		UsuariosService usuService = new UsuariosService();
		RegistrosService regisService = new RegistrosService();
		FechasService fechaService = new FechasService();
		try {
			u1.setNombre("Alberto");
			u1.setApellidos("Avila Mateos");
			u1.setEmail("albertoavilamateos00@gmail.com");
			u1.setPassword("Funciona");
			u1.setCiclo("DAM");
			r1.setDescripcion("Programacion java");
			r1.setFecha(LocalDate.now());
			r1.setNum_horas(new BigDecimal(5));
			usuService.altaUsuario(u1);
			System.out.println(u1);
			r1.setId_usuario(u1.getId_usuario());
			System.out.println(r1);
			regisService.insertarRegistro(r1);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
