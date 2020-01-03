package mz.co.gym.services;

import java.io.Serializable;
import java.util.List;

import mz.co.gym.models.Usuario;

public interface IEngineUserService extends Serializable {
	
	void delete(Long id);
	
	Usuario findById(Long id);

	List<Usuario> findAll();
	
	Usuario save(Usuario usuario);


}
