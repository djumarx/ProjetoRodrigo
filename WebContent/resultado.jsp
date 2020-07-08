<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="br.com.eng3.crud_fornecedor.dominio.*, java.util.*" %>

<!DOCTYPE html>

<html lang="pt-br">
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title> Resultado </title>

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
          </nav>

          <h1 style="text-align:center" class="display-3">Resultado</h1>
          <br>

          
          <%
		        Resultado resultado = (Resultado) session.getAttribute("resultado");
          
	        if(resultado !=null && resultado.getMsg() != null){
                out.print(resultado.getMsg());
            }
         %>

          <div class="container">
            <table class="table table-striped">
                <thead>
                  <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>CNPJ</th>
                    <th>Perfil</th>
                  </tr>
                </thead>
                <tbody>
	<%
	
              if (resultado != null) {
                 List<EntidadeDominio> entidades = resultado.getEntidades();
                 if(entidades != null){
                    for (int i = 0; i < entidades.size(); i++) {
                        Fornecedor f = (Fornecedor) entidades.get(i);
                        out.print("<tr>");
                        out.print("<td>" + f.getId() + "</td>");
                        out.print("<td>"+ f.getNome()+"</td>");
                        out.print("<td>"+ f.getCnpj()+"</td>");
               
                        out.print("<td><form action='PerfilFornecedor' method='POST'><input name='id' id='id' value='"+f.getId()+
                        		"' style='display:none'><input type='submit' id='OPERACAO' " +
                        		"name='OPERACAO' value='PERFIL' class='btn btn-outline-info btn-sm'></form></td>");
                        out.print("</tr>");
                 	}
                }
              }

	%>

		        </tbody>
              </table>
          </div>
        
    </body>
</html>