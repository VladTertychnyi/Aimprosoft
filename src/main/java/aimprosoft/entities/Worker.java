package aimprosoft.entities;
import java.util.Date;

public class Worker implements Entity {

    private int id;
    private String login;
    private String mail;
    private Date date;
    private int department_id;

    public Worker(int id, String login, String mail, Date date, int department_id) {
        this.id = id;
        this.login = login;
        this.mail = mail;
        this.date = date;
        this.department_id = department_id;
    }

    public Worker(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", mail='" + mail + '\'' +
                ", date=" + date +
                ", department_id=" + department_id +
                '}';
    }
}