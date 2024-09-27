package co.ao.OkayulaTech.Netflix.controller.DTOs.Detalhes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import co.ao.OkayulaTech.Netflix.model.Ponctuacoes;


public class DetalhesPonctuacoesDTO {

private Long video;
	
	private String email;
	private String usuario;
	
	private double ponctuacao;
	private LocalDateTime dataVisualizacao;

	
	
	public DetalhesPonctuacoesDTO(Ponctuacoes ponctuacoes) 
	{                                              
		                                                		                                    
		
		this.video = ponctuacoes.getExibicao().getVideo().getId();
		this.usuario = ponctuacoes.getUsuario().getNome();
		this.email=ponctuacoes.getUsuario().getEmail();
		this.ponctuacao=ponctuacoes.getPonctuacao();
		this.dataVisualizacao=ponctuacoes.getExibicao().getDataVizualizacao();
		
		
	}


	public Long getVideo() {
		return video;
	}



	public void setVideo(Long video) {
		this.video = video;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}






	public LocalDateTime getDataVisualizacao() {
		return dataVisualizacao;
	}


	public void setDataVisualizacao(LocalDateTime dataVisualizacao) {
		this.dataVisualizacao = dataVisualizacao;
	}


	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public double getPonctuacao() {
		return ponctuacao;
	}



	public void setPonctuacao(double ponctuacao) {
		this.ponctuacao = ponctuacao;
	}
	
	
	public static List<DetalhesPonctuacoesDTO> converter(List<Ponctuacoes> ponctuacao) {
		return ponctuacao.stream().map(DetalhesPonctuacoesDTO::new).collect(Collectors.toList());
	}
	
	
	
}
