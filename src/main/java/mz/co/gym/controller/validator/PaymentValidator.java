package mz.co.gym.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import mz.co.gym.models.PaymentEntity;

@Component
public class PaymentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return PaymentEntity.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors err) {
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "initialDate", "payment.initialDate");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "paymentType", "payment.paymentType");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "paymentMethod", "payment.paymentMethod");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "customer", "payment.customer");
	}

}
