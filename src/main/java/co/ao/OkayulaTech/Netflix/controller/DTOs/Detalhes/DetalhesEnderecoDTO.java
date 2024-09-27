package co.ao.OkayulaTech.Netflix.controller.DTOs.Detalhes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import co.ao.OkayulaTech.Netflix.controller.DTOs.UsuarioEnderecoDTO;
import co.ao.OkayulaTech.Netflix.model.Endereco;


public class DetalhesEnderecoDTO {

	
	private Long id;
	private String rua;
	
	private String bairro;
	
	private String municipio;
	
	private String provincia;
	
	private List<UsuarioEnderecoDTO> usuarioUsu;

	
	public DetalhesEnderecoDTO(Endereco endereco) {
		
		this.rua =endereco.getRua();
		this.bairro =endereco.getBairro();
		this.municipio =endereco.getMunicipio();
		this.provincia =endereco.getProvincia();
		this.id=endereco.getId();
		
		this.usuarioUsu=new ArrayList<>();
        this.usuarioUsu.addAll(endereco.getEnderecoUsu().stream().map(UsuarioEnderecoDTO::new).collect(Collectors.toList()));	
		
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


	


	public List<UsuarioEnderecoDTO> getUsuarioUsu() {
		return usuarioUsu;
	}


	public void setUsuarioUsu(List<UsuarioEnderecoDTO> usuarioUsu) {
		this.usuarioUsu = usuarioUsu;
	}


	public static List<DetalhesEnderecoDTO> converter(List<Endereco> endereco) {
		return endereco.stream().map(DetalhesEnderecoDTO::new).collect(Collectors.toList());
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	
	
	
}
