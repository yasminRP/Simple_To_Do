package sg.edu.rp.c346.id22026024.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etActivity;
    Button btnAdd;
    Button btnClear;
    ListView lvActivity;

    ArrayList<String> alActivity = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etActivity = findViewById(R.id.editTextActivity);
        btnAdd = findViewById(R.id.buttonAdd);
        btnClear = findViewById(R.id.buttonClear);
        lvActivity = findViewById(R.id.listViewActivity);

        ArrayAdapter aaActivity = new ArrayAdapter(this, android.R.layout.simple_list_item_1, alActivity);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String activity = etActivity.getText().toString();
                for (String a : alActivity) {
                    alActivity.add(0, activity);
                    aaActivity.notifyDataSetChanged();
                }

            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alActivity.clear();
                aaActivity.notifyDataSetChanged();
            }
        });
        lvActivity.setAdapter(aaActivity);

    }
}