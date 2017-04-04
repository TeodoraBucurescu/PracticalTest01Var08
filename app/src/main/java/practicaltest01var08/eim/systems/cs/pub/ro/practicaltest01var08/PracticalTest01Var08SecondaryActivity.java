package practicaltest01var08.eim.systems.cs.pub.ro.practicaltest01var08;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view .Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

/**
 * Created by student on 04.04.2017.
 */

public class PracticalTest01Var08SecondaryActivity extends AppCompatActivity {

    final public static String TAG  = "practicaltest01var08";


    private EditText oneEditText = null;
    private EditText twoEditText = null;
    private EditText threeEditText = null;
    private EditText fourEditText = null;

    private Button SumButton = null;
    private Button ProductButton = null;

    int numberOne, numberTwo, numberThree, numberFour;


    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.sum_button:
                    Log.d(TAG, "sumClick: " + (numberOne + numberTwo + numberThree + numberFour));
                    setResult(RESULT_OK, null);
                    break;
                case R.id.product_button:
                    Log.d(TAG, "productClick: " + (numberOne * numberTwo * numberThree * numberFour));
                    setResult(RESULT_CANCELED, null);
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var08_secondary);

        oneEditText = (EditText) findViewById(R.id.one_edit_text);
        twoEditText = (EditText) findViewById(R.id.two_edit_text);
        threeEditText = (EditText) findViewById(R.id.three_edit_text);
        fourEditText = (EditText) findViewById(R.id.four_edit_text);

        SumButton = (Button) findViewById(R.id.sum_button);
        SumButton.setOnClickListener(buttonClickListener);

        ProductButton = (Button) findViewById(R.id.product_button);
        ProductButton.setOnClickListener(buttonClickListener);


        Intent intent = getIntent();
        if (intent != null ) {
            if (intent.getExtras().containsKey("numberOne")) {
                numberOne = intent.getIntExtra("numberOne", -1);
                oneEditText.setText(String.valueOf(numberOne));
            }
            if (intent.getExtras().containsKey("numberTwo")) {
                numberTwo = intent.getIntExtra("numberTwo", -1);
                twoEditText.setText(String.valueOf(numberTwo));
            }
            if (intent.getExtras().containsKey("numberThree")) {
                numberThree = intent.getIntExtra("numberThree", -1);
                threeEditText.setText(String.valueOf(numberThree));
            }
            if (intent.getExtras().containsKey("numberFour")) {
                numberFour = intent.getIntExtra("numberFour", -1);
                fourEditText.setText(String.valueOf(numberFour));
            }
        }


    }
}
