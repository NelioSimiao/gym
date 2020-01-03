package mz.co.gym.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mz.co.gym.controller.utility.Utility;
import mz.co.gym.controller.validator.PaymentValidator;
import mz.co.gym.controller.validator.ProcessPayment;
import mz.co.gym.models.PaymentEntity;
import mz.co.gym.services.ICustomerService;
import mz.co.gym.services.IPaymentService;

@Controller
@RequestMapping("/payments")
public class PaymentController extends TransactionalService {
	private static final String PAGE_PAYMENTS = "payments/payments";
	private static final String PAGE_PAYMENT_REGISTER = "payments/payments-form";
	private static final String PAGE_PAYMENT_REGISTER_EDIT = "payments/payments-form-edit";
	private static final String PAGE_PAYMENT_SUMMERIZE = "payments/summery-payments";
	private static final String REDIRECT_PAGINA_PAYMENTS = "redirect:/payments";

	@Autowired
	private IPaymentService paymentService;

	@Autowired
	private ICustomerService customerService;

	@Autowired
	private PaymentValidator paymentValidator;

	@Autowired
	private List<ProcessPayment> processPayments;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(paymentValidator);
	}

	/**
	 * For register the payment
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/form")
	public String form(Model model) {
		model.mergeAttributes(Utility.getInstance().addAttributes(customerService));
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
		List<PaymentEntity> validatePayments = paymentService.findAllValidatePayment(LocalDate.now());
		model.addAttribute("payments", validatePayments);
		model.addAttribute("validatePayment", true);

		return PAGE_PAYMENTS;
	}

	/**
	 * For register the payment
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/inspiredPayment")
	public String inspiredPayment(Model model) {
		List<PaymentEntity> findAll = paymentService.findAllInspiredPayment(LocalDate.now());
		model.addAttribute("payments", findAll);
		model.addAttribute("validatePayment", false);

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
	public String add(@Valid @ModelAttribute("payment") PaymentEntity payment, BindingResult bindingResult, Model model,
			RedirectAttributes redirectModel) {
		model.mergeAttributes(Utility.getInstance().addAttributes(customerService));

		if (bindingResult.hasErrors()) {
			return PAGE_PAYMENT_REGISTER;

		}
		processPayments.forEach(p -> p.process(payment));
		this.paymentService.save(payment);
		redirectModel.addFlashAttribute("msgSucesso", "Pagamento efectudo com sucesso!");

		return REDIRECT_PAGINA_PAYMENTS;
	}

	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable Long id, Model model) {
		model.addAttribute("payment", this.paymentService.findByid(id));
		model.mergeAttributes(Utility.getInstance().addAttributes(customerService));
		return PAGE_PAYMENT_REGISTER_EDIT;
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id, RedirectAttributes redirectModel) {
		PaymentEntity paymentEntity = this.paymentService.findByid(id);
		this.paymentService.inactivar(paymentEntity);
		redirectModel.addFlashAttribute("msgSucesso", "Pagamento excluido com sucesso!");
		return REDIRECT_PAGINA_PAYMENTS;
	}

	@GetMapping(value = "/summarise/{year}")
	public String summerise(@PathVariable Long year, Model model) {
		List<PaymentEntity> allPaymentsOfYear = paymentService.findAllByYear(year);
		Map<Long, List<PaymentEntity>> groupByMonth = Utility.getInstance().groupByMonth(allPaymentsOfYear);
		//model.addAttribute("payments", groupByMonth);
		return PAGE_PAYMENT_SUMMERIZE;
	}

}
