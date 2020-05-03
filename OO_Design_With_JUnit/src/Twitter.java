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
	
	public int getUserId() {
		return this.userId;
	}
	
	public List<Tweet> returnUserTweets() {
		return this.listOfTweets;
	}
	
	public void createTweet(User user, String tweet, int tweetId) {
		Tweet newTweet = new Tweet(tweet, listOfTweets.size()+1);
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
	}
    
}

