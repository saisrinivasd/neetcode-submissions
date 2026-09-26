class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsMap = new HashMap<>();
        List<List<String>> anagramsGrouped = new ArrayList<>();
        for(String str : strs) {
            String key = getFrequencyString(str);
            anagramsMap.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(anagramsMap.values());
    }

    private String getFrequencyString(String str) {
        int[] freq = new int[26];
        for(int i = 0; i < str.length(); i++) {
            freq[str.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            sb.append(freq[i]);
            sb.append("#");
        }
        return sb.toString();
    }
}
