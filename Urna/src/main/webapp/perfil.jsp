<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="model.Papel"%>
<%@page import="model.Usuario"%>




<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
       <meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-type" content="text/html; charset=utf-8">
		<title>Perfil do Eleitor</title>
		<meta name="author" content="Victor Machado">
        <link rel="stylesheet" type="text/css" href="CSS/perfilchefedesecao.css"/>
        <script type="text/javascript" src="javascript/caixavotacao.js"></script>
        <script type="text/javascript" src="javascript/autorizavoto.js"></script>
        <script type="text/javascript" src="javascript/relatorio.js"></script>
        <script type="text/javascript" src="javascript/alertavoto.js"></script>


    </head>
    <body>
		<% Usuario u = (Usuario)request.getAttribute("usuarioLogado"); %>
        <!--CABEÇALHO-->
        <div class="geral">
		<div id="nav">
            <div id="topp">
			     <a  href="http://fatecsjc-prd.azurewebsites.net/" id="top-left">
				Faculdade de Tecnologia de São José dos Campos
			     </a>
            </div>
            <form name= votar id="toppp" action='Sair.action' method='post'>
                <input type="submit" value="Sair da Sessão">
            </form>
        </div>
        <div id="boxtitle">
        <div class="center">
                <img src="imagens/titulo3.png" id="titulo">
            </div>
        </div>
        <!--CABEÇALHO-->
        <div id="geral">
            <div id="title1">
                <center id="title2"> Dados do Eleitor</center>
			</div>
			<div style="height:auto; border-bottom:solid 2px;">
				<div style="margin-left:0.2%;  width:50%;" class="div-float">
					<b><%= u.getNome() %></b>
				</div>
				<div class="div-float">
					<b>Status:</b>
					<b><%= u.getAutorizacao() %></b>
				</div>
				<div class="div-clear"></div>
			</div>
			<div id="caixafotoperfil" class="picture">
                <img id="fotoperfil" src="imagens/perfilpadrao.png" width="180" height="200" title="fotoperfil">
            </div>
            
            
           <div id="informacoesperfil" class="row">
                <table border="1" cellspacing="10" style="margin-right: 50px; border: none; margin-bottom:2px;" class="row">
                    <tr>
                        <td>Data de Nascimento:</td>
                        <td>00/00/0000</td>
					</tr>
                       
                    <tr>	
						 <td>Registro Geral:</td>
                        <td>00000000</td>
                    </tr>
					<tr>
                        <td>CPF:</td>
                        <td>00000000000</td>
                    </tr>
					
                <tr>
                        <td>Número do Titulo:</td>
                        <td>000000000</td>
                    </tr>
					<tr>
                        <td>Naturalidade:</td>
                        <td>São Paulo</td>
                    </tr>
					 <tr>
                        <td>Local de Votação:</td>
                        <td>teste</td>
                    </tr>
				</table>
            </div>
            
            
            <div class="div-clear">
            </div>
        </div>
        
        <%for(Papel p: u.getPapeis()){
            if( p.getDescricao().equals("MESARIO") || p.getDescricao().equals("CHEFE_DE_SECAO") ){ %>
                <%@include file= "autorizar.jsp"%>
          <%} } %> 
        
        
        
         <div id="geral2">
            <div id="caixaresposta">
                <div id="textao1">
                    <b id="text1">Clique no botão para votar!!!</b>
                </div>
                <div>
                    <% if(u.getAutorizacao().equals("autorizado")){
                    out.print("<button type='button' id='button1' class='div-clear' onclick='liberaCaixaVotar()'>VOTAR</button>");
                    }%>
                        <%if(u.getAutorizacao().equals("nao autorizado")){
                    out.print("<button type='button' id='button1' class='div-clear' onclick='alertaVoto()' >VOTAR</button>");
                             }%>
                    <%if(u.getAutorizacao().equals("ja votou")){
                    out.print("<button type='button' id='button1' class='div-clear' onclick='alertaVoto2()' >VOTAR</button>");
                             }%>
                </div>
            </div>
        </div>
        
        <%@include file= "voto.jsp"%>
        
        
        
        <%for(Papel p: u.getPapeis()){
            if(p.getDescricao().equals("CHEFE_DE_SECAO") ){ %>
                <%@include file= "pagrelatorio.jsp"%>
          <%} } %> 
        
        
        
        
        <!--RODAPÉ-->
		<div id="boxrodape">
                    <img src="imagens/Rodap%C3%A9.png" id="imgrodape">
				    <a id="about" href="about.html">about</a>
				    <a id="contact" href="contact.html">contact</a>
        </div>
        <div id="bordaesquerda"></div>
        <div id="bordadireita"></div>
        <!--RODAPÉ-->
    </body>
</html>
