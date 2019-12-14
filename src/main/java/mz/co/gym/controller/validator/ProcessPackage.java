package mz.co.gym.controller.validator;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import mz.co.gym.models.PaymentEntity;
import mz.co.gym.models.PaymentMethod;

@Component
public class ProcessPackage implements ProcessPayment {

	@Override
	public PaymentEntity process(PaymentEntity paymentEntity) {
		if (paymentEntity.getPaymentMethod().equals(PaymentMethod.Familiar)) {
			paymentEntity.setAmount(new BigDecimal(1000));

		}

		return paymentEntity;
	}

}
