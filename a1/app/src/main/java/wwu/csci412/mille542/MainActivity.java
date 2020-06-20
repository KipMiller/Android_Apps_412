//Author: Chris Miller
// CSCI412 Spring 2019
// Date Started: 4/13/2019
// Assignment 1

package wwu.csci412.mille542;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create variables for each button
        final Button nameButton = findViewById(R.id.button);//create the name button
        final Button bioButton = findViewById(R.id.button4);//create the bio button
        final Button pictureButton = findViewById(R.id.button5);//Create the "picture" button

        // If the user touches the "name" button
        nameButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                nameButton.setBackgroundColor(getResources().getColor(R.color.purple));
                bioButton.setBackgroundColor(getResources().getColor(R.color.green));
                pictureButton.setBackgroundColor(getResources().getColor(R.color.red));

                FragmentOne frag = (FragmentOne) getSupportFragmentManager().
                        findFragmentById(R.id.textFragment);
                frag.namePress();

                FragmentTwo frag2 = (FragmentTwo) getSupportFragmentManager().
                        findFragmentById(R.id.imageFragment);
                frag2.imageDisappear();// make the image invisible
            }
        });

        //if the user touches the bio button
        bioButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                nameButton.setBackgroundColor(getResources().getColor(R.color.blue));
                bioButton.setBackgroundColor(getResources().getColor(R.color.purple));
                pictureButton.setBackgroundColor(getResources().getColor(R.color.red));

                FragmentOne frag = (FragmentOne) getSupportFragmentManager().
                        findFragmentById(R.id.textFragment);
                frag.bioPress();

                FragmentTwo frag2 = (FragmentTwo) getSupportFragmentManager().
                        findFragmentById(R.id.imageFragment);
                frag2.imageDisappear();// make the image invisible
            }
        });

        // if the user clicks on the picture button
        pictureButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                nameButton.setBackgroundColor(getResources().getColor(R.color.blue));
                bioButton.setBackgroundColor(getResources().getColor(R.color.green));
                pictureButton.setBackgroundColor(getResources().getColor(R.color.purple));

                FragmentTwo frag2 = (FragmentTwo) getSupportFragmentManager().
                        findFragmentById(R.id.imageFragment);
                frag2.imageAppear();// make the image visible

                FragmentOne frag = (FragmentOne) getSupportFragmentManager().
                        findFragmentById(R.id.textFragment);
                frag.changeText(0, "");

            }
        });

    }
}
