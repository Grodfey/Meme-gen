import java.util.Comparator;

public class CompareMemeByRating implements Comparator<Meme>{
@Override
public int compare(Meme meme1, Meme meme2) {
    int firstSort = Double.compare(meme1.calculateOverallRating(), meme2.calculateOverallRating());
    if (firstSort != 0) {
        return firstSort*-1;
    }
    int secondSort = meme1.getCaption().compareTo(meme2.getCaption());
    if (secondSort != 0) {
        return secondSort;
    }
    int thirdSort = meme1.getBackgroundImage().compareTo(meme2.getBackgroundImage());
    if(thirdSort != 0) {
        return thirdSort;
    }
    int fourthSort = meme1.getCreator().compareTo(meme2.getCreator());
    if(fourthSort != 0) {
        return fourthSort;
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

    CompareMemeByRating new1 = new CompareMemeByRating();
    System.out.println(new1.compare(meme1, meme2));
    System.out.println(new1.compare(meme1,meme1));
    System.out.println(new1.compare(meme2, meme1));
}
}
