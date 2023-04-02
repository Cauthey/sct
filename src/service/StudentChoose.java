package service;

import dao.CourseDao;
import dao.StudentCourseDao;
import dao.StudentDao;
import entity.Course;
import entity.Student;
import entity.StudentCourse;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @name：StudentChoose
 * @Description：学生选课退课
 * @Author：cauthy
 * @date：2023/4/1 19:02
 */
public class StudentChoose {
    public void selectCourse(int studentId,int courseId) throws SQLException {
        // 检查选课总人数
        ArrayList<StudentCourse> studentCourses =  StudentCourseDao.searchStudentCourse(0,courseId);
        if(studentCourses.size()>=50){
            System.out.println("选课人数已达上限50人, 选课失败!");
            System.out.println("按任意键继续！");
            Scanner scan = new Scanner(System.in);
            scan.nextLine();
            return;
        }
        // 检查该生学分总数
        ArrayList<Student> studentArrayList = StudentDao.searchStudent(studentId,"");
        if(studentArrayList.size()!=1){
            System.out.println("操作失败！");
            System.out.println("按任意键继续！");
            Scanner scan = new Scanner(System.in);
            scan.nextLine();
            return;
        }
        studentCourses =  StudentCourseDao.searchStudentCourse(studentId,0);
        int sumCredit = 0;
        for(int i=0;i<studentCourses.size();i++){
            ArrayList<Course> courseList = CourseDao.searchCourse(studentCourses.get(i).getCourseId(),"",0,"");
            if(courseList.size()==1){
                sumCredit+=courseList.get(0).getAcademicCredit();
            }
        }
        if(studentArrayList.get(0).getType().equals("本科生") && sumCredit >= 40){
            System.out.println("本科生学分总数不可超过40，选课失败！");
            System.out.println("按任意键继续！");
            Scanner scan = new Scanner(System.in);
            scan.nextLine();
            return;
        }
        if(studentArrayList.get(0).getType().equals("研究生") && sumCredit >= 30){
            System.out.println("研究生学分总数不可超过30，选课失败！");
            System.out.println("按任意键继续！");
            Scanner scan = new Scanner(System.in);
            scan.nextLine();
            return;
        }

        StudentCourse studentCourse = new StudentCourse(studentId,courseId,null);
        boolean res = StudentCourseDao.addStudentCourse(studentCourse);
        if(res){
            System.out.println("选课成功!");
        }else{
            System.out.println("选课失败!");
        }
    }
    public static boolean exitCourse(int studentId, int courseId) throws SQLException {
        boolean res = StudentCourseDao.deleteStudentCourse(courseId,studentId);
        if(res){
            System.out.println("退课成功!");
        }else{
            System.out.println("退课失败!");
        }
        return res;
    }
}
