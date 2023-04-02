package entity;

import java.util.Date;

/**
 * @name：PostGraduate
 * @Description：研究生实体
 * @Author：cauthy
 * @date：2023/4/1 14:07
 */
public class Postgraduate extends Student {
    private String tutor;
    private String searchDirection;

    public Postgraduate() {
    }

    public Postgraduate(int studentId, String studentName, String gender, Date birth, String grade, String major, String password, String type, String tutor, String searchDirection) {
        super(studentId, studentName, gender, birth, grade, major, password,type);
        this.tutor = tutor;
        this.searchDirection = searchDirection;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getSearchDirection() {
        return searchDirection;
    }

    public void setSearchDirection(String searchDirection) {
        this.searchDirection = searchDirection;
    }

    @Override
    public String toString() {
        return "研究生{" +super.toString()+","+ "导师：" + tutor + ',' +"研究方向："+searchDirection+'}';
    }
}
