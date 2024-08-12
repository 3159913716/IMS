package model;

public class Teacher {
    private String id;
    private String name;
    private String sex;
    private String age;
    private String phone;
    private String email;
    private String address;
    private String subject;

    //无参构造
    public Teacher(){}
    //有参构造
    public Teacher(String id, String name, String sex, String age, String phone,
                   String email, String address, String subject) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.subject = subject;
    }

    //获取id变量的数据
    public String getId() {
        return id;
    }
    //给id数据赋值
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
