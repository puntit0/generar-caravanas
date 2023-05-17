/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package generar_planillas;

import Entity.Pedido;
import GUI.aplicacion;
import entity.Caravana;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author elias
 */
public class GenerarPlanillas {

    private List<String> caravanas = new ArrayList<>();
    private ArrayList<String> secuencias = new ArrayList<>();
    private Object[][] abecedario;
    private final int[] multiplos = {7, 6, 5, 4, 3, 2, 7, 6, 5, 4, 3, 2, 7, 6, 5, 4, 3, 2};
    private int caravanasPorPlanilla = 25;
    private int caravanasEnPlanillaActual = 0;
    private int nroPlanilla = 1;

    public static void main(String[] args) {
        GenerarPlanillas planillas = new GenerarPlanillas();
        GenerarPlanillas.carpeta();

        aplicacion interfaz = new aplicacion();
        interfaz.setTitle("generar planillas");
        interfaz.setLocationRelativeTo(null);
        interfaz.setVisible(true);

        //planillas.prueba();
    }

    public void generar(Pedido pedido) {
        ArrayList<Caravana> secuencia = new ArrayList<>();
        nroPlanilla = pedido.getHoja();
        for (int i = 0; i < caravanas.size(); i++) {
            Caravana numcaravana = new Caravana(caravanas.get(i), secuencias.get(i));
            if (secuencia.isEmpty()) {
                numcaravana.setTitular(pedido.getTitular());
                numcaravana.setCuit(pedido.getCUIT());
                numcaravana.setEstablecimiento(pedido.getEstablecimiento());
                numcaravana.setRenspa(pedido.getRENSPA());
                numcaravana.setCuig(pedido.getCUIG());
                numcaravana.setnHoja(nroPlanilla);

            }
            secuencia.add(numcaravana);
            caravanasEnPlanillaActual++;

            if (caravanasEnPlanillaActual == caravanasPorPlanilla) {
                generarPlanilla(secuencia);
                secuencia.clear();
                caravanasEnPlanillaActual = 0;
                nroPlanilla++;
            }
        }

        if (!secuencia.isEmpty()) {
            generarPlanilla(secuencia);
        }
    }

    private void generarPlanilla(ArrayList<Caravana> secuencia) {
        try {
            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/reports/report1.jasper"));

            if (report != null) {
                Caravana cara = secuencia.get(0);
                System.out.println("copia or: " + cara.getTipocopia());
                String nombrePlanilla = cara.getCuig() + "_" + "planilla" + nroPlanilla;
                for (int i = 0; i < 3; i++) {
                    String nombreArchivo = "C:/documentos/" + nombrePlanilla + "_" + getNombreRepeticion(i) + ".pdf";

                    cara.setTipocopia(getNombreRepeticion(i));
                    secuencia.set(24, cara);
                    Caravana caras = secuencia.get(24);
                    System.out.println("copia seq: " + caras.getTipocopia());

                    JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(secuencia);

                    JasperPrint jprint = JasperFillManager.fillReport(report, null, ds);

                    //JasperViewer visualiza = new JasperViewer(jprint, false);
                    //visualiza.setTitle("reporte caravanas");
                    //visualiza.setVisible(true);
                    JasperExportManager.exportReportToPdfFile(jprint, nombreArchivo);
                }
            }
        } catch (JRException ex) {
            System.out.println("hubo un error al intentar generar el reporte: " + ex.getMessage());
            ex.getMessage();
        }
    }

    private String getNombreRepeticion(int repeticion) {
        switch (repeticion) {
            case 0:
                return "ORIGINAL";
            case 1:
                return "DUPLICADO";
            case 2:
                return "TRIPLICADO";
            default:
                return "";
        }
    }

    public void prueba(Pedido pedido) {
        //String inicaravanas = "Z999";
        //String cuig = "PW209";
        //int cantidad = 75;
        generarCa(pedido.getDesde(), pedido.getCantidad(), pedido.getCUIG());
        generar(pedido);

    }

    public void generarCa(String desde, int cant, String cuig) {
        //ArrayList<String> secuencias = new ArrayList<>();
        secuencias.add(desde);

        for (int i = 1; i < cant; i++) {
            // Obtener la última secuencia generada
            String lastSequence = secuencias.get(secuencias.size() - 1);

            // Convertir la última secuencia en una matriz de caracteres
            char[] chars = lastSequence.toCharArray();

            // Incrementar el último dígito numérico
            int lastIndex = chars.length - 1;
            while (lastIndex >= 0 && Character.isDigit(chars[lastIndex])) {
                if (chars[lastIndex] == '9') {
                    chars[lastIndex] = '0';
                    lastIndex--;
                } else {
                    chars[lastIndex]++;
                    break;
                }
            }

            // Verificar si se necesita agregar una nueva letra a la izquierda
            if (lastIndex >= 0 && Character.isLetter(chars[lastIndex])) {
                char currentLetter = chars[lastIndex];
                if (currentLetter == 'Z') {
                    // Agregar una nueva letra a la izquierda
                    int firstIndex = lastIndex - 1;
                    if (firstIndex >= 0 && Character.isLetter(chars[firstIndex])) {
                        char firstLetter = chars[firstIndex];
                        if (firstLetter == 'Z') {
                            // Si la primera letra es 'Z', reiniciar toda la secuencia a "AA00"
                            for (int j = 0; j < chars.length; j++) {
                                chars[j] = (j < 2) ? 'A' : '0';
                            }
                        } else {
                            // Aumentar la primera letra y reiniciar la segunda letra y los dígitos a "0"
                            chars[firstIndex]++;
                            chars[lastIndex] = 'A';
                            for (int j = lastIndex + 1; j < chars.length; j++) {
                                chars[j] = '0';
                            }
                        }
                    } else {
                        // Si la primera letra no es válida, reiniciar toda la secuencia a "AA00"
                        for (int j = 0; j < chars.length; j++) {
                            chars[j] = (j < 2) ? 'A' : '0';
                        }
                    }
                } else {
                    chars[lastIndex]++;
                    // Establecer los dígitos a la derecha en "0"
                    for (int j = lastIndex + 1; j < chars.length; j++) {
                        chars[j] = '0';
                    }
                }
            }

            // Verificar si la última secuencia generada es "ZZ99"
            if (lastSequence.equals("ZZ99")) {
                secuencias.add("AAA0");
            } else {
                // Convertir la matriz de caracteres en una secuencia y agregarla al ArrayList
                String newSequence = new String(chars);
                secuencias.add(newSequence);
            }
        }

        // Imprimir las secuencias generadas
        /*for (String s : secuencias) {
            System.out.println(s);
        }*/
        digitoV(cuig);
    }

    private void digitoV(String cuig) {
        String caravanaC = "";
        for (String seq : secuencias) {
            String Caravana = cuig + seq;
            String numsSeq = "";
            String digitoV = "";

            int suma = 0;
            int resto;

            //A) Convertir las letras a números según la tabla
            for (int i = 0; i < Caravana.length(); i++) {
                char c = Caravana.charAt(i);
                if (Character.isLetter(c)) {
                    if (!(c < 'A' || c > 'Z')) {
                        numsSeq += Equivalente(c);
                    }
                } else {
                    numsSeq += c;
                }
            }
            //B) Se multiplican los términos por su correspondiente número de la secuencia
            //y se suman los resultados de estas multiplicaiones
            for (int i = numsSeq.length() - 1; i >= 0; i--) {
                int a = Character.getNumericValue(numsSeq.charAt(i));
                suma += multiplos[i] * a;

            }
            //la suma se divide popr 11 y se obtiene el resto
            resto = suma % 11;

            /*E) Si el RESTO es cero, el dígito verificador es cero.
            Si el RESTO es uno, el dígito verificador es uno.
            Si el RESTO no es ni cero ni uno, el dígito verificador es 11 menos el resto*/
            if (resto == 0 || resto == 1) {
                digitoV = String.valueOf(resto);
            } else {
                digitoV = String.valueOf(11 - resto);
            }

            //construyo la caravana final
            caravanaC = "" + cuig + "-" + seq + "-" + digitoV;
            caravanas.add(caravanaC);
        }

        for (String s : caravanas) {
            System.out.println(s);
        }
    }

    private String Equivalente(char letra) {
        String valor = "";

        abecedario = new Object[][]{
            {'A', 65},
            {'B', 66},
            {'C', 67},
            {'D', 68},
            {'E', 69},
            {'F', 70},
            {'G', 71},
            {'H', 72},
            {'I', 73},
            {'J', 74},
            {'K', 75},
            {'L', 76},
            {'M', 77},
            {'N', 78},
            {'O', 79},
            {'P', 80},
            {'Q', 81},
            {'R', 82},
            {'S', 83},
            {'T', 84},
            {'U', 85},
            {'V', 86},
            {'W', 87},
            {'X', 88},
            {'Y', 89},
            {'Z', 90}
        };

        for (int i = 0; i < abecedario.length; i++) {
            if (letra == (char) abecedario[i][0]) {
                valor = String.valueOf(abecedario[i][1]);
            }
        }

        return valor;
    }

    private static void carpeta() {
        String ruta = "C:/documentos";
        File carpeta = new File(ruta);
        if (carpeta.exists() && carpeta.isDirectory()) {
            System.out.println("La carpeta existe");
        } else {
            if (carpeta.mkdir()) {
                System.out.println("La carpeta ha sido creada");
            } else {
                System.out.println("No se ha podido crear la carpeta");
            }
        }
    }
}
