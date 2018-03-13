package co.example.johan_lohi.sanapeli;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private String word;
    private TextView wordView;
    private TextView otsikko;
    private Resources res;
    private String[] words;
    private String[] letters;
    private List<String> wordList;
    private TextView correct1;
    private TextView correct2;
    private TextView correct3;
    private TextView correct4;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private ArrayList<Button> buttonList;
    private ArrayList<Button> buttonList1;
    private int taso = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        wordView = (TextView) findViewById(R.id.word);
        otsikko = (TextView) findViewById(R.id.textView);
        correct1 = (TextView) findViewById(R.id.correct1);
        correct2 = (TextView) findViewById(R.id.correct2);
        correct3 = (TextView) findViewById(R.id.correct3);
        correct4 = (TextView) findViewById(R.id.correct4);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);


        res = getResources();


        buttonList = new ArrayList<Button>();
        buttonList1 = new ArrayList<Button>();

        setWords();
        setLetters();


    }


    public void getLetter(View view)
    {
        if (view instanceof Button)
        {
            Button bu = (Button) view;
            buttonList.add(bu);

            if (word == null)
            {
                word = bu.getText().toString().toLowerCase();
                wordView.setText(word);
                bu.setEnabled(false);
            }
            else
            {
                word += bu.getText().toString().toLowerCase();
                wordView.setText(word);
                bu.setEnabled(false);
            }

            for (int i = 0; i < wordList.size(); i++ )
            {
                if ( word.equals(wordList.get(i)))
                {
                    wordList.remove(i);
                    if (correct1.getText().equals(""))
                    {
                        correct1.setText(word);
                        word = "";
                        wordView.setText(word);


                        for (int ic = 0; ic < buttonList.size(); ic++)
                        {
                            buttonList.get(ic).setEnabled(true);

                        }
                        buttonList.clear();
                    }
                    else if (correct2.getText().equals(""))
                    {
                        correct2.setText(word);
                        word = "";
                        wordView.setText(word);

                        for (int ic = 0; ic < buttonList.size(); ic++)
                        {
                            buttonList.get(ic).setEnabled(true);

                        }
                        buttonList.clear();
                    }
                    else if (correct3.getText().equals(""))
                    {
                        correct3.setText(word);
                        word = "";
                        wordView.setText(word);

                        for (int ic = 0; ic < buttonList.size(); ic++)
                        {
                            buttonList.get(ic).setEnabled(true);

                        }
                        buttonList.clear();
                    }
                    else if (correct4.getText().equals(""))
                    {
                        correct4.setText(word);
                        word = "";
                        wordView.setText(word);
                        taso = taso + 1;

                        for (int ic = 0; ic < buttonList.size(); ic++)
                        {
                            buttonList.get(ic).setEnabled(true);

                        }
                        buttonList.clear();
                        setWords();
                        setLetters();
                        correct1.setText("");
                        correct2.setText("");
                        correct3.setText("");
                        correct4.setText("");
                    }

                }
                else if (buttonList.size() == 6)
                {
                    for (int counter = 0; counter < buttonList.size(); counter++)
                    {
                        buttonList.get(counter).setEnabled(true);

                        word = "";
                        wordView.setText(word);


                    }
                    buttonList.clear();
                }

            }
        }
    }

    public void clearWord(View view)
    {
        word = "";
        wordView.setText(word);

        for (int i = 0; i < buttonList.size(); i++)
        {
            buttonList.get(i).setEnabled(true);

        }
        buttonList.clear();
    }

    public void setLetters()
    {
        buttonList1.add(button1);
        buttonList1.add(button2);
        buttonList1.add(button3);
        buttonList1.add(button4);
        buttonList1.add(button5);
        buttonList1.add(button6);



        for (int i = 0; i < 6; i++)
        {
            buttonList1.get(i).setText(letters[i]);

        }
    }
    public  void setWords()
    {
        if (taso == 1)
        {
            words = res.getStringArray(R.array.words1);
            wordList = new ArrayList<String>(Arrays.asList(words));
            letters = res.getStringArray(R.array.letters1);
            otsikko.setText("Taso: " + taso);
        }
        else if (taso == 2)
        {
            words = res.getStringArray(R.array.words2);
            wordList = new ArrayList<String>(Arrays.asList(words));
            letters = res.getStringArray(R.array.letters2);
            otsikko.setText("Taso: " + taso);
        }
        else if (taso == 3)
        {
            words = res.getStringArray(R.array.words3);
            wordList = new ArrayList<String>(Arrays.asList(words));
            letters = res.getStringArray(R.array.letters3);
            otsikko.setText("Taso: " + taso);
        }
        else if (taso == 4)
        {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

}
