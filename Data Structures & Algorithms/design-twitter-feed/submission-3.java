class Twitter {

    private int time = 0;

    private Map<Integer, Set<Integer>> following;
    private Map<Integer, List<Tweet>> tweets;

    class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    // Node giúp Heap biết:
    // tweet này của user nào
    // và nó nằm ở index nào
    class Node {
        int userId;
        int index;
        Tweet tweet;

        Node(int userId, int index, Tweet tweet) {
            this.userId = userId;
            this.index = index;
            this.tweet = tweet;
        }
    }

    public Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {

        time++;

        tweets.putIfAbsent(userId, new ArrayList<>());

        tweets.get(userId).add(
            new Tweet(tweetId, time)
        );
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> result = new ArrayList<>();

        PriorityQueue<Node> maxHeap =
            new PriorityQueue<>(
                (a, b) ->
                    Integer.compare(
                        b.tweet.time,
                        a.tweet.time
                    )
            );

        // User's own tweets
        if (tweets.containsKey(userId)) {

            List<Tweet> userTweets = tweets.get(userId);

            if (!userTweets.isEmpty()) {

                int lastIndex = userTweets.size() - 1;

                maxHeap.add(
                    new Node(
                        userId,
                        lastIndex,
                        userTweets.get(lastIndex)
                    )
                );
            }
        }

        // Tweets from people user follows
        if (following.containsKey(userId)) {

            for (int followeeId : following.get(userId)) {

                if (tweets.containsKey(followeeId)) {

                    List<Tweet> followeeTweets =
                        tweets.get(followeeId);

                    if (!followeeTweets.isEmpty()) {

                        int lastIndex =
                            followeeTweets.size() - 1;

                        maxHeap.add(
                            new Node(
                                followeeId,
                                lastIndex,
                                followeeTweets.get(lastIndex)
                            )
                        );
                    }
                }
            }
        }

        // Get newest 10 tweets
        while (!maxHeap.isEmpty() && result.size() < 10) {

            // 1. Lấy tweet mới nhất
            Node current = maxHeap.poll();

            // 2. Đưa tweetId vào result
            result.add(current.tweet.tweetId);

            // 3. Đi tới tweet cũ kế tiếp
            int nextIndex = current.index - 1;

            // 4. Nếu user đó còn tweet
            if (nextIndex >= 0) {

                List<Tweet> userTweets =
                    tweets.get(current.userId);

                // 5. Đưa tweet kế tiếp vào Heap
                maxHeap.add(
                    new Node(
                        current.userId,
                        nextIndex,
                        userTweets.get(nextIndex)
                    )
                );
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {

        following.putIfAbsent(
            followerId,
            new HashSet<>()
        );

        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}