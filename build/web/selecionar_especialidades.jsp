<%-- 
    Document   : listar_funcionario
    Created on : 12/12/2020, 19:08:22
    Author     : SEBASTIÃO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@page import="java.sql.ResultSet"%> 
<%@page import="java.util.Date" %>
<jsp:useBean id="conexao" scope="page" class="banco_dados.conexaoBancoDados"/> 
<jsp:useBean id="especialidade" scope="page" class="banco_dados.especialidades"/> 
<!DOCTYPE html>
<html> <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
        <title>SGC - Versão 1.0</title> <link href="clinica_medica.css" rel="stylesheet" type="text/css" />
    </head> 
    <body class="FundoPagina">
        <%
            ResultSet rsRegistros;
            if (conexao.abrirConexao()) {
                especialidade.configurarConexao(conexao.obterConexao());

                rsRegistros = especialidade.listarRegistros("DESCRIÇÃO");
                
                if (rsRegistros != null) {
                    out.println("<h2><center>Lista de especialidades</center></h2>");
                    out.println("<br>");
                    out.println("<table align='center' bgcolor='moccasin'>");
                    out.println("<tr><th>Especialidade médica</th><th></th><th></th></tr>");
                    while (rsRegistros.next()) {
                        out.print("<tr>");
                        out.print("<td>" + rsRegistros.getString("Descricao_Especialidade") + "</td>");
                        out.print("<td><a href='editar_especialidades.jsp?Codigo="+rsRegistros.getString("Codigo_Especialidade")+"'>Editar</a></td>");
                        out.print("<td><a href='excluir_especialidades.jsp?Codigo="+rsRegistros.getString("Codigo_Especialidade")+"'>Excluir</a></td>");
                       
                       
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
