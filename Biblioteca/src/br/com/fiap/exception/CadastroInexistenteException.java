package br.com.fiap.exception;

public class CadastroInexistenteException extends Exception {

	private static final long serialVersionUID = 1L;

	public CadastroInexistenteException() {
		super();
	}

	public CadastroInexistenteException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public CadastroInexistenteException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CadastroInexistenteException(String arg0) {
		super(arg0);
	}

	public CadastroInexistenteException(Throwable cause) {
		super(cause);
	}
	
}
