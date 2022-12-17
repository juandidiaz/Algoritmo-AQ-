/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package elementos;

import java.util.HashSet;

/**
 *
 * @author Usuario
 */
public class Recubrimiento {

    private HashSet<Complejo> conjunto;

    public Recubrimiento() {
        conjunto = new HashSet<Complejo>();
    }

    public void addComplejo(Complejo c) {
        conjunto.add(c);
    }
    
    public HashSet<Complejo>getConjunto()
    {
        return this.conjunto;
    }
}
