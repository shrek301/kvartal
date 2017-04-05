package app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.androidbegin.yqltutorial.R;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by LatypovTV on 13.08.2014.
 */
public class MainActivity extends Activity {

    //запускаем поток проверки наличия конекта к сети
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (checkInternet()) {

                } else {
                    setContentView(R.layout.no_connect_for_inet);
                }
            }
        }).start();
    }

    // главный метод для проверки подключения
    public boolean checkInternet() {

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        // проверка подключения
        if (activeNetwork != null && activeNetwork.isConnected()) {
            try {
                // тест доступности внешнего ресурса
                URL url = new URL("http://www.google.com/");
                HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
                urlc.setRequestProperty("User-Agent", "test");
                urlc.setRequestProperty("Connection", "close");
                urlc.setConnectTimeout(1000); // Timeout в секундах
                urlc.connect();
                // статус ресурса OK
                if (urlc.getResponseCode() == 200) {
                    return true;
                }
                // иначе проверка провалилась
                return false;

            } catch (IOException e) {
                return false;
            }
        }

        return false;
    }


    public void goToNewActivity8(View v) {

        String number = "23454568678";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        startActivity(intent);
    }

    public void goToNewActivity(View v) {
        Intent intent = new Intent(this, bisnes.class);
        startActivity(intent);
    }

    public void goToNewActivity1(View v) {
        Intent intent = new Intent(this, gil.class);
        startActivity(intent);
    }

    public void goToNewActivity2(View v) {
        Intent intent = new Intent(this, invest.class);
        startActivity(intent);
    }

    public void goToNewActivity3(View v) {
        Intent intent = new Intent(this, kom.class);
        startActivity(intent);
    }

    public void goToNewActivity4(View v) {
        Intent intent = new Intent(this, ur.class);
        startActivity(intent);
    }

    public void goToNewActivity5(View v) {
        Intent intent = new Intent(this, vopros.class);
        startActivity(intent);
    }

    public void goToNewActivity6(View v) {
        Intent intent = new Intent(this, zag.class);
        startActivity(intent);
    }

    public void goToNewActivity7(View v) {
        Intent intent = new Intent(this, gar.class);
        startActivity(intent);
    }

}
