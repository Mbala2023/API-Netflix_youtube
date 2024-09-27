package co.ao.OkayulaTech.Netflix.controller.DTOs.Detalhes;


import java.util.List;
import java.util.stream.Collectors;

import co.ao.OkayulaTech.Netflix.model.Endereco;
import co.ao.OkayulaTech.Netflix.model.Usuario;
import co.ao.OkayulaTech.Netflix.model.Usuario_Endereco;


public class DetalhesUsuarioEnderecoDTO {


	private Long id;
	
    private Usuario usuario;	
	
	private Endereco endereco;
	
	
	
	public DetalhesUsuarioEnderecoDTO(Usuario_Endereco usuarioEnd) {
		
		this.id=usuarioEnd.getId();
		this.usuario =usuarioEnd.getUsuario();
		this.endereco = usuarioEnd.getEndereco();
		
		
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public Endereco getEndereco() {
		return endereco;
	}



	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}



	public static List<DetalhesUsuarioEnderecoDTO> converter(List<Usuario_Endereco> endereco2) {
		return endereco2.stream().map(DetalhesUsuarioEnderecoDTO::new).collect(Collectors.toList());
	}
	
	
}
