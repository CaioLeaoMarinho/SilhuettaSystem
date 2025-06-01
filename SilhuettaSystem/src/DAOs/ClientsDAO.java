/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import JDBC.ConnectionFactory;
import Models.ClientsModel;
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
public class ClientsDAO {
    private Connection con;
    public ClientsDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    
    public void registerClient(ClientsModel client){
        try
        {
            String sql = "insert into tb_clientes(nome, cpf, email, celular, cep, endereco)"
                    + " values(?,?,?,?,?,?)";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, client.getName());
            stmt.setString(2, client.getCPF());
            stmt.setString(3, client.getEmail());
            stmt.setString(4, client.getCellphone());
            stmt.setString(5, client.getCEP());
            stmt.setString(6, client.getAddress());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "SUCESSO ao CADASTRAR Cliente.");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "FALHA ao CADASTRAR Cliente: " + e);
        }
    }
    
    
    public void updateClient(ClientsModel client){
        try
        {
            String sql = "update tb_clientes set nome = ?, cpf = ?, email = ?, celular = ?, cep = ?, endereco = ? where id = ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, client.getName());
            stmt.setString(2, client.getCPF());
            stmt.setString(3, client.getEmail());
            stmt.setString(4, client.getCellphone());
            stmt.setString(5, client.getCEP());
            stmt.setString(6, client.getAddress());
            stmt.setInt(7, client.getId());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "SUCESSO ao ALTERAR Cliente.");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "FALHA ao ALTERAR Cliente: " + e);
        }
    }
    
    
    public void deleteClient(ClientsModel client){
        try
        {
            String sql = "delete from tb_clientes where id = ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, client.getId());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "SUCESSO ao EXCLUIR Cliente.");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "FALHA ao EXCLUIR Cliente: " + e);
        }
    }
    
    
    public List<ClientsModel> listClients(){
        try {
            List<ClientsModel> list = new ArrayList<>();
            
            String sql = "select * from tb_clientes";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                ClientsModel c = new ClientsModel();
                
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setCellphone(rs.getString("celular"));
                c.setAddress(rs.getString("endereco"));
                c.setCEP(rs.getString("cep"));
                c.setCPF(rs.getString("cpf"));
                
                list.add(c);
            }
            
            return list;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "FALHA ao LISTAR Clientes: " + e);
            return null;
        }
    }
    
    
    public List<ClientsModel> searchClientsByName(String clientCPF){
        try {
            List<ClientsModel> list = new ArrayList<>();
            
            String sql = "select * from tb_clientes where cpf like ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, clientCPF);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                ClientsModel c = new ClientsModel();
                
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setCellphone(rs.getString("celular"));
                c.setAddress(rs.getString("endereco"));
                c.setCEP(rs.getString("cep"));
                c.setCPF(rs.getString("cpf"));
                
                list.add(c);
            }
            
            return list;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "FALHA ao LISTAR Clientes: " + e);
            return null;
        }
    }
    
    
    public ClientsModel consultClientByName(String clientName){
        try{
            String sql = "select * from tb_clientes where nome = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, clientName);
            
            ResultSet rs = stmt.executeQuery();
            
            ClientsModel c = new ClientsModel();
            if(rs.next()){
                
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setCellphone(rs.getString("celular"));
                c.setAddress(rs.getString("endereco"));
                c.setCEP(rs.getString("cep"));
                c.setCPF(rs.getString("cpf"));
            }
            return c;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "FALHA ao ENCONTRAR Cliente: " + e);
            return null;
        }
    }
}
