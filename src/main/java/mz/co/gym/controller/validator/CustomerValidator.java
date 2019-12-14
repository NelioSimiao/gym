package mz.co.gym.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import mz.co.gym.models.CustomerEntity;

@Component
public class CustomerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return CustomerEntity.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors err) {
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "nomeCompleto", "name.nomeCompleto");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "dataDeInscricao", "name.initialDate");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "numeroBI", "numeroBI.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "naturalDe", "naturalDe.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "profissao", "profissao.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "contacto", "contacto.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "email", "email.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "residencia", "residencia.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "localDeTrabalho", "localDeTrabalho.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "dataDeNascimento", "dataDeNascimento.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "dataDeInicio", "dataDeInicio.empty");

	}

}
