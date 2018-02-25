/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Fabian
 */
public class Bruch {
    private int Zaehler;
    private int Nenner;
    
    public Bruch(int v){
        Zaehler = v;
        Nenner = 1;
    }
    
    public Bruch(int z, int n){
        Zaehler = z;
        Nenner = n;
        Kuerzen();
    }
    
    public Bruch(Bruch orig){
        Zaehler = orig.Zaehler;
        Nenner = orig.Nenner;
    }
    
    private void Kuerzen(){
        int ggt = GGT(Zaehler, Nenner);
        Zaehler /= ggt;
        Nenner /= ggt;
    }
    
    @Override
    public String toString() {
       return Zaehler + "/" + Nenner; 
    }
    
    private static int GGT(int a, int b){
        if (a < 0) return GGT(-a, b);
        if (b < 0) return GGT(a, -b);
        if (a < b) return GGT(b, a);
        int c = a%b;
        if (c == 0) return b;
        return GGT(b, c);
    }
    
    public void Plus(Bruch b){
        int nennerGgt = GGT(b.Nenner, Nenner);
        int zaehlerNeu = Zaehler * b.Nenner / nennerGgt + b.Zaehler * Nenner / nennerGgt;
        int nennerNeu = Nenner / nennerGgt * b.Nenner;
        Zaehler = zaehlerNeu;
        Nenner = nennerNeu;
        Kuerzen();
    }
    
    public void Minus(Bruch b){
        Bruch c = new Bruch(-b.Zaehler, b.Nenner);
        Plus(c);
    }
    
    public void Mal(Bruch b){
        Zaehler *= b.Zaehler;
        Nenner *= b.Nenner;
        Kuerzen();
    }
    
    public void GeteiltDurch(Bruch b){
        Bruch c = new Bruch(b.Nenner, b.Zaehler);
        Mal(c);
    }
}
