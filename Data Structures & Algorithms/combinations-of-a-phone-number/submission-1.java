class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        StringBuilder cur = new StringBuilder();

        // edge case
        if (digits.length() == 0) {
            return res;
        }

        String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        backtrack(0, digits, phone, cur, res);

        return res;
    }


    private void backtrack(int i, String digits, String[] phone, StringBuilder cur, List<String> res){
        // base case
        if(i == digits.length()){
            res.add(cur.toString());
            return;
        }

        //get letter form curent digits
        int digit = digits.charAt(i) - '0'; //cause its integer
        String letters = phone[digit];

       for(char letter : letters.toCharArray()){
        cur.append(letter);
        backtrack(i + 1, digits, phone, cur, res);
        cur.deleteCharAt(cur.length() - 1);
       }
    }
}
