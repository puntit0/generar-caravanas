/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author elias
 */
public class Pedido {
    private String CUIG;
    private String sobrecuig;
    private String establecimiento;
    private String RENSPA;
    private String CUIT;
    private int hoja;
    private String desde;
    private String hasta;
    private String impresor;

    public Pedido() {
    }

    public Pedido(String CUIG, String sobrecuig, String establecimiento, String RENSPA, String CUIT, int hoja, String desde, String hasta, String impresor) {
        this.CUIG = CUIG;
        this.sobrecuig = sobrecuig;
        this.establecimiento = establecimiento;
        this.RENSPA = RENSPA;
        this.CUIT = CUIT;
        this.hoja = hoja;
        this.desde = desde;
        this.hasta = hasta;
        this.impresor = impresor;
    }

    public String getCUIG() {
        return CUIG;
    }

    public void setCUIG(String CUIG) {
        this.CUIG = CUIG;
    }

    public String getSobrecuig() {
        return sobrecuig;
    }

    public void setSobrecuig(String sobrecuig) {
        this.sobrecuig = sobrecuig;
    }

    public String getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(String establecimiento) {
        this.establecimiento = establecimiento;
    }

    public String getRENSPA() {
        return RENSPA;
    }

    public void setRENSPA(String RENSPA) {
        this.RENSPA = RENSPA;
    }

    public String getCUIT() {
        return CUIT;
    }

    public void setCUIT(String CUIT) {
        this.CUIT = CUIT;
    }

    public int getHoja() {
        return hoja;
    }

    public void setHoja(int hoja) {
        this.hoja = hoja;
    }

    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }

    public String getImpresor() {
        return impresor;
    }

    public void setImpresor(String impresor) {
        this.impresor = impresor;
    }
    
    
}
