package co.ao.OkayulaTech.Netflix.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="tb_Visualizadores")
public class Visualizadores {
	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column (nullable=false)
	private LocalDate dataVisualizacao;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="exibicaoID",nullable=false)
	private Exibicao exibicao;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="usuarioID",nullable=false)
	private Usuario usuario;
	
	
	public Visualizadores()
	{
		
		this.dataVisualizacao=LocalDate.now();	
		
	}
	
	
	public Visualizadores(Exibicao exibicao, Usuario usuario) 
	{                                              
		                                                 
		this();                                        
		
		this.exibicao = exibicao;
		this.usuario = usuario;
		
		
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
		Visualizadores other = (Visualizadores) obj;
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


	public LocalDate getDataVisualizacao() {
		return dataVisualizacao;
	}


	public void setDataVisualizacao(LocalDate dataVisualizacao) {
		this.dataVisualizacao = dataVisualizacao;
	}


	public Exibicao getExibicao() {
		return exibicao;
	}


	public void setExibicao(Exibicao exibicao) {
		this.exibicao = exibicao;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	

}
