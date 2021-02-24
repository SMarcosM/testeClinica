<%-- 
    Document   : excluir_funcionario
    Created on : 12/12/2020, 18:14:22
    Author     : SEBASTIÃO
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@page import="java.sql.ResultSet"%> 
<%@page  import ="java.util.Date"%>
<%@page import="model.c_funcionarios"%> 
<jsp:useBean id="conexao" scope="page" class="banco_dados.conexaoBancoDados"/> 
<jsp:useBean id="funcionario" scope="page" class="banco_dados.funcionarios"/> 
<jsp:useBean id="converter" scope="page" class="util.conversao"/>
<!DOCTYPE html>
<html> <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<title>SGC - Versão 1.0</title> 
<link href="clinica_medica.css" rel="stylesheet" type="text/css" />
</head> 
<body class="FundoPagina">
<%
            ResultSet rsRegistro;
            Date dtDataNascimento;
            int intDia, intMes, intAno;
            boolean blnConectado;

            c_funcionarios Funcionario = new c_funcionarios();
            int intCodigoFuncionario = Integer.parseInt(request.getParameter("codigo_funcionarios"));
            blnConectado = false;

            if (conexao.abrirConexao()) {
                funcionario.configurarConexao(conexao.obterConexao());

                rsRegistro = funcionario.lerRegistro(intCodigoFuncionario);

                dtDataNascimento = rsRegistro.getDate("Data_Nascimento");

                intDia = converter.DiaData(dtDataNascimento);
                intMes = converter.MesData(dtDataNascimento);
                intAno = converter.AnoData(dtDataNascimento);

                Funcionario.setNomeCompleto(rsRegistro.getString("Nome_Completo"));
                Funcionario.setNumeroRG(rsRegistro.getString("Numero_RG"));
                Funcionario.setOrgaoEmissor(rsRegistro.getString("Orgao_Emissor"));
                Funcionario.setNumeroCPF(rsRegistro.getString("Numero_CPF"));
                Funcionario.setEndereco(rsRegistro.getString("Endereco"));
                Funcionario.setNumero(rsRegistro.getString("Numero"));
                Funcionario.setComplemento(rsRegistro.getString("Complemnto"));
                Funcionario.setBairro(rsRegistro.getString("Bairro"));
                Funcionario.setCidade(rsRegistro.getString("Cidade"));
                Funcionario.setEstado(rsRegistro.getString("Estado"));
                Funcionario.setTelefone(rsRegistro.getString("Telefone"));
                Funcionario.setCelular(rsRegistro.getString("Celular"));
                Funcionario.setNumeroCTPS(rsRegistro.getString("Numero_CTPS"));
                Funcionario.setNumeroPIS(rsRegistro.getString("Numero_PIS"));
                Funcionario.setDataNascimento(Integer.toString(intDia), Integer.toString(intMes), Integer.toString(intAno));
                Funcionario.setSexo(rsRegistro.getString("Sexo"));

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

        <form  name="formExcluirFuncionario" method="post" action="excluirFuncionario" target="_parent">

            <p>Nome do funcionário:
                <input type="text" name="txtNomeFuncionario" size="50" maxlength="50" value="<%=Funcionario.getNomeCompleto()%>"/>
            </p>

            <p>Data de nascimento (dd/mm/aaaa):
                <input type="text" name="txtDiaNascimento" size="2" maxlength="2" value="<%=Funcionario.getDiaNascimento()%>">/
                <input type="text" name="txtMesNascimento" size="2" maxlength="2" value="<%=Funcionario.getDiaNascimento()%>">/
                <input type="text" name="txtAnoNascimento" size="4" maxlength="4" value="<%=Funcionario.getDiaNascimento()%>">
            </p>
            <%
                   if (Funcionario.getSexo().equals("M")) {%>
            <p> - Sexo:
                <input type="radio" name="rbSexo" value="M" checked="checked">Masculino
                <input type="radio" name="rbSexo" value="F" >Feminino
            </p> 
            <%} else {%>
            <p> - Sexo:

                <input type="radio" name="rbSexo" value="M" >Masculino
                <input type="radio" name="rbSexo" value="F" checked="checked">Feminino
            </p>
            <%}
            %>
            <p>Número do RG:          
                <input type="text" name="txtRG" size="12" maxlength="12" value="<%=Funcionario.getNumeroRG()%>">
                - Órgão emissor:
                <input type="text" name="txtOrgaoEmissor" size="6" maxlength="6" value="<%=Funcionario.getOrgaoEmissor()%>">
                - Número do CPF:
                <input type="text" name="txtCPF" size="14" maxlength="14" value="<%=Funcionario.getNumeroCPF()%>">
            </p>

            <p>Endereço/Número:
                <input type="text" name="txtEndereco" size="50" maxlength="50" value="<%=Funcionario.getEndereco()%>">
                <input type="text" name="txtNumero" size="15" maxlength="15" value="<%=Funcionario.getNumero()%>">
            </p>

            <p>Complemento:
                <input type="text" name="txtComplemento" size="30" maxlength="30" value="<%=Funcionario.getComplemento()%>">
                - Bairro:
                <input type="text" name="txtBairro" size="40" maxlength="40" value="<%=Funcionario.getBairro()%>">
            </p>

            <p>Cidade:
                <input type="text" name="txtCidade" size="40" maxlength="40" value="<%=Funcionario.getCidade()%>">
                - Estado:
                <input type="text" name="txtEstado" size="2" maxlength="2" value="<%=Funcionario.getEstado()%>">
            </p>

            <p>Telefone:
                <input type="text" name="txtTelefone" size="20" maxlength="20" value="<%=Funcionario.getTelefone()%>">
                - Celular:
                <input type="text" name="txtCelular" size="20" maxlength="20" value="<%=Funcionario.getCelular()%>">
            </p>

            <p>Número CTPS:
                <input type="text" name="txtCTPS" size="20" maxlength="20" value="<%=Funcionario.getNumeroCTPS()%>">
                - Número do PIS:
                <input type="text" name="txtPIS" size="20" maxlength="20" value="<%=Funcionario.getNumeroPIS()%>">
            </p>

            <p>
                <input type="hidden" name="codigo_funcionario" value="<%=intCodigoFuncionario%>">
                <br>
            </p>
            <p>
                <input type="submit"  name="btnExcluir" value="Excluir">
                <span class="LinkVoltar"><a href="javascript:history.back()">[Voltaar]</a> 
            </p>
        </form>
        <p class="RodapePagina">Copyright 2020 - SebastioMM</p> 
        <%}%>
    </body>
</html>
