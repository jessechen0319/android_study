package com.example.cheruixi.session2_view_component;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private AutoCompleteTextView textView;
    private RadioGroup group;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.xingqiu);
        final String[] xingqius = getResources().getStringArray(R.array.xingqiu);
        textView = findViewById(R.id.xiaomei);
        group = findViewById(R.id.button2);
        String[] xiaomei = {"guoguo", "chenyan"};
        final ArrayAdapter adapter1 = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_item, xiaomei);
        final ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_item, xingqius);
        textView.setAdapter(adapter1);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                System.out.println("spinner come this");

                String item1 = xingqius[i];
                String item2 = adapter.getItem(i).toString();
                String item3 = spinner.getItemAtPosition(i).toString();

                Toast.makeText(MainActivity.this, item2, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        textView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println( adapter1.getPosition(i));
                Toast.makeText(MainActivity.this, adapter1.getPosition(i), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton button =  findViewById(checkedId);
                String text =  button.getText().toString();
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void clickButton(View view){
        Toast.makeText(MainActivity.this, "~~~~", Toast.LENGTH_SHORT).show();
    }
}
