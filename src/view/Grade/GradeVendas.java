/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.Grade;

import Classes.ModeloTabela.ModeloTabelaVendas;
import Classes.Venda;
import Classes.DAO.VendaDAO;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import view.Carrinho;
import view.ConsultarVenda;

/**
 *
 * @author Carvalho
 */
public class GradeVendas extends javax.swing.JDialog {

    /**
     * Creates new form GradeVendas
     */
    private ModeloTabelaVendas modeloVendas;
    private ArrayList<Venda> vendas = new ArrayList<>();
    
    public GradeVendas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        modeloVendas = new ModeloTabelaVendas(vendas);
        readJTable();
    }

    public GradeVendas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void readJTable()
    {
        modeloVendas = new ModeloTabelaVendas(vendas);
        VendaDAO vendaDAO = new VendaDAO();

        for ( Venda venda : vendaDAO.read() )
        {
            
            venda.getCodigo();
            venda.getData();
            venda.getHora();
            venda.getFormaPagamento();
            venda.getPrecoTotal();
            venda.getCodigoCliente();
            modeloVendas.inserirVenda(venda);
        }
        
        tbGradeVendas.setModel(modeloVendas);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbGradeVendas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnAddVenda = new javax.swing.JButton();
        btnRemoverVenda = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbGradeVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbGradeVendas);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Vendas");

        btnAddVenda.setText("Adicionar nova venda");
        btnAddVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddVendaActionPerformed(evt);
            }
        });

        btnRemoverVenda.setText("Remover venda");
        btnRemoverVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverVendaActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        jButton1.setText("Consultar dados da venda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 130, Short.MAX_VALUE)
                .addComponent(btnAddVenda)
                .addGap(18, 18, 18)
                .addComponent(btnRemoverVenda)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(btnFechar)
                .addGap(86, 86, 86))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddVenda)
                    .addComponent(btnRemoverVenda)
                    .addComponent(btnFechar)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddVendaActionPerformed
        int ultimo = modeloVendas.getRowCount();
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        Carrinho abre = new Carrinho(frame, true, ultimo);
        abre.setLocationRelativeTo(null);
        abre.setVisible(true);
        readJTable();
    }//GEN-LAST:event_btnAddVendaActionPerformed

    private void btnRemoverVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverVendaActionPerformed
        int indice = tbGradeVendas.getSelectedRow();
        if ( indice >= 0 && JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esta venda?", "Confirmação", 2) == 0 )
        {
            Venda venda = modeloVendas.getVenda(indice);
            VendaDAO dao = new VendaDAO();
            dao.delete(venda.getCodigo());
            readJTable();
        }
    }//GEN-LAST:event_btnRemoverVendaActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int indice = tbGradeVendas.getSelectedRow();
        Venda venda = new Venda();
        
        if ( indice >= 0 )
        {
            venda = modeloVendas.getVenda(indice);
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            ConsultarVenda abre = new ConsultarVenda(frame, true, venda);
            abre.setLocationRelativeTo(null);
            abre.setVisible(true);
        }        
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(GradeVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GradeVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GradeVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GradeVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GradeVendas dialog = new GradeVendas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddVenda;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnRemoverVenda;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbGradeVendas;
    // End of variables declaration//GEN-END:variables
}
