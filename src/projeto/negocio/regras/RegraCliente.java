package projeto.negocio.regras;

import java.util.ArrayList;
import projeto.acesso.ClienteDAO;
import projeto.acesso.ClienteDAOImpl;
import projeto.erro.ConexaoException;
import projeto.erro.DaoException;
import projeto.negocio.classesBasicas.Cliente;
import projeto.erro.RegraExceptionCliente;
import projeto.util.Msg;
/**
 *
 * @author Daiene
 */
public class RegraCliente {
    ClienteDAO  clienteDao = new ClienteDAOImpl();
    
    /**
     * Valida nome do cliente 
     * @param nome 
     * @throws projeto.erro.RegraExceptionCliente 
     */
    public void validaNome(String nome)throws RegraExceptionCliente{
        if ((nome == null)||(nome.isEmpty())){
            throw new RegraExceptionCliente("Nome Invalido");
        } 
    } 
    
    /**
     * Valida cpf do cliente 
     * @param cpf 
     * @throws projeto.erro.RegraExceptionCliente 
     */
    public void validaCpf(String cpf)throws RegraExceptionCliente{
        if ((cpf == null)||(cpf.isEmpty())){
            throw new RegraExceptionCliente("CPF Invalido");
        }
    } 
    
     /**
     * Valida o  telefone do cliente 
     * @param telefone
     * @throws projeto.erro.RegraExceptionCliente 
     */
    public void validarTelefone(String telefone)throws RegraExceptionCliente {
        if((telefone == null)||(telefone.isEmpty())){
            throw new RegraExceptionCliente("Telefone Invalido");
        }
    }   
    
    /**
     * Valida o objeto Cleinte ja existe no banco de dados
     * @param cliente 
     * @throws projeto.erro.RegraExceptionCliente 
     */
    public void verificaDuplicidade(Cliente cliente)throws RegraExceptionCliente {
        try{
            Cliente cl = clienteDao.consultar(cliente.getCpf());
            if(cl != null){
                throw new RegraExceptionCliente("Cliente ja cadastrado");
            }
        }catch(ConexaoException | DaoException e){
            throw new RegraExceptionCliente(e.getMessage());
        }        
    }
    
     /**
     * Insete o objeto Cleinte no banco de dados
     * @param cliente 
     * @throws projeto.erro.RegraExceptionCliente 
     * @throws projeto.erro.ConexaoException 
     * @throws projeto.erro.DaoException 
     */
    public void inserirCliente(Cliente cliente) throws RegraExceptionCliente, ConexaoException, DaoException{
        try{
             clienteDao.inserir(cliente);
        }catch(ConexaoException | DaoException e){
            throw new RegraExceptionCliente(e.getMessage());
        }    
    }  
    
     /**
     * deleta o objeto Cleinte do banco de dados
     * @param codCliente
     * @throws projeto.erro.RegraExceptionCliente 
     * @throws projeto.erro.ConexaoException 
     * @throws projeto.erro.DaoException 
     */
    public void deletarCliente(int codCliente) throws RegraExceptionCliente, ConexaoException, DaoException{
        
        try{
            int result = Msg.msgConfirm("Tem certeza que deseja deletar o cliente?", "Deletar Cliente");
        if(result == 0){
            clienteDao.deletar(codCliente);
        }
        }catch(ConexaoException | DaoException e){
            throw new RegraExceptionCliente("Não foi possivel deletar o cliente do BD!");
        } 
    }
    
    /**
     * altera o cliente no banco de dados
     * @param cliente
     * @throws RegraExceptionCliente
     * @throws ConexaoException
     * @throws DaoException 
     */
    public void atualizarCliente(Cliente cliente) throws RegraExceptionCliente, ConexaoException, DaoException{
        try{
            clienteDao.atualizar(cliente);
        }catch(ConexaoException | DaoException e){
            throw new RegraExceptionCliente(e.getMessage());
        } 
    }
    
    /**
     * Metodo para consultar o cliente
     * @param cpf
     * @return
     * @throws RegraExceptionCliente
     * @throws ConexaoException
     * @throws DaoException 
     */
    public Cliente consultarCliente(String cpf) throws RegraExceptionCliente, ConexaoException, DaoException{
        Cliente cliente;
        try{
            cliente = clienteDao.consultar(cpf);
        }catch(ConexaoException | DaoException e){
            throw new RegraExceptionCliente(e.getMessage());
        }
        return cliente;
    }
    
    /**
     * Metodo para consultar apenas o codigo do cliente.
     * @param cpf
     * @return
     * @throws RegraExceptionCliente
     * @throws ConexaoException
     * @throws DaoException 
     */
    public int consultarCodigoCliente(String cpf) throws RegraExceptionCliente, ConexaoException, DaoException{
        int codigoCliente = 0;
        try{
            codigoCliente = clienteDao.consultarId(cpf);
        }catch(ConexaoException | DaoException e){
            throw new RegraExceptionCliente(e.getMessage());
        }
        return codigoCliente;
    }
    
    /**
     * Metodo para consultar todos os clientes do banco.
     * @return
     * @throws RegraExceptionCliente
     * @throws ConexaoException
     * @throws DaoException 
     */
    public ArrayList<Cliente> listar()throws RegraExceptionCliente, ConexaoException, DaoException{
        try{
            return clienteDao.listar();
        }catch(ConexaoException | DaoException e){
            throw new RegraExceptionCliente(e.getMessage());
        }      
    }
     
}           
 