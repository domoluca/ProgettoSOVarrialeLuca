/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package progettosovarrialeluca;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;


/**
 *
 * @author Luca
 */
public class ProgettoSOVarrialeLuca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numElfi = 0;
        int numRichieste=0;
        BufferedReader br;
        String _String;
        int _int;
       
        
         System.out.println("quanti regali vuoi creare? ");
         br = new BufferedReader(new InputStreamReader(System.in));
         try
      {
         _String = br.readLine();
         _int = Integer.parseInt(_String);
         numRichieste = _int;
      }catch (IOException e1)
      {
         System.out.println ("errore");
      }
      catch (NumberFormatException e2)
      {System.out.println("Errore di input da tastiera.");
       System.out.print("inserire un numero intero ");
      }
        Negozio negozio = new Negozio(numRichieste);
        BabboNatale babboNatale = new BabboNatale("santa claus", negozio);
        
       
        System.out.println("quanti elfi vuoi a disposizione? ");
         br = new BufferedReader(new InputStreamReader(System.in));
         try
      {
         _String = br.readLine();
         _int = Integer.parseInt(_String);
         numElfi = _int;
      }catch (IOException e1)
      {
         System.out.println ("errore di flusso.");
      }
      catch (NumberFormatException e2)
      {System.out.println("Errore di input da tastiera.");
       System.out.print("inserire un numero intero ");
      }
        Elfo elfi[] = new Elfo[numElfi];
        for(int i=0; i<numElfi; i++) {
            elfi[i] = new Elfo(negozio, "elfo " +i);
        }
        
     
      babboNatale.start();
      for(int i=0; i<numElfi; i++)
            elfi[i].start();
      try{
            for(int i=0; i<numElfi; i++)
                elfi[i].join();
            babboNatale.join();

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
