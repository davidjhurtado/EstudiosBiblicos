package com.mycompany.myapp;

import android.app.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.*;
//import android.view.*;

import android.view.View;
import android.widget.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import android.content.*;

public class RegisterActivity extends Activity
{
    EditText txtNombre;
    EditText txtDireccion;
    EditText txtPhone;
    EditText txtEmail;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
       try {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
		} catch (Exception e){
			System.out.println(e.toString());
		}
	    
    }

    public void InsertarUsuario(){
        User user = new User();
        txtNombre = (EditText)findViewById(R.id.txtNombre);
        txtDireccion = (EditText)findViewById(R.id.txtDireccion);
        txtPhone = (EditText)findViewById(R.id.txtPhone);
        txtEmail = (EditText)findViewById(R.id.txtEmail);
        user.setNombre(txtNombre.getText().toString());
        user.setDireccion((txtDireccion.getText().toString()));
        user.setTelefono(txtPhone.getText().toString());
        user.setEmail(txtEmail.getText().toString());
        StudiesDBHelper sdhUser = new StudiesDBHelper(this);
        if (sdhUser.insertUser(user)) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("Datos completados!");
            alert.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface Dialog, int id) {
                }
            });
            alert.create();
            alert.show();
            Intent act = new Intent(this,StudiesActivity.class);
            startActivity(act);
        }
    }

    public boolean ValidateData (){
        boolean result;
        result = true;
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtDireccion = (EditText)findViewById(R.id.txtDireccion);
        txtPhone = (EditText)findViewById(R.id.txtPhone);
        txtEmail = (EditText)findViewById(R.id.txtEmail);
        if (txtNombre.length() < 2 && txtDireccion.length() < 6 && txtPhone.length() < 6 && txtEmail.length() < 5){
            result = false;
        }
        if (!checkemail(txtEmail.getText().toString())){
            txtEmail.setError("Formato Inválido!");
            result = false;
        }
        return result;
    }
    public boolean checkemail(String email) {
        boolean emailcheck;
        Pattern pattern = Pattern.compile(".+@.+.[a-z]+");
        Matcher matcher = pattern.matcher(email);
        emailcheck = matcher.matches();
        return emailcheck;
    }
    public  void onClickBtnRegistrar (View v){
        try {
            if (ValidateData()) {
                InsertarUsuario();
            }
        } catch (Exception vEx) {
            Toast toast = Toast.makeText(this, vEx.getMessage(), Toast.LENGTH_LONG);
            toast.show();

        }
    }
	
}
