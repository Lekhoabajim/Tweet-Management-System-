  
package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.TweetEntity;
import twitter4j.DirectMessage;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Stateless
@LocalBean
public class TweetsEJB {

	@PersistenceContext
	private EntityManager em;

	public TweetsEJB() {}

	
	public void addNew(TweetEntity tweet) {
		System.out.println("Adding Tweet");	
		em.persist(tweet);
		System.out.println("!!!!Added successfully!!!!");
	}

	public List<TweetEntity> getAllTweets() {
		System.out.println("!!!!Tweets!!!!");
		List<TweetEntity> tweets;
		tweets = em.createQuery("SELECT t FROM tweets_tbl t").getResultList();
		return tweets;
	}

	public void sendTweet(String message) {
		try {
			ConfigurationBuilder configBuilder = new ConfigurationBuilder();
			configBuilder.setDebugEnabled(true).setOAuthConsumerKey("AkG778DJ7xhHU5Atr89gfDWZ5")
					.setOAuthConsumerSecret("p7yTuyWpOycOaGztE1Z5OvHufoH7UZfsDBrZOsPtmqygMMWEhI")
					.setOAuthAccessToken("928565770161999872-tC0OY0jMJRVfyuJdwjt0exZfpoe0eoM")
					.setOAuthAccessTokenSecret("lSeUJDCQ6DhlMwrBruTh08pMS6ODMWJHYBFqQJTHIS1PV");
			TwitterFactory tweetfactory;
			tweetfactory  = new TwitterFactory(configBuilder.build());
			Twitter sender = tweetfactory.getInstance();
			DirectMessage response = sender.sendDirectMessage("@AdhLecturer", message);
			System.out.println("Sent: " + message + " to @" + response.getText());
		} catch (Exception e) {
			System.out.println("!!!!!!!!OOOPS didn't send successfully!!!!!!!");
		}
	}
}

