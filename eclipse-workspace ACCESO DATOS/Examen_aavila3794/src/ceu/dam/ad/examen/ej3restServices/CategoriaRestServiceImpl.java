package ceu.dam.ad.examen.ej3restServices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ceu.dam.ad.examen.ej2services.CategoriaServiceImpl;
import ceu.dam.ad.examen.exceptions.AccessDatabaseException;
import ceu.dam.ad.examen.exceptions.InvalidParamException;
import ceu.dam.ad.examen.exceptions.NotFoundException;
import ceu.dam.ad.examen.modelo.Categoria;

@RestController
public class CategoriaRestServiceImpl implements CategoriaRestService {
	private CategoriaServiceImpl cateService;
	private Categoria cate;

	@Override
	@PostMapping("/categoria")
	public Categoria crearCategoria(@RequestBody Categoria categoria)
			throws InvalidParamException, AccessDatabaseException {
		try {
			cateService = new CategoriaServiceImpl();
			
			if (categoria.getName() == null || categoria.getName().isEmpty() || categoria.getName().isBlank()
					|| categoria.getName().length() > 25) {
				throw new InvalidParamException(
						"El id indicado es null, está vacío, en blanco o es mayor a 25 caracteres");
			}
			cateService.crearCategoria(categoria.getName());
			cate = cateService.consultarCategoria(categoria.getId());
			return cate;
		} catch (Exception e) {
			throw new AccessDatabaseException("Ha habido un error en la BBDD");
		}
	}

	@Override
	@GetMapping("/categoria/{id}")
	public Categoria consultarCategoria(@PathVariable Long id)
			throws InvalidParamException, NotFoundException, AccessDatabaseException {
		cateService = new CategoriaServiceImpl();
		try {
			cate = cateService.consultarCategoria(id);

			if (id == null) {
				throw new InvalidParamException("El id indicado es null");
			}
			if (cate.getId() == null) {
				throw new NotFoundException("No se ha encontrado ninguna categoria con ese id");
			}
			return cate;
		} catch (Exception e) {
			throw new AccessDatabaseException("Ha habido un error en la BBDD");
		}
	}

}
