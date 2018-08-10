/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.acesso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import projeto.erro.ConexaoException;
import projeto.erro.DaoException;
import projeto.negocio.classesBasicas.Funcionario;
import projeto.util.GerenciadorConexao;
import projeto.util.GerenciadorConexaoImpl;
import projeto.util.Msg;

/**
 *
 * @author Mario
 */
public class FuncionarioDAOImpl implements FuncionarioDAO{
     private final GerenciadorConexao ger;
    public FuncionarioDAOImpl(){
        ger = GerenciadorConexaoImpl.getInstancia();
    }
    
    /**
     * Metodo para inserir os dados do funcionrio no banco de dados
     * @param funcionario
     * @throws DaoException
     * @throws ConexaoException 
     */
    @Override
    public void inserir(Funcionario funcionario) throws DaoException, ConexaoException {
        
        Connection con = ger.abrirConexao();
        String sql = "INSERT INTO FUNCIONARIO (FUN_NOME, FUN_CPF, FUN_TELEFONE, FUN_EMAIL, FUN_CARGO) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, funcionario.getNome());
            pstm.setString(2, funcionario.getCpf());
            pstm.setString(3, funcionario.getTelefone());
            pstm.setString(4, funcionario.getEmail());
            pstm.setString(5, funcionario.getCargo());
            pstm.executeUpdate();
            Msg.msgSucesso("Funcionario inserido com sucesso", "Sucesso ao inserir Cliente");
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        }finally{
            ger.fecharConexao(con);
        }
    }

    /**
     * Metodo para alterar um funcionario
     * @param funcionario
     * @throws DaoException
     * @throws ConexaoException 
     */
    @Override
    public void alterar(Funcionario funcionario) throws DaoException, ConexaoException {
        
        Connection con = ger.abrirConexao();
        String sql = "UPDATE FUNCIONARIO SET FUN_NOME = ?, FUN_CPF = ?, FUN_TELEFONE = ?, FUN_EMAIL = ?, FUN_CARGO = ? WHERE FUN_CODIGO = ?";
        try { 
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, funcionario.getNome());
            pstm.setString(2, funcionario.getCpf());
            pstm.setString(3, funcionario.getTelefone());
            pstm.setString(4, funcionario.getEmail());
            pstm.setString(5, funcionario.getCargo());
            pstm.setInt(6, funcionario.getCodigoFuncionario());
            pstm.executeUpdate(); 
            Msg.msgSucesso("Funcionario alterado com sucesso", "Sucesso ao alterar");
        } catch (SQLException ex) {
            throw new DaoException();
        }finally{
            ger.fecharConexao(con);
        }
    }

    /**
     * Metodo para deletar um funcionario do banco de dados
     * @param codFunc
     * @throws DaoException
     * @throws ConexaoException 
     */
    @Override
    public void deletar(int codFunc) throws DaoException, ConexaoException {
        
        Connection con = ger.abrirConexao();
        String sql = "DELETE FROM FUNCIONARIO WHERE FUN_CODIGO = ?";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, codFunc);
            pstm.executeUpdate();
            Msg.msgSucesso("Funcionario deletado do BD com sucesso!", "Sucesso ao deletar Funcionario");
        } catch (SQLException ex) {
            throw new DaoException();
        }finally{
            ger.fecharConexao(con);
        }
    }

    /**
     * Metodo para consultar um funcionario no banco de dados
     * @param cpf
     * @return Funcionario funcionario
     * @throws DaoException
     * @throws ConexaoException 
     */
    @Override
    public Funcionario consultar(String cpf) throws DaoException, ConexaoException {
        
        Connection con = ger.abrirConexao();
        Funcionario func = null;
        String sql = "SELECT FUN_CODIGO,FUN_CPF,FUN_NOME,FUN_TELEFONE, FUN_CARGO, FUN_EMAIL FROM FUNCIONARIO WHERE FUN_CPF=?";
        try{
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,cpf);
            ResultSet result = pstm.executeQuery();
            if(result.first()){
                func = new Funcionario();
                func.setCodigoFuncionario(result.getInt("FUN_CODIGO"));
                func.setCpf(result.getString("FUN_CPF"));
                func.setNome(result.getString("FUN_NOME"));
                func.setTelefone(result.getString("FUN_TELEFONE"));
                func.setCargo(result.getString("FUN_CARGO"));
                func.setEmail(result.getString("FUN_EMAIL"));
            }
            return func; 
        }catch(SQLException e){
            throw new DaoException();
        }finally{
            ger.fecharConexao(con);
        }   
    }

    /**
     * Metodo que lista todos os funcionarios e retorna em um Array.
     * @return lista de funcionarios.
     * @throws ConexaoException
     * @throws DaoException 
     */
    @Override
    public ArrayList<Funcionario> consultarFuncionarios() throws ConexaoException, DaoException {
        Connection con = ger.abrirConexao();
        Funcionario func;
        ArrayList <Funcionario> ListaFunc = new ArrayList();
        String sql = "SELECT * FROM FUNCIONARIO";

       try{
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet result = pstm.executeQuery();
            while(result.next()){
                func = new Funcionario();
                func.setCodigoFuncionario(result.getInt("FUN_CODIGO"));
                func.setNome(result.getString("FUN_NOME"));
                func.setCpf(result.getString("FUN_CPF"));
                func.setEmail(result.getString("FUN_EMAIL"));  
                func.setTelefone(result.getString("FUN_TELEFONE"));
                func.setCargo(result.getString("FUN_CARGO"));
                ListaFunc.add(func);
            }
           return ListaFunc; 
        }catch(SQLException e){
            throw new DaoException();
        }finally{
            ger.fecharConexao(con);
        }
    } 
}
