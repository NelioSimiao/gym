package mz.co.gym.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import mz.co.gym.models.Usuario;
import mz.co.gym.repositories.UsuarioRepository;

@Service
public class EngineUserImpl implements IEngineUserService {

	private static final long serialVersionUID = 1L;
	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public List<Usuario> findAll() {
		return repository.findAll();
	}

	@Override
	public Usuario save(Usuario usuario) {

		return repository.save(enconder(passwordEncoder, usuario));
	}
  
	private Usuario enconder(BCryptPasswordEncoder passwordEncoder, Usuario usuario) {
		String passwordEncodered = passwordEncoder.encode(usuario.getPassword());
		usuario.setSenha(passwordEncodered);
		return usuario;
	}

	@Override
	public void delete(Long id) {
		
		repository.delete(id);
		
	}

	@Override
	public Usuario findById(Long id) {
		return repository.findOne(id);
	}
	
	
	public static void main(String[] args) {
		   BCryptPasswordEncoder bCryptPasswordEncoder = new	BCryptPasswordEncoder();	
		   
		   String encode = bCryptPasswordEncoder.encode("123456");
		   
		   System.out.println(encode);
	}

}
