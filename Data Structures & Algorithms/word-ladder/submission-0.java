class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // 1. Nếu endWord không có trong list → không thể tới được
        if (!wordList.contains(endWord)) {
            return 0;
        }

        // 2. Đưa tất cả words vào Set để kiểm tra nhanh
        Set<String> words = new HashSet<>(wordList);

        // 3. BFS
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        // beginWord đã được sử dụng
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            // Xử lý tất cả words trong cùng một level
            for (int i = 0; i < size; i++) {

                String word = queue.poll();

                // Thử thay từng character
                for (int j = 0; j < word.length(); j++) {

                    char[] chars = word.toCharArray();

                    // Thử a -> z
                    for (char c = 'a'; c <= 'z'; c++) {

                        chars[j] = c;
                        String nextWord = new String(chars);

                        // Tìm thấy endWord
                        if (nextWord.equals(endWord)) {
                            return level + 1;
                        }

                        // Word hợp lệ và chưa đi
                        if (words.contains(nextWord) && !visited.contains(nextWord)) {
                            visited.add(nextWord);
                            queue.offer(nextWord);
                        }
                    }
                }
            }

            level++;
        }

        return 0;
    }
}