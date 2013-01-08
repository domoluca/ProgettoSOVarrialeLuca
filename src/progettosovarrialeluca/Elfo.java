/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package progettosovarrialeluca;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Luca
 */
public class Elfo extends Thread{
    Negozio negozio;
    private String nome;
    
    
    public Elfo(Negozio ne, String nome){
    super(nome);
    this.negozio = ne;
    this.nome = nome;
    
}
    /**
     *
     */
    
    @Override
    public void run(){
    System.out.println("sono l'elfo "+this.nome+" e sono partito");   
    while(negozio.richieste > 0){
        int possibileguasto = (int)(Math.random()*99);
        int pid = negozio.richiestaAttuale;
        //negozio.richiestaAttuale++;
        if(possibileguasto > 43){
        negozio.richiestaRegalo();
        System.out.println("sono l'elfo "+nome+" e servo la richiesta "+pid);
        int eseguo = (int) (Math.random() * 101) + 100;  
        try{         
            Thread.sleep(eseguo);
            }catch(Exception e){
            System.out.println(e);
            }
        }
        else{
            System.out.println("c'è stato un guasto con il regalo "+pid);
            negozio.richiestaAttuale++;
            negozio.richieste--;
            richiediAiuto(pid);    
        
        }
        }
}
    public void richiediAiuto(int pid){
    

        //negozio.richiestaAttuale++;
        
        while(negozio.permesso == true){
        
        this.negozio.help(pid);
            try {
                Thread.sleep(550);
            } catch (InterruptedException ex) {
                Logger.getLogger(Elfo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            try {
                Thread.sleep(200);
                richiediAiuto(pid);
            } catch (InterruptedException ex) {
                Logger.getLogger(Elfo.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }



}
