package co.ao.OkayulaTech.Netflix.controller.DTOs.Detalhes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import co.ao.OkayulaTech.Netflix.model.Exibicao;
import co.ao.OkayulaTech.Netflix.model.Usuario;
import co.ao.OkayulaTech.Netflix.model.Video;



public class DetalhesExibicaoDTO {

	private Long id;
	
	private Video video;
	
	private Usuario usuario;
	
	private boolean vizualizacao;
	private LocalDateTime dataVizualizacao;
	
	private double ponctuacao;
	
	private boolean recomenda;
	
	
	public DetalhesExibicaoDTO(Exibicao exibicao) {
		
		
		this.id=exibicao.getId();
		
		this.video = exibicao.getVideo();
		this.vizualizacao =exibicao.isVizualizacao();
		this.dataVizualizacao =exibicao.getDataVizualizacao();
		this.usuario=exibicao.getUsuario();
		this.ponctuacao=exibicao.getPonctuacao();
		this.recomenda=exibicao.isRecomenda();		
		
	}


	public Video getVideo() {
		return video;
	}


	public void setVideo(Video video) {
		this.video = video;
	}


	public boolean isVizualizacao() {
		return vizualizacao;
	}


	public void setVizualizacao(boolean vizualizacao) {
		this.vizualizacao = vizualizacao;
	}


	public LocalDateTime getDataVizualizacao() {
		return dataVizualizacao;
	}


	public void setDataVizualizacao(LocalDateTime dataVizualizacao) {
		this.dataVizualizacao = dataVizualizacao;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public static List<DetalhesExibicaoDTO> converter(List<Exibicao> exibicao) {
		return exibicao.stream().map(DetalhesExibicaoDTO::new).collect(Collectors.toList());
	}


	

	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
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
