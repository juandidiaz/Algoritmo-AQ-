/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aq_algorithm;

import elementos.Complejo;
import elementos.Selector;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Star_Algorithm {

    public static Set<Complejo> star_algorithm(String[] atributos, String[] semilla, HashSet<String[]> N) throws CloneNotSupportedException {
        Set<Complejo> E = new HashSet<Complejo>();
        Set<Complejo> L = new HashSet<Complejo>();
        Complejo aceptaTodo = new Complejo();
        L.add(aceptaTodo);

        Set<Selector> conjuntoSelectores = new HashSet<Selector>();
        for (int i = 0; i < atributos.length - 1; i++) {
            Selector s = new Selector(atributos[i], "=", semilla[i]);
            conjuntoSelectores.add(s);
        }

        while (L.size() > 0) {
            Set<Complejo> EPrima = new HashSet<Complejo>();

            Set<Complejo> aux = new HashSet<Complejo>();
            for (Selector s : conjuntoSelectores) {
                Complejo copia = null;

                for (Complejo c : L) {
                    if (!c.getConjunto().contains(s)) {
                        copia = new Complejo(c);
                        copia.addSelector(s);
                        aux.add(copia);
                    }
                }
            }

            for (Complejo c : aux) {
                EPrima.add(c);
            }
            if (E != null) {
                for (Complejo c : EPrima) {
                    if (E.contains(c)) {
                        EPrima.remove(c);
                    }
                }
            }

            Set<Complejo> aux2 = new HashSet<Complejo>();
            for (Complejo c : EPrima) {
                aux2.add(c);
            }

            for (Complejo c : aux2) {
                int contador = 0;
                for (String[] dato : N) {
                    if (c.acepta(atributos, dato)) {
                        contador++;
                    }
                }
                if (contador > 0) {

                } else {
                    E.add(c);
                    EPrima.remove(c);
                }

            }

            L = EPrima;

        }

        return E;
    }

}
