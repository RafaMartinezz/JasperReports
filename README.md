# Application for annual order reports

This Java project generates reports of orders by city for a specified year. It connects to a MySQL database, executes SQL queries, and utilizes the JasperReports library to create and open a PDF report. This application is designed as an educational exercise on using Java, MySQL, JasperReports, and the Java Swing framework.

## Features

- Connects to a MySQL database using JDBC
- Queries orders and groups them by city for a specified year
- Generates a PDF report using JasperReports
- Opens the generated report automatically on the desktop

## Requirements

- Java 17 or later
- MySQL database server
- Maven for dependency management
- JasperReports 6.21.0
- JasperSoft Studio (optional, for designing reports)

## Usage

1. Run the `Aplicacionud5` main class:
   - This will prompt the application to connect to the MySQL database and generate the PDF report.

2. Enter the target year when prompted:
   - The application will generate a report that includes all orders grouped by city for the specified year.

3. View the report:
   - The generated PDF report, `informe.pdf`, will automatically open on your desktop.

## Project Structure

- `Aplicacionud5`: Main class that initializes the report generation process.
- `PedidosAnio`: Core class responsible for database connection, query execution, and PDF report generation using JasperReports.
- `PedidosCiudadParametro.jasper`: JasperReports template defining the report layout and structure, located in `src/main/java/com/mycompany/aplicacionud5`.

## Dependencies

This project includes the following dependencies, managed via Maven:
- `mysql-connector-j`: JDBC driver for MySQL connectivity.
- `jasperreports`: Main JasperReports library for creating PDF reports.
- Additional JasperReports libraries for enhanced functionality:
  - `jasperreports-annotation-processors`
  - `jasperreports-fonts`
  - `jasperreports-chart-themes`
  - `jasperreports-custom-visualization`

## Notes

- **Database configuration**: The connection details in `PedidosAnio` are currently hard-coded. To make the project more flexible, consider using environment variables or configuration files for database settings.
- **Report template**: The JasperReports template (`PedidosCiudadParametro.jasper`) can be modified in JasperSoft Studio if you need to change the layout or data fields in the report.