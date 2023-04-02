package entity;

import java.util.Date;

/**
 * @name：Undergraduate
 * @Description：本科生
 * @Author：cauthy
 * @date：2023/4/1 14:12
 */
public class Undergraduate extends Student {
    private String rankClass;
    private String headTeacher;

    public Undergraduate() {
    }

    public Undergraduate(int studentId, String studentName, String gender, Date birth, String grade, String major, String password, String type, String rankClass, String headTeacher) {
        super(studentId, studentName, gender, birth, grade, major, password,type);
        this.rankClass = rankClass;
        this.headTeacher = headTeacher;
    }

    public String getRankClass() {
        return rankClass;
    }

    public void setRankClass(String rankClass) {
        this.rankClass = rankClass;
    }

    public String getHeadTeacher() {
        return headTeacher;
    }

    public void setHeadTeacher(String headTeacher) {
        this.headTeacher = headTeacher;
    }

    @Override
    public String toString() {
        return "本科生{" +super.toString()+","+ "班级：" + rankClass + ',' +"班主任："+headTeacher+'}';
    }
}
