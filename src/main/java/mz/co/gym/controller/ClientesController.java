package mz.co.gym.controller;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mz.co.gym.models.Cliente;
import mz.co.gym.repositories.ClienteRepository;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

	private static final String PAGINA_CLIENTES = "clientes/clientes";
	private static final String PAGINA_CADASTRO_CLIENTES = "clientes/cliente-form";
	private static final String PAGINA_CADASTRO_CLIENTES_EDIT = "clientes/cliente-form-edit";

	private static final String REDIRECT_PAGINA_CLIENTES = "redirect:/clientes";

	private static final Sort SORT_BY_NAME = new Sort("nomeCompleto");

	private final ClienteRepository clienteRepository;

	public ClientesController(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@GetMapping("/form")
	public String form() {
		return PAGINA_CADASTRO_CLIENTES;
	}

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("clientes", clienteRepository.findAll(SORT_BY_NAME));
		return PAGINA_CLIENTES;
	}

	@PostMapping()
	@Transactional
	public String adicionar(Cliente cliente, RedirectAttributes redirectModel) {

		this.clienteRepository.save(cliente);
		redirectModel.addFlashAttribute("msg", "Cliente cadastrado com sucesso!");
		return REDIRECT_PAGINA_CLIENTES;
	}

	@DeleteMapping("/{id}") 
	@Transactional
	public String excluir(@PathVariable("id") Long id, RedirectAttributes redirectModel) {
		this.clienteRepository.delete(id);
		redirectModel.addFlashAttribute("msg", "Processo Excluido com sucesso!");
		return REDIRECT_PAGINA_CLIENTES;
	}

	@GetMapping(value = "/actualizar/{id}")
	public String edit(@PathVariable Long id, Model model) {
		Cliente cliente = this.clienteRepository.findOne(id);

		model.addAttribute("cliente", cliente);
		return PAGINA_CADASTRO_CLIENTES_EDIT;
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String  saveCustomer(@ModelAttribute("cliente") Cliente cliente) {
		this.clienteRepository.save(cliente);
		return REDIRECT_PAGINA_CLIENTES;

	}

}