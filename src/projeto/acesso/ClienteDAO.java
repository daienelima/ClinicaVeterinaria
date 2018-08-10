package projeto.acesso;
import java.util.ArrayList;
import projeto.erro.ConexaoException;
import projeto.erro.DaoException;
import projeto.negocio.classesBasicas.Cliente;

/**
 *
 * @author Daiene
 */
public interface ClienteDAO {
    /**
     * Anotacao do metodo de consultar
     * @param cpf
     * @return
     * @throws ConexaoException
     * @throws DaoException 
     */
    public Cliente consultar(String cpf) throws ConexaoException, DaoException;
    
    /**
     * Anotacao do metodo de inserir
     * @param cliente
     * @throws ConexaoException
     * @throws DaoException 
     */
    public void inserir(Cliente cliente)throws ConexaoException, DaoException; 
    
    /**
     * Anotacao do metodo de deletar
     * @param codCliente
     * @throws ConexaoException
     * @throws DaoException 
     */
    public void deletar(int codCliente)throws ConexaoException, DaoException;
    
    /**
     * Anotacao do metodo de atualizar
     * @param cliente
     * @throws ConexaoException
     * @throws DaoException 
     */
    public void atualizar(Cliente cliente)throws ConexaoException, DaoException;
    
    /**
     * Anotacao do metodo de buscar ID
     * @param cpf
     * @return
     * @throws ConexaoException
     * @throws DaoException 
     */
    public int consultarId(String cpf)throws ConexaoException, DaoException;
    
    /**
     * Anotacao da lista de clientes.
     * @return
     * @throws ConexaoException
     * @throws DaoException 
     */
    public ArrayList<Cliente> listar()throws ConexaoException, DaoException;   
}
