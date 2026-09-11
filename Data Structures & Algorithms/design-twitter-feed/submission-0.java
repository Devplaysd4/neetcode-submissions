
class Twitter {

    class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    class TweetEntry {
        int userId;
        int index;
        Tweet tweet;

        TweetEntry(int userId, int index, Tweet tweet) {
            this.userId = userId;
            this.index = index;
            this.tweet = tweet;
        }
    }

    HashMap<Integer, List<Tweet>> tweets;
    HashMap<Integer, HashSet<Integer>> following;
    int time;

    public Twitter() {
        tweets = new HashMap<>();
        following = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        time++;

        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new ArrayList<>());
        }

        tweets.get(userId).add(new Tweet(tweetId, time));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();

        // User sees their own tweets
        // plus tweets from everyone they follow
        HashSet<Integer> users = new HashSet<>();
        users.add(userId);

        if (following.containsKey(userId)) {
            users.addAll(following.get(userId));
        }

        // Max-heap: newest tweet has highest priority
        PriorityQueue<TweetEntry> maxHeap =
            new PriorityQueue<>(
                (a, b) -> b.tweet.time - a.tweet.time
            );

        // Add newest tweet from every relevant user
        for (int id : users) {
            List<Tweet> list = tweets.get(id);

            if (list != null && !list.isEmpty()) {
                int index = list.size() - 1;

                maxHeap.add(
                    new TweetEntry(id, index, list.get(index))
                );
            }
        }

        // Get at most 10 newest tweets
        while (!maxHeap.isEmpty() && feed.size() < 10) {

            TweetEntry entry = maxHeap.poll();

            // Add the tweet ID to the feed
            feed.add(entry.tweet.tweetId);

            // Move backward in the same user's tweet list
            if (entry.index > 0) {
                List<Tweet> list = tweets.get(entry.userId);

                maxHeap.add(
                    new TweetEntry(
                        entry.userId,
                        entry.index - 1,
                        list.get(entry.index - 1)
                    )
                );
            }
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {
        if (!following.containsKey(followerId)) {
            following.put(followerId, new HashSet<>());
        }

        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}