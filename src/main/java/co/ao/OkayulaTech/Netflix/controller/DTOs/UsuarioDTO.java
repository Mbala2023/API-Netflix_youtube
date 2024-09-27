package co.ao.OkayulaTech.Netflix.controller.DTOs;

import java.time.LocalDate;

import co.ao.OkayulaTech.Netflix.Enuns.PacotesNetflix;
import co.ao.OkayulaTech.Netflix.Enuns.Sexo;
import co.ao.OkayulaTech.Netflix.model.Usuario;



public class UsuarioDTO {

	private Long id;
	
	private String nome;	
	
	private String email;
	
	private String senha;
		
	private String nif;

	private String telefone;
	
	private LocalDate dataNascimento;
	
	private Sexo sexo;
	
	private PacotesNetflix pacote;
	
	public UsuarioDTO()
	{
		
	}
	
	public UsuarioDTO(Usuario usuario) {
		
		this.id=usuario.getId();
		this.nome =usuario.getNome();
		this.email =usuario.getEmail();
		this.nif =usuario.getNif();
		this.telefone =usuario.getTelefone();
		this.dataNascimento =usuario.getDataNascimento();
		this.sexo=usuario.getSexo();
		this.pacote=usuario.getPacote();
		this.senha=usuario.getSenha();
		
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
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

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
}
