import java.util.Scanner;

/**
 * 1、中文大写金额数字前应标明“人民币”字样。中文大写金额数字应用
 * 壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零、整等字样填写。
 *
 * 2、中文大写金额数字到“元”为止的，在“元”之后，应写“整字，
 * 如￥ 532.00应写成“人民币伍佰叁拾贰元整”。在”角“和”分“后面不写”整字。
 *
 * 3、阿拉伯数字中间有“0”时，中文大写要写“零”字，阿拉伯数字中间连续有几个“0”时，
 * 中文大写金额中间只写一个“零”字，如￥6007.14，应写成“人民币陆仟零柒元壹角肆分“。
 *
 *
 * @author haozhang
 * @date 20120/03/30
 */
public class Main {
    private static final String[] NUM = new String[] {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    private static final String[] UNIT = new String[]{"元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿"};
    private static final String[] DECIMAL_UNIT = new String[] {"角", "分"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] nums = s.split("\\.");

            //带小数
            if (s.contains(".")) {
                //整数部分为0
                if (nums[0].length() == 0 ||
                        (nums[0].length() == 1 && nums[0].charAt(0) == '0')) {
                    System.out.println("人名币" + decimalPart(nums[1]));
                    //整数部分不为0
                } else {
                    System.out.println("人名币" + integerPart(nums[0]) + decimalPart(nums[1]));
                }
                //不带小数
            } else {
                System.out.println("人名币" + integerPart(nums[0]) + "整");
            }
        }
    }

    /**
     * 处理整数部分
     * @param intPart
     * @return
     */
    public static String integerPart(String intPart) {
        StringBuilder sb = new StringBuilder();
        for (int i = intPart.length() - 1; i >= 0; i--) {
            int indexOfUnit = intPart.length() - 1 - i;
            sb.append(UNIT[indexOfUnit]);

            int indexOfNum = Integer.parseInt(intPart.substring(i, i + 1));
            sb.append(NUM[indexOfNum]);
        }

        if (sb.charAt(sb.length() - 1) == '壹' && sb.charAt(sb.length() - 2) == '拾') {
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.println(sb.toString());

        return sb.reverse().toString();
    }

    /**
     * 处理小数部分
     * @param deciPart
     * @return
     */
    private static String decimalPart(String deciPart) {
        StringBuilder sb = new StringBuilder();
        //为了解决 10   20
        for (int i = 0; i < deciPart.length(); i++) {
            int num = Integer.parseInt(deciPart.substring(i, i + 1));
            if (num == 0) {
                continue;
            }

            sb.append(NUM[num]);
            sb.append(DECIMAL_UNIT[i]);
        }
        return sb.toString();
    }
}
