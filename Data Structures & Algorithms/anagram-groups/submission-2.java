class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            // Create frequency count array for the string
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            
            // Convert frequency array to a string key
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    key.append((char) ('a' + i)).append(count[i]);
                }
            }
            
            // Add string to the corresponding anagram group
            map.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(str);
        }
        
        return new ArrayList<>(map.values());
    }
}