
import java.io.InputStream;


public class ApplicantsProcessor {

    /**
     * @param csvStream input stream allowing to read the CSV input file
     * @return the processing output, in JSON format
     */
    public String processApplicants(InputStream csvStream) {

        Service service=new Service();
        return service.processApplicants(csvStream);
    }

}
