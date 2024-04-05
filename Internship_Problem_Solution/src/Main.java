import java.io.FileInputStream;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        String csvFilePath = "src/example.csv";

        try (InputStream inputStream = new FileInputStream(csvFilePath)) {

            ApplicantsProcessor processor = new ApplicantsProcessor();

            String output = processor.processApplicants(inputStream);

            System.out.println("Output JSON:\n" + output);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
