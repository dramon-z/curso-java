package mx.gob.tabasco.seguro.repositories;

import mx.gob.tabasco.seguro.entities.Usuario;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Integer> {

	public Usuario getByUsuarioAndPassword(String usuario, String password);

}
