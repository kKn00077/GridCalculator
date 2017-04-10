package kn0077.kr.hs.emirim.gridcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText text1;
    EditText text2;
    Button[] butnums=new Button[10];
    Button[] opnums=new Button[4];
    public static final int SELECT_EDIT1=0;
    public static final int SELECT_EDIT2=1;
    int selectEdit=SELECT_EDIT1; // 아무것도 터치하지 않았을 때엔 에디트텍스트 첫번째에 숫자가 입력되도록
    TextView tv;
    String numStr=""; // 에디트텍스트에 입력받은 텍스트를 누적시켜주기 위해 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1=(EditText)findViewById(R.id.text1);
        text2=(EditText)findViewById(R.id.text2);
        text1.setOnTouchListener(editHandler);
        text2.setOnTouchListener(editHandler);


        for(int i=0;i<butnums.length;i++) {
            butnums[i] = (Button) findViewById(R.id.but1+i);
            butnums[i].setOnClickListener(butNumHandler);
        }

        for(int i=0;i<opnums.length;i++) {
            opnums[i] = (Button) findViewById(R.id.op1+i);
            opnums[i].setOnClickListener(butOpHandler);
        }

        tv=(TextView)findViewById(R.id.tv);
    }

    View.OnClickListener butNumHandler=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button but=(Button)v; // getText 메서드를 불러오기 위해 선언과 형변환(getText 메서드는 view의 자식 클래스가 가지고 있음)
            numStr+=but.getText();
            switch(selectEdit){
                case SELECT_EDIT1: text1.setText(numStr); break;
                case SELECT_EDIT2: text2.setText(numStr); break;
            }
        }
    };

    View.OnClickListener butOpHandler=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int num1, num2, result;
            num1=Integer.parseInt(text1.getText().toString());
            num2=Integer.parseInt(text1.getText().toString());
            switch(v.getId()){
                case R.id.op1 : result=num1+num2;break;
                case R.id.op2 : result=num1-num2;break;
                case R.id.op3 : result=num1*num2;break;
                case R.id.op4 : result=num1/num2;break;
            }
            tv.setText(); // 으르흐윽흐그흐극규ㅠㅠㅠ
        }
    }; // 익명 클래스는 ; 필요

    View.OnTouchListener editHandler=new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            numStr=""; // 에디트 텍스트가 선택되었을때 문자열이 누적되지 않도록 초기화
            switch(v.getId()){ // 선택된 에디트텍스트가 무엇인지 판단
                case R.id.text1:
                    selectEdit=SELECT_EDIT1; break;
                case R.id.text2:
                    selectEdit=SELECT_EDIT2; break;
            }
            return true; // 터치가 되었다면 트루값을 반환
        }
    };

}