import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Homework 2
 * Tho Vu, thv7pas
 * 
 */
public class Meme implements Comparable<Meme>{

    /**
     * Stores the name of the Creator
     */
    private User creator;
    
    /**
     * Stores the background image
     */
    private BackgroundImage backgroundImage;
    
    /**
     * Stores the ratings 
     */
    private Rating[] ratings;
    
    /**
     * Stores the captions 
     */
    private String caption;
    
    /**
     * Stores the caption vertical align as a String
     */
    
    private String captionVerticalAlign;
    
    /**
     * Stores whether the image is shared or not
     */
    private boolean shared;
    
    /**
     * class constructor
     */
   public Meme(BackgroundImage backgroundImage, String caption, User creator){
       this.ratings = new Rating[10];
       captionVerticalAlign = "bottom";
       this.caption = caption;
       this.backgroundImage = backgroundImage;
       this.creator = creator;
    }
   
   /*
    * Default Constructor
    */
   public Meme() {
       this.creator = new User();
       backgroundImage = new BackgroundImage();
       this.ratings = new Rating[10];
       caption = "";
       captionVerticalAlign = "bottom";
       shared = false;     
   }
   public int compareTo(Meme m) {
       int firstSort = caption.compareTo(m.caption);
          if(firstSort != 0)
       {
           return firstSort;
       }
       int secondSort = backgroundImage.compareTo(m.backgroundImage);
       if(secondSort != 0) {
           return secondSort;
       }
       int thirdSort =  Double.compare(calculateOverallRating(),m.calculateOverallRating());
       if(thirdSort != 0) {
       return thirdSort*-1;
       }
       int fourthSort = Boolean.compare(shared,m.shared);
       if(fourthSort != 0) {
       return fourthSort*-1;
       }
       return 0;
   }
    
    /**
     * Increases the rating of the meme
     * 
     * @param rating1 User inputed rating
     * @return Determines if the user adds to the rating or not
     */
   
   public boolean addRating(Rating rating1) {
       int nullCounter = 0;
       boolean addedRating = false;      
        for(Object ob : ratings) {
            if(ob != null) {
                nullCounter++;
            }
        }
       
        if(nullCounter > 9) {       
        addedRating = true;
        for (int i = 1; i < ratings.length; i++) {
            
            ratings[i-1] = ratings[i];
            
            }
        ratings[9] = rating1;
        }
        
        else {
            if(nullCounter == 0) {
            if(ratings != null) {
            ratings[0] = rating1;
            addedRating = true;
                }
            }
            else if(nullCounter > 0){
                if(nullCounter > 0 && nullCounter < 10) {
                    ratings[nullCounter] = rating1;
                }
            }
        
    }
        return addedRating;
   }
    
    
    /**
     * Calculates the overall rating of the meme
     * 
     *@return Returns the value of the rating of the mean
     */
     public double calculateOverallRating() {
       
       int overallScore = 0;
       for(int i = 0; i < ratings.length; i++) {
           if(ratings[i] != null) {
           overallScore = overallScore + ratings[i].getScore();
       }
       }
       if(overallScore != 0) {
         double overallRating = overallScore;
           return overallRating;
       }
       else
           return 0.0;
    }
    

    /*
     * Private helper method to calculate positive ratings
     */
    private int goodRatings() {
        int ratingsCountGood = 0;
        for(int i = 0; i <= ratings.length-1; i++) {
            if (ratings[i] != null) {
            if(ratings[i].getScore() == 1.0) {
                ratingsCountGood = ratingsCountGood + 1;
                }  
            }
        }
        return ratingsCountGood;
    }
        
    /*
     * Private helper method to calculate negative ratings
     */
    private int badRatings() {
        int ratingsCountBad = 0;
        
            for(int i = 0; i <= ratings.length-1; i++) {
                if (ratings[i] != null) {
            if(ratings[i].getScore() == -1.0) {
                ratingsCountBad = ratingsCountBad + 1;
                 }
               }
            }
        return ratingsCountBad;
    }
    
    /**
     * Convert the values into Strings
     * 
     * @return This returns the values as Strings
     */
     @Override
   public String toString() {
     
        return backgroundImage + " '" + caption + "' " + calculateOverallRating() + " [+1: " + goodRatings() + ", -1: " + badRatings() + "]" + " - created by " + creator.getUserName();  
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
        Meme other = (Meme) obj;
        if (backgroundImage == null) {
            if (other.backgroundImage != null)
                return false;
        } else if (!backgroundImage.equals(other.backgroundImage))
            return false;
        if (caption == null) {
            if (other.caption != null)
                return false;
        } else if (!caption.equals(other.caption))
            return false;
        if (captionVerticalAlign == null) {
            if (other.captionVerticalAlign != null)
                return false;
        } else if (!captionVerticalAlign.equals(other.captionVerticalAlign))
            return false;
        if (creator == null) {
            if (other.creator != null)
                return false;
        } else if (!creator.equals(other.creator))
            return false;
        if (!Arrays.equals(ratings, other.ratings))
            return false;
        if (shared != other.shared)
            return false;
        return true;
    }

    /**
     * Getter for the creator
     * 
     * @return Returns the name of the creator
     */
    public User getCreator() {
        return creator;
    }
    
    /**
     * Setter for the name of the creator
     */
    public void setCreator(User creator) {
        this.creator = creator;
    }
    
    /**
     * Getter for the background image
     * 
     * @return Returns the background image
     */
    public BackgroundImage getBackgroundImage() {
        return backgroundImage;
    }
    
    /**
     * Setter for the background image
     */
    public void setBackgroundImage(BackgroundImage backgroundImage) {
        this.backgroundImage = backgroundImage;
    }
    
    /**
     * Getter for the ratings
     * 
     *@return Returns the values of the ratings
     */
    public Rating[] getRatings() {
        return ratings;
    }
    
    /**
     * Setter for the ratings
     */
    public void setRatings(Rating ratings[]) {
        this.ratings = ratings;
    }
    
    /**
     * Getter for the captions
     * 
     * @return Returns the name of the captions
     */
   public String getCaption() {
       return caption;
   }
    
    /**
     * Setter for the captions
     */
    public void setCaption(String caption) {
        this.caption = caption;
    }
    
    /**
     * Getter for the caption vertical align
     * 
     * @return Returns the caption vertical align
     */
    public String getCaptionVerticalAlign() {
        return captionVerticalAlign;
    }
    
    /**
     * Setter for the caption vertical align
     */
    public boolean setCaptionVerticalAlign(String captionVerticalAlign) {
        
        boolean isTrue = false;
        String str1 = "top";
        String str2 = "middle";
        String str3 = "bottom";
        if (captionVerticalAlign.equals(str1) || captionVerticalAlign.equals(str2) || captionVerticalAlign.equals(str3)) {
            isTrue = true;
            this.captionVerticalAlign = captionVerticalAlign;
        }
        else {
            captionVerticalAlign = this.captionVerticalAlign;
        }
        return isTrue;
    }
    
    /**
     * Getter for whether the meme is shared or not
     * 
     * @return Return whether the meme is shared or not
     */
    public boolean getShared() {
        return shared;
    }
    
    /**
     * Setter for the whether the meme is shared or not
     */
    public void setShared(boolean shared) {
        this.shared = shared;
    }
    
    public static void main(String args[]) {
        User user1 = new User("tho");
        User user2 = new User("me");
        BackgroundImage a = new BackgroundImage("happy", "dog", "brown");
        BackgroundImage b = new BackgroundImage("sad", "cat", "black");
        Meme meme1 = new Meme(a, "Sad", user1);
        Meme meme2 = new Meme(a, "Sad", user2);
        Rating rating1 = new Rating(user1, -1);
        Rating rating2 = new Rating(user2, 0);
       
        
        Rating[] ratingss = new Rating[10];
        ratingss[0] = new Rating(user2, 1);
        ratingss[1] = new Rating(user2, 0);
        ratingss[2] = new Rating(user2, 1);
        ratingss[3] = new Rating(user2, -1);
        ratingss[4] = new Rating(user2, 1);
        ratingss[5] = new Rating(user2, 1);
        ratingss[6] = new Rating(user2, 0);
        ratingss[7] = new Rating(user2, 1);
        ratingss[8] = new Rating(user2, 1);
        ratingss[9] = new Rating(user2, 1);
        System.out.println(meme1.addRating(rating1));
        System.out.println(meme2.addRating(rating2));
        System.out.println(meme1.toString());
        System.out.println(meme2.toString());
        meme1.setRatings(ratingss);
        System.out.println(meme1.calculateOverallRating());
        System.out.println(meme2.calculateOverallRating());


        System.out.println(Arrays.toString(meme1.getRatings()));
        System.out.println(Arrays.toString(meme2.getRatings()));

        System.out.println(meme1.setCaptionVerticalAlign("middle"));
        System.out.println(meme1.setCaptionVerticalAlign("sideways"));
        ArrayList<Meme> newList = new ArrayList<>();
        newList.add(meme2);
        newList.add(meme1);
        System.out.println(meme1.compareTo(meme2));
        System.out.println(newList);
        Collections.sort(newList);
        System.out.println(newList);
        System.out.println(meme1.compareTo(meme2));
        System.out.println(meme2.compareTo(meme1));
        System.out.println(meme2.compareTo(meme2));
    }
}
