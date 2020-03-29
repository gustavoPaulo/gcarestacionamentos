package br.com.gcarestacionamentos;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.dao.DaoGeneric;
import br.com.entidades.Estabelecimento;

@ViewScoped
@ManagedBean(name = "estabelecimentoBean")
public class EstabelecimentoBean {

	private Estabelecimento estabelecimento = new Estabelecimento();
	private DaoGeneric<Estabelecimento> daoGeneric = new DaoGeneric<Estabelecimento>();
	private List<Estabelecimento> estabelecimentos = new ArrayList<Estabelecimento>();
	
	
	
	public String salvar() {

		estabelecimento = daoGeneric.merge(estabelecimento);
		carregarEstabelecimentos();
		
		return "cadastroEstabelecimento";
	}
	
	public String remove() {

		daoGeneric.deletePorId(estabelecimento);
		estabelecimento = new Estabelecimento();
		carregarEstabelecimentos();
		
		return "";
	}
	
	@PostConstruct
	public void carregarEstabelecimentos() {
		
		estabelecimentos = daoGeneric.getListEntity(Estabelecimento.class);
	}
	

	
	
	public String cadastro() {
		
		return "cadastroEstabelecimento";
	}
	
	
	
	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}
	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	public DaoGeneric<Estabelecimento> getDaoGeneric() {
		return daoGeneric;
	}
	public void setDaoGeneric(DaoGeneric<Estabelecimento> daoGeneric) {
		this.daoGeneric = daoGeneric;
	}
	public List<Estabelecimento> getEstabelecimentos() {
		return estabelecimentos;
	}
	public void setEstabelecimentos(List<Estabelecimento> estabelecimentos) {
		this.estabelecimentos = estabelecimentos;
	}
}
