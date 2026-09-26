class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> partitions = new ArrayList<>();
        List<String> partition = new ArrayList<>();
        palindromePartitions(s, 0, partition, partitions);
        return partitions;   
    }

    private void palindromePartitions(String s, int index, List<String> partition, List<List<String>> partitions) {
        if(index == s.length()) {
            partitions.add(new ArrayList<>(partition));
            return;
        }

        for(int i = index; i < s.length(); i++) {
            if(isPalindrome(s, index, i)) {
                partition.add(s.substring(index, i+1));
                palindromePartitions(s, i+1, partition, partitions);
                partition.remove(partition.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while(start <= end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
