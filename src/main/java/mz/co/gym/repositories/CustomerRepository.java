package mz.co.gym.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mz.co.gym.models.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
	
	CustomerEntity findByNomeCompleto(String nomeCompleto);
	
	List<CustomerEntity> findAllByOrderByNomeCompletoDesc();
}
