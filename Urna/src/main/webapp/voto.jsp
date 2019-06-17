<%-- 
    Document   : voto
    Created on : 28/05/2019, 14:07:02
    Author     : Victor.Machado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<form name= votar id="geral3"  class="caixaqueries" style="display: none;"  action='Votar.action' method='post'>
            <div class="caixavotacao">
                <div class="textovereador">
                    <b class="text1">Digite o número do seu voto para vereador:</b>
                </div>
                <div class="caixavotovereador">
                    <input id="votovereador" name='voto' type="text" maxlength="2" onkeypress="if (!isNaN(String.fromCharCode(window.event.keyCode))) return true; else return false;">
                </div>
                <div>
                    <button type="submit" id="button2" class="buttonqueries" onclick='liberaCaixaVotar()'>ConfirmarVoto</button>
                </div>
            </div>
</form>