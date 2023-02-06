import java.util.ArrayList;
import java.util.Collections;

public class OrderableFeed extends Feed{

    public void sortByCaption() {
        Collections.sort(getMemes());
    }
    
    public void sortByRating() {
        Collections.sort(getMemes(), new CompareMemeByRating());
    }
    
    public void sortByCreator() {
        Collections.sort(getMemes(), new CompareMemeByCreator());
    }
    
    public static void main(String args[]) {
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
        OrderableFeed new1 = new OrderableFeed();
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
        new1.sortByCaption();
        new1.sortByRating();
        new1.sortByCreator();
        System.out.println(new1.getNewMeme(user1));
        System.out.println(new1.getNewMeme(user2)); 
        
    }
}
