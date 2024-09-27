package co.ao.OkayulaTech.Netflix.controller.DTOs;

import co.ao.OkayulaTech.Netflix.model.Endereco;



public class EnderecoDTO {

	
	private Long id;
	
	private String rua;
		
	private String bairro;
	
	private String municipio;
	
	private String provincia;

	
	public EnderecoDTO()
	{
		
	}
	
	public EnderecoDTO(Endereco endereco) {
	
		this.id=endereco.getId();
		this.rua =endereco.getRua();
		this.bairro =endereco.getBairro();
		this.municipio =endereco.getMunicipio();
		this.provincia =endereco.getProvincia();
	}


	public String getRua() {
		return rua;
	}


	public void setRua(String rua) {
		this.rua = rua;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getMunicipio() {
		return municipio;
	}


	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
	
	
}
