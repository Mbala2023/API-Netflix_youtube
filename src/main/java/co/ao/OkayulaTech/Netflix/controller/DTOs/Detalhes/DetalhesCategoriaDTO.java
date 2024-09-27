package co.ao.OkayulaTech.Netflix.controller.DTOs.Detalhes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import co.ao.OkayulaTech.Netflix.controller.DTOs.VideoDTO;
import co.ao.OkayulaTech.Netflix.model.Categoria;



public class DetalhesCategoriaDTO {
	
	private Long id;
    private String descricao;
	
	private boolean isApenasAdulto;
	
	private boolean estado;
	
	private List<VideoDTO> video;

	
	public DetalhesCategoriaDTO(Categoria categoria) {
		
		
		this.id=categoria.getId();
		this.descricao = categoria.getDescricao();
		this.isApenasAdulto =categoria.isApenasAdulto();
		this.estado = categoria.isEstado();
		
		this.video=new ArrayList<>();
        this.video.addAll(categoria.getVideo().stream().map(VideoDTO::new).collect(Collectors.toList()));
			
		
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


	public List<VideoDTO> getVideo() {
		return video;
	}


	public void setVideo(List<VideoDTO> video) {
		this.video = video;
	}
	
	
	public static List<DetalhesCategoriaDTO> converter(List<Categoria> categoria) {
		return categoria.stream().map(DetalhesCategoriaDTO::new).collect(Collectors.toList());
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}	
		
}
