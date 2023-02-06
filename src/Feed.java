import java.util.ArrayList;

/**
 * Homework 2
 * Tho Vu, thv7pas
 * 
 */
public class Feed {

    /**
     * Stores an array of memes that were created
     */
    private ArrayList<Meme> memesCreated;
    
    /**
     * class constructor
     */
   public Feed(){
      memesCreated = new ArrayList<Meme>(); 
    }
    
    /**
     * Gets the user a new meme
     * 
     * @param Gets a new meme 
     * @return Returns the new meme
     */
   
    public Meme getNewMeme(User user1) {
       
        if(getMemes().isEmpty() == false) {                 
           
            for(int i = 0; i < getMemes().size(); i++) {                
            if(!user1.getMemesViewed().contains(getMemes().get(i)) && !user1.getMemesCreated().contains(getMemes().get(i))) {
                 return getMemes().get(i);
                }
               }           
            }
        return null;
    }
    
    
    /**
     * Convert the values into Strings
     * 
     * @return This returns the values as Strings
     */
    @Override 
    public String toString() {
        String newString = "";
        if(memesCreated.isEmpty() == false) {
        for(int i = 0; i < memesCreated.size(); i++) {
            newString = newString + memesCreated.get(i) + "\n";
    }
        }
        return newString;
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
        Feed other = (Feed) obj;
        if (memesCreated == null) {
            if (other.memesCreated != null)
                return false;
        } else if (!memesCreated.equals(other.memesCreated))
            return false;
        return true;
    }

    /**
     * Getter for the meme created
     * 
     * @return Returns the memes created
     */
    public ArrayList<Meme> getMemes() {
        return memesCreated;
    }
    
    /**
     * Setter for memes created
     */
    public void setMemes(ArrayList<Meme> memesCreated) {
        this.memesCreated = memesCreated;
    }
    
    public static void main(String[] args) {
        User user1 = new User("tho");
        User user2 = new User("me");
        BackgroundImage a = new BackgroundImage("happy", "dog", "brown");
        BackgroundImage b = new BackgroundImage("sad", "cat", "black");
        Meme meme1 = new Meme(a, "Happy", user2);
        Meme meme2 = new Meme(b, "Sad", user2);
        Meme meme3 = new Meme(b, "Sad", user2);
        Meme meme4 = new Meme(b, "not Sad", user1);
        Feed feed = new Feed();
        Feed feed2 = new Feed();
        ArrayList<Meme> newMemes = new ArrayList<Meme>();
        newMemes.add(meme1);
        newMemes.add(meme2);
        feed.setMemes(newMemes);
        ArrayList<Meme> newMemes2 = new ArrayList<Meme>();
        newMemes.add(meme1);
        newMemes.add(meme2);
        newMemes.add(meme3);
        newMemes.add(meme4);
        feed2.setMemes(newMemes2);
        ArrayList<Meme> newMemesC = new ArrayList<Meme>();
        newMemesC.add(meme3);
        user1.setMemesCreated(newMemesC);
        System.out.println(feed.getNewMeme(user1));
        System.out.println(feed.getNewMeme(user2));
        System.out.println(feed.toString());
        System.out.println(feed2.toString());
    }
}
