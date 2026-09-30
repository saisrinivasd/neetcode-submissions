class Twitter {

    private Map<Integer, List<Tweet>> tweets;
    private Map<Integer, Set<Integer>> following;
    private int sequenceNumber;

    public Twitter() {
        tweets = new HashMap<>();
        following = new HashMap<>();
        sequenceNumber = 1;
    }

    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> new ArrayList<>())
              .add(new Tweet(tweetId, userId, sequenceNumber++));
    }

    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<TweetCandidate> maxHeap =
            new PriorityQueue<>(
                (a, b) -> Integer.compare(
                    b.tweet.sequence,
                    a.tweet.sequence
                )
            );

        // User's own tweets + tweets from followed users
        Set<Integer> usersForFeed = new HashSet<>();

        usersForFeed.add(userId);

        Set<Integer> followedUsers = following.get(userId);
        if (followedUsers != null) {
            usersForFeed.addAll(followedUsers);
        }

        // Add the newest tweet from every relevant user
        for (int user : usersForFeed) {

            List<Tweet> userTweets = tweets.get(user);

            if (userTweets == null || userTweets.isEmpty()) {
                continue;
            }

            int index = userTweets.size() - 1;

            maxHeap.offer(
                new TweetCandidate(
                    userTweets.get(index),
                    index
                )
            );
        }

        List<Integer> feed = new ArrayList<>();

        // K-way merge: retrieve at most 10 newest tweets
        while (!maxHeap.isEmpty() && feed.size() < 10) {

            TweetCandidate candidate = maxHeap.poll();

            feed.add(candidate.tweet.tweetId);

            // Move to the next older tweet from the same user
            if (candidate.index > 0) {

                int nextIndex = candidate.index - 1;

                List<Tweet> userTweets =
                    tweets.get(candidate.tweet.userId);

                maxHeap.offer(
                    new TweetCandidate(
                        userTweets.get(nextIndex),
                        nextIndex
                    )
                );
            }
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {

        if (followerId == followeeId) {
            return;
        }

        following
            .computeIfAbsent(followerId, k -> new HashSet<>())
            .add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        Set<Integer> followedUsers = following.get(followerId);

        if (followedUsers != null) {
            followedUsers.remove(followeeId);
        }
    }

    static class Tweet {

        int tweetId;
        int userId;
        int sequence;

        Tweet(int tweetId, int userId, int sequence) {
            this.tweetId = tweetId;
            this.userId = userId;
            this.sequence = sequence;
        }
    }

    static class TweetCandidate {

        Tweet tweet;
        int index;

        TweetCandidate(Tweet tweet, int index) {
            this.tweet = tweet;
            this.index = index;
        }
    }
}