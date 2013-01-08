/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package progettosovarrialeluca;
import java.util.*;
import java.util.concurrent.locks.*;
/**
 *
 * @author Luca
 */
public class Negozio{
    int richieste;
    int richiestaAttuale;
    int contatore = 0;
    boolean permesso = true;
    boolean dormi = true;
    Lock lockHash = null; 
    BabboNatale babboNatale;
    Stack stack;
    Hashtable<Integer, Integer> hash = null;
    
    public Negozio(int rc){
        this.richieste = rc;
       // this.babboNatale = babboNatale;
    }
    
    
    public int richiestaRegalo(){
     
    if(richieste > 0){
    richieste--;
    richiestaAttuale++;
    }
    
    return richiestaAttuale;
    }

    
    public void help(int pid){
    
    //this.hash = new Hashtable<Integer, Integer>();
    Stack stack = new Stack();
    Lock lockHash = new ReentrantLock();
    if (contatore < 3){
        lockHash.lock();
        //hash.put(contatore, pid);
        stack.push(pid);
        lockHash.unlock();
        contatore++;
        System.out.println("ho posizionato nella hashtable il regalo "+pid+
                        " contatore = "+(contatore));
    }
    else{
        permesso = false;
        dormi = false;
        }
}
    
    public void risolvi(){
   // this.hash = new Hashtable<Integer, Integer>();
    //Lock lockHash = new ReentrantLock();
    //permesso = false;
    //dormi = false;
    int chiave = 2;
    lockHash.lock();
    while (chiave >= 0){
        //hash.get(chiave);
        //stack.pop();
        //int pidAttuale = stack.pop();
        System.out.println("Babbo Natale aggiusta il regalo "+stack.pop());
        //this.hash.remove(chiave);
        try{BabboNatale.sleep(200);
        }catch(Exception e){
        System.out.println(e);}
        chiave--;   
        
    }
    this.lockHash.unlock();
    this.dormi = true;
    this.permesso = true;
    }
}
