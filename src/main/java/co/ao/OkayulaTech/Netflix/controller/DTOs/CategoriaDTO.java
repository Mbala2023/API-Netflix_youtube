package co.ao.OkayulaTech.Netflix.controller.DTOs;

import co.ao.OkayulaTech.Netflix.model.Categoria;


public class CategoriaDTO {
	
	
	private Long id;
	private String descricao;
	
	private boolean isApenasAdulto;
	
	private boolean estado;
	
	
	public CategoriaDTO()
	{
		
		
	}

	public CategoriaDTO(Categoria categoria) {
		
		this.id=categoria.getId();
		this.descricao =categoria.getDescricao();
		this.isApenasAdulto =categoria.isApenasAdulto();
		this.estado = categoria.isEstado();
		
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public boolean isApenasAdulto() {
		return isApenasAdulto;
	}



	public void setApenasAdulto(boolean isApenasAdulto) {
		this.isApenasAdulto = isApenasAdulto;
	}



	public boolean isEstado() {
		return estado;
	}



	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
}
