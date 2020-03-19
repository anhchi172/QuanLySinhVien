public class Student {
    private int id;
    private String name;
    private int age;
    private String address;
    private int gpa;

    public Student(int i, String n, int a, String ad, int g){
        id = i;
        name = n;
        age = a;
        address = ad;
        gpa = g;

    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public int getGpa() {
        return gpa;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGpa(int gpa) {
        this.gpa = gpa;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return ("Name: " + name + "Age: " + age + "GPA: " + gpa + "Address: " + address);
    }
}
