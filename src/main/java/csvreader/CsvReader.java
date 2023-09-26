package csvreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public static void main(String[] args) {
        new CsvReader().readCSVFile();
    }

    public void readCSVFile() {
        String csvFile = "C:\\Users\\francois-nicolas.mar\\Documents\\Action.csv";
        String line;
        String csvSplitBy = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            List<String> allRows = new ArrayList<>();
            
            String[] headers = br.readLine().split(csvSplitBy);

            while ((line = br.readLine()) != null) {
                String[] values = line.split(csvSplitBy);
                List<String> currentRow = new ArrayList<>();

                for (int i = 0; i < headers.length && i < values.length; i++) {
                    currentRow.add(headers[i] + ":" + values[i]);
                }

                allRows.add("{" + String.join("; ", currentRow) + "}");
            }

            // Affichage pour tester
            System.out.println(String.join(", ", allRows));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

