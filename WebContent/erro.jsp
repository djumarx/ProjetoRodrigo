<%@ page import="br.com.eng3.crud_fornecedor.dominio.*, java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title> ES3 - Cadastro de Fornecedor </title>

        <!-- Folha de Estilo CSS -->
        <link href="FormCadastro.css" rel="stylesheet" type="text/css">

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
              ES3 - Cadastro de Fornecedor
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

          <div id="container-fluid">
              <h1 class="text-center display-4"> ES3 - Cadastro de Fornecedor </h1>
              <p class="text-center display-6 font-italic"> Desculpe o transtorno... <br> Erro:...  
                <%
                Resultado resultado = (Resultado) session.getAttribute("resultado");
          
                if(resultado !=null && resultado.getMsg() != null){
                    out.print(resultado.getMsg());
                }

                %>
            </p>
            
              <br>
            
          </div>
      
    </body>
</html>