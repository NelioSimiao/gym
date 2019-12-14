package mz.co.gym.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mz.co.gym.models.CustomerEntity;
import mz.co.gym.models.PaymentEntity;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

	@Query("select p from PaymentEntity p where p.lastDayOfValidPaymentDate >=:now  and p.active=true")
	List<PaymentEntity> findAllValidatePayment(@Param("now") LocalDate now);

	@Query("select p from PaymentEntity p where p.lastDayOfValidPaymentDate <=:now ")
	List<PaymentEntity> findAllInspiredPayment(@Param("now") LocalDate now);
	
	@Query("select p from PaymentEntity p where p.customer =:customer ")
	List<PaymentEntity>  findPaymentByCustomer(@Param("customer") CustomerEntity customer);
	


}
