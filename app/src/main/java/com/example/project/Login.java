package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity
{
    String url = "https://creartproducts.com/student_api/transportontips/user_login.php";
    EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("UserLogin", Context.MODE_PRIVATE);
        if(sharedPreferences.contains("login"))
        {
            startActivity(new Intent(Login.this, PlanJourney.class));
            finish();
        }

        email = findViewById(R.id.emailLogin);
        password = findViewById(R.id.passwordLogin);
    }

    public void LoginUser()
    {
        final String email1 = email.getText().toString();
        final String password1 = password.getText().toString();

        if(TextUtils.isEmpty(email1) || !Patterns.EMAIL_ADDRESS.matcher(email1).matches())
        {
            email.setError("Enter Email");
            email.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(password1))
        {
            password.setError("Enter Password");
            password.requestFocus();
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
                    Log.e("json response", error);
                    if(error.equals("0"))
                    {
                        Toast.makeText(getApplicationContext(), "Login Successfully!!", Toast.LENGTH_SHORT).show();
                        JSONObject data = jsonObject.getJSONObject("data");
                        String email = data.getString("email");

                        SharedPreferences.Editor editor;
                        SharedPreferences preferences;
                        preferences = getApplicationContext().getSharedPreferences("UserLogin",
                                Context.MODE_PRIVATE);
                        editor = preferences.edit();
                        editor.putString("login", email);
                        editor.apply();
                        editor.commit();

                        Intent intent = new Intent(Login.this, PlanJourney.class);
                        startActivity(intent);
                        finish();
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
        },
        error -> Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show())
        {
            protected Map<String, String> getParams()
            {
                Map<String, String> params = new HashMap<>();
                params.put("email", email1);
                params.put("password", password1);
                return params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }

    public void SkipButton(View view)
    {
        Intent intent = new Intent(getApplicationContext(), activity_journeywologin.class);
        startActivity(intent);
    }
    public void login(View view)
    {
        LoginUser();
    }
    public void show(View view)
    {
        Intent intent = new Intent(getApplicationContext(), Createacc.class);
        startActivity(intent);
    }
    public void forgot(View view)
    {
        Intent intent = new Intent(getApplicationContext(), Forgotpass.class);
        startActivity(intent);
    }
}
