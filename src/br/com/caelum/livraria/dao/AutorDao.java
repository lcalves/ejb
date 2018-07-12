package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Autor;


@Stateless
public class AutorDao {

	@PersistenceContext
	EntityManager manager;
	
	@PostConstruct
	void aposCriacao() {
	    System.out.println("AutorDao foi criado");
	}
	
	public void salva(Autor autor) {
		manager.persist(autor);
	}
	
	public List<Autor> todosAutores() {
		return manager.createQuery("SELECT a FROM Autor a", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = manager.find(Autor.class, autorId);
		return autor;
	}
	
}
