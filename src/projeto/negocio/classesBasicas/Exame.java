/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.negocio.classesBasicas;

import java.util.Date;

/**
 *
 * @author Mario
 */
public class Exame {
    
    private String nomeAnimal;
    private int exameCodigo;
    private String exameDescricao;
    private String dataExame;
    private String veterinarioExame;

    /**
     * @return the exameCodigo
     */
    public int getExameCodigo() {
        return exameCodigo;
    }

    /**
     * @param exameCodigo the exameCodigo to set
     */
    public void setExameCodigo(int exameCodigo) {
        this.exameCodigo = exameCodigo;
    }

    /**
     * @return the exameDescricao
     */
    public String getExameDescricao() {
        return exameDescricao;
    }

    /**
     * @param exameDescricao the exameDescricao to set
     */
    public void setExameDescricao(String exameDescricao) {
        this.exameDescricao = exameDescricao;
    }

    /**
     * @return the nomeAnimal
     */
    public String getNomeAnimal() {
        return nomeAnimal;
    }

    /**
     * @param nomeAnimal the nomeAnimal to set
     */
    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    /**
     * @return the dataExame
     */
    public String getDataExame() {
        return dataExame;
    }

    /**
     * @param dataExame the dataExame to set
     */
    public void setDataExame(String dataExame) {
        this.dataExame = dataExame;
    }

    /**
     * @return the veterinarioExame
     */
    public String getVeterinarioExame() {
        return veterinarioExame;
    }

    /**
     * @param veterinarioExame the veterinarioExame to set
     */
    public void setVeterinarioExame(String veterinarioExame) {
        this.veterinarioExame = veterinarioExame;
    }
 
}
