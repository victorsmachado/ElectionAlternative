<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Papel"%>
<%@page import="model.Usuario"%>
<%@page import="model.Candidato"%>
<%@page import="model.ListaCandidato"%>

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
		<title>Sistema de Votação</title>
		<meta name="author" content="Victor Machado">
        <link rel="stylesheet" type="text/css" href="CSS/relatorio.css"/>
        

    </head>
    <body>
        <% ListaCandidato lc = (ListaCandidato)request.getAttribute("candidatos");%>
        

        <div>
            <div id="nav">
                <div>
		<a  href="http://fatecsjc-prd.azurewebsites.net/" id="top-left">
		Faculdade de Tecnologia de São José dos Campos - Prof. Jessen Vidal
		</a>
		</div>
	    </div>
	    <div id="boxtitle">
                <img src="imagens/titulo3.png" id="titulo">
	    </div>
        </div>
        
    <div id="relatorio" class="group">
        <div class="table1">
            <ul>
            <% for(Candidato c: lc.getCandidatos() ){ %>
            <li><%= c.getNome()%></li>
            <li><%= c.getQtdvotos()%></li>
            <%} %>
            </ul>
        </div>
    </div>
<div style="margin-left:90%;">
    <input type="button" value="Voltar" onClick="history.go(-1)">
</div>
       
        
        
<div id="boxrodape" style="clear: left">
    <img src="imagens/Rodap%C3%A9.png" id="imgrodape"> 
    <a id="about" href="about.html">about</a>
    <a id="contact" href="contact.html">contact</a>
</div>
        
    </body>
</html>

