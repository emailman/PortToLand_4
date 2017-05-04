package edu.rjones95dttc.porttoland;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private final String KEY = "answer value";

    private double answer;

    private EditText editText;

    private TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = (TextView) findViewById(R.id.tvDisplay);

        editText = (EditText) findViewById(R.id.editText);

        Button createString = (Button) findViewById(R.id.btnCalculate);
        createString.setOnClickListener(this);

        if (savedInstanceState != null)
        {
            answer = savedInstanceState.getDouble(KEY);

            tvDisplay.setText(String.format("%.2f", answer));
            Log.d("Ray", "bundle restored");
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);

        outState.putDouble(KEY, answer);

        Log.d("Ray", "bundle saved");
    }

    @Override
    public void onClick(View v)
    {
        try
        {
            double data = Double.parseDouble(editText.getText().toString());

            answer = data * 100;

            tvDisplay.setText(String.format("%.2f", answer));
        }
        catch (Exception e)
        {
            Toast.makeText(MainActivity.this, "Enter Numbers Only", Toast.LENGTH_LONG).show();

            tvDisplay.setText("0");
        }
    }
}
