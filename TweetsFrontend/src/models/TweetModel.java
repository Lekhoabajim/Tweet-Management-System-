package models;

import java.util.Date;

public class TweetModel {
	public Long Id;
	public String tweetBody;
	public Date timestamp;

	public TweetModel () {}
	
	public TweetModel(String tweetBody, Date timestamp) {
		this.tweetBody = tweetBody;
		this.timestamp = timestamp;
	}
	
	public Long getId() {
		return Id;
	}

	public String getTweetBody() {
		return tweetBody;
	}
	
	public void setTweetBody(String tweetBody) {
		this.tweetBody = tweetBody;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}