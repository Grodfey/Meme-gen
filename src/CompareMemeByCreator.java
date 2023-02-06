import java.util.Comparator;

public class CompareMemeByCreator implements Comparator<Meme>{
@Override
public int compare(Meme meme1, Meme meme2) {
    int firstSort = meme1.getCreator().compareTo(meme2.getCreator());
    if(firstSort != 0) {
        return firstSort;
    }
    int secondSort = Double.compare(meme1.calculateOverallRating(), meme2.calculateOverallRating());
    if(secondSort != 0) {
        return secondSort*-1;
    }
    int thirdSort = meme1.getCaption().compareTo(meme2.getCaption());
    if(thirdSort != 0) {
        return thirdSort;
    }
    int fourthSort = meme1.getBackgroundImage().compareTo(meme2.getBackgroundImage());
    if(fourthSort != 0) {
        return fourthSort;
    }
    int fifthSort = Boolean.compare(meme1.getShared(), meme2.getShared());
    if(fifthSort != 0) {
        return fifthSort*-1;
    }
    return 0;
}
public static void main(String args[]) {
    User user1 = new User("tho");
    User user2 = new User("me");
    BackgroundImage a = new BackgroundImage("happy", "dog", "brown");
    BackgroundImage b = new BackgroundImage("sad", "cat", "black");
    Meme meme1 = new Meme(a, "Sad", user1);
    Meme meme2 = new Meme(a, "Sad", user2);

    CompareMemeByCreator new1 = new CompareMemeByCreator();
    System.out.println(new1.compare(meme1, meme2));
    System.out.println(new1.compare(meme1,meme1));
    System.out.println(new1.compare(meme2, meme1));
}
}
