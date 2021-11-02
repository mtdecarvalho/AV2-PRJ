/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.Grade;

import Classes.ModeloTabela.ModeloTabelaVendas;
import Classes.Venda;
import Classes.DAO.VendaDAO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    //private int codVenda;
    //private int codCliente = -1;
    //private double preco;
    
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
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vendas");
        setResizable(false);

        tbGradeVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbGradeVendas);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Vendas");

        btnAddVenda.setText("Nova Venda");
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

        jButton1.setText("Consultar venda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Relatório de vendas");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bitcoin.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btnAddVenda)
                .addGap(18, 18, 18)
                .addComponent(btnRemoverVenda)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFechar)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddVenda)
                    .addComponent(btnRemoverVenda)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(btnFechar))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddVendaActionPerformed
        int ultimo = modeloVendas.getRowCount();
        Carrinho abre = new Carrinho(new javax.swing.JFrame(), true, ultimo);
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
            ConsultarVenda abre = new ConsultarVenda(new javax.swing.JFrame(), true, venda);
            abre.setLocationRelativeTo(null);
            abre.setVisible(true);
        }        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        VendaDAO vendadao = new VendaDAO();
        vendas = vendadao.read();
        
        Document document = new Document();   
              
            try {
                PdfWriter.getInstance(document, new FileOutputStream("relatorio.pdf"));
                
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.US);
                
                
                document.open();
                Paragraph p = new Paragraph("Relatório de Vendas");
                p.setAlignment(Element.ALIGN_CENTER);               
                document.add(p);               
                document.add(new Paragraph(" "));
                PdfPTable table = new PdfPTable(4);
                PdfPCell c1 = new PdfPCell(new Phrase("Código Venda"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
                c1 = new PdfPCell(new Phrase("Data e Hora"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
                c1 = new PdfPCell(new Phrase("Preço Total"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
                c1 = new PdfPCell(new Phrase("Codigo do Cliente"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);            
                table.setHeaderRows(1);
                for(int i = 0; i < vendas.size(); i++){
                    table.addCell(String.valueOf(vendas.get(i).getCodigo()));                
                    table.addCell(vendas.get(i).getData());
                    table.addCell(String.valueOf(vendas.get(i).getPrecoTotal()));
                    if (vendas.get(i).getCodigoCliente() > -1)
                    {
                        table.addCell(String.valueOf(vendas.get(i).getCodigoCliente()));
                    } else {
                        table.addCell("");
                    }                        
                }
                
                document.add(table);
                
                } catch (FileNotFoundException | DocumentException ex) {
                    Logger.getLogger(Carrinho.class.getName()).log(Level.SEVERE, null, ex);           
                } finally {
                    document.close();
                }  

                try {
                    Desktop.getDesktop().open(new File("venda.pdf"));
                } catch (IOException ex) {
                    Logger.getLogger(Carrinho.class.getName()).log(Level.SEVERE, null, ex);
                }
            
    }//GEN-LAST:event_jButton2ActionPerformed

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
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbGradeVendas;
    // End of variables declaration//GEN-END:variables
}
