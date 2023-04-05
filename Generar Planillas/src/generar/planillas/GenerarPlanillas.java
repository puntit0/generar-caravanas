/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package generar.planillas;

import entity.Caravana;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author elias
 */
public class GenerarPlanillas {

    List<String> caravanas = new ArrayList<>();
    List<String> nroCaravanas = new ArrayList<>();
    int nroHoja = 1;

    public static void main(String[] args) {
        GenerarPlanillas planillas = new GenerarPlanillas();
        planillas.prueba();
    }

    public void generar() {
        ArrayList<Caravana> secuencia = new ArrayList<>();
        for (int i = 0; i < nroCaravanas.size(); i++) {
            Caravana numcaravana = new Caravana(nroCaravanas.get(i));

            secuencia.add(numcaravana);
        }

        try {

            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/reports/report1.jasper"));

            if (report != null) {
                /*for (int i = 0; i < 3; i++) {
                    JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(secuencia);
                    JasperPrint jprint = JasperFillManager.fillReport(report, null, ds);

                    //JasperViewer view = new JasperViewer(jprint, false);
                    //view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    //view.setVisible(true);
                    JasperViewer visualiza = new JasperViewer(jprint, false);
                    visualiza.setTitle("reporte caravanas");
                    visualiza.setVisible(true);
                }*/
                JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(secuencia);
                JasperPrint jprint = JasperFillManager.fillReport(report, null, ds);

                JasperViewer visualiza = new JasperViewer(jprint, false);
                visualiza.setTitle("reporte caravanas");
                visualiza.setVisible(true);
            }

        } catch (JRException ex) {
            System.out.println("hubo un error al intentar generar el reporte: " + ex.getMessage());
            ex.getMessage();
        }

    }

    public void cargarCaravanas(String iniCaravana, int cantidad) {
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

            nroCaravanas.add(Caravana);

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

    public void prueba() {
        String inicaravanas = "AB250";
        int cantidad = 25;
        cargarCaravanas(inicaravanas, cantidad);
        generar();
    }

}
