import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
class FileIOClass {
    public static void main(String[] args) {
        String personFile = "person.txt";
        String employeeFile = "employee.txt";
        String clientFile = "client.txt";
        String outputFile = "output.txt";
        try {
            // Read data form file person.txt
            String personData = readFile(personFile);

            // Read data from file employee.txt
            String employeeData = readFile(employeeFile);

            // Read data from file client.txt
            String clientData = readFile(clientFile);

            // create the output
            StringBuilder outputData = new StringBuilder();
            outputData.append("Person:\n").append("-------------------\n").append(personData).append("\n")
                    .append("Employee:\n").append("-------------------\n").append(employeeData).append("\n")
                    .append("Client:\n").append("-------------------\n").append(clientData);

            // Write the output to output.txt
            writeFile(outputFile, outputData.toString());

        } catch (IOException e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
    
    // Handles to read the file
    private static String readFile(String filename) throws IOException {
        StringBuilder data = new StringBuilder();

        try (BufferedReader readData = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = readData.readLine()) != null) {
                data.append(line).append("\n");
            }
            
        }
        return data.toString();
       
    }

    // Handles to write in the file
    private static void writeFile(String filename, String content) throws IOException {
        try (BufferedWriter writeData = new BufferedWriter(new FileWriter(filename))) {
            writeData.write(content);
            System.out.println("Check the output in"+ filename);
            System.out.println("Output.txt file:\n"+ content);
        }
    }
}
