/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author caiol
 */
public class ConnectionFactory {
    public Connection getConnection(){
        try
        {
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1/BDSILHUETTA","root","l2c8s0r8");
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
