package aimprosoft.entities;
public class Department implements Entity {

    private String name;
    private int id;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Department(){
    }

    public Department(int id){
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
