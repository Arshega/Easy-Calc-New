package com.vincent.arriesga.easycalcnew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editFirsNum;
    EditText editSecondNum;
    Button btnPlus;
    Button btnMinus;
    Button btnClear;
    Button btnMul;
    Button btnDiv;
    Button btnExit;
    TextView txtAns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findviews();
    }


    private void findviews(){
        editFirsNum = (EditText) findViewById(R.id.editFirstNum);
        String errorNum1 = editFirsNum.getText().toString();
        if (TextUtils.isEmpty(errorNum1)){
            editFirsNum.setError("Please Enter a Valid Number");

        }
        editSecondNum = (EditText) findViewById(R.id.editSecondNum);
        String errorNum2 = editSecondNum.getText().toString();
        if (TextUtils.isEmpty(errorNum2)){
            editSecondNum.setError("Please Enter a Valid Number");

        }
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnExit = (Button) findViewById(R.id.btnExit);
        txtAns = (TextView) findViewById(R.id.txtAns);

        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnExit.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        double num1 = Double.parseDouble(editFirsNum.getText().toString());
        double num2 = Double.parseDouble(editSecondNum.getText().toString());
        double result;
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        String Formats;
        switch (v.getId()){
            case R.id.btnPlus:
                result = num1 + num2;
                Formats = formatter.format(result);
                txtAns.setText(Formats);
                break;
            case R.id.btnMinus:
                result = num1 - num2;
                Formats = formatter.format(result);
                txtAns.setText(Formats);
                break;
            case R.id.btnMul:
                result = num1 * num2;
                Formats = formatter.format(result);
                txtAns.setText(Formats);
                break;
            case R.id.btnDiv:
                result = num1 / num2;
                Formats = formatter.format(result);
                txtAns.setText(Formats);
                break;
            case R.id.btnClear:
                editFirsNum.setText(" ");
                editSecondNum.setText(" ");
                txtAns.setText(" ");
                break;
            case R.id.btnExit:
                finish();
                break;
        }
    }
}
