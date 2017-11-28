package pnw.seancalc;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.Math;

public class CalculatorWindow extends AppCompatActivity {

    EditText operand1;
    EditText operand2;
    TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_window);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        operand1 = findViewById(R.id.editText);
        operand2 = findViewById(R.id.editText2);
        result = findViewById(R.id.editText3);

    }


   public void calculate(View view){
        String opString1, opString2;
        double op1, op2, resultNum;
        boolean errorFlag = false;

        op1 = 0.0;
        op2 = 0.0;
        resultNum = 0.0;

        opString1 = operand1.getText().toString();
        opString2 = operand2.getText().toString();

        try{
            op1 = Double.parseDouble(opString1);
            op2 = Double.parseDouble(opString2);
        }catch(NumberFormatException e){
            errorFlag = true;
        }

        switch(view.getId()){

            case R.id.buttonAdd:
                resultNum = op1 + op2;
                break;

            case R.id.buttonSub:
                resultNum = op1 - op2;
                break;

            case R.id.buttonMult:
                resultNum = op1 * op2;
                break;

            case R.id.buttonDiv:
                if(op2 == 0.0)
                    errorFlag = true;
                else
                    resultNum = op1 / op2;
                break;

            case R.id.buttonSq:
                if(op1 < 0.0)
                    errorFlag = true;
                else
                    resultNum = Math.sqrt(op1);
                break;

            case R.id.buttonPow:
                resultNum = Math.pow(op1, op2);
                break;

        }
       if(errorFlag)
           result.setText("Error");

       else
           result.setText(Double.toString(resultNum));

   }

   public void clearAll(View v){
       result.setText("");
       operand1.setText("");
       operand2.setText("");
   }

}
