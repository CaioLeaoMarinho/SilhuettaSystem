/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import javax.swing.text.*;

/**
 *
 * @author caiol
 */
public class NumberFilterDocument extends DocumentFilter {
    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) 
        throws BadLocationException {
        if (string != null && string.matches("[0-9]+")) {
            super.insertString(fb, offset, string, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) 
        throws BadLocationException {
        if (text != null && text.matches("[0-9]+")) {
            super.replace(fb, offset, length, text, attrs);
        }
    }
}
