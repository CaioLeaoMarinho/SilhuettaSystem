/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import JDBC.ConnectionFactory;
import Models.EmployeesModel;
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
public class EmployeesDAO {
    private Connection con;
    public EmployeesDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    
    public void registerEmployee(EmployeesModel employee){
        try
        {
            String sql = "insert into tb_funcionarios(nome, rg, cpf, email, senha, celular, cep, endereco, nivel_acesso)"
                    + " values(?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getRg());
            stmt.setString(3, employee.getCPF());
            stmt.setString(4, employee.getEmail());
            stmt.setString(5, employee.getPassword());
            stmt.setString(6, employee.getCellphone());
            stmt.setString(7, employee.getCEP());
            stmt.setString(8, employee.getAddress());
            stmt.setString(9, employee.getAcessLevel());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "SUCESSO ao CADASTRAR Funcionario.");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "FALHA ao CADASTRAR Funcionario: " + e);
        }
    }
    
    
    public void updateEmployee(EmployeesModel employee){
        try
        {
            String sql = "update tb_funcionarios set nome = ?, rg = ?, cpf = ?, email = ?, senha = ?, celular = ?, cep = ?, endereco = ?, nivel_acesso = ? where id = ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getRg());
            stmt.setString(3, employee.getCPF());
            stmt.setString(4, employee.getEmail());
            stmt.setString(5, employee.getPassword());
            stmt.setString(6, employee.getCellphone());
            stmt.setString(7, employee.getCEP());
            stmt.setString(8, employee.getAddress());
            stmt.setString(9, employee.getAcessLevel());
            stmt.setInt(10, employee.getId());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "SUCESSO ao ALTERAR Funcionario.");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "FALHA ao ALTERAR Funcionario: " + e);
        }
    }
    
    
    public void deleteEmployee(EmployeesModel employees){
        try
        {
            String sql = "delete from tb_funcionarios where id = ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, employees.getId());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "SUCESSO ao EXCLUIR Funcionario.");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "FALHA ao EXCLUIR Funcionario: " + e);
        }
    }
    
    
    public List<EmployeesModel> listEmployees(){
        try {
            List<EmployeesModel> list = new ArrayList<>();
            
            String sql = "select * from tb_funcionarios";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                EmployeesModel e = new EmployeesModel();
                
                e.setId(rs.getInt("id"));
                e.setName(rs.getString("nome"));
                e.setRg(rs.getString("rg"));
                e.setCPF(rs.getString("cpf"));
                e.setEmail(rs.getString("email"));
                e.setPassword(rs.getString("senha"));
                e.setCellphone(rs.getString("celular"));
                e.setAddress(rs.getString("endereco"));
                e.setCEP(rs.getString("cep"));
                e.setAcessLevel(rs.getString("nivel_acesso"));
                
                list.add(e);
            }
            
            return list;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "FALHA ao LISTAR Funcionarios: " + e);
            return null;
        }
    }
    
    
    public List<EmployeesModel> searchEmployeeByName(String employeeCPF){
        try {
            List<EmployeesModel> list = new ArrayList<>();
            
            String sql = "select * from tb_funcionarios where cpf like ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, employeeCPF);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                EmployeesModel e = new EmployeesModel();
                
                e.setId(rs.getInt("id"));
                e.setName(rs.getString("nome"));
                e.setRg(rs.getString("rg"));
                e.setCPF(rs.getString("cpf"));
                e.setEmail(rs.getString("email"));
                e.setPassword(rs.getString("senha"));
                e.setCellphone(rs.getString("celular"));
                e.setAddress(rs.getString("endereco"));
                e.setCEP(rs.getString("cep"));
                e.setAcessLevel(rs.getString("nivel_acesso"));
                
                list.add(e);
            }
            
            return list;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "FALHA ao LISTAR Funcionarios: " + e);
            return null;
        }
    }
    
    
    public EmployeesModel consultEmployeeByName(String employeeName){
        try{
            String sql = "select * from tb_funcionarios where nome = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, employeeName);
            
            ResultSet rs = stmt.executeQuery();
            
            EmployeesModel e = new EmployeesModel();
            if(rs.next()){
                
                e.setId(rs.getInt("id"));
                e.setName(rs.getString("nome"));
                e.setRg(rs.getString("rg"));
                e.setCPF(rs.getString("cpf"));
                e.setEmail(rs.getString("email"));
                e.setPassword(rs.getString("senha"));
                e.setCellphone(rs.getString("celular"));
                e.setAddress(rs.getString("endereco"));
                e.setCEP(rs.getString("cep"));
                e.setAcessLevel(rs.getString("nivel_acesso"));
            }
            return e;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "FALHA ao ENCONTRAR Funcionario: " + e);
            return null;
        }
    }
    
    public EmployeesModel TryLogin(String email, String password){
        EmployeesModel employeeLogged = null;
        
        try{
            String sql = "select * from tb_funcionarios where email = ? and senha = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, email);
            stmt.setString(2, password);
            
            ResultSet rs = stmt.executeQuery();
            
            if( rs.next() ){
                employeeLogged = new EmployeesModel();
                
                employeeLogged.setId(rs.getInt("id"));
                employeeLogged.setName(rs.getString("nome"));
                employeeLogged.setRg(rs.getString("rg"));
                employeeLogged.setCPF(rs.getString("cpf"));
                employeeLogged.setEmail(rs.getString("email"));
                employeeLogged.setPassword(rs.getString("senha"));
                employeeLogged.setCellphone(rs.getString("celular"));
                employeeLogged.setCEP(rs.getString("cep"));
                employeeLogged.setAddress(rs.getString("endereco"));
                employeeLogged.setAcessLevel(rs.getString("nivel_acesso"));
            }
            else{
                JOptionPane.showMessageDialog(null, "USUÁRIO NÃO ENCONTRADO");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar login: " + e);
        }
        
        return employeeLogged;
    }
}
