package com.example.surya.myapplication;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by surya on 9/29/17.
 */

public class RegisterRequest extends StringRequest{
    private static final String Register_request_url = "http://fwtest.ga/register.php";
    //"https://suryaraut.000webhostapp.com/register1.php";
    private Map<String, String> params;


    public RegisterRequest( String first_name, String last_name, String email, String password,
                            Response.Listener<String> listener) {
        super(Method.POST, Register_request_url, listener, null);

        params = new HashMap<>();
        params.put("first_name", first_name);
        params.put("last_name", last_name);
        params.put("email", email);
        params.put("password", password);
        //params.put("pass2", pass2);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
