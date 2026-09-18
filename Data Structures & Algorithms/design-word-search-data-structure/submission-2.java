class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}

class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
        }

        curr.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }


    private boolean dfs(TrieNode curr, String word, int index){

        // base case
        if(index == word.length()){
            return curr.isEnd;
        }


        char c = word.charAt(index);

        //normal character

        if(c != '.'){
            int i = c - 'a';

            if(curr.children[i] == null){
                return false;
            }

            return dfs(curr.children[i], word, index + 1);
        }


        // if it is '.'
        for (TrieNode child : curr.children){
            if(child != null){
                 if (dfs(child, word, index + 1)) {
                    return true;
                }
            }
        }

        return false;
    }
}
