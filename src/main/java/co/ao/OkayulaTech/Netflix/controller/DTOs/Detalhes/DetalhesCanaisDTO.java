package co.ao.OkayulaTech.Netflix.controller.DTOs.Detalhes;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import co.ao.OkayulaTech.Netflix.model.Canais;



public class DetalhesCanaisDTO {

private Long id;
	
	private Long usuario;

	private LocalDate dataCadastro;
	
	private String nome;
	
	
	public DetalhesCanaisDTO(Canais canais) {
		
		this.id=canais.getId();
		
		this.usuario = canais.getUsuario().getId();
		this.dataCadastro =canais.getDataCadastro();
		this.nome=canais.getNome();	
		
	}


	
	

	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}


	public Long getUsuario() {
		return usuario;
	}


   void setUsuario(Long usuario) {
		this.usuario = usuario;
	}


	public LocalDate getDataCadastro() {
		return dataCadastro;
	}


	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public static List<DetalhesCanaisDTO> converter(List<Canais> canais) {
		return canais.stream().map(DetalhesCanaisDTO::new).collect(Collectors.toList());
	}
	
}
