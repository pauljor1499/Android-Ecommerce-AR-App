package com.dev.Lipstick_AR.product_view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.Lipstick_AR.product_catalog.ProductCatalog;
import com.dev.Lipstick_AR.product_details.ProductDetails;
import com.dev.Lipstick_AR.R;
import com.dev.Lipstick_AR.cart.CartActivity;
import com.dev.Lipstick_AR.augmented_reality.MakeupActivity;
import com.dev.Lipstick_AR.product.service.ProductList;
import com.nex3z.notificationbadge.NotificationBadge;


public class ProductView extends AppCompatActivity {

    public static NotificationBadge prod_view_badge;
    private ProductList prod_list = new ProductList();
    private ImageButton buttonBack, cartIcon;
    private ImageView title_bar;
    //Bundle
    private String product_label, product_price, product_weight, product_details;
    private int product_image;
    //
    private Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_view);

        //hide on-screen bottom navigation
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        ImageView imageView = (ImageView) findViewById(R.id.viewProductImage);
        TextView item_name = (TextView) findViewById(R.id.viewProductName);
        TextView item_price = (TextView) findViewById(R.id.viewProductPrice);
        TextView item_weight = (TextView) findViewById(R.id.viewProductWeight);
        TextView item_details = (TextView) findViewById(R.id.viewProductDetails);

        //Get Value From Catalog
        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            product_label = bundle.getString("LABEL");
            product_price = bundle.getString("PRICE");
            product_image = bundle.getInt("IMAGE");
            product_weight = bundle.getString("WEIGHT");
            product_details = bundle.getString("DETAILS");

            item_name.setText(product_label);
            item_price.setText(product_price);
            imageView.setImageResource(product_image);
            item_weight.setText(product_weight);
            item_details.setText(product_details);
        }

        title_bar = (ImageView) findViewById(R.id.app_bar_title);
        title_bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(ProductView.this, ProductCatalog.class);
                startActivity(intent);
            }
        });

        cartIcon = (ImageButton) findViewById(R.id.catalog_cart_icon);
        cartIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(ProductView.this, CartActivity.class);
                startActivity(intent);
            }
        });

        prod_view_badge = (NotificationBadge) findViewById(R.id.catalog_cart_badge);
        prod_view_badge.setNumber(prod_list.counter);

        buttonBack = (ImageButton) findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void Buy(View v) {

        if (product_label.equals("MAGIC PINK LIP GLOSS")){
            intent = new Intent(this, ProductDetails.class);
            intent.putExtra("LABEL", "MAGIC PINK LIP GLOSS");
            intent.putExtra("PRICE", "75.90");
            intent.putExtra("PICTURE", R.drawable.magic_pink_lip_gloss);
            startActivity(intent);

        }else if (product_label.equals("BLENDABLE LIP AND CHEEK COLOR")){
            intent = new Intent(this, ProductDetails.class);
            intent.putExtra("LABEL", "BLENDABLE LIP AND CHEEK COLOR");
            intent.putExtra("PRICE", "81.40");
            intent.putExtra("PICTURE", R.drawable.blendable_lip);
            startActivity(intent);

        }else if (product_label.equals("BLENDABLE LIP AND CHEEK COLOR ANGEL")){
            intent = new Intent(this, ProductDetails.class);
            intent.putExtra("LABEL", "BLENDABLE LIP AND CHEEK COLOR ANGEL");
            intent.putExtra("PRICE", "81.40");
            intent.putExtra("PICTURE", R.drawable.blendable_lip_angel);
            startActivity(intent);

        }else if (product_label.equals("METALLIC PRO LIPSTICK")){
            intent = new Intent(this, ProductDetails.class);
            intent.putExtra("LABEL", "METALLIC PRO LIPSTICK");
            intent.putExtra("PRICE", "86.80");
            intent.putExtra("PICTURE", R.drawable.metallic_pro);
            startActivity(intent);

        }else if (product_label.equals("MATTE PRO LIPSTICK")){
            intent = new Intent(this, ProductDetails.class);
            intent.putExtra("LABEL", "MATTE PRO LIPSTICK");
            intent.putExtra("PRICE", "86.80");
            intent.putExtra("PICTURE", R.drawable.matte_pro);
            startActivity(intent);

        }else if (product_label.equals("MATTE PRO LIPSTICK BLITZ")){
            intent = new Intent(this, ProductDetails.class);
            intent.putExtra("LABEL", "MATTE PRO LIPSTICK BLITZ");
            intent.putExtra("PRICE", "86.80");
            intent.putExtra("PICTURE", R.drawable.matte_pro_blitz);
            startActivity(intent);

        }else if (product_label.equals("LIP GLOSS")){
            intent = new Intent(this, ProductDetails.class);
            intent.putExtra("LABEL", "LIP GLOSS");
            intent.putExtra("PRICE", "97.70");
            intent.putExtra("PICTURE", R.drawable.lip_gloss);
            startActivity(intent);

        }else if (product_label.equals("LIP CHEEK EYE COLOR")){
            intent = new Intent(this, ProductDetails.class);
            intent.putExtra("LABEL", "LIP CHEEK EYE COLOR");
            intent.putExtra("PRICE", "108.70");
            intent.putExtra("PICTURE", R.drawable.lip_cheek_eye_color);
            startActivity(intent);

        }else if (product_label.equals("LONG LASTING METALLIC LIP COLOR")){
            intent = new Intent(this, ProductDetails.class);
            intent.putExtra("LABEL", "LONG LASTING METALLIC LIP COLOR");
            intent.putExtra("PRICE", "119.60");
            intent.putExtra("PICTURE", R.drawable.long_lasting_metallic);
            startActivity(intent);

        }else if (product_label.equals("LONG LASTING LIP COLOR")){
            intent = new Intent(this, ProductDetails.class);
            intent.putExtra("LABEL", "LONG LASTING LIP COLOR");
            intent.putExtra("PRICE", "119.60");
            intent.putExtra("PICTURE", R.drawable.long_lasting_lip);
            startActivity(intent);

        }else if (product_label.equals("CLASSIQUE LIPSTICK")){
            intent = new Intent(this, ProductDetails.class);
            intent.putExtra("LABEL", "CLASSIQUE LIPSTICK");
            intent.putExtra("PRICE", "119.60");
            intent.putExtra("PICTURE", R.drawable.classique_lipstick);
            startActivity(intent);

        }else if (product_label.equals("METALLIC PRO LIPSTICK HOLLYWOOD")){
            intent = new Intent(this, ProductDetails.class);
            intent.putExtra("LABEL", "METALLIC PRO LIPSTICK HOLLYWOOD");
            intent.putExtra("PRICE", "86.80");
            intent.putExtra("PICTURE", R.drawable.metallic_pro_hollywood);
            startActivity(intent);

        }else if (product_label.equals("MAGIC PINK LIP GLOSS - 5 PCS BUNDLE")){
            intent = new Intent(this, ProductDetails.class);
            intent.putExtra("LABEL", "MAGIC PINK LIP GLOSS - 5 PCS BUNDLE");
            intent.putExtra("PRICE", "297.60");
            intent.putExtra("PICTURE", R.drawable.magic_pink_lip_gloss_bundle);
            startActivity(intent);

        }

    }

    public void Try(View v){

        if (product_label.equals("MAGIC PINK LIP GLOSS")){
            intent = new Intent(this, MakeupActivity.class);
            intent.putExtra("LABEL", "MAGIC PINK LIP GLOSS");
            intent.putExtra("MAKEUP", R.drawable.makeup_1);
            startActivity(intent);

        }else if (product_label.equals("BLENDABLE LIP AND CHEEK COLOR")){
            intent = new Intent(this, MakeupActivity.class);
            intent.putExtra("LABEL", "BLENDABLE LIP AND CHEEK COLOR");
            intent.putExtra("MAKEUP", R.drawable.makeup_2);
            startActivity(intent);

        }else if (product_label.equals("BLENDABLE LIP AND CHEEK COLOR ANGEL")){
            intent = new Intent(this, MakeupActivity.class);
            intent.putExtra("LABEL", "BLENDABLE LIP AND CHEEK COLOR ANGEL");
            intent.putExtra("MAKEUP", R.drawable.makeup_3);
            startActivity(intent);

        }else if (product_label.equals("METALLIC PRO LIPSTICK")){
            intent = new Intent(this, MakeupActivity.class);
            intent.putExtra("LABEL", "METALLIC PRO LIPSTICK");
            intent.putExtra("MAKEUP", R.drawable.makeup_4);
            startActivity(intent);

        }else if (product_label.equals("MATTE PRO LIPSTICK")){
            intent = new Intent(this, MakeupActivity.class);
            intent.putExtra("LABEL", "MATTE PRO LIPSTICK");
            intent.putExtra("MAKEUP", R.drawable.makeup_5);
            startActivity(intent);

        }else if (product_label.equals("MATTE PRO LIPSTICK BLITZ")){
            intent = new Intent(this, MakeupActivity.class);
            intent.putExtra("LABEL", "MATTE PRO LIPSTICK BLITZ");
            intent.putExtra("MAKEUP", R.drawable.makeup_6);
            startActivity(intent);

        }else if (product_label.equals("LIP GLOSS")){
            intent = new Intent(this, MakeupActivity.class);
            intent.putExtra("LABEL", "LIP GLOSS");
            intent.putExtra("MAKEUP", R.drawable.makeup_7);
            startActivity(intent);

        }else if (product_label.equals("LIP CHEEK EYE COLOR")){
            intent = new Intent(this, MakeupActivity.class);
            intent.putExtra("LABEL", "LIP CHEEK EYE COLOR");
            intent.putExtra("MAKEUP", R.drawable.makeup_8);
            startActivity(intent);

        }else if (product_label.equals("LONG LASTING METALLIC LIP COLOR")) {
            intent = new Intent(this, MakeupActivity.class);
            intent.putExtra("LABEL", "LONG LASTING METALLIC LIP COLOR");
            intent.putExtra("MAKEUP", R.drawable.makeup_9);
            startActivity(intent);

        }else if (product_label.equals("LONG LASTING LIP COLOR")){
            intent = new Intent(this, MakeupActivity.class);
            intent.putExtra("LABEL", "LONG LASTING LIP COLOR");
            intent.putExtra("MAKEUP", R.drawable.makeup_10);
            startActivity(intent);

        }else if (product_label.equals("CLASSIQUE LIPSTICK")){
            intent = new Intent(this, MakeupActivity.class);
            intent.putExtra("LABEL", "CLASSIQUE LIPSTICK");
            intent.putExtra("MAKEUP", R.drawable.makeup_11);
            startActivity(intent);

        }else if (product_label.equals("METALLIC PRO LIPSTICK HOLLYWOOD")){
            intent = new Intent(this, MakeupActivity.class);
            intent.putExtra("LABEL", "METALLIC PRO LIPSTICK HOLLYWOOD");
            intent.putExtra("MAKEUP", R.drawable.makeup_12);
            startActivity(intent);

        }else if (product_label.equals("MAGIC PINK LIP GLOSS - 5 PCS BUNDLE")){
            intent = new Intent(this, MakeupActivity.class);
            intent.putExtra("LABEL", "MAGIC PINK LIP GLOSS - 5 PCS BUNDLE");
            intent.putExtra("MAKEUP", R.drawable.makeup_1);
            startActivity(intent);

        }
    }


}