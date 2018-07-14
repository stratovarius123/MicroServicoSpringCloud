package br.com.VeigarMensageria.veigar.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.VeigarMensageria.veigar.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{ 

	@Query("select case when count(u) > 0 then true else false end from Usuario u where u.email = :email")
	boolean isEmailUserExist(@Param("email") String email);
	
	Usuario findByEmail(String email);
	
	Optional<Usuario> findById(Integer id);
}
