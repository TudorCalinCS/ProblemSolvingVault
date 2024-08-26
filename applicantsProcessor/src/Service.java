import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Service {
    Validation validation = new Validation();
    LocalDateTime minDay = null;
    LocalDateTime maxDay = null;
    List<Applicant> applicants = new ArrayList<>();
    Set<String> emails = new HashSet<>();
    Double averageScore = 0.0;


    public List<String> processInput(InputStream csvStream) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(csvStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (Exception e) {
            return null;
        }
        return lines;
    }

    public String processApplicants(InputStream csvStream) {

        // Process the csvStream
        List<String> list = processInput(csvStream);

        // Validate and filter input lines
        validateLines(list);

        // Calculate average score
        averageScore();

        // Adjust scores if necessary
        adjustScores();

        // Sort applicants
        sortApplicants();

        // Get the last names of the top 3 applicants
        List<String> top3Applicants = new ArrayList<>();
        for (int i = 0; i < Math.min(3, applicants.size()); i++) {
            String name = applicants.get(i).getName();
            top3Applicants.add(name);
        }

        // Return the result
        return jsonObject(top3Applicants);

    }

    // Validate and filter input lines
    public void validateLines(List<String> list) {
        for (String line : list) {

            if (line.trim().isEmpty()) {
                continue;
            }

            String[] split = line.split(",");
            if (split.length < 4) {
                continue;
            }

            if (validation.validateName(split[0]) && validation.validateEmail(split[1]) && validation.validateDateTime(split[2]) && validation.validateScore(split[3])) {
                // Valid line
                String name = split[0];
                String email = split[1];

                // Check if applicant already exists
                if (!emails.contains(email)) {
                    emails.add(email);
                } else {
                    deleteExisting(applicants, email);
                    emails.add(email);
                }

                LocalDateTime dateTime = LocalDateTime.parse(split[2], DateTimeFormatter.ISO_LOCAL_DATE_TIME);

                if (minDay == null || dateTime.isBefore(minDay)) {
                    minDay = dateTime;
                }
                if (maxDay == null || dateTime.isAfter(maxDay)) {
                    maxDay = dateTime;
                }

                double score = Double.parseDouble(split[3]);

                String[] eachName = name.split(" ");

                Applicant applicant = new Applicant(eachName[eachName.length - 1], email, dateTime, score, score);
                applicants.add(applicant);

            }
        }
    }
    // Calculate the average score
    public void averageScore() {
        // Average score before adjustments
        applicants.sort(Comparator.comparing(Applicant::getScore));

        // Calculate the index where the top half starts
        double number = applicants.size() / 2;
        double startIndex = Math.ceil(number);

        // Iterate through the top half of applicants
        for (int i = (int) startIndex; i < applicants.size(); i++) {
            Applicant applicant = applicants.get(i);
            averageScore += applicant.getScore();
        }
        averageScore /= (applicants.size() - startIndex);
    }

    // Adjust scores if necessary
    public void adjustScores() {
        boolean sameDay = minDay.toLocalDate().isEqual(maxDay.toLocalDate());
        if (!sameDay) {
            // Adjust scores
            for (Applicant applicant : applicants) {
                if (applicant.getDateTime().toLocalDate().isEqual(minDay.toLocalDate())) {
                    // Apply 1 whole bonus point
                    applicant.setFinalScore(applicant.getScore() + 1);
                } else {
                    LocalDateTime halfDay = maxDay.withHour(12).withMinute(0).withSecond(0);
                    if (applicant.getDateTime().isAfter(halfDay)) {
                        // Apply 1 whole malus point
                        applicant.setFinalScore(applicant.getScore() - 1);
                    }
                }
            }
        }
    }

    // Delete existing applicants by email
    public void deleteExisting(List<Applicant> list, String email) {
        for (Applicant applicant : list) {
            if (Objects.equals(applicant.getEmail(), email)) {
                list.remove(applicant);
                return;
            }
        }
    }

    // Sort applicants accordingly
    public void sortApplicants() {
        // Sort applicants
        applicants.sort((a1, a2) -> {
            if (a1.getFinalScore() != a2.getFinalScore()) {
                return Double.compare(a2.getFinalScore(), a1.getFinalScore()); // Sort in descending order of final score
            } else if (a1.getScore() != a2.getScore()) {
                return Double.compare(a2.getScore(), a1.getScore()); // If final scores are equal, use initial score
            } else if (!a1.getDateTime().isEqual(a2.getDateTime())) {
                return a1.getDateTime().compareTo(a2.getDateTime()); // If initial scores are equal, use delivery date
            } else {
                return a1.getEmail().compareTo(a2.getEmail()); // If delivery dates are equal, use alphabetical order of email
            }
        });
    }

    // Construct JSON object
    public String jsonObject(List<String> top3Applicants) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");
        jsonBuilder.append("\"uniqueApplicants\": ").append(applicants.size()).append(", ");
        jsonBuilder.append("\"topApplicants\": [");
        for (int i = 0; i < top3Applicants.size(); i++) {
            jsonBuilder.append("\"").append(top3Applicants.get(i)).append("\"");
            if (i < top3Applicants.size() - 1) {
                jsonBuilder.append(", ");
            }
        }
        jsonBuilder.append("], ");
        jsonBuilder.append("\"averageScore\": ").append(String.format("%.2f", averageScore));
        jsonBuilder.append("}");

        return jsonBuilder.toString();
    }

}
