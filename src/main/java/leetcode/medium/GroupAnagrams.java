package leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * group-anagrams/
 * <p>
 * <p>
 * 字母异位词分组
 * <p>
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class GroupAnagrams {

    public static void main(String[] args) {

        String[] param = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        new GroupAnagrams().groupAnagrams1(param);
    }


    /**
     * 1、对所有字母排序对比
     *
     * @param strs
     * @return
     */

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            if (map.get(sortedStr) == null) {
                List<String> resList = new ArrayList<>();
                resList.add(str);
                map.put(sortedStr, resList);
            } else {
                map.get(sortedStr).add(str);
            }
        }
        List<List<String>> resLists = new ArrayList<>();
        map.forEach((k, v) -> {
            resLists.add(v);
        });
        return resLists;
    }

    public List<List<String>> groupAnagrams1(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            int count[] = new int[26];
            Arrays.fill(count, 0);
            for (char c : chars) {
                count[c - 'a']++;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < count.length; i++) {
                stringBuilder.append("#");
                stringBuilder.append(count[i]);
            }
            String key = stringBuilder.toString();
            if (map.get(key) == null) {
                List<String> resList = new ArrayList<>();
                resList.add(str);
                map.put(key, resList);
            } else {
                map.get(key).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams11(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }


}
