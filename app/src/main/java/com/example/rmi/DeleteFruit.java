package com.example.rmi;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;


import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rmi.ServiceHandler;

public class DeleteFruit extends Activity {

    public String msg;



    EditText txtvid,txtmodel;
    Button btnSubmit;

    //ProgressDialog pDialog;
    private ProgressDialog pDialog;
    AlertDialogManager alert= new AlertDialogManager();

    // URL to get contacts JSON
    private static String url = "http://10.51.4.117:8080/TestWeb/DeleteFruitClientServlet";



    // JSON Node names
    private static final String KEY_SUCCESS = "success";

    String strvid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_fruit);



        btnSubmit = (Button) findViewById(R.id.btnDelete);
        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //initialize the edittext
                txtvid = (EditText) findViewById(R.id.name);
                //  txtmake = (EditText) findViewById(R.id.make);
               // txtmodel = (EditText) findViewById(R.id.price);



                //read data entered from the screen

                strvid = txtvid.getText().toString().trim();
                //   strmake = txtmake.getText().toString().trim();
              //  strmodel = txtmodel.getText().toString().trim();

                //initialize the Textview
                //display = (TextView) findViewById(R.id.display);
                new AddManager().execute();


            }
        });



    }

    /**
     * Async task class to get json by making HTTP call
     * */
    private class AddManager extends AsyncTask<Void, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(DeleteFruit.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected String doInBackground(Void... arg0) {
            String result = null;

            strvid = txtvid.getText().toString().trim();
            //  strmake = txtmake.getText().toString().trim();
           // strmodel = txtmodel.getText().toString().trim();



            // Toast.makeText(getApplicationContext(), "Enginge",+ strengined + "nopass"+ strnopassToast.LENGTH_SHORT).show();




            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("username", strvid));
            // params.add(new BasicNameValuePair("username",strmake));
          //  params.add(new BasicNameValuePair("price",strmodel));



            // Creating service handler class instance
            ServiceHandler sh = new ServiceHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET,params);
            JSONObject json = null;
            try {
                json = new JSONObject(jsonStr);
            } catch (JSONException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            //shows the response that we got from the http request on the logcat
            Log.d("Response: ", "> " + jsonStr);

            msg = jsonStr;

            // check for login response
            try {
                if (msg != null) {
                    // loginErrorMsg.setText("");
                    // String res = json.getString(KEY_SUCCESS);

                    result = "Success";

                }

            } catch (Exception e) {

                runOnUiThread( new Runnable() {
                    public void run() {

                        messageDialog("Login Error", "Wrong Username or Password");

                    }
                });


                e.printStackTrace();
            }

            return result;
        }

        protected void onPostExecute(String result) {
            // dismiss the dialog once done
            pDialog.dismiss();

            if (result.equalsIgnoreCase("Success")) {
                runOnUiThread( new Runnable() {
                    public void run() {

                        messageDialog("Success",msg);

                    }
                });
            }
            if (result.equalsIgnoreCase("Fail")) {
                runOnUiThread( new Runnable() {
                    public void run() {

                        messageDialog("Fail", "Vehicle Exists");

                    }
                });
            }



        }

        public void messageDialog(String title, String message){


            new AlertDialog.Builder(DeleteFruit.this)
                    .setTitle(title)
                    .setMessage(message)

                    .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {

                        }
                    })
                    .show();

        }
    }

}