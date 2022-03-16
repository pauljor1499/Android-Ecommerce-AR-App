package com.dev.Lipstick_AR.about_us;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.dev.Lipstick_AR.R;
import com.dev.Lipstick_AR.cart.CartActivity;
import com.dev.Lipstick_AR.product_catalog.ProductCatalog;
import com.nex3z.notificationbadge.NotificationBadge;

public class AboutUsActivity extends AppCompatActivity {

    private ImageButton buttonBack, cartButton;
    private NotificationBadge cartBadge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        buttonBack = (ImageButton) findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = intent = new Intent(AboutUsActivity.this, ProductCatalog.class);
                startActivity(intent);
            }
        });

        cartButton = (ImageButton) findViewById(R.id.catalog_cart_icon);
        cartButton.setVisibility(View.INVISIBLE);

        cartBadge = (NotificationBadge) findViewById(R.id.catalog_cart_badge);
        cartBadge.setVisibility(View.INVISIBLE);
    }
}