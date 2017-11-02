package com.example.surya.myapplication;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by surya on 9/29/17.
 */

public class RegisterRequest extends StringRequest{
    private static final String Register_request_url = "https://lovethesnipers.000webhostapp.com/newRegister.php";
    private Map<String, String> params;


    public RegisterRequest( String firstname, String lastname, String email, String pass, String pass2,
                            Response.Listener<String> listener) {
        super(Method.POST, Register_request_url, listener, null);

        params = new HashMap<>();
        params.put("firstname", firstname);
        params.put("lastname", lastname);
        params.put("email", email);
        params.put("pass", pass);
        params.put("pass2", pass2);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
