package projeto.negocio.regras;

import java.util.ArrayList;
import projeto.acesso.AnimalDAO;
import projeto.acesso.AnimalDAOImpl;
import projeto.erro.ConexaoException;
import projeto.erro.DaoException;
import projeto.erro.RegraExceptionAnimal;
import projeto.negocio.classesBasicas.Animal;
import projeto.util.Msg;

/**
 * 
 * @author Geraldo
 */
  
public class RegraAnimal {
    AnimalDAO  animalDao = new AnimalDAOImpl(); 
    /**
     * Valida nome do Animal
     * @param nome 
     * @throws projeto.erro.RegraExceptionAnimal 
     */
    public void validaNome(String nome)throws RegraExceptionAnimal{
        if ((nome == null)||(nome.isEmpty())){
            throw new RegraExceptionAnimal("Nome Não pode ser deixado em branco");
        } 
    } 
    
    /**
     * Valida espécie do Animal 
     * 
     * @param especie
     * @throws projeto.erro.RegraExceptionAnimal 
     */
    public void validaEspecie(String especie)throws RegraExceptionAnimal{
        if ((especie == null)||(especie.isEmpty())){
            throw new RegraExceptionAnimal("Espécie  Não pode ser deixada em branco");
        }
    }
    
    /**
     * Validar sexo do animal
     * @param sexo
     * @throws RegraExceptionAnimal 
     */
    public void validarSexo(String sexo)throws RegraExceptionAnimal{
        if ((sexo == null) || (sexo.isEmpty())){
            throw new  RegraExceptionAnimal("Sexo nao pode ser deixado em branco");
        }
        if (("I".equals(sexo))){
            throw new RegraExceptionAnimal("Deve escolher uma opção valida para sexo");
        }
    }
    
    public void validarIdCliente(int codigoCliente) throws RegraExceptionAnimal{
        if (codigoCliente == 0){
            throw new  RegraExceptionAnimal("CPF do cliente não consta no sistema, favor cadastrar o cliente ou alterar o CPF.");
        }
    }
    
    /**
     * Valida o objeto Animal ja existe no banco de dados
     * @param animal 
     * @throws projeto.erro.RegraExceptionAnimal 
     */
    public void verificaDuplicidade(Animal animal)throws RegraExceptionAnimal {
        try{
            Animal a1 = animalDao.consultar(animal.getCodigoAnimal());
            if(a1 != null){
                throw new RegraExceptionAnimal("Animal ja cadastrado");
            }
        }catch(ConexaoException | DaoException e){
            throw new RegraExceptionAnimal(e.getMessage());
        }        
    }  
     /**
     * Insete o objeto Cleinte no banco de dados
     * @param animal 
     * @throws projeto.erro.RegraExceptionAnimal 
     * @throws projeto.erro.ConexaoException 
     * @throws projeto.erro.DaoException 
     */
    public void inserirAnimal(Animal animal) throws RegraExceptionAnimal, ConexaoException, DaoException{
        try{
             animalDao.inserir(animal);
        }catch(ConexaoException | DaoException e){
            throw new RegraExceptionAnimal(e.getMessage());
        }    
    }       
     /**
     * deleta o objeto Cleinte do banco de dados
     * @param codigoAnimal
     * @throws projeto.erro.RegraExceptionAnimal 
     * @throws projeto.erro.ConexaoException 
     * @throws projeto.erro.DaoException 
     */
     public void deletarAnimal(int codigoAnimal) throws RegraExceptionAnimal, ConexaoException, DaoException{
        
        try{
            int result = Msg.msgConfirm("Tem certeza que deseja deletar o Animal?", "Deletar Animal");
            if(result == 0){
                animalDao.deletar(codigoAnimal);
            }
        }catch(ConexaoException | DaoException e){
            throw new RegraExceptionAnimal("Não foi possivel deletar o Animal do BD!");
        } 
    }
     
    /**
     * Metodo que altera animal
     * @param animal
     * @throws RegraExceptionAnimal
     * @throws ConexaoException
     * @throws DaoException 
     */
    public void atualizarAnimal(Animal animal) throws RegraExceptionAnimal, ConexaoException, DaoException{
        try{
            animalDao.atualizar(animal);
        }catch(ConexaoException | DaoException e){
            throw new RegraExceptionAnimal(e.getMessage());
        } 
    }
    
    /**
     * Metodo que retorna uma lista de todos os animais cadastrados no BD
     * @return lista de animais
     * @throws RegraExceptionAnimal
     * @throws ConexaoException
     * @throws DaoException 
     */
    public ArrayList<Animal> listar()throws RegraExceptionAnimal, ConexaoException, DaoException{
        try{
            return animalDao.listarA();
        }catch(ConexaoException | DaoException e){
            throw new RegraExceptionAnimal(e.getMessage());
        
        }
    }
    
    /**
     * Metodo para consultar um animal por ID
     * @param id
     * @return Animal animal
     * @throws RegraExceptionAnimal
     * @throws ConexaoException
     * @throws DaoException 
     */
    public Animal consultarAnimal(int id) throws RegraExceptionAnimal, ConexaoException, DaoException{
        Animal animal;
        try{
            animal = animalDao.consultar(id);
        }catch(ConexaoException | DaoException e){
            throw new RegraExceptionAnimal(e.getMessage());
        }
        return animal;
    }
}