package co.ao.OkayulaTech.Netflix.model;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="tb_Categoria")
public class Categoria {

	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column (nullable=false)
	private String descricao;
	
	@Column 
	private boolean isApenasAdulto;
	
	@Column 
	private boolean estado;
	
	@OneToMany
	@JoinTable(name="Categoria_Video")
	private List <Video> video;

	
	public Categoria()
	{
		this.video=new ArrayList<>();	
		
	}
	
	
	public Categoria( boolean isApenasAdulto, boolean estado,String descricao) 
	{                                              
		                                                 
		this();                                        
		
		this.descricao = descricao;
		this.isApenasAdulto = isApenasAdulto;
		this.estado = estado;
		
		
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
		Categoria other = (Categoria) obj;
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


	public List<Video> getVideo() {
		return video;
	}


	public void setVideo(List<Video> video) {
		this.video = video;
	}


	
}
