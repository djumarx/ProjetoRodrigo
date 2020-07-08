<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="br.com.eng3.crud_fornecedor.dominio.*, java.util.*" %>

<!DOCTYPE html>

<html lang="pt-br">
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title> Alterar </title>

        <!-- CÃ³digo Javascript -->
        <script src="formCadastro.js" lang="javascript"></script>

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
            <a class="navbar-brand " href="home.html"> 
              <img src="https://ubisafe.org/images/vector-book-4.png" alt="Logo" style="width:40px;">
              ES3 - Alterar dados do fornecedor
            </a>
            
             <!-- Links -->
             <ul class="navbar-nav">
                  <li class="nav-item">
                      <a class="nav-link" href="formCadastroFornecedor.jsp">Cadastrar</a>
                  </li>
                <li class="nav-item">
                    <a class="nav-link" href="pesquisa.jsp">Pesquisar</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="alterarSenha.jsp">Alterar Senha</a>
                </li>
                                <li class="nav-item">
                    <a class="nav-link" href="alterarEndereco.jsp">Alterar Endereço</a>
                </li>
              </ul>
          </nav>
          
          <br>

      <div class="container">
        <h1 class="text-center display-3">Alterar</h1>
        </div>

      <div class="container">
        <form action="AlterarFornecedor" method="POST">
          
          
          <%
              Fornecedor f = (Fornecedor) session.getAttribute("fornecedor");  
              out.print("<input style='display:none;'  id='id' name='id' value='"+ f.getId() +"'>");
	          
         %>


          <div class="card">
            <div class="card-body">
              <h4> Dados Pessoais:</h4>
              

              

              <label for="nome">Nome:</label>
              
              <input type="text" pattern="^[^-\s][a-zA-ZÃ€-ú ]*" title="Insira somente letras!" class="form-control" id="nome" name="nome" placeholder="Ex: Guilherme Ferreira " required value="<% out.print(f.getNome()); %>">
              
              <br>              

                <div class="row">
                    <div class="form-group col-md-4">
                        <label for="genero">Gênero:</label>
                        <select class="form-control" id="genero" name="genero" required >
                          <option><% out.print(f.getGenero()); %></option>
                          <option>Feminino</option>
                          <option>Masculino</option>
                          <option>Outros</option>
                        </select>
                      </div>

                  <div class="form-group col-md-4">
                    <label for="dataNascimento">Data de nascimento:</label>
                    <input type="date" class="form-control" id="dataNascimento" required maxlength="10" name="dataNascimento" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" min="1900-01-01" max="2004-01-01" value="<%
                    out.print(f.getDtNascimento()); %>">
                  </div>

                  <div class="form-group col-md-4">
                    <label for="CNPJ">CNPJ:</label>
                    <input type="text" class="form-control" id="CNPJ" pattern="\d{2}\.?\d{3}\.?\d{3}\/?\d{4}-?\d{2}" name="CNPJ" title="Insira um CNPJ valido! ex: 47.123.456/0000-73"required placeholder="Ex: 47.123.456/0000-73" value='<%
                out.print(f.getCnpj()); %>'>
                  </div>
            
                </div> 
              </div>
            </div>

            <br>
        <div class="card">
          <div class="card-body">   
            <h4> Dados de contato:</h4>
            <div class="row">
                <div class="form-group col-md-5">
                    <label for="tipoTelefone">Telefone:</label>
                    <select class="form-control" id="tipoTelefone" name="tipoTelefone" required>
                      <option><% out.print(f.getTelefone().getTipoNumero()); %></option>
                        <option>celular</option>
                        <option>residencial</option>
                        <option>empresarial</option>
                      </select>
                  </div>
                <div class="form-group col-md-2">
                      <label for="ddd">DDD:</label>
                      <input type="number" class="form-control" id="ddd" pattern="[0-9]+$" title="Somente números!" name="ddd" min="11" max="99" required value='<% out.print(f.getTelefone().getDdd()); %>'>

                </div>   
                <div class="form-group col-md-5">
                    <label for="numeroTel">Número:</label>
                    <input type="tel" class="form-control" minlength="9" maxlength="9" id="numeroTel" title="Somente números! tamanho minumo 8 digitos maximo 9 digitos!" name="numeroTel" required placeholder="Ex: 987654321" value="<%
                out.print(f.getTelefone().getNumero()); %> ">
              </div>   
            </div>
            
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" title="Insira um email valido!" name="email" required placeholder="Ex:  joao.765@hotmail.com.br" value="<%
                out.print(f.getUsuario().getEmail()); %> ">
            </div> 

            <div class="row">
                <div class="form-group col-md-6">
                      <label for="senha">Senha:</label>
                      <input type="password" class="form-control" pattern="((?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,15})" title="A senha deve conter no minimo 8 caracteres, ter letras maisculas e minusculas, números alÃ©m de conter caracteres especiais!" id="senha" name="senha" required>
                </div>   
                <div class="form-group col-md-6">
                    <label for="confSenha">Confirmar senha:</label>
                    <input type="password" class="form-control" onblur="validarSenha()" pattern="((?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,15})" title="A senha deve conter no minimo 8 caracteres, ter letras maisculas e minusculas, números alÃ©m de conter caracteres especiais!" id="confSenha" name="confSenha" required>
              </div>   
            </div>
            
        </div>
      </div>

          <br>
          
<%
	
    for(int i = 0; i < f.getEndereco().size(); i++){

      out.print("<div class='card'>");
        out.print("<div class='card-body'>");
          out.print("<h4> Endereço "+ (i + 1) +": </h4>");
          out.print("<div class='form-group'>");
              out.print("<label for='nomeEndereco'>Identificação do Endereço - "+ (i + 1) +":</label>");
              out.print("<input type='text' name='nomeEndereco"+ (i + 1) +"' class='form-control' id='nomeEndereco"+ (i + 1) +"' minlength='5' maxlength='30' required placeholder='Casa do Guilherme' value='"+ f.getEndereco().get(i).getNome() +"'>");
          out.print("</div>");
            out.print("<br>");
            out.print("<div class='row'>");
                out.print("<div class='form-group col-md-6'>");
                    out.print("<label for='tipoResidencia"+ (i + 1) +"'>Tipo de Residencial:</label>");
                    out.print("<select class='form-control' id='tipoResidencia"+ (i + 1) +"' name='tipoResidencia"+ (i + 1) +"' required>");
                      out.print("<option> "+ f.getEndereco().get(i).getTipoResidencia() +"</option>");
                      out.print("<option>Casa</option>");
                      out.print("<option>apartamento</option>");
                      out.print("<option>Sitio</option>");
                      out.print("<option>Empresa</option>");
                      out.print("<option>outros</option>");
                    out.print("</select>");
                  out.print("</div>");
                  out.print("<div class='form-group col-md-6'>");
                      out.print("<label for='tipoLogradouro"+ (i + 1) +"'>Tipo de Logradouro:</label>");
                      out.print("<select class='form-control' id='tipoLogradouro"+ (i + 1) +"' name='tipoLogradouro"+ (i + 1) +"' required>");
                       out.print("<option> "+ f.getEndereco().get(i).getTipoLogradouro() +"</option>");
                        out.print("<option>Avenida</option>");
                        out.print("<option>Área</option>");
                        out.print("<option>Balneário</option>");
                        out.print("<option>Beco</option>");
                        out.print("<option>Comunidade</option>");
                        out.print("<option>Descida</option>");
                        out.print("<option>Destrito</option>");
                        out.print("<option>Estrada</option>");
                        out.print("<option>Favela</option>");
                        out.print("<option>Praça</option>");
                        out.print("<option>Parque</option>");
                        out.print("<option>Rua</option>");
                        out.print("<option>Vila</option>");
                        out.print("<option>Travessa</option>");
                      out.print("</select>");
                  out.print("</div>");
            out.print("</div>");
          out.print("<div class='row'>");
              out.print("<div class='form-group col-md-6'>");
                  out.print("<label for='logradouro"+ (i + 1) +"'>Logradouro:</label>");
                  out.print("<input type='text' value='"+ f.getEndereco().get(i).getLogradouro() + "' class='form-control' id='logradouro"+ (i + 1) +"' name='logradouro"+ (i + 1) +"'  placeholder='Ex: apartamento'>");
                out.print("</div>");
                out.print("<div class='form-group col-md-6'>");
                  out.print("<label for='numero"+ (i + 1) +"'>Número:</label>");
                  out.print("<input type='text' class='form-control' id='numero"+ (i + 1) +"' name='numero"+ (i + 1) +"' value='"+ f.getEndereco().get(i).getNumero() + "' minlength='1' required placeholder='Ex: 743 '>");
                out.print("</div>");
                out.print("<div class='form-group col-md-6'>");
                out.print("<label for='bairro"+ (i + 1) +"'>Bairro:</label>");
                out.print("<input type='text' class='form-control' id='bairro"+ (i + 1) +"' value='"+ f.getEndereco().get(i).getBairro() + "' name='bairro"+ (i + 1) +"' placeholder='Ex: Boa Vista'>");
              out.print("</div>");
                out.print("<div class='form-group col-md-6'>");
                  out.print("<label for='CEP"+ (i + 1) +"'>CEP:</label>");
                  out.print("<input type='text' class='form-control' id='CEP"+ (i + 1) +"' name='CEP"+ (i + 1) +"' value='"+ f.getEndereco().get(i).getCep() + "' pattern='[0-9]{5}-[0-9]{3}'  placeholder='Ex: 08690-112' >");
                out.print("</div>");
          out.print("</div>");
          out.print("<div class='row'>");
          out.print("<div class='form-group col-md-6'>");
              out.print("<label for='cidade"+ (i + 1) +"'>Cidade:</label>");
              out.print("<input type='text' class='form-contro"+ (i + 1) +"' id='cidade"+ (i + 1) +"' value='"+ f.getEndereco().get(i).getCidade() + "'   name='cidade"+ (i + 1) +"'  placeholder='Ex: Suzano'>");
            out.print("</div>");
            out.print("<div class='form-group col-md-6'>");
            out.print("<label for='estado"+ (i + 1) +"'>Estado:</label>");
            out.print("<input type='text' class='form-control' id='estado"+ (i + 1) +"' value='"+ f.getEndereco().get(i).getEstado() + "'   name='estado"+ (i + 1) +"'  placeholder='Ex: São Paulo'>");
          out.print("</div>");
          out.print("<div class='row'>");
              out.print("<div class='form-group col-md-6'>");
                  out.print("<label for='pais"+ (i + 1) +"'>Pais:</label>");
                  out.print("<input type='text' class='form-control' id='pais"+ (i + 1) +"' value='"+ f.getEndereco().get(i).getPais() + "' name='pais"+ (i + 1) +"'  placeholder='Ex: Brasil'>");
                out.print("</div>");
          out.print("</div>");
          out.print("</div>");
          out.print("</div>");
          out.print("<div align='center'>");
              out.print("<label>Tipo de endereço: &#160;&#160;</label>");
                out.print("<div class='form-check-inline'>");
                    out.print("<label class='form-check-label' for='entrega"+ (i + 1) +"'>");

                    if(f.getEndereco().get(i).isEntrega()){
                      out.print("<input type='checkbox' class='form-check-input' id='entrega"+ (i + 1) +"' name='entrega"+ (i + 1) +"' value='entrega' checked>Entrega");
                    }
                    else{ 
                       out.print("<input type='checkbox' class='form-check-input' id='entrega"+ (i + 1) +"' name='entrega"+ (i + 1) +"' value='entrega'>Entrega");
                    }
                  out.print("</label>");
                out.print("</div>");
                
                out.print("<div class='form-check-inline'>");
                out.print("<label class='form-check-label' for='cobrança"+ (i + 1) +"'>");

                  if(f.getEndereco().get(i).isCobranca()){
                    out.print("<input type='checkbox' class='form-check-input' id='cobranca"+ (i + 1) +"' name='cobranca"+ (i + 1) +"' value='cobranca' checked>Cobrança");
                  }
                  else{
                    out.print("<input type='checkbox' class='form-check-input' id='cobranca"+ (i + 1) +"' name='cobranca"+ (i + 1) +"' value='cobranca'>Cobrança");
                  }
                  out.print("</label>");
                out.print("</div>");
            out.print("</div>");
            out.print("<div class='form-group'>");
              out.print("<label for='complemento"+ (i + 1) +"'>Complemento:</label>");
              out.print("<textarea rows='5' class='form-control' id='complemento"+ (i + 1) +"' value='"+ f.getEndereco().get(i).getComplemento() + "' name='complemento"+ (i + 1) +"'></textarea>");
            out.print("</div>");
          out.print("<br>");
        out.print("</div>");
      out.print("</div>");
    }

	out.print("<input value='" + f.getEndereco().size() + "' style='display:none;' id='qtdEnd' name='qtdEnd'>");
  %>
  <br>
  <%
  for(int i = 0; i < f.getProduto().size(); i++){
	out.print("<div class='card'>");
	  out.print("<div class='card-body'>");
	    out.print("<h4> Produto: </h4>");
	
	    out.print("<br>");
	
	    out.print("<div class='row'>");
	        out.print("<div class='form-group col-md-6'>");
	            out.print("<label for='nomeProduto"+ (i + 1) +"'>Nome do Produto:</label>");
	            out.print("<input type='text' class='form-control' id='nomeProduto " + (i + 1) +"' name='nomeProduto "+ (i + 1) +"' required placeholder='Ex: Celular' value='"+ f.getProduto().get(i).getNome() + "'>");
	          out.print("</div>");
	          out.print("<div class='form-group col-md-6'>");
	            out.print("<label for='preco"+ (i + 1) +"'>Preço:</label>");
	            out.print("<input type='text' class='form-control' id='preco'+ (i + 1) + name='preco"+ (i + 1) +"' pattern='[0-9]{1}.[0-9]{3},[0-9]{3}' placeholder='Ex: 1.200,00' required value='"+ f.getProduto().get(i).getPreco() + "'>");
	          out.print("</div>");
	    out.print("</div>");
	    
	    out.print("<div class='row'>");
	        out.print("<div class='form-group col-md-6'>");
	            out.print("<label for='descricao"+ (i + 1) +"'>Descrição do Produto:</label>");
	            out.print("<input type='text' class='form-control' id='descricao"+ (i + 1) +"' name='descricao1 "+ (i + 1) +"' required placeholder='Digite a descrição do produto' value='"+ f.getProduto().get(i).getDescricao() + "'>");
	          out.print("</div>");
	          out.print("<div class='form-group col-md-6'>");
	            out.print("<label for='categoria1"+ (i + 1) +"'>Categoria do Produto:</label>");
	            out.print("<input type='text' class='form-control' id='categoria1' name='categoria"+ (i + 1) +"' required placeholder='Digite a categoria do produto' value='"+ f.getProduto().get(i).getCategoria() + "'>");
	          out.print("</div>");
	    out.print("</div>");
	    out.print("<div align='center'>");
	        out.print("<label>Produto padrão: &#160;&#160;</label>");
	          out.print("<div class='form-check-inline'>");
	              out.print("<label class='form-check-label' for='produtoPadrao"+ (i + 1) +"'>");
				  if(f.getProduto().get(i).isProdutoPadrao()){
						out.print("<input type='checkbox' class='form-check-input' id='produtoPadrao "+ (i + 1) +"' name='produtoPadrao "+ (i + 1) +"' value='produtoPadrao"+ (i + 1) +"' checked>Produto Padrão");
				  }else{
						out.print("<input type='checkbox' class='form-check-input' id='produtoPadrao "+ (i + 1) +"' name='produtoPadrao "+ (i + 1) +"' value='produtoPadrao"+ (i + 1) +"' checked>Produto Padrão");
				  }
	            out.print("</label>");
	          out.print("</div>");
	      out.print("</div>");
	    out.print("<br>");
	    out.print("<div id='novosProd'></div>");
	
	    out.print("<br>");
	    out.print("<button nome='addProd' type='button' class='btn btn-success' name='addProd' onclick='addProd()' text='Adicionar Produto'>Adicionar Produto</button>");
	  out.print("</div>");
	out.print("</div>");
  }
	%>
       <br>
		<div class="card">
		    <div class="card-body">
		        <h4> Cartão: </h4>
		
		        <br>
		
		        <div class="row">
		            <div class="form-group col-md-6">
		                <label for="nomeCartao">Nome Cartão:</label>
		                <input type="text" class="form-control" id="nomeCartao" name="nomeCartao" pattern="^[^-\s][a-zA-ZÀ-ú ]*" required placeholder="Ex: Djulia Camargo" value="<% out.print(f.getTelefone().getDdd()); %>">
		            </div>
		            <div class="form-group col-md-6">
		                <label for="numeroCartao">Número cartão:</label>
		                <input type="text" class="form-control" id="numeroCartao" name="numeroCartao" pattern="[0-9]{4} [0-9]{4} [0-9]{4} [0-9]{4}" required value="<% out.print(f.getTelefone().getDdd()); %>">
		            </div>
		        </div>
		            
		        <div class="row">
		            <div class="form-group col-md-6">
		                <label for="codSeguranca">Código de Segurança:</label>
		                <input type="text" class="form-control" id="codSeguranca" pattern="[0-9]{3}" name="codSeguranca" required value="<% out.print(f.getTelefone().getDdd()); %>">
		            </div>
		            <div class="form-group col-md-6">
		                <label for="bandeira">Bandeira:</label>
		                <input type="text" class="form-control" id="bandeira" pattern="^[^-\s][a-zA-ZÀ-ú ]*" name="bandeira" required value="<% out.print(f.getTelefone().getDdd()); %>">
		             </div>
		        </div>
		        <br>
		    </div>
		</div>
		<br>
          <div align="center">
              <input type="submit" name="OPERACAO" id="OPERACAO" value="ALTERAR" class="btn btn-success btn-lg">
              <button type="button" class="btn btn-danger btn-lg"><a href="perfil.jsp">CANCELAR</a></button>
          </div>
          <br>

          <input value="1" style="display:none;" id="qtdEnd" name="qtdEnd">
      </form>
    </div>

      <footer class="footer">
          <div class="container text-center">
            <span class=" text-muted">Fatec MC - Engenharia de Software III</span>
          </div>
        </footer>
    </body>
</html>