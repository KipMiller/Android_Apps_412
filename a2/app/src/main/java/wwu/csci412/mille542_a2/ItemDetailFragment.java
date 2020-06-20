// Author: Chris Miller
// CSCI 412 Spring 2019
// Date Started: 4/28/2019
// Assignment 2

package wwu.csci412.mille542_a2;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends android.support.v4.app.Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    private FilmContent.FilmItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            mItem = FilmContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.filmName);
            }

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.item_detail, container, false);


        final Button saveButton = rootView.findViewById(R.id.save_button);
        final EditText textBox = rootView.findViewById(R.id.editText);


        // Show the film content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.item_detail)).setText(mItem.filmName);
            textBox.setText(mItem.details);
        }

        final RadioButton badButton = rootView.findViewById(R.id.radioBad);
        final RadioButton avgButton = rootView.findViewById(R.id.radioAverage);
        final RadioButton amazeButton = rootView.findViewById(R.id.radioAmazing);

        //If the user has saved a rating, make sure to keep that button checked in future cases
        if(mItem.rating.equals("bad")) {
            badButton.setChecked(true);
        }
        else if(mItem.rating.equals("avg")) {
            avgButton.setChecked(true);
        }
        else if(mItem.rating.equals("amz")) {
            amazeButton.setChecked(true);
        }

        saveButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    // when the user pushes down on the button, change the color
                    saveButton.setBackgroundColor(getResources().getColor(R.color.skyblue));
                } else if (event.getAction() == MotionEvent.ACTION_UP){// on button release
                    String review = textBox.getText().toString();// get the user review
                    mItem.details = review;//set this item's details to the review

                    // See which radio button is pressed and save that rating for future display
                    if(badButton.isChecked()){
                        mItem.rating="bad";
                    }
                    else if(avgButton.isChecked()){
                        mItem.rating="avg";
                    }
                    else if(amazeButton.isChecked()){
                        mItem.rating="amz";
                    }
                    rootView.setVisibility(View.GONE);// make fragment disappear after button press

                    ItemListActivity.updateView();//Tell the list to update (I.E. get rid of the ?)

                }
                return true;
            }
        });

        return rootView;
    }

}
