/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

public class Caravana {
    private String nrocaravana;
    private String caravana;
    private String titular;
    private String cuit;
    private String establecimiento;
    private String renspa;
    private String tipocopia;
    private String cuig;
    private int nHoja;

    public String getCaravana() {
       return caravana;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(String establecimiento) {
        this.establecimiento = establecimiento;
    }

    public String getRenspa() {
        return renspa;
    }

    public void setRenspa(String renspa) {
        this.renspa = renspa;
    }

    public String getTipocopia() {
        return tipocopia;
    }

    public void setTipocopia(String tipocopia) {
        this.tipocopia = tipocopia;
    }

    public String getCuig() {
        return cuig;
    }

    public void setCuig(String cuig) {
        this.cuig = cuig;
    }

    public int getnHoja() {
        return nHoja;
    }

    public void setnHoja(int nHoja) {
        this.nHoja = nHoja;
    }

    public void setCaravana(String caravana) {
        this.caravana = caravana;
    }


    public Caravana(String nrocaravana, String caravana) {
        this.nrocaravana = nrocaravana;
        this.caravana = caravana;
    }

    public Caravana() {
        
    }

    public String getNrocaravana() {
        return nrocaravana;
    }

    public void setNrocaravana(String nrocaravana) {
        this.nrocaravana = nrocaravana;
    }
    
    
}
