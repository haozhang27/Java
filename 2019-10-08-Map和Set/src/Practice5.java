
import java.util.*;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/08
 */
public class Practice5 {
    /**
     * 比较器，用来比较 o1 和 o2 的大小
     */
    public static class StringComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }

    /**
     * 求出每个单词所对应的出现次数  例如 i => 2
     * @param words 要求每个单词出现次数的数组
     * @return 求出之后 每个单词和出现次数所对应的键值对
     */
    Map<String, Integer> count(String[] words) {
        Map<String, Integer> wordToCount = new HashMap<>(16);
        for (String word : words) {
            int c = wordToCount.getOrDefault(word, 0);
            wordToCount.put(word, c + 1);
        }

        return wordToCount;
    }

    /**
     *把出现次数一样的单词放入一个数组，然后让数组和这个出现的次数形成映射
     * @param wordToCount 单词和出现次数的键值对
     * @return 出现次数 和 单词数组 形成的键值对
     */
    Map<Integer, List<String>> remap(Map<String, Integer> wordToCount) {
        Map<Integer, List<String>> countToWordList = new HashMap<>(16);
        for (Map.Entry<String, Integer> e : wordToCount.entrySet()) {
            String word = e.getKey();
            int count = e.getValue();
            List<String> wordList = countToWordList.get(count);
            if (wordList == null) {
                wordList = new ArrayList<>();
                countToWordList.put(count, wordList);
            }
            wordList.add(word);
        }
        return countToWordList;
    }

    /**
     * 寻找 前 k 个出现次数最多的单词，并且按照单词首字母顺序输出
     * @param words 要求的单词数组
     * @param k 前 k 个
     * @return 求出的单词数组
     */
    public List<String> topKfrequent(String[] words, int k) {
        Map<String, Integer> wordToCount = count(words);
        Map<Integer, List<String>> countToWorldList = remap(wordToCount);

        //目的是将所有出现次数都放到一个 int[] 数组中
        Set<Integer> keys = countToWorldList.keySet();
        int[] counts = new int[keys.size()];
        int i = 0;
        for (int key : keys) {
            counts[i++] = key;
        }

        Arrays.sort(counts);

        //录取名单
        List<String> result = new ArrayList<>();

        //已经录取人数
        int j = 0;

        //当前选择的分数，因为是从小到大排列，所以要反过来
        int index = counts.length - 1;

        //为了排序 String List 用
        Comparator<String> comparator = new StringComparator();
        while (j < k) {
            //得到最大分
            int c = counts[index--];

            //获取当前考 c 分的人数
            List<String> wordList = countToWorldList.get(c);

            //人按字母排序
            wordList.sort(comparator);
            if (wordList.size() <= k - j) {
                //如果当前分数的人数 <= 还差的人数
                result.addAll(wordList);
                j += wordList.size();
            } else {
                //否则，选择前 k - j 个
                result.addAll(wordList.subList(0, k - j));
                j = k;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String[] words = {
                "i", "love", "java",
                "i", "love", "coding"
        };
        List<String> r = new Practice5().topKfrequent(words, 3);
        System.out.println(r);
    }
}
