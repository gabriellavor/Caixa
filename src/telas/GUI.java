package telas;

import caixa.CaixaEletronico;
import java.sql.*;
import conexao.ModuloConexao;
import javax.swing.JOptionPane;

public class GUI extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet resultado = null;

    public GUI() {
        initComponents();
        conexao = ModuloConexao.conectar();

        if (conexao != null) {
            lblClienteStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/power_on.png")));
        } else {
            lblClienteStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/power_off.png")));
        }
        statusCota();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        lblModuloCliente = new javax.swing.JLabel();
        lblModuloAdmin = new javax.swing.JLabel();
        lblModuloAmbos = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        btnRelatorioCedulas = new javax.swing.JButton();
        btnValorTotalDisponivel = new javax.swing.JButton();
        btnReposicaoCedulas = new javax.swing.JButton();
        btnCotaMinima = new javax.swing.JButton();
        lblClienteStatus = new javax.swing.JLabel();
        lblCotaMinima = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Caixa Eletronico");

        lblModuloCliente.setText("Modulo Cliente");

        btnEfetuarSaque.setText("Efetuar Saque");
        btnEfetuarSaque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEfetuarSaqueActionPerformed(evt);
            }
        });

        lblModuloAdmin.setText("Modulo Administrador");

        lblModuloAmbos.setText("Modulo de Ambos");

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnRelatorioCedulas.setText("Relatorio de Cedulas");
        btnRelatorioCedulas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioCedulasActionPerformed(evt);
            }
        });

        btnValorTotalDisponivel.setText("Valor Total disponivel");
        btnValorTotalDisponivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValorTotalDisponivelActionPerformed(evt);
            }
        });

        btnReposicaoCedulas.setText("Reposição de Cedulas");
        btnReposicaoCedulas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReposicaoCedulasActionPerformed(evt);
            }
        });

        btnCotaMinima.setText("Cota Minima");
        btnCotaMinima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCotaMinimaActionPerformed(evt);
            }
        });

        lblClienteStatus.setText("Status");

        lblCotaMinima.setText("Cota");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEfetuarSaque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRelatorioCedulas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnValorTotalDisponivel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReposicaoCedulas, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblModuloAdmin)
                            .addComponent(lblModuloAmbos))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnCotaMinima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblModuloCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCotaMinima)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblClienteStatus)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModuloCliente)
                    .addComponent(lblClienteStatus)
                    .addComponent(lblCotaMinima))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEfetuarSaque)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblModuloAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRelatorioCedulas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnValorTotalDisponivel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReposicaoCedulas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCotaMinima)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblModuloAmbos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {                                        
        this.dispose();
        new RelatorioMovimentacaoTela().setVisible(true);
    }                                       

    private void btnEfetuarSaqueActionPerformed(java.awt.event.ActionEvent evt) {                                                
        try {
            CaixaEletronico caixa = new CaixaEletronico();
            int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o valor do saque", 0));
            String retorno = caixa.sacar(valor);
            JOptionPane.showMessageDialog(null, retorno);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro " + e);
        } finally {
            statusCota();
        }
    }                                               

    private void btnValorTotalDisponivelActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        try {
            CaixaEletronico caixa = new CaixaEletronico();
            String retorno = caixa.pegaValorTotalDisponivel();
            JOptionPane.showMessageDialog(null, "Valor Total disponivel " + retorno);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro " + e);
        } finally {
            statusCota();
        }
    }                                                       

    private void btnCotaMinimaActionPerformed(java.awt.event.ActionEvent evt) {                                              
        try {
            CaixaEletronico caixa = new CaixaEletronico();
            int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o valor da Cota", caixa.getCotamin()));
            String retorno = caixa.armazenaCotaMinima(valor);
            JOptionPane.showMessageDialog(null, retorno);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro " + e);
        } finally {
            statusCota();
        }

    }                                             

    private void btnRelatorioCedulasActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        try {
            CaixaEletronico caixa = new CaixaEletronico();
            String retorno = caixa.pegaRelatorioCedulas();
            JOptionPane.showMessageDialog(null, retorno);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro " + e);
        } finally {
            statusCota();
        }
    }                                                   

    private void btnReposicaoCedulasActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        try {
            int matrizNota[];
            matrizNota = new int[6];
            matrizNota[0] = 2;
            matrizNota[1] = 5;
            matrizNota[2] = 10;
            matrizNota[3] = 20;
            matrizNota[4] = 50;
            matrizNota[5] = 100;
            CaixaEletronico caixa = new CaixaEletronico();
            for (int i = 0; i < 6; i++) {
                int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade da cedula de " + matrizNota[i], 0));
                String retorno = caixa.reposicaoCedulas(matrizNota[i], valor);
                JOptionPane.showMessageDialog(null, retorno);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro " + e);
        } finally {
            statusCota();
        }
    }                                                   

    public void statusCota() {
        CaixaEletronico caixa = new CaixaEletronico();
        if (caixa.verificaCotaMinima() == true) {
            lblCotaMinima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/gas-station.png")));
            btnEfetuarSaque.setEnabled(true);
        } else {
            lblCotaMinima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/gasoline-pump.png")));
            btnEfetuarSaque.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Caixa Vazio: Chame o Operador");
        }
    }

  
    // Variables declaration - do not modify                     
    private javax.swing.JButton btnCotaMinima;
    public static final javax.swing.JButton btnEfetuarSaque = new javax.swing.JButton();
    private javax.swing.JButton btnRelatorioCedulas;
    private javax.swing.JButton btnReposicaoCedulas;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnValorTotalDisponivel;
    private javax.swing.JLabel lblClienteStatus;
    private javax.swing.JLabel lblCotaMinima;
    private javax.swing.JLabel lblModuloAdmin;
    private javax.swing.JLabel lblModuloAmbos;
    private javax.swing.JLabel lblModuloCliente;
    // End of variables declaration                   
}
