/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author SEBASTIÃO
 */
public class c_pacientes extends c_pessoa {

    private int codigo_paciente;
    private String tem_convenio;
    private int codigo_convenio;
    private String senha_acesso;

    public c_pacientes() {
        super("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
        tem_convenio = "N";
        codigo_convenio = 0;
        senha_acesso = "";
    }

    public c_pacientes(String nome_completo,
            String numero_rg,
            String orgao_emissor,
            String numero_cpf,
            String endereco,
            String numero,
            String complemento,
            String bairro,
            String cidade,
            String estado,
            String telefone,
            String celular,
            String sexo,
            String dia_nascimento,
            String mes_nascimento,
            String ano_nascimento) {
        super(nome_completo, numero_rg, orgao_emissor,
                numero_cpf, endereco, numero, complemento,
                bairro, cidade, estado, telefone, celular,
                sexo, dia_nascimento, mes_nascimento, ano_nascimento);
    }

    public int getCodigo_paciente() {
        return codigo_paciente;
    }

    public void setCodigo_paciente(int codigo_paciente) {
        this.codigo_paciente = codigo_paciente;
    }

    public String getTem_convenio() {
        return tem_convenio;
    }

    public void setTem_convenio(String tem_convenio) {
        this.tem_convenio = tem_convenio;
    }

    public int getCodigo_convenio() {
        return codigo_convenio;
    }

    public void setCodigo_convenio(int codigo_convenio) {
        this.codigo_convenio = codigo_convenio;
    }

    public String getSenha_acesso() {
        return senha_acesso;
    }

    public void setSenha_acesso(String senha_acesso) {
        this.senha_acesso = senha_acesso;
    }
    
}
