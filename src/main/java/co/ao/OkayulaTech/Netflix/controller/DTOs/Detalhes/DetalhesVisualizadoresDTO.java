package co.ao.OkayulaTech.Netflix.controller.DTOs.Detalhes;

import java.util.List;
import java.util.stream.Collectors;

import co.ao.OkayulaTech.Netflix.model.Visualizadores;



public class DetalhesVisualizadoresDTO {

	
    private Long video;

    private String tituloVideo;
	
	
	private String usuario;
	
	private String email;

	
	
	public DetalhesVisualizadoresDTO(Visualizadores visualizadores) 
	{                                              	                                                		                                    
		
		this.video = visualizadores.getExibicao().getVideo().getId();
		this.usuario = visualizadores.getUsuario().getNome();
		this.tituloVideo=visualizadores.getExibicao().getVideo().getTitulo();
		this.email=visualizadores.getUsuario().getEmail();	
		
	}


	public Long getVideo() {
		return video;
	}


	public void setVideo(Long video) {
		this.video = video;
	}


	public String getTituloVideo() {
		return tituloVideo;
	}



	public void setTituloVideo(String tituloVideo) {
		this.tituloVideo = tituloVideo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	public static List<DetalhesVisualizadoresDTO> converter(List<Visualizadores> visualizadores) {
		return visualizadores.stream().map(DetalhesVisualizadoresDTO::new).collect(Collectors.toList());
	}
	
	
	
}
