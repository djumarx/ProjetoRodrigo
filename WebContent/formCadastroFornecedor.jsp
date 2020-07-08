<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title> Cadastre-se! </title>

        <!-- Código Javascript -->
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
              ES3 - Cadastro de Fornecedor
            </a>
            
             <!-- Links -->
             <ul class="navbar-nav">
                  <li class="nav-item">
                      <a class="nav-link" href="formCadastroFornecedor.jsp">Cadastrar-se</a>
                    </li>
                <li class="nav-item">
                    <a class="nav-link" href="pesquisa.jsp">Pesquisar</a>
                </li>
              </ul>
          </nav>
          
          <br>

      <div class="container">
        <h1 class="text-center display-3">Cadastre-se!</h1>
      </div>

        <form action="SalvarFornecedor" method="POST">

            <div class="card">
                <div class="card-body">
                    <h4> Dados do Fornecedor:</h4>

                    <label for="nome">Nome:</label>
                    <input type="text" pattern="^[^-\s][a-zA-ZÀ-ú ]*" title="Insira somente letras!" class="form-control" id="nome" name="nome" placeholder="Ex: Djulia Camargo " required onblur="ola()">
                    <br>



                    <div class="row">
                        <div class="form-group col-md-4">
                            <label for="genero">Gênero:</label>
                            <select class="form-control" id="genero" name="genero" required>
                                <option>Feminino</option>
                                <option>Masculino</option>
                                <option>Outros</option>
                            </select>
                        </div>

                        <div class="form-group col-md-4">
                            <label for="dataNascimento">Data de nascimento:</label>
                            <input type="date" class="form-control" id="dataNascimento" required maxlength="10" name="dataNascimento" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" min="1900-01-01" max="2004-01-01" />
                        </div>

                        <div class="form-group col-md-4">
                            <label for="CNPJ">CNPJ:</label>
                            <input type="text" class="form-control" id="CNPJ" pattern="\d{2}\.?\d{3}\.?\d{3}\/?\d{4}-?\d{2}" name="CNPJ" title="Insira um CNPJ valido! ex: 47.123.456/0000-73 "required placeholder="Ex: 47.123.456/0000-73">
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
                                <option>celular</option>
                                <option>residencial</option>
                                <option>empresarial</option>
                            </select>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="ddd">DDD:</label>
                            <input type="number" class="form-control" id="ddd" pattern="[0-9]+$" title="Sómente números!" name="ddd" min="11" max="99" required>
                        </div>
                        <div class="form-group col-md-5">
                            <label for="numeroTel">Número:</label>
                            <input type="tel" class="form-control" minlength="9" maxlength="9" id="numeroTel" title="Somente números! tamanho minumo 8 digitos maximo 9 digitos!" name="numeroTel" required placeholder="Ex: 987654321">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email">Email:</label>
                        <input type="email" class="form-control" id="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" title="Insira um email valido!" name="email" required placeholder="Ex:  joao.765@hotmail.com.br">
                    </div>
                    <div class="row">
                        <div class="form-group col-md-6">
                            <label for="senha">Senha:</label>
                            <input type="password" class="form-control" pattern="((?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,15})" title="A senha deve conter no minimo 8 caracteres, ter letras maisculas e minusculas, números além de conter caracteres especiais!" id="senha" name="senha" required>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="confSenha">Confirmar senha:</label>
                            <input type="password" class="form-control" onblur="validarSenha()" pattern="((?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,15})" title="A senha deve conter no minimo 8 caracteres, ter letras maisculas e minusculas, números além de conter caracteres especiais!" id="confSenha" name="confSenha" required>
                        </div>
                    </div>

                </div>
            </div>

            <br>

            <div class="card">
                <div class="card-body">
                    <h4> Endereço: </h4>
                    <div class="form-group">
                        <label for="nomeEndereco1">Identificação do Endereço:</label>
                        <input type="text" name="nomeEndereco1" class="form-control" id="nomeEndereco1" minlength="5" maxlength="30" required placeholder="Fabrica">
                    </div>

                    <br>
                    <div class="row">
                        <div class="form-group col-md-6">
                            <label for="tipoResidencia1">Tipo de Residencia:</label>
                            <select class="form-control" id="tipoResidencia1" name="tipoResidencia1" required>
                                <option>Casa</option>
                                <option>apartamento</option>
                                <option>Sitio</option>
                                <option>Empresa</option>
                                <option>outros</option>
                            </select>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="tipoLogradouro1">Tipo de Logradouro:</label>
                            <select class="form-control" id="tipoLogradouro1" name="tipoLogradouro1" required>
                                <option>Avenida</option>
                                <option>área</option>
                                <option>Balneário</option>
                                <option>Beco</option>
                                <option>Comunidade</option>
                                <option>Descida</option>
                                <option>Destrito</option>
                                <option>Estrada</option>
                                <option>Favela</option>
                                <option>Praça</option>
                                <option>Parque</option>
                                <option>Rua</option>
                                <option>Vila</option>
                                <option>Travessa</option>
                            </select>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-6">
                            <label for="logradouro1">Logradouro:</label>
                            <input type="text" class="form-control" id="logradouro1" name="logradouro1" pattern="^[^-\s][a-zA-ZÀ-ú ]*" required placeholder="Ex: Rua Batatais">
                            <div class="form-group col-md-6">
                                <label for="numero1">Número:</label>
                                <input type="text" class="form-control" id="numero1" min="0" name="numero1" minlength="1" required placeholder="Ex: 743 ">
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="CEP1">CEP:</label>
                            <input type="text" class="form-control" id="CEP1" name="CEP1" pattern="[0-9]{5}-[0-9]{3}" title="Insira um CEP valido!" placeholder="Ex: 08690-112" required>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-6">
                            <label for="pais1">Pais:</label>
                            <input type="text" class="form-control" id="pais1" pattern="^[^-\s][a-zA-ZÀ-ú ]*" title="Insira um pais valido!" name="pais1" required placeholder="Ex: Brasil">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="estado1">Estado:</label>
                            <input type="text" class="form-control" id="estado1" pattern="^[^-\s][a-zA-ZÀ-ú ]*" title="Insira um estado valido!" name="estado1" required placeholder="Ex: São Paulo">
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-6">
                            <label for="cidade1">Cidade:</label>
                            <input type="text" class="form-control" id="cidade1" pattern="^[^-\s][a-zA-ZÀ-ú ]*" title="Insira uma cidade valida!"  name="cidade1" required placeholder="Ex: Suzano">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="bairro1">Bairro:</label>
                            <input type="text" class="form-control" id="bairro1" pattern="^[^-\s][a-zA-ZÀ-ú ]*" title="Insira um bairro valido!"  name="bairro1" required placeholder="Ex: Boa Vista">
                        </div>
                    </div>

                    <div align="center">
                        <label>Tipo de endereço: &#160;&#160;</label>
                        <div class="form-check-inline">
                            <label class="form-check-label" for="entrega1">
                                <input type="checkbox" class="form-check-input" id="entrega1" name="entrega1" value="entrega" checked>Entrega
                            </label>
                        </div>
                        <div class="form-check-inline">
                            <label class="form-check-label" for="cobranca1">
                                <input type="checkbox" class="form-check-input" id="cobranca1" name="cobranca1" value="cobranca" checked>Cobrança
                            </label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="complemento1">Complemento:</label>
                        <textarea rows="5" class="form-control" id="complemento1" name="complemento1"></textarea>
                    </div>
                    <br>

                    <div id="novosEnd"></div>

                    <br>
                    <button nome="addEnd" type="button" class="btn btn-success" name="addEnd" onclick='addEndereco()' text="Adicionar Endereço">Adicionar Endereço</button>
                </div>
            </div>

            <br>

            <div class="card">
                <div class="card-body">
                    <h4> Produto: </h4>

                    <br>

                    <div class="row">
                        <div class="form-group col-md-6">
                            <label for="nomeProduto1">Nome do Produto:</label>
                            <input type="text" class="form-control" id="nomeProduto1" name="nomeProduto1" pattern="^[^-\s][a-zA-ZÀ-ú ]*" required placeholder="Ex: Celular">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="preco1">Preço:</label>
                            <input type="text" class="form-control" id="preco1" name="preco1" pattern="[0-9]{1}.[0-9]{3},[0-9]{3}" placeholder="Ex: 1.200,00" required>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-6">
                            <label for="descricao1">Descrição do Produto:</label>
                            <input type="text" class="form-control" id="descricao1" pattern="^[^-\s][a-zA-ZÀ-ú ]*" name="descricao1" required placeholder="Digite a descrição do produto">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="categoria1">Categoria do Produto:</label>
                            <input type="text" class="form-control" id="categoria1" pattern="^[^-\s][a-zA-ZÀ-ú ]*" name="categoria1" required placeholder="Digite a categoria do produto">
                        </div>
                    </div>
                    <div align="center">
                        <label>Produto padrão: &#160;&#160;</label>
                        <div class="form-check-inline">
                            <label class="form-check-label" for="produtoPadrao">
                                <input type="checkbox" class="form-check-input" id="produtoPadrao" name="produtoPadrao" value="produtoPadrao" checked>Produto Padrão
                            </label>
                        </div>
                    </div>
                    <br>
                    <div id="novosProd"></div>

                    <br>
                    <button nome="addProd" type="button" class="btn btn-success" name="addProd" onclick='addProd()' text="Adicionar Produto">Adicionar Produto</button>
                </div>
            </div>
            <br>
            <div class="card">
                <div class="card-body">
                    <h4> Cartão: </h4>

                    <br>

                    <div class="row">
                        <div class="form-group col-md-6">
                            <label for="nomeCartao">Nome Cartão:</label>
                            <input type="text" class="form-control" id="nomeCartao" name="nomeCartao" pattern="^[^-\s][a-zA-ZÀ-ú ]*" required placeholder="Ex: Djulia Camargo">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="numeroCartao">Número cartão:</label>
                            <input type="text" class="form-control" id="numeroCartao" name="numeroCartao" pattern="[0-9]{4} [0-9]{4} [0-9]{4} [0-9]{4}" required>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-6">
                            <label for="codSeguranca">Código de Segurança:</label>
                            <input type="text" class="form-control" id="codSeguranca" pattern="[0-9]{3}" name="codSeguranca" required>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="bandeira">Bandeira:</label>
                            <input type="text" class="form-control" id="bandeira" pattern="^[^-\s][a-zA-ZÀ-ú ]*" name="bandeira" required>
                        </div>
                    </div>
                    <br>
                </div>
            </div>

            <br>

            <div align="center">
                <input type="submit" name="OPERACAO" id="OPERACAO" value="SALVAR" class="btn btn-success btn-lg">
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