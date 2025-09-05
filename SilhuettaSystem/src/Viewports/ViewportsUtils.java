/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Viewports;

import Models.AddressModel;
import WebServices.WebServiceCep;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author caiol
 */
public class ViewportsUtils {

    public void clearPanel(JPanel containerPanel) {
        Component components[] = containerPanel.getComponents();

        for (Component component : components) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText(null);
            }
        }
    }

    public AddressModel fillAddressByCep(String CEP) {
        WebServiceCep webServiceCep = WebServiceCep.searchCep(CEP);

        System.out.println("Endereço encontrado: " + webServiceCep.getLogradouroFull() + ", " + webServiceCep.getBairro() + " - " + webServiceCep.getCidade());

        AddressModel client = new AddressModel();

        if (webServiceCep.wasSuccessful()) {
            client.setAddress(webServiceCep.getLogradouroFull() + ", " + webServiceCep.getBairro() + " - " + webServiceCep.getCidade());
        } else {
            client.setAddress("");
        }
        return client;
    }

    public String getTwoFirstWords(String text) {
        String[] parts = text.trim().split("\\s+"); 
        String twoFirstWords;
        
        if (parts.length >= 2) {
            twoFirstWords = parts[0] + " " + parts[1];
        } else {
            twoFirstWords = parts[0];
        }
        return twoFirstWords;
    }
}
