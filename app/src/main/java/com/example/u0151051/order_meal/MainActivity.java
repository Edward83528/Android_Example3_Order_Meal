package com.example.u0151051.order_meal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 第一步:建立元件(先宣告元件)
    Button bt;
    TextView tv4;
    EditText et;
    // Ratio group中的小選項(多選一)
    RadioButton rb1, rb2, rb3, rb4;
    // 可複選
    CheckBox cb1, cb2, cb3, cb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findview();
    }

    // 第一步:建立一方法建立元件
    void findview() {
        bt = (Button) findViewById(R.id.button2);
        tv4 = (TextView) findViewById(R.id.textView4);
        et = (EditText) findViewById(R.id.editText);
        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        rb4 = (RadioButton) findViewById(R.id.radioButton4);
        cb1 = (CheckBox) findViewById(R.id.checkBox);
        // 可以利用setTag設立一個標籤(放物件,會自動autoboxing)再用gettag取用標籤
        cb1.setTag(100.0);// cb1.setTag(new Double 100.0)
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        cb2.setTag(150.0);
        cb3 = (CheckBox) findViewById(R.id.checkBox3);
        cb3.setTag(200.0);
        cb4 = (CheckBox) findViewById(R.id.checkBox4);
        cb4.setTag(250.0);
        // 第三步:設監聽器給元件
        bt.setOnClickListener(c);
    }

    // 第二步:建立監聽器
    View.OnClickListener c = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // 建立 StringBuilder不會浪費記憶體
            StringBuilder s = new StringBuilder();
            // TextView.getText().toString()
            s.append("桌號:").append(et.getText().toString()).append("\n");
            // isChecked()有沒有被選到
            if (rb1.isChecked()) {
                s.append(rb1.getText()).append("\n");
            } else {
                s.append(rb2.getText()).append("\n");
            }
            s.append("主餐").append("\n");
            double money = 0;
            if (cb1.isChecked()) {
                s.append(cb1.getText()).append("\n");
                money = money + (Double) cb1.getTag();
            }
            if (cb2.isChecked()) {
                s.append(cb2.getText()).append("\n");
                money = money + (Double) cb2.getTag();
            }
            if (cb3.isChecked()) {
                s.append(cb3.getText()).append("\n");
                money = money + (Double) cb3.getTag();
            }
            if (cb4.isChecked()) {
                s.append(cb4.getText()).append("\n");
                money = money + (Double) cb4.getTag();
            }
            s.append("附餐:").append("\n");
            if (rb3.isChecked()) {
                s.append(rb3.getText().toString()).append("\n");
            } else {
                s.append(rb4.getText().toString()).append("\n");
            }
            if (rb1.isChecked()) {
                money *= 0.8;
            }
            s.append("共").append(money).append("元");
            // 把TextView顯示文字:TextView.setText()
            tv4.setText(s);

        }
    };
}
