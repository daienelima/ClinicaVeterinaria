
package projeto.acesso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import projeto.erro.AutenticacaoException;
import projeto.erro.ConexaoException;
import projeto.erro.DaoException;
import projeto.negocio.classesBasicas.Autenticacao;
import projeto.util.GerenciadorConexao;
import projeto.util.GerenciadorConexaoImpl;
import projeto.util.Msg;

/**
 *
 * @author Mario
 */
public class AutenticacaoDAOImpl implements AutenticacaoDAO{
    
    GerenciadorConexao ger = GerenciadorConexaoImpl.getInstancia();

    /**
     * Metodo checarAutenticação.
     * @param login
     * @param pass
     * @return
     * @throws AutenticacaoException
     * @throws ConexaoException
     * @throws DaoException 
     */
    @Override
    public Autenticacao checarAutenticacao(String login, String pass) throws AutenticacaoException, ConexaoException, DaoException {
        Connection con = ger.abrirConexao();
        Autenticacao autenticacao = null;
        String sql = "SELECT * FROM AUTENTICACAO WHERE LOGIN_FUNC = ? AND PASS_FUNC = ?";
        try{
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,login);
            pstm.setString(2,pass);
            ResultSet result = pstm.executeQuery();
            if(result.first()){
                autenticacao = new Autenticacao();
                autenticacao.setLogin(result.getString("LOGIN_FUNC"));
                autenticacao.setPass(result.getString("PASS_FUNC"));
                autenticacao.setFunCpf(result.getString("FUN_CPF"));
                autenticacao.setPrimeiroAcesso(result.getString("PRIMEIRO_ACESSO"));               
            }
            return autenticacao; 
        }catch(SQLException e){
            throw new DaoException();
        }finally{
            ger.fecharConexao(con);
        }
    }

    /**
     * Metodo para criar as credenciais.
     * @param autenticacao
     * @throws AutenticacaoException
     * @throws ConexaoException
     * @throws DaoException 
     */
    @Override
    public void criarCredenciais(Autenticacao autenticacao) throws AutenticacaoException, ConexaoException, DaoException {
        Connection con = ger.abrirConexao();
        String sql = "INSERT INTO AUTENTICACAO (LOGIN_FUNC,PASS_FUNC,FUN_CPF,PRIMEIRO_ACESSO) VALUES (?,?,?,?)";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, autenticacao.getLogin());
            pstm.setString(2, autenticacao.getPass());
            pstm.setString(3, autenticacao.getFunCpf());
            pstm.setString(4, autenticacao.getPrimeiroAcesso());
            pstm.executeUpdate();
            Msg.msgSucesso("Credenciais do funcionario foram inseridas no banco de dados", "Sucesso ao inserir credenciais");
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        }finally{
            ger.fecharConexao(con);
        }
    }
    
    /**
     * Metodo para alterar as credenciais.
     * @param id
     * @param newPassword
     * @throws ConexaoException
     * @throws DaoException 
     */
    @Override
    public void alterarPassword(String cpfCli, String newPassword) throws ConexaoException, DaoException{
        Connection con = ger.abrirConexao();
        String sql = "UPDATE AUTENTICACAO SET PASS_FUNC = ?, PRIMEIRO_ACESSO = 'N' WHERE FUN_CPF = ? ";
        try { 
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, newPassword);
            pstm.setString(2, cpfCli);
            pstm.executeUpdate(); 
            Msg.msgSucesso("Senha alterada com sucesso", "Sucesso ao alterar");
        } catch (SQLException ex) {
            throw new DaoException();
        }finally{
            ger.fecharConexao(con);
        }
    }
    
}
