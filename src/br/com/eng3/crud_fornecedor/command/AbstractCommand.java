package br.com.eng3.crud_fornecedor.command;

import br.com.eng3.crud_fornecedor.web.fachada.Fachada;
import br.com.eng3.crud_fornecedor.web.fachada.IFachada;

public abstract class AbstractCommand implements ICommand {
	protected IFachada fachada = (IFachada) new Fachada();
}