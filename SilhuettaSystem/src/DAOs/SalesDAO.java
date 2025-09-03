/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import JDBC.ConnectionFactory;
import Models.SalesModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author caiol
 */
public class SalesDAO {
    private Connection con;
    public SalesDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    public void registerSale(SalesModel sale){
        try
        {
            String sql = "insert into tb_vendas(cliente_nome, cliente_cpf, data_venda, total_venda, dinheiro, debito, pix, link, credito, parcelas, cliente_endereco, cliente_referencia, observacoes)"
                    + " values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, sale.getClient_name());
            stmt.setString(2, sale.getClient_CPF());
            stmt.setString(3, sale.getDate());
            stmt.setDouble(4, sale.getTotal());
            stmt.setDouble(5, sale.getCash());
            stmt.setDouble(6, sale.getDebit());
            stmt.setDouble(7, sale.getPix());
            stmt.setDouble(8, sale.getLink());
            stmt.setDouble(9, sale.getCredit());
            stmt.setInt(10, sale.getInstallments());
            stmt.setString(11, sale.getClient_address());
            stmt.setString(12, sale.getClient_address_ref());
            stmt.setString(13, sale.getObs());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "SUCESSO ao CADASTRAR Venda.");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "FALHA ao CADASTRAR Venda: " + e);
        }
    }
    
    public int getLastIDSale(){
        try{
            int id = 0;
            
            String sql = "select max(id) id from tb_vendas;";
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                SalesModel c = new SalesModel();
                
                c.setID(rs.getInt("id"));
                
                id = c.getID();
            }
            return id;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
