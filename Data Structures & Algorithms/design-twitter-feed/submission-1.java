class Twitter {
    private static int FEED_LIMIT = 10;

    private Map<Integer, Set<Integer>> following;
    private Map<Integer, List<int[]>> tweetsByUser;
    private int timestamp;

    public Twitter() {
        this.tweetsByUser = new HashMap<>();
        this.following = new HashMap<>();
        this.timestamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetsByUser.computeIfAbsent(userId, v -> new ArrayList<>())
            .add(new int[] { timestamp++, tweetId });
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> feed = new PriorityQueue<>((a,b) -> b[0] - a[0]);

        Set<Integer> toProcess = following.getOrDefault(userId, new HashSet<>());
        toProcess.add(userId);

        for (int id : toProcess) {
            List<int[]> tweets = tweetsByUser.get(id);

            if (tweets != null && !tweets.isEmpty()) {
                int latestIdx = tweets.size() - 1;
                feed.add(new int[] { tweets.get(latestIdx)[0], id, latestIdx });
            }
        }

        List<Integer> tweets = new ArrayList<>();

        while (!feed.isEmpty() && tweets.size() < FEED_LIMIT) {
            int[] curr = feed.poll();
            int time = curr[0], id = curr[1], lastestIdx = curr[2];

            tweets.add(tweetsByUser.get(id).get(lastestIdx)[1]);

            if (lastestIdx > 0) {
                feed.add(new int[] { tweetsByUser.get(id).get(lastestIdx - 1)[0], id, lastestIdx - 1 });
            }
        }

        return tweets;
    }
    
    public void follow(int followerId, int followeeId) {
        following.computeIfAbsent(followerId, v -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        following.computeIfAbsent(followerId, v -> new HashSet<>()).remove(followeeId);
    }
}
