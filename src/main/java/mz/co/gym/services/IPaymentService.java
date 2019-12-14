package mz.co.gym.services;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import mz.co.gym.models.CustomerEntity;
import mz.co.gym.models.PaymentEntity;

public interface IPaymentService extends Serializable {

	PaymentEntity findByid(Long id);
	
	PaymentEntity save(PaymentEntity payment);

	void delete(PaymentEntity payment);

	List<PaymentEntity> findAll();

	List<PaymentEntity> findAllValidatePayment(LocalDate now);

	List<PaymentEntity> findAllInspiredPayment(LocalDate now);

	List<PaymentEntity> findPaymentByCustomer(CustomerEntity customer);

	PaymentEntity inactivar(PaymentEntity customer);

}
