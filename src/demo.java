import dao.*;
import entity.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @name：demo
 * @Description：add some data to database
 * @Author：cauthy
 * @date：2023/4/1 12:31
 */
public class demo {
    /**
     * 添加学生测试数据
     * @throws SQLException
     */
    public static void addStudentData() throws SQLException {
        try {
            ArrayList<Student> students = StudentDao.searchStudent(0, "");
            if (students.size() == 0) {
                // 创建 java.util.Date 类型的对象
                String strDate = "2002-11-01"; // 日期字符串
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // 解析日期的格式
                java.util.Date utilDate = format.parse(strDate); // 将字符串解析成 java.util.Date 对象
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); // 将 java.util.Date 对象转换为 java.sql.Date 类型

                Undergraduate student1 = new Undergraduate(1001, "张三", "男", sqlDate, "大一", "计算机", "123456","本科生","五班","王老师");
                System.out.println("添加测试学生1:" + student1);
                boolean res1 = StudentDao.addStudent(student1,null);
                if (!res1) {
                    System.out.println("添加测试学生1失败");
                } else {
                    System.out.println("添加测试学生1成功");
                }
                Undergraduate student2 = new Undergraduate(1002, "李四", "女", sqlDate, "大四", "软件工程", "123456","本科生","一班","李老师");
                System.out.println("添加测试学生2:" + student2);
                boolean res2 = StudentDao.addStudent(student2,null);
                if (!res2) {
                    System.out.println("添加测试学生2失败");
                } else {
                    System.out.println("添加测试学生2成功");
                }
                Postgraduate student3 = new Postgraduate(1003, "王五", "女", sqlDate, "研一", "机械工程", "123456","研究生","何老师","如何才能进入西工大工作");
                System.out.println("添加测试学生3:" + student3);
                boolean res3 = StudentDao.addStudent(null,student3);
                if (!res3) {
                    System.out.println("添加测试学生3失败");
                } else {
                    System.out.println("添加测试学生3成功");
                }
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 添加课程测试数据
     * @throws SQLException
     */
    public static void addCourseData() throws SQLException {
        try {
            ArrayList<Course> courses = CourseDao.searchCourse(0, "",0,"");
            if (courses.size() == 0) {
                // 创建 java.util.Date 类型的对象
                Course course1 = new Course(1,"语文",1,"张老师","一门非常好玩的课程",2);
                Course course2 = new Course(2,"数学",2,"王老师","学习数学知识",4);
                Course course3 = new Course(3,"英语",3,"李老师","学习英语知识",8);
                Course course4 = new Course(4,"政治",4,"赵老师","学习政治知识",10);
                Course course5 = new Course(5,"历史",5,"钱老师","学习历史知识",5);
                Course course6 = new Course(6,"物理",6,"孙老师","学习物理知识",3);
                CourseDao.addCourse(course1);
                CourseDao.addCourse(course2);
                CourseDao.addCourse(course3);
                CourseDao.addCourse(course4);
                CourseDao.addCourse(course5);
                CourseDao.addCourse(course6);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 添加老师测试数据
     * @throws SQLException
     */
    public static void addTeacherData() throws SQLException {
        try {
            ArrayList<Teacher> teachers = TeacherDao.searchTeacher(0, "");
            if (teachers.size() == 0) {
                // 创建 java.util.Date 类型的对象
                Teacher teacher1 = new Teacher(1,"张老师","123456");
                Teacher teacher2 = new Teacher(2,"王老师","123456");
                Teacher teacher3 = new Teacher(3,"李老师","123456");
                Teacher teacher4 = new Teacher(4,"赵老师","123456");
                Teacher teacher5 = new Teacher(5,"钱老师","123456");
                Teacher teacher6 = new Teacher(6,"孙老师","123456");
                TeacherDao.addTeacher(teacher1);
                TeacherDao.addTeacher(teacher2);
                TeacherDao.addTeacher(teacher3);
                TeacherDao.addTeacher(teacher4);
                TeacherDao.addTeacher(teacher5);
                TeacherDao.addTeacher(teacher6);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 初始化管理员账号
     * @throws SQLException
     */
    public static void initAdminData() throws SQLException {
        try {
            ArrayList<Admin> admins = AdminDao.searchAdmin("");
            if (admins.size() == 0) {
                // 创建 java.util.Date 类型的对象
                Admin admin = new Admin("admin","admin");
                boolean res = AdminDao.addAdmin(admin);
                if(res){
                    System.out.println("初始化管理员admin/admin成功!");
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
