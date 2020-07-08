package br.com.eng3.crud_fornecedor.web.controle;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.eng3.crud_fornecedor.command.AlterarCommand;
import br.com.eng3.crud_fornecedor.command.ConsultarCommand;
import br.com.eng3.crud_fornecedor.command.ExcluirCommand;
import br.com.eng3.crud_fornecedor.command.ICommand;
import br.com.eng3.crud_fornecedor.command.SalvarCommand;
import br.com.eng3.crud_fornecedor.dominio.EntidadeDominio;
import br.com.eng3.crud_fornecedor.dominio.Resultado;
import br.com.eng3.crud_fornecedor.web.viewHelper.FornecedorVH;
import br.com.eng3.crud_fornecedor.web.viewHelper.IViewHelper;

/**
 * Servlet implementation class Controle
 */
@WebServlet("/Controle")
public class Controle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static Map<String, ICommand> commands;
	private static Map<String, IViewHelper> viewHelpers;
	
    public Controle() {
        commands = new HashMap<String, ICommand>();
        commands.put("SALVAR", new SalvarCommand());
        commands.put("ALTERAR", new AlterarCommand());
        commands.put("EXCLUIR", new ExcluirCommand());
        commands.put("PESQUISAR", new ConsultarCommand());
        commands.put("PERFIL", new ConsultarCommand());
        
        viewHelpers = new HashMap<String, IViewHelper>();
        viewHelpers.put("/CRUD_FORNECEDOR/SalvarFornecedor", new FornecedorVH());
        viewHelpers.put("/CRUD_FORNECEDOR/AlterarFornecedor", new FornecedorVH());
        viewHelpers.put("/CRUD_FORNECEDOR/ExcluirFornecedor", new FornecedorVH());
        viewHelpers.put("/CRUD_FORNECEDOR/PesquisarFornecedor", new FornecedorVH());
        viewHelpers.put("/CRUD_FORNECEDOR/PerfilFornecedor", new FornecedorVH());
    }
    
    protected void doProcessarServlet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException{
    	//qual botao foi pressionado
    	String uri = request.getRequestURI();
    	//qual operacao foi selecionada pelo botao
    	String operacao = request.getParameter("OPERACAO");
    	//instanciar a view
    	IViewHelper viewHelper = viewHelpers.get(uri);
    	//recebendo a entidade da view
    	EntidadeDominio entidade = viewHelper.getEntidade(request);
    	//chamando a command
    	ICommand command = null;
    	Resultado resultado = null;
    	command = commands.get(operacao);
    	//adicionando o resultado na command
    	resultado = command.executar(entidade);
    	//setando a view
    	viewHelper.setView(resultado, request, response);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
				doProcessarServlet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
				doProcessarServlet(request, response);
	}
}
