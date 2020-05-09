import java.util.*;

class User {
	
	int userId;
	List<Tweet> listOfTweets;
	int allUsers = 0;
	int tweetId = 0;
	
	public User() {
		this.userId = allUsers;
		listOfTweets = new ArrayList<Tweet>();
		allUsers++;
	}
	
	public void createTweet(User user, String tweet, int tweetId) {
		Tweet newTweet = new Tweet(tweet, listOfTweets.size());
		listOfTweets.add(newTweet);
	}
	
	public void deleteTweet(User user, int tweetId) {
		user.listOfTweets.remove(tweetId);
	}
	
}

class Tweet {
	
	String tweet = null;
	int tweetId = 0;
	
	public Tweet(String tweet, int tweetId) {
		this.tweet = tweet;
		this.tweetId = tweetId;
	}
	
	public int getTweetId() {
		return this.tweetId;
	}
}

public class Twitter {
	
	public static void main(String[] args) {
		
		User user1 = new User();
		user1.createTweet(user1,"first tweet", user1.listOfTweets.size());
		user1.createTweet(user1, "second tweet", user1.listOfTweets.size());
		System.out.println("first list");
		
		for(int i = 0; i < user1.listOfTweets.size(); i++) {
			System.out.println(user1.listOfTweets.get(i).tweet+", tweet id = "+user1.listOfTweets.get(i).tweetId);
		}
		System.out.println("\nsecond list");
		user1.deleteTweet(user1, 1);
		for(int i = 0; i < user1.listOfTweets.size(); i++) {
			System.out.println(user1.listOfTweets.get(i).tweet+", tweet id = "+user1.listOfTweets.get(i).tweetId);
		}
		user1.createTweet(user1, "third tweet", user1.listOfTweets.size());
		user1.createTweet(user1, "fourth tweet", user1.listOfTweets.size());
		user1.createTweet(user1, "fifth tweet", user1.listOfTweets.size());
		user1.createTweet(user1, "sixth tweet", user1.listOfTweets.size());
		System.out.println("\nthird list");
		for(int i = 0; i < user1.listOfTweets.size(); i++) {
			System.out.println(user1.listOfTweets.get(i).tweet+", tweet id = "+user1.listOfTweets.get(i).tweetId);
		}
		
		user1.deleteTweet(user1, 1);
		System.out.println("\nfourth list");
		for(int i = 0; i < user1.listOfTweets.size(); i++) {
			System.out.println(user1.listOfTweets.get(i).tweet+", tweet id = "+user1.listOfTweets.get(i).tweetId);
		}
		
		User user2 = new User();
		user2.createTweet(user2,"first user tweet", user2.listOfTweets.size());
		user2.createTweet(user2, "second user tweet", user2.listOfTweets.size());
		System.out.println("\nsecond user list");
		
		for(int i = 0; i < user2.listOfTweets.size(); i++) {
			System.out.println(user2.listOfTweets.get(i).tweet+", tweet id = "+user2.listOfTweets.get(i).tweetId);
		}
	}
    
}

