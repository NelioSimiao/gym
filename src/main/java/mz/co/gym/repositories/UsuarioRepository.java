package  mz.co.gym.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mz.co.gym.models.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

Usuario findByLogin(String login);
	
}
