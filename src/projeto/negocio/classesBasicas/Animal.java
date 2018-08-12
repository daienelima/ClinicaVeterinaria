package projeto.negocio.classesBasicas;

/**
 * Tabela Animal
 * @author 
 */
public class Animal {

    private int codigoAnimal;
    private int codigoCliente;
    private String nome;
    private String especie;
    private String sexo; 
    private String dataNascimento;
    private String cpfCliente;
    
    /**
     * @return the codigoAnimal
     */
    public int getCodigoAnimal() {
        return codigoAnimal;
    }

    /**
     * @param codigoAnimal the codigoAnimal to set
     */
    public void setCodigoAnimal(int codigoAnimal) {
        this.codigoAnimal = codigoAnimal;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the especie
     */
    public String getEspecie() {
        return especie;
    }

    /**
     * @param especie the especie to set
     */
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the codigoCliente
     */
    public String getCpfCliente() {
        return cpfCliente;
    }

    /**
     * @param cpfCliente
     */
    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    /**
     * @return the dataNascimento
     */
    public String getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param data 
     */
    public void setDataNascimento(String data) {
        this.dataNascimento = data;
    } 
    
    /**
     * @return 
     */
    public int getCodigoCliente() {
        return this.codigoCliente;
    }   

    /**
     * @param codigoCliente 
     */
    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }
    
}
