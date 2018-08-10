package projeto.acesso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import projeto.erro.ConexaoException;
import projeto.erro.DaoException;
import projeto.negocio.classesBasicas.Exame;
import projeto.util.GerenciadorConexao;
import projeto.util.GerenciadorConexaoImpl;
import projeto.util.Msg;

/**
 *
 * @author Mario
 */
public class ExameDAOImpl implements ExameDAO {
    private final GerenciadorConexao ger;
    public ExameDAOImpl(){
        ger = GerenciadorConexaoImpl.getInstancia();
    }
    
    /**
     * Metodo para inserir no banco de dados
     * @param exame
     * @throws DaoException
     * @throws ConexaoException 
     */
    @Override
    public void inserir(Exame exame) throws DaoException, ConexaoException {
       
        Connection con = ger.abrirConexao();
        String sql = "INSERT INTO EXAME (EXA_NOME_ANIMAL,EXA_DESCRICAO,EXA_VETERINARIO,EXA_DATA) VALUES (?,?,?,?)";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, exame.getNomeAnimal());
            pstm.setString(2, exame.getExameDescricao());
            pstm.setString(3, exame.getVeterinarioExame());
            pstm.setString(4, exame.getDataExame());
            pstm.execute();
            Msg.msgSucesso("Exame agendado com sucesso", "Sucesso ao agendar exame");
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        } finally{
            ger.fecharConexao(con);
        }
    }

    /**
     * Metodo para alterar no banco de dados
     * @param exame
     * @throws DaoException
     * @throws ConexaoException 
     */
    @Override
    public void alterar(Exame exame) throws DaoException, ConexaoException {
         
        Connection con = ger.abrirConexao();
        String sql = "UPDATE EXAME SET EXA_DESCRICAO = ?, EXA_VETERINARIO = ?, EXA_DATA = ?, EXA_NOME_ANIMAL = ? WHERE EXA_CODIGO = ?";
        try { 
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, exame.getExameDescricao());
            pstm.setString(2, exame.getVeterinarioExame());
            pstm.setString(3, exame.getDataExame());
            pstm.setString(4, exame.getNomeAnimal());
            pstm.setInt(5, exame.getExameCodigo());
            pstm.executeUpdate(); 
            Msg.msgSucesso("Exame alterado com sucesso", "Sucesso ao alterar Exame");
        } catch (SQLException ex) {
            throw new DaoException();
        }finally{
            ger.fecharConexao(con);
        }
    }

    /**
     * Metodo para deletar do banco de dados
     * @param codExame
     * @throws DaoException
     * @throws ConexaoException 
     */
    @Override
    public void deletar(int codExame) throws DaoException, ConexaoException {
        
        Connection con = ger.abrirConexao();
        String sql = "DELETE FROM EXAME WHERE EXA_CODIGO = ?";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, codExame);
            pstm.executeUpdate();
            Msg.msgSucesso("Exame deletado do BD com sucesso!", "Sucesso ao deletar Exame");
        } catch (SQLException ex) {
            throw new DaoException();
        }finally{
            ger.fecharConexao(con);
        }
    }

    /**
     * Metodo para consultar no banco de dados
     * @param codExame
     * @return
     * @throws DaoException
     * @throws ConexaoException 
     */
    @Override
    public Exame consultar(int codExame) throws DaoException, ConexaoException {
        
        Connection con = ger.abrirConexao();
        Exame exame = null;
        String sql = "SELECT * FROM EXAME WHERE EXA_CODIGO = ?";
        try{
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1,codExame);
            ResultSet result = pstm.executeQuery();
            if(result.first()){
                exame = new Exame();
                exame.setExameCodigo(result.getInt("EXA_CODIGO"));
                exame.setExameDescricao(result.getString("EXA_DESCRICAO"));
                exame.setVeterinarioExame(result.getString("EXA_VETERINARIO"));
                exame.setDataExame(result.getString("EXA_DATA"));
                exame.setNomeAnimal(result.getString("EXA_NOME_ANIMAL"));
            }
            return exame; 
        }catch(SQLException e){
            throw new DaoException();
        }finally{
            ger.fecharConexao(con);
        }   
        
    }

    /**
     * Metodo para consultar uma lista de todos os exames no banco de dados
     * @return
     * @throws ConexaoException
     * @throws DaoException 
     */
    @Override
    public ArrayList<Exame> listarExames() throws ConexaoException, DaoException {
        Connection con = ger.abrirConexao();
        Exame exame;
        ArrayList <Exame> Lista = new ArrayList();
        String sql = "SELECT * FROM EXAME";

       try{
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet result = pstm.executeQuery();
            while(result.next()){
                exame = new Exame();
                exame.setExameCodigo(result.getInt("EXA_CODIGO"));
                exame.setDataExame(result.getString("EXA_DATA"));
                exame.setExameDescricao(result.getString("EXA_DESCRICAO"));
                exame.setNomeAnimal(result.getString("EXA_NOME_ANIMAL"));  
                exame.setVeterinarioExame(result.getString("EXA_VETERINARIO"));
                Lista.add(exame);
            }
           return Lista; 
        }catch(SQLException e){
            throw new DaoException();
        }finally{
            ger.fecharConexao(con);
        }
    }
    
}
