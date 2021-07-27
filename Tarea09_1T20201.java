package deber9;

import java.util.*;

public class Tarea09_1T20201 {

    public static void main(String[] args) {
        ABB<Integer> arbol = new ABB();
        arbol.add(20);
        arbol.add(8);
        arbol.add(4);
        arbol.add(12);
        arbol.add(10);
        arbol.add(14);
        arbol.add(22);
        arbol.add(25);
        System.out.println(arbol.preOrden());
        ABB<Integer> espejo = arbol.espejo();
        System.out.println(espejo.preOrden());
        System.out.println(arbol.esEspejo(espejo));

        
        ABB<Integer> arbol2 = new ABB();
        arbol2.add(20);
        arbol2.add(8);
        arbol2.add(4);
        arbol2.add(12);
        arbol2.add(10);
        arbol2.add(14);
        arbol2.add(22);
        arbol2.add(25);
        //System.out.println(arbol2.preOrden());
        //System.out.println(arbol.esEspejo(arbol2));
        ABB<Integer> arbol3 = arbol2.espejo();
        System.out.println(arbol3.preOrden());
        System.out.println(arbol.esEspejo(arbol3));

    }
}
