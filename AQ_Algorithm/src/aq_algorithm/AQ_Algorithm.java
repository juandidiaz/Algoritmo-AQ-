/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aq_algorithm;

import elementos.Complejo;
import elementos.Recubrimiento;
import elementos.Selector;
import datasets.ParserCSV;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Usuario
 */
public class AQ_Algorithm {

    /**
     * @param args the command line arguments
     */
    public static Recubrimiento algoritmoAQ(HashSet<String[]> P, HashSet<String[]> N,String[] atributos) throws CloneNotSupportedException {
        Recubrimiento conjuntoRecubrimiento = new Recubrimiento();

        Iterator<String[]>it=P.iterator();
        
        while(it.hasNext())
        {
            String[] semillaString=it.next();
            HashSet<Selector>conjuntoSelectores=new HashSet<Selector>();
            for(int i=0;i<atributos.length-1;i++)
            {
                Selector s=new Selector(atributos[i],"=",semillaString[i]);
                conjuntoSelectores.add(s);
            }
            
            Set<Complejo> C=Star_Algorithm.star_algorithm(atributos,semillaString,N);
            
            Iterator<Complejo>it2=C.iterator();
            Complejo agregar=it2.next();
            List<Integer>criterios=agregar.getCriterios(atributos, P);
            
            
            while(it2.hasNext())
            {
               Complejo c=it2.next();
               List<Integer>criterios2=c.getCriterios(atributos, P);
               
               if(criterios2.get(0)>criterios.get(0))
               {
                   criterios=criterios2;
                   agregar=c;
               }
               else if(criterios2.get(0)==criterios.get(0))
               {
                   if(criterios2.get(1)<criterios.get(1))
                   {
                       criterios=criterios2;
                       agregar=c;
                   }
               }
            }
            
            HashSet<String[]> nuevosPositivos=new HashSet<String[]>();
            for(String[] positivo: P)
            {
                nuevosPositivos.add(positivo);
            }
            
            for(String[] positivo:nuevosPositivos)
            {
                if(agregar.acepta(atributos, positivo))
                {
                    P.remove(positivo);
                }
            }
            it=P.iterator();
            conjuntoRecubrimiento.addComplejo(agregar);
        }
        return conjuntoRecubrimiento;
    }

}
