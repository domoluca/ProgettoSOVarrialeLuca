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
    
    this.hash = new Hashtable<Integer, Integer>();
    Lock lockHash = new ReentrantLock();
    if (contatore < 3){
    lockHash.lock();
    hash.put(contatore, pid);
    lockHash.unlock();
    contatore++;
    System.out.println("ho posizionato nella hashtable il regalo "+pid+
                        " contatore = "+(contatore-1));
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
    while (chiave >= 0){
    this.lockHash.lock();
    this.hash.get(chiave);
    int pidAttuale = this.hash.get(chiave);
    System.out.println("Babbo Natale aggiusta il regalo "+this.hash.get(pidAttuale));
    this.hash.remove(chiave);
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