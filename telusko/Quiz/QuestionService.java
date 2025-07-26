import java.util.Scanner;

public class QuestionService {
    private Question[] questions = new Question[4];
    private String[] userInputs = new String[4];
    Scanner input = new Scanner(System.in);

    public QuestionService() {
        this.questions[0] = new Question("Question-1", "option1-1", "option1-2", "option1-3", "option1-4", "1");
        this.questions[1] = new Question("Question-2", "option2-1", "option2-2", "option2-3", "option2-4", "2");
        this.questions[2] = new Question("Question-3", "option3-1", "option3-2", "option3-3", "option3-4", "3");
        this.questions[3] = new Question("Question-4", "option4-1", "option4-2", "option4-3", "option4-4", "4");
    }

    public void playQuiz() {
        int i = 0;
        for (Question question : questions) {
            System.out.println(question.getQuestion());
            System.out.println("1. " + question.getOption1());
            System.out.println("2. " + question.getOption2());
            System.out.println("3. " + question.getOption3());
            System.out.println("4. " + question.getOption4());
            userInputs[i] = input.nextLine();
            i++;
        }

        // for (String userInput : userInputs) {
        //     System.out.println(userInput);
        // }
    }

    public void printScore() {
        int score = 0;
        for (int i = 0; i < questions.length; i++) {
            String answer = questions[i].getAnswer();
            if (answer.equals(userInputs[i])) {
                score++;
            }
        }
        System.out.println("Correct guesses: " + score);
    }
}