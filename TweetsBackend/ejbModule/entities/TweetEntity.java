package entities;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "tweets_tbl")
public class TweetEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long Id;
	public String tweetBody;
	public Date timestamp;
	
	public TweetEntity() {
		super();
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
