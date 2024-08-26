import java.time.LocalDateTime;

public class Applicant {
    private String name;
    private String email;
    private LocalDateTime dateTime;
    private Double initialScore;
    private Double finalScore;


    public Applicant(String name, String email, LocalDateTime dateTime, Double score, Double finalScore) {
        this.name = name;
        this.email = email;
        this.dateTime = dateTime;
        this.initialScore = score;
        this.finalScore = finalScore;
    }

    public String getName() {
        return name;
    }


    public String getEmail() {
        return email;
    }


    public LocalDateTime getDateTime() {
        return dateTime;
    }


    public Double getScore() {
        return initialScore;
    }


    public Double getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(Double finalScore) {
        if (finalScore > 10.0) {
            this.finalScore = 10.0;
        } else {
            this.finalScore = finalScore;
        }
    }
}
