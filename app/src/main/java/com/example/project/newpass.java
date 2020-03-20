package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class newpass extends AppCompatActivity
{
    EditText newEditText, conEditText;
    String email;
    String url = "https://creartproducts.com/student_api/transportontips/password_update.php";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpass);

        newEditText = findViewById(R.id.newPassword);
        conEditText = findViewById(R.id.confirmPassword);

        Intent intent = getIntent();
        email = intent.getStringExtra("email");
    }

    private void ChangePassword()
    {
        String newpassword = newEditText.getText().toString();
        String conpassword = conEditText.getText().toString();
        if(TextUtils.isEmpty(newpassword))
        {
            newEditText.setError("Enter new password");
            newEditText.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(conpassword))
        {
            conEditText.setError("Enter confirm password");
            conEditText.requestFocus();
            return;
        }
        if(!newpassword.equals(conpassword))
        {
            conEditText.setError("Password does not match");
            conEditText.requestFocus();
        }
        else
        {
            String finalpassword = conpassword;
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
                        if(error.equals("0"))
                        {
                            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(newpass.this, Login.class);
                            startActivity(intent);
                            finish();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                        }
                    }
                    catch (JSONException e)
                    {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener()
            {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            })
            {
                protected Map<String, String> getParams()
                {
                    Map<String, String> params = new HashMap<>();
                    params.put("email", email);
                    params.put("new_password", finalpassword);
                    return params;
                }
            };
            VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
        }
    }

    public void Change(View view)
    {
        ChangePassword();
    }

}
