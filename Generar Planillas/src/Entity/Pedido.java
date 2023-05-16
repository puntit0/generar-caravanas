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
    private String titular;
    private String establecimiento;
    private String RENSPA;
    private String CUIT;
    private int hoja;
    private int cantidad;
    private String desde;
    private String hasta;//notuse
    private String impresor;//notuse
    private String copia; //notuse

    public Pedido() {
    }

    public Pedido(String CUIG, String titular, String establecimiento, String RENSPA, String CUIT, int hoja, int cantidad, String desde) {
        this.CUIG = CUIG;
        this.titular = titular;
        this.establecimiento = establecimiento;
        this.RENSPA = RENSPA;
        this.CUIT = CUIT;
        this.hoja = hoja;
        this.cantidad = cantidad;
        this.desde = desde;
    
    }

    public String getCopia() {
        return copia;
    }

    public void setCopia(String copia) {
        this.copia = copia;
    }

    public String getCUIG() {
        return CUIG;
    }

    public void setCUIG(String CUIG) {
        this.CUIG = CUIG;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
