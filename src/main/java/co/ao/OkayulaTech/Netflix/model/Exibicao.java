package co.ao.OkayulaTech.Netflix.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="tb_Exibicao")
public class Exibicao {
	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="videoID",nullable=false)
	private Video video;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="usuarioID",nullable=false)
	private Usuario usuario;
	
	@OneToMany(mappedBy="exibicao")
	private List <Visualizadores> visualizadores;
	
	@OneToMany(mappedBy="exibicao")
	private List <Ponctuacoes> ponctuacoes;

	
	@Column (nullable=false)
	private double ponctuacao;
	
	private boolean recomenda;
	
	@Column 
	private boolean vizualizacao;
	
	@Column (nullable=false)
	private LocalDateTime dataVizualizacao;
			
	
	
	public Exibicao()
	{
		this.dataVizualizacao=LocalDateTime.now();	
		this.vizualizacao=false;
	}
	
	
	public Exibicao( Video video, Usuario usuario, double ponctuacao,boolean recomenda) 
	{                                              
		                                                 
		this();                                        
		
		
		this.video = video;
		this.usuario=usuario;
		this.ponctuacao=ponctuacao;
		this.recomenda=recomenda;
		
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
		Exibicao other = (Exibicao) obj;
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


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	


	public List<Visualizadores> getVisualizadores() {
		return visualizadores;
	}


	public void setVisualizadores(List<Visualizadores> visualizadores) {
		this.visualizadores = visualizadores;
	}


	public List<Ponctuacoes> getPonctuacoes() {
		return ponctuacoes;
	}


	public void setPonctuacoes(List<Ponctuacoes> ponctuacoes) {
		this.ponctuacoes = ponctuacoes;
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
