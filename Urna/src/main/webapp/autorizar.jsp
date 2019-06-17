<%-- 
    Document   : autenticar
    Created on : 09/11/2017, 16:56:06
    Author     : fabriciogmc
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Papel"%>
<%@page import="model.Usuario"%>
<form name =autorizar id='geral6'  class='caixaqueries' action='Autorizar.action' method='post'>
        <div class='caixavotacao'>
            <div class='textovereador'>
                <b class='text1'>Autorizar Voto, digite o cpf do usuario:</b>
            </div>
            <div class='caixavotovereador'>
                <input id='autorizavoto' name='autorizavoto' type='text' maxlength='11' onkeypress='if (!isNaN(String.fromCharCode(window.event.keyCode))) return true; else return false;'>
            </div>
            <div>
                <button type='submit' id='button3' class='buttonqueries' onclick='autorizaVoto()'>AutorizarVoto</button>
            </div>
        </div>
</form>