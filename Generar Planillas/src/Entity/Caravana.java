/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

public class Caravana {
    private String nrocaravana;
    private String caravana;

    public String getCaravana() {
       return caravana;
    }

    public void setCaravana(String caravana) {
        this.caravana = caravana;
    }


    public Caravana(String nrocaravana, String caravana) {
        this.nrocaravana = nrocaravana;
        this.caravana = caravana;
    }

    public Caravana() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getNrocaravana() {
        return nrocaravana;
    }

    public void setNrocaravana(String nrocaravana) {
        this.nrocaravana = nrocaravana;
    }
    
    
}
