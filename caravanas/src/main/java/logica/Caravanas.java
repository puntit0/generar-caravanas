package logica;

import igu.InterfaceApp;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author elias
 */
public class Caravanas {

    List<String> caravanas = new ArrayList<String>();
    List<String> nrocaravanas = new ArrayList<String>();

    public static void main(String[] args) {

        InterfaceApp pantalla = new InterfaceApp();
        pantalla.setVisible(true);
        pantalla.setLocationRelativeTo(null);

    }

    public void exportarReporteCaravanas() throws IOException {
        try {
            InputStream reporteCaravana = this.getClass().getResourceAsStream("caravanas/reporteCaravanas.jasper");

            if (reporteCaravana != null) {

            } else {
                System.out.println("hubo un error al intentar generar el reporte: ");
            }
        } catch (Exception e) {
            System.out.println("hubo un error al intentar generar el reporte: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //metodo donde una vez generado el numero de caravanas se le asigna el numero verificador, entonces la caravanas estaran terminadas
    public void listacaravanas(String cuig) {

        for (int i = 0; i < nrocaravanas.size(); i++) {
            String elemento = nrocaravanas.get(i);
            elemento = "" + cuig + "-" + elemento + "-" + generarDigitoV();
            caravanas.set(i, elemento);
        }
    }

    public void getNumeros() {

        for (int i = 0; i < caravanas.size(); i++) {
            nrocaravanas.add(caravanas.get(i).substring(5));
        }
    }

    private String generarDigitoV() {
        return "";
    }

    private void cargarCaravanas(String iniCaravana, int cantidad) {
        char letra1;
        char letra2;
        int numCaravana;
        
        /*verifica si el numero actual de la caravana es de 1 o 2 letras, segun 
        corresponda descomponera y asiganara los valores a las variables*/
        if (iniCaravana.length() < 5) {
            letra1 = iniCaravana.charAt(0);
            letra2 = ' ';
            numCaravana = Integer.parseInt(iniCaravana.substring(1));
        } else {
            letra1 = iniCaravana.charAt(0);
            letra2 = iniCaravana.charAt(1);
            numCaravana = Integer.parseInt(iniCaravana.substring(2));
        }
        
        //forma el numero de caravana con datos generados
        for (int c = 0; c < cantidad; c++) {
            String Caravana;
            if (letra2 == ' ') {
                Caravana = "" + letra1 + String.format("%03d", numCaravana);
            } else {
                Caravana = "" + letra1 + letra2 + String.format("%03d", numCaravana);
            }

            nrocaravanas.add(Caravana);

            numCaravana++;
            
            if (letra2 == ' ') {

                if (numCaravana > 999) {
                    numCaravana = 0;

                    if (letra1 == 'Z') {
                        letra1 = 'A';
                        letra2 = 'A';
                    } else {
                        letra1++;
                    }
                }
            } else {
                if (numCaravana > 999) {
                    numCaravana = 0;
                    if (letra2 == 'Z') {
                        letra2 = 'A';
                        if (letra1 == 'Z') {
                            letra1 = 'A';
                        } else {
                            letra1++;
                        }
                    } else {
                        letra2++;
                    }
                }
            }
        }

    }
}

