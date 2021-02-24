/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import model.c_funcionarios;
import banco_dados.conexaoBancoDados;
import banco_dados.funcionarios;

/**
 *
 * @author SEBASTIÃO
 */
public class atualizarFuncionarios extends HttpServlet {

    private String codigo_funcionario;

    @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
            {PrintWriter out;
             response.setContentType("text/html;charset=UTF-8");
            out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println(" <meta  http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />");
            out.println("<title>SGC - Versão 1.0</title>");
            out.println(" <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("</head>");
            out.println("<body class='FundoPagina'>");
            out.println("<p class='TituloAplicacao'>SGC - Sistema de Gestao de Clinicas 1.0</p>");
            out.println("<p class='TituloPagina'>Cadastro de Funcionario</p>"); 
        
    try{

                conexaoBancoDados conexao = new conexaoBancoDados(); 
                funcionarios funcionario = new funcionarios();
                c_funcionarios Funcionario = new c_funcionarios(
                    request.getParameter("txtNomeFuncionario"),
                    request.getParameter("txtRG"),
                    request.getParameter("txtOrgaoEmissor"),
                    request.getParameter("txtCPF"),
                    request.getParameter("txtEndereço"),
                    request.getParameter("txtNumero"),
                    request.getParameter("txtComplemento"),
                    request.getParameter("txtBairro"),
                    request.getParameter("txtCidade"),
                    request.getParameter("lstEstado"),
                    request.getParameter("txtTelefone"),
                    request.getParameter("txtCelular"),
                    String.valueOf(request.getParameter("rbSexo").charAt(0)),
                    request.getParameter("txtCTPS"),
                    request.getParameter("txtPIS"),
                    request.getParameter("txtDiaNascimento"),
                    request.getParameter("txtMesNascimento"),
                    request.getParameter("txtAnoNascimento"));
                    Funcionario.setCodigoFuncionario(Integer.parseInt(request.getParameter(codigo_funcionario)));
                        
                        
                        if(conexao.abrirConexao())
                             {
                funcionario.configurarConexao(conexao.obterConexao());
                 if (funcionario.alterarRegistro(Funcionario)) 
                {
                    out.println("<h2>Dados do funcionário atualizado com sucesso!</h2>");
                    out.println("<br><br><br><br>");
                    out.println("<a href='menu_funcionario.html'>Voltar</a>");
                } else 
                    out.println("<h2>Nao foi possivel atualizar os dados do funcionário!</h2>");
                
                conexao.fecharConexao();
            } else {
                out.println("<h2>Nao foi possivel estabelecer conexao com o banco de dados!</h2>");
                }
            }catch(Exception erro) 
                    {
                     erro.printStackTrace();
                    out.println("<h2>Erro do sistema: processo de cadastro de funcionário!</h2>");
                     }
            out.println("<p class=\"RodapePagina\">Copyright (c) 2020 - SebastiaoMM</p>");
            out.println("</body>");
            out.println("</html>");
        
    }
}
