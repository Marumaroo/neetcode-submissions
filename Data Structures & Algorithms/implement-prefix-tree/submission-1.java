class TreeNode {
    private TreeNode[] children = new TreeNode[26];
    private boolean endOfWord = false;

    TreeNode() { }

    public TreeNode insert(char c) {
        if (get(c) != null) {
            return get(c);
        }

        children[c - 'a'] = new TreeNode();
        return get(c);
    }

    public void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }

    public TreeNode get(Character c) {
        return children[c - 'a'];
    }

    public boolean isEndOfWord() {
        return endOfWord;
    }
}

class PrefixTree {
    private TreeNode root;

    public PrefixTree() {
        this.root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode current = root;
        for (char c : word.toCharArray()) {
            current = current.insert(c);
        }
        current.setEndOfWord(true);
    }

    public boolean search(String word) {
        TreeNode current = root;
        for (char c : word.toCharArray()) {
            current = current.get(c);

            if (current == null) return false;
        }

        return current.isEndOfWord();
    }

    public boolean startsWith(String prefix) {
        TreeNode current = root;

        for (char c : prefix.toCharArray()) {
            current = current.get(c);

            if (current == null) return false;
        }

        return true;
    }
}
