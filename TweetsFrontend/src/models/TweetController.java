package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import entities.TweetEntity;
import services.TweetsEJB;

@ManagedBean(name = "tweetController")
@SessionScoped
public class TweetController {

	@EJB
	private TweetsEJB tweetsEJB;
	
	@ManagedProperty(value="#{tweet}")
	public TweetModel tweet;
	
	public TweetController() {
		
	}
	
	@PostConstruct
	public void init() {
		tweet = new TweetModel();
	}
	
	public void postTweet() {
		System.out.print("uploading tweet");
		tweetsEJB.addNew(mapTweetToEntity(tweet));
		System.out.print(tweet);
	}
	
	public List<TweetModel> getAllTweets()
	{
		System.out.print("get all tweets");
		List<TweetEntity> tweetsEntites = tweetsEJB.getAllTweets();
		return mapTweetsToModel(tweetsEntites);
	}
	
	private TweetEntity mapTweetToEntity(TweetModel tweet) {
		TweetEntity tt = new TweetEntity();
		tt.setTweetBody(tweet.getTweetBody());
		tt.setTimestamp(new Date());
		return tt;
	}
	
	private List<TweetModel> mapTweetsToModel(List<TweetEntity> entities) {
		
		List<TweetModel> tweets = new ArrayList<TweetModel>();
		
		if(entities.isEmpty()) return tweets; 
				
		for (TweetEntity tweetEntity : entities) {
			TweetModel tweet = new TweetModel(tweetEntity.getTweetBody(), tweetEntity.getTimestamp());
			tweets.add(tweet);
		}
		return tweets;
	}

	public TweetModel getTweet() {
		return tweet;
	}

	public void setTweet(TweetModel tweet) {
		this.tweet = tweet;
	}
}
