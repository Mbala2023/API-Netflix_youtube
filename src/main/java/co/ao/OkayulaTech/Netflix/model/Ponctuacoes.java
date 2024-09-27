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
@Table(name="tb_Ponctuacoes")
public class Ponctuacoes {
	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column (nullable=false)
	private LocalDate dataPonctuacao;
	
	@Column (nullable=false)
	private double ponctuacao;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="exibicaoID",nullable=false)
	private Exibicao exibicao;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="usuarioID",nullable=false)
	private Usuario usuario;
	
	
	public Ponctuacoes()
	{
		
		this.dataPonctuacao=LocalDate.now();	
		
	}
	
	
	public Ponctuacoes(Exibicao exibicao, Usuario usuario,double ponctuacao) 
	{                                              
		                                                 
		this();                                        
		
		this.exibicao = exibicao;
		this.usuario = usuario;
		this.ponctuacao=ponctuacao;
		
		
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
		Ponctuacoes other = (Ponctuacoes) obj;
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
		return dataPonctuacao;
	}


	public void setDataVisualizacao(LocalDate dataPonctuacao) {
		this.dataPonctuacao = dataPonctuacao;
	}


	public double getPonctuacao() {
		return ponctuacao;
	}


	public void setPonctuacao(double ponctuacao) {
		this.ponctuacao = ponctuacao;
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
