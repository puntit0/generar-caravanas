
package entity;

public class Pedido {
    private String cuig, nameEst, desdeCaravana, impresor;
    private int renspa, cuit, hoja, cantidad;

    public Pedido(String cuig, String nameEst, String desdeCaravana, String impresor, int renspa, int cuit, int hoja, int cantidad) {
        this.cuig = cuig;
        this.nameEst = nameEst;
        this.desdeCaravana = desdeCaravana;
        this.impresor = impresor;
        this.renspa = renspa;
        this.cuit = cuit;
        this.hoja = hoja;
        this.cantidad = cantidad;
    }

    public String getCuig() {
        return cuig;
    }

    public void setCuig(String cuig) {
        this.cuig = cuig;
    }

    public String getNameEst() {
        return nameEst;
    }

    public void setNameEst(String nameEst) {
        this.nameEst = nameEst;
    }

    public String getDesdeCaravana() {
        return desdeCaravana;
    }

    public void setDesdeCaravana(String desdeCaravana) {
        this.desdeCaravana = desdeCaravana;
    }

    public String getImpresor() {
        return impresor;
    }

    public void setImpresor(String impresor) {
        this.impresor = impresor;
    }

    public int getRenspa() {
        return renspa;
    }

    public void setRenspa(int renspa) {
        this.renspa = renspa;
    }

    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
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
    
    
        
}
