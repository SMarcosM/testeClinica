package model;

/**
 * @author SEBASTIÃO
 */
public class c_pessoa {
   private  String
    nome_completo,       
    numero_rg ,
    orgao_emissor,
    numero_cpf,
    endereco,
    numero,
    complemento,
    bairro,
    cidade,
    estado,
    telefone,
    celular,
    sexo,
    dia_nascimento,
    mes_nascimento,
    ano_nascimento;

public c_pessoa( String nome_completo,
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
            String ano_nascimento 
        )
    {
        this.nome_completo = nome_completo; 
        this.numero_rg = numero_rg; 
        this.orgao_emissor = orgao_emissor; 
        this.numero_cpf = numero_cpf; 
        this.endereco = endereco; 
        this.numero = numero; 
        this.complemento = complemento; 
        this.bairro = bairro;
        this.cidade = cidade; 
        this.estado = estado; 
        this.telefone = telefone; 
        this.celular = celular; 
        this.sexo = sexo; 
        this.dia_nascimento = dia_nascimento; 
        this.mes_nascimento = mes_nascimento; 
        this.ano_nascimento = ano_nascimento;
    }

    public String getNomeCompleto() { return nome_completo;}
    public void setNomeCompleto(String nome_completo) {    this.nome_completo = nome_completo;    }

    public String getNumeroRG() { return numero_rg; }
    public void setNumeroRG(String numero_rg) {  this.numero_rg = numero_rg;    }

    public String getOrgaoEmissor() {   return orgao_emissor;    }
    public void setOrgaoEmissor(String orgao_emissor) {   this.orgao_emissor = orgao_emissor;    }

    public String getNumeroCPF() {  return numero_cpf;    }
    public void setNumeroCPF(String numero_cpf) {   this.numero_cpf = numero_cpf;    }
     
    public String getEndereco() { return endereco;    }
    public void setEndereco(String endereco) {  this.endereco = endereco;    }

    public String getNumero() {    return numero;    }
    public void setNumero(String numero) { this.numero = numero;    }

    public String getComplemento() {  return complemento;    }
    public void setComplemento(String complemento) {  this.complemento = complemento;    }
      
    public String getBairro() {return bairro;    }
    public void setBairro(String bairro) {this.bairro = bairro;    }

    public String getCidade() { return cidade;    }
    public void setCidade(String cidade) { this.cidade = cidade;    }

    public String getEstado() {return estado;    }
    public void setEstado(String estado) {this.estado = estado;    }

    public String getTelefone() { return telefone;    }
    public void setTelefone(String telefone) { this.telefone = telefone;    }

    public String getCelular() {  return celular;    }
    public void setCelular(String celular) {  this.celular = celular;    }
      
    public String getSexo() {  return sexo;    }
    public void setSexo(String sexo) {    this.sexo = sexo;    }
    
    public String getDataNascimento(){return dia_nascimento+"/"+ mes_nascimento+"/"+ano_nascimento;}
    public void setDataNascimento(String dia_nascimento,String mes_nascimento,String ano_nascimento){
       this.dia_nascimento = dia_nascimento;
       this.mes_nascimento = mes_nascimento;
       this.ano_nascimento = ano_nascimento;
    }

    public String getDiaNascimento() { return dia_nascimento; }
    public String getMesNascimento() {return mes_nascimento;}
    public String getAnoNascimento() { return ano_nascimento;}
       
    
}