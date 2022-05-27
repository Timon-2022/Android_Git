package com.example.app01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app01.enroll.Enrollpage;

import java.util.ArrayList;
import java.util.List;

/*
实现内容：
1.一个基本的登录UI
2.+上一个判断，在账户和密码正确的情况下如何跳转到一个新的界面
3.错误的情况下，弹出一则信息

拓展部分
1.如果用户名和米姆是一个EXCEL或者数据库考虑IO

 */
public class MainActivity extends AppCompatActivity {


    //(1)create two list to save the data of enroll name and password
    public List<String> userNameList = new ArrayList<>();
    public List<String> userPassList = new ArrayList();
    //(2)initialize the list and put the default value of name and password

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



// add listener on button"login in "
        //1.get the button by "findviewByid" method
        //2.transfer the type into Button
        Button button = (Button) this.findViewById(R.id.buttonlogin);
        Button buttonEnroll = (Button) this.findViewById(R.id.buttonEnroll);
        Button buttonEnter = (Button) this.findViewById(R.id.buttonenter);
        // 3.create a clicklistener and put it on the object button
        // 4. method "inner class"在实际开发中，我们常常遇到这样的情况：
        // 一个接口/类的方法的某个实现方式在程序中只会执行一次，但为了使用它，
        // 我们需要创建它的实现类/子类去实现/重写。此时可以使用匿名内部类的方式，
        // 可以无需创建新的类，减少代码冗余。
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //5.initial the object name and password
                //notion: there "this" is not represent the class"MainActivity"
                //in order to use the main class,we use"MainActivity.this" instead of "this"
                //also , we need to transfer the object type.
                EditText userName = (EditText) MainActivity.this.findViewById(R.id.editTextTextPersonName);
                EditText userPassword = (EditText) MainActivity.this.findViewById(R.id.editTextTextPassword2);

                //6.assign the String with the message we get
                String name = userName.getText().toString();
                String password = userPassword.getText().toString();

                // we need to check if we get the correct message we need
                //7. print the name and password

                Log.i("MainActivity 1st check out line ","name ="+name+"\nPassword= "+password);
                int flag=0;
//                userNameList.add("Timon");
//                userNameList.add("123");
//
                for (int i = 0; i <userNameList.size() ; i++) {

                    String n = userNameList.get(i);
                    if(n.equals(name)){flag++;}
//

                }
                for (int j = 0; j < userPassList.size(); j++) {

                }

                if("Timon".equals(name)&&"123".equals(password)){

                    Intent intent1 = new Intent(MainActivity.this,Homepage1.class);
                    intent1.putExtra("name",name);
                    MainActivity.this.startActivity(intent1);

                }else{
                    Toast toast=Toast.makeText(MainActivity.this, "密码错误或账户不存在！", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    //Toast.makeText(MainActivity.this,"密码错误或账户不存在！",Toast.LENGTH_LONG).show();
                }

            }
        });
        
        buttonEnroll.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, Enrollpage.class);
                MainActivity.this.startActivity(intent2);
                
            }
        });
        buttonEnter.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent8 = new Intent(MainActivity.this, Homepage1.class);
                MainActivity.this.startActivity(intent8);

            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();



    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}