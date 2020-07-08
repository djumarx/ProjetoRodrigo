
// Adicionar Endereços ao cadastro!
var contador = 1;
var contador1 = 1;

function addEndereco(){
    contador++;
    document.getElementById("qtdEnd").value = contador;
    document.getElementById("novosEnd").innerHTML +=
'<br><br>'+
'<div id="endereco'+contador+'" >'+
'<h4> Endereço - ' +contador+ ': </h4>'+
'<div class="form-group">'+
    '<label for="nomeEndereco' +contador+ '">Identificação do Endereço:</label>'+
    '<input type="text" name="nomeEndereco' +contador+ '" class="form-control" id="nomeEndereco' +contador+ '" required placeholder="Casa do Guilherme">'+
'</div>'+
  '<br>'+
  '<div class="row">'+
      '<div class="form-group col-md-6">'+
          '<label for="tpResidencia' +contador+ '">Tipo de Residencial:</label>'+
          '<select class="form-control" id="tpResidencia' +contador+ '" name="tpResidencia' +contador+ '" required>'+
            '<option>Casa</option>'+
            '<option>apartamento</option>'+
            '<option>Sitio</option>'+
            '<option>Empresa</option>'+
            '<option>outros</option>'+
          '</select>'+
        '</div>'+
        '<div class="form-group col-md-6">'+
            '<label for="tpLogradouro' +contador+ '">Tipo de Logradouro:</label>'+
           '<select class="form-control" id="tpLogradouro' +contador+ '" name="tpLogradouro' +contador+ '" required>'+
              '<option>Avenida</option>'+
              '<option>área</option>'+
              '<option>Balneário</option>'+
              '<option>Beco</option>'+
              '<option>Comunidade</option>'+
              '<option>Descida</option>'+
              '<option>Destrito</option>'+
              '<option>Estrada</option>'+
              '<option>Favela</option>'+
              '<option>Praça</option>'+
              '<option>Parque</option>'+
              '<option>Rua</option>'+
              '<option>Vila</option>'+
              '<option>Travessa</option>'+
            '</select>'+
        '</div>'+
  '</div>'+
'<div class="row">'+
    '<div class="form-group col-md-6">'+
        '<label for="logradouro' +contador+ '">Logradouro:</label>'+
        '<input type="text" class="form-control" id="logradouro' +contador+ '" name="logradouro' +contador+ '"  pattern="^[^-\s][a-zA-ZÀ-ú ]*" required placeholder="Ex: apartamento">'+
      '</div>'+
      '<div class="form-group col-md-6">'+
        '<label for="CEP' +contador+ '">CEP:</label>'+
        '<input type="text" class="form-control" id="CEP'+contador+'" name="CEP'+contador+'" pattern="[0-9]{5}-[0-9]{3}" title="Insira um CEP valido!" placeholder="Ex: 08690-112" required>'+
      '</div>'+
'</div>'+
'<div class="row">'+
    '<div class="form-group col-md-6">'+
        '<label for="pais' +contador+ '">Pais:</label>'+
        '<input type="text" class="form-control" id="pais' +contador+ '" name="pais' +contador+ '" required pattern="^[^-\s][a-zA-ZÀ-ú ]*" placeholder="Ex: Brasil">'+
      '</div>'+
      '<div class="form-group col-md-6">'+
        '<label for="estado' +contador+ '">Estado:</label>'+
        '<input type="text" class="form-control" id="estado' +contador+ '" name="estado' +contador+ '" required pattern="^[^-\s][a-zA-ZÀ-ú ]*" placeholder="Ex: São Paulo">'+
      '</div>'+
'</div>'+
'<div class="row">'+
    '<div class="form-group col-md-6">'+
       '<label for="cidade' +contador+ '">Cidade:</label>'+
        '<input type="text" class="form-control" id="cidade' +contador+ '" name="cidade' +contador+ '" required pattern="^[^-\s][a-zA-ZÀ-ú ]*" placeholder="Ex: Suzano">'+
      '</div>'+
      '<div class="form-group col-md-6">'+
        '<label for="bairro' +contador+ '">Bairro:</label>'+
        '<input type="text" class="form-control" id="bairro' +contador+ '" name="bairro' +contador+ '" required pattern="^[^-\s][a-zA-ZÀ-ú ]*" placeholder="Ex: Boa Vista">'+
      '</div>'+
'</div>'+
'<div class="row">'+
  '<div class="form-group col-md-6">'+
      '<label for="rua' +contador+ '">Rua:</label>'+
      '<input type="text" class="form-control" id="rua' +contador+ '" name="rua' +contador+ '" required pattern="^[^-\s][a-zA-ZÀ-ú ]*" placeholder="Ex: Jonas Profeta de Carvalho">'+
    '</div>'+
    '<div class="form-group col-md-6">'+
      '<label for="numero' +contador+ '">Número:</label>'+
      '<input type="text" minlength="1" class="form-control" id="numero' +contador+ '" name="numero' +contador+ '" required placeholder="Ex: 743 ">'+
    '</div>'+
'</div>'+
'<div align="center">'+
    '<label>Tipo de endereço: &#160;&#160;</label>'+
      '<div class="form-check-inline">'+
          '<label class="form-check-label" for="entrega'+contador+'">'+
          '<input type="checkbox" class="form-check-input" id="entrega'+contador+'" name="entrega'+contador+'" value="entrega" checked>Entrega'+
        '</label>'+
      '</div>'+
      '<div class="form-check-inline">'+
          '<label class="form-check-label" for="cobranca'+contador+'">'+
          '<input type="checkbox" class="form-check-input" id="cobranca'+contador+'" name="cobranca'+contador+'" value="cobranca" checked>Cobrança'+
        '</label>'+
      '</div>'+
  '</div>'+  
  '<div class="form-group">'+
      '<label for="observacao">Observações:</label>'+
      '<textarea rows="5" class="form-control" id="observacao'+contador+'" name="observacao'+contador+'"></textarea>'+
  '</div>'+
  '<button type="button" class="btn btn-danger" onclick="excluirEnd('+contador+')">Excluir Endereço - '+contador+' </button>'+
'<br>'+
'</div>';
}

function addProd(){
    contador1++;
    document.getElementById("qtdProd").value = contador;
    document.getElementById("novosProd").innerHTML +=
'<br><br>'+
'<div id="produto'+i+'" >'+
'<h4> Produto - ' +i+ ': </h4>'+
  '<br>'+
  '<div class="row">'+
      '<div class="form-group col-md-6">'+
          '<label for="nomeProduto' +i+ '">Nome do Produto:</label>'+
          '<input type="text" class="form-control" id="nomeProduto' +i+ '" name="nomeProduto' +i+ '" pattern="^[^-\s][a-zA-ZÀ-ú ]*" required placeholder="Ex: Celular">'+
        '</div>'+
	  '<div class="form-group col-md-6">'+
        '<label for="preco' +i+ '">Preço:</label>'+
        '<input type="text" class="form-control" id="preco' +i+ '" name="preco' +i+ '" pattern="[0-9]{1}.[0-9]{3},[0-9]{3}" placeholder="Ex: 1.200,00" required>'+
      '</div>'+
'</div>'+
'<div class="row">'+
    '<div class="form-group col-md-6">'+
        '<label for="descricao' +i+ '">Descrição do Produto:</label>'+
        '<input type="text" class="form-control" id="descricao' +i+ '" pattern="^[^-\s][a-zA-ZÀ-ú ]*" name="descricao' +i+ '" required placeholder="Digite a descrição do produto">'+
      '</div>'+
      '<div class="form-group col-md-6">'+
        '<label for="categoria' +i+ '">Categoria do Produto:</label>'+
        '<input type="text" class="form-control" id="categoria' +i+ '" name="categoria' +i+ '" required pattern="^[^-\s][a-zA-ZÀ-ú ]*" required placeholder="Digite a categoria do produto">'+
      '</div>'+
'</div>'+ 
  '<button type="button" class="btn btn-danger" onclick="excluirProd('+i+')">Excluir Produto - '+i+' </button>'+
'<br>'+
'</div>';
}

// Validar senha
function validarSenha(){ 
var senha = document.getElementById("senha").value;
var confSenha = document.getElementById("confSenha").value;

if(senha != confSenha){
  alert("Senhas diferentes! Digite novamente a senha e confirme no campo ao lado!");
  document.getElementById("senha").value = "";
  document.getElementById("confSenha").value = "";
}
}

function excluirEnd(){
  contador--;
  document.getElementById("qtdEnd").value = contador;
  
  if(contador == 1)
    document.getElementById("novosEnd").innerHTML = "";

  else{
    document.getElementById("novosEnd").innerHTML = "";
    for(i = 2; i < contador + 1; i++){
      document.getElementById("novosEnd").innerHTML += 
      '<br><br>'+
'<div id="endereco'+i+'" >'+
'<h4> Endereço - ' +i+ ': </h4>'+
'<div class="form-group">'+
    '<label for="nomeEndereco' +i+ '">Identificação do Endereço:</label>'+
    '<input type="text" name="nomeEndereco' +i+ '" class="form-control" id="nomeEndereco' +i+ '" required placeholder="Casa do Guilherme">'+
'</div>'+
  '<br>'+
  '<div class="row">'+
      '<div class="form-group col-md-6">'+
          '<label for="tpResidencia' +i+ '">Tipo de Residencial:</label>'+
          '<select class="form-control" id="tpResidencia' +i+ '" name="tpResidencia' +i+ '" required>'+
            '<option>Casa</option>'+
            '<option>apartamento</option>'+
            '<option>Sitio</option>'+
            '<option>Empresa</option>'+
            '<option>outros</option>'+
          '</select>'+
        '</div>'+
        '<div class="form-group col-md-6">'+
            '<label for="tpLogradouro' +i+ '">Tipo de Logradouro:</label>'+
           '<select class="form-control" id="tpLogradouro' +i+ '" name="tpLogradouro' +i+ '" required>'+
              '<option>Avenida</option>'+
              '<option>área</option>'+
              '<option>Balneário</option>'+
              '<option>Beco</option>'+
              '<option>Comunidade</option>'+
              '<option>Descida</option>'+
              '<option>Destrito</option>'+
              '<option>Estrada</option>'+
              '<option>Favela</option>'+
              '<option>Praça</option>'+
              '<option>Parque</option>'+
              '<option>Rua</option>'+
              '<option>Vila</option>'+
              '<option>Travessa</option>'+
            '</select>'+
        '</div>'+
  '</div>'+
'<div class="row">'+
    '<div class="form-group col-md-6">'+
        '<label for="logradouro' +i+ '">Logradouro:</label>'+
        '<input type="text" class="form-control" id="logradouro' +i+ '" name="logradouro' +i+ '"  pattern="^[^-\s][a-zA-ZÀ-ú ]*" required placeholder="Ex: apartamento">'+
      '</div>'+
      '<div class="form-group col-md-6">'+
        '<label for="CEP' +i+ '">CEP:</label>'+
        '<input type="number" class="form-control" id="CEP' +i+ '" name="CEP' +i+ '" placeholder="Ex: 08690-112" pattern="[0-9]{5}-[0-9]{3}" required>'+
      '</div>'+
'</div>'+
'<div class="row">'+
    '<div class="form-group col-md-6">'+
        '<label for="pais' +i+ '">Pais:</label>'+
        '<input type="text" class="form-control" id="pais' +i+ '" name="pais' +i+ '" required pattern="^[^-\s][a-zA-ZÀ-ú ]*" placeholder="Ex: Brasil">'+
      '</div>'+
      '<div class="form-group col-md-6">'+
        '<label for="estado' +i+ '">Estado:</label>'+
        '<input type="text" class="form-control" id="estado' +i+ '" name="estado' +i+ '" required pattern="^[^-\s][a-zA-ZÀ-ú ]*" placeholder="Ex: São Paulo">'+
      '</div>'+
'</div>'+
'<div class="row">'+
    '<div class="form-group col-md-6">'+
       '<label for="cidade' +i+ '">Cidade:</label>'+
        '<input type="text" class="form-control" id="cidade' +i+ '" name="cidade' +i+ '" required pattern="^[^-\s][a-zA-ZÀ-ú ]*" placeholder="Ex: Suzano">'+
      '</div>'+
      '<div class="form-group col-md-6">'+
        '<label for="bairro' +i+ '">Bairro:</label>'+
        '<input type="text" class="form-control" id="bairro' +i+ '" name="bairro' +i+ '" required pattern="^[^-\s][a-zA-ZÀ-ú ]*" placeholder="Ex: Boa Vista">'+
      '</div>'+
'</div>'+
'<div class="row">'+
  '<div class="form-group col-md-6">'+
      '<label for="rua' +i+ '">Rua:</label>'+
      '<input type="text" class="form-control" id="rua' +i+ '" name="rua' +i+ '" required pattern="^[^-\s][a-zA-ZÀ-ú ]*" placeholder="Ex: Jonas Profeta de Carvalho">'+
    '</div>'+
    '<div class="form-group col-md-6">'+
      '<label for="numero' +i+ '">Número:</label>'+
      '<input type="number" minlength="1" class="form-control" id="numero'  +i+ '" min="0" name="numero' +i+ '" required placeholder="Ex: 743 ">'+
    '</div>'+
'</div>'+
'<div align="center">'+
    '<label>Tipo de endereço: &#160;&#160;</label>'+
      '<div class="form-check-inline">'+
          '<label class="form-check-label" for="entrega' +i+ '">'+
          '<input type="checkbox" class="form-check-input" id="entrega' +i+ '" value="entrega" name="entrega'+i+'" checked>Entrega'+
        '</label>'+
      '</div>'+
      '<div class="form-check-inline">'+
          '<label class="form-check-label" for="cobrança' +i+ '">'+
          '<input type="checkbox" class="form-check-input" id="cobrança' +i+ '" name="cobranca' +i+ '" value="cobranca" checked>Cobrança'+
        '</label>'+
      '</div>'+
  '</div>'+  
  '<div class="form-group">'+
      '<label for="observacao">Observações:</label>'+
      '<textarea rows="5" class="form-control" id="observacao'+i+'" name="observacao'+i+'"></textarea>'+
  '</div>'+
  '<button type="button" class="btn btn-danger" onclick="excluirEnd('+i+')">Excluir Endereço - '+i+' </button>'+
'<br>'+
'</div>';
    }
  }
}

function excluirProd(){
  contador1--;
  document.getElementById("qtdProd").value = contador1;
  
  if(contador1 == 1)
    document.getElementById("novosProd").innerHTML = "";

  else{
    document.getElementById("novosProd").innerHTML = "";
    for(i = 2; i < contador1 + 1; i++){
      document.getElementById("novosProd").innerHTML += 
'<br><br>'+
'<div id="produto'+i+'" >'+
'<h4> Produto - ' +i+ ': </h4>'+
  '<br>'+
  '<div class="row">'+
      '<div class="form-group col-md-6">'+
          '<label for="nomeProduto' +i+ '">Nome do Produto:</label>'+
          '<input type="text" class="form-control" id="nomeProduto' +i+ '" name="nomeProduto' +i+ '" pattern="^[^-\s][a-zA-ZÀ-ú ]*" required placeholder="Ex: Celular">'+
        '</div>'+
	  '<div class="form-group col-md-6">'+
        '<label for="preco' +i+ '">Preço:</label>'+
        '<input type="text" class="form-control" id="preco' +i+ '" name="preco' +i+ '" pattern="[0-9]{1}.[0-9]{3},[0-9]{3}" placeholder="Ex: 1.200,00" required>'+
      '</div>'+
'</div>'+
'<div class="row">'+
    '<div class="form-group col-md-6">'+
        '<label for="descricao' +i+ '">Descrição do Produto:</label>'+
        '<input type="text" class="form-control" id="descricao' +i+ '" pattern="^[^-\s][a-zA-ZÀ-ú ]*" name="descricao' +i+ '" required placeholder="Digite a descrição do produto">'+
      '</div>'+
      '<div class="form-group col-md-6">'+
        '<label for="categoria' +i+ '">Categoria do Produto:</label>'+
        '<input type="text" class="form-control" id="categoria' +i+ '" name="categoria' +i+ '" required pattern="^[^-\s][a-zA-ZÀ-ú ]*" required placeholder="Digite a categoria do produto">'+
      '</div>'+
'</div>'+ 
  '<button type="button" class="btn btn-danger" onclick="excluirProd('+i+')">Excluir Produto - '+i+' </button>'+
'<br>'+
'</div>';
    }
  }
}