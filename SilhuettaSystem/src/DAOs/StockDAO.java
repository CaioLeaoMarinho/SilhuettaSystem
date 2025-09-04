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
            String sql = "insert into tb_produtos(codigo, referencia, produto, cor, tipo, tamanho, preco, qtd_estoque, fornecedor)"
                    + " values(?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, product.getCode());
            stmt.setString(2, product.getReference());
            stmt.setString(3, product.getProduct());
            stmt.setString(4, product.getColor());
            stmt.setString(5, product.getType());
            stmt.setString(6, product.getSize());
            stmt.setDouble(7, product.getPrice());
            stmt.setInt(8, product.getQuantity());
            stmt.setString(9, product.getSupplier());
            
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
            String sql = "update tb_produtos set codigo = ?, referencia = ?, produto = ?, cor = ?, tipo = ?, tamanho = ?, preco = ?, qtd_estoque = ?, fornecedor = ? where id = ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, product.getCode());
            stmt.setString(2, product.getReference());
            stmt.setString(3, product.getProduct());
            stmt.setString(4, product.getColor());
            stmt.setString(5, product.getType());
            stmt.setString(6, product.getSize());
            stmt.setDouble(7, product.getPrice());
            stmt.setInt(8, product.getQuantity());
            stmt.setString(9, product.getSupplier());
            stmt.setInt(10, product.getId());
            
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
                c.setReference(rs.getString("referencia"));
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
    
    
    public List<ProductsModel> searchProductByFeatures(String productID, String productReference, String productProduct, String productColor, String productType, String productSize, String productSupplier){
        try {
            List<ProductsModel> list = new ArrayList<>();
            
            String sql = "select * from tb_produtos where id like ? and referencia like ? and produto like ? and cor like ? and tipo like ? and tamanho like ? and fornecedor like ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, productID);
            stmt.setString(2, productReference);
            stmt.setString(3, productProduct);
            stmt.setString(4, productColor);
            stmt.setString(5, productType);
            stmt.setString(6, productSize);
            stmt.setString(7, productSupplier);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                ProductsModel c = new ProductsModel();
                
                c.setId(rs.getInt("id"));
                c.setCode(rs.getString("codigo"));
                c.setReference(rs.getString("referencia"));
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
            JOptionPane.showMessageDialog(null, "FALHA ao FILTRAR Produtos: " + e);
            return null;
        }
    }
    
    public ProductsModel consultProductByID(int productID){
        try{
            String sql = "select * from tb_produtos where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, productID);
            
            ResultSet rs = stmt.executeQuery();
            
            ProductsModel c = new ProductsModel();
            if(rs.next()){
                c.setId(rs.getInt("id"));
                c.setCode(rs.getString("codigo"));
                c.setReference(rs.getString("referencia"));
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
            JOptionPane.showMessageDialog(null, "FALHA ao ENCONTRAR Produto: " + e);
            return null;
        }
    }
    
    public void StockWriteOff(int productID, int newQuantity){
        try{
            String sql = "update tb_produtos set qtd_estoque = ? where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, newQuantity);
            stmt.setInt(2, productID);
            
            stmt.execute();
            stmt.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "FALHA ao dar BAIXA no Estoque: " + e);
        }
    }
    
    public int getProductStock(int productID){
        try{
            int inStock = 0;
            
            String sql = "SELECT qtd_estoque from tb_produtos where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, productID);
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){              
                inStock = (rs.getInt("qtd_estoque"));
            }
            
            return inStock;
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
