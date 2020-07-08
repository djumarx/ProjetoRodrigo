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
        <h1 class="text-center display-3">Alterar Senha</h1>
        </div>

      <div class="container">
        <form action="AlterarSenhaFornecedor" method="POST">
          
         <%
              Fornecedor f = (Fornecedor) session.getAttribute("fornecedor");  
              out.print("<input style='display:none;'  id='id' name='id' value='"+ f.getId() +"'>");
	          
         %>

          <div class="card">
            <div class="card-body">
              <h4> Alterar Senha:</h4>

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
      </form>
    </div>
          <br>

      <footer class="footer">
          <div class="container text-center">
            <span class=" text-muted">Fatec MC - Engenharia de Software III</span>
          </div>
        </footer>
    </body>
</html>