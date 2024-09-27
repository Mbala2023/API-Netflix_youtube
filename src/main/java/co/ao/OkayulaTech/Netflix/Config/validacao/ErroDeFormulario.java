package co.ao.OkayulaTech.Netflix.Config.validacao;



public class ErroDeFormulario {

	
private String erro;
	
	private String campo;

	public ErroDeFormulario(String erro, String campo) {
		
		this.erro = erro;
		this.campo = campo;
	}

	public String getErro() {
		return erro;
	}

	public String getCampo() {
		return campo;
	}
	
	
}
