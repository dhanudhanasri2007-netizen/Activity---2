class Trie {
    private Trie[] children = new Trie[26];
    private boolean isEnd;

    public Trie() {
    }

    public void insert(String word) {
        Trie node = this;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }

            node = node.children[index];
        }

        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = find(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private Trie find(String text) {
        Trie node = this;

        for (char c : text.toCharArray()) {
            int index = c - 'a';

            if (index < 0 || index >= 26
                    || node.children[index] == null) {
                return null;
            }

            node = node.children[index];
        }

        return node;
    }
}
