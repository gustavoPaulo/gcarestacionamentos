package br.com.gcarestacionamentos;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.dao.DaoGeneric;
import br.com.entidades.Movimento;

@ViewScoped
@ManagedBean(name = "movimentoBean")
public class MovimentoBean {

	private DaoGeneric<Movimento> daoGeneric = new DaoGeneric<Movimento>();
	private List<Movimento> movimentos = new ArrayList<Movimento>();
	

	
	@PostConstruct
	public void carregarMovimentos() {
		
		movimentos = daoGeneric.getListEntity(Movimento.class);
	}
	
	public String relatorio() {
		
		return "movimento";
	}



	public DaoGeneric<Movimento> getDaoGeneric() {
		return daoGeneric;
	}

	public void setDaoGeneric(DaoGeneric<Movimento> daoGeneric) {
		this.daoGeneric = daoGeneric;
	}

	public List<Movimento> getMovimentos() {
		return movimentos;
	}

	public void setMovimentos(List<Movimento> movimentos) {
		this.movimentos = movimentos;
	}
	
}
