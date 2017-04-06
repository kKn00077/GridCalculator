package kn0077.kr.hs.emirim.gridcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText text1;
    EditText text2;
    Button[] butnums=new Button[10];
    Button[] opnums=new Button[4];
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1=(EditText)findViewById(R.id.text1);
        text2=(EditText)findViewById(R.id.text2);


        for(int i=0;i<=butnums.length;i++) {
            butnums[i] = (Button) findViewById(R.id.but1+i);
            butnums[i].setOnClickListener(butNumHandler);
        }

        for(int i=0;i<=opnums.length;i++) {
            opnums[i] = (Button) findViewById(R.id.op1+i);
            opnums[i].setOnClickListener(butOpHandler);
        }

        tv=(TextView)findViewById(R.id.tv);
    }

    View.OnClickListener butNumHandler=new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    View.OnClickListener butOpHandler=new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    }; // 참조값을 할당받는 클래스는 ; 필요
}