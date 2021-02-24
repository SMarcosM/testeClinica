package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import model.c_usuarios;

public final class editar_005fusuario_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /> \n");
      out.write("        <title>SGC - Versão 1.0</title> <link href=\"clinica_medica.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("    </head> \n");
      out.write("    <body class=\"FundoPagina\">\n");
      out.write("        ");

            ResultSet rsRegistro;
            boolean blnConectado;

            c_usuarios Usuario = new c_usuarios();
            int intCodigoUsuario = Integer.parseInt(request.getParameter("codigo_usuario"));
            blnConectado = false;
            if (conexao.abrirConexao()) {
                usuario.configuraraConexao(conexao.obterConexao());

                rsRegistro = usuario.lerRegistro(intCodigoUsuario);

                Usuario.setIdUsuario(rsRegistro.getString("Identificacao_Usuario"));
                Usuario.setSenhaAcesso(rsRegistro.getString("Senha_Acesso"));
                Usuario.setCadastroFuncionario(rsRegistro.getString("Cadastro_Funcionario"));
                Usuario.setCadastroUsuario(rsRegistro.getString("Cadastro_Usuario"));
                Usuario.setCadastroPaciente(rsRegistro.getString("Cadastro_Paciente"));
                Usuario.setCadastroEspecialidade(rsRegistro.getString("Cadastro_Especialidade"));
                Usuario.setCadastroMedico(rsRegistro.getString("Cadastro_Medico"));
                Usuario.setCadastroConvenio(rsRegistro.getString("Cadastro_Convenio"));
                Usuario.setAgendamentoConsulta(rsRegistro.getString("Agendamento_Consulta"));
                Usuario.setCancelamentoConsulta(rsRegistro.getString("Cancelamento_Consulta"));
                Usuario.setModuloAdministrativo(rsRegistro.getString("Modulo_Administrativo"));
                Usuario.setModuloAgendamento(rsRegistro.getString("Modulo_Agendamento"));
                Usuario.setModuloAtendimento(rsRegistro.getString("Modulo_Atendimento"));
                Usuario.setCodigoUsuario(intCodigoUsuario);

                conexao.fecharConexao();
                blnConectado = true;
            } else {
                out.println("<p>Falha na conexão com o banco de dados!</p>");
            }
       
      out.write("\n");
      out.write("       \n");
      out.write("       ");
 if (blnConectado) {
      out.write(" <p class=\"TituloAplicacao\">SGC - Sistema de Gestão de Clínicas 1.0</p> <p class=\"TituloPagina\">Cadastro de Funcionários - Edição</p>\n");
      out.write("<form name=\"formEditaUsuario\" method=\"post\" action=\"atualizarUsuario\" target=\"_parent\"> <p>Nome do usuário: <input type=\"text\" name=\"txtNomeUsuario\" size=\"20\" maxlength=\"20\"\n");
      out.write("value=\"");
      out.print(Usuario.getIdUsuario());
      out.write("\"/></p>\n");
 if(Usuario.getModuloAdministrativo().equals("S")) { 
      out.write("\n");
      out.write("<p><input name=\"chkAdministrativo\" type=\"checkbox\" value=\"ModuloAdministrativo\" checked=\"checked\" />Módulo administrativo</p>\n");
 }
else
{ 
      out.write("\n");
      out.write("<p><input name=\"chkAdministrativo\" type=\"checkbox\" value=\"ModuloAdministrativo\" />Módulo administrativo</p>\n");
 } 
      out.write('\n');
 if(Usuario.getCadastroFuncionario().equals("S")) { 
      out.write("\n");
      out.write("<p>&nbsp;&nbsp;&nbsp;&nbsp;<input name=\"chkFuncionario\" type=\"checkbox\" value=\"Funcionario\" checked=\"checked\"/>Cadastro de funcionários</p>\n");
 }
else
{ 
      out.write("\n");
      out.write("<p>&nbsp;&nbsp;&nbsp;&nbsp;<input name=\"chkFuncionario\" type=\"checkbox\" value=\"Funcionario\" />Cadastro de funcionários</p>\n");
 } 
      out.write('\n');
 if(Usuario.getCadastroUsuario().equals("S")) { 
      out.write("\n");
      out.write("<p>&nbsp;&nbsp;&nbsp;&nbsp;<input name=\"chkUsuario\" type=\"checkbox\" value=\"Usuario\" checked=\"checked\"/>Cadastro de usuários</p>/>\n");
 }
else
{ 

      out.write("\n");
      out.write("<p>&nbsp;&nbsp;&nbsp;&nbsp;<input name=\"chkUsuario\" type=\"checkbox\" value=\"Usuario\" checked=\"checked\"/>Cadastro de usuários</p>\n");
 } 
      out.write('\n');
      out.write('\n');
 if(Usuario.getCadastroEspecialidade().equals("S")) { 
      out.write("\n");
      out.write("<p>&nbsp;&nbsp;&nbsp;&nbsp;<input name=\"chkEspecialidade\" type=\"checkbox\" value=\"Especialidade\" checked=\"checked\"/>Cadastro de especialidades</p>\n");
 }
else
{ 
      out.write("\n");
      out.write("<p>&nbsp;&nbsp;&nbsp;&nbsp;<input name=\"chkEspecialidade\" type=\"checkbox\" value=\"Especialidade\" />Cadastro de especialidades</p>\n");
 } 
      out.write('\n');
 if(Usuario.getCadastroMedico().equals("S")) { 
      out.write("\n");
      out.write("<p>&nbsp;&nbsp;&nbsp;&nbsp;<input name=\"chkMedico\" type=\"checkbox\" value=\"Medico\" checked=\"checked\"/>Cadastro de médicos</p>\n");
 }
else
{ 
      out.write("\n");
      out.write("<p>&nbsp;&nbsp;&nbsp;&nbsp;<input name=\"chkMedico\" type=\"checkbox\" value=\"Medico\"/>Cadastro de médicos</p>   \n");
 } 
      out.write('\n');
 if(Usuario.getCadastroConvenio().equals("S")) { 
      out.write("\n");
      out.write("<p>&nbsp;&nbsp;&nbsp;&nbsp;<input name=\"chkConvenio\" type=\"checkbox\" value=\"Convenio\" checked=\"checked\"/>Cadastro de convênios</p>\n");
      out.write("\n");
      out.write("\n");
 }
else
{ 
      out.write("\n");
      out.write("<p>&nbsp;&nbsp;&nbsp;&nbsp;<input name=\"chkConvenio\" type=\"checkbox\" value=\"Convenio\" convênios</p> ");
 } 
      out.write('\n');
 if(Usuario.getModuloAgendamento().equals("S")) { 
      out.write("\n");
      out.write("<p><input name=\"chkAgendamento\" type=\"checkbox\" value=\"ModuloAgendamento\" checked=\"checked\"/>Módulo de agendamento</p>\n");
 }
else
{ 
      out.write("\n");
      out.write("<p><input name=\"chkAgendamento\" type=\"checkbox\" value=\"ModuloAgendamento\" />Módulo de agendamento</p>\n");
 } 
      out.write('\n');
 if(Usuario.getCadastroPaciente().equals("S")) { 
      out.write("\n");
      out.write("<p>&nbsp;&nbsp;&nbsp;&nbsp;<input name=\"chkPaciente\" type=\"checkbox\" value=\"Paciente\" checked=\"checked\"/>Cadastro de pacientes</p>\n");
      out.write("/>Cadastro de\n");
 }
else
{ 
      out.write("\n");
      out.write("<p>&nbsp;&nbsp;&nbsp;&nbsp;<input name=\"chkPaciente\" type=\"checkbox\" value=\"Paciente\" pacientes</p> ");
 } 
      out.write('\n');
 if(Usuario.getAgendamentoConsulta().equals("S")) { 
      out.write("\n");
      out.write("<p>&nbsp;&nbsp;&nbsp;&nbsp;<input name=\"chkAgendarConsulta\" type=\"checkbox\" value=\"AgendarConsulta\" checked=\"checked\"/>Agendamento de consulta</p>\n");
 }
else
{ 
      out.write("\n");
      out.write("<p>&nbsp;&nbsp;&nbsp;&nbsp;<input name=\"chkPaciente\" type=\"checkbox\" value=\"Paciente\" pacientes</p> ");
 } 
      out.write('\n');
 if(Usuario.getAgendamentoConsulta().equals("S")) { 
      out.write("\n");
      out.write("<p>&nbsp;&nbsp;&nbsp;&nbsp;<input name=\"chkAgendarConsulta\" type=\"checkbox\" value=\"AgendarConsulta\" checked=\"checked\"/>Agendamento de consulta</p>\n");
 }
else
{ 
      out.write("\n");
      out.write("<p>&nbsp;&nbsp;&nbsp;&nbsp;<input name=\"chkAgendarConsulta\" type=\"checkbox\" value=\"AgendarConsulta\" />Agendamento de consulta</p>\n");
 } 
      out.write('\n');
 if(Usuario.getCancelamentoConsulta().equals("S")) { 
      out.write("\n");
      out.write("<p>&nbsp;&nbsp;&nbsp;&nbsp;<input name=\"chkCancelarConsulta\" type=\"checkbox\" value=\"CancelarConsulta\" checked=\"checked\"/>Cancelamento de consulta</p>\n");
 }
else
{ 
      out.write("\n");
      out.write("\n");
      out.write("<p>&nbsp;&nbsp;&nbsp;&nbsp;<input name=\"chkCancelarConsulta\" type=\"checkbox\" value=\"CancelarConsulta\" />Cancelamento de consulta</p>\n");
 } 
      out.write('\n');
 if(Usuario.getModuloAtendimento().equals("S")) { 
      out.write("\n");
      out.write("<p><input name=\"chkAtendimento\" type=\"checkbox\" value=\"ModuloAtendimento\" checked=\"checked\"/>Módulo de atendimento médico</p>\n");
 }
else
{ 
      out.write("\n");
      out.write("<p><input name=\"chkAtendimento\" type=\"checkbox\" value=\"ModuloAtendimento\" />Módulo de atendimento médico</p>\n");
 } 
      out.write("\n");
      out.write("<p>\n");
      out.write("<input type=\"hidden\" name=\"codigo_usuario\" value=\"");
      out.print(intCodigoUsuario);
      out.write("\">\n");
      out.write("<input type=\"hidden\" name=\"senha_acesso\" value=\"");
      out.print(Usuario.getSenhaAcesso());
      out.write("\"> </p>\n");
      out.write("<br> <p><input type=\"submit\" name=\"btnAtualizar\" value=\"Atualizar\" />\n");
      out.write("<span class=\"LinkVoltar\"><a href=\"javascript:history.back()\">[Voltar]</a></span> </p>\n");
      out.write("</form>\n");
      out.write("<p class=\"RodapePagina\">Copyright(c) 2020 - SebastiaoMM.</p>\n");
}
      out.write("\n");
      out.write("   </body>\n");
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
