package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tictactoe.Bean.Game;
import com.example.tictactoe.Bean.Player;
import com.example.tictactoe.Bean.Status;
import com.example.tictactoe.Bean.Symbol;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    Game game = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game = new Game(new Player(Symbol.X), new Player(Symbol.O), true, 3);
    }

    public void playerTap(View view) {
        ImageView img = (ImageView) view;

        if(game.getStatus() != Status.UNDECIDED)
            resetGame(view);

        String[] rowAndCol = img.getTag().toString().split(" ");
        TextView status = findViewById(R.id.status);
        int row = Integer.parseInt(rowAndCol[0]), col = Integer.parseInt(rowAndCol[1]);

        img.setTranslationY(-1000f);
        img.animate().translationYBy(1000f).setDuration(300);
        if(game.getActivePlayer().getPlayerPiece() == Symbol.X) {
            img.setImageResource(R.drawable.x);
            status.setText("O's turn - Select cell");
        }
        else {
            img.setImageResource(R.drawable.o);
            status.setText("X's turn - Select cell");
        }

        try {
            game.makeMove(row, col);
        } catch (IllegalArgumentException e) {
            status.setText("You can't play there!! Select a cell again!!");
        }

        switch (game.getStatus()) {
            case DRAW: status.setText("Game is Draw!!");
                break;
            case PLAYER_X_WON: status.setText("X Won!! Congratulations!!");
                break;
            case PLAYER_O_WON: status.setText("O Won!! Congratulations!!");
                break;
        }
    }

    public void resetGame(View view) {
        game = new Game(new Player(Symbol.X), new Player(Symbol.O), true, 3);

        ((ImageView) findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("X's turn - Select Cell");
    }
}