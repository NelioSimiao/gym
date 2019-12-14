package mz.co.gym.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mz.co.gym.controller.validator.CustomerValidator;
import mz.co.gym.models.CustomerEntity;
import mz.co.gym.services.ICustomerService;
import mz.co.gym.services.IPaymentService;

@Controller
@RequestMapping("/customers")
public class CustomerController extends TransactionalService {

	@Autowired
	private CustomerValidator customerValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(customerValidator);
	}

	private static final String PAGINA_CLIENTES = "customers/customers";
	private static final String PAGINA_CADASTRO_CLIENTES = "customers/customer-form";
	private static final String PAGINA_CADASTRO_CLIENTES_EDIT = "customers/customer-form-edit";

	private static final String REDIRECT_PAGINA_CLIENTES = "redirect:/customers";

	@Autowired
	private ICustomerService customerService;
	@Autowired

	private IPaymentService paymentService;

	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("customer", new CustomerEntity());
		return PAGINA_CADASTRO_CLIENTES;
	}

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("customers", customerService.findAll());
		return PAGINA_CLIENTES;
	}

	/***
	 * Insere o cliente na Base de Dado
	 * 
	 * @param customer
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute("customer") CustomerEntity customer, BindingResult result,
			RedirectAttributes redirectModel) {

		if (result.hasErrors()) {
			return PAGINA_CADASTRO_CLIENTES;
		}
		this.customerService.save(customer);
		redirectModel.addFlashAttribute("msgSucesso", "Cliente adicionada com sucesso!");

		return REDIRECT_PAGINA_CLIENTES;

	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id, RedirectAttributes redirectModel) {
		this.delete(redirectModel, id);
		return REDIRECT_PAGINA_CLIENTES;
	}

	@GetMapping(value = "/actualizar/{id}")
	public String edit(@PathVariable Long id, Model model) {
		CustomerEntity customer = this.customerService.findById(id);
		model.addAttribute("customer", customer);
		return PAGINA_CADASTRO_CLIENTES_EDIT;
	}

	/**
	 * This method update the customer.
	 * 
	 * @param customer
	 * @param bindingResult
	 * @return
	 */

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("customer") @Validated CustomerEntity customer, BindingResult bindingResult,
			RedirectAttributes redirectModel) {

		if (bindingResult.hasErrors()) {
			return PAGINA_CADASTRO_CLIENTES;

		}
		this.customerService.save(customer);
		redirectModel.addFlashAttribute("msgSucesso", "Cliente Actualizado com sucesso!");

		return REDIRECT_PAGINA_CLIENTES;

	}

	private void delete(RedirectAttributes redirectModel, Long id) {

		if (!paymentService.findPaymentByCustomer(customerService.findById(id)).isEmpty()) {
			redirectModel.addFlashAttribute("errorSucesso", "Cliente não pode ser excluido porque possui pagamento ");
		} else {

			this.customerService.delete(id);
			redirectModel.addFlashAttribute("msgSucesso", "Cliente Excluido com sucesso!");
		}
	}

}
