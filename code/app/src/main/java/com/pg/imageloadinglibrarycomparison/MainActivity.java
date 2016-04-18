package com.pg.imageloadinglibrarycomparison;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity
{

    private ImageView ivUIL;

    private ImageView ivPicasso;

    private ImageView ivGlide;

    private ImageView ivFresco;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // need to call this before setContentView()
        Fresco.initialize(this);

        setContentView(R.layout.activity_main);
        ivUIL = (ImageView) findViewById(R.id.ivUIL);
        ivPicasso = (ImageView) findViewById(R.id.ivPicasso);
        ivGlide = (ImageView) findViewById(R.id.ivGlide);
        ivFresco = (ImageView) findViewById(R.id.ivFresco);

        loadImages("https://i.imgur.com/tGbaZCY.jpg");
    }

    private void loadImages(String url)
    {
        // UIL
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(this));
        imageLoader.displayImage(url, ivUIL);

        // Picasso
        Picasso.with(this).load(url).into(ivPicasso);

        // Glide
        Glide.with(this).load(url).into(ivGlide);

        // Fresco
        Uri imageUri = Uri.parse(url);
        ivFresco.setImageURI(imageUri);
        //     Con:   DraweeView doesn't support specifying wrap_content for the layout_width or layout_height attributes.
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.image_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        String url = "https://i.imgur.com/tGbaZCY.jpg";
        String url2 =
                "https://bigideasineducation.files.wordpress.com/2014/08/booklets_of_questions_national_center_test_for_university_admissions.jpg";
        String url3 =
                "https://62e528761d0685343e1c-f3d1b99a743ffa4142d9d7f1978d9686.ssl.cf2.rackcdn.com/files/92512/area14mp/image-20150820-32489-85k25a.jpg";
        String url4 = "http://www.digitalbolex.com/wp-content/uploads/2013/04/20130214-Prototype-Lens-Testing-8601.jpg";
        String url5 = "https://rthirtytwotaka.files.wordpress.com/2013/11/dsc01532.jpg";

        switch(item.getItemId())
        {
            case R.id.url1:
                loadImages(url);
                break;
            case R.id.url2:
                loadImages(url2);
                break;
            case R.id.url3:
                loadImages(url3);
                break;
            case R.id.url4:
                loadImages(url4);
                break;
            case R.id.url5:
                loadImages(url5);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
