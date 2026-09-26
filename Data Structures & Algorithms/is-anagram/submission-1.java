class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        //Brute: Sort and compare - O(nlogn + mlogm)/O(1)
        // char[] sArray = s.toCharArray();
        // char[] tArray = t.toCharArray();
        // Arrays.sort(sArray);
        // Arrays.sort(tArray);
        // return Arrays.equals(sArray, tArray);

        //Better: HashMap for frequencies

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>(); 
        for(int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        return sMap.equals(tMap);
    }
}
