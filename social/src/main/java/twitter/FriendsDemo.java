package twitter;

import java.util.List;

import org.springframework.social.twitter.TwitterTemplate;

public class FriendsDemo {

	public static void main(String[] args) {
		String username = "m_f_";
		TwitterTemplate twitterTemplate = new TwitterTemplate();
		List<String> friends = twitterTemplate.getFriends(username);
		for (String friend : friends) {
			System.out.println(friend);
		}
	}

}
