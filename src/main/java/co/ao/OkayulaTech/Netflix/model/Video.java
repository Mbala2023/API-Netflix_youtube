package co.ao.OkayulaTech.Netflix.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import co.ao.OkayulaTech.Netflix.Enuns.PacotesNetflix;

@Entity
@Table(name="tb_Video")
public class Video {

	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column (nullable=false)
	private String titulo;
	
	@Column (nullable=false)
	private String descricao;
	
	@Column (nullable=false)
	private String url;
	
	@Column (nullable=false)
	private LocalDate dataPublicacao;
	
	@OneToMany(mappedBy="video")
	private List <Exibicao> exibicao;
	
	
	@Enumerated
	private PacotesNetflix pacote;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="usuarioID",nullable=false)
	private Usuario usuario;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="Categoria_Video")
	private List <Categoria> categoria;
	
	
	public Video()
	{
		this.categoria=new ArrayList<>();
		this.exibicao=new ArrayList<>();
		this.dataPublicacao=LocalDate.now();	
		
	}
	
	
	public Video(String titulo, String descricao, String url, Usuario usuario,PacotesNetflix pacote) 
	{                                              
		                                                 
		this();                                        
		
		this.titulo = titulo;
		this.descricao = descricao;
		this.url = url;
		this.usuario=usuario;
		this.pacote=pacote;
		
		
	}


	@Override
	public int hashCode() 
	{		
                                       	                                                                         
		final int prime = 31;                                                                                                                                                                                                                                                      
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;	
		
	}                                                                                                                                              
    
	
	@Override
	public boolean equals(Object obj)
	{
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Video other = (Video) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;

	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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

	

	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public List<Exibicao> getExibicao() {
		return exibicao;
	}


	public void setExibicao(List<Exibicao> exibicao) {
		this.exibicao = exibicao;
	}


	public List<Categoria> getCategoria() {
		return categoria;
	}


	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}
	
	
	

	
}
