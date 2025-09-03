/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import JDBC.ConnectionFactory;
import Models.ItensSalesModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author caiol
 */
public class ItemSalesDAO {
    private Connection con;
    public ItemSalesDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    public void registerItemSale(ItensSalesModel itemSale){
        try
        {
            String sql = "insert into tb_itensvendas(venda_id, produto_id, qtd, subtotal)"
                    + " values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, itemSale.getSale().getID());
            stmt.setInt(2, itemSale.getProduct().getId());
            stmt.setInt(3, itemSale.getQuantity());
            stmt.setDouble(4, itemSale.getSubtotal());
            
            stmt.execute();
            stmt.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "FALHA ao CADASTRAR Item da Venda: " + e);
        }
    }
}
