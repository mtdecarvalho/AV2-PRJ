/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.DAO;

import Classes.ConnectionFactory;
import Classes.Parametros;
import Classes.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Juliana
 */
public class VendaDAO {
    public void create(Venda venda, Parametros parametro)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null; 
        formaPagamentoDAO dao = new formaPagamentoDAO();
        
        try 
        {
            if ( venda.getCodigoCliente() != "N/A" )
            {
                con.setAutoCommit(false);
                stmt = con.prepareStatement("INSERT INTO venda(data, hora, formaDePagamento, precoTotal, codigoCliente) VALUES (?,?,?,?,?,?)");

                stmt.setString(1, venda.getData());
                stmt.setString(2, venda.getHora());
                stmt.setInt(3, venda.getFormaPagamento());
                stmt.setDouble(4, venda.getPrecoTotal());
                stmt.setInt(5, Integer.parseInt(venda.getCodigoCliente()));
            }
            else
            {
                con.setAutoCommit(false);
                stmt = con.prepareStatement("INSERT INTO venda(data, hora, formaDePagamento, precoTotal) VALUES (?,?,?,?,?)");
            
                stmt.setString(1, venda.getData());
                stmt.setString(2, venda.getHora());
                stmt.setInt(3, venda.getFormaPagamento());
                stmt.setDouble(4, venda.getPrecoTotal());
            }
            
            stmt.executeUpdate();
            con.commit();
            dao.updateValorTotal(venda.getFormaPagamento(), venda.getPrecoTotal(), Parametros.ADICIONAR);
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
            if (con != null){
                try {
                   JOptionPane.showMessageDialog(null, "Transaction is being rolled back.");
                   con.rollback();
                } catch (SQLException excep) {
                    JOptionPane.showMessageDialog(null, excep);
                }
            }
        } 
        finally 
        {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public ArrayList<Venda> read()
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Venda> vendas = new ArrayList<>();
        
        try
        {
 
            stmt = con.prepareStatement("SELECT * FROM venda");
            rs = stmt.executeQuery();
            
            while (rs.next())
            {
                Venda venda = new Venda();
                
                venda.setCodigo(rs.getInt("codigo"));
                venda.setData(rs.getString("data"));
                venda.setHora(rs.getString("hora"));
                venda.setFormaPagamento(rs.getInt("formaDePagamento"));
                venda.setPrecoTotal(rs.getDouble("precoTotal"));
                venda.setCodigoCliente(String.valueOf(rs.getInt("codigoCliente")));
                if ( rs.wasNull() )
                    venda.setCodigoCliente("N/A");
                vendas.add(venda);
            }
            
        }
        catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return vendas;
    }
    
    public void update(Venda venda, int codigo)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null; 
        
        try 
        {
            con.setAutoCommit(false);
            stmt = con.prepareStatement("UPDATE produto SET  data = ? , "
                    + "hora = ? , formaDePagamento = ? , precoTotal = ? WHERE codigo = ?");
            
            stmt.setString(1, venda.getData());
            stmt.setString(2, venda.getHora());
            stmt.setInt(3, venda.getFormaPagamento());
            stmt.setDouble(4, venda.getPrecoTotal());
            stmt.setInt(1, codigo);
            
            stmt.executeUpdate();
            con.commit();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
            if (con != null){
                try {
                   JOptionPane.showMessageDialog(null, "Transaction is being rolled back.");
                   con.rollback();
                } catch (SQLException excep) {
                    JOptionPane.showMessageDialog(null, excep);
                }
            }
        } 
        finally 
        {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(Venda venda)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null; 
        formaPagamentoDAO dao = new formaPagamentoDAO();
        
        try 
        {
            con.setAutoCommit(false);
            stmt = con.prepareStatement("DELETE FROM venda WHERE codigo = ?");
            
            stmt.setInt(1, venda.getCodigo());
            
            stmt.executeUpdate();
            con.commit();
            
            dao.updateValorTotal(venda.getFormaPagamento(), venda.getPrecoTotal(), Parametros.REMOVER);
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
            if (con != null){
                try {
                   JOptionPane.showMessageDialog(null, "Transaction is being rolled back.");
                   con.rollback();
                } catch (SQLException excep) {
                    JOptionPane.showMessageDialog(null, excep);
                }
            }
        } 
        finally 
        {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
}
