package Controller;

import Entity.User;
import service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentController {
    @Autowired
    private UserService studentService;

    public void displayStudent(String username) {
        User user = studentService.getStudentByUsername(username);

        String info = String.format(
                "Id: %s \n" + "Username: %s \n" + "Email: %s \n" + "Address: %s \n",
                user.getId(), user.getUsername(), user.getEmail(), user.getaddress());
        System.out.println(info);
    }

    public boolean updateStudent(User newStudent) {
        User oldStudent = studentService.getStudentByUsername(newStudent.getUsername());

        if (oldStudent != null && StringUtils.isAlpha(newStudent.getUsername())
                && StringUtils.isAlpha(newStudent.getEmail())
                && StringUtils.isAlpha(newStudent.getaddress())) {
            oldStudent.setUsername(newStudent.getUsername());
            oldStudent.setEmail(newStudent.getEmail());
            oldStudent.setaddress(newStudent.getaddress());

            studentService.saveOrUpdate(oldStudent);

            return true;
        }

        return false;
    }
}