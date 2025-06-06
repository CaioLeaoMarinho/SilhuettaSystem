/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import JDBC.ConnectionFactory;
import Models.ProductsModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author caiol
 */
public class StockDAO {
    private Connection con;
    public StockDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    
    public void registerProduct(ProductsModel product){
        try
        {
            String sql = "insert into tb_produtos(codigo,modelo, cor, tipo, tamanho, preco, qtd_estoque, fornecedor)"
                    + " values(?,?,?,?,?,?,?,?)";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, product.getCode());
            stmt.setString(2, product.getProduct());
            stmt.setString(3, product.getColor());
            stmt.setString(4, product.getType());
            stmt.setString(5, product.getSize());
            stmt.setDouble(6, product.getPrice());
            stmt.setInt(7, product.getQuantity());
            stmt.setString(8, product.getSupplier());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "SUCESSO ao CADASTRAR Produto.");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "FALHA ao CADASTRAR Produto: " + e);
        }
    }
    
    
    public void updateProduct(ProductsModel product){
        try
        {
            String sql = "update tb_produtos set codigo = ?, produto = ?, cor = ?, tipo = ?, tamanho = ?, preco = ?, qtd_estoque = ?, fornecedor = ? where id = ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, product.getCode());
            stmt.setString(2, product.getProduct());
            stmt.setString(3, product.getColor());
            stmt.setString(4, product.getType());
            stmt.setString(5, product.getSize());
            stmt.setDouble(6, product.getPrice());
            stmt.setInt(7, product.getQuantity());
            stmt.setString(8, product.getSupplier());
            stmt.setInt(9, product.getId());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "SUCESSO ao ALTERAR Produto.");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "FALHA ao ALTERAR Produto: " + e);
        }
    }
    
    
    public void deleteProduct(ProductsModel product){
        try
        {
            String sql = "delete from tb_produtos where id = ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, product.getId());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "SUCESSO ao EXCLUIR Produto.");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "FALHA ao EXCLUIR Produto: " + e);
        }
    }
    
    
    public List<ProductsModel> listProducts(){
        try {
            List<ProductsModel> list = new ArrayList<>();
            
            String sql = "select * from tb_produtos";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                ProductsModel c = new ProductsModel();
                
                c.setId(rs.getInt("id"));
                c.setCode(rs.getString("codigo"));
                c.setProduct(rs.getString("produto"));
                c.setColor(rs.getString("cor"));
                c.setType(rs.getString("tipo"));
                c.setSize(rs.getString("tamanho"));
                c.setPrice(rs.getDouble("preco"));
                c.setQuantity(rs.getInt("qtd_estoque"));
                c.setSupplier(rs.getString("fornecedor"));
                
                list.add(c);
            }
            
            return list;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "FALHA ao LISTAR Clientes: " + e);
            return null;
        }
    }
    
    
    public List<ProductsModel> searchProductByFeatures(String productModel, String productCode, String productColor, String productType, String productSize, String productSupplier){
        try {
            List<ProductsModel> list = new ArrayList<>();
            
            String sql = "select * from tb_produtos where codigo like ? and produto like ? and cor like ? and tipo like ? and tamanho like ? and fornecedor like ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, productCode);
            stmt.setString(2, productModel);
            stmt.setString(3, productColor);
            stmt.setString(4, productType);
            stmt.setString(5, productSize);
            stmt.setString(6, productSupplier);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                ProductsModel c = new ProductsModel();
                
                c.setId(rs.getInt("id"));
                c.setCode(rs.getString("codigo"));
                c.setProduct(rs.getString("produto"));
                c.setColor(rs.getString("cor"));
                c.setType(rs.getString("tipo"));
                c.setSize(rs.getString("tamanho"));
                c.setPrice(rs.getDouble("preco"));
                c.setQuantity(rs.getInt("qtd_estoque"));
                c.setSupplier(rs.getString("fornecedor"));
                
                list.add(c);
            }
            
            return list;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "FALHA ao LISTAR Produtos: " + e);
            return null;
        }
    }
    
    public ProductsModel consultProductByCode(String productCode){
        try{
            String sql = "select * from tb_produtos where codigo = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, productCode);
            
            ResultSet rs = stmt.executeQuery();
            
            ProductsModel c = new ProductsModel();
            if(rs.next()){
                c.setId(rs.getInt("id"));
                c.setCode(rs.getString("codigo"));
                c.setProduct(rs.getString("produto"));
                c.setColor(rs.getString("cor"));
                c.setType(rs.getString("tipo"));
                c.setSize(rs.getString("tamanho"));
                c.setPrice(rs.getDouble("preco"));
                c.setQuantity(rs.getInt("qtd_estoque"));
                c.setSupplier(rs.getString("fornecedor"));
            }
            return c;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "FALHA ao ENCONTRAR Cliente: " + e);
            return null;
        }
    }
}
