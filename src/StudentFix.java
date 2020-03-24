import java.io.Serializable;

public class StudentFix implements Serializable {
    private int id;
    private String name;
    private byte age;
    private String address;
    private float gpa;

    public StudentFix(){

    }

    public StudentFix(int id, String name, byte age, String address, float gpa){
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.gpa = gpa;

    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public byte getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public float getGpa() {
        return gpa;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }
}
