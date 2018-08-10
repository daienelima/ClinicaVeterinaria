package projeto.util;

import java.sql.Connection;
import projeto.erro.ConexaoException;

/**
 *
 * @author Clinica
 */
public interface GerenciadorConexao {
    
    /**
     * Metodo para abrir a conexao com o Bando de dados.
     * @return 
     * @throws ConexaoException 
     */
    public Connection abrirConexao()throws ConexaoException;
    
    /**
     * Metodo para fechar a conexao com o banco de dados.
     * @param con
     * @throws ConexaoException 
     */
    public void fecharConexao(Connection con)throws ConexaoException;
    
    /**
     * Metodo para executar uma String que nao está no contexto do crud.
     * @param sql
     * @throws ConexaoException 
     */
    public void executaSql(String sql) throws ConexaoException;
    
}
