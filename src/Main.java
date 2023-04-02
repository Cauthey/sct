
import dao.AdminDao;
import dao.StudentCourseDao;
import dao.StudentDao;
import entity.StudentCourse;

import java.sql.SQLException;
import java.util.Scanner;

import static service.ShowRoleList.*;
import static service.StudentChoose.exitCourse;
import static utils.ConsoleShow.*;
public class Main {
    public static void main(String[] args) throws SQLException {
        demo.initAdminData();
        demo.addStudentData();
        demo.addCourseData();
        demo.addTeacherData();
        try {
            boolean mainStatus = true;
            while (mainStatus) {
                showMainDisplay();
                Scanner input = new Scanner(System.in);
                switch (input.next()) {
                    case "1": {
                        System.out.print("请输入学号:");
                        Scanner inputPassport = new Scanner(System.in);
                        int studentId = Integer.parseInt(inputPassport.next());
                        System.out.print("请输入登录密码:");
                        String password = inputPassport.next();
                        boolean res = StudentDao.checkLoginPassport(studentId, password);
                        if (res) {
                            boolean status = true;
                            while (status) {
                                showStudentDisplay();
                                Scanner inputFunction = new Scanner(System.in);
                                switch (inputFunction.next()) {
                                    case "1": {
                                        showCourseByStudentId(studentId);  // 查看已选课程
                                        showExitCourseDisplay();   // 退课显示
                                        Scanner inputChoose = new Scanner(System.in);
                                        switch (inputChoose.next()) {
                                            case "1":
                                            {
                                                System.out.print("请输入要退的课程id：");
                                                Scanner course = new Scanner(System.in);
                                                int courseId = Integer.parseInt(course.next());
                                                boolean resTemp = exitCourse(courseId,studentId);
                                                if(resTemp){
                                                    System.out.println("退课成功!");
                                                }else{
                                                    System.out.println("退课失败!");
                                                }
                                                break;
                                            }
                                            case "0":
                                                break;
                                            default:
                                                System.out.println("输入错误，请重试！");
                                        }
                                        break;
                                    }
                                    case "2": {
                                        showNotChooseCourse(studentId);     // 查看未选课程
                                        showChooseCourseDisplay();  //选课显示
                                        Scanner inputChoose = new Scanner(System.in);
                                        switch (inputChoose.next()) {
                                            case "1":
                                            {
                                                System.out.print("请输入要选的课程id：");
                                                Scanner course = new Scanner(System.in);
                                                int courseId = Integer.parseInt(course.next());
                                                boolean resTemp = StudentCourseDao.addStudentCourse(new StudentCourse(studentId,courseId,null));
                                                if(resTemp){
                                                    System.out.println("选课成功!");
                                                }else{
                                                    System.out.println("选课失败!");
                                                }
                                                break;
                                            }
                                            case "0":
                                                break;
                                            default:
                                                System.out.println("输入错误，请重试！");
                                        }
                                    }
                                    case "0":
                                        status = false;
                                    default:
                                            System.out.println("选择有误,请重新输入！");
                                    }
                            }
                        } else {
                            System.out.println("账号或密码错误, 请重试!");
                            System.out.println("按任意键继续！");
                            Scanner scan = new Scanner(System.in);
                            scan.nextLine();
                        }
                        break;
                    }
                    case "2": {
                        System.out.print("请输入职工编号:");
                        Scanner inputPassport = new Scanner(System.in);
                        int teacherId = Integer.parseInt(inputPassport.next());
                        System.out.print("请输入登录密码:");
                        String password = inputPassport.next();
                        boolean res = StudentDao.checkLoginPassport(teacherId, password);
                        if (res) {
                            while (true) {
                                showTeacherDisplay();
                                Scanner inputFunction = new Scanner(System.in);
                                switch (inputFunction.next()) {
                                    case "1":
                                        showCourseByTeacherId(teacherId);
                                        break;
                                    case "0":
                                        break;
                                    default:
                                        System.out.println("选择有误,请重新输入！");
                                }
                            }
                        } else {
                            System.out.println("账号或密码错误, 请重试!");
                            System.out.println("按任意键继续！");
                            Scanner scan = new Scanner(System.in);
                            scan.nextLine();
                        }
                        break;
                    }
                    case "3": {
                        System.out.print("请输入用户名:");
                        Scanner inputPassport = new Scanner(System.in);
                        String username = inputPassport.next();
                        System.out.print("请输入登录密码:");
                        String password = inputPassport.next();
                        boolean res = AdminDao.checkLoginPassport(username, password);
                        if (res) {
                            while (true) {
                                showAdminDisplay();
                                Scanner inputFunction = new Scanner(System.in);
                                switch (inputFunction.next()) {
                                    case "1":
                                        showStudents();
                                        break;
                                    case "2":
                                        showTeachers();
                                        break;
                                    case "3":
                                        showAdministrators();
                                    case "4":
                                        showCourse();
                                    case "0":
                                        break;
                                    default:
                                        System.out.println("选择有误,请重新输入！");
                                }
                            }
                        } else {
                            System.out.println("账号或密码错误, 请重试!");
                            System.out.println("按任意键继续！");
                            Scanner scan = new Scanner(System.in);
                            scan.nextLine();
                        }
                        break;
                    }
                    case "0":
                        mainStatus = false;
                    default:
                        System.out.println("选择有误,请重新输入！");
                }
            }
        }catch (RuntimeException e){
            e.printStackTrace();
        }
    }
}