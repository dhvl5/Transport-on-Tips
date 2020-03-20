package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Createacc extends AppCompatActivity
{
    String url="https://creartproducts.com/student_api/transportontips/user_add.php";
    EditText name, email,password,mobile_number;
    Spinner gender;
    public Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acc_create);
        name=findViewById(R.id.edtFullname);
        email = findViewById(R.id.edtEmail);
        mobile_number = findViewById(R.id.edtMobileNumber);
        password = findViewById(R.id.edtPassword);
        gender = findViewById(R.id.edtGender);
        nextButton = findViewById(R.id.nxtBtn);
        nextButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                addUser();
            }
        });
    }

    public void SkipButton(View view)
    {
        Intent intent = new Intent(getApplicationContext(), activity_journeywologin.class);
        startActivity(intent);
    }

    public void addUser()
    {
        final String name1 = name.getText().toString();
        final String email1 = email.getText().toString();
        final String gender1 = gender.getSelectedItem().toString();
        final String mobile1 = mobile_number.getText().toString();
        final String password1 = password.getText().toString();

        if (TextUtils.isEmpty(name1))
        {
            name.setError("Enter UserName");
            name.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(email1) || !Patterns.EMAIL_ADDRESS.matcher(email1).matches())
        {
            email.setError("Enter Valid Email-ID");
            email.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(mobile1) || TextUtils.getTrimmedLength(mobile1)!=10)
        {
            mobile_number.setError("Enter 10 Digit Mobile No..");
            mobile_number.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(name1))
        {
            name.setError("Enter UserName");
            name.requestFocus();
            return;
        }
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                try
                {
                    JSONObject jsonObject = new JSONObject(response);
                    String error = jsonObject.getString("error");
                    String message = jsonObject.getString("msg");
                    if (error.equals("0"))
                    {
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Createacc.this, Login.class );
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }, error -> Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show())
        {
            protected Map<String, String> getParams()
            {
                Map<String, String> params = new HashMap<>();
                params.put("name", name1);
                params.put("email", email1);
                params.put("mobile", mobile1);
                params.put("gender", gender1);
                params.put("password", password1);
                return params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }
}