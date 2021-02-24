package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import banco_dados.conexaoBancoDados;
import banco_dados.especialidades;

/**
 * @author SEBASTIÃO
 */
public class inserirEspecialidades extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String strDescricao;
            PrintWriter out;
            
            strDescricao = request.getParameter("txtDescricao");
            response.setContentType("text/html;charset=UTF-8");
            out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
        out.println("<title>SGC - Versao 1.0</title>");
        out.println("<link href='clinica_medica.css' rel='stylesheet' type='text/css' />");
        out.println("<body class='FundoPagina'>");
        out.println("<p class='TituloAplicacao'>SGC - Sistema de Gestao de Clinicas 1.0</p>");
        out.println("<p class='TituloPagina'>Cadastro de Especialidades</p>");

        try {
            conexaoBancoDados conexao = new conexaoBancoDados();
            especialidades especialidade = new especialidades();
            
            if (conexao.abrirConexao()) 
            {
                especialidade.configurarConexao(conexao.obterConexao());

                if (especialidade.inserirRegistro(strDescricao)) 
                {
                    out.println("<h2>Especialidade cadastrada com sucesso!</h2>");
                    out.println("<br><br><br><br>");
                    out.println("<a href='inserir_especialidades.html'>Voltar</a>");
                } else {
                    out.println("<h2>Nao foi possivel cadastrar a especialidade!</h2>");
                }

                conexao.fecharConexao();
            } else {
                out.println("<h2>Nao foi possivel estabelecer conexao com o banco de dados!</h2>");
            }
        } catch (Exception erro) {
            erro.printStackTrace();
            out.println("<h2>Erro do sistema: processo de cadastro de especialidades!</h2>");
        }
        out.println("<p class='RodapePagina'>Copyright(c) 2020 - SebastiaoMM</p>");
        out.println("</body>");
        out.println("</html>");
    }
}


