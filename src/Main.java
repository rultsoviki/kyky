import Repository.PasswordRepository;
import Repository.StudentScheduleRepository;
import Service.Exception.AuthorizationService;
import Service.RegistrationService;
import Service.ScheduleAndGradeService;
import UI.ConsoleUI;
import domain.Lesson;
import domain.Role;
import domain.Schedule;
import domain.Student;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PasswordRepository passwordRepository = new PasswordRepository();
        StudentScheduleRepository studentScheduleRepository = new StudentScheduleRepository();
        RegistrationService registrationService = new RegistrationService(passwordRepository, studentScheduleRepository);
        Schedule schedule = new Schedule();
        AuthorizationService authorizationService = new AuthorizationService(passwordRepository);
        ScheduleAndGradeService scheduleAndGradeService = new ScheduleAndGradeService(studentScheduleRepository, schedule);
        ConsoleUI consoleUI = new ConsoleUI(registrationService, authorizationService, scheduleAndGradeService);
        consoleUI.start();

    }
}
