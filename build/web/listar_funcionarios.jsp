<%-- 
    Document   : listar_funcionario
    Created on : 12/12/2020, 19:08:22
    Author     : SEBASTIÃO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@page import="java.sql.ResultSet"%> 
<%@page import="java.util.Date" %>
<%@page import="model.c_funcionarios"%> 
<jsp:useBean id="conexao" scope="page" class="banco_dados.conexaoBancoDados"/> 
<jsp:useBean id="funcionario" scope="page" class="banco_dados.funcionarios"/> 
<jsp:useBean id="converter" scope="page" class="util.conversao"/>
<!DOCTYPE html>
<html> <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
        <title>SGC - Versão 1.0</title> <link href="clinica_medica.css" rel="stylesheet" type="text/css" />
    </head> 
    <body class="FundoPagina">
        <%
            ResultSet rsRegistros;
            if (conexao.abrirConexao()) {
                funcionario.configurarConexao(conexao.obterConexao());

                rsRegistros = funcionario.listarRegistro();
                
                if (rsRegistros != null) {
                    out.println("<h2><center>Lista de funcionários</center></h2>");
                    out.println("<br>");
                    out.println("<table align='center' bgcolor='moccasin'>");
                    out.println("<tr><th>NOme</th><th>RG</th><th>CPF</th><th>Nascimento</th>"
                            + "<th>Endereço</th></tr>");
                    while (rsRegistros.next()) {
                        out.print("<tr>");
                        out.print("<td>" + rsRegistros.getString("Nome_Completo") + "</td>");
                        out.print("<td>" + rsRegistros.getString("Numero_RG") + "</td>");
                        out.print("<td>" + rsRegistros.getString("Numeero_CPF") + "</td>");
                        out.print("<td>" + converter.DateToString(rsRegistros.getDate("Data_Nascimento")) + "</td>");
                        out.print("<td>" + rsRegistros.getString("Endereco") + "</td>");
                        out.print("</tr>");
                    }
                    out.println("</table>");
                    out.println("<br>");

                } else {
                    out.println("<p>Falha na exibição dos registros!</p>");
                }
                conexao.fecharConexao();
            } else {
                out.println("<p>Falha na conexão com o banco de dados!</p>");
            }

        %>

        <span class="LinkVoltar"><a href="javascript:history.back()">[Voltaar]</a> 
            <p class="RodapePagina">Copyright 2020 - SebastioMM</p>   
    </body>
</html>
