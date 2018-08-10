package projeto.acesso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import projeto.erro.ConexaoException;
import projeto.erro.DaoException;
import projeto.negocio.classesBasicas.Cliente;
import projeto.util.GerenciadorConexao;
import projeto.util.GerenciadorConexaoImpl;
import projeto.util.Msg;

/**
 *
 * @author Daiene
 */
public class ClienteDAOImpl implements ClienteDAO{
    private final GerenciadorConexao ger;
    public ClienteDAOImpl(){
        ger = GerenciadorConexaoImpl.getInstancia();
    }
    
    /**
     * Metodo para consultar um cliente
     * @param cpf
     * @return
     * @throws ConexaoException
     * @throws DaoException 
     */
    @Override
    public Cliente consultar(String cpf) throws ConexaoException, DaoException {
        
        Connection con = ger.abrirConexao();
        Cliente cliente = null;
        String sql = "SELECT * FROM cliente WHERE CLI_CPF=?";
        try{
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,cpf);
            ResultSet result = pstm.executeQuery();
            if(result.first()){
                cliente = new Cliente();
                cliente.setCodigoCliente(result.getInt("CLI_CODIGO"));
                cliente.setCpf(result.getString("CLI_CPF"));
                cliente.setNome(result.getString("CLI_NOME"));
                cliente.setTelefone(result.getString("CLI_TELEFONE"));               
            }
            return cliente; 
        }catch(SQLException e){
            throw new DaoException();
        }finally{
            ger.fecharConexao(con);
        }   
    }
    
    /**
     * Metodo para consultar por ID
     * @param cpf
     * @return
     * @throws ConexaoException
     * @throws DaoException 
     */
    @Override
    public int consultarId(String cpf) throws ConexaoException, DaoException{
        Connection con = ger.abrirConexao();
        int codigoCliente = 0;
        String sql = "SELECT CLI_CODIGO FROM cliente WHERE CLI_CPF = ?";
        try{
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,cpf);
            ResultSet result = pstm.executeQuery();
            if(result.first()){
                codigoCliente = result.getInt("CLI_CODIGO");             
            }
            return codigoCliente; 
        }catch(SQLException e){
            throw new DaoException();
        }finally{
            ger.fecharConexao(con);
        }   
    }

    /**
     * Metodo para inserir um cliente no BD
     * @param cliente
     * @throws ConexaoException
     * @throws DaoException 
     */
    @Override
    public void inserir(Cliente cliente) throws ConexaoException, DaoException {
        
        Connection con = ger.abrirConexao();
        String sql = "INSERT INTO CLIENTE (CLI_NOME,CLI_CPF,CLI_TELEFONE) VALUES (?,?,?)";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getCpf());
            pstm.setString(3, cliente.getTelefone());
            pstm.executeUpdate();
            Msg.msgSucesso("Cliente inserido com sucesso", "Sucesso ao inserir Cliente");
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        }finally{
            ger.fecharConexao(con);
        }
    }

    /**
     * Metodo para deletar do BD
     * @param codCliente
     * @throws ConexaoException
     * @throws DaoException 
     */
    @Override
    public void deletar(int codCliente) throws ConexaoException, DaoException {
       
        Connection con = ger.abrirConexao();
        String sql = "DELETE FROM CLIENTE WHERE CLI_CODIGO = ?";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, codCliente);
            pstm.executeUpdate();
            Msg.msgSucesso("Cliente deletado do BD com sucesso!", "Sucesso ao deletar Cliente");
        } catch (SQLException ex) {
            throw new DaoException();
        }finally{
            ger.fecharConexao(con);
        }
    }

    /**
     * Metodo para atualizar no BD
     * @param cliente
     * @throws ConexaoException
     * @throws DaoException 
     */
    @Override
    public void atualizar(Cliente cliente) throws ConexaoException, DaoException {
      
        Connection con = ger.abrirConexao();
        String sql = "UPDATE CLIENTE SET CLI_NOME = ?,CLI_CPF = ?,CLI_TELEFONE = ? WHERE CLI_CODIGO = ?";
        try { 
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getCpf());
            pstm.setString(3, cliente.getTelefone());
            pstm.setInt(4, cliente.getCodigoCliente());
            pstm.executeUpdate(); 
            Msg.msgSucesso("Cliente alterado com sucesso", "Sucesso ao alterar");
        } catch (SQLException ex) {
            throw new DaoException();
        }finally{
            ger.fecharConexao(con);
        }
    }

    /**
     * Metodo para listar todos os Clientes do BD
     * @return
     * @throws ConexaoException
     * @throws DaoException 
     */
    @Override
    public ArrayList<Cliente> listar() throws ConexaoException, DaoException {
       
        Connection con = ger.abrirConexao();
        Cliente cliente;
        ArrayList <Cliente> Lista = new ArrayList();
        String sql = "SELECT * FROM CLIENTE";

       try{
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet result = pstm.executeQuery();
            while(result.next()){
                cliente = new Cliente();
                cliente.setCodigoCliente(result.getInt("CLI_CODIGO"));
                cliente.setCpf(result.getString("CLI_CPF"));
                cliente.setNome(result.getString("CLI_NOME"));
                cliente.setTelefone(result.getString("CLI_TELEFONE"));  
                Lista.add(cliente);
            }
           return Lista; 
        }catch(SQLException e){
            throw new DaoException();
        }finally{
            ger.fecharConexao(con);
        }        
    }  
}
