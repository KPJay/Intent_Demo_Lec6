package com.example.priya.intent_demo_lec6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.priya.intent_demo_lec6.Utils.Utils.AGE_MSG_KEY;
import static com.example.priya.intent_demo_lec6.Utils.Utils.NAME_MSG_KEY;

public class Main2Activity extends AppCompatActivity {

    private TextView textView1,textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView1 =(TextView)findViewById(R.id.tv_ma2);
        String incomingMsg = getIntent().getStringExtra(AGE_MSG_KEY);
        textView1.setText(incomingMsg);

        textView2 =(TextView)findViewById(R.id.tv2_ma2);
        String incomingMsg2 = getIntent().getStringExtra(NAME_MSG_KEY);
        textView2.setText(incomingMsg2);

        Button btn2 = (Button)findViewById(R.id.btn_ma2);
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent3);
            }
        });
    }
}
