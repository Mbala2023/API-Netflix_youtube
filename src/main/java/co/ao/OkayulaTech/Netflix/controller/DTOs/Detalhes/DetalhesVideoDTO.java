package co.ao.OkayulaTech.Netflix.controller.DTOs.Detalhes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Enumerated;

import co.ao.OkayulaTech.Netflix.Enuns.PacotesNetflix;
import co.ao.OkayulaTech.Netflix.controller.DTOs.CategoriaDTO;
import co.ao.OkayulaTech.Netflix.controller.DTOs.ExibicaoDTO;
import co.ao.OkayulaTech.Netflix.model.Usuario;
import co.ao.OkayulaTech.Netflix.model.Video;



public class DetalhesVideoDTO {

	
	private Long id;
	
    private String titulo;
	
	private String descricao;
		
	private String url;
	
	private List <ExibicaoDTO> exibicao;

	private List <CategoriaDTO> categoria;
	
	private LocalDate dataPublicacao;
	
	private Usuario usuario;
	
    @Enumerated
	private PacotesNetflix pacote;


	public DetalhesVideoDTO(Video video) {
		
		
		this.id=video.getId();
		this.titulo = video.getTitulo();
		this.descricao =video.getDescricao();
		this.url =video.getUrl();
		this.dataPublicacao =video.getDataPublicacao();
		this.usuario=video.getUsuario();
		this.pacote=video.getPacote();
		
		this.categoria=new ArrayList<>();
        this.categoria.addAll(video.getCategoria().stream().map(CategoriaDTO::new).collect(Collectors.toList()));
        
        this.exibicao=new ArrayList<>();
        this.exibicao.addAll(video.getExibicao().stream().map(ExibicaoDTO::new).collect(Collectors.toList()));
        
        this.exibicao=new ArrayList<>();
        this.exibicao.addAll(video.getExibicao().stream().map(ExibicaoDTO::new).collect(Collectors.toList()));
        		
		
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


	public List<ExibicaoDTO> getExibicao() {
		return exibicao;
	}


	public void setExibicao(List<ExibicaoDTO> exibicao) {
		this.exibicao = exibicao;
	}


	public List<CategoriaDTO> getCategoria() {
		return categoria;
	}


	public void setCategoria(List<CategoriaDTO> categoria) {
		this.categoria = categoria;
	}


	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}


	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	
	
	
	
	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public static List<DetalhesVideoDTO> converter(List<Video> video) {
		return video.stream().map(DetalhesVideoDTO::new).collect(Collectors.toList());
	}
	
}
