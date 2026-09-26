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

        //Better: HashMap for frequencies - O(n+m)/O(1)
        //Space O(1) because map can have max of 26 size
        // Map<Character, Integer> sMap = new HashMap<>();
        // Map<Character, Integer> tMap = new HashMap<>(); 
        // for(int i = 0; i < s.length(); i++) {
        //     sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        //     tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        // }
        // return sMap.equals(tMap);

        //Optimal: HashTable for count management - O(n)/O(1)
        //O(1) space for constant space
        int[] counts = new int[26];
        for(int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }

        for(int v : counts) {
            if (v > 0) {
                return false;
            }
        }
        return true;
    }
}
