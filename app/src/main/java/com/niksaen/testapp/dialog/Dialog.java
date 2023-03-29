package com.niksaen.testapp.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AlertDialog;

import com.niksaen.testapp.databinding.DialogBinding;
import com.niksaen.testapp.models.Quote;

public class Dialog {
    DialogBinding ui;
    Context context;
    AlertDialog.Builder builder;
    AlertDialog dialog;

    public Dialog(Context context){
        this.context = context;
        ui = DialogBinding.inflate(LayoutInflater.from(context));
        builder = new AlertDialog.Builder(context);
    }
    public void show(Quote quote){
        builder.setView(ui.getRoot());
        dialog = builder.create();
        ui.button.setOnClickListener(v -> dialog.dismiss());
        ui.author.setText(quote.getAuthor());
        ui.content.setText("\""+quote.getContent()+"\"");
        dialog.show();
    }
}
