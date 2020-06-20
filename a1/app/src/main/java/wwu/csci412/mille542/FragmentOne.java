//Author: Chris Miller
// CSCI412 Spring 2019
// Date Started: 4/13/2019
// Assignment 1

package wwu.csci412.mille542;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

// Fragment One contains a text view for the use of displaying either the name or bio
// of the app creator.
public class FragmentOne extends Fragment {

    private static TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_layout,
                container, false);

        textView = view.findViewById(R.id.textView);

        return view;
    }

    // method to change the text and font size of a given text view
    public void changeText(int font, String text){
        textView.setTextSize(font);
        textView.setText(text);
    }

    // Function for when the "bio" button is pressed by the user,
    // changes the text, font size and font color
    // of the text view fragment in the main activity.
    public void bioPress() {
        textView.setTextSize(30);
        textView.setText("Student majoring in Computer Science. \n " +
                "I like dogs, movies, video games and programming of all sorts.");
        //change the text color by accessing my custom color
        textView.setTextColor(this.getResources().getColor(R.color.white));
    }

    // Function for when the "name" button is pressed by the user,
    // changes the text, font size and font color
    // of the text view fragment in the main activity.
    public void namePress() {
        textView.setTextSize(70);
        textView.setText("Chris Miller");
        //change the text color by accessing my custom color
        textView.setTextColor(this.getResources().getColor(R.color.white));
    }


}
