package mz.co.gym.controller.validator;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import mz.co.gym.models.PaymentEntity;
import mz.co.gym.models.PaymentType;

@Component
public class ProcessPaymentType implements ProcessPayment {

	@Override
	public PaymentEntity process(PaymentEntity payment) {

		if ((payment.getPaymentType().equals(PaymentType.Semanal))) {

			payment.setLastDayOfValidPaymentDate(payment.getInitialDate().plusDays(8));
			payment.setAmount(new BigDecimal(750));

		}
		if (payment.getPaymentType().equals(PaymentType.Quizenal)) {
			payment.setLastDayOfValidPaymentDate(payment.getInitialDate().plusDays(16));
			payment.setAmount(new BigDecimal(750));

		}
		if (payment.getPaymentType().equals(PaymentType.Mensal)) {
			payment.setLastDayOfValidPaymentDate(payment.getInitialDate().plusDays(30));
			payment.setAmount(new BigDecimal(1250));

		}

		return payment;
	}

}
