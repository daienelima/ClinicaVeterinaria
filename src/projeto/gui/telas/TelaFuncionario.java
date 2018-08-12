/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.gui.telas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListSelectionModel;
import projeto.erro.AutenticacaoException;
import projeto.erro.ConexaoException;
import projeto.erro.DaoException;
import projeto.erro.RegraExceptionFuncionario;
import projeto.negocio.classesBasicas.Autenticacao;
import projeto.negocio.classesBasicas.Funcionario;
import projeto.negocio.fachada.FachadaAutenticacao;
import projeto.negocio.fachada.FachadaFuncionario;
import projeto.util.Msg;
import projeto.util.TableFuncionario;

/**
 *
 * @author aluno
 */
public class TelaFuncionario extends javax.swing.JFrame {

    int acao;
    int codigoFuncionario;
    /**
     * Creates new form Funcionario
     */
    public TelaFuncionario() {
        initComponents();
        preencherTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFuncNome = new javax.swing.JTextField();
        txtFuncCpf = new javax.swing.JFormattedTextField();
        txtFuncTel = new javax.swing.JFormattedTextField();
        btnCadastrarFuncionario = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtFuncEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        comboFuncCargo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFunc = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtFuncId = new javax.swing.JTextField();
        jButtonAlterar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonDeletar = new javax.swing.JButton();
        jButtonNovo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Funcionario");
        setResizable(false);

        jPanel1.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Nome :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("CPF :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Telefone :");

        txtFuncNome.setEnabled(false);
        txtFuncNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFuncNomeActionPerformed(evt);
            }
        });

        try {
            txtFuncCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFuncCpf.setEnabled(false);

        try {
            txtFuncTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFuncTel.setEnabled(false);

        btnCadastrarFuncionario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCadastrarFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/gui/icones/salvar_1.png"))); // NOI18N
        btnCadastrarFuncionario.setText("Salvar");
        btnCadastrarFuncionario.setEnabled(false);
        btnCadastrarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarFuncionarioActionPerformed(evt);
            }
        });

        jLabel5.setText("Email :");

        txtFuncEmail.setEnabled(false);

        jLabel6.setText("Cargo :");

        comboFuncCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Cargo", "Recepcionista", "Veterinario", "Outros" }));
        comboFuncCargo.setEnabled(false);

        jTableFunc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableFunc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFuncMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableFunc);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("ID :");

        txtFuncId.setEnabled(false);

        jButtonAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/gui/icones/reload.png"))); // NOI18N
        jButtonAlterar.setText("Alterar");
        jButtonAlterar.setEnabled(false);
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/gui/icones/excluir.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setEnabled(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/gui/icones/trash.gif"))); // NOI18N
        jButtonDeletar.setText("Deletar");
        jButtonDeletar.setEnabled(false);
        jButtonDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeletarActionPerformed(evt);
            }
        });

        jButtonNovo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/gui/icones/add.png"))); // NOI18N
        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cadastro de Funcionários");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(228, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap(214, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel4)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFuncId, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFuncNome, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFuncCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFuncEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboFuncCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFuncTel, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonNovo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDeletar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAlterar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrarFuncionario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtFuncId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtFuncNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtFuncCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFuncTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCadastrarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFuncEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboFuncCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButtonDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtFuncNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFuncNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFuncNomeActionPerformed

    private void btnCadastrarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarFuncionarioActionPerformed

        FachadaFuncionario fachadaFunc = new FachadaFuncionario();
        FachadaAutenticacao fachadaAutenticacao = new FachadaAutenticacao();
        String cpfFormater = txtFuncCpf.getText().replaceAll("[^0-9]", "");
        String telFormater = txtFuncTel.getText().replaceAll("[^0-9]", "");
        
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(txtFuncNome.getText());
        funcionario.setCpf(cpfFormater);
        funcionario.setTelefone(telFormater);
        funcionario.setEmail(txtFuncEmail.getText());
        funcionario.setCargo(comboFuncCargo.getSelectedItem()+"");
        
        Autenticacao autenticacao = new Autenticacao();
        autenticacao.setFunCpf(cpfFormater);
        autenticacao.setLogin(cpfFormater);
        autenticacao.setPass("12345");
        autenticacao.setPrimeiroAcesso("Y");
        
        if(acao == 1){
            try{
                fachadaFunc.cadastrarFuncionario(funcionario);
                fachadaAutenticacao.inserirCredenciais(autenticacao);
            } catch (RegraExceptionFuncionario ex) {
                Msg.msgErro(ex.getMessage(),"Erro ao inserir");
            } catch (DaoException ex) {
                Msg.msgErro("Nao foi possivel inserir o funcionario no banco de dados","Erro de SQL");
            } catch (ConexaoException ex) {
                Msg.msgErro("Nao foi possivel inserir o funcionario no banco de dados","Erro na conexão");
            } catch (AutenticacaoException ex) {
                Msg.msgErro("Não foi possivel inserir as credenciais do Funcionario", "Erro ao inserir credenciais");
            }
        }
        
        if(acao == 2){
            funcionario.setCodigoFuncionario(Integer.parseInt(txtFuncId.getText()));
            try {
                fachadaFunc.alterarFuncionario(funcionario);
            } catch (RegraExceptionFuncionario ex) {
                Msg.msgErro("Nao foi possivel alterar o funcionario no banco de dados","Erro ao inserir");
            } catch (DaoException ex) {
                Msg.msgErro("Nao foi possivel alterar o funcionario no banco de dados","Erro de SQL");
            } catch (ConexaoException ex) {
                Msg.msgErro("Nao foi possivel alterar o funcionario no banco de dados","Erro na conexão");
            }
        }
        
        limparCampos();
        desativaCampos();
        
        jButtonNovo.setEnabled(false);
        jButtonCancelar.setEnabled(false);
        jButtonNovo.setEnabled(true);
        jButtonDeletar.setEnabled(false);
        btnCadastrarFuncionario.setEnabled(false);
        
        preencherTabela();
        
    }//GEN-LAST:event_btnCadastrarFuncionarioActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        
        acao = 2;
        
        ativaCampos();
        
        btnCadastrarFuncionario.setEnabled(true);
        jButtonAlterar.setEnabled(false);
        jButtonCancelar.setEnabled(true);
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed

        limparCampos();
                
        jButtonAlterar.setEnabled(false);
        jButtonDeletar.setEnabled(false);
        jButtonCancelar.setEnabled(false);
        btnCadastrarFuncionario.setEnabled(false);
        jButtonNovo.setEnabled(true);

        desativaCampos();
        
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeletarActionPerformed

        FachadaFuncionario fachada = new FachadaFuncionario();
        try {
            fachada.deletarFuncionario(Integer.parseInt(txtFuncId.getText()));
        } catch (RegraExceptionFuncionario ex) {
            Msg.msgErro("Nao foi possivel deletar o funcionario no banco de dados","Erro ao Deletar");
        } catch (DaoException ex) {
            Msg.msgErro("Nao foi possivel deletar o funcionario no banco de dados","Erro de SQL");
        } catch (ConexaoException ex) {
            Msg.msgErro("Nao foi possivel deletar o funcionario no banco de dados","Erro na conexão");
        }

        desativaCampos();
        
        limparCampos();

        jButtonAlterar.setEnabled(false);
        jButtonDeletar.setEnabled(false);
        jButtonCancelar.setEnabled(false);
        btnCadastrarFuncionario.setEnabled(false);
        jButtonNovo.setEnabled(true);

        preencherTabela();

    }//GEN-LAST:event_jButtonDeletarActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        acao = 1;
        
        ativaCampos();
        
        jButtonCancelar.setEnabled(true);
        btnCadastrarFuncionario.setEnabled(true);
        jButtonNovo.setEnabled(false);
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jTableFuncMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFuncMouseClicked
        String cpfFunc = String.valueOf(jTableFunc.getValueAt(jTableFunc.getSelectedRow(), 2));
        
        FachadaFuncionario fachadaFuncionario = new FachadaFuncionario();
        try{
            Funcionario funcionario = fachadaFuncionario.consultarFuncionario(cpfFunc);
            txtFuncId.setText(String.valueOf(funcionario.getCodigoFuncionario()));
            txtFuncNome.setText(funcionario.getNome());
            txtFuncCpf.setText(funcionario.getCpf());
            txtFuncEmail.setText(funcionario.getEmail());
            txtFuncTel.setText(funcionario.getTelefone());
            comboFuncCargo.setSelectedItem(funcionario.getCargo());
            jButtonAlterar.setEnabled(true);
            jButtonDeletar.setEnabled(true);
            
        }catch(RegraExceptionFuncionario e){
            Msg.msgErro("Erro ao tentar pegar Funcionario", "Error");
        }catch(ConexaoException e){
            Msg.msgErro("Erro ao tentar pegar Funcionario", "Erro de Conexão");
        }catch(DaoException e){
            Msg.msgErro("Erro ao tentar pegar Funcionario", "Erro SQL");
        }
    }//GEN-LAST:event_jTableFuncMouseClicked

    public void preencherTabela(){
        
        FachadaFuncionario fachadaFuncionario = new FachadaFuncionario();
        List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
        ArrayList data = new ArrayList();
        String [] colunas = new String []{"Id", "Nome", "CPF", "EMAIL", "Telefone","Cargo"};
        try {
            listaFuncionario = fachadaFuncionario.listarFuncionarios();
            for(Funcionario lFunc : listaFuncionario){
                data.add(new Object[]{lFunc.getCodigoFuncionario(),lFunc.getNome(),lFunc.getCpf(),lFunc.getEmail(),lFunc.getTelefone(), lFunc.getCargo()});
            }
        } catch (RegraExceptionFuncionario | ConexaoException | DaoException ex) {
            Msg.msgErro("Não foi possivel listar os funcionarios.","Erro ao listar os Funcionarios");
        }
        
        TableFuncionario tabela = new TableFuncionario(data, colunas);
        jTableFunc.setModel(tabela);
        jTableFunc.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTableFunc.getColumnModel().getColumn(0).setResizable(false);
        jTableFunc.getColumnModel().getColumn(1).setPreferredWidth(130);
        jTableFunc.getColumnModel().getColumn(1).setResizable(false);
        jTableFunc.getColumnModel().getColumn(2).setPreferredWidth(110);
        jTableFunc.getColumnModel().getColumn(2).setResizable(false);
        jTableFunc.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTableFunc.getColumnModel().getColumn(3).setResizable(false);
        jTableFunc.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTableFunc.getColumnModel().getColumn(4).setResizable(false);
        jTableFunc.getColumnModel().getColumn(5).setPreferredWidth(100);
        jTableFunc.getColumnModel().getColumn(5).setResizable(false);
        jTableFunc.getTableHeader().setReorderingAllowed(false);
        jTableFunc.setAutoResizeMode(jTableFunc.AUTO_RESIZE_OFF);
        jTableFunc.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
    }
    
    /**
     * Metodo para limpar os campos do formulário
     */
    public void limparCampos(){
        txtFuncId.setText("");
        txtFuncNome.setText("");
        txtFuncCpf.setText("");
        txtFuncTel.setText("");
        txtFuncEmail.setText("");
        comboFuncCargo.setSelectedItem("Selecione o Cargo");
    }
    
    /**
     * Metodo para desabilitar a edição dos campos do formulario
     */
    public void desativaCampos(){
        txtFuncNome.setEnabled(false);
        txtFuncCpf.setEnabled(false);
        txtFuncTel.setEnabled(false);
        txtFuncEmail.setEnabled(false);
        comboFuncCargo.setEnabled(false);
    }
    
    /**
     * Metodo para ativar os campos do formulario
     */
    public void ativaCampos(){
        txtFuncNome.setEnabled(true);
        txtFuncCpf.setEnabled(true);
        txtFuncTel.setEnabled(true);
        txtFuncEmail.setEnabled(true);
        comboFuncCargo.setEnabled(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarFuncionario;
    private javax.swing.JComboBox<String> comboFuncCargo;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonDeletar;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFunc;
    private javax.swing.JFormattedTextField txtFuncCpf;
    private javax.swing.JTextField txtFuncEmail;
    private javax.swing.JTextField txtFuncId;
    private javax.swing.JTextField txtFuncNome;
    private javax.swing.JFormattedTextField txtFuncTel;
    // End of variables declaration//GEN-END:variables
}