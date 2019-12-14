package mz.co.gym.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import mz.co.gym.models.CustomerEntity;
import mz.co.gym.models.PaymentEntity;
import mz.co.gym.repositories.PaymentRepository;

@Service
public class PaymentService implements IPaymentService {

	private static final long serialVersionUID = 1L;
	private static final Sort SORT_BY_NAME = new Sort("nomeCompleto");

	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public List<PaymentEntity> findAllValidatePayment(LocalDate now) {
		return paymentRepository.findAllValidatePayment(now);
	}

	@Override
	public List<PaymentEntity> findAllInspiredPayment(LocalDate now) {
		return paymentRepository.findAllInspiredPayment(now);
	}

	@Override
	public List<PaymentEntity> findPaymentByCustomer(CustomerEntity customer) {
		return paymentRepository.findPaymentByCustomer(customer);
	}

	@Override
	public PaymentEntity inactivar(PaymentEntity paEntity) {
		paEntity.setActive(false);
		return paymentRepository.save(paEntity);
	}

	@Override
	public PaymentEntity findByid(Long id) {
		return paymentRepository.findOne(id);
	}

	@Override
	public List<PaymentEntity> findAll() {
		return paymentRepository.findAll(SORT_BY_NAME);
	}

	@Override
	public PaymentEntity save(PaymentEntity payment) {
		return paymentRepository.save(payment);
	}

	@Override
	public void delete(PaymentEntity payment) {
		paymentRepository.delete(payment);
	}

}
