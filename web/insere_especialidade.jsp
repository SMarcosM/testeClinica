<%-- 
    Document   : insere_especialidade
    Created on : 24/11/2020, 20:32:48
    Author     : SEBASTIÃO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<jsp:useBean id="conexao" scope="page" class="banco_dados.conexaoBancoDados"/>
<jsp:useBean id="especialidade" scope="page" class="banco_dados.especialidades"/> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Conexão com Banco de Dados</title>
    </head>
    <body>
        <h2>Conexão com banco de dados</h2>
        <%
            if (conexao.abrirConexao()) {
                especialidade.configurarConexao(conexao.obterConexao());

                if (especialidade.inserirRegistro("Pediatria")) {
                    out.println("<h2>Especialidade cadastrada com sucesso!</h2>");
                } else {
                    out.println("<h3>Erro ao tentar cadastrar especialidade!</h3>");
                }
                conexao.fecharConexao();

            } else {
                out.println("<p>Falha na conexão com o banco de dados!</p>");
            }

        %>
    </body>
</html>
