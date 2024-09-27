package co.ao.OkayulaTech.Netflix.Enuns;


public enum Sexo {
	FEMININO("Feminino"), MASCULINO("Masculino"), OUTROS("Outros");
	private String descricao;


    private Sexo(String descricao)
    {
		//this();
		this.descricao=descricao;
		
	}


	public String  getDescricao( ) {
		return descricao;
	}
}



	