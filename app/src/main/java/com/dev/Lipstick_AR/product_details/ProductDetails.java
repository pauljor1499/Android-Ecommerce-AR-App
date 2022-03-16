package com.dev.Lipstick_AR.product_details;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.Lipstick_AR.R;
import com.dev.Lipstick_AR.cart.CartActivity;
import com.dev.Lipstick_AR.cart.CartItemActivity;
import com.dev.Lipstick_AR.form.FormOrder;
import com.dev.Lipstick_AR.product_catalog.ProductCatalog;
import com.dev.Lipstick_AR.product.service.ProductList;
import com.nex3z.notificationbadge.NotificationBadge;

import java.text.DecimalFormat;

public class ProductDetails extends AppCompatActivity{

    //Badge
    public static NotificationBadge prod_details_badge;

    private ProductList prod_list = new ProductList();
    private TextView product_name, product_price, quantity ,total;
    private ImageView product_image, title_bar;
    private ImageButton buttonBack, cartIcon;
    //Bundle
    private String item_name, item_price;
    private int item_image;
    //
    private int count_quantity = 1;
    private double price;
    private double count_total = 0.0;
    //
    private DecimalFormat df = new DecimalFormat(",###.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        //hide on-screen bottom navigation
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        product_image = (ImageView) findViewById(R.id.detailsProductImage);
        product_name = (TextView) findViewById(R.id.detailsProductName);
        product_price = (TextView) findViewById(R.id.detailsProductPrice);
        quantity = (TextView) findViewById(R.id.detailsQuantity);
        total = (TextView) findViewById(R.id.detailsTotalPayment);

        //Get Value From ProductView
        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            item_name = bundle.getString("LABEL");
            item_price = bundle.getString("PRICE");
            item_image = bundle.getInt("PICTURE");

            product_name.setText(item_name);
            product_price.setText(item_price);
            product_image.setImageResource(item_image);

            price = Double.parseDouble(item_price);

            count_total = (double) count_quantity * price;
            quantity.setText(count_quantity+"");
            total.setText("₱"+df.format(count_total));
        }

        title_bar = (ImageView) findViewById(R.id.app_bar_title);
        title_bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductDetails.this, ProductCatalog.class);
                startActivity(intent);
            }
        });

        cartIcon = (ImageButton) findViewById(R.id.catalog_cart_icon);
        cartIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductDetails.this, CartActivity.class);
                startActivity(intent);
            }
        });

        prod_details_badge = (NotificationBadge) findViewById(R.id.catalog_cart_badge);
        prod_details_badge.setNumber(prod_list.counter);

        buttonBack = (ImageButton) findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void decrementValue(View v){
        if(count_quantity <= 1){
            count_quantity = 1;
        }else{
            count_quantity--;
        }
        count_total = (double) count_quantity * price;
        quantity.setText(count_quantity+"");
        total.setText("₱"+df.format(count_total));
    }

    public void incrementValue(View v){
        count_quantity++;
        count_total = (double) count_quantity * price;
        quantity.setText(count_quantity+"");
        total.setText("₱"+df.format(count_total));
    }

    public void addToCart(View v){
        prod_list.addCartItem(
                product_name.getText().toString(),
                product_price.getText().toString(),
                count_quantity,
                count_total);

        Intent intent = new Intent(this, CartActivity.class);
        startActivity(intent);

        Toast.makeText(this, "Item successfully added.", Toast.LENGTH_SHORT).show();
    }
}