package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class insere_005fespecialidade_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write('\n');
      banco_dados.especialidades especialidade = null;
      synchronized (_jspx_page_context) {
        especialidade = (banco_dados.especialidades) _jspx_page_context.getAttribute("especialidade", PageContext.PAGE_SCOPE);
        if (especialidade == null){
          especialidade = new banco_dados.especialidades();
          _jspx_page_context.setAttribute("especialidade", especialidade, PageContext.PAGE_SCOPE);
        }
      }
      out.write(" \n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Conexão com Banco de Dados</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h2>Conexão com banco de dados</h2>\n");
      out.write("        ");

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
