/**
 * Homework 2
 * Tho Vu, thv7pas
 * 
 */
public class BackgroundImage implements Comparable<BackgroundImage>{
 /**
 * Stores the image file name
 */
private String imageFileName;
/**
 * Stores the user's title 
 */
private String title;

/**
 * Stores the user's description of the image
 */
private String description;

/**
 * class constructor
 */
 public BackgroundImage(String imageFileName, String title, String description){
     this.imageFileName = imageFileName;
     this.title = title;
     this.description = description;
}

 /*
  * Default constructor
  */
 public BackgroundImage() {
     imageFileName = "";
     title = "";
     description = "";
 }
 
 @Override
public int compareTo(BackgroundImage b) {
   
     int firstSort = imageFileName.compareTo(b.imageFileName);
     if(firstSort != 0) {
         return firstSort;
     }
     int secondSort = title.compareTo(b.title);
     if(secondSort != 0) {
         return secondSort;
     }
     int thirdSort = description.compareTo(b.description);
     if(thirdSort != 0) {
         return thirdSort;
     }
     return 0;
 }
/**
 * Convert the values into Strings
 * 
 * @return This returns the values as Strings
 */
@Override
public String toString() {
    return title + " " + "<" + description + ">";
}


@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    BackgroundImage other = (BackgroundImage) obj;
    if (description == null) {
        if (other.description != null)
            return false;
    } else if (!description.equals(other.description))
        return false;
    if (imageFileName == null) {
        if (other.imageFileName != null)
            return false;
    } else if (!imageFileName.equals(other.imageFileName))
        return false;
    if (title == null) {
        if (other.title != null)
            return false;
    } else if (!title.equals(other.title))
        return false;
    return true;
}

/**
 * Getter for image file name
 * 
 * @return Returns image file name
 */
public String getImageFileName() {
    return imageFileName;
}

/**
 * Setter for the image file name
 */
public void setImageFileName(String imageFileName) {
    this.imageFileName = imageFileName;
}

/**
 * Getter for the title
 * 
 * @return Returns the title name
 */
public String getTitle() {
    return title;
}

/**
 * Setter for the title name
 */
public void setTitle(String title) {
    this.title = title;
}

/**
 * Getter for the image description
 * 
 * @return Returns the image description
 */
public String getDescription() {
    return description;
}

/**
 * Setter for the description of the image
 */
public void setDescription(String description) {
    this.description = description;
}

public static void main(String args[]) {
    BackgroundImage a = new BackgroundImage("happy", "dog", "brown");
    BackgroundImage b = new BackgroundImage("sad", "cat", "black");
    System.out.println(a.toString());
    System.out.println(a.equals(a));
    System.out.println(b.toString());
    System.out.println(b.equals(a));
    System.out.println(a.compareTo(b));
    System.out.println(a.compareTo(a));
}

}
