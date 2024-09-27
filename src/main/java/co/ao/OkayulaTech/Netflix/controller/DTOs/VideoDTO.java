package co.ao.OkayulaTech.Netflix.controller.DTOs;

import java.time.LocalDate;

import javax.persistence.Enumerated;

import co.ao.OkayulaTech.Netflix.Enuns.PacotesNetflix;
import co.ao.OkayulaTech.Netflix.model.Video;



public class VideoDTO {
	

	private Long id;
	
	private String titulo;
	
	private Long usuario;
	
	private String descricao;
	
	
	private String url;
	
	@Enumerated
	private PacotesNetflix pacote;
	
	private LocalDate dataPublicacao;
	
	private CategoriaDTO categoria;

	
	
	public VideoDTO()
	{
		
	}

	public VideoDTO(Video video) {
		
		
		this.id=video.getId();
		this.titulo = video.getTitulo();
		this.descricao =video.getDescricao();
		this.url =video.getUrl();
		this.dataPublicacao =video.getDataPublicacao();
		this.usuario=video.getUsuario().getId();
		this.pacote=video.getPacote();
				 
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}

    
	
	public PacotesNetflix getPacote() {
		return pacote;
	}

	public void setPacote(PacotesNetflix pacote) {
		this.pacote = pacote;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}


	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CategoriaDTO getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDTO categoria) {
		this.categoria = categoria;
	}

	public Long getUsuario() {
		return usuario;
	}

	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}
	
	
	
	
	

}
