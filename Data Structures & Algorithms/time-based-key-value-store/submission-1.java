class TimeMap {

    private Map<String, List<Pair<Integer, String>>> store;

    public TimeMap() {
        this.store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        store.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!store.containsKey(key)) {
            return "";
        }

        List<Pair<Integer, String>> values = store.get(key);

        int start = 0, end = values.size() - 1;
        int resultIndex = -1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);

            if (values.get(mid).getKey() <= timestamp) {
                resultIndex = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return resultIndex != -1 ? values.get(resultIndex).getValue() : "";
    }
}
