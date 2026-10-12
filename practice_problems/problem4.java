import java.util.*;

abstract class Question {
    String questionText;
    String correctAnswer;
    String studentAnswer;
    double points;

    Question(String questionText, String correctAnswer,
             String studentAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double evaluate();

    abstract String getType();
}

class MCQ extends Question {
    MCQ(String q, String correct, String student, double points) {
        super(q, correct, student, points);
    }

    double evaluate() {
        return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0;
    }

    String getType() {
        return "MCQ";
    }
}

class TrueFalseQuestion extends Question {
    TrueFalseQuestion(String q, String correct, String student, double points) {
        super(q, correct, student, points);
    }

    double evaluate() {
        return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0;
    }

    String getType() {
        return "TF";
    }
}

class EssayQuestion extends Question {
    EssayQuestion(String q, String correct, String student, double points) {
        super(q, correct, student, points);
    }

    double evaluate() {
        String[] keywords = correctAnswer.split(",");
        String answer = studentAnswer.toLowerCase();
        int matched = 0;

        for (String keyword : keywords) {
            if (answer.contains(keyword.trim().toLowerCase())) {
                matched++;
            }
        }

        if (matched >= 2) {
            return points * 0.75;
        } else if (matched == 1) {
            return points * 0.50;
        }

        return 0;
    }

    String getType() {
        return "ESSAY";
    }
}

public class problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        Question[] questions = new Question[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split("\"");

            String type = parts[0].trim();
            String questionText = parts[1];
            String correctAnswer = parts[3];
            String studentAnswer = parts[5];
            double points = Double.parseDouble(parts[6].trim());

            switch (type) {
                case "MCQ":
                    questions[i] = new MCQ(
                            questionText, correctAnswer, studentAnswer, points
                    );
                    break;
                case "TF":
                    questions[i] = new TrueFalseQuestion(
                            questionText, correctAnswer, studentAnswer, points
                    );
                    break;
                case "ESSAY":
                    questions[i] = new EssayQuestion(
                            questionText, correctAnswer, studentAnswer, points
                    );
                    break;
                default:
                    throw new IllegalArgumentException("Invalid question type");
            }
        }

        for (Question question : questions) {
            double score = question.evaluate();
            System.out.printf("%s: %.2f%n", question.getType(), score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}