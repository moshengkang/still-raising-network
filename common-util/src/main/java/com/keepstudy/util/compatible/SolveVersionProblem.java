package com.keepstudy.util.compatible;

/**
 * @author: 莫升康
 * @e-mail: 1634414600@qq.com
 * @Date: 2020/4/8 13:56
 * @Description: 兼容版本问题
 */
public class SolveVersionProblem {

    /**
     * 小于最新版本则返回false(老版本),否则返回true(新版本)
     * @param currentVersion app当前版本（老版本）
     * @param lastVersion 即将发布的版本（新版本）
     * @return
     */
    public static boolean checkVersion(String currentVersion, String lastVersion) {
        int instr = 0;
        //当前手机版本如果是测试环境后缀为sit,如2.0.3sit,所以判断时需截取
        for (int i = currentVersion.length(); --i >= 0; ) {
            if (Character.isDigit(currentVersion.charAt(i))) {
                instr = i;
                break;
            }
        }
        String currentVersionStr = currentVersion.substring(0, instr + 1);
        /**
         * 字符串前面部分的每个字符完全一样，返回：后面两个字符串长度差；
         * 字符串前面部分的每个字符存在不一样，返回：出现不一样的字符 ASCII 码的差值。
         * 字符串的每个字符完全一样，返回 0；
         */
        int compareValue = currentVersionStr.compareTo(lastVersion);
        if (compareValue >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(checkVersion("3.1.9", "3.2.1"));
    }
}
