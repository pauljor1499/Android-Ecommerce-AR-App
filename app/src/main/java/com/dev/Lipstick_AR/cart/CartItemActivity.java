package com.dev.Lipstick_AR.cart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.Lipstick_AR.product_catalog.ProductCatalog;
import com.dev.Lipstick_AR.product.service.ProductList;
import com.dev.Lipstick_AR.R;

import java.text.DecimalFormat;

public class CartItemActivity extends AppCompatActivity {

    private ProductList prod_list = new ProductList();
    private ImageButton buttonBack, cartIcon;
    private Button buttonRemove;
    private TextView product_name, product_price, product_quantity ,product_total;
    private ImageView product_image, title_bar;
    //Bundle
    private String item_name, item_price;
    private int item_quantity;
    private double item_total;
    private int item_image;
    //
    private double price;
    private DecimalFormat df = new DecimalFormat(",###.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_item);

        //hide on-screen bottom navigation
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        product_image = (ImageView) findViewById(R.id.cart_item_ProductImage);
        product_name = (TextView) findViewById(R.id.cart_item_ProductName);
        product_price = (TextView) findViewById(R.id.cart_item_ProductPrice);
        product_quantity = (TextView) findViewById(R.id.cart_item_Quantity);
        product_total = (TextView) findViewById(R.id.cart_item_TotalPayment);

        //Get Value From CartActivity
        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            item_name = bundle.getString("NAME");
            item_price = bundle.getString("PRICE");
            item_image = bundle.getInt("PICTURE");
            item_quantity = bundle.getInt("QUANTITY");
            item_total = bundle.getDouble("TOTAL");

            product_name.setText(item_name);
            product_price.setText(item_price);
            product_image.setImageResource(item_image);
            product_quantity.setText(item_quantity+"");
            product_total.setText( "₱" + df.format(item_total));

            price = Double.parseDouble(item_price);
        }

        buttonBack = (ImageButton) findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prod_list.updateCartItem(item_name,  item_quantity, item_total);
                Toast.makeText(CartItemActivity.this, "Item updated.", Toast.LENGTH_SHORT).show();
                Intent intent = intent = new Intent(CartItemActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });

        title_bar = (ImageView) findViewById(R.id.app_bar_title);
        title_bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prod_list.updateCartItem(item_name,  item_quantity, item_total);
                Toast.makeText(CartItemActivity.this, "Item updated.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CartItemActivity.this, ProductCatalog.class);
                startActivity(intent);
            }
        });

        cartIcon = (ImageButton) findViewById(R.id.catalog_cart_icon);
        cartIcon.setVisibility(View.INVISIBLE);

        buttonRemove = (Button) findViewById(R.id.button_remove);
        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prod_list.removeCartItem(item_name);
                Toast.makeText(CartItemActivity.this, "Item removed.", Toast.LENGTH_SHORT).show();
                Intent intent = intent = new Intent(CartItemActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
    }

    public void cart_decrementValue(View v){
        if(item_quantity <= 1){
            item_quantity = 1;
        }else{
            item_quantity--;
        }
        item_total = (double) item_quantity * price;
        product_quantity.setText(item_quantity+"");
        product_total.setText("₱"+df.format(item_total));
    }

    public void cart_incrementValue(View v){
        item_quantity++;
        item_total = (double) item_quantity * price;
        product_quantity.setText(item_quantity+"");
        product_total.setText("₱"+df.format(item_total));
    }
}