package banco_dados;

/**
 * @author SEBASTIÃO
 */
import java.sql.*;
import java.util.Date;
import model.c_funcionarios;
import util.conversao;

public class funcionarios {

    private Connection conBanco;
    private PreparedStatement psComando;
    private ResultSet rsRegistros;
   

    public void configurarConexao(Connection conBanco) {
        this.conBanco = conBanco;
    }

    public boolean inserirRegistro(c_funcionarios funcionario) {
       
        conversao Converter = new conversao();
        Date dtDataNascimento;
        String strDataInvertida, strComandoSQL;

        try {
            dtDataNascimento = Converter.StringToDate(funcionario.getDataNascimento());
           
            if (dtDataNascimento != null) 
                strDataInvertida = Converter.DataInvertida(dtDataNascimento);
             else 
                strDataInvertida = "null";
            

            if (!(strDataInvertida.equals("null"))) 
                strDataInvertida =""+ strDataInvertida +"";
            

            strComandoSQL = "INSERT INTO funcionarios(Nome_Completo,Numero_RG,Orgao_Emissor, "
                    + "Numero_CPF,Endereco,Numero,Complemento,Bairro,Cidade,Estado,Telefone,"
                    + "Celular,Numero_CTPS,Numero_PIS,Sexo,Data_Nascimento)"
                    + "VALUES('"+funcionario.getNomeCompleto()+"',"+
                     "'"+ funcionario.getNumeroRG() +"',"+
                     ","+ funcionario.getOrgaoEmissor() +"',"+
                     ","+ funcionario.getNumeroCPF() +"',"+
                     ","+ funcionario.getEndereco() +"',"+
                     ","+ funcionario.getNumero() +"',"+
                     ","+ funcionario.getComplemento() +","+
                     ","+ funcionario.getBairro() +"',"+
                     ","+ funcionario.getCidade() +"',"+
                     ","+ funcionario.getEstado() +"',"+
                     ","+ funcionario.getTelefone() +"',"+
                     ","+ funcionario.getCelular() +"',"+
                     ","+ funcionario.getNumeroCTPS()+"',"+
                     ","+ funcionario.getNumeroPIS() +"',"+
                     ","+ funcionario.getSexo() +"',"+
                     ","+ funcionario.getDataNascimento() +"',"+
                      strDataInvertida +")";
           
            psComando = conBanco.prepareStatement(strComandoSQL);
            psComando.executeUpdate();
            
            return true;
            
        } catch (Exception erro) {
            erro.printStackTrace();
            return false;
        }
    }

    public int localizarRegistro(String strCampo, String strValor) {
        int intCodigoFuncionario = 0;
        String strComandoSQL;
        try {
            if (strCampo.equals("NOME")) 
                strComandoSQL = "SELECT Codigo_Funcionario FROM funcionarios WHERE Nome_Completo LIKE '%" + strValor + "%'";
             else if (strCampo.equals("RG")) 
                strComandoSQL = "SELECT Codigo_Funcionario FROM funcionarios WHERE Numero_RG = '" + strValor + "'";
             else 
                strComandoSQL = "SELECT Codigo_Funcionario FROM funcionarios WHERE Numero_CPF = '" + strValor + "'";
            
            psComando = conBanco.prepareStatement(strComandoSQL);
            rsRegistros = psComando.executeQuery();
            rsRegistros.next();
            
            intCodigoFuncionario = rsRegistros.getInt("Codigo_Funcionario");
        } 
        catch (Exception erro)
        {
            erro.printStackTrace();
        }
        
        return intCodigoFuncionario;
    }
    
    public ResultSet lerRegistro(int intCodigFuncionario){
        int intCodigoFuncionario = 0;
        String strComandoSQL;
        
        try{
            strComandoSQL = "SELECT *FROM funcionarios WHERE Codigo_Fucionario ="+ intCodigoFuncionario;
                psComando = conBanco.prepareStatement(strComandoSQL);
                rsRegistros = psComando.executeQuery();
                rsRegistros.next();
                
                return rsRegistros;
    }
    catch (Exception erro){
        erro.printStackTrace();
        return null;
    }
}
    
public boolean alterarRegistro(c_funcionarios funcionario)
{
        conversao Converter = new conversao();
        Date dtDataNascimento;
        String strDataInvertida, strComandoSQL;

        try {
            dtDataNascimento = Converter.StringToDate(funcionario.getDataNascimento());
            if (dtDataNascimento != null) 
                strDataInvertida = Converter.DataInvertida(dtDataNascimento);
             else 
                strDataInvertida = "null";
            

            if (!(strDataInvertida.equals("null"))) 
                strDataInvertida = "'" + strDataInvertida + "'";
            

            strComandoSQL = "UPDATE funcionarios SET Nome_Completo = '"+funcionario.
                    getNomeCompleto() + "',"+
                    "Numero_RG = '"+funcionario.getNumeroRG()+"',"+
                    "Orgao_Emissor = '"+funcionario.getOrgaoEmissor()+"',"+
                    "Numero_CPF= '"+funcionario.getNumeroCPF()+"',"+
                    "Endereco = '"+funcionario.getEndereco()+"',"+
                    "Numero = '"+funcionario.getNumero()+"',"+
                    "Complemento = '"+funcionario.getComplemento ()+"',"+
                    "Bairro = '"+funcionario.getBairro()+"',"+
                    "Cidade = '"+funcionario.getCidade()+"',"+
                    "Estado = '"+funcionario.getEstado ()+"',"+
                    "Telefone = '"+funcionario.getTelefone()+"',"+
                    "Celular = '"+funcionario.getCelular()+"',"+
                    "Numero_CTPS = '"+funcionario.getNumeroCTPS()+"',"+
                    "Numero_PIS = '"+funcionario.getNumeroPIS()+"',"+
                    "Sexo = '"+funcionario.getSexo()+"',"+
                    "Data_Nascimento = '"+strDataInvertida+
                    "WHERE Codigo_Funcionario = "+funcionario.getCodigoFuncionario();
                  
            psComando = conBanco.prepareStatement(strComandoSQL);
            psComando.executeUpdate();
            return true;
            
        } catch (Exception erro) {
            erro.printStackTrace();
            return false;
        }  
}
    
    public boolean excluirRegistro(int intCodigoFuncionario) {
        String strComandoSQL;
        try {
            strComandoSQL = "DELETE FROM pessoa WHERE idcod ="
                    + intCodigoFuncionario;
            psComando = conBanco.prepareStatement(strComandoSQL);
            psComando.executeUpdate();
            return true;
        } catch (Exception erro) {
            erro.printStackTrace();
            return false;
        }
    }
    public ResultSet listarRegistro() {
        String strComandoSQL;
        try {
            strComandoSQL = "SELECT *FROM funcionarios ORSER BY Nome_Completo";
                    
            psComando = conBanco.prepareStatement(strComandoSQL);
            psComando.executeQuery();
            return rsRegistros;
        } 
        catch (Exception erro) {
            erro.printStackTrace();
            return null;
        }
    }
}