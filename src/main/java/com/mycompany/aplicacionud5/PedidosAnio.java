package com.mycompany.aplicacionud5;

import java.awt.Desktop;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 * The PedidosAnio class connects to a MySQL database to generate and display
 * an annual report of orders using JasperReports. The report is generated
 * based on a year parameter, exported to PDF, and automatically opened.
 * 
 * This class requires the JasperReports library and a MySQL database with the
 * appropriate structure and data.
 * 
 * Usage example:
 * 
 * <pre>
 * {@code
 * PedidosAnio pedidos = new PedidosAnio();
 * pedidos.ejecutar(2022);
 * }
 * </pre>
 * 
 * @author rafa
 */
public class PedidosAnio {

    // Connection to the database
    public static Connection conexion = null;

    // Database connection details
    String baseDatos = "jdbc:mysql://localhost/fabrica";
    String usuario = "root"; // Replace with your MySQL username
    String clave = "coupecabrio1"; // Replace with your MySQL password

    /**
     * Constructor for PedidosAnio.
     * 
     * Attempts to establish a connection to the specified MySQL database
     * using the provided credentials. If the connection fails, the program
     * exits with an error message.
     */
    public PedidosAnio() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            // Establish the database connection
            conexion = DriverManager.getConnection(baseDatos, usuario, clave);

        } catch (ClassNotFoundException cnfe) {
            // Handle error if JDBC driver is not found
            System.err.println("Failed to load JDBC Driver");
            System.exit(1);
        } catch (SQLException sqle) {
            // Handle error if the database connection fails
            System.err.println("Could not connect to database");
            System.exit(1);
        } catch (java.lang.InstantiationException sqlex) {
            // Handle error if instantiation fails
            System.err.println("Unable to connect");
            System.exit(1);
        } catch (Exception ex) {
            // Handle any other exceptions
            System.err.println("Unable to connect");
            System.exit(1);
        }
    }

    /**
     * Generates and displays an annual report of orders for the specified year.
     * 
     * This method uses JasperReports to fill a report template with data
     * based on the given year, exports the filled report to a PDF file, and
     * opens the generated PDF.
     * 
     * @param año The year for which to generate the report.
     */
    public void ejecutar(int año) {
        // Path to the JasperReports template (relative to the project)
        String archivojasper = "src/main/java/com/mycompany/aplicacionud5/PedidosCiudadParametro.jasper";

        try {
            // Load the report parameters into a HashMap
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("año", año); // Set the year parameter

            // Generate the report in memory using JasperReports
            JasperPrint print = JasperFillManager.fillReport(archivojasper, parametros, conexion);

            // Export the in-memory report to a PDF file
            JasperExportManager.exportReportToPdfFile(print, "informe.pdf");

            // Open the generated PDF file using the default PDF viewer
            File path = new File("informe.pdf");
            Desktop.getDesktop().open(path);

        } catch (Exception e) {
            // Display any errors that occur during report generation or export
            JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
}
