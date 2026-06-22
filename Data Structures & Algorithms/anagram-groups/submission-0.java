class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> groups = new HashMap<>();

        for (String s : strs) {
            String key = sortString(s);
            
            if (groups.containsKey(key)) {
                groups.get(key).add(s);
            } else {
                ArrayList<String> group = new ArrayList<>();
                group.add(s);
                groups.put(key, group);
            }
        }

        return groups.values()
        .stream()
        .collect(Collectors.toCollection(ArrayList::new));
    }

    private String sortString(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);

        return new String(c);
    }
}
