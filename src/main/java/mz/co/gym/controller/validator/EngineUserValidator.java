package mz.co.gym.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import mz.co.gym.models.Usuario;
@Component
public class EngineUserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Usuario.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "usuario.nome");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "usuario.nome");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "senha", "usuario.senha");
	}

}
