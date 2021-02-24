    package banco_dados;
    /**
     * @author SEBASTIÃO
     */
    import java.sql.*;

    public class especialidades { 
        private Connection conBanco; 
        private PreparedStatement psComando;
        private ResultSet rsRegistros;

    public void configurarConexao(Connection conBanco){
        this.conBanco = conBanco;
    }
    public boolean inserirRegistro(String strDescricao) { 
        String strComandoSQL;
        try { strComandoSQL = "INSERT INTO especialidades(Descricao_Especialidade)VALUES('"+strDescricao+"')";  
            psComando = conBanco.prepareStatement(strComandoSQL);
            psComando.executeUpdate();

            return true;
        }
        catch (Exception erro){
        erro.printStackTrace();
        return false;
        }
    }
    public boolean alternararRegistro(int intCodigo, String strDescricao){
    String strComandoSQL;

        try{
        strComandoSQL = "UPDATE especialidades SET Descricao_Especialidade = '"+strDescricao+"'WHERE Codigo_Especialidade = "+intCodigo; 
        psComando = conBanco.prepareStatement(strComandoSQL); 
        psComando.executeUpdate();

            return true;
        }
        catch (Exception erro) {
            erro.printStackTrace();
            return false;
        }
    }

    public boolean excluirRegistro(int intCodigo) { 
        String strComandoSQL;

        try { 
        strComandoSQL = "DELETE FROM especialidades WHERE Codigo_Especialidade = "+intCodigo;
        psComando = conBanco.prepareStatement(strComandoSQL); 
        psComando.executeUpdate();

        return true;

    }
    catch (Exception erro) { 
        erro.printStackTrace();
        return false;
    }
    }
    public ResultSet listarRegistros(String strOrdem) { 
        String strComandoSQL;

        try {
            if (strOrdem == "CÓDIGO")
                strComandoSQL = "SELECT * FROM especialidades ORDER BY Codigo_Especialidade"; 
            else
            strComandoSQL = "SELECT * FROM especialidades ORDER BY Descricao_Especialidade";

            psComando = conBanco.prepareStatement(strComandoSQL); 
            rsRegistros = psComando.executeQuery(); 
            return rsRegistros;

        }   
        catch (Exception erro) {
        erro.printStackTrace();
        return null;
    }
    }
    }