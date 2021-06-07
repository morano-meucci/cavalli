/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maincorsecavalli;

/**
 *
 * @author 39334
 */
public class CavalloInGara implements Runnable{
    Cavallo cavallo;
    GaraCavalli campo;
    int velocità;
    Thread t;
    int conta;
    int posizione;
    
    public CavalloInGara(Cavallo c,GaraCavalli g){
    cavallo=c;
    campo=g;
    conta=0;
    velocità=2;
    t=new Thread(this);
    t.start();
    posizione=0;
    }
    public void run(){
    int dimImmagine=79;
    int dimPista=960;
    while((cavallo.getCordx()+dimImmagine)<dimPista){
    if((conta%10)==0)
        velocità=(int)(Math.random()*4+1);
    cavallo.setCordx(cavallo.getCordx()+velocità);
    conta++;
    try{Thread.sleep(75);}
    catch(Exception e){}
    campo.repaint();
    }
    posizione=campo.getPosizione();
    campo.controllaArrivi();
    }
}
