package twitter;

import org.springframework.social.twitter.SearchResults;
import org.springframework.social.twitter.Tweet;
import org.springframework.social.twitter.TwitterTemplate;

public class SearchDemo {

	public static void main(String[] args) {
		TwitterTemplate template = new TwitterTemplate();
		SearchResults results = template.search("#springintegration");
		for (Tweet tweet : results.getTweets()) {
			System.out.println(tweet.getFromUser() + ": " + tweet.getText());
		}
	}

}
