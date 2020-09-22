package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangsenmu
 * @date 18/09/2020
 * <p>
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * <p>
 * 示例:
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 * <p>
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ImplementTriePrefixTree {
}


class TrieNode {

    char val;
    boolean isWord;
    TrieNode[] childs = new TrieNode[26];

    /**
     * Initialize your data structure here.
     */
    public TrieNode() {
    }

    public TrieNode(char c) {
        TrieNode trie = new TrieNode();
        trie.val = c;
    }
}

class Trie {

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
        root.val = ' ';
    }


    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode tn = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (tn.childs[c - 'a'] == null) {
                tn.childs[c - 'a'] = new TrieNode(c);
            }
            tn = tn.childs[c - 'a'];
        }
        tn.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode tn = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (tn.childs[c - 'a'] == null) {
                return false;
            }
            tn = tn.childs[c - 'a'];
        }
        return tn.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode tn = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (tn.childs[c - 'a'] == null) {
                return false;
            }
            tn = tn.childs[c - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */