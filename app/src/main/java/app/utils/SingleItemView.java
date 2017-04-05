
package app.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import app.vopros;
import com.androidbegin.yqltutorial.R;

public class SingleItemView extends Activity {
    // Declare Variables
    String rank;
    String country;
    String population;
    String flag;
    String pol;
    ImageLoader imageLoader = new ImageLoader(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from singleitemview.xml
        setContentView(R.layout.singleitemview);

        Intent i = getIntent();
        // Get the result of rank
        rank = i.getStringExtra("rank");
        pol = i.getStringExtra("pol");
        // Get the result of country
        country = i.getStringExtra("country");
        // Get the result of population
        population = i.getStringExtra("population");
        // Get the result of flag
        flag = i.getStringExtra("flag");

        // Locate the TextViews in singleitemview.xml
        TextView txtpol = (TextView) findViewById(R.id.pol);
        TextView txtcountry = (TextView) findViewById(R.id.country);
        TextView txtpopulation = (TextView) findViewById(R.id.population);

        // Locate the ImageView in singleitemview.xml
        ImageView imgflag = (ImageView) findViewById(R.id.flag);

        // Set results to the TextViews
        txtpol.setText(Html.fromHtml(pol));
        txtcountry.setText(country);
        txtpopulation.setText(population);

        // Capture position and set results to the ImageView
        // Passes flag images URL into ImageLoader.class
        imageLoader.DisplayImage(flag, imgflag);
    }
    public void goToNewActivity8(View v) {

        String number = "8(347)2-95-96-95";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        startActivity(intent);
    }
    public void goToNewActivity9(View v) {
        Intent intent = new Intent(this, vopros.class);
        startActivity(intent);
    }

}