/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package elementos;

/**
 *
 * @author Usuario
 */
public class Selector {

    private String atributo;
    private String operador;
    private String valor;
    

    public Selector(String atributo, String operador, String valor) {
        this.atributo = atributo;
        this.operador = operador;
        this.valor = valor;
    }
    
    @Override
    public String toString(){
       String s="";
       s=atributo+operador+valor;
       return s;
    }
    
    public String getAtributo()
    {
        return this.atributo;
    }
    
    public String getOperador()
    {
        return this.operador;
    }
    
    public String getValor()
    {
        return this.getValor();
    }
    
    public boolean acepta(String atr, String val)
    {
        if(this.atributo.equals(atr))
        {
            if(this.valor.equals(val))
                return true;
        }
        
        return false;
    }

}
