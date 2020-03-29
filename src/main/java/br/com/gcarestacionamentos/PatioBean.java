package br.com.gcarestacionamentos;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.dao.DaoGeneric;
import br.com.entidades.Movimento;
import br.com.entidades.Patio;

@ViewScoped
@ManagedBean(name = "patioBean")
public class PatioBean {

	private Patio patio = new Patio();
	private Movimento movimento = new Movimento();
	private DaoGeneric<Patio> daoGenericPatio = new DaoGeneric<Patio>();
	private DaoGeneric<Movimento> daoGenericMovimento = new DaoGeneric<Movimento>();
	
	private List<Patio> patios = new ArrayList<Patio>();
	
	
	public String entradaVeiculo() {
		
		patio = daoGenericPatio.merge(patio);
		carregarPatio();
		
		return "patio";
	}
	
	public String remove() {

		daoGenericPatio.deletePorId(patio);
		patio = new Patio();
		
		carregarPatio();
		
		return "";
	}
	
	@PostConstruct
	public void carregarPatio() {
		
		patios = daoGenericPatio.getListEntity(Patio.class);
	}
	
	


	public Patio getPatio() {
		return patio;
	}

	public void setPatio(Patio patio) {
		this.patio = patio;
	}

	public Movimento getMovimento() {
		return movimento;
	}

	public void setMovimento(Movimento movimento) {
		this.movimento = movimento;
	}

	public DaoGeneric<Patio> getDaoGenericPatio() {
		return daoGenericPatio;
	}

	public void setDaoGenericPatio(DaoGeneric<Patio> daoGenericPatio) {
		this.daoGenericPatio = daoGenericPatio;
	}

	public DaoGeneric<Movimento> getDaoGenericMovimento() {
		return daoGenericMovimento;
	}

	public void setDaoGenericMovimento(DaoGeneric<Movimento> daoGenericMovimento) {
		this.daoGenericMovimento = daoGenericMovimento;
	}

	public List<Patio> getPatios() {
		return patios;
	}

	public void setPatioList(List<Patio> patios) {
		this.patios = patios;
	}
	
}
