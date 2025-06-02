/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Viewports;

import Models.EmployeesModel;
import WebServices.WebServiceCep;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author caiol
 */
public class ViewportsUtils {
    public void clearPanel(JPanel containerPanel){
        Component components[] = containerPanel.getComponents();
        
        for(Component component : components){
            if (component instanceof JTextField){
                ((JTextField)component).setText(null);
            }
        }
    }
}
