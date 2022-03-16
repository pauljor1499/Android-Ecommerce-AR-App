package com.dev.Lipstick_AR.product_catalog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import com.dev.Lipstick_AR.R;
import com.dev.Lipstick_AR.about_us.AboutUsActivity;
import com.dev.Lipstick_AR.cart.CartActivity;
import com.dev.Lipstick_AR.contact_us.ContactUsActivity;
import com.dev.Lipstick_AR.product.service.ProductList;
import com.dev.Lipstick_AR.product_view.ProductView;
import com.nex3z.notificationbadge.NotificationBadge;

public class ProductCatalog extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener, View.OnClickListener {

    public static NotificationBadge catalog_badge;

    private ProductList prod_list = new ProductList();
    private CardView item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12, item13;
    private ImageButton cartIcon, menuOption;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_catalog);

        //hide on-screen bottom navigation
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        cartIcon = (ImageButton) findViewById(R.id.catalog_cart_icon);
        menuOption = (ImageButton) findViewById(R.id.catalog_option);

        catalog_badge = (NotificationBadge) findViewById(R.id.catalog_cart_badge);
        catalog_badge.setNumber(prod_list.counter);

        item1 = (CardView) findViewById(R.id.card_1);
        item2 = (CardView) findViewById(R.id.card_2);
        item3 = (CardView) findViewById(R.id.card_3);
        item4 = (CardView) findViewById(R.id.card_4);
        item5 = (CardView) findViewById(R.id.card_5);
        item6 = (CardView) findViewById(R.id.card_6);
        item7 = (CardView) findViewById(R.id.card_7);
        item8 = (CardView) findViewById(R.id.card_8);
        item9 = (CardView) findViewById(R.id.card_9);
        item10 = (CardView) findViewById(R.id.card_10);
        item11 = (CardView) findViewById(R.id.card_11);
        item12 = (CardView) findViewById(R.id.card_12);
        item13 = (CardView) findViewById(R.id.card_13);

        item1.setOnClickListener(this);
        item2.setOnClickListener(this);
        item3.setOnClickListener(this);
        item4.setOnClickListener(this);
        item5.setOnClickListener(this);
        item6.setOnClickListener(this);
        item7.setOnClickListener(this);
        item8.setOnClickListener(this);
        item9.setOnClickListener(this);
        item10.setOnClickListener(this);
        item11.setOnClickListener(this);
        item12.setOnClickListener(this);
        item13.setOnClickListener(this);

        cartIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(ProductCatalog.this, CartActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.card_1) {
            intent = new Intent(this, ProductView.class);
            intent.putExtra("LABEL", "MAGIC PINK LIP GLOSS");
            intent.putExtra("PRICE", "₱75.90");
            intent.putExtra("WEIGHT", "• 3g");
            intent.putExtra("DETAILS", "Magic Pink Lip Gloss has the magic touch that turns your lips naturally pink. Perfect to keep your lips looking fresh and healthy throughout the day.");
            intent.putExtra("IMAGE", R.drawable.magic_pink_lip_gloss);
            startActivity(intent);

        } else if (v.getId() == R.id.card_2) {
            intent = new Intent(this, ProductView.class);
            intent.putExtra("LABEL", "BLENDABLE LIP AND CHEEK COLOR");
            intent.putExtra("PRICE", "₱81.10");
            intent.putExtra("WEIGHT", "• 3g");
            intent.putExtra("DETAILS", "Match your lipstick shade with your blush with this 2-in-1 wonder! The formula is creamy and smooth that it can create an intense color on your lips yet it is so easy to blend on your cheek for a beautiful blush. It is also enriched with Olive oil which is a known natural moisturizer.");
            intent.putExtra("IMAGE", R.drawable.blendable_lip);
            startActivity(intent);

        } else if (v.getId() == R.id.card_3) {
            intent = new Intent(this, ProductView.class);
            intent.putExtra("LABEL", "BLENDABLE LIP AND CHEEK COLOR ANGEL");
            intent.putExtra("PRICE", "₱81.40");
            intent.putExtra("WEIGHT", "• 3g");
            intent.putExtra("DETAILS", "Now you can have matching shade for your lips and cheeks. This multipurpose product can be used as lipstick as well as blusher. The formula is creamy and smooth that it can create an intense color on your lips yet it is so easy to blend on your cheek for a beautiful blush. It is enriched with Olive oil which is known as natural moisturizer.");
            intent.putExtra("IMAGE", R.drawable.blendable_lip_angel);
            startActivity(intent);


        } else if (v.getId() == R.id.card_4) {
            intent = new Intent(this, ProductView.class);
            intent.putExtra("LABEL", "METALLIC PRO LIPSTICK");
            intent.putExtra("PRICE", "₱86.80");
            intent.putExtra("WEIGHT", "• 2.3g");
            intent.putExtra("DETAILS", "Sophie Martin Metallic Pro Lipstick has a smooth metallic finish that will keep your lips moisturized all day long. Perfect to complete your glam look!");
            intent.putExtra("IMAGE", R.drawable.metallic_pro);
            startActivity(intent);


        } else if (v.getId() == R.id.card_5) {
            intent = new Intent(this, ProductView.class);
            intent.putExtra("LABEL", "MATTE PRO LIPSTICK");
            intent.putExtra("PRICE", "₱86.80");
            intent.putExtra("WEIGHT", "• 2.3g");
            intent.putExtra("DETAILS", "Sophie Martin Matte Pro Lipstick gives you an attractive matte finish without leaving your lips dry.");
            intent.putExtra("IMAGE", R.drawable.matte_pro);
            startActivity(intent);


        } else if (v.getId() == R.id.card_6) {
            intent = new Intent(this, ProductView.class);
            intent.putExtra("LABEL", "MATTE PRO LIPSTICK BLITZ");
            intent.putExtra("PRICE", "₱86.80");
            intent.putExtra("WEIGHT", "• 2.3g");
            intent.putExtra("DETAILS", "Sophie Martin Matte Pro Lipstick gives you an attractive matte finish without leaving your lips dry.");
            intent.putExtra("IMAGE", R.drawable.matte_pro_blitz);
            startActivity(intent);

        }else if (v.getId() == R.id.card_7) {
            intent = new Intent(this, ProductView.class);
            intent.putExtra("LABEL", "LIP GLOSS");
            intent.putExtra("PRICE", "₱97.70");
            intent.putExtra("WEIGHT", "• 5.5ml");
            intent.putExtra("DETAILS", "With intense color and luster, this lip gloss is specially formulated to enhance the appearance of your lips. It's easy to use and leaves your lips soft and smooth. Apply it directly on the lips or use it on top of your favorite lipstick!");
            intent.putExtra("IMAGE", R.drawable.lip_gloss);
            startActivity(intent);

        }else if (v.getId() == R.id.card_8) {
            intent = new Intent(this, ProductView.class);
            intent.putExtra("LABEL", "LIP CHEEK EYE COLOR");
            intent.putExtra("PRICE", "₱108.70");
            intent.putExtra("WEIGHT", "• 5.5ml");
            intent.putExtra("DETAILS", "Three-in-one must have! It acts as lip color, cream blush and eye shadow. The formula is infused with nourishing ingredients for a smooth application and intense matte finish.");
            intent.putExtra("IMAGE", R.drawable.lip_cheek_eye_color);
            startActivity(intent);

        }else if (v.getId() == R.id.card_9) {
            intent = new Intent(this, ProductView.class);
            intent.putExtra("LABEL", "LONG LASTING METALLIC LIP COLOR");
            intent.putExtra("PRICE", "₱119.60");
            intent.putExtra("WEIGHT", "• 5.5ml");
            intent.putExtra("DETAILS", "Long Lasting Metallic Lip Color is specially formulated to give an intense and long lasting metallic finish without leaving your lips dry.");
            intent.putExtra("IMAGE", R.drawable.long_lasting_metallic);
            startActivity(intent);

        }else if (v.getId() == R.id.card_10) {
            intent = new Intent(this, ProductView.class);
            intent.putExtra("LABEL", "LONG LASTING LIP COLOR");
            intent.putExtra("PRICE", "₱119.60");
            intent.putExtra("WEIGHT", "• 5.5ml");
            intent.putExtra("DETAILS", "Experience a new liquid lip color that is long-wearing, non-transfer, and highly pigmented! It contains a smooth and color rich formula that comfortably glides on your lips and rapidly dries up to a matte finish and a lightweight feel that stays on all day. Plus, it has enriched with Vitamin E to keep your lips moisturized. Be bold, be beautiful!");
            intent.putExtra("IMAGE", R.drawable.long_lasting_lip);
            startActivity(intent);

        }else if (v.getId() == R.id.card_11) {
            intent = new Intent(this, ProductView.class);
            intent.putExtra("LABEL", "CLASSIQUE LIPSTICK");
            intent.putExtra("PRICE", "₱119.60");
            intent.putExtra("WEIGHT", "• 4g");
            intent.putExtra("DETAILS", "Sophie Martin Classique Lipstick is enriched with moisturizer to keep your lips smooth and healthy. Its creamy and glossy finish is suitable for dry lips.");
            intent.putExtra("IMAGE", R.drawable.classique_lipstick);
            startActivity(intent);

        }else if (v.getId() == R.id.card_12) {
            intent = new Intent(this, ProductView.class);
            intent.putExtra("LABEL", "METALLIC PRO LIPSTICK HOLLYWOOD");
            intent.putExtra("PRICE", "₱86.80");
            intent.putExtra("WEIGHT", "• 2.3g");
            intent.putExtra("DETAILS", "Sophie Martin Metallic Pro Lipstick has a smooth metallic finish that will keep your lips moisturized all day long. Perfect to complete your glam look!");
            intent.putExtra("IMAGE", R.drawable.metallic_pro_hollywood);
            startActivity(intent);

        }else if (v.getId() == R.id.card_13) {
            intent = new Intent(this, ProductView.class);
            intent.putExtra("LABEL", "MAGIC PINK LIP GLOSS - 5 PCS BUNDLE");
            intent.putExtra("PRICE", "₱297.60");
            intent.putExtra("WEIGHT", "• 3g x 5");
            intent.putExtra("DETAILS", "Enjoy 20% discount with this awesome bundle! Valued at P695, Magic Pink Lip Gloss 5-piece Bundle can now be yours for only P545. Buy now and save P150!");
            intent.putExtra("IMAGE", R.drawable.magic_pink_lip_gloss_bundle);
            startActivity(intent);

        }
    }

    public void showMenu(View view){
        PopupMenu popup = new PopupMenu(this, view);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.option_menu);
        popup.show();
    }



    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.item_1:
                intent = new Intent(this, AboutUsActivity.class);
                startActivity(intent);
                return true;

            case R.id.item_2:
                intent = new Intent(this, ContactUsActivity.class);
                startActivity(intent);
                return true;

            case R.id.item_3:
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setTitle("Confirmation");
                alertDialogBuilder
                        .setMessage("Do you want to close the app?")
                        .setCancelable(false)
                        .setPositiveButton("No",
                                new DialogInterface.OnClickListener(){
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                })

                        .setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                moveTaskToBack(true);
                                android.os.Process.killProcess(android.os.Process.myPid());
                                System.exit(1);
                            }
                        });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                return true;

            default:
                return false;
        }
    }

}