package br.com.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.entidades.Usuario;
import br.com.jpautil.JPAUtil;

public class IDaoUsuarioImpl implements IDaoUsuario {

	@Override
	public Usuario consultarUsuario(String login, String senha) {

		Usuario usuario = null;
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		usuario = (Usuario) entityManager.createQuery("select u from Usuario u where u.login = '" + login + "' and u.senha = '" + senha + "'").getSingleResult();
		
		entityTransaction.commit();
		entityManager.close();
		
		return usuario;
	}
}
