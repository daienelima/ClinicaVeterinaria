package projeto.negocio.fachada;

import java.util.ArrayList;
import projeto.erro.ConexaoException;
import projeto.erro.DaoException;
import projeto.erro.RegraExceptionAnimal;
import projeto.erro.RegraExceptionCliente;
import projeto.negocio.classesBasicas.Animal;
import projeto.negocio.regras.RegraAnimal;

/**
 * 
 * @author Geraldo
 */
public class FachadaAnimal {

    RegraAnimal ra = new RegraAnimal();

    /**
     * Metodo para checar conformidades antes de inserir animal.
     * @param animal
     * @throws ConexaoException
     * @throws DaoException
     * @throws RegraExceptionAnimal 
     */
    public void inserirAnimal(Animal animal) throws ConexaoException, DaoException, RegraExceptionAnimal {
        ra.validaNome(animal.getNome());
        ra.validaEspecie(animal.getEspecie());
        ra.validarSexo(animal.getSexo());
        ra.validarIdCliente(animal.getCodigoCliente());
        ra.verificaDuplicidade(animal);
        ra.inserirAnimal(animal);
    }

    /**
     * Metodo para deletar animal.
     * @param CodigoAnimal
     * @throws RegraExceptionAnimal
     * @throws ConexaoException
     * @throws DaoException 
     */
    public void deletarAnimal(int CodigoAnimal) throws RegraExceptionAnimal, ConexaoException, DaoException {
        ra.deletarAnimal(CodigoAnimal);
    }

    /**
     * Metodo para checar conformidades e alterar animal.
     * @param animal
     * @throws RegraExceptionCliente
     * @throws ConexaoException
     * @throws DaoException
     * @throws RegraExceptionAnimal 
     */
    public void alterarAnimal(Animal animal) throws RegraExceptionCliente, ConexaoException, DaoException, RegraExceptionAnimal {
        ra.validaNome(animal.getNome());
        ra.validaEspecie(animal.getEspecie());
        ra.atualizarAnimal(animal);
    }
    
    /**
     * Metodo para consultar Animal.
     * @param Id
     * @return Animal.
     * @throws RegraExceptionAnimal
     * @throws ConexaoException
     * @throws DaoException 
     */
    public Animal consultarAnimal(int Id) throws RegraExceptionAnimal, ConexaoException, DaoException{
        Animal animal = ra.consultarAnimal(Id);
        return animal;
    }

    /**
     * Metodo para listar todos os animais.
     * @return Lista de Animal
     * @throws RegraExceptionAnimal
     * @throws ConexaoException
     * @throws DaoException 
     */
    public ArrayList<Animal> listarAnimal() throws RegraExceptionAnimal, ConexaoException, DaoException {
        return ra.listar();
    }
}