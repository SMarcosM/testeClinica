package banco_dados;

/**
 * @author SEBASTIÃO
 */
import java.sql.*;
import java.util.Date;
import model.c_pacientes;
import util.conversao;

public class pacientes {

    private Connection conBanco;
    private PreparedStatement psComando;
    private ResultSet rsRegistros;
   

    public void configurarConexao(Connection conBanco) {
        this.conBanco = conBanco;
    }

    public boolean inserirRegistro(c_pacientes paciente) {
       
        conversao Converter = new conversao();
        Date dtDataNascimento;
        String strDataInvertida, strComandoSQL;

        try {
            dtDataNascimento = Converter.StringToDate(paciente.getDataNascimento());
            if (dtDataNascimento != null) 
                strDataInvertida = Converter.DataInvertida(dtDataNascimento);
             else 
                strDataInvertida = "null";
            

            if (!(strDataInvertida.equals("null"))) 
                strDataInvertida = "'"+strDataInvertida+"'" ;
            

            strComandoSQL = "INSERT INTO pacientes(Nome,Numero_RG,Orgao_Emissor, "
                    + "Numero_CPF,Endereco,Numero,Complemento,Bairro,Cidade,Estado,Telefone,"
                    + "CelularNumero_CTPS,Numero_PIS,Sexo,Data_nascimento)"+
                     " VALUES('" + paciente.getNomeCompleto()+ "',"+
                     "'" + paciente.getNumeroRG() + "',"+
                     "," + paciente.getOrgaoEmissor() + "',"+
                     "," + paciente.getNumeroCPF() + "',"+
                     "," + paciente.getEndereco() + "',"+
                     "," + paciente.getNumero() + "',"+
                     "," + paciente.getComplemento() + ","+
                     "," + paciente.getBairro() + "',"+
                     "," + paciente.getCidade() + "',"+
                     "," + paciente.getEstado() + "',"+
                     "," + paciente.getTelefone() + "',"+
                     "," + paciente.getCelular() + "',"+
                    "," + strDataInvertida + "',"+
                    "," + paciente.getSexo() + "',"+
                    "," + paciente.getTem_convenio() + "',"+
                    "," + paciente.getSenha_acesso() + "',"+
                    "," + paciente.getCodigo_convenio()+")";
            

           
            psComando = conBanco.prepareStatement(strComandoSQL);
            psComando.executeUpdate();
            
            return true;
            
        } catch (Exception erro) {
            erro.printStackTrace();
            return false;
        }
    }

    public int localizarRegistro(String strCampo, String strValor) {
        int intCodigoPaciente = 0;
        String strComandoSQL;
        try {
            if (strCampo.equals("NOME")) 
                strComandoSQL = "SELECT Codigo_Paciente FROM pacientes WHERE Nome LIKE '%" + strValor + "%'";
             else if (strCampo.equals("RG")) 
                strComandoSQL = "SELECT Codigo_Paciente FROM pacientes WHERE Numero_RG = '" + strValor + "'";
             else 
                strComandoSQL = "SELECT Codigo_Paciente FROM pacientes WHERE Numero_CPF = '" + strValor + "'";
            
            psComando = conBanco.prepareStatement(strComandoSQL);
            rsRegistros = psComando.executeQuery();
            rsRegistros.next();
            
            intCodigoPaciente = rsRegistros.getInt("Codigo_Paciente");
        } 
        catch (Exception erro)
        {
            erro.printStackTrace();
        }
        
        return intCodigoPaciente;
    }
    
    public ResultSet lerRegistro(int intCodigoPaciente){
        String strComandoSQL;
        
        try{
            strComandoSQL = "SELECT *FROM funcionarios WHERE Codigo_Paciente ="+ intCodigoPaciente;
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
    
public boolean alterarRegistro(c_pacientes paciente)
{
        conversao Converter = new conversao();
        Date dtDataNascimento;
        String strDataInvertida, strComandoSQL;

        try {
            dtDataNascimento = Converter.StringToDate(paciente.getDataNascimento());
            if (dtDataNascimento != null) 
                strDataInvertida = Converter.DataInvertida(dtDataNascimento);
             else 
                strDataInvertida = "null";
            

            if (!(strDataInvertida.equals("null"))) 
                strDataInvertida = "'" + strDataInvertida + "'";
            

            strComandoSQL = "UPDATE pacientes SET Nome = '"+paciente.getNomeCompleto()+"',"+
                    "Numero_RG = '"+paciente.getNumeroRG()+"',"+
                    "Orgao_Emissor = '"+paciente.getOrgaoEmissor()+"',"+
                    "Numero_CPF= '"+paciente.getNumeroCPF()+"',"+
                    "Endereco = '"+paciente.getEndereco()+"',"+
                    "Numero = '"+paciente.getNumero()+"',"+
                    "Complemento = '"+paciente.getComplemento ()+"',"+
                    "Bairro = '"+paciente.getBairro()+"',"+
                    "Cidade = '"+paciente.getCidade()+"',"+
                    "Estado = '"+paciente.getEstado ()+"',"+
                    "Telefone = '"+paciente.getTelefone()+"',"+
                    "Data_Nascimento = '"+strDataInvertida+
                    "Celular = '"+paciente.getCelular()+"',"+
                    "Sexo = '"+paciente.getSexo()+"',"+
                    "Tem_Convenio = '"+paciente.getTem_convenio()+"',"+
                    "Codigo_Convenio = '"+paciente.getCodigo_convenio()+
                    "WHERE Codigo_Paciente = "+paciente.getCodigo_paciente();
                  
            psComando = conBanco.prepareStatement(strComandoSQL);
            psComando.executeUpdate();
            return true;
            
        } catch (Exception erro) {
            erro.printStackTrace();
            return false;
        }  
}
    
    public ResultSet listarRegistro(String strNome) {
        String strComandoSQL;
        try {
            if(strNome.equals(""))
            strComandoSQL = "SELECT *FROM pacientes ORSER BY Nome";
            else
                strComandoSQL = "SELECT Codigo_Paciente, Nome, Numero_RG, Numero_CPF FROM pacientes WHERE"
                        + "Nome LIKE '%"+strNome.toUpperCase()+"' ORDER BY Nome";
                
                
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