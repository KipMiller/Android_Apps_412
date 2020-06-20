// Author: Chris Miller
// CSCI 412 Spring 2019
// Date Started: 4/28/2019
// Assignment 2

package wwu.csci412.mille542_a2;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// The Film Content class is used to populate the recycler view with things to review.
// Each film item contains a title, a rating (from bad to amazing), and details (a review provided
//  by the user by typing in the text edit).
public class FilmContent extends ItemListActivity {

    /**
     * An array of sample film items.
     */
    public static final List<FilmItem> ITEMS = new ArrayList<FilmItem>();

    public static final Map<String, FilmItem> ITEM_MAP = new HashMap<String, FilmItem>();

    public static void fill(String title){
       addItem(new FilmItem("Unrated", title, ""));
    }

    // Static loop to populate the item list with film titles pulled from the movie_array
    // located in the array.xml file as a string array.
    static {
        // Utilize the app class to obtain context (needed to get resources in a static context)
        Context context = App.getContext();
        //Obtain the string array of film titles
        String[] movieArray = context.getResources().getStringArray(R.array.movie_array);
        for(int i = 0; i < movieArray.length; i++) {
            FilmContent.fill( movieArray[i]);//fill the hash map with films
        }
    }

    private static void addItem(FilmItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.filmName, item);
    }

    // Custom film item class made to store information needed in the rating functions.
    public static class FilmItem {
        public  String rating;// From bad, to average, to amazing
        public  String filmName;// the title of the film (supplied by film string array, unique)
        public  String details;// the user written review, comes from the edit text in the fragment

        public FilmItem(String rating, String filmName, String details) {
            this.rating = rating;
            this.filmName = filmName;
            this.details = details;
        }

        @Override
        public String toString() {
            return filmName;
        }
    }
}
