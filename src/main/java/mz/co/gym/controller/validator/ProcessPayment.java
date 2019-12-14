package mz.co.gym.controller.validator;

import mz.co.gym.models.PaymentEntity;

public interface ProcessPayment {

	public PaymentEntity process(PaymentEntity paymentEntity);

}
