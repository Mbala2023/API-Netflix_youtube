package co.ao.OkayulaTech.Netflix.controller.DTOs;


import co.ao.OkayulaTech.Netflix.model.Ponctuacoes;

public class PonctuacoesDTO {

	
private Long exibicao;
	
	
	private Long usuario;
	
	private double ponctuacao;
	
	
	public PonctuacoesDTO()
	{
			
		
	}
	
	
	public PonctuacoesDTO(Ponctuacoes ponctuacoes) 
	{                                              
		                                                                                        
		
		this.exibicao = ponctuacoes.getExibicao().getId();
		this.usuario = ponctuacoes.getUsuario().getId();
		this.ponctuacao=ponctuacoes.getPonctuacao();
		
		
	}


	public Long getExibicao() {
		return exibicao;
	}


	public void setExibicao(Long exibicao) {
		this.exibicao = exibicao;
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
	
	

	
}
