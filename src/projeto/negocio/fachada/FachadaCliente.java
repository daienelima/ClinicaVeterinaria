package projeto.negocio.fachada;
import java.util.ArrayList;
import projeto.erro.ConexaoException;
import projeto.erro.DaoException;
import projeto.erro.RegraExceptionCliente;
import projeto.negocio.classesBasicas.Cliente;
import projeto.negocio.regras.RegraCliente;

/**
 *
 * @author Daiene
 */
public class FachadaCliente  {
    RegraCliente rn = new RegraCliente();
    
    /**
     * Metodo para validar cliente antes de inserir
     * @param cliente
     * @throws RegraExceptionCliente
     * @throws ConexaoException
     * @throws DaoException 
     */
    public void inserirCliente (Cliente cliente) throws RegraExceptionCliente, ConexaoException, DaoException {        
        rn.validaNome(cliente.getNome());
        rn.validaCpf(cliente.getCpf());
        rn.validarTelefone(cliente.getTelefone());
        rn.verificaDuplicidade(cliente);
        rn.inserirCliente(cliente);       
    }
    
    /**
     * Metodo para validar cliente antes de deletar
     * @param cliente
     * @throws RegraExceptionCliente
     * @throws ConexaoException
     * @throws DaoException 
     */
    public void deletarCliente (int codCliente) throws RegraExceptionCliente, ConexaoException, DaoException{
        rn.deletarCliente(codCliente);
    }
    
    /**
     * Metodo para validar cliente antes de alterar
     * @param cliente
     * @throws RegraExceptionCliente
     * @throws ConexaoException
     * @throws DaoException 
     */
    public void alterarCliente (Cliente cliente) throws RegraExceptionCliente, ConexaoException, DaoException{
        rn.validaNome(cliente.getNome());
        rn.validaCpf(cliente.getCpf());
        rn.atualizarCliente(cliente);  
    }
    
    /**
     * Consultar cliente
     * @param cpf
     * @return cliente
     * @throws RegraExceptionCliente
     * @throws ConexaoException
     * @throws DaoException 
     */
    public Cliente consultarCliente (String cpf) throws RegraExceptionCliente, ConexaoException, DaoException{
        rn.validaCpf(cpf);
        Cliente cliente = rn.consultarCliente(cpf);
        return cliente;
    }
    
    /**
     * Consultar codigo do cliente
     * @param cpf
     * @return codigo do cliente
     * @throws RegraExceptionCliente
     * @throws ConexaoException
     * @throws DaoException 
     */
    public int consultarCodigoCliente (String cpf) throws RegraExceptionCliente, ConexaoException, DaoException{
        rn.validaCpf(cpf);
        int codigoCliente = rn.consultarCodigoCliente(cpf);
        return codigoCliente;
    }
    
    /**
     * Metodo para consultar todos os clientes.
     * @return
     * @throws RegraExceptionCliente
     * @throws ConexaoException
     * @throws DaoException 
     */
    public ArrayList<Cliente> listarCliente()throws RegraExceptionCliente, ConexaoException, DaoException{
        return rn.listar();      
    }
}

