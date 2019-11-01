package mz.co.gym.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mz.co.gym.models.PaymentEntity;
@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
	
	List<PaymentEntity> findAllByOrderByPaymentdateDesc();


}
