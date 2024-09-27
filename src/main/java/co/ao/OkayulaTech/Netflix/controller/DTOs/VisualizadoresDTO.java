package co.ao.OkayulaTech.Netflix.controller.DTOs;


import co.ao.OkayulaTech.Netflix.model.Visualizadores;



public class VisualizadoresDTO {	
	
	private Long exibicao;
	
	
	private Long usuario;
	
	
	public VisualizadoresDTO()
	{
			
		
	}
	
	
	public VisualizadoresDTO(Visualizadores visualizadores) 
	{                                              
		                                                                                        
		
		this.exibicao = visualizadores.getExibicao().getId();
		this.usuario = visualizadores.getUsuario().getId();
		
		
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
	
	
	
	
}
