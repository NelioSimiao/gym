package mz.co.gym.services;

import java.io.Serializable;
import java.util.List;

import mz.co.gym.models.CustomerEntity;

public interface ICustomerService extends Serializable {

	CustomerEntity save(CustomerEntity customer);

	void delete(Long id);

	CustomerEntity inactive(CustomerEntity customer);

	List<CustomerEntity> findAll();

	CustomerEntity findById(Long id);

	Long count();

	CustomerEntity findByNomeCompleto(String nomeCompleto);

	List<CustomerEntity> findAllByOrderByNomeCompletoDesc();

}
