package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import model.c_usuarios;

public final class excluir_005fusuario_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write(" \n");
      out.write(" \n");
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
      banco_dados.usuarios usuario = null;
      synchronized (_jspx_page_context) {
        usuario = (banco_dados.usuarios) _jspx_page_context.getAttribute("usuario", PageContext.PAGE_SCOPE);
        if (usuario == null){
          usuario = new banco_dados.usuarios();
          _jspx_page_context.setAttribute("usuario", usuario, PageContext.PAGE_SCOPE);
        }
      }
      out.write(" \n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html> <head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /> \n");
      out.write("<title>SGC - Versão 1.0</title> \n");
      out.write("<link href=\"clinica_medica.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("</head> \n");
      out.write("<body class=\"FundoPagina\">\n");

ResultSet rsRegistro; 
boolean blnConectado;

c_usuarios Usuario = new c_usuarios(); 
int intCodigoUsuario = Integer.parseInt(request.getParameter("codigo_usuario")); 
blnConectado = false;
if (conexao.abrirConexao())
{
usuario.configuraraConexao(conexao.obterConexao());
rsRegistro = usuario.lerRegistro(intCodigoUsuario);

Usuario.setIdUsuario(rsRegistro.getString("Identificacao_Usuario"));
Usuario.setModuloAdministrativo(rsRegistro.getString("Modulo_Administrativo")); 
Usuario.setCadastroFuncionario(rsRegistro.getString("Cadastro_Funcionario")); 
Usuario.setCadastroUsuario(rsRegistro.getString("Cadastro_Usuario")); 
Usuario.setCadastroPaciente(rsRegistro.getString("Cadastro_Paciente")); 
Usuario.setCadastroEspecialidade(rsRegistro.getString("Cadastro_Especialidade")); 
Usuario.setCadastroMedico(rsRegistro.getString("Cadastro_Medico"));
Usuario.setCadastroConvenio(rsRegistro.getString("Cadastro_Convenio"));
Usuario.setModuloAgendamento(rsRegistro.getString("Modulo_Agendamento")); 
Usuario.setAgendamentoConsulta(rsRegistro.getString("Agendamento_Consulta")); 
Usuario.setCancelamentoConsulta(rsRegistro.getString("Cancelamento_Consulta")); 
Usuario.setModuloAtendimento(rsRegistro.getString("Modulo_Atendimento")); 
Usuario.setCodigoUsuario(intCodigoUsuario);
conexao.fecharConexao();
blnConectado = true;

} else
out.println("<p>Falha na conexão com o banco de dados!</p>");

      out.write('\n');
 if (blnConectado) {
      out.write(" <p class=\"TituloAplicacao\">SGC - Sistema de Gestão de Clínicas 1.0</p> \n");
      out.write("<p class=\"TituloPagina\">Cadastro de Usuários - Exclusão</p>\n");
      out.write("<form name=\"formExcluiUsuario\" method=\"post\" action=\"excluirUsuario\" target=\"_parent\"> \n");
      out.write("    <p>Nome do usuário: ");
      out.print(Usuario.getIdUsuario());
      out.write("</p> <br> \n");
      out.write("    <p>Módulo administrativo: ");
      out.print(Usuario.getModuloAdministrativo());
      out.write("</p> \n");
      out.write("    <p>&nbsp;&nbsp;&nbsp;&nbsp;Cadastro de funcionários: ");
      out.print(Usuario.getCadastroFuncionario());
      out.write("</p> \n");
      out.write("    <p>&nbsp;&nbsp;&nbsp;&nbsp;Cadastro de usuários: ");
      out.print(Usuario.getCadastroUsuario());
      out.write("</p> \n");
      out.write("    <p>&nbsp;&nbsp;&nbsp;&nbsp;Cadastro de especialidades: ");
      out.print(Usuario.getCadastroEspecialidade());
      out.write("</p>\n");
      out.write("    <p>&nbsp;&nbsp;&nbsp;&nbsp;Cadastro de médicos: ");
      out.print(Usuario.getCadastroMedico());
      out.write("</p>\n");
      out.write("    <p>&nbsp;&nbsp;&nbsp;&nbsp;Cadastro de convênios: ");
      out.print(Usuario.getCadastroConvenio());
      out.write("</p>\n");
      out.write("    <p>Módulo de agendamento: ");
      out.print(Usuario.getModuloAgendamento());
      out.write("</p> \n");
      out.write("    <p>&nbsp;&nbsp;&nbsp;&nbsp;Cadastro de pacientes: ");
      out.print(Usuario.getCadastroPaciente());
      out.write("</p>\n");
      out.write("    <p>&nbsp;&nbsp;&nbsp;&nbsp;Agendamento de consulta: ");
      out.print(Usuario. getAgendamentoConsulta());
      out.write("</p>\n");
      out.write("    <p>&nbsp;&nbsp;&nbsp;&nbsp;Cancelamento de consulta: ");
      out.print(Usuario. getCancelamentoConsulta());
      out.write("</p>\n");
      out.write("    <p>Módulo de atendimento médico: ");
      out.print(Usuario.getModuloAtendimento());
      out.write("</p> \n");
      out.write("    <p><input type=\"hidden\" name=\"codigo_usuario\" value=\"");
      out.print(intCodigoUsuario);
      out.write("\"></p>  \n");
      out.write("    <p><input type=\"submit\" name=\"btnExcluir\" value=\"Excluir\" />\n");
      out.write("    <span class=\"LinkVoltar\"><a href=\"javascript:history.back()\">[Voltar]</a></span> </p>\n");
      out.write("</form>\n");
      out.write("<p class=\"RodapePagina\">Copyright(c) 2020 - SebastiaoMM.</p>\n");
}
      out.write(" </body>\n");
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
