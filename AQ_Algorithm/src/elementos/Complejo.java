/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package elementos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Usuario
 */
public class Complejo {

    private Set<Selector> conjunto;

    public Complejo() {
        conjunto = new HashSet<Selector>();
    }
    
    @Override
    public String toString()
    {
        String s="";
        Iterator<Selector>it=conjunto.iterator();
        
        while(it.hasNext())
        {
            s=s+it.next().toString();
            if(it.hasNext())
                s=s+"^";
        }
        return s;
    }

    public Complejo(Complejo c) {
        this.conjunto = new HashSet<>(c.getConjunto());
    }

    public void addSelector(Selector s) {
        conjunto.add(s);
    }

    public Set<Selector> getConjunto() {
        return this.conjunto;
    }

    public boolean acepta(String[] atributos, String[] dato) {
        if (conjunto.size() == 0) {
            return true;
        } else {
            for (Selector s : conjunto) {
                for (int i = 0; i < dato.length - 1; i++) {
                    String atributo = atributos[i];
                    if (s.getAtributo().equals(atributo)) {
                        if (s.acepta(atributo, dato[i])) {
                            continue;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public List<Integer> getCriterios(String[] atributos, HashSet<String[]> P) {
        List<Integer> criterios = new ArrayList<Integer>();
        int contador = 0;
        for (String[] positivo : P) {
            if (this.acepta(atributos, positivo)) {
                contador++;
            }
        }
        criterios.add(contador);
        criterios.add(conjunto.size());
        return criterios;
    }

}
