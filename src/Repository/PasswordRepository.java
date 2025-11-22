package Repository;

import domain.Student;
import domain.Teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PasswordRepository {
    private final Map<String, Student> mapStudentPas = new HashMap<>();
    private final Map<String, Teacher> mapTeacherPas = new HashMap<>();

    //Добовление студента
    public boolean addStudent(String login, String password, Student student) {
        if (mapStudentPas.containsKey(login)) {
            return false; // логин уже занят
        }
        mapStudentPas.put(login, student);
        return true;
    }

    //Добовление учителя
    public boolean addTeacher(String login, String password, Teacher teacher) {
        if (mapTeacherPas.containsKey(login)) {
            return false;
        }
        mapTeacherPas.put(login, teacher);
        return true;
    }

    //удаление студента
    public void removeStudent(String login) {
        if (login != null) {
            mapStudentPas.remove(login);
        }
    }

    //удаление учителя
    public void removeTeacher(String login) {
        if (login != null) {
            mapTeacherPas.remove(login);
        }
    }

    // Получить студента по логину (без пароля)
    public Student getStudent(String login) {
        return mapStudentPas.get(login);
    }

    // Получить учителя по логину (без пароля)
    public Teacher getTeacher(String login) {
        return mapTeacherPas.get(login);
    }

    // Получить всех студентов
    public List<Student> getAllStudents() {
        return new ArrayList<>(mapStudentPas.values());
    }

    // Получить всех учителей
    public List<Teacher> getAllTeachers() {
        return new ArrayList<>(mapTeacherPas.values());
    }


    public Student getNameStudent(String name) {
        for (Map.Entry<String, Student> entry : mapStudentPas.entrySet()) {
            String key = entry.getKey();
            Student student = entry.getValue();
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }
}
