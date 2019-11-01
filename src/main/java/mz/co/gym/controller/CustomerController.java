package mz.co.gym.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mz.co.gym.models.CustomerEntity;
import mz.co.gym.repositories.CustomerRepository;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	private static final String PAGINA_CLIENTES = "customers/customers";
	private static final String PAGINA_CADASTRO_CLIENTES = "customers/customer-form";
	private static final String PAGINA_CADASTRO_CLIENTES_EDIT = "customers/customer-form-edit";

	private static final String REDIRECT_PAGINA_CLIENTES = "redirect:/customers";

	private static final Sort SORT_BY_NAME = new Sort("nomeCompleto");

	private final CustomerRepository customerRepository;

	public CustomerController(CustomerRepository clienteRepository) {
		this.customerRepository = clienteRepository;
	}
 
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("customer", new CustomerEntity());
		return PAGINA_CADASTRO_CLIENTES;
	}

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("customers", customerRepository.findAll(SORT_BY_NAME));
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
	@Transactional
	public String add(@Valid CustomerEntity customer, // RedirectAttributes redirectModel,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return PAGINA_CADASTRO_CLIENTES;

		}
		// redirectModel.addFlashAttribute("msg", "Cliente cadastrado com sucesso!");
		this.customerRepository.save(customer);
		return REDIRECT_PAGINA_CLIENTES;
	}

	@DeleteMapping("/{id}")
	@Transactional
	public String delete(@PathVariable("id") Long id, RedirectAttributes redirectModel) {
		this.customerRepository.delete(id);
		redirectModel.addFlashAttribute("msg", "Processo Excluido com sucesso!");
		return REDIRECT_PAGINA_CLIENTES;
	}

	@GetMapping(value = "/actualizar/{id}")
	public String edit(@PathVariable Long id, Model model) {
		CustomerEntity customer = this.customerRepository.findOne(id);
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
	public String update(@ModelAttribute("customer") @Valid CustomerEntity customer, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return PAGINA_CADASTRO_CLIENTES;

		}
		this.customerRepository.save(customer);
		return REDIRECT_PAGINA_CLIENTES;

	}

}
