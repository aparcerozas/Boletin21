/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author aparcerozas
 */
public class Libreria {
    public void crearLibro(ArrayList<Libro> lista){
        String titulo = JOptionPane.showInputDialog("Título:");
        String autor = JOptionPane.showInputDialog("Autor:");
        String isbn = JOptionPane.showInputDialog("ISBN:");
        double prezo = Double.parseDouble(JOptionPane.showInputDialog("Prezo:"));
        int numUnid = Integer.parseInt(JOptionPane.showInputDialog("Número de unidades:"));
        Libro l = new Libro(titulo, autor, isbn, prezo, numUnid);
        lista.add(l);
    }
    
    public void engadirLibros(ArrayList<Libro> lista){
        String isbn = JOptionPane.showInputDialog("Introduzca el ISBN del libro:");
        for(Libro l : lista){
            if(isbn.equalsIgnoreCase(l.getISBN())){
                l.setNumUnid(l.getNumUnid()+Integer.parseInt(JOptionPane.showInputDialog("Introduzca el número de unidades a añadir:")));
            }
        }
    }
    
    public void venderLibros(ArrayList<Libro> lista){
        String isbn = JOptionPane.showInputDialog("Introduzca el ISBN del libro:");
        for(Libro l : lista){
            if(isbn.equalsIgnoreCase(l.getISBN())){
                int num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el número de unidades a vender:"));
                if(num>l.getNumUnid()){
                    l.setNumUnid(0);
                }
                else{
                    l.setNumUnid(l.getNumUnid()-num);
                }
            }
        }
    }
    
    public void ver(ArrayList<Libro> lista){
        for(Libro l : lista){
            l.toString();
            System.out.println("");
        }
    }
    
}
