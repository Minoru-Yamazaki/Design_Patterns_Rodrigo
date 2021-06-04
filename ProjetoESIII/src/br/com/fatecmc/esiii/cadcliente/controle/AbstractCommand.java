package br.com.fatecmc.esiii.cadcliente.controle;

public abstract class AbstractCommand implements ICommand {
	
	protected IFachada fachada = new Fachada();
}
