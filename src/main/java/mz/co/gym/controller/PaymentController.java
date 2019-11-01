package mz.co.gym.controller;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mz.co.gym.models.CustomerEntity;
import mz.co.gym.models.PaymentEntity;
import mz.co.gym.models.PaymentType;
import mz.co.gym.repositories.CustomerRepository;
import mz.co.gym.repositories.PaymentRepository;

@Controller
@RequestMapping("/payments")
public class PaymentController {
	private static final String PAGE_PAYMENTS = "payments/payments";
	private static final String PAGE_PAYMENT_REGISTER = "payments/payments-form";
	private static final String REDIRECT_PAGINA_CLIENTES = "redirect:/payments";


	private static final Sort SORT_BY_DATE = new Sort("paymentdate");
	private final PaymentRepository paymentRepository;

	private final CustomerRepository customerRepository;

	public PaymentController(PaymentRepository paymentRepository, CustomerRepository customerRepository) {
		this.paymentRepository = paymentRepository;
		this.customerRepository = customerRepository;
	}

	/**
	 * For register the payment
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("paymentTypes", PaymentType.values());
		model.addAttribute("customers", customerRepository.findAll(new Sort("nomeCompleto")));
		model.addAttribute("payment", new PaymentEntity());
		return PAGE_PAYMENT_REGISTER;
	}

	/**
	 * Get all payment
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping
	public String listAll(Model model) {
		List<PaymentEntity> findAll = paymentRepository.findAll(SORT_BY_DATE);
		model.addAttribute("payments", findAll);
		return PAGE_PAYMENTS;
	}

	/***
	 * Insere o cliente na Base de Dado
	 * 
	 * @param customer
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@Transactional
	public String add(@Valid PaymentEntity payment, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return PAGE_PAYMENT_REGISTER;

		}
		this.process(payment);
		this.paymentRepository.save(payment);
		return REDIRECT_PAGINA_CLIENTES;
	}

	private PaymentEntity process(PaymentEntity payment) {

		if (payment.getPaymentType().equals(PaymentType.Semanal)) {

			payment.setLastDayOfValidPaymentDate(payment.getInitialDate().plusDays(8));

		}
		if (payment.getPaymentType().equals(PaymentType.Quizenal)) {
			payment.setLastDayOfValidPaymentDate(payment.getInitialDate().plusDays(16));

		}
		if (payment.getPaymentType().equals(PaymentType.Mensal)) {
			payment.setLastDayOfValidPaymentDate(payment.getInitialDate().plusDays(30));

		}

		return payment;
	}

}
