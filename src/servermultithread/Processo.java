/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermultithread;

/**
 *
 * @author guagliumi.gianluca
 */
public class Processo extends Thread {
    private int n;
    
    public Processo(int n){
        this.n = n;
    }
    
    public int getN(){
        return n;
    }
}
