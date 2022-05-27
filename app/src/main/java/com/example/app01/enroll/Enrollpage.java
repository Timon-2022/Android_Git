package com.example.app01.enroll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app01.MainActivity;
import com.example.app01.R;

import java.util.ArrayList;

public class Enrollpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enrollpage);

        ArrayList enrollList = new ArrayList<>();

        //1.create a button listener
        Button btCreate = (Button) this.findViewById(R.id.buttonCreate);

        btCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText newName = (EditText) Enrollpage.this.findViewById(R.id.editTextTextNewName);
                EditText newPassword = (EditText) Enrollpage.this.findViewById(R.id.editTextNewPassword);
                EditText newPasswordRe = (EditText) Enrollpage.this.findViewById(R.id.editTextNewPasswordRe);

                //6.assign the String with the message we get
                String name =newName.getText().toString();
                String password = newPassword.getText().toString();
                String passwordRe = newPasswordRe.getText().toString();

                Log.i("Enrollpage 1st check out line ","name ="+name+"\nPassword= "+password);


                if(passwordRe.equals(password)){

                    Toast toast=Toast.makeText(Enrollpage.this, "创建账号成功!\n\n        请登录", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();

                    Intent intent3 = new Intent(Enrollpage.this, MainActivity.class);
                    Enrollpage.this.startActivity(intent3);

                    enrollList.add(name);
                    enrollList.add(password);
                    intent3.putStringArrayListExtra("Enroll",enrollList);
                    Log.i("Enrollpage 2nd check out line ","enrollList ="+enrollList);

                }else{
                    Toast toast=Toast.makeText(Enrollpage.this, "两次输入的密码不一致！", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    //Toast.makeText(MainActivity.this,"密码错误或账户不存在！",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}