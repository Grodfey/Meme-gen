/**
 * Homework 2
 * Tho Vu, thv7pas
 * 
 */
public class Rating {

    /**
     * Stores the value of the score
     */
    private int score;
    
    /**
     * Stores the user 
     */
    private User user;
   
    /**
     * class constructor
     */
   public Rating(User user, int score){
       this.score = 0;
       this.user = user;
       if(score == -1 || score == 0 || score == 1) {
           this.score = score;
       }      
    }
   
   /*
    * Default constructor
    */
    public Rating() {
        this.user = new User();
        score = 0;
    }
    
    /**
     * Convert the values into Strings
     * 
     * @return This returns the values as Strings
     */
    @Override
    public String toString() {
        String upvote = "rated as an upvote";
        String downvote = "rated as a downvote";
        String pass = "rated as a pass";
        if (score == 1) {
            return user.getUserName() + " " + upvote;
        }
        else if(score == 0) {
            return user.getUserName() + " " + pass;
        }
        else {
            return user.getUserName() + " " + downvote;
        }
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
        Rating other = (Rating) obj;
        if (score != other.score)
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        return true;
    }

    /**
     * Getter for the value of the score
     * 
     * @return Returns the value of score
     */
    public int getScore() {
        return score;
    }

    /**
     * Setter for the value of score
     */
    public boolean setScore(int score) {
        boolean changedScore = false;
        if (score == -1 || score == 0 || score == 1) {
            this.score = score;
            changedScore = true;
        }
        return changedScore;
    }

    /**
     * Getter for the user
     * 
     * @return Returns the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Setter for the user
     */
    public void setUser(User user) {
        this.user = user;
    }
    public static void main(String args[]) {
        User user1 = new User("tho");
        User user2 = new User("me");
        Rating rating = new Rating(user1, 1);
        Rating rating2 = new Rating (user2, 0);
        System.out.println(rating.toString());
        System.out.println(rating2.toString());
        
        System.out.println(rating.setScore(2));
        System.out.println(rating.setScore(0));

        System.out.println(rating.equals(rating2));
        System.out.println(rating.equals(rating));
    }
    
}
