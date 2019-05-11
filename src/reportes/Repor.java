package reportes;

import conection.Conexion;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Repor {


    public static void SimpleReport(Date fechaInicio,Date fechaFin,double total ) throws JRException {
        try {
            Conexion co = new Conexion();


            JasperPrint jasperPrint;
            java.io.File urlreporte = null;
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("fechaInicio",fechaInicio);
            params.put("fechaFIn",fechaFin);
            params.put("total",total);



            try {
                urlreporte = new java.io.File("src/reportes/Cherry.jasper");
            } catch (Exception ex) {
                System.out.println("No encuentro el archivo del reporte maestro." +ex);
            }
            if (urlreporte == null) {
                System.out.println("No encuentro el archivo del reporte maestro." );

            }




            jasperPrint = JasperFillManager.fillReport(urlreporte.getPath(),params,co.obtener() );

            JasperViewer visor=new JasperViewer(jasperPrint,false);
            visor.setTitle("Cajas de ahorro - GSF");
            visor.setVisible(true);


            // Compile jrxml file.

        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
        }

    }
    public static void SimpleReportHoras(Date fechaInicio,Date fechaFin ) throws JRException {
        try {
            Conexion co = new Conexion();


            JasperPrint jasperPrint;
            java.io.File urlreporte = null;
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("fechaInicio",fechaInicio);
            params.put("fechaFin",fechaFin);




            try {
                urlreporte = new java.io.File("src/reportes/totalHorasjrxml.jasper");
            } catch (Exception ex) {
                System.out.println("No encuentro el archivo del reporte maestro." +ex);
            }
            if (urlreporte == null) {
                System.out.println("No encuentro el archivo del reporte de horas ." );

            }




            jasperPrint = JasperFillManager.fillReport(urlreporte.getPath(),params,co.obtener() );

            JasperViewer visor=new JasperViewer(jasperPrint,false);
            visor.setTitle("COnstruccion- GSF");
            visor.setVisible(true);


            // Compile jrxml file.

        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
        }

    }


}
