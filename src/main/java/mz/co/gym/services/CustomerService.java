package mz.co.gym.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import mz.co.gym.models.CustomerEntity;
import mz.co.gym.repositories.CustomerRepository;

@Service
public class CustomerService implements ICustomerService {
	private static final long serialVersionUID = 1L;

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public CustomerEntity findByNomeCompleto(String nomeCompleto) {
		return customerRepository.findByNomeCompleto(nomeCompleto);
	}

	@Override
	public List<CustomerEntity> findAllByOrderByNomeCompletoDesc() {
		return customerRepository.findAllByOrderByNomeCompletoDesc();
	}

	@Override
	public CustomerEntity findById(Long id) {
		return customerRepository.findOne(id);
	}

	@Override
	public List<CustomerEntity> findAll() {
		return customerRepository.findAll(new Sort("nomeCompleto"));
	}

	@Override
	public CustomerEntity save(CustomerEntity customer) {
		return customerRepository.save(customer);
	}

	@Override
	public void delete(Long id) {
		customerRepository.delete(id);
	}

	@Override
	public CustomerEntity inactive(CustomerEntity customer) {
		customer.setActive(false);
		return save(customer);
	}

	@Override
	public Long count() {
		return customerRepository.count();
	}

}
