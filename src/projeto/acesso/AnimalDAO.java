package projeto.acesso;

import java.util.ArrayList;
import projeto.erro.ConexaoException;
import projeto.erro.DaoException;
import projeto.negocio.classesBasicas.Animal;

/**
 *
 * @author Geraldo
 */
public interface AnimalDAO {
    
    /**
     * Assinatura do metodo de consultar animais
     * @param id
     * @return
     * @throws ConexaoException
     * @throws DaoException 
     */
    public Animal consultar(int id) throws ConexaoException, DaoException;

    /**
     * Assinatura do metodo de inserir animais
     * @param animal
     * @throws ConexaoException
     * @throws DaoException 
     */
    public void inserir(Animal animal) throws ConexaoException, DaoException;

    /**
     * Assinatura do metodo de deletar animais
     * @param codigoAnimal
     * @throws ConexaoException
     * @throws DaoException 
     */
    public void deletar(int codigoAnimal) throws ConexaoException, DaoException;

    /**
     * Assinatura do metodo de atualizar animais
     * @param animal
     * @throws ConexaoException
     * @throws DaoException 
     */
    public void atualizar(Animal animal) throws ConexaoException, DaoException;

    /**
     * Assinatura do metodo de listar todos os animais
     * @return
     * @throws ConexaoException
     * @throws DaoException 
     */
    public ArrayList<Animal> listarA() throws ConexaoException, DaoException;
}
