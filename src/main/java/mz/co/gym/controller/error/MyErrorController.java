package mz.co.gym.controller.error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAdvice
public class MyErrorController implements ErrorController {

	private final static String ERROR_PATH = "/error";

	@RequestMapping("/error")
	public String handleError(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
		return String.format(
				"<html><body><h2>Error Page</h2><div>Status code: <b>%s</b></div>"
						+ "<div>Exception Message: <b>%s</b></div><body></html>",
				statusCode, exception == null ? "N/A" : exception.getMessage());
	}

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}
}
