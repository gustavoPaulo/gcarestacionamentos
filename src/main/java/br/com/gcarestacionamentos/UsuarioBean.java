package br.com.gcarestacionamentos;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.com.dao.DaoGeneric;
import br.com.entidades.Usuario;
import br.com.repository.IDaoUsuario;
import br.com.repository.IDaoUsuarioImpl;

@ViewScoped
@ManagedBean(name = "usuarioBean")
public class UsuarioBean {

	private Usuario usuario = new Usuario();
	private DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();
	private IDaoUsuario iDaoUsuario = new IDaoUsuarioImpl();

	public String salvar() {

		usuario = daoGeneric.merge(usuario);

		return "index.jsf";
	}
	
	

	public String retornarPatio() {
		
		return "patio.jsf";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public DaoGeneric<Usuario> getDaoGeneric() {
		return daoGeneric;
	}

	public void setDaoGeneric(DaoGeneric<Usuario> daoGeneric) {
		this.daoGeneric = daoGeneric;
	}

	public IDaoUsuario getiDaoUsuario() {
		return iDaoUsuario;
	}

	public void setiDaoUsuario(IDaoUsuario iDaoUsuario) {
		this.iDaoUsuario = iDaoUsuario;
	}

	public String logar() {

		Usuario userLogar = iDaoUsuario.consultarUsuario(usuario.getLogin(), usuario.getSenha());

		if (userLogar != null) {

			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext externalContext = context.getExternalContext();
			externalContext.getSessionMap().put("usuarioLogado", userLogar.getLogin());

			return "patio.jsf";
		}

		return "index.jsf";
	}

}
