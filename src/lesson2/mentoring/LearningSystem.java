package lesson2.mentoring;

/**
 * Created by Saak_Akopov on 5/19/2017.
 */
public class LearningSystem {
    public static void main(String[] args) {
        Student Student1 = new Student();
        Tutor Tutor1 = new Tutor();
        Lesson JavaLanguage = new Lesson();
        Coordinator Coordinator1 = new Coordinator();

        double lesson_duration = JavaLanguage.setDuration_hour(2);

        double tutor_price = Tutor1.setPrice_per_hour(25.00);
        Student1.setLevel(3);

        Tutor1.getinfo(lesson_duration,tutor_price);
        Student1.getinfo();
        Coordinator1.getinfo();

    }
}
