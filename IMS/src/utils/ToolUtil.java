package utils;

import java.util.Objects;
import java.util.Random;

public class ToolUtil {
    /*
     * 判断邮箱格式是否正确
     * */
    public static boolean verifyEmail(String email) {
        //正则表达式
        return email.matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
    }

    /*
     * 判断手机号格式是否正确
     * */
    public static boolean verifyPhone(String phone) {
        return phone.matches("^(13[0-9]|14[5|7]|15[0-9]" +
                "|18[0-9]|19[0-9])\\d{8}$");
    }

    /*
     * 判断字符串是否为汉字
     * */
    public static boolean verifyChinese(String chinese) {
        return chinese.matches("^[\\u4e00-\\u9fa5]*$");
    }

    /*
     * 判断是否是为数字
     * */
    public static boolean verifyNumber(String number) {
        return number.matches("^[0-9]*$");
    }

    /*
     * 判断性别是否输入是否正确
     * */
    public static boolean verifySex(String sex) {
        return Objects.equals(sex, "男") || Objects.equals(sex, "女");
    }

    /*
     * 随机10~100之间的整数
     * */
    public static int verifyScores() {
        Random r = new Random();
        return r.nextInt(91) + 10;
    }

    /*
     * 冒泡法排序
     * */
    public static void bubbleSorting(double[] arr, String input) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (Objects.equals(input, "1")) {
                    if (arr[j] > arr[j + 1]) {
                        double t = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = t;
                    }
                } else if (Objects.equals(input, "2")) {
                    if (arr[j] < arr[j + 1]) {
                        double t = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = t;
                    }
                }

            }
        }
    }
}
