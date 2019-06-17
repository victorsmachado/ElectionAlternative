<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    String contexto = request.getContextPath();
    if (!contexto.equals(""))
        contexto = contexto + "/";
%>


<!DOCTYPE html>

<html>
    <head>
       <meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-type" content="text/html; charset=utf-8">
		<title>Sistema de Votação</title>
		<meta name="author" content="Victor Machado">
        <link rel="stylesheet" type="text/css" href="CSS/autentificacao.css"/>
        <script type="text/javascript" src="javascript/login.js"></script>

    </head>
    <body>
        <div class="geral">
		<div id="nav">
            <div>
			<a  href="http://fatecsjc-prd.azurewebsites.net/" id="top-left">
				Faculdade de Tecnologia de São José dos Campos - Prof. Jessen Vidal
			</a>
			 <nav>
				<a id="top-center-right" href="https://github.com/victorsmachado?tab=repositories">meu github</a>
				<a id="top-right" href="#">Área administrativa</a>
			 </nav>
            </div>
        </div>
        <div id="boxtitle">
        <div class="center">
                <img src="imagens/titulo3.png" id="titulo">
            </div>
        </div>
        <div class="boxcentro">
        
        </div>
        
        <b></b>
        <form name=login id="boxcenter" action="Autenticador.action" method="post">
            <div id ="box">
                <p id="autentuser"> Autenticação de Usuario do Sistema </p>
                <p class="login1">Username</p>
                <input type="text" name="nomeUsuario" required class="login2">
                <p class="login1">Password</p>
                <input type="password" name="senha" required class="login2">   
                <input type="submit" id="button1"  style="margin-top: 10px" value="Entrar" >
            </div>
        </form>
        
        <div class="boxcentro">
        </div>
        
        
		<div id="boxrodape">
                    <img src="imagens/Rodap%C3%A9.png" id="imgrodape"> 
				    <a id="about" href="about.html">about</a>
				    <a id="contact" href="contact.html">contact</a>
        </div>
        
    </body>
</html>
