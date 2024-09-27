package co.ao.OkayulaTech.Netflix.controller.DTOs.Detalhes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import co.ao.OkayulaTech.Netflix.Enuns.PacotesNetflix;
import co.ao.OkayulaTech.Netflix.Enuns.Sexo;
import co.ao.OkayulaTech.Netflix.controller.DTOs.CanaisDTO;
import co.ao.OkayulaTech.Netflix.controller.DTOs.ExibicaoDTO;
import co.ao.OkayulaTech.Netflix.controller.DTOs.UsuarioEnderecoDTO;
import co.ao.OkayulaTech.Netflix.model.Usuario;



public class DetalhesUsuarioDTO {
	
	private Long id;
	
    private String nome;	

		
	private String nif;

	private String telefone;
	
	private LocalDate dataNascimento;
	
	private Sexo sexo;
	
	private List <ExibicaoDTO> exibicao;
	
	private List <CanaisDTO> canais;
	
	private List <UsuarioEnderecoDTO> enderecoUsu;
	
	private PacotesNetflix pacote;

	
	public DetalhesUsuarioDTO(Usuario usuario) {
		
		
		this.id=usuario.getId();
		this.nome =usuario.getNome();
	
		this.nif =usuario.getNif();
		this.telefone =usuario.getTelefone();
		this.dataNascimento =usuario.getDataNascimento();
		this.sexo=usuario.getSexo();
		this.pacote=usuario.getPacote();
		
		this.exibicao=new ArrayList<>();
        this.exibicao.addAll(usuario.getExibicao().stream().map(ExibicaoDTO::new).collect(Collectors.toList()));
        
        this.canais=new ArrayList<>();
        this.canais.addAll(usuario.getCanais().stream().map(CanaisDTO::new).collect(Collectors.toList()));
        
       
        this.enderecoUsu=new ArrayList<>();
        this.enderecoUsu.addAll(usuario.getEnderecoUsu().stream().map(UsuarioEnderecoDTO::new).collect(Collectors.toList()));
	}


	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getNif() {
		return nif;
	}



	public void setNif(String nif) {
		this.nif = nif;
	}



	public String getTelefone() {
		return telefone;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}	

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public List<UsuarioEnderecoDTO> getEnderecoUsu() {
		return enderecoUsu;
	}


	public void setEnderecoUsu(List<UsuarioEnderecoDTO> enderecoUsu) {
		this.enderecoUsu = enderecoUsu;
	}
	
	public List<CanaisDTO> getCanais() {
		return canais;
	}


	public void setCanais(List<CanaisDTO> canais) {
		this.canais = canais;
	}


	public Sexo getSexo() {
		return sexo;
	}



	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}



	public List<ExibicaoDTO> getExibicao() {
		return exibicao;
	}



	public void setExibicao(List<ExibicaoDTO> exibicao) {
		this.exibicao = exibicao;
	}


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	public PacotesNetflix getPacote() {
		return pacote;
	}



	public void setPacote(PacotesNetflix pacote) {
		this.pacote = pacote;
	}



	public static List<DetalhesUsuarioDTO> converter(List<Usuario> usuario) {
		return usuario.stream().map(DetalhesUsuarioDTO::new).collect(Collectors.toList());
	}



}
