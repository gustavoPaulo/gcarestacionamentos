package br.com.gcarestacionamentos;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.dao.DaoGeneric;
import br.com.entidades.Veiculo;

@ViewScoped
@ManagedBean(name = "veiculoBean")
public class VeiculoBean {

	private Veiculo veiculo = new Veiculo();
	private DaoGeneric<Veiculo> daoGeneric = new DaoGeneric<Veiculo>();
	private List<Veiculo> veiculos = new ArrayList<Veiculo>();
	
	
	
	public String salvar() {

		veiculo = daoGeneric.merge(veiculo);
		carregarVeiculos();
		
		return "cadastroVeiculo";
	}
	
	public String remove() {

		daoGeneric.deletePorId(veiculo);
		veiculo = new Veiculo();
		carregarVeiculos();
		
		return "";
	}
	
	@PostConstruct
	public void carregarVeiculos() {
		
		veiculos = daoGeneric.getListEntity(Veiculo.class);
	}
	
	
	public String cadastro() {
	
		return "cadastroVeiculo";
	}

	
	
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public DaoGeneric<Veiculo> getDaoGeneric() {
		return daoGeneric;
	}
	public void setDaoGeneric(DaoGeneric<Veiculo> daoGeneric) {
		this.daoGeneric = daoGeneric;
	}
	public List<Veiculo> getVeiculos() {
		return veiculos;
	}
	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
}
