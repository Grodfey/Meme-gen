import java.util.ArrayList;
import java.util.*; 
/**
 * Homework 2
 * Tho Vu, thv7pas
 * 
 */

public class User implements Comparable<User>{
 
    /**
     * Stores the username of the person
     */
	private String userName;
	
	/**
	 * Stores an array of memes that were created
	 */
	private ArrayList<Meme> memesCreated;
	
	/**
     * Stores an array of memes that were viewed
     */
	private TreeSet<Meme> memesViewed;
	
	/**
	 * class constructor
	 */
	public User(String userName){
	this.userName = userName;
    this.memesCreated = new ArrayList<Meme>();
    this.memesViewed = new TreeSet<Meme>();
	
	}
	
	/*
	 * Default constructor
	 */
	public User() {
	    userName = "";
	    memesCreated = new ArrayList<Meme>();
	    memesViewed = new TreeSet<Meme>();
	}
	
	//compare method
	@Override
	public int compareTo(User u) {
	 
	    int firstSort = userName.compareTo(u.userName);
        if(firstSort != 0) {
            return firstSort;
        }
        int secondSort = Integer.compare(getMemesCreated().size(),(u.getMemesCreated().size()));
            if(secondSort != 0) {
                return secondSort*-1;
            }
	    return 0;
	}
	
	/**
	 * Takes a meme and gives it a rating
	 * 
	 * @param meme1 A inputed meme
	 * @param rating A user inputed rating
	 * @return Nothing is returned
	 */
	public void rateMeme(Meme meme1, int rating) {
	    getMemesViewed().add(meme1);
	    Rating newRating = new Rating(this, rating);
        meme1.addRating(newRating);
	}
	
	/**
	 * Creates a meme with a image and caption
	 * 
	 * @param backgroundImage1 A inputed image
	 * @param caption A inputed caption
	 * @return null
	 */
	public Meme createMeme(BackgroundImage backgroundImage1, String caption) {
	   Meme createdMeme = new Meme(backgroundImage1, caption, this);
	   memesCreated.add(createdMeme); 
	   return createdMeme;
	}
	
	/**
	 * Deletes a meme and verifies whether it is deleted
	 * 
	 * @param meme1 A inputed meme
	 * @return boolean; whether the mean was successfully deleted or not
	 */
	public boolean deleteMeme(Meme meme1) {
	    for(int i = 0; i < memesCreated.size(); i++) {
	        if(memesCreated.get(i).equals(meme1) && meme1.getShared() == false) {
	            memesCreated.remove(meme1);
	            return true;
	        }	    
	    
	}
	    return false;
	}
	
	/**
	 * Shares a meme on a feed
	 * 
	 * @param meme1 A inputed meme
	 * @param feed1 Tells where to share the meme
	 */
	public void shareMeme(Meme meme1, Feed feed1) {
	    meme1.setShared(true);
	    feed1.getMemes().add(meme1);
	}
	
	/**
	 * Rates the next meme from the user's feed
	 * 
	 * @param feed1 Defines which feed
	 * @param ratingScore Gives a score
	 */
	public boolean rateNextMemeFromFeed(Feed feed1, int ratingScore) {
	    if(feed1.getNewMeme(this) != null) {
	        Meme newMeme = feed1.getNewMeme(this);
	    getMemesViewed().add(feed1.getNewMeme(this));
	    Rating newRating = new Rating(this, ratingScore);
	    newMeme.addRating(newRating);	    
	    return true;
	}
	    return false;
	}
	/**
	 * Gives the reputation of the meme
	 * 
	 * @return Return the reputation of the meme or return a default value of zero
	 */
	public double calculateReputation() {
	    double calculatedReputation = 0.0;
	    double totalCalculation = 0.0;
	   if(getMemesCreated().isEmpty() == false) {
	    for(int i = 0; i < memesCreated.size(); i++) {
	       calculatedReputation = memesCreated.get(i).calculateOverallRating();
	       totalCalculation = totalCalculation + calculatedReputation;
	       
	       
	}
	    totalCalculation = totalCalculation/(memesCreated.size());
	    totalCalculation = Math.floor(totalCalculation*100)/100;
	            
	   }

	    return totalCalculation;
}
	
	/**
	 * Convert the values into Strings
	 * 
	 * @return This returns the values as Strings
	 */
	@Override 
	public String toString() {    
	    
	    return userName + " has rated (" + memesViewed.size() + ") memes, (" + calculateReputation() + ")";
	}
	
	/**
	 * Compares two given Strings
	 * 
	 * @param A input object
	 * @return Returns a value of true of false whether both string match or not
	 */

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (memesCreated == null) {
            if (other.memesCreated != null)
                return false;
        } else if (!memesCreated.equals(other.memesCreated))
            return false;
        if (memesViewed == null) {
            if (other.memesViewed != null)
                return false;
        } else if (!memesViewed.equals(other.memesViewed))
            return false;
        if (userName == null) {
            if (other.userName != null)
                return false;
        } else if (!userName.equals(other.userName))
            return false;
        return true;
    }

    /**
	 *Retrieves the username
	 *
	 * @return Returns the username
	 */
    public String getUserName() {
        return userName;
    }
    
    /**
     *Sets the username
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    /**
     *Retrieves the memes created
     *
     * @return Returns the memes created
     */
    public ArrayList<Meme> getMemesCreated() {
        return memesCreated;
    }
    
    /**
     *Changes the memes created
     */
    public void setMemesCreated(ArrayList<Meme> memesCreated) {
        this.memesCreated = memesCreated;
    }
    
    /**
     *Retrieves the memes viewed
     *
     * @return Returns the memes viewed
     */
    public ArrayList<Meme> getMemesViewed() {
        ArrayList<Meme> listMemesViewed = new ArrayList<Meme>();
        for (Meme o : memesViewed) {
        listMemesViewed.add(o);
        }
        return listMemesViewed;
    }
    
    /**
     *Changes the memes viewed
     */
    public void setMemesViewed(ArrayList<Meme> memesViewed) {
        this.memesViewed.clear();
        for (Meme o : memesViewed) {
        this.memesViewed.add(o);
        }
        
    }
    
	public static void main(String[] args) {
        User user1 = new User("someone");
        User user2 = new User("me");
        BackgroundImage a = new BackgroundImage("happy", "dog", "brown");
        BackgroundImage b = new BackgroundImage("sad", "cat", "black");
        BackgroundImage c = new BackgroundImage("sd", "ct", "back");
        Meme meme1 = new Meme(a, "Happy", user1);
        Meme meme2 = new Meme(b, "Sad", user1);
        Meme meme3 = new Meme(b, "Saf", user1);
        Feed feed = new Feed();
        
        ArrayList<Meme> newMemes = new ArrayList<Meme>();
        newMemes.add(meme1);
        newMemes.add(meme2);
        newMemes.add(meme3);
        user1.setMemesCreated(newMemes);
        user2.rateMeme(meme1, 1);
        user1.rateMeme(meme1, 1);
        user1.rateMeme(meme1, 1);
        user2.rateMeme(meme1, 1);
        feed.setMemes(newMemes);
        System.out.println(user1.equals(user1));
        System.out.println(user1.equals(user2));
        System.out.println(user1.toString());
        System.out.println(user2.toString());
        System.out.println(user1.rateNextMemeFromFeed(feed, 1));
        System.out.println(user2.rateNextMemeFromFeed(feed, 1));
        System.out.println(user1.calculateReputation());
        System.out.println(user2.calculateReputation());
        System.out.println(user1.createMeme(c, "happy"));
        System.out.println(user2.createMeme(b, "nani"));
        user1.shareMeme(meme1, feed);
        user2.shareMeme(meme2, feed);
        System.out.println(user1.deleteMeme(meme1));
        System.out.println(user2.deleteMeme(meme2));

        System.out.println(user1.compareTo(user2));
        System.out.println(user1.compareTo(user1));
        System.out.println(user2.compareTo(user1));
	}
	
}
