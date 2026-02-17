class Solution {

    public void combination(String digits, int i, List<String> ans, String current,Map<Character, String> map) {

        if (i == digits.length()) {
            ans.add(current);
            return;
        }

        String letters = map.get(digits.charAt(i));

        for (char ch : letters.toCharArray()) {
            combination(digits, i + 1, ans, current + ch, map);
        }
    }

    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();

        if (digits == null || digits.length() == 0)
            return ans;

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        combination(digits, 0, ans, "", map);

        return ans;
    }
}