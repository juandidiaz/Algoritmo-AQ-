/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aq_algorithm;

import elementos.Complejo;
import elementos.Recubrimiento;
import datasets.ParserCSV;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Usuario
 */
public class main {

    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el nombre del dataset");
        String nomDataset = sc.nextLine();
        ArrayList<String[]> dataset = ParserCSV.leeCSV(nomDataset);

        System.out.println("Introduzca el nombre de la clase positiva");
        String nombre = sc.nextLine();

        HashSet<String[]> P = new HashSet<String[]>();
        HashSet<String[]> N = new HashSet<String[]>();

        int tamanioEjemplo = dataset.get(0).length - 1;

        String[] atr = dataset.get(0);
        dataset.remove(0);
        for (String[] aux : dataset) {
            if (aux[tamanioEjemplo].equals(nombre)) {
                P.add(aux);
            } else {
                N.add(aux);
            }
        }

        Recubrimiento c = AQ_Algorithm.algoritmoAQ(P, N, atr);

        HashSet<Complejo> recub = c.getConjunto();

        if (recub.size() > 0) {
            for (Complejo comp : recub) {
                System.out.println("Si " + "( " + comp.toString() + " )" + " entonces Clase = " + nombre);
            }
        } else {
            System.out.println("No hay recubrimiento");
        }

    }
}
