class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(map.containsKey(curr)) {
                if(stack.isEmpty() || stack.pop() != map.get(curr)) {
                    return false;
                }
            } else {
                stack.push(curr);
            }
        }
        return stack.isEmpty() ? true : false;
    }
}
