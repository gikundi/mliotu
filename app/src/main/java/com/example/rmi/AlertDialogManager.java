package com.example.rmi;

/**
 * Created by gikundi on 5/27/15.
 */
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;


/**
 * Created by gikundi on 4/10/15.
 */
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class AlertDialogManager {

    public void showAlertDialog(Context context, String title, String message,
                                Boolean status) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();

        // Setting Dialog Title
        alertDialog.setTitle(title);

        // Setting Dialog Message
        alertDialog.setMessage(message);

        //  if(status != null)
        // Setting alert dialog icon
        // alertDialog.setIcon((status) ? R.drawable.good_dark : R.drawable.bad_dark);
        // Setting OK Button
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        // Showing Alert Message
        alertDialog.show();
    }
}