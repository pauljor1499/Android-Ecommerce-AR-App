package com.dev.Lipstick_AR.form.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.dev.Lipstick_AR.product_catalog.ProductCatalog;

public class OrderSuccess extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle saveInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("")
                .setMessage("Thank you for purchasing! \n\nOrder successfully sent.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        startActivity(new Intent(getActivity(), ProductCatalog.class));
                    }
                });
        return builder.create();
    }
}
