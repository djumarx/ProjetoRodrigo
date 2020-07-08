<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="br.com.eng3.crud_fornecedor.dominio.*, java.util.*" %>

<!DOCTYPE html>

<html lang="pt-br">
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title> Perfil </title>

        <!-- Folha de Estilo propria -->
        <link href="perfil.css" rel="stylesheet" type="text/css">

        <!-- Bootstrap 4 -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

        <!-- Jquery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        <!-- Popper -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    </head>

    <body class="">
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <!-- Brand/logo -->
            <a class="navbar-brand "> 
              ES3 - Cadastro de fornecedor
            </a>
            
            <!-- Links -->
            <ul class="navbar-nav">
                  <li class="nav-item">
                      <a class="nav-link" href="formCadastroFornecedor.jsp">Cadastrar</a>
                    </li>
                <li class="nav-item">
                    <a class="nav-link" href="pesquisa.jsp">Pesquisar</a>
                </li>
              </ul>
          </nav>
          <br>

                <div class="container">
                <h1 class="text-center display-4"> Perfil</h1>
                
                <%
                
                    Fornecedor f = (Fornecedor)session.getAttribute("fornecedor");  

                            out.print("<div>");
                            out.print("<button class='btn btn-dark text-white' type='button'><a id='bt-alterar' href='alterar.jsp'>Alterar</a></button>");
                 %>           
                 			<form action="ExcluirFornecedor" method="POST">
                 				<input type=submit id=OPERACAO name=OPERACAO value=EXCLUIR class='btn btn-dark text-white'>
                 			</form>
                 			
                 			  
                 <%
                            out.print("<br><br>");
                            out.print("</div>");
                            out.print("<div class=card>");
                            out.print("<div class=card-body>");
                            out.print("<h4>Dados pessoais</h4>");
                            out.print("<label>Nome:" + f.getNome() + "</label><br>");
                            out.print("<label>CPF:"+ f.getCnpj() + "</label><br>");
                            out.print("<label>CPF:"+ f.getRanking() + "</label><br>");
                            out.print("<label>Data de nascimento:" + f.getDtNascimento() + "</label><br>");
                            out.print("<label>G�nero:" + f.getGenero() + "</label><br>");
                            out.print("</div>");
                            out.print("</div>");
                            out.print("<br>");
                            out.print("<div class=card>");
                            out.print("<div class=card-body>");
                            out.print("<h4>Contato</h4>");
                            out.print("<label>Tipo de telefone:"+ f.getTelefone().getTipoNumero() +"</label><br>");
                            out.print("<label>N�mero de telefone:"+ f.getTelefone().getDdd() + f.getTelefone().getNumero() +"</label><br>");
                            out.print("<label>Email:"+ f.getUsuario().getEmail() +"</label><br>");
                            out.print("</div>");
                            out.print("</div>");
                            out.print("<br>");
							
                            List<Endereco> enderecos = f.getEndereco();
                            for(int i = 0; i < enderecos.size(); i++){
                                out.print("<div class=card>");
                                out.print("<div class=card-body>");
                                out.print("<h4>Endere�o</h4><br>");
                                out.print("<label>Nome do endere�o:"+ enderecos.get(i).getNome() +"</label><br>");
                                out.print("<label>Tipo de Logradouro:"+ enderecos.get(i).getTipoLogradouro() +"</label><br>");
                                out.print("<label>Logradouro:"+ enderecos.get(i).getLogradouro() +"</label><br>");
                                out.print("<label>Tipo de residencia:"+ enderecos.get(i).getTipoResidencia() + "</label><br>");
                                out.print("<label>CEP:"+ enderecos.get(i).getCep() +"</label><br>");
                                out.print("<label>Pais:"+ enderecos.get(i).getPais()+"</label><br>");
                                out.print("<label>Estado:"+ enderecos.get(i).getEstado() +"</label><br>");
                                out.print("<label>Cidade:"+ enderecos.get(i).getCidade() +"</label><br>");
                                out.print("<label>Bairro:"+ enderecos.get(i).getBairro() +"</label><br>");
                                out.print("<label>Rua:"+ enderecos.get(i).getLogradouro() +"</label><br>");
                                out.print("<label>N�mero:"+ enderecos.get(i).getNumero() +"</label><br>");
                                if(enderecos.get(i).isEntrega()){
                                    out.print("<label>Endere�o de entrega: sim </label> <br>");
                                }   else
                                {
                                    out.print("<label>Endere�o de entrega: N�o </label> <br>");
                                }

                                if(enderecos.get(i).isCobranca()){
                                    out.print("<label>Endere�o de Cobra�a: sim </label> <br>");
                                }
                                else{
                                    out.print("<label>Endere�o de Cobran�a: N�o </label> <br>");
                                }
                                out.print("<label>Complemento:"+ enderecos.get(i).getComplemento() +"</label> <br>");
                                out.print("</div>");
                                out.print("</div>");
                            
                            }
							List<Produto> produtos = f.getProduto();
                            for(int i = 0; i < produtos.size(); i++){
                                out.print("<div class=card>");
                                out.print("<div class=card-body>");
                                out.print("<h4>Produtos</h4><br>");
                                out.print("<label>Nome do produto:"+ produtos.get(i).getNome() +"</label><br>");
                                out.print("<label>Pre�o do produto:"+ produtos.get(i).getPreco() +"</label><br>");
                                out.print("<label>Descri��o do produto:"+ produtos.get(i).getDescricao() +"</label><br>");
                                out.print("<label>Categoria do produto:"+ produtos.get(i).getCategoria() + "</label><br>");
                                if(produtos.get(i).isProdutoPadrao()){
                                    out.print("<label>Endere�o de entrega: sim </label> <br>");
                                }   else
                                {
                                    out.print("<label>Endere�o de entrega: N�o </label> <br>");
                                }
                                out.print("<br>");
                                out.print("</div>");
                                out.print("</div>");
                            
                            }
                            List<Cartao> cartoes = f.getCartao();
                            for(int i = 0; i < cartoes.size(); i++){
							out.print("<br><br>");
                            out.print("</div>");
                            out.print("<div class=card>");
                            out.print("<div class=card-body>");
                            out.print("<h4>Dados Cart�o</h4>");
                            out.print("<label>Nome impresso no cart�o:" + f.getCartao().get(i).getNome() + "</label><br>");
                            out.print("<label>Numero do cart�o:"+ f.getCartao().get(i).getNumero() + "</label><br>");
                            out.print("<label>Codigo de seguran�a do cart�o:"+ f.getCartao().get(i).getCodSeguranca() + "</label><br>");
                            out.print("<label>Bandeira do cart�o" + f.getCartao().get(i).getBandeira().getNome() + "</label><br>");
                            out.print("</div>");
                            out.print("</div>");
                            }
                %>
                  
                
            <br><br>
          </div>
    </body>
</html>