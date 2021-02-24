package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.util.Date;
import model.c_funcionarios;

public final class excluir_005ffuncionario_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write(" \n");
      out.write(" \n");
      out.write("\n");
      out.write(" \n");
      banco_dados.conexaoBancoDados conexao = null;
      synchronized (_jspx_page_context) {
        conexao = (banco_dados.conexaoBancoDados) _jspx_page_context.getAttribute("conexao", PageContext.PAGE_SCOPE);
        if (conexao == null){
          conexao = new banco_dados.conexaoBancoDados();
          _jspx_page_context.setAttribute("conexao", conexao, PageContext.PAGE_SCOPE);
        }
      }
      out.write(' ');
      out.write('\n');
      banco_dados.funcionarios funcionario = null;
      synchronized (_jspx_page_context) {
        funcionario = (banco_dados.funcionarios) _jspx_page_context.getAttribute("funcionario", PageContext.PAGE_SCOPE);
        if (funcionario == null){
          funcionario = new banco_dados.funcionarios();
          _jspx_page_context.setAttribute("funcionario", funcionario, PageContext.PAGE_SCOPE);
        }
      }
      out.write(' ');
      out.write('\n');
      util.conversao converter = null;
      synchronized (_jspx_page_context) {
        converter = (util.conversao) _jspx_page_context.getAttribute("converter", PageContext.PAGE_SCOPE);
        if (converter == null){
          converter = new util.conversao();
          _jspx_page_context.setAttribute("converter", converter, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html> <head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /> \n");
      out.write("<title>SGC - Versão 1.0</title> \n");
      out.write("<link href=\"clinica_medica.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("</head> \n");
      out.write("<body class=\"FundoPagina\">\n");

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
        
      out.write("\n");
      out.write("\n");
      out.write("        ");

           if (blnConectado) {
      out.write("\n");
      out.write("        <p class=\"TituloAplicacao\">SGC - Sistema de Gerenciamento de Clínicas 1.0 </p>\n");
      out.write("        <p class=\"TituloPagina\"> Cadastro de Funcionario</p>\n");
      out.write("\n");
      out.write("        <form  name=\"formExcluirFuncionario\" method=\"post\" action=\"excluirFuncionario\" target=\"_parent\">\n");
      out.write("\n");
      out.write("            <p>Nome do funcionário:\n");
      out.write("                <input type=\"text\" name=\"txtNomeFuncionario\" size=\"50\" maxlength=\"50\" value=\"");
      out.print(Funcionario.getNomeCompleto());
      out.write("\"/>\n");
      out.write("            </p>\n");
      out.write("\n");
      out.write("            <p>Data de nascimento (dd/mm/aaaa):\n");
      out.write("                <input type=\"text\" name=\"txtDiaNascimento\" size=\"2\" maxlength=\"2\" value=\"");
      out.print(Funcionario.getDiaNascimento());
      out.write("\">/\n");
      out.write("                <input type=\"text\" name=\"txtMesNascimento\" size=\"2\" maxlength=\"2\" value=\"");
      out.print(Funcionario.getDiaNascimento());
      out.write("\">/\n");
      out.write("                <input type=\"text\" name=\"txtAnoNascimento\" size=\"4\" maxlength=\"4\" value=\"");
      out.print(Funcionario.getDiaNascimento());
      out.write("\">\n");
      out.write("            </p>\n");
      out.write("            ");

                   if (Funcionario.getSexo().equals("M")) {
      out.write("\n");
      out.write("            <p> - Sexo:\n");
      out.write("                <input type=\"radio\" name=\"rbSexo\" value=\"M\" checked=\"checked\">Masculino\n");
      out.write("                <input type=\"radio\" name=\"rbSexo\" value=\"F\" >Feminino\n");
      out.write("            </p> \n");
      out.write("            ");
} else {
      out.write("\n");
      out.write("            <p> - Sexo:\n");
      out.write("\n");
      out.write("                <input type=\"radio\" name=\"rbSexo\" value=\"M\" >Masculino\n");
      out.write("                <input type=\"radio\" name=\"rbSexo\" value=\"F\" checked=\"checked\">Feminino\n");
      out.write("            </p>\n");
      out.write("            ");
}
            
      out.write("\n");
      out.write("            <p>Número do RG:          \n");
      out.write("                <input type=\"text\" name=\"txtRG\" size=\"12\" maxlength=\"12\" value=\"");
      out.print(Funcionario.getNumeroRG());
      out.write("\">\n");
      out.write("                - Órgão emissor:\n");
      out.write("                <input type=\"text\" name=\"txtOrgaoEmissor\" size=\"6\" maxlength=\"6\" value=\"");
      out.print(Funcionario.getOrgaoEmissor());
      out.write("\">\n");
      out.write("                - Número do CPF:\n");
      out.write("                <input type=\"text\" name=\"txtCPF\" size=\"14\" maxlength=\"14\" value=\"");
      out.print(Funcionario.getNumeroCPF());
      out.write("\">\n");
      out.write("            </p>\n");
      out.write("\n");
      out.write("            <p>Endereço/Número:\n");
      out.write("                <input type=\"text\" name=\"txtEndereco\" size=\"50\" maxlength=\"50\" value=\"");
      out.print(Funcionario.getEndereco());
      out.write("\">\n");
      out.write("                <input type=\"text\" name=\"txtNumero\" size=\"15\" maxlength=\"15\" value=\"");
      out.print(Funcionario.getNumero());
      out.write("\">\n");
      out.write("            </p>\n");
      out.write("\n");
      out.write("            <p>Complemento:\n");
      out.write("                <input type=\"text\" name=\"txtComplemento\" size=\"30\" maxlength=\"30\" value=\"");
      out.print(Funcionario.getComplemento());
      out.write("\">\n");
      out.write("                - Bairro:\n");
      out.write("                <input type=\"text\" name=\"txtBairro\" size=\"40\" maxlength=\"40\" value=\"");
      out.print(Funcionario.getBairro());
      out.write("\">\n");
      out.write("            </p>\n");
      out.write("\n");
      out.write("            <p>Cidade:\n");
      out.write("                <input type=\"text\" name=\"txtCidade\" size=\"40\" maxlength=\"40\" value=\"");
      out.print(Funcionario.getCidade());
      out.write("\">\n");
      out.write("                - Estado:\n");
      out.write("                <input type=\"text\" name=\"txtEstado\" size=\"2\" maxlength=\"2\" value=\"");
      out.print(Funcionario.getEstado());
      out.write("\">\n");
      out.write("            </p>\n");
      out.write("\n");
      out.write("            <p>Telefone:\n");
      out.write("                <input type=\"text\" name=\"txtTelefone\" size=\"20\" maxlength=\"20\" value=\"");
      out.print(Funcionario.getTelefone());
      out.write("\">\n");
      out.write("                - Celular:\n");
      out.write("                <input type=\"text\" name=\"txtCelular\" size=\"20\" maxlength=\"20\" value=\"");
      out.print(Funcionario.getCelular());
      out.write("\">\n");
      out.write("            </p>\n");
      out.write("\n");
      out.write("            <p>Número CTPS:\n");
      out.write("                <input type=\"text\" name=\"txtCTPS\" size=\"20\" maxlength=\"20\" value=\"");
      out.print(Funcionario.getNumeroCTPS());
      out.write("\">\n");
      out.write("                - Número do PIS:\n");
      out.write("                <input type=\"text\" name=\"txtPIS\" size=\"20\" maxlength=\"20\" value=\"");
      out.print(Funcionario.getNumeroPIS());
      out.write("\">\n");
      out.write("            </p>\n");
      out.write("\n");
      out.write("            <p>\n");
      out.write("                <input type=\"hidden\" name=\"codigo_funcionario\" value=\"");
      out.print(intCodigoFuncionario);
      out.write("\">\n");
      out.write("                <br>\n");
      out.write("            </p>\n");
      out.write("            <p>\n");
      out.write("                <input type=\"submit\"  name=\"btnExcluir\" value=\"Excluir\">\n");
      out.write("                <span class=\"LinkVoltar\"><a href=\"javascript:history.back()\">[Voltaar]</a> \n");
      out.write("            </p>\n");
      out.write("        </form>\n");
      out.write("        <p class=\"RodapePagina\">Copyright 2020 - SebastioMM</p> \n");
      out.write("        ");
}
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
