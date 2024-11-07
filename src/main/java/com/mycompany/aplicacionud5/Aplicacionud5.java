/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.aplicacionud5;

/**
 * The Aplicacionud5 class serves as the main entry point for running the
 * PedidosAnio report generation. It creates an instance of PedidosAnio and
 * generates an annual report for the specified year.
 * 
 * This application demonstrates how to integrate Java with JasperReports
 * to generate and view reports in PDF format.
 * 
 * @author rafa
 */
public class Aplicacionud5 {

    /**
     * Main method to execute the application.
     * 
     * Sets the year parameter to 2019 and generates a report for that year.
     * This value can be adjusted to generate reports for different years.
     * 
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Create an instance of PedidosAnio to generate the report
        PedidosAnio informe = new PedidosAnio();

        // Year to be passed as a parameter to the report
        int anio = 2019;

        // Execute the report generation with the specified year
        informe.ejecutar(anio);
    }
}
