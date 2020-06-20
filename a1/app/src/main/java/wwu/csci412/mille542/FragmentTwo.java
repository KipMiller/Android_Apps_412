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
import android.widget.ImageView;

// Fragment two contains an image view with the purpose of displaying the image of the
// apps creator when the "image" button is pressed.
public class FragmentTwo extends Fragment {

    private static ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.image_fragment_layout,
                container, false);

        imageView = view.findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.profilepic);
        imageView.setVisibility(View.INVISIBLE);

        return view;
    }

    public void imageAppear(){
        imageView.setVisibility(View.VISIBLE);

    }

    public void imageDisappear(){
        imageView.setVisibility(View.INVISIBLE);

    }



}
