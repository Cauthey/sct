package utils;

/**
 * @name：ConsoleShow
 * @Description：界面显示信息
 * @Author：cauthy
 * @date：2023/4/1 16:15
 */
public class ConsoleShow {
    public static void printHeadInfo(){
        System.out.println("*****************************************");
        System.out.println("*                                       *");
        System.out.println("*              学生选课系统               *");
        System.out.println("*                                       *");
        System.out.println("*****************************************");
    }
    public static void showMainDisplay(){
        printHeadInfo();
        System.out.println("*****           1.学生               *****");
        System.out.println("*****           2.教师               *****");
        System.out.println("*****           3.管理员             *****");
        System.out.println("*****           0.退出选课系统        *****");
        System.out.println("*****************************************");
        System.out.print("请选择您的角色:");
    }
    public static void showAdminDisplay(){
        printHeadInfo();
        System.out.println("*****           1.查看学生            *****");
        System.out.println("*****           2.查看教师            *****");
        System.out.println("*****           3.查看管理员          *****");
        System.out.println("*****           4.查看所有课程        *****");
        System.out.println("*****           0.返回登录界面        *****");
        System.out.println("*****************************************");
        System.out.print("请输入对应编号:");
    }
    public static void showStudentDisplay(){
        printHeadInfo();
        System.out.println("*****           1.查看所选课程        *****");
        System.out.println("*****           2.查看未选课程        *****");
        System.out.println("*****           0.返回登录界面        *****");
        System.out.println("*****************************************");
        System.out.print("请输入对应编号:");

    }
    public static void showTeacherDisplay(){
        printHeadInfo();
        System.out.println("*****           1.查看所授课程        *****");
        System.out.println("*****           0.返回登录界面        *****");
        System.out.println("*****************************************");
        System.out.print("请输入对应编号:");
    }
    public static void showChooseCourseDisplay(){
        System.out.println("*****************************************");
        System.out.println("*****           1.选课              *****");
        System.out.println("*****************************************");
        System.out.print("请输入编号1选课:");
    }
    public static void showExitCourseDisplay(){
        System.out.println("*****************************************");
        System.out.println("*****           1.退课              *****");
        System.out.println("*****************************************");
        System.out.print("请输入编号1退课:");
    }
}
