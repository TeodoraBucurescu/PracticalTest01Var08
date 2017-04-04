package practicaltest01var08.eim.systems.cs.pub.ro.practicaltest01var08;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view .Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class PracticalTest01Var08MainAcvtivity extends AppCompatActivity {

    private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;


    private EditText oneEditText = null;
    private EditText twoEditText = null;
    private EditText threeEditText = null;
    private EditText fourEditText = null;

    private Button setButton = null;


    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.set_button:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var08SecondaryActivity.class);
                    int numberOne = Integer.parseInt(oneEditText.getText().toString());
                    int numberTwo = Integer.parseInt(twoEditText.getText().toString());
                    int numberThree = Integer.parseInt(threeEditText.getText().toString());
                    int numberFour = Integer.parseInt(fourEditText.getText().toString());

                    intent.putExtra("numberOne", numberOne);
                    intent.putExtra("numberTwo", numberTwo);
                    intent.putExtra("numberThree", numberThree);
                    intent.putExtra("numberFour", numberFour);
                    startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var08_main);

        oneEditText = (EditText)findViewById(R.id.one_edit_text);
        twoEditText = (EditText)findViewById(R.id.two_edit_text);
        threeEditText = (EditText)findViewById(R.id.three_edit_text);
        fourEditText = (EditText)findViewById(R.id.four_edit_text);

        setButton = (Button)findViewById(R.id.set_button);

        setButton = (Button)findViewById(R.id.set_button);
        setButton.setOnClickListener(buttonClickListener);


        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("oneField")) {
                oneEditText.setText(savedInstanceState.getString("oneField"));
            } else {
                oneEditText.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey("twoField")) {
                twoEditText.setText(savedInstanceState.getString("twoField"));
            } else {
                twoEditText.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey("threeField")) {
                threeEditText.setText(savedInstanceState.getString("threeField"));
            } else {
                threeEditText.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey("fourField")) {
                fourEditText.setText(savedInstanceState.getString("fourField"));
            } else {
                fourEditText.setText(String.valueOf(0));
            }
        } else {
            oneEditText.setText(String.valueOf(0));
            twoEditText.setText(String.valueOf(0));
            threeEditText.setText(String.valueOf(0));
            fourEditText.setText(String.valueOf(0));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("oneField", oneEditText.getText().toString());
        savedInstanceState.putString("twoField", twoEditText.getText().toString());
        savedInstanceState.putString("threeField", threeEditText.getText().toString());
        savedInstanceState.putString("fourField", fourEditText.getText().toString());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("oneField")) {
            oneEditText.setText(savedInstanceState.getString("oneField"));
        } else {
            oneEditText.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey("twoField")) {
            twoEditText.setText(savedInstanceState.getString("twoField"));
        } else {
            twoEditText.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey("threeField")) {
            threeEditText.setText(savedInstanceState.getString("threeField"));
        } else {
            threeEditText.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey("fourField")) {
            fourEditText.setText(savedInstanceState.getString("fourField"));
        } else {
            fourEditText.setText(String.valueOf(0));
        }
    }
}
