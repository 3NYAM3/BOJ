package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ14426 {
    static int n, m;

    //노드 클래스
    static class TrieNode {
        Map<Character, TrieNode> children; //자식 노드
        boolean isEnd; //현재 노드가 단어의 끝인지

        TrieNode() {
            children = new HashMap<>();
            isEnd = false;
        }
    }

    //트라이 자료구조 구현
    static class Trie {
        TrieNode root;  //트라이의 루트노드

        Trie() {
            root = new TrieNode();
        }

        //단어를 트라이에 삽입
        public void insert(String word) {
            TrieNode cur = root;
            for (char ch : word.toCharArray()) {
                cur = cur.children.computeIfAbsent(ch, k -> new TrieNode());
            }
            cur.isEnd = true;
        }

        //주어진 접두사로 시작하는 단어가 트라이에 존재하는지 확인
        boolean startsWith(String prefix) {
            TrieNode node = searchPrefix(prefix);
            return node != null;
        }

        // 접두사에 해당하는 노드를 찾기
        TrieNode searchPrefix(String prefix) {
            TrieNode cur = root;
            for (char ch : prefix.toCharArray()) {
                TrieNode child = cur.children.get(ch);
                if (child == null) {
                    return null;
                }
                cur = child;
            }
            return cur;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Trie trie = new Trie();

        for (int i = 0; i < n; i++) {
            trie.insert(br.readLine());
        }

        int count = 0;

        for (int i = 0; i < m; i++) {
            String word = br.readLine();
            if (trie.startsWith(word)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
