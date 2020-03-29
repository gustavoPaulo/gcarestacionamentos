package br.com.repository;

import br.com.entidades.Usuario;

public interface IDaoUsuario {

	Usuario consultarUsuario(String login, String senha);
}