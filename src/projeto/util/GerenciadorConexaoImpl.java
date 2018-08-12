package projeto.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import projeto.erro.ConexaoException;

/**
 *
 * @author Clinica
 */
public class GerenciadorConexaoImpl implements GerenciadorConexao{
    
    private static GerenciadorConexaoImpl instancia;
    private final String url;
    private final String user;
    private final String pass;
    
    /**
     * Construtor da classe, pegando a autenticação do banco no documento bancoConfigs.
     */
    private GerenciadorConexaoImpl(){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("projeto.util.bancoConfigs");
        url = resourceBundle.getString("url");
        user = resourceBundle.getString("user");
        pass = resourceBundle.getString("pass");
    }
    
    /**
     * Criando uma nova instancia no banco.
     * @return 
     */
    public static GerenciadorConexaoImpl getInstancia(){
        if(instancia==null){
            instancia = new GerenciadorConexaoImpl();
        }
        return instancia;
    }

    /**
     * Metodo para abrir uma conexao com o banco.
     * @return
     * @throws ConexaoException 
     */
    @Override
    public Connection abrirConexao() throws ConexaoException {
        Connection con;
        try{
            con = DriverManager.getConnection(url, user, pass);
            return con;
        }catch(SQLException e){
            throw new ConexaoException();
        }
    }

    /**
     * Metodo para fechar a conexao com o banco.
     * @param con
     * @throws ConexaoException 
     */
    @Override
    public void fecharConexao(Connection con) throws ConexaoException {
        try{
            con.close();
        }catch(SQLException e){
            throw new ConexaoException();
        }
    }
    
    public void executaSql(String sql) throws ConexaoException{
        try{
            Connection con = abrirConexao();
        }catch(ConexaoException ex){
            Msg.msgErro("Erro na conexao", "Erro na conexao GC");
        }
    }
    
    
    
}
