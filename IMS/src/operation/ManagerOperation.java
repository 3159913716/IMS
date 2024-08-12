package operation;

import model.Student;
import model.Teacher;
import utils.ToolUtil;


import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ManagerOperation {
    //增加用户
    public void augmentUser(ArrayList<Teacher> teachers, ArrayList<Student> students, Scanner sc, String input) {
        Teacher teacher = new Teacher();
        Student student = new Student();
        StringBuilder sb = new StringBuilder();
        String t = "23581";
        int t1 = 2;
        String s = "215804063";
        int s1 = 8;
        String choice;
        System.out.println("请输入姓名:");
        while (true) {
            choice = sc.next();
            if (ToolUtil.verifyChinese(choice)) {
                if (Objects.equals(input, "1")) {
                    teacher.setName(choice);
                    break;
                } else if (Objects.equals(input, "2")) {
                    student.setName(choice);
                    break;
                }
            } else {
                System.out.println("请输入汉字!");
            }
        }
        System.out.println("请输入性别:");
        while (true) {
            choice = sc.next();
            if (ToolUtil.verifySex(choice)) {
                if (Objects.equals(input, "1")) {
                    teacher.setSex(choice);
                    break;
                } else if (Objects.equals(input, "2")) {
                    student.setSex(choice);
                    break;
                }
            } else {
                System.out.println("请输入正确的性别:");
            }
        }
        System.out.println("请输入年龄:");
        while (true) {
            choice = sc.next();
            if (ToolUtil.verifyNumber(choice)) {
                if (Objects.equals(input, "1")) {
                    teacher.setAge(choice);
                    break;
                } else if (Objects.equals(input, "2")) {
                    student.setAge(choice);
                    break;
                }
            } else {
                System.out.println("请输入数字:");
            }
        }
        System.out.println("请输入手机号:");
        while (true) {
            choice = sc.next();
            if (ToolUtil.verifyPhone(choice)) {
                if (Objects.equals(input, "1")) {
                    teacher.setPhone(choice);
                    break;
                } else if (Objects.equals(input, "2")) {
                    student.setPhone(choice);
                    break;
                }
            } else {
                System.out.println("请输入正确的手机号格式:");
            }
        }
        System.out.println("请输入电子邮箱:");
        while (true) {
            choice = sc.next();
            if (ToolUtil.verifyEmail(choice)) {
                if (Objects.equals(input, "1")) {
                    teacher.setEmail(choice);
                    break;
                } else if (Objects.equals(input, "2")) {
                    student.setEmail(choice);
                    break;
                }
            } else {
                System.out.println("请输入正确的电子邮箱格式:");
            }
        }
        System.out.println("请输入现居地:");
        while (true) {
            choice = sc.next();
            if (ToolUtil.verifyChinese(choice)) {
                if (Objects.equals(input, "1")) {
                    teacher.setAddress(choice);
                    break;
                } else if (Objects.equals(input, "2")) {
                    student.setAddress(choice);
                    break;
                }
            } else {
                System.out.println("请输入汉字:");
            }
        }
        if (Objects.equals(input, "1")) {
            System.out.println("请输入所授科目:");
            while (true) {
                choice = sc.next();
                if (ToolUtil.verifyChinese(choice)) {
                    teacher.setSubject(choice);
                    break;
                } else {
                    System.out.println("请输入汉字:");
                }
            }
        }
        if (Objects.equals(input, "1")) {
            sb.append(t);
            String t2 = String.valueOf(++t1);
            sb.insert(5, t2);
            teacher.setId(sb.toString());
            teachers.add(teacher);
            System.out.println("添加成功!");
            System.out.println("教师编号为:" + teacher.getId());
        } else if (Objects.equals(input, "2")) {
            sb.append(s);
            String s2 = String.valueOf(++s1);
            sb.insert(9, s2);
            student.setId(sb.toString());
            student.setChinese(ToolUtil.verifyScores());
            student.setMath(ToolUtil.verifyScores());
            student.setEnglish(ToolUtil.verifyScores());
            student.setTotalScore(student.getChinese() + student.getMath() + student.getEnglish());
            student.setAverageScore(String.format("%.2f", student.getTotalScore() / 3));
            students.add(student);
            System.out.println("添加成功!");
            System.out.println("学生学号为:" + student.getId());
        }

    }

    //删除用户
    public void deleteUser(ArrayList<Teacher> teachers, ArrayList<Student> students, Scanner sc, String input) {
        String choice;
        if (Objects.equals(input, "1")) {
            System.out.println("请输入教师编号:");
            choice = sc.next();
            for (int i = 0; i < teachers.size(); i++) {
                if (Objects.equals(choice, teachers.get(i).getId())) {
                    System.out.println("再次确认是否删除该教师用户?");
                    System.out.println("是请输入'Y',否则输入任一字符");
                    choice = sc.next();
                    if (Objects.equals(choice, "Y")) {
                        teachers.remove(i);
                        System.out.println("删除成功!");
                        break;
                    }
                    break;
                }
            }
        } else if (Objects.equals(input, "2")) {
            System.out.println("请输入学生学号:");
            choice = sc.next();
            for (int i = 0; i < students.size(); i++) {
                if (Objects.equals(choice, students.get(i).getId())) {
                    System.out.println("再次确认是否删除该学生用户?");
                    System.out.println("是请输入'Y',否则输入任一字符");
                    choice = sc.next();
                    if (Objects.equals(choice, "Y")) {
                        students.remove(i);
                        System.out.println("删除成功!");
                        break;
                    }
                    break;
                }
            }
        }
    }

    //修改用户信息
    public void modifyInformation(ArrayList<Teacher> teachers, ArrayList<Student> students, Scanner sc, String input) {
        String choice;
        int judgment = -1;
        while (true) {
            if (Objects.equals(input, "1")) {
                System.out.println("请输入教师编号");
                choice = sc.next();
                for (int i = 0; i < teachers.size(); i++) {
                    if (Objects.equals(choice, teachers.get(i).getId())) {
                        judgment = i;
                    }
                }
                if (judgment == -1) {
                    System.out.println("你输入的教师编号不存在!");
                    break;
                }
            } else if (Objects.equals(input, "2")) {
                System.out.println("请输入学号:");
                choice = sc.next();
                for (int i = 0; i < students.size(); i++) {
                    if (Objects.equals(choice, students.get(i).getId())) {
                        judgment = i;
                    }
                }
                if (judgment == -1) {
                    System.out.println("你输入的学号不存在!");
                    break;
                }
            }
            while (true) {
                System.out.println("---------------------------------" +
                        "--------------------------------------");
                System.out.println("1 姓名");
                System.out.println("2 性别");
                System.out.println("3 年龄");
                System.out.println("4 手机号");
                System.out.println("5 电子邮箱");
                System.out.println("6 现居地");
                if (Objects.equals(input, "1")) {
                    System.out.println("7 所授科目");
                    System.out.println("8 返回上级菜单");
                    System.out.println("请选择你要执行的操作:");
                    choice = sc.next();
                    if (Objects.equals(choice, "8")) {
                        break;
                    }
                    switch (choice) {
                        case "1":
                            System.out.println("请输入新姓名:");
                            choice = sc.next();
                            if (ToolUtil.verifyChinese(choice)) {
                                teachers.get(judgment).setName(choice);
                                System.out.println("修改成功!");
                            } else {
                                System.out.println("修改失败,请输入汉字!");
                            }
                            break;
                        case "2":
                            System.out.println("请输入新性别:");
                            choice = sc.next();
                            if (ToolUtil.verifySex(choice)) {
                                teachers.get(judgment).setSex(choice);
                                System.out.println("修改成功!");
                            } else {
                                System.out.println("修改失败,请输入正确的性别!");
                            }
                            break;
                        case "3":
                            System.out.println("请输入新年龄:");
                            choice = sc.next();
                            if (ToolUtil.verifyNumber(choice)) {
                                teachers.get(judgment).setAge(choice);
                                System.out.println("修改成功!");
                            } else {
                                System.out.println("修改失败,请输入数字!");
                            }
                            break;
                        case "4":
                            System.out.println("请输入新手机号:");
                            choice = sc.next();
                            if (ToolUtil.verifyPhone(choice)) {
                                teachers.get(judgment).setPhone(choice);
                                System.out.println("修改成功!");
                            } else {
                                System.out.println("修改失败,请输入正确的手机号格式!");
                            }
                            break;
                        case "5":
                            System.out.println("请输入新电子邮箱:");
                            choice = sc.next();
                            if (ToolUtil.verifyEmail(choice)) {
                                teachers.get(judgment).setEmail(choice);
                                System.out.println("修改成功!");
                            } else {
                                System.out.println("修改失败,请输入正确的邮箱格式!");
                            }
                            break;
                        case "6":
                            System.out.println("请输入新现居地:");
                            choice = sc.next();
                            if (ToolUtil.verifyChinese(choice)) {
                                teachers.get(judgment).setAddress(choice);
                                System.out.println("修改成功!");
                            } else {
                                System.out.println("修改失败,请输入汉字!");
                            }
                            break;
                        case "7":
                            System.out.println("请输入新所授科目:");
                            choice = sc.next();
                            if (ToolUtil.verifyChinese(choice)) {
                                teachers.get(judgment).setSubject(choice);
                                System.out.println("修改成功!");
                            } else {
                                System.out.println("修改失败,请输入汉字!");
                            }
                            break;
                        default:
                            System.out.println("请输入正确的选项编号!");
                    }
                } else if (Objects.equals(input, "2")) {
                    System.out.println("7 返回上级菜单");
                    System.out.println("请选择你要执行的操作:");
                    choice = sc.next();
                    if (Objects.equals(choice, "7")) {
                        break;
                    }
                    switch (choice) {
                        case "1":
                            System.out.println("请输入新姓名:");
                            choice = sc.next();
                            if (ToolUtil.verifyChinese(choice)) {
                                students.get(judgment).setName(choice);
                                System.out.println("修改成功!");
                            } else {
                                System.out.println("修改失败,请输入汉字!");
                            }
                            break;
                        case "2":
                            System.out.println("请输入新性别:");
                            choice = sc.next();
                            if (ToolUtil.verifySex(choice)) {
                                students.get(judgment).setSex(choice);
                                System.out.println("修改成功!");
                            } else {
                                System.out.println("修改失败,请输入正确的性别!");
                            }
                            break;
                        case "3":
                            System.out.println("请输入新年龄:");
                            choice = sc.next();
                            if (ToolUtil.verifyNumber(choice)) {
                                students.get(judgment).setAge(choice);
                                System.out.println("修改成功!");
                            } else {
                                System.out.println("修改失败,请输入数字");
                            }
                            break;
                        case "4":
                            System.out.println("请输入新手机号:");
                            choice = sc.next();
                            if (ToolUtil.verifyPhone(choice)) {
                                students.get(judgment).setPhone(choice);
                                System.out.println("修改成功!");
                            } else {
                                System.out.println("修改失败,请输入正确的手机号格式!");
                            }
                            break;
                        case "5":
                            System.out.println("请输入新电子邮箱:");
                            choice = sc.next();
                            if (ToolUtil.verifyEmail(choice)) {
                                students.get(judgment).setEmail(choice);
                                System.out.println("修改成功!");
                            } else {
                                System.out.println("修改失败,请输入正确的邮箱格式!");
                            }
                            break;
                        case "6":
                            System.out.println("请输入新现居地:");
                            choice = sc.next();
                            if (ToolUtil.verifyChinese(choice)) {
                                students.get(judgment).setAddress(choice);
                                System.out.println("修改成功!");
                            } else {
                                System.out.println("修改失败,请输入汉字!");
                            }
                            break;
                        default:
                            System.out.println("请输入正确的选项编号");

                    }
                }

            }
            break;
        }

    }

    //用户信息查询
    public void informationInquiry(ArrayList<Teacher> teachers, ArrayList<Student> students, Scanner sc, String input) {
        String choice;
        while (true) {
            System.out.println("1 查询所有");
            System.out.println("2 单独查询");
            System.out.println("3 返回上级菜单");
            System.out.println("请选择你要执行的操作:");
            choice = sc.next();
            if (Objects.equals(choice, "3")) {
                break;
            }
            switch (choice) {
                case "1":
                    if (Objects.equals(input, "1")) {
                        System.out.println("---------------------------------" +
                                "--------------------------------------");
                        System.out.println("编号\t\t姓名\t\t性别\t\t年龄\t\t手机号\t\t\t电子邮件\t\t\t\t" +
                                "现居住地\t\t\t所授科目");
                        for (int i = 0; i < teachers.size(); i++) {
                            System.out.println(teachers.get(i).getId() + "\t\t" +
                                    teachers.get(i).getName() + "\t\t" +
                                    teachers.get(i).getSex() + "\t\t\t" +
                                    teachers.get(i).getAge() + "\t\t\t" +
                                    teachers.get(i).getPhone() + "\t\t" +
                                    teachers.get(i).getEmail() + "\t\t" +
                                    teachers.get(i).getAddress() + "\t\t" +
                                    teachers.get(i).getSubject());
                        }
                        System.out.println("查询成功!");
                        System.out.println("---------------------------------" +
                                "--------------------------------------");
                    } else if (Objects.equals(input, "2")) {
                        System.out.println("---------------------------------" +
                                "--------------------------------------");
                        System.out.println("学号\t\t\t姓名\t\t性别\t\t年龄\t\t手机号\t\t\t电子邮件\t\t\t\t现居住地");
                        for (int i = 0; i < students.size(); i++) {
                            System.out.println(students.get(i).getId() + "\t\t" +
                                    students.get(i).getName() + "\t\t" +
                                    students.get(i).getSex() + "\t\t\t" +
                                    students.get(i).getAge() + "\t\t\t" +
                                    students.get(i).getPhone() + "\t\t" +
                                    students.get(i).getEmail() + "\t\t" +
                                    students.get(i).getAddress());
                        }
                        System.out.println("查询成功!");
                        System.out.println("---------------------------------" +
                                "--------------------------------------");
                    }
                    break;
                case "2":
                    if (Objects.equals(input, "1")) {
                        int index = -1;
                        System.out.println("请输入教师编号或姓名");
                        choice = sc.next();
                        System.out.println("---------------------------------" +
                                "--------------------------------------");
                        System.out.println("编号\t\t姓名\t\t性别\t\t年龄\t\t手机号\t\t\t电子邮件\t\t\t\t" +
                                "现居住地\t\t\t所授科目");
                        for (int i = 0; i < teachers.size(); i++) {
                            if (Objects.equals(choice, teachers.get(i).getId()) ||
                                    Objects.equals(choice, teachers.get(i).getName())) {
                                System.out.println(teachers.get(i).getId() + "\t\t" +
                                        teachers.get(i).getName() + "\t\t" +
                                        teachers.get(i).getSex() + "\t\t\t" +
                                        teachers.get(i).getAge() + "\t\t\t" +
                                        teachers.get(i).getPhone() + "\t\t" +
                                        teachers.get(i).getEmail() + "\t\t" +
                                        teachers.get(i).getAddress() + "\t\t" +
                                        teachers.get(i).getSubject());
                                index = i;
                            }
                        }
                        if (index == -1) {
                            System.out.println("查询失败,没有该教师用户!");
                        } else {
                            System.out.println("查询成功!");
                        }
                    } else if (Objects.equals(input, "2")) {
                        int index = -1;
                        System.out.println("请输入学号或姓名:");
                        choice = sc.next();
                        System.out.println("---------------------------------" +
                                "--------------------------------------");
                        System.out.println("学号\t\t\t姓名\t\t性别\t\t年龄\t\t手机号\t\t\t电子邮件\t\t\t\t现居住地");
                        for (int i = 0; i < students.size(); i++) {
                            if (Objects.equals(choice, students.get(i).getId()) ||
                                    Objects.equals(choice, students.get(i).getName())) {
                                System.out.println(students.get(i).getId() + "\t\t" +
                                        students.get(i).getName() + "\t\t" +
                                        students.get(i).getSex() + "\t\t\t" +
                                        students.get(i).getAge() + "\t\t\t" +
                                        students.get(i).getPhone() + "\t\t" +
                                        students.get(i).getEmail() + "\t\t" +
                                        students.get(i).getAddress());
                                index = i;
                            }
                        }
                        if (index == -1) {
                            System.out.println("查询失败,没有该学生用户!");
                        } else {
                            System.out.println("查询成功!");
                        }
                    }
                    break;
                default:
                    System.out.println("请输入正确的选项编号!");
                    break;
            }
        }
    }

    //查询成绩
    public void queryGrade(ArrayList<Student> students, Scanner sc, String input) {
        String choice = null;
        String choice1 = null;
        double[] arr = new double[students.size()];
        if (Objects.equals(input, "1")) {
            while (true) {
                System.out.println("---------------------------------" +
                        "--------------------------------------");
                System.out.println("1 升序展示");
                System.out.println("2 降序展示");
                System.out.println("3 返回上一级");
                System.out.println("请选择你要执行的操作:");
                choice1 = sc.next();
                if (Objects.equals(choice1, "3")) {
                    break;
                }
                switch (choice1) {
                    case "1", "2":
                        System.out.println("---------------------------------" +
                                "--------------------------------------");
                        showMethod(students, arr, choice, choice1, input);
                        System.out.println("查询成功!");
                        break;
                    default:
                        System.out.println("请输入正确的选项编号!");
                }
            }
        } else if (Objects.equals(input, "2")) {
            System.out.println("请输入你要查询的科目:");
            choice = sc.next();
            if (Objects.equals(choice, "语文") || Objects.equals(choice, "数学") || Objects.equals(choice, "英语")) {
                while (true) {
                    System.out.println("---------------------------------" +
                            "--------------------------------------");
                    System.out.println("1 升序查询");
                    System.out.println("2 降序查询");
                    System.out.println("3 返回上级菜单");
                    System.out.println("请选择你要执行的操作:");
                    choice1 = sc.next();
                    if (Objects.equals(choice1, "3")) {
                        break;
                    }
                    switch (choice1) {
                        case "1", "2":
                            System.out.println("---------------------------------" +
                                    "--------------------------------------");
                            showMethod(students, arr, choice, choice1, input);
                            System.out.println("查询成功!");
                            break;
                        default:
                            System.out.println("请输入正确的选项编号!");
                            break;
                    }
                }
            } else {
                System.out.println("抱歉,没有" + choice + "这个科目!");
            }
        } else if (Objects.equals(input, "3")) {
            int index = -1;
            System.out.println("请输入学生学号或姓名:");
            choice = sc.next();
            System.out.println("---------------------------------" +
                    "--------------------------------------");
            System.out.println("学号\t\t\t姓名\t\t语文\t\t数学\t\t英语\t\t平均分\t\t总分");
            for (int i = 0; i < students.size(); i++) {
                if (Objects.equals(choice, students.get(i).getId()) || Objects.equals(choice, students.get(i).getName())) {
                    System.out.println(students.get(i).getId() + "\t\t" +
                            students.get(i).getName() + "\t\t" +
                            students.get(i).getChinese() + "\t\t" +
                            students.get(i).getMath() + "\t\t" +
                            students.get(i).getEnglish() + "\t\t" +
                            students.get(i).getAverageScore() + "\t\t" +
                            students.get(i).getTotalScore());
                    index = i;
                }
            }
            if (index == -1) {
                System.out.println("查询失败,没有该学生成绩");
                System.out.println("---------------------------------" +
                        "--------------------------------------");
            } else {
                System.out.println("查询成功!");
                System.out.println("---------------------------------" +
                        "--------------------------------------");
            }
        }
    }

    //展示方法
    public void showMethod(ArrayList<Student> students, double[] arr, String choice, String choice1, String input) {
        TeacherAndStudentOperation teacherAndStudentOperation = new TeacherAndStudentOperation();
        if (Objects.equals(input, "1")) {
            System.out.println("序号\t\t学号\t\t\t姓名\t\t语文\t\t数学\t\t英语\t\t平均分\t\t总分");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = students.get(i).getTotalScore();
            }
            ToolUtil.bubbleSorting(arr, choice1);
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (Objects.equals(arr[i], students.get(j).getTotalScore())) {
                        System.out.println(i + 1 + "\t\t" + students.get(j).getId() + "\t\t\t" +
                                students.get(j).getName() + "\t\t" +
                                students.get(j).getChinese() + "\t\t" +
                                students.get(j).getMath() + "\t\t" +
                                students.get(j).getEnglish() + "\t\t" +
                                students.get(j).getAverageScore() + "\t\t" +
                                students.get(j).getTotalScore());
                    }
                }

            }
        } else if (Objects.equals(input, "2")) {
            System.out.println("序号\t\t学号\t\t\t姓名\t\t" + choice + "成绩");
            teacherAndStudentOperation.showMethod(students, arr, choice, choice1);
        }
    }
}
