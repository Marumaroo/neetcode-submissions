class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        return sortString(s).equals(sortString(t));
    }

    private String sortString(String s) {
        return s.chars()
        .sorted()
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
    }
}
