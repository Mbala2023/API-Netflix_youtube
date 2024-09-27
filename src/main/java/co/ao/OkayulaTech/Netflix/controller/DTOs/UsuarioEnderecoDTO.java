package co.ao.OkayulaTech.Netflix.controller.DTOs;


import co.ao.OkayulaTech.Netflix.model.Usuario_Endereco;

public class UsuarioEnderecoDTO {

	
	private Long id;
	
	private Long usuario;	
	
	private Long endereco;

	public UsuarioEnderecoDTO()
	{
		
	}
	
	public UsuarioEnderecoDTO(Usuario_Endereco usuarioEndere) {
		
		this.id=usuarioEndere.getId();
		this.usuario =usuarioEndere.getId();
		this.endereco =usuarioEndere.getId();
		
		
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

	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}

	public Long getEndereco() {
		return endereco;
	}

	public void setEndereco(Long endereco) {
		this.endereco = endereco;
	}



	
	
}
