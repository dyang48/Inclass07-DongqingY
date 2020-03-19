package com.example.inclass07_dongqingy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class Main2 extends AppCompatActivity {

    private CheckBox hasfurcheckbox = null;
    private EditText editText = null;
    private EditText editText1 = null;
    private EditText editText2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        this.setTitle("Animal Info");
        hasfurcheckbox=(CheckBox)findViewById(R.id.checkbox);
        editText=(EditText)findViewById(R.id.name);
        editText1=(EditText)findViewById(R.id.number);
        editText2=(EditText)findViewById(R.id.information);
    }

    public void submit(View view){

        String typename=editText.getText().toString();
        String value =editText1.getText().toString();
        int finalvalue=Integer.parseInt(value);
        String information=editText2.getText().toString();
        boolean hasfur = hasfurcheckbox.isChecked();
        String animalmessage=createMessageSummary(finalvalue,hasfur,typename,information);
        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra("ANIMAL_KEY",animalmessage);
        setResult(RESULT_OK,intent);
        finish();
    }

    private String createMessageSummary(int finalValue, boolean hasfur, String typename, String information){
        String animalmessage="\nAnimal Name: "+typename;
        animalmessage+="\nNumber of legs: "+finalValue;
        animalmessage+="\nHas fur? "+ hasfur;
        animalmessage+="\nMore information: "+information;
        return animalmessage;
    }

}
