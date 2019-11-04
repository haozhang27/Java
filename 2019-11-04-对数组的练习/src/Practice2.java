/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/04
 */
public class Practice2 {
    /**
     * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
     * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * @param height 给定的数组
     * @return 最大面积
     */
    public int maxArea(int[] height) {
        int ret = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            ret = Math.max(ret, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right --;
            }
        }

        return ret;
    }
}
