package com.example.joginderpal.toolbar;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import static com.example.joginderpal.toolbar.R.layout.bottomtoolbar;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private Toolbar bottomtb;
    RelativeLayout rel;
    final static int POSITION_RIGHT_CENTRE=7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rel= (RelativeLayout) findViewById(R.id.rel);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        toolbar.setTitle("My Toolbar");
        toolbar.setSubtitle("My sub Title");
        toolbar.setLogo(R.mipmap.ic_launcher);
        setSupportActionBar(toolbar);
        bottomtb = (Toolbar) findViewById(R.id.inc_tb_bottom);
        bottomtb.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.facebook1:
                        Intent i = new Intent(android.content.Intent.ACTION_VIEW,
                                Uri.parse("http://www.facebook.com"));
                        startActivity(i);
                        break;
                    case R.id.facebook2:
                        Intent i1 = new Intent(android.content.Intent.ACTION_VIEW,
                                Uri.parse("http://www.whatsapp.com"));
                        startActivity(i1);
                        break;
                    case R.id.facebook3:
                        Intent i2 = new Intent(android.content.Intent.ACTION_VIEW,
                                Uri.parse("http://www.youtube.com"));
                        startActivity(i2);
                        break;
                    case R.id.facebook4:
                        Intent i4 = new Intent(android.content.Intent.ACTION_VIEW,
                                Uri.parse("http://www.plus.google.com"));
                        startActivity(i4);
                        break;

                }

                return true;
            }
        });
        bottomtb.inflateMenu(R.menu.menu_bottom);
        bottomtb.findViewById(R.id.iv_settings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "SETTING PRESSED", Toast.LENGTH_LONG).show();
            }
        });
        ImageView icon = new ImageView(this); // Create an icon
        icon.setImageResource(R.mipmap.ic_settings_black_24dp);

        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
               .setPosition(POSITION_RIGHT_CENTRE)
                .setBackgroundDrawable(R.drawable.colorfloating)
                .setContentView(icon)
                .build();

        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);

        ImageView itemIcon = new ImageView(this);
        itemIcon.setImageResource(R.drawable.ic_facebook);
        SubActionButton button1 = itemBuilder.setContentView(itemIcon)

                .build();

        ImageView itemIcon1 = new ImageView(this);
        itemIcon1.setImageResource(R.drawable.ic_whatsapp);
        SubActionButton button2 = itemBuilder.setContentView(itemIcon1).build();

        ImageView itemIcon2 = new ImageView(this);
        itemIcon2.setImageResource(R.drawable.ic_yout);
        SubActionButton button3 = itemBuilder.setContentView(itemIcon2).build();

        ImageView itemIcon3 = new ImageView(this);
        itemIcon3.setImageResource(R.drawable.ic_google);
        SubActionButton button4 = itemBuilder.setContentView(itemIcon3).build();

        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(button1)
                .addSubActionView(button2)
                .addSubActionView(button3)
                .addSubActionView(button4)
                .setStartAngle(-90)
                .setEndAngle(+90)
                .attachTo(actionButton)
                .build();


        Button b= (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context=getApplicationContext();
                LayoutInflater inflater=getLayoutInflater();
                View toastroot=inflater.inflate(R.layout.customtoast,null);
                Toast toast=new Toast(context);
                toast.setView(toastroot);
                toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL,
                        0, 0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        return super.onOptionsItemSelected(item);
    }
}

