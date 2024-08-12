
import model.Student;
import model.Teacher;
import operation.ManagerOperation;
import operation.TeacherAndStudentOperation;
import utils.ToolUtil;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("-----------------------------------------------------------------------");
        //集合用于储存用户对象
        ArrayList<Teacher> teachers = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        teacher(teachers);
        student(students);
        Scanner sc = new Scanner(System.in);
        String input;
        int index = -1;
        int judgment = -1;
        System.out.println("==============欢迎来到综合系统==============");
        while (true) {
            System.out.println("---------------------------------" +
                    "--------------------------------------");
            System.out.println("1 管理员登录");
            System.out.println("2 教师用户登录");
            System.out.println("3 学生用户登录");
            System.out.println("4 退出系统");
            System.out.println("请选择你要执行的操作:");
            input = sc.next();
            switch (input) {
                case "1":
                    System.out.println("---------------------------------" +
                            "--------------------------------------");
                    managerLogin(teachers,students);
                    break;
                case "2":
                    System.out.println("请输入教师编号:");
                    input = sc.next();
                    for (int i = 0; i < teachers.size(); i++) {
                        if (teachers.get(i).getId().equals(input)) {
                            index = i;
                            judgment = 1;
                        }
                    }
                    if (index == -1) {
                        System.out.println("登录失败没有该用户");
                        break;
                    }
                    System.out.println("登录成功");
                    System.out.println("---------------------------------" +
                            "--------------------------------------");
                    teacherLogin(teachers, students, index, judgment);
                    index = -1;
                    break;
                case "3":
                    System.out.println("请输入学号:");
                    input = sc.next();
                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).getId().equals(input)) {
                            index = i;
                            judgment = 2;
                        }
                    }
                    if (index == -1) {
                        System.out.println("登录失败没有该用户");
                        break;
                    }
                    System.out.println("登录成功");
                    System.out.println("---------------------------------" +
                            "--------------------------------------");
                    studentLogin(teachers, students, index, judgment);
                    index = -1;
                    break;
                case "4":
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("请输入正确的选项编号!");
                    System.out.println("---------------------------------" +
                            "--------------------------------------");
                    break;
            }
        }

    }

    public static void teacher(ArrayList<Teacher> teachers) {
        Teacher chineseTeacher = new Teacher("235810", "陈爱国", "男", "43", "19377102680"
                , "19377102680@163.com", "南宁", "语文");
        Teacher mathTeacher = new Teacher("235811", "王建国", "男", "42", "19377102681"
                , "19377102681@163.com", "崇左", "数学");
        Teacher englishTheater = new Teacher("235812", "李翠花", "女", "45", "19377102683"
                , "19377102683@163.com", "贵港", "英语");
        teachers.add(chineseTeacher);
        teachers.add(mathTeacher);
        teachers.add(englishTheater);
    }

    public static void student(ArrayList<Student> students) {
        Student s = new Student("2158040635", "张三", "男", "18", "19377102780",
                "19377102780@163.com", "A市");
        Student s2 = new Student("2158040636", "李四", "男", "19", "19377102781",
                "19377102781@163.com", "B市");
        Student s3 = new Student("2158040637", "王五", "男", "18", "19377102782",
                "19377102782@163.com", "C市");
        Student s4 = new Student("2158040638", "赵六", "男", "19", "19377102783",
                "19377102783@163.com", "D市");
        students.add(s);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        for (int i = 0; i < students.size(); i++) {
            students.get(i).setChinese(ToolUtil.verifyScores());
            students.get(i).setMath(ToolUtil.verifyScores());
            students.get(i).setEnglish(ToolUtil.verifyScores());
        }
        for (int i = 0; i < students.size(); i++) {
            double sum = 0;
            sum = students.get(i).getChinese() +
                    students.get(i).getMath() +
                    students.get(i).getEnglish();
            students.get(i).setTotalScore(sum);
            students.get(i).setAverageScore(String.format("%.2f", sum / 3));
        }
    }

    //管理员登录
    public static void managerLogin(ArrayList<Teacher> teachers, ArrayList<Student> students) {
        ManagerOperation managerOperation = new ManagerOperation();
        Scanner sc = new Scanner(System.in);
        String input;
        while (true) {
            System.out.println("---------------------------------" +
                    "--------------------------------------");
            System.out.println("1 管理用户");
            System.out.println("2 信息查询");
            System.out.println("3 返回登录菜单");
            System.out.println("请选择你要执行的操作:");
            input = sc.next();
            if (Objects.equals(input, "3")) {
                System.out.println("-----------------------------------------------------------------------");
                break;
            }
            switch (input) {
                case "1":
                    System.out.println("---------------------------------" +
                            "--------------------------------------");
                    while (true) {
                        System.out.println("1 增加用户");
                        System.out.println("2 删除用户");
                        System.out.println("3 修改用户信息");
                        System.out.println("4 返回上级菜单");
                        System.out.println("请选择你要执行的操作:");
                        input = sc.next();
                        if (Objects.equals(input, "4")) {
                            System.out.println("---------------------------------" +
                                    "--------------------------------------");
                            break;
                        }
                        switch (input) {
                            case "1":
                                System.out.println("---------------------------------" +
                                        "--------------------------------------");
                                while (true){
                                    System.out.println("---------------------------------" +
                                            "--------------------------------------");
                                    System.out.println("1 增加教师用户");
                                    System.out.println("2 增加学生用户");
                                    System.out.println("3 返回上级菜单");
                                    System.out.println("请选择你要执行的操作:");
                                    input =sc.next();
                                    if (Objects.equals(input, "3")){
                                        break;
                                    }
                                    switch (input) {
                                        case "1" ,"2":
                                            managerOperation.augmentUser(teachers,students,sc,input);
                                            break;
                                        default:
                                            System.out.println("请输入正确的选项编号!");
                                    }

                                    System.out.println("---------------------------------" +
                                            "--------------------------------------");
                                }
                                System.out.println("---------------------------------" +
                                        "--------------------------------------");
                                break;
                            case "2":
                                System.out.println("---------------------------------" +
                                        "--------------------------------------");
                                while (true){
                                    System.out.println("---------------------------------" +
                                            "--------------------------------------");
                                    System.out.println("1 删除教师用户");
                                    System.out.println("2 删除学生用户");
                                    System.out.println("3 返回上级菜单");
                                    System.out.println("请选择你要执行的操作:");
                                    input = sc.next();
                                    if (Objects.equals(input, "3")){
                                        break;
                                    }
                                    switch (input) {
                                        case "1" ,"2":
                                            managerOperation.deleteUser(teachers,students,sc,input);
                                            break;
                                        default:
                                            System.out.println("请输入正确的选项编号!");
                                    }

                                }
                                System.out.println("---------------------------------" +
                                        "--------------------------------------");
                                break;
                            case "3":
                                System.out.println("---------------------------------" +
                                        "--------------------------------------");
                                while (true){
                                    System.out.println("---------------------------------" +
                                            "--------------------------------------");
                                    System.out.println("1 修改教师用户信息");
                                    System.out.println("2 修改学生用户信息");
                                    System.out.println("3 返回上级菜单");
                                    System.out.println("请选择你要执行的操作:");
                                    input = sc.next();
                                    if (Objects.equals(input, "3")){
                                        break;
                                    }
                                    switch (input) {
                                        case "1" ,"2":
                                            managerOperation.modifyInformation(teachers,students,sc,input);
                                            break;
                                        default:
                                            System.out.println("请输入正确的选项编号!");
                                    }
                                }
                                System.out.println("---------------------------------" +
                                        "--------------------------------------");
                                break;
                            default:
                                System.out.println("请输入正确的选项编号!");
                                System.out.println("---------------------------------" +
                                        "--------------------------------------");
                                break;
                        }
                    }
                    break;
                case "2":
                    System.out.println("---------------------------------" +
                            "--------------------------------------");
                    while (true) {
                        System.out.println("---------------------------------" +
                                "--------------------------------------");
                        System.out.println("1 用户信息查询");
                        System.out.println("2 成绩查询");
                        System.out.println("3 返回上级菜单");
                        System.out.println("请选择你要执行的操作:");
                        input = sc.next();
                        if (Objects.equals(input, "3")) {
                            break;
                        }
                        switch (input) {
                            case "1":
                                System.out.println("---------------------------------" +
                                        "--------------------------------------");
                                while (true){
                                    System.out.println("---------------------------------" +
                                            "--------------------------------------");
                                    System.out.println("1 教师用户信息查询");
                                    System.out.println("2 学生用户信息查询");
                                    System.out.println("3 返回上级菜单");
                                    System.out.println("请选择你要执行的操作:");

                                    input = sc.next();
                                    if (Objects.equals(input, "3")) {
                                        break;
                                    }
                                    switch (input){
                                        case "1" ,"2":
                                            System.out.println("---------------------------------" +
                                                    "--------------------------------------");
                                            managerOperation.informationInquiry(teachers,students,sc,input);
                                            System.out.println("---------------------------------" +
                                                    "--------------------------------------");
                                            break;
                                        default:
                                            System.out.println("请输入正确的选项编号!");
                                    }
                                }
                                break;
                            case "2":
                                System.out.println("---------------------------------" +
                                        "--------------------------------------");
                                while (true){
                                    System.out.println("---------------------------------" +
                                            "--------------------------------------");
                                    System.out.println("1 查询所有学生所有科目成绩");
                                    System.out.println("2 查询单个科目所有学生成绩");
                                    System.out.println("3 查询单个学生成绩");
                                    System.out.println("4 返回上级菜单");
                                    System.out.println("请选择你要执行的操作:");
                                    input = sc.next();
                                    if (Objects.equals(input, "4")) {
                                        break;
                                    }
                                    switch (input) {
                                        case "1" ,"2","3":
                                            managerOperation.queryGrade(students,sc,input);
                                            break;
                                        default:
                                            System.out.println("请输入正确的选项编号!");
                                    }
                                }
                                break;
                            default:
                                System.out.println("请输入正确的选项编号!");
                                System.out.println("---------------------------------" +
                                        "--------------------------------------");
                                break;
                        }
                    }
                    break;
                default:
                    System.out.println("请输入正确的选项编号!");
            }
        }
    }

    //教师登录
    public static void teacherLogin(ArrayList<Teacher> teachers, ArrayList<Student> students,
                                    int index, int judgment) {
        Scanner sc = new Scanner(System.in);
        TeacherAndStudentOperation teacherOperation = new TeacherAndStudentOperation();
        String input;
        while (true) {
            System.out.println("---------------------------------" +
                    "--------------------------------------");
            System.out.println("1 查询自己的信息");
            System.out.println("2 修改自己的部分信息");
            System.out.println("3 查询成绩");
            System.out.println("4 返回登录菜单");
            System.out.println("请选择你要执行的操作:");
            input = sc.next();
            if (Objects.equals(input, "4")) {
                break;
            }
            switch (input) {
                case "1":
                    System.out.println("编号\t\t姓名\t\t性别\t\t年龄\t\t手机号\t\t\t电子邮件\t\t\t\t现居住地\t\t\t所授科目");
                    System.out.println(teachers.get(index).getId() + "\t\t" + teachers.get(index).getName() + "\t\t" +
                            teachers.get(index).getSex() + "\t\t\t" + teachers.get(index).getAge() + "\t\t\t" +
                            teachers.get(index).getPhone() + "\t\t" + teachers.get(index).getEmail() + "\t\t" +
                            teachers.get(index).getAddress() + "\t\t" + teachers.get(index).getSubject());
                    System.out.println("查询成功!");
                    break;
                case "2":
                    System.out.println("---------------------------------" +
                            "--------------------------------------");
                    teacherOperation.modifyInformation(teachers, students, sc, index, judgment);
                    break;
                case "3":
                    System.out.println("---------------------------------" +
                            "--------------------------------------");
                    teacherOperation.queryGrade(teachers, students, sc, index);
                    break;
                default:
                    System.out.println("请输入正确的选项编号:");
                    break;
            }
        }
    }

    //学生登录
    public static void studentLogin(ArrayList<Teacher> teachers, ArrayList<Student> students,
                                    int index, int judgment) {
        Scanner sc = new Scanner(System.in);
        TeacherAndStudentOperation studentOperation = new TeacherAndStudentOperation();
        String input;
        while (true) {
            System.out.println("---------------------------------" +
                    "--------------------------------------");
            System.out.println("1 查询自己的信息");
            System.out.println("2 修改自己的部分信息");
            System.out.println("3 查询成绩");
            System.out.println("4 返回登录菜单");
            System.out.println("请选择你要执行的操作:");
            input = sc.next();
            if (Objects.equals(input, "4")) {
                break;
            }
            switch (input) {
                case "1":
                    System.out.println("---------------------------------" +
                            "--------------------------------------");
                    System.out.println("学号\t\t\t姓名\t\t性别\t\t年龄\t\t手机号\t\t\t电子邮件\t\t\t\t现居住地");
                    System.out.println(students.get(index).getId() + "\t\t" + students.get(index).getName() + "\t\t" +
                            students.get(index).getSex() + "\t\t\t" + students.get(index).getAge() + "\t\t\t" +
                            students.get(index).getPhone() + "\t\t" + students.get(index).getEmail() + "\t\t" +
                            students.get(index).getAddress());
                    System.out.println("查询成功!");
                    break;
                case "2":
                    System.out.println("---------------------------------" +
                            "--------------------------------------");
                    studentOperation.modifyInformation(teachers, students, sc, index, judgment);
                    break;
                case "3":
                    System.out.println("---------------------------------" +
                            "--------------------------------------");
                    studentOperation.queryGrade(students, sc, index);
                    break;
                default:
                    System.out.println("请输入正确的选项编号:");
                    break;
            }
        }
    }
}
