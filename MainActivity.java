package com.ancientlore.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String DIGITS="0123456789.";
    private static final String OPERATIONS="/*-+";
    private TextView textViewExp;
    private TextView textViewRes;
    private double operand1=0;
    private double operand2=0;
    private char operation=' ';
    private double result=0;
    //private StringBuilder string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            findViewById(R.id.button0).setOnClickListener(this);
            findViewById(R.id.button1).setOnClickListener(this);
            findViewById(R.id.button2).setOnClickListener(this);
            findViewById(R.id.button3).setOnClickListener(this);
            findViewById(R.id.button4).setOnClickListener(this);
            findViewById(R.id.button5).setOnClickListener(this);
            findViewById(R.id.button6).setOnClickListener(this);
            findViewById(R.id.button7).setOnClickListener(this);
            findViewById(R.id.button8).setOnClickListener(this);
            findViewById(R.id.button9).setOnClickListener(this);
            findViewById(R.id.buttonAdd).setOnClickListener(this);
            findViewById(R.id.buttonSub).setOnClickListener(this);
            findViewById(R.id.buttonMod).setOnClickListener(this);
            findViewById(R.id.buttonMult).setOnClickListener(this);
            findViewById(R.id.buttonDiv).setOnClickListener(this);
            findViewById(R.id.buttonDel).setOnClickListener(this);
            findViewById(R.id.buttonDot).setOnClickListener(this);
            findViewById(R.id.buttonBracket).setOnClickListener(this);
            findViewById(R.id.buttonCancel).setOnClickListener(this);
            findViewById(R.id.buttonResult).setOnClickListener(this);
        textViewExp=(TextView)findViewById(R.id.textViewExpression);
        textViewRes=(TextView)findViewById(R.id.textViewResult);
        //string=new StringBuilder("");
    }

    private void parseLine(int line){}

    @Override
    public void onClick(View v) {
        Button button=(Button)findViewById(v.getId());
        switch (button.getId()){
            case R.id.buttonCancel:
                operation=' ';
                textViewExp.setText("");
                textViewRes.setText("");
                break;
            case R.id.buttonResult:
                calc();
                reset();
                break;
            case R.id.buttonDel:
                StringBuilder strb=new StringBuilder(textViewExp.getText());
                if(strb.length()>0)
                    strb.deleteCharAt(strb.length()-1);
                textViewExp.setText(strb);
                break;
            case R.id.buttonDiv:case R.id.buttonMult:case R.id.buttonMod:
            case R.id.buttonAdd:case R.id.buttonSub:
                if (OPERATIONS.contains(""+operation))
                    break;
                TextView tmpTextView;
                if (!textViewExp.getText().equals(""))
                    tmpTextView=textViewExp;
                else if (!textViewRes.getText().equals(""))
                    tmpTextView=textViewRes;
                else break;
                operand1= Double.parseDouble(tmpTextView.getText().toString());
                String str=tmpTextView.getText().toString();
                operation=button.getText().charAt(0);
                textViewRes.setText(str+" "+operation);
                textViewExp.setText("");
                break;
            case R.id.buttonDot:
                String str2=textViewExp.getText().toString();
                if(!str2.contains("."))
                    textViewExp.setText(textViewExp.getText()+".");
                break;
            default:
                if(textViewExp.getText().length()==1 && textViewExp.getText().charAt(0)=='0')
                    textViewExp.setText(button.getText());
                else textViewExp.setText(textViewExp.getText()+""+button.getText());
                break;
        }
    }
    private void calc(){
        operand2=Double.parseDouble(textViewExp.getText().toString());
        switch (operation){
            case '/':
                if (operand2!=0)
                    result=operand1/operand2;
                break;
            case '*':
                result=operand1*operand2;
                break;
            case '-':
                result=operand1-operand2;
                break;
            case '+':
                result=operand1+operand2;
                break;
            case '%':
                result=operand1%operand2;
                break;
        }
    }
    private void reset(){
        operand1=0;
        operand2=0;
        operation=' ';
        textViewExp.setText("");
        textViewRes.setText(""+result);
    }
}
        /*switch (v.getId()){
            case R.id.buttonCancel:
                string=new StringBuilder("");
                textViewExp.setText("0");
                textViewRes.setText("0");
                break;
            case R.id.buttonResult:
                textViewRes.setText(""+result);
                break;
            case R.id.buttonDelete:
                if(string.length()>1) {
                    string.deleteCharAt(string.length() - 1);
                    textViewExp.setText(string);
                }else textViewExp.setText("0");
                break;
            case R.id.buttonDivide:case R.id.buttonMultiply:case R.id.buttonMod:
            case R.id.buttonPlus:case R.id.buttonMinus:case R.id.buttonDot:
                char last=string.charAt(string.length()-1);
                if (last=='/' || last=='*' || last=='+' || last=='-' || last=='%')
                    break;
                if (string.)
            default:
                Button button=(Button)findViewById(v.getId());
                string.append(button.getText());
                textViewExp.setText(string);
                break;*/
