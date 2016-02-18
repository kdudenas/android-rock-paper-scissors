package com.cs407_android.rockpaperscissors;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link PlayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlayFragment extends Fragment {

    private static final String ARG_PLAYER_ONE = "player1";
    private static final String ARG_PLAYER_TWO = "player2";
    private static final String ARG_TIE = "No one - it's a tie!"; //KAD what if they tie?

    private String player1Choice;
    private String player2Choice;

    private Button rockButton;
    private Button paperButton;
    private Button scissorsButton;
    private TextView headerTextView;

    /**
     * DONT CHANGE THIS METHOD
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param player1Choice Player 1's move (null if not specified yet).
     * @param player2Choice Player 2's move (null if not specified yet).
     * @return A new instance of fragment PlayFragment.
     */
    public static PlayFragment newInstance(String player1Choice, String player2Choice) {
        PlayFragment fragment = new PlayFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PLAYER_ONE, player1Choice);
        args.putString(ARG_PLAYER_TWO, player2Choice);
        fragment.setArguments(args);
        return fragment;
    }

    public PlayFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            player1Choice = getArguments().getString(ARG_PLAYER_ONE);
            player2Choice = getArguments().getString(ARG_PLAYER_TWO);
        }
    }


    @Override //KAD this is the gameplay screen, basically. Displays to the user the three options: rock, paper, scissors.
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //TA Implementation DON'T CHANGE
        View view = null;
        view = inflater.inflate(R.layout.fragment_play, container, false);

        //instantiate widgets
        rockButton = (Button) view.findViewById(R.id.rock);
        paperButton = (Button) view.findViewById(R.id.paper);
        scissorsButton = (Button) view.findViewById(R.id.scissors);
        headerTextView = (TextView) view.findViewById(R.id.header);

        //set header
        if(player1Choice == null) {
            headerTextView.setText(getString(R.string.player_1_header));
        }
        else{
            headerTextView.setText(getString(R.string.player_2_header));
        }

        return view;

        // End TA Implementation
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //TA Implementation

        //different way of implementing click interaction.
        rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(player1Choice == null) {
                   //KAD player 1 chose Rock - Player 2's turn
                    getFragmentManager()
                            .beginTransaction() //KAD apparently getText(int) will retain any rich text styling applied to the string.
                            .replace(R.id.main_fragment_container, PlayFragment.newInstance(getString(R.string.rock), null))
                            .addToBackStack(null)
                            .commit();
                }
                else{
                    //KAD player 2 chose Rock
                    if(player1Choice.equals(getString(R.string.paper))){
                        //paper beats rock; p1 wins
                        displayWinner(ARG_PLAYER_ONE);
                    }
                    else if(player1Choice.equals(getString(R.string.scissors))){
                        //rock beats scissors; p2 wins
                        displayWinner(ARG_PLAYER_TWO);
                    }
                    else{
                        //rock == rock; tie
                        displayWinner(ARG_TIE);
                    }
                }

            }
        });

        paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(player1Choice == null) {
                    //KAD player 1 chose Paper - Player 2's turn
                    getFragmentManager()
                            .beginTransaction() //KAD apparently getText(int) will retain any rich text styling applied to the string.
                            .replace(R.id.main_fragment_container, PlayFragment.newInstance(getString(R.string.paper), null))
                            .addToBackStack(null)
                            .commit();

                }
                else{
                    //KAD player 2 chose Paper
                    if(player1Choice.equals(getString(R.string.scissors))){
                        //scissors beats paper; p1 wins
                        displayWinner(ARG_PLAYER_ONE);
                    }
                    else if(player1Choice.equals(getString(R.string.rock))){
                        //paper beats rock; p2 wins
                        displayWinner(ARG_PLAYER_TWO);
                    }
                    else{
                        //paper == paper; tie
                        displayWinner(ARG_TIE);
                    }

                }
            }
        });

        scissorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(player1Choice == null) {
                    //KAD player 1 chose Scissors - Player 2's turn
                    getFragmentManager()
                            .beginTransaction() //KAD apparently getText(int) will retain any rich text styling applied to the string.
                            .replace(R.id.main_fragment_container, PlayFragment.newInstance(getString(R.string.scissors), null))
                            .addToBackStack(null)
                            .commit();

                }
                else{
                    //KAD player 2 chose Scissors
                    if(player1Choice.equals(getString(R.string.rock))){
                        //rock beats scissors; p1 wins
                        displayWinner(ARG_PLAYER_ONE);
                    }
                    else if(player1Choice.equals(getString(R.string.paper))){
                        //scissors beats paper; p2 wins
                        displayWinner(ARG_PLAYER_TWO);
                    }
                    else{
                        //scissors == scissors; tie
                        displayWinner(ARG_TIE);
                    }

                }
            }
        });
    }


    private void displayWinner(String winner){

        //TODO finish implementing this AlertDialog

        //do a prompt about the winner
        new AlertDialog.Builder(getActivity())
                .setCancelable(true)
                .setTitle("Winner is:")
                .setMessage(winner)
                .setPositiveButton("Replay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //KAD start a rematch!
                        getFragmentManager()
                                .beginTransaction() //KAD apparently getText(int) will retain any rich text styling applied to the string.
                                .replace(R.id.main_fragment_container, PlayFragment.newInstance(null, null))
                                .addToBackStack(null)
                                .commit();
                    }
                })
                .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //KAD back out to the start screen
                        Intent other=new Intent(getActivity(), MainActivity.class); //we want to start a new activity, PlayActivity
                        getActivity().startActivity(other);

                    }
                })
                .show();

    }


}
