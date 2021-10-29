/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Classes.Cliente;
import Classes.DAO.ClienteDAO;
import Classes.ModeloTabela.ModeloTabelaCarrinho;
import Classes.Parametros;
import Classes.Produto;
import Classes.DAO.ProdutoDAO;
import Classes.Venda;
import Classes.DAO.VendaDAO;
import Classes.ItemVenda;
import Classes.DAO.ItemVendaDAO;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Juliana
 */
public class Carrinho extends javax.swing.JDialog {
    private ModeloTabelaCarrinho modeloCarrinho;
    private ArrayList<ItemVenda> itens = new ArrayList<>();
    private ArrayList<Produto> produtos = new ArrayList<>();
    private int codVenda;
    private int codCliente = -1;
    private double preco;
    /**
     * Creates new form Carrinho
     */
    public Carrinho(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        modeloCarrinho = new ModeloTabelaCarrinho(itens);
        tbCarrinho.setModel(modeloCarrinho);
    }
    
    public Carrinho(java.awt.Frame parent, boolean modal, int codVenda) {
        super(parent, modal);
        initComponents();
        ProdutoDAO dao = new ProdutoDAO();
        this.codVenda = codVenda+1;
        modeloCarrinho = new ModeloTabelaCarrinho(itens);
        tbCarrinho.setModel(modeloCarrinho);
        produtos = dao.read();
    }
    
    public void calcularPreco()
    {
        preco = 0;
        for ( ItemVenda item : modeloCarrinho.getItens() )
        {
            preco += item.getPreco();
        }
        tbxPrecoTotal.setText(String.valueOf(preco));
    }
    
    public void atualizarEstoque(int codigoProduto, int quantidade, Parametros parametro)
    {
        ProdutoDAO dao = new ProdutoDAO();
        
        int qtdNova = 0, qtdAtual = 0;
        
//        produtos = dao.read();
        
        for ( int i = 0 ; i < produtos.size() ; i++ )
        {
            if ( produtos.get(i).getCodigo() == codigoProduto )
            {
                qtdAtual = produtos.get(i).getQtdEstoque();
                if (parametro == Parametros.REMOVER)
                {
                    qtdNova = qtdAtual - quantidade;
                    produtos.get(i).setQtdEstoque(qtdNova);
                }
                else
                {
                    qtdNova = qtdAtual + quantidade;
                    produtos.get(i).setQtdEstoque(qtdNova);
                }
                break;
            }
        }
        
//        dao.updateEstoque(codigoProduto, quantidade, parametro);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCarrinho = new javax.swing.JTable();
        btnAddItem = new javax.swing.JButton();
        btnRemoverItem = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();
        cbFormaPagamento = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        tbxPrecoTotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        tbxCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnAddCliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Registro de nova venda");

        tbCarrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbCarrinho);

        btnAddItem.setText("Adicionar item");
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemActionPerformed(evt);
            }
        });

        btnRemoverItem.setText("Remover item");
        btnRemoverItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverItemActionPerformed(evt);
            }
        });

        btnFinalizar.setText("Finalizar Venda");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        cbFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cartão de Crédito", "Dinheiro" }));

        jLabel2.setText("Forma de pagamento:");

        tbxPrecoTotal.setEditable(false);

        jLabel3.setText("Preço total:");

        jButton1.setText("Cancelar");

        tbxCliente.setEditable(false);

        jLabel4.setText("Cliente:");

        btnAddCliente.setText("Adicionar cliente");
        btnAddCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tbxPrecoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(btnAddCliente)
                                .addGap(18, 18, 18)
                                .addComponent(btnAddItem)
                                .addGap(18, 18, 18)
                                .addComponent(btnRemoverItem)
                                .addGap(18, 18, 18)
                                .addComponent(btnFinalizar)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel1)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(tbxPrecoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(tbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddItem)
                    .addComponent(btnRemoverItem)
                    .addComponent(btnFinalizar)
                    .addComponent(jButton1)
                    .addComponent(btnAddCliente))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        AdicionarItem abre = new AdicionarItem(frame, true, codVenda, produtos);
        abre.setLocationRelativeTo(null);
        abre.setVisible(true);
        if ( abre.getItem() != null ) 
        { 
            modeloCarrinho.inserirItemVenda(abre.getItem()); 
            atualizarEstoque(abre.getItem().getCodigoProduto(), abre.getItem().getQtdVendida(), Parametros.REMOVER);
        }
        calcularPreco();
    }//GEN-LAST:event_btnAddItemActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        Venda venda = new Venda();
        VendaDAO vendaDAO = new VendaDAO();
        
        String data = String.valueOf(java.time.LocalDate.now());
        String hora = String.valueOf(java.time.LocalTime.now());
        
        venda.setCodigo(codVenda);
        venda.setData(data);
        venda.setHora(hora);
        if ( cbFormaPagamento.getSelectedItem().toString().equals("Cartão de Crédito") )
        {
            venda.setFormaPagamento(0);
        } else venda.setFormaPagamento(1);
        venda.setPrecoTotal(preco);
        venda.setCodigoCliente(codCliente);
        
        vendaDAO.create(venda, Parametros.COM_NOTIFICACAO);
        
        for ( ItemVenda item : modeloCarrinho.getItens() )
        {
            ProdutoDAO pDAO = new ProdutoDAO();
            ItemVendaDAO dao = new ItemVendaDAO();
            
            item.getCodigoVenda();
            item.getCodigoProduto();
            item.getQtdVendida();
            item.getPreco();
            
            dao.create(item, Parametros.SEM_NOTIFICACAO);
            pDAO.updateUltimaVenda(item.getCodigoProduto(), data);
            pDAO.updateEstoque(item.getCodigoProduto(), item.getQtdVendida(), Parametros.REMOVER);
        }
        
        dispose();
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnRemoverItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverItemActionPerformed
        int indice = tbCarrinho.getSelectedRow();
        
        if ( indice >= 0 )
        {
            int qtd = modeloCarrinho.getItemVenda(indice).getQtdVendida();
            int codigoProduto = modeloCarrinho.getItemVenda(indice).getCodigoProduto();
            atualizarEstoque(codigoProduto, qtd, Parametros.ADICIONAR);
            modeloCarrinho.excluirItemVenda(indice);
            calcularPreco();
        }
    }//GEN-LAST:event_btnRemoverItemActionPerformed

    private void btnAddClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddClienteActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        SelecionarCliente abre = new SelecionarCliente(frame, true);
        abre.setLocationRelativeTo(null);
        abre.setVisible(true);
        if ( abre.getCliente() != null )
        {
            codCliente = abre.getCliente().getCodigo();
            tbxCliente.setText(abre.getCliente().getNome());
        }
    }//GEN-LAST:event_btnAddClienteActionPerformed

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
            java.util.logging.Logger.getLogger(Carrinho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Carrinho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Carrinho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Carrinho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Carrinho dialog = new Carrinho(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAddCliente;
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnRemoverItem;
    private javax.swing.JComboBox<String> cbFormaPagamento;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCarrinho;
    private javax.swing.JTextField tbxCliente;
    private javax.swing.JTextField tbxPrecoTotal;
    // End of variables declaration//GEN-END:variables
}
