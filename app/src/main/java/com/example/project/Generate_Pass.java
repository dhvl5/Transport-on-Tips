package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Generate_Pass extends AppCompatActivity
{
    EditText fullName, email, phone, dob, address, aadharNumber;
    RadioGroup radioGroup;
    DatePickerDialog datePickerDialog;
    String url = "https://creartproducts.com/student_api/transportontips/user_pass_add.php";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate__pass);

        fullName = findViewById(R.id.FullName);
        email = findViewById(R.id.Email);
        phone = findViewById(R.id.phone);
        dob = findViewById(R.id.dob);
        address = findViewById(R.id.add);
        aadharNumber = findViewById(R.id.Aadhar_num);
        radioGroup = findViewById(R.id.rg);

        dob.setInputType(InputType.TYPE_NULL);
        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                datePickerDialog = new DatePickerDialog(Generate_Pass.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String temp = year + "-" + (month+1) + "-" + dayOfMonth;
                        dob.setText(temp);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });
    }

    public void GeneratePass()
    {
        final String fullName1 = fullName.getText().toString();
        final String email1 = email.getText().toString();
        final String phone1 = phone.getText().toString();
        final String dob1 = dob.getText().toString();
        final String address1 = address.getText().toString();
        final String aadharNumber1 = aadharNumber.getText().toString();
        int id = 0;

        if(radioGroup.getCheckedRadioButtonId() == R.id.rb1)
            id = 1;
        else if(radioGroup.getCheckedRadioButtonId() == R.id.rb2)
            id = 2;

        if(TextUtils.isEmpty(fullName1))
        {
            fullName.setError("Enter your Full Name");
            fullName.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(email1) || !Patterns.EMAIL_ADDRESS.matcher(email1).matches())
        {
            email.setError("Enter your Email");
            email.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(phone1) || TextUtils.getTrimmedLength(phone1) != 10)
        {
            phone.setError("Enter 10 Digit Mobile No.");
            phone.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(address1))
        {
            address.setError("Enter Address");
            address.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(aadharNumber1))
        {
            aadharNumber.setError("Enter your Full Name");
            aadharNumber.requestFocus();
            return;
        }

        int finalId = id;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String error = jsonObject.getString("error");
                    String message = jsonObject.getString("msg");
                    if (error.equals("0")) {
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Generate_Pass.this, mycard.class);
                        startActivity(intent);

                        SharedPreferences.Editor editor;
                        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("MenuItemVisibility", Context.MODE_PRIVATE);
                        editor = sharedPreferences.edit();
                        editor.putString("visible", "visible");
                        editor.apply();
                        editor.commit();
                    } else {
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String> params = new HashMap<>();
                params.put("name", fullName1);
                params.put("email", email1);
                params.put("mobile", phone1);
                params.put("dob", dob1);
                params.put("address", address1);
                params.put("adharcard_no", aadharNumber1);
                params.put("pass_cate_id", String.valueOf(finalId));
                return params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }

    public void almost(View view)
    {
        GeneratePass();
    }
}



















