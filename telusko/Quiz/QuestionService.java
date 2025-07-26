public class QuestionService {
    private Question[] questions = new Question[4];

    public QuestionService() {
        this.questions[0] = new Question("Question-1", "option1-1", "option1-2", "option1-3", "option1-4", "answer-1");
        this.questions[1] = new Question("Question-2", "option2-1", "option2-2", "option2-3", "option2-4", "answer-2");
        this.questions[2] = new Question("Question-3", "option3-1", "option3-2", "option3-3", "option3-4", "answer-3");
        this.questions[3] = new Question("Question-4", "option4-1", "option4-2", "option4-3", "option4-4", "answer-4");
    }

    public void playQuiz() {
        for (Question question : questions) {
            System.out.println(question);
        }
    }
}