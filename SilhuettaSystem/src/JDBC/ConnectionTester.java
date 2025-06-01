/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JDBC;

import javax.swing.JOptionPane;

/**
 *
 * @author caiol
 */
public class ConnectionTester 
{
    public static void main(String[]args){
        try{
            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null, "Conectado(a) com SUCESSO.");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Erro na conexão: " + e);
        }
    }
}
