class Solution {
    public boolean isAnagram(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();

        for (char n: s.toCharArray()){
            map.put(n, map.getOrDefault(n,0)+ 1);
        }

        
        for (char n: t.toCharArray()){
            map.put(n, map.getOrDefault(n,0)- 1);
        }

         for (int value: map.values()){
            if (value != 0) return false;
        }
        return true;
    }
}
