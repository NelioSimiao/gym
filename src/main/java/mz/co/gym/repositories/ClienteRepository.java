package mz.co.gym.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mz.co.gym.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	Cliente findByNomeCompleto(String nomeCompleto);
	List<Cliente> findAllByOrderByNomeCompletoDesc();

}
