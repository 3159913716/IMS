package operation;
import utils.ToolUtil;
import model.Student;
import model.Teacher;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class TeacherAndStudentOperation {
    //修改信息
    public void modifyInformation(ArrayList<Teacher> teachers, ArrayList<Student> students,
                                  Scanner sc, int index, int judgment) {
        String input;
        while (true) {
            System.out.println("---------------------------------" +
                    "--------------------------------------");
            System.out.println("1 修改手机号");
            System.out.println("2 修改电子邮箱");
            System.out.println("3 修改现居地");
            System.out.println("4 返回上级菜单");
            System.out.println("请选择你要执行的操作:");
            input = sc.next();
            if (Objects.equals(input, "4")) {
                break;
            }
            switch (input) {
                case "1":
                    System.out.println("请输入新手机号:");
                    input = sc.next();
                    if (ToolUtil.verifyPhone(input)) {
                        if (judgment == 1) {
                            teachers.get(index).setPhone(input);
                        } else if (judgment == 2) {
                            students.get(index).setPhone(input);
                        }
                        System.out.println("修改成功!");
                    } else {
                        System.out.println("修改失败,请输入正确的手机号格式");
                    }
                    break;
                case "2":
                    System.out.println("请输入新电子邮箱:");
                    input = sc.next();
                    if (ToolUtil.verifyEmail(input)) {
                        if (judgment == 1) {
                            teachers.get(index).setEmail(input);
                        } else if (judgment == 2) {
                            students.get(index).setEmail(input);
                        }
                        System.out.println("修改成功!");
                    } else {
                        System.out.println("修改失败,请输入正确的邮箱格式!");
                    }
                    break;
                case "3":
                    System.out.println("请输入新现居地:");
                    input = sc.next();
                    if (ToolUtil.verifyChinese(input)) {
                        if (judgment == 1) {
                            teachers.get(index).setAddress(input);
                        } else if (judgment == 2) {
                            students.get(index).setAddress(input);
                        }
                        System.out.println("修改成功!");
                    } else {
                        System.out.println("修改失败,请输入汉字!");
                    }
                    break;
                default:
                    System.out.println("请输入正确的选项编号!");
                    break;
            }
        }
    }

    //教师查询成绩
    public void queryGrade(ArrayList<Teacher> teachers, ArrayList<Student> students, Scanner sc, int index) {
        String input;
        double[] arr = new double[students.size()];
        while (true) {
            System.out.println("---------------------------------" +
                    "--------------------------------------");
            System.out.println("1 查询所授科目的全部成绩");
            System.out.println("2 单独查询所授科目的学生成绩");
            System.out.println("3 返回上级菜单");
            System.out.println("请选择你要执行的操作:");
            input = sc.next();
            if (Objects.equals(input, "3")) {
                break;
            }
            switch (input) {
                case "1":
                    while (true) {
                        System.out.println("---------------------------------" +
                                "--------------------------------------");
                        System.out.println("1 升序查询");
                        System.out.println("2 降序查询");
                        System.out.println("3 返回上级菜单");
                        System.out.println("请选择你要执行的操作:");
                        input = sc.next();
                        if (Objects.equals(input, "3")) {
                            break;
                        }
                        switch (input) {
                            case "1", "2":
                                System.out.println("序号\t\t学号\t\t\t姓名\t\t" + teachers.get(index).getSubject() + "成绩");
                                showMethod(students, arr, teachers.get(index).getSubject(), input);
                                break;
                            default:
                                System.out.println("请输入正确的选项编号!");
                                break;
                        }
                    }
                    System.out.println("查询成功");
                    System.out.println("---------------------------------" +
                            "--------------------------------------");
                    break;
                case "2":
                    System.out.println("请输入学生学号或姓名:");
                    input = sc.next();
                    int index1 = -1;
                    for (int i = 0; i < students.size(); i++) {
                        if (Objects.equals(input, students.get(i).getId()) ||
                                Objects.equals(input, students.get(i).getName())) {
                            System.out.println("学号\t\t\t姓名\t\t" + teachers.get(index).getSubject() + "成绩");
                            if (Objects.equals(teachers.get(index).getSubject(), "语文")) {
                                System.out.println(students.get(i).getId() + "\t\t" +
                                        students.get(i).getName() + "\t\t" +
                                        students.get(i).getChinese());
                            } else if (Objects.equals(teachers.get(index).getSubject(), "数学")) {
                                System.out.println(students.get(i).getId() + "\t\t" +
                                        students.get(i).getName() + "\t\t" +
                                        students.get(i).getMath());
                            } else if (Objects.equals(teachers.get(index).getSubject(), "英语")) {
                                System.out.println(students.get(i).getId() + "\t\t" +
                                        students.get(i).getName() + "\t\t" +
                                        students.get(i).getEnglish());
                            }
                            index1 = i;
                        }
                    }
                    if (index1 == -1) {
                        System.out.println("查询失败,没有这个学生!");
                        break;
                    }
                    System.out.println("查询成功!");
                    break;
                default:
                    System.out.println("请输入正确的选项编号!");
            }
        }
    }

    //学生查询成绩
    public void queryGrade(ArrayList<Student> students, Scanner sc, int index) {
        String input;
        while (true) {
            System.out.println("1 查询全部科目成绩");
            System.out.println("2 查询单个科目成绩");
            System.out.println("3 返回上级菜单");
            input = sc.next();
            if (Objects.equals(input, "3")) {
                break;
            }
            switch (input) {
                case "1":
                    System.out.println("---------------------------------" +
                            "--------------------------------------");
                    System.out.println("学号\t\t\t姓名\t\t语文\t\t数学\t\t英语\t\t平均分\t\t总分");
                    System.out.println(students.get(index).getId() + "\t\t" +
                            students.get(index).getName() + "\t\t" +
                            students.get(index).getChinese() + "\t\t" +
                            students.get(index).getMath() + "\t\t" +
                            students.get(index).getEnglish() + "\t\t" +
                            students.get(index).getAverageScore() + "\t\t" +
                            students.get(index).getTotalScore());
                    System.out.println("查询成功!");
                    break;
                case "2":
                    System.out.println("---------------------------------" +
                            "--------------------------------------");
                    System.out.println("请输入你要查询的科目:");
                    input = sc.next();
                    switch (input) {
                        case "语文" -> {
                            System.out.println("学号\t\t\t姓名\t\t" + input + "成绩");
                            System.out.println(students.get(index).getId() + "\t\t" +
                                    students.get(index).getName() + "\t\t" +
                                    students.get(index).getChinese());
                        }
                        case "数学" -> {
                            System.out.println("学号\t\t\t姓名\t\t" + input + "成绩");
                            System.out.println(students.get(index).getId() + "\t\t" +
                                    students.get(index).getName() + "\t\t" +
                                    students.get(index).getMath());
                        }
                        case "英语" -> {
                            System.out.println("学号\t\t\t姓名\t\t" + input + "成绩");
                            System.out.println(students.get(index).getId() + "\t\t" +
                                    students.get(index).getName() + "\t\t" +
                                    students.get(index).getEnglish());
                        }
                        case null, default -> System.out.println("查询失败,没有" + input + "科目的成绩!");
                    }

                    break;
                default:
                    System.out.println("请输入正确的选项编号!");
            }
        }
    }

    //展示方法
    public void showMethod(ArrayList<Student> students, double[] arr, String subject, String input) {
        for (int i = 0; i < arr.length; i++) {
            if (Objects.equals(subject, "语文")) {
                arr[i] = students.get(i).getChinese();
            } else if (Objects.equals(subject, "数学")) {
                arr[i] = students.get(i).getMath();
            } else if (Objects.equals(subject, "英语")) {
                arr[i] = students.get(i).getEnglish();
            }
        }
        ToolUtil.bubbleSorting(arr, input);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (Objects.equals(subject, "语文")) {
                    if (Objects.equals(arr[i], students.get(j).getChinese())) {
                        System.out.println(i + 1 + "\t\t" + students.get(j).getId() + "\t\t\t" +
                                students.get(j).getName() + "\t\t" +
                                students.get(j).getChinese());
                    }
                } else if (Objects.equals(subject, "数学")) {
                    if (Objects.equals(arr[i], students.get(j).getMath())) {
                        System.out.println(i + 1 + "\t\t" + students.get(j).getId() + "\t\t\t" +
                                students.get(j).getName() + "\t\t" +
                                students.get(i).getMath());
                    }
                } else if (Objects.equals(subject, "英语")) {
                    if (Objects.equals(arr[i], students.get(j).getEnglish())) {
                        System.out.println(i + 1 + "\t\t" + students.get(j).getId() + "\t\t\t" +
                                students.get(j).getName() + "\t\t" +
                                students.get(j).getEnglish());
                    }
                }

            }
        }
    }
}

