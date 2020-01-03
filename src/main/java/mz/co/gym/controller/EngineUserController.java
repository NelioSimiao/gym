package mz.co.gym.controller;

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

import mz.co.gym.controller.validator.EngineUserValidator;
import mz.co.gym.models.Usuario;
import mz.co.gym.services.IEngineUserService;

@Controller
@RequestMapping("/engineUsers")
public class EngineUserController extends TransactionalService {

	private static final String PAGE_ENGINE_USERS = "engineusers/engineUsers";
	private static final String PAGINA_ENGINE_USERS_FORM = "engineusers/engineUser-form";
	private static final String PAGINA_ENGINE_USERS_EDITE = "engineusers/engineUser-form-edit";

	private static final String REDIRECT_PAGE_ENGINE_USERS = "redirect:/engineUsers";

	@Autowired
	private EngineUserValidator engineUserValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(engineUserValidator);
	}

	@Autowired
	private IEngineUserService engineUserService;

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("engineUsers", engineUserService.findAll());
		return PAGE_ENGINE_USERS;
	}

	@GetMapping("/add")
	public String form(Model model) {
		model.addAttribute("engineUser", new Usuario());
		return PAGINA_ENGINE_USERS_FORM;
	}

	/***
	 * Insere o cliente na Base de Dado
	 * 
	 * @param customer
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute("engineUser") Usuario engineUser, BindingResult result,
			RedirectAttributes redirectModel, Model model) {
		if (result.hasErrors()) {
			return PAGINA_ENGINE_USERS_FORM;
		}
		this.engineUserService.save(engineUser);
		model.addAttribute("engineUsers", engineUserService.findAll());
		redirectModel.addFlashAttribute("msgSucesso", "Usuario adicionada com sucesso!");
		return PAGE_ENGINE_USERS;

	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id, RedirectAttributes redirectModel) {
		engineUserService.delete(id);
		return REDIRECT_PAGE_ENGINE_USERS;
	}

	@GetMapping(value = "/update/{id}")
	public String edit(@PathVariable Long id, Model model) {
		Usuario engineUser = engineUserService.findById(id);
	//	engineUser.setSenha("");
		model.addAttribute("engineUser", engineUser);
		return PAGINA_ENGINE_USERS_EDITE;
	}

}
