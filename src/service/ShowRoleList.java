package service;

import dao.*;
import entity.Course;
import entity.StudentCourse;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @name：ShowRoleList
 * @Description：展示列表信息
 * @Author：cauthy
 * @date：2023/4/1 18:02
 */
public class ShowRoleList {
    /**
     * 查看所有学生
     * @throws SQLException
     */
    public static void showStudents() throws SQLException {
        StudentDao.searchStudent(0,"");
        System.out.println("按任意键继续！");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
    }

    /**
     * 查看所有老师
     * @throws SQLException
     */
    public static void showTeachers() throws SQLException {
        TeacherDao.searchTeacher(0,"");
        System.out.println("按任意键继续！");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
    }

    /**
     * 查看所有管理员
     * @throws SQLException
     */
    public static void showAdministrators() throws SQLException {
        AdminDao.searchAdmin("");
        System.out.println("按任意键继续！");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
    }

    /**
     * 查看学生对应的课程
     * @param studentId
     * @throws SQLException
     */

    public static void showCourseByStudentId(int studentId) throws SQLException {
        ArrayList<StudentCourse> studentCourses =  StudentCourseDao.searchStudentCourse(studentId,0);
        System.out.println("您的课程信息如下：");
        for(int i=0;i<studentCourses.size();i++){
            CourseDao.searchCourse(studentCourses.get(i).getCourseId(),"",0,"");
        }
        System.out.println("按任意键继续！");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
    }

    /**
     * 展示所有课程
     * @throws SQLException
     */
    public static void showCourse() throws SQLException {
        CourseDao.searchCourse(0,"",0,"");
        System.out.println("按任意键继续！");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
    }
    // 展示未选课程
    public static ArrayList<Course> showNotChooseCourse(int studentId) throws SQLException {
        ArrayList<Course> courseList = CourseDao.searchCourse(0,"",0,"");  // 总课程
        ArrayList<StudentCourse> studentCourses =  StudentCourseDao.searchStudentCourse(studentId,0);   //已选课程
        ArrayList<Course> courseNotList = new ArrayList<>();
        Map<Integer, String> myMap = new HashMap<>();
        for(int i=0;i<studentCourses.size();i++){
            myMap.put(studentCourses.get(i).getCourseId(),"1");
        }
        for(int i=0;i<courseList.size();i++){
            if(!myMap.containsKey(courseList.get(i).getCourseId())){
                courseNotList.add(courseList.get(i));
            }
        }
        return courseNotList;
    }

    /**
     * 查看选课学生
     * @param courseId
     * @throws SQLException
     */
    public static void showStudentsByCourseId(int courseId) throws SQLException {
        ArrayList<StudentCourse> studentCourses =  StudentCourseDao.searchStudentCourse(0,courseId);
        System.out.println("该课程对应的学生如下：");
        for(int i=0;i<studentCourses.size();i++){
            StudentDao.searchStudent(studentCourses.get(i).getStudentId(),"");
        }
        System.out.println("按任意键继续！");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
    }

    /**
     * 展示老师所授课程
     * @param teacherId
     * @throws SQLException
     */
    public static void showCourseByTeacherId(int teacherId) throws SQLException {
        CourseDao.searchCourse(0,"",teacherId,"");
        System.out.println("按任意键继续！");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
    }
}
