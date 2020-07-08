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
            <a class="navbar-brand ">
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
        <h1 class="text-center display-3">Alterar Endereço Fornecedor</h1>
        </div>

      <div class="container">
        <form action="AlterarEndereçoFornecedor" method="POST">
          
          
          <%
              Fornecedor f = (Fornecedor) session.getAttribute("fornecedor");  
              out.print("<input style='display:none;'  id='id' name='id' value='"+ f.getId() +"'>");
	          
         %>


          <div class="card">
            <div class="card-body">
              <h4> Alterar endereço fornecedor:</h4>

          <br>
          
<%
	
    for(int i = 0; i < f.getEndereco().size(); i++){

      out.print("<div class='card'>");
        out.print("<div class='card-body'>");
          out.print("<h4> Endereço "+ (i + 1) +": </h4>");
          out.print("<div class='form-group'>");
              out.print("<label for='nomeEndereco1'>Identificação do Endereço - "+ (i + 1) +":</label>");
              out.print("<input type='text' name='nomeEndereco"+ (i + 1) +"' class='form-control' id='nomeEndereco"+ (i + 1) +"' minlength='5' maxlength='30' required placeholder='Casa do Guilherme' value='"+ f.getEndereco().get(i).getNome() +"'>");
          out.print("</div>");
            out.print("<br>");
            out.print("<div class='row'>");
                out.print("<div class='form-group col-md-6'>");
                    out.print("<label for='tpResidencia"+ (i + 1) +"'>Tipo de Residencial:</label>");
                    out.print("<select class='form-control' id='tpResidencia"+ (i + 1) +"' name='tpResidencia"+ (i + 1) +"' required>");
                      out.print("<option> "+ f.getEndereco().get(i).getTipoResidencia() +"</option>");
                      out.print("<option>Casa</option>");
                      out.print("<option>apartamento</option>");
                      out.print("<option>Sitio</option>");
                      out.print("<option>Empresa</option>");
                      out.print("<option>outros</option>");
                    out.print("</select>");
                  out.print("</div>");
                  out.print("<div class='form-group col-md-6'>");
                      out.print("<label for='tpLogradouro"+ (i + 1) +"'>Tipo de Logradouro:</label>");
                      out.print("<select class='form-control' id='tpLogradouro"+ (i + 1) +"' name='tpLogradouro"+ (i + 1) +"' required>");
                       out.print("<option> "+ f.getEndereco().get(i).getLogradouro() +"</option>");
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
                  out.print("<label for='CEP"+ (i + 1) +"'>CEP:</label>");
                  out.print("<input type='text' class='form-control' id='CEP"+ (i + 1) +"' name='CEP"+ (i + 1) +"' value='"+ f.getEndereco().get(i).getCep() + "' pattern='[0-9]{5}-[0-9]{3}'  placeholder='Ex: 08690-112' >");
                out.print("</div>");
          out.print("</div>");
          out.print("<div class='row'>");
              out.print("<div class='form-group col-md-6'>");
                  out.print("<label for='pais"+ (i + 1) +"'>Pais:</label>");
                  out.print("<input type='text' class='form-control' id='pais"+ (i + 1) +"' value='"+ f.getEndereco().get(i).getPais() + "' name='pais"+ (i + 1) +"'  placeholder='Ex: Brasil'>");
                out.print("</div>");
                out.print("<div class='form-group col-md-6'>");
                  out.print("<label for='estado"+ (i + 1) +"'>Estado:</label>");
                  out.print("<input type='text' class='form-control' id='estado"+ (i + 1) +"' value='"+ f.getEndereco().get(i).getEstado() + "'   name='estado"+ (i + 1) +"'  placeholder='Ex: São Paulo'>");
                out.print("</div>");
          out.print("</div>");
          out.print("<div class='row'>");
              out.print("<div class='form-group col-md-6'>");
                  out.print("<label for='cidade"+ (i + 1) +"'>Cidade:</label>");
                  out.print("<input type='text' class='form-contro"+ (i + 1) +"' id='cidade"+ (i + 1) +"' value='"+ f.getEndereco().get(i).getCidade() + "'   name='cidade"+ (i + 1) +"'  placeholder='Ex: Suzano'>");
                out.print("</div>");
                out.print("<div class='form-group col-md-6'>");
                  out.print("<label for='bairro"+ (i + 1) +"'>Bairro:</label>");
                  out.print("<input type='text' class='form-control' id='bairro"+ (i + 1) +"' value='"+ f.getEndereco().get(i).getBairro() + "' name='bairro"+ (i + 1) +"' placeholder='Ex: Boa Vista'>");
                out.print("</div>");
          out.print("</div>");
          out.print("<div class='row'>");
            out.print("<div class='form-group col-md-6'>");
                out.print("<label for='rua"+ (i + 1) +"'>Rua:</label>");
                out.print("<input type='text' class='form-control'  value='"+ f.getEndereco().get(i).getLogradouro() + "' id='rua"+ (i + 1) +"' name='rua"+ (i + 1) +"'  placeholder='Ex: Jonas Profeta de Carvalho'>");
              out.print("</div>");
              out.print("<div class='form-group col-md-6'>");
                out.print("<label for='numero"+ (i + 1) +"'>Número:</label>");
                out.print("<input type='text' class='form-control' id='numero"+ (i + 1) +"' name='numero"+ (i + 1) +"' value='"+ f.getEndereco().get(i).getNumero() + "' minlength='1' required placeholder='Ex: 743 '>");
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
              out.print("<textarea rows='5' class='form-control' id='complemento"+ (i + 1) +"' value='"+ f.getEndereco().get(i).getComplemento() + "' name='Complemento"+ (i + 1) +"'></textarea>");
            out.print("</div>");
          out.print("<br>");
        out.print("</div>");
      out.print("</div>");
    }

	out.print("<input value='" + f.getEndereco().size() + "' style='display:none;' id='qtdEnd' name='qtdEnd'>");
  %>
          <br>

          <div align="center">
              <input type="submit" name="OPERACAO" id="OPERACAO" value="ALTERAR" class="btn btn-success btn-lg">
              <button type="button" class="btn btn-danger btn-lg"><a href="perfil.jsp">CANCELAR</a></button>
          </div>
          <br>
</div>
</div>
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