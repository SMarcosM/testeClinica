<%-- 
    Document   : editar_funcionario
    Created on : 12/12/2020, 00:29:33
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
            ResultSet rsRegistro;
            boolean blnConectado;
            String strDescricao = "";

            int intCodigo = Integer.parseInt(request.getParameter("Codigo"));
            blnConectado = false;

            if (conexao.abrirConexao()) {
                especialidade.configurarConexao(conexao.obterConexao());

                rsRegistro = Interger.parseInt(especialidade.listarRegistros(intCodigo));
                strDescricao = rsRegistro.getString("Codigo_Especialidade");

                conexao.fecharConexao();
                blnConectado = true;
            } else {
                out.println("<p>Falha na conexão com o banco de dados!</p>");
            }
        %>

        <%
           if (blnConectado) {%>
        <p class="TituloAplicacao">SGC - Sistema de Gerenciamento de Clínicas 1.0 </p>
        <p class="TituloPagina"> Cadastro de Funcionario</p>

        <form  name="formEditaDescricao" method="post" action="atualizarDescricao" target="_parent">

            <p>Descrição:
                
                <input type="text" name="txtNomeF" size="50" maxlength="50" value="<%=Funcionario.getNomeCompleto()%>"/>
            </p>

            
            <p>
                <input type="hidden" name="codigo_funcionario" value="<%=intCodigoFuncionario%>">
                <span class="LinkVoltar"><a href="javascript:history.back()">[Voltaar]</a> 
            </p>
        </form>
        <p class="RodapePagina">Copyright 2020 - SebastioMM</p> 
        <%}%>
    </body>
</html>
