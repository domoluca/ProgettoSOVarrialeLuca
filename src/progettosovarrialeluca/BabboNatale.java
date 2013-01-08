/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package progettosovarrialeluca;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luca
 */
public class BabboNatale extends Thread{
    Negozio negozio;
    
    public BabboNatale(String nome, Negozio negozio){
        super(nome);
        this.negozio = negozio;
    }
    
    public void run(){
    System.out.println("sono babbo natale e sono partito");
    while (negozio.dormi == true){
        System.out.println("sono babbo natale e sto dormendo");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(BabboNatale.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
    }
    System.out.println("Babbo natale si è svegliato");
    negozio.risolvi();
    
    
    }
    
    
    
}
