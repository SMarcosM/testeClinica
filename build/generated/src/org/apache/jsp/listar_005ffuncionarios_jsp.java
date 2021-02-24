package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.util.Date;
import model.c_funcionarios;

public final class listar_005ffuncionarios_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("\n");
      out.write("%@page contentType=\"text/html\" pageEncoding=\"UTF-8\"%> \n");
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
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /> \n");
      out.write("        <title>SGC - Versão 1.0</title> <link href=\"clinica_medica.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("    </head> \n");
      out.write("    <body class=\"FundoPagina\">\n");
      out.write("        ");

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

        
      out.write("\n");
      out.write("\n");
      out.write("        <span class=\"LinkVoltar\"><a href=\"javascript:history.back()\">[Voltaar]</a> \n");
      out.write("            <p class=\"RodapePagina\">Copyright 2020 - SebastioMM</p>   \n");
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
