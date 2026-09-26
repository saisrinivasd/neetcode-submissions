class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsMap = new HashMap<>();
        for(String str : strs) {
            int[] freq = new int[26];
            for(int i = 0; i < str.length(); i++) {
                freq[str.charAt(i) - 'a']++;
            }
            StringBuilder key = new StringBuilder();
            for(int i = 0; i < 26; i++) {
                key.append(freq[i]).append("#");
            }
            anagramsMap.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(anagramsMap.values());
    }
}
