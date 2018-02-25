/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test; 

import Test.MyDouble;
import Test.DoubleSum;
import Test.DoubleProd;

/**
 *
 * @author Fabian
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //NetworkTest();
        Bruch b = new Bruch(-27, 48);
        System.out.println(b);
        Bruch a = new Bruch(5, 8);
        System.out.println(a);
        a.Plus(b);
        System.out.println(a);
        a.Mal(new Bruch(18));
        System.out.println(a);
        a.Minus(b);
        System.out.println(a);
        a.GeteiltDurch(b);
        System.out.println(a);
    }
    
        
    public static void NetworkTest() { 
        MyDouble a = new MyDouble("a", 2), b = new MyDouble("b", 3);
        DoubleSum sum = new DoubleSum("a+b");
        System.out.println(sum.getValue());
        sum.setConnection(a);
        System.out.println(sum.getValue());
        sum.setConnection(b);
        System.out.println(sum.getValue());
        MyDouble minOne = new MyDouble("minOne", -1);
        DoubleProd minB = new DoubleProd("-b");
        minB.setConnection(minOne);
        minB.setConnection(b);
        DoubleSum result = new DoubleSum("Final");
        result.setConnection(sum);
        result.setConnection(minB);
        System.out.println(result.getValue());
        a.setValue(7);
        b.setValue(4);
        System.out.println(result.getValue());
        boolean fehler = sum.setConnection(result);
        if (fehler) System.out.println("Konnte zirkel erzeugen");
    }
    
}
