package com.example.priya.intent_demo_lec6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import static com.example.priya.intent_demo_lec6.Utils.Utils.AGE_MSG_KEY;
import static com.example.priya.intent_demo_lec6.Utils.Utils.NAME_MSG_KEY;
import static java.lang.Integer.*;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private EditText edTxt1, edTxt2;
    private ListView lsView;
    private String age, name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lsView = (ListView)findViewById(R.id.ls_view1_ma1);
        final String[] myItems = getResources().getStringArray(R.array.my_itm_lst);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myItems);
        lsView.setAdapter(adapter);

        lsView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                view.setSelected(true);
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra(AGE_MSG_KEY, "Item is:" + myItems[i]);
                startActivity(intent);
            }
        });
        edTxt1 = (EditText)findViewById(R.id.edtTxt_ma1);
        edTxt2 = (EditText)findViewById(R.id.edtTxt2_ma1);

        btn1 = (Button)findViewById(R.id.btn_ma1);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                age =  edTxt1.getText().toString();
                name =  edTxt2.getText().toString();
                if((age.length()==0)||(name.length()==0)){
                    if(age.length()==0){edTxt1.setError("Age cannot be empty");}
                    else {edTxt2.setError("Name cannot be empty");}
                }
                else{
                    Intent intent2 = new Intent(MainActivity.this, Main2Activity.class);
                    intent2.putExtra(AGE_MSG_KEY, "Age is:  " + Integer.parseInt(age));
                    intent2.putExtra(NAME_MSG_KEY, "Name is: " + name);
                    startActivity(intent2);
                }
            }
        });

    }

}