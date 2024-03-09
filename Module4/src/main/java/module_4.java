import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

public class module_4 {

    private static final String DB_URL = "jdbc:derby:myDerbyDb;create=true";

    public static void dropAllTables() {
        // Connect to database
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {

            // Search all the user tables
            ResultSet rs = conn.getMetaData().getTables(null, "APP", null, new String[]{"TABLE"});

            while (rs.next()) {
                String tableName = rs.getString("TABLE_NAME");
                stmt.executeUpdate("DROP TABLE " + tableName);
                System.out.println("Dropped table " + tableName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void ensureTableExists() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            DatabaseMetaData dbm = conn.getMetaData();
            // Check if the table exists
            ResultSet tables = dbm.getTables(null, null, "MYTABLE", null);
            if (!tables.next()) {
                // If the table do not exist, create it
                stmt.execute("CREATE TABLE MYTABLE (ID VARCHAR(255), NAME VARCHAR(255), GRADE VARCHAR(255))");
                System.out.println("Created table MYTABLE.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void readCSVAndInsertData(String csvFilePath) {
        ensureTableExists(); // Make sure the table exist

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader("ID", "NAME", "GRADE").withSkipHeaderRecord());
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO MYTABLE (ID, NAME, GRADE) VALUES (?, ?, ?)")) {

            // Read the csv
            for (CSVRecord csvRecord : csvParser) {
                String id = csvRecord.get("ID");
                String name = csvRecord.get("NAME");
                String grade = csvRecord.get("GRADE");

                // Insert the data into the table
                pstmt.setString(1, id);
                pstmt.setString(2, name);
                pstmt.setString(3,grade);
                pstmt.executeUpdate();
            }
            System.out.println("Data inserted into MYTABLE from CSV file.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeTableToCSV(String csvFilePath) {
        try (Connection conn = DriverManager.getConnection(DB_URL);
            Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM MYTABLE");

            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(csvFilePath));
                 CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("ID", "NAME","GRADE"))) {

                while (rs.next()) {
                    String id = rs.getString("ID");
                    String name = rs.getString("NAME");
                    String grade = rs.getString("GRADE");
                    csvPrinter.printRecord(id, name, grade);
                }
                csvPrinter.flush();
            }

            System.out.println("Table MYTABLE has been written to " + csvFilePath);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void addItemToTable(){
        ensureTableExists();


    }

    public static void main(String[] args) {
        dropAllTables();
        String csvFilePath = "SchoolStudents.csv";
        readCSVAndInsertData(csvFilePath);

        writeTableToCSV("New.csv");
    }

}
