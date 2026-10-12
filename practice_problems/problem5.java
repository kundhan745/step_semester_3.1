import java.util.Arrays;

class Candidate implements Comparable<Candidate> {

    private String name;
    private double cgpa;
    private int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    private double compositeScore() {
        return cgpa * 10 + codingScore;
    }

    @Override
    public int compareTo(Candidate other) {
        return Double.compare(
                other.compositeScore(),
                this.compositeScore()
        );
    }

    static String shortlistAndRank(Candidate[] candidates) {
        Candidate[] shortlisted = new Candidate[candidates.length];
        int count = 0;

        for (int i = 0; i < candidates.length; i++) {
            if (isEligible(candidates[i].cgpa)
                    || isEligible(candidates[i].cgpa,
                    candidates[i].codingScore)) {
                shortlisted[count] = candidates[i];
                count++;
            }
        }

        shortlisted = Arrays.copyOf(shortlisted, count);
        Arrays.sort(shortlisted);

        String result = "";

        for (int i = 0; i < shortlisted.length; i++) {
            if (i > 0) {
                result = result + " | ";
            }

            result = result + (i + 1) + ". "
                    + shortlisted[i].name + " ("
                    + shortlisted[i].compositeScore() + ")";
        }

        return result;
    }
}

public class problem5 {

    public static void main(String[] args) {
        Candidate[] candidates = {
                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.0, 90),
                new Candidate("Karan", 7.5, 20)
        };

        System.out.println(Candidate.shortlistAndRank(candidates));
    }
}