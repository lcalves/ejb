package br.com.caelum.livraria.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Usuario;

@Stateless
public class UsuarioDao {

	@PersistenceContext
	EntityManager manager;

	public Usuario buscaPeloLogin(String login) {
		return manager.createQuery("From Usuario u where u.login=:pLogin",Usuario.class)
				.setParameter("pLogin", login)
				.getSingleResult();
	}
	
}
