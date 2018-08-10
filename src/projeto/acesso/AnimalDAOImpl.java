package projeto.acesso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import projeto.erro.ConexaoException;
import projeto.erro.DaoException;
import projeto.negocio.classesBasicas.Animal;
import projeto.util.GerenciadorConexao;
import projeto.util.GerenciadorConexaoImpl;
import projeto.util.Msg;

/**
 * 
 * @author Geraldo
 */

public class AnimalDAOImpl implements AnimalDAO {
    private final GerenciadorConexao ger;
    public AnimalDAOImpl(){
        ger = GerenciadorConexaoImpl.getInstancia();
    }

    /**
     * Metodo para consultar animal no banco de dados
     * @param id
     * @return Animal
     * @throws ConexaoException
     * @throws DaoException 
     */
    @Override
    public Animal consultar(int id) throws ConexaoException, DaoException {
        
        Connection con = ger.abrirConexao();
        Animal animal = null;
        String sql = "SELECT * FROM ANIMAL WHERE ANI_CODIGO = ?";
        try{
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1,id);
            ResultSet result = pstm.executeQuery();
            if(result.next()){
                animal = new Animal();
                animal.setCodigoAnimal(result.getInt("ANI_CODIGO"));
                animal.setNome(result.getString("ANI_NOME"));
                animal.setEspecie(result.getString("ANI_ESPECIE"));
                animal.setDataNascimento(result.getString("ANI_NASCIMENTO"));
                animal.setCpfCliente(result.getString("CPF_CLIENTE"));
                animal.setSexo("ANI_SEXO");         
            }
            return animal; 
        }catch(SQLException e){
            throw new DaoException();
        }finally{
            ger.fecharConexao(con);
        }   
    }
    
    /**
     * Metodo para inserir animal no banco de dados
     * @param animal
     * @throws ConexaoException
     * @throws DaoException 
     */
    @Override
    public void inserir(Animal animal) throws ConexaoException, DaoException {
       
        Connection con = ger.abrirConexao();
        String sql = "INSERT INTO ANIMAL (ANI_NOME,ANI_ESPECIE,ANI_NASCIMENTO,ANI_SEXO,CPF_CLIENTE) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, animal.getNome());
            pstm.setString(2, animal.getEspecie());
            pstm.setString(3, animal.getDataNascimento());
            pstm.setString(4, animal.getSexo());
            pstm.setString(5, animal.getCpfCliente());
            pstm.executeUpdate();  
            Msg.msgSucesso("Animal inserido com sucesso!", "Inserido com sucesso!");
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        }finally{
            ger.fecharConexao(con);
        }
    }

    /**
     * Metodo para deletar animal no banco de dados.
     * @param codigoAnimal
     * @throws ConexaoException
     * @throws DaoException 
     */
    @Override
    public void deletar(int codigoAnimal) throws ConexaoException, DaoException {
        
        Connection con = ger.abrirConexao();
        String sql = "DELETE FROM ANIMAL WHERE ANI_CODIGO = ?";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, codigoAnimal);
            pstm.executeUpdate();
            Msg.msgSucesso("Animal deletado com sucesso!", "Deletado do banco de dados!");
        } catch (SQLException ex) {
            throw new DaoException();
        }finally{
            ger.fecharConexao(con);
        }
    }

    /**
     * Metodo para alterar animal no banco de dados.
     * @param animal
     * @throws ConexaoException
     * @throws DaoException 
     */
    @Override
    public void atualizar(Animal animal) throws ConexaoException, DaoException {
       
        Connection con = ger.abrirConexao();
        String sql = "UPDATE animal SET ANI_NOME = ?,ANI_ESPECIE = ?, ANI_NASCIMENTO = ?, ANI_SEXO = ?, CPF_CLIENTE = ? WHERE ANI_CODIGO = ?";
        try { 
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, animal.getNome());
            pstm.setString(2, animal.getEspecie());
            pstm.setString(3, animal.getDataNascimento());
            pstm.setString(4, animal.getSexo());
            pstm.setString(5, animal.getCpfCliente());
            pstm.setInt(6, animal.getCodigoAnimal());
            pstm.executeUpdate();   
            Msg.msgSucesso("Animal alterado com sucesso", "Sucesso ao alterar");
        } catch (SQLException ex) {
            throw new DaoException();
        }finally{
            ger.fecharConexao(con);
        }
    }

   /**
    * Metodo para listar todos os animais.
    * @return ArrayList
    * @throws ConexaoException
    * @throws DaoException 
    */
    @Override
    public ArrayList<Animal> listarA() throws ConexaoException, DaoException {
        
        Connection con = ger.abrirConexao();
        String sql ="SELECT * FROM ANIMAL";
        ArrayList <Animal> ListaA = new ArrayList();
        Animal animal;
       try{
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet result = pstm.executeQuery();
            while (result.next()){
                animal = new Animal();
                animal.setCodigoAnimal(result.getInt("ANI_CODIGO"));
                animal.setEspecie(result.getString("ANI_ESPECIE"));
                animal.setNome(result.getString("ANI_NOME"));
                animal.setSexo(result.getString("ANI_SEXO"));
                animal.setDataNascimento(result.getString("ANI_NASCIMENTO"));
                animal.setCpfCliente(result.getString("CPF_CLIENTE"));
                 
                ListaA.add(animal);
            }
           return ListaA; 
        }catch(SQLException e){
            throw new DaoException();
        }finally{
            ger.fecharConexao(con);
        }        
    }  
}

