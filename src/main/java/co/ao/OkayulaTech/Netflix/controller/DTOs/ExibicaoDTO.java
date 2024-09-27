package co.ao.OkayulaTech.Netflix.controller.DTOs;

import java.time.LocalDate;
import co.ao.OkayulaTech.Netflix.model.Exibicao;


public class ExibicaoDTO {

    private Long id;
	
	private Long video;
	
	private Long usuario;
	
	private boolean vizualizacao;
	private LocalDate dataVizualizacao;

	
	private double ponctuacao;
	
	private boolean recomenda;
	
	
	public ExibicaoDTO()
	{}
	
	public ExibicaoDTO(Exibicao exibicao) {
		
		
		this.id=exibicao.getId();
		this.video = exibicao.getVideo().getId();
		this.vizualizacao =exibicao.isVizualizacao();	
		this.usuario=exibicao.getUsuario().getId();
		this.ponctuacao=exibicao.getPonctuacao();
		this.recomenda=exibicao.isRecomenda();
		
		
	}


	public Long getVideo() {
		return video;
	}


	public void setVideo(Long video) {
		this.video = video;
	}


	public boolean isVizualizacao() {
		return vizualizacao;
	}


	public void setVizualizacao(boolean vizualizacao) {
		this.vizualizacao = vizualizacao;
	}


	public LocalDate getDataVizualizacao() {
		return dataVizualizacao;
	}


	public void setDataVizualizacao(LocalDate dataVizualizacao) {
		this.dataVizualizacao = dataVizualizacao;
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

	public double getPonctuacao() {
		return ponctuacao;
	}

	public void setPonctuacao(double ponctuacao) {
		this.ponctuacao = ponctuacao;
	}

	public boolean isRecomenda() {
		return recomenda;
	}

	public void setRecomenda(boolean recomenda) {
		this.recomenda = recomenda;
	}
	
	
			
	
}
