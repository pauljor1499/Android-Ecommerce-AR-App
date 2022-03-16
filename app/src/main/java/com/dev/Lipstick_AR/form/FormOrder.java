package com.dev.Lipstick_AR.form;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.Lipstick_AR.form.dialog.OrderSuccess;
import com.dev.Lipstick_AR.form.service.Check_Internet;
import com.dev.Lipstick_AR.product_catalog.ProductCatalog;
import com.dev.Lipstick_AR.R;
import com.dev.Lipstick_AR.email_service.GMailService;
import com.dev.Lipstick_AR.form.dialog.CheckInternet;
import com.google.android.material.textfield.TextInputLayout;


public class FormOrder extends AppCompatActivity {

    //Bundle
    public static String txt_items, txt_price, txt_quantity, txt_total;
    //
    private Check_Internet check_internet = new Check_Internet();
    private GMailService sender;
    //
    private TextInputLayout txt_firstname, txt_middlename, txt_lastname, txt_address, txt_email, txt_phone;
    private TextView prod_name, order_items, order_total, prod_quantity, form_total;
    private Button place_order;
    private ImageButton cart, buttonBack;
    private ImageView title_bar;
    //Sender
    private String username = "sophieparisforever@gmail.com";
    private String password = "0910916cvwkxam";
    //Notify the Seller
    private String subject, body;
    private String recipient = "pauljorhahaha@gmail.com";
    private String msg_quantity = "";
    //Notify the Customer
    private String subject1, body1, recipient1;
    private String getFirstname, getMiddlename, getLastname, getAddress, getEmail, getPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_order);

        //hide on-screen bottom navigation
//        getWindow().getDecorView().setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
//                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        prod_name = (TextView) findViewById(R.id.order_productName);
        order_items = (TextView) findViewById(R.id.order_items);
        prod_quantity = (TextView) findViewById(R.id.order_total_items);
        order_total = (TextView) findViewById(R.id.order_total_payment);
        form_total = (TextView) findViewById(R.id.form_Total);
        prod_quantity = (TextView) findViewById(R.id.order_total_items);

        order_items.setText(txt_items);

        if (Double.parseDouble(txt_quantity)>1){
            prod_quantity.setText("Total Items: " + txt_quantity +"pcs");
            msg_quantity = txt_quantity.toString()+"pcs";
        }else{
            prod_quantity.setText("Total Items: " + txt_quantity +"pc");
            msg_quantity = txt_quantity.toString()+"pc";
        }

        order_total.setText("Total Payment: ₱" + txt_total);
        form_total.setText("₱" + txt_total);

        cart = (ImageButton) findViewById(R.id.catalog_cart_icon);
        cart.setVisibility(View.INVISIBLE);

        buttonBack = (ImageButton) findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        place_order = findViewById(R.id.form_PlaceOrder);

        sender = new GMailService(username, password);

//        Bundle bundle = getIntent().getExtras();
//        if (bundle!=null){
//            txt_name = bundle.getString("NAME");
//            txt_price = bundle.getString("PRICE");
//            txt_quantity = bundle.getString("QUANTITY");
//            txt_total = bundle.getString("TOTAL");
//
//            prod_name.setText("Product name: " + txt_name);
//            prod_price.setText("Product price: " + txt_price);
//            prod_quantity.setText("Product quantity: " + txt_quantity);
//            order_total.setText("Total Payment: " + txt_total);
//        }

        txt_firstname = findViewById(R.id.firstname);
        txt_middlename = findViewById(R.id.middlename);
        txt_lastname = findViewById(R.id.lastname);
        txt_address = findViewById(R.id.address);
        txt_email = findViewById(R.id.email);
        txt_phone = findViewById(R.id.phone);


        place_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getFirstname = txt_firstname.getEditText().getText().toString().trim();
                getMiddlename = txt_middlename.getEditText().getText().toString().trim();
                getLastname = txt_lastname.getEditText().getText().toString().trim();
                getAddress = txt_address.getEditText().getText().toString().trim();
                getEmail = txt_email.getEditText().getText().toString().trim();
                getPhone = txt_phone.getEditText().getText().toString().trim();


                if (!check_internet.isConnected(FormOrder.this)){
                    CheckInternet check_internet = new CheckInternet();
                    check_internet.show(getSupportFragmentManager(), "my dialog");

                }else{

                    //Start Action
                    if (
                            validateFields() != true

                    ){
                        Toast.makeText(FormOrder.this, "Invalid", Toast.LENGTH_SHORT).show();

                    }else{
                        subject = "SOPHIE PARIS LIPSTICK ORDER";
                        body = "NEW ORDER HAS ARRIVED!!!" + "\n \n" +
                                "Customer Details:" + "\n" +
                                "Name: " + txt_firstname.getEditText().getText().toString().trim() + " " +
                                txt_middlename.getEditText().getText().toString().trim() + " " +
                                txt_lastname.getEditText().getText().toString().trim() + "\n" +
                                "Home Address: " + txt_address.getEditText().getText().toString().trim() + "\n" +
                                "Email: " + txt_email.getEditText().getText().toString().trim() + "\n" +
                                "Phone Number: +63" + txt_phone.getEditText().getText().toString().trim() + "\n \n" +
                                "Order Details: \n" +
                                "Items: \n" + txt_items +
                                "Total Items: " + msg_quantity + "\n" +
                                "Total Payment: ₱" + txt_total;

                        subject1 = "SOPHIE PARIS LIPSTICK ORDER";
                        body1 = "Thank you for purchasing our product/s, "+txt_firstname.getEditText().getText().toString().trim() +" "+
                                txt_middlename.getEditText().getText().toString().trim()+" "+
                                txt_lastname.getEditText().getText().toString().trim()+"!" + "\n" +

                                "Customer Details:" + "\n" +
                                "Name: " + txt_firstname.getEditText().getText().toString().trim() + " " +
                                txt_middlename.getEditText().getText().toString().trim() + " " +
                                txt_lastname.getEditText().getText().toString().trim() + "\n" +
                                "Home Address: " + txt_address.getEditText().getText().toString().trim() + "\n" +
                                "Email: " + txt_email.getEditText().getText().toString().trim() + "\n" +
                                "Phone Number: +63" + txt_phone.getEditText().getText().toString().trim() + "\n \n" +
                                "Order Details: \n" +
                                "Items: \n" + txt_items +
                                "Total Items: " + msg_quantity + "\n" +
                                "Total Payment: ₱" + txt_total;
                        recipient1 = txt_email.getEditText().getText().toString().trim();
                        new MyAsyncClass().execute();
                    }
                }
            }

            private boolean validateFields(){
                boolean check_firstname = validateFirstname(getFirstname);
                boolean check_middlename = validateMiddlename(getMiddlename);
                boolean check_lastname = validateLastname(getLastname);
                boolean check_address = validateAddress(getAddress);
                boolean check_email = validateEmail(getEmail);
                boolean check_phone = validatePhone(getPhone);

                if(
                        check_firstname && check_middlename &&
                                check_lastname && check_address &&
                                check_email && check_phone
                ){
                    return true;

                }else{
                    return false;
                }
            }

            private boolean validateFirstname(String firstnameInput){
                if(!firstnameInput.isEmpty()){
                    txt_firstname.setError(null);
                    return true;
                }else{
                    txt_firstname.setError(" ");
                    return false;
                }
            }

            private boolean validateMiddlename(String middlenameInput){
                if(!middlenameInput.isEmpty()){
                    txt_middlename.setError(null);
                    return true;
                }else{
                    txt_middlename.setError(" ");
                    return false;
                }
            }

            private boolean validateLastname(String lastnameInput){
                if(!lastnameInput.isEmpty()){
                    txt_lastname.setError(null);
                    return true;
                }else{
                    txt_lastname.setError(" ");
                    return false;
                }
            }

            private boolean validateAddress(String addressInput){
                if(!addressInput.isEmpty()){
                    txt_address.setError(null);
                    return true;
                }else{
                    txt_address.setError(" ");
                    return false;
                }
            }

            private boolean validateEmail(String emailInput) {
                if(!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
                    txt_email.setError(null);
                    return true;
                }else{
                    txt_email.setError(" ");
                    return false;
                }
            }

            private boolean validatePhone(String phoneInput){
                if(phoneInput.length()==10){
                    txt_phone.setError(null);
                    return true;
                }else{
                    txt_phone.setError(" ");
                    return false;
                }
            }
        });

        title_bar = (ImageView) findViewById(R.id.app_bar_title);
        title_bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormOrder.this, ProductCatalog.class);
                startActivity(intent);
            }
        });
    }

    class MyAsyncClass extends AsyncTask<Void, Void, Void> {
        ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(FormOrder.this);
            pDialog.setMessage("Please wait...");
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... mApi) {
            try {
                // Add Subject, Body, Username, and Recipient.
                sender.sendMail(subject, body, username, recipient);
                sender.sendMail(subject1, body1, username, recipient1);
                Log.d("send", "done");
            }
            catch (Exception ex) {
                Log.d("exceptionsending", ex.toString());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            pDialog.cancel();
            OrderSuccess dialogBox = new OrderSuccess();
            dialogBox.show(getSupportFragmentManager(), "my dialog");
        }
    }

}


