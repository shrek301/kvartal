package app;


import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.androidbegin.yqltutorial.R;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ur extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.ur_layout, container, false);
        WebView mWebView = (WebView) myView.findViewById(R.id.web);

        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDefaultTextEncodingName("utf-8");
        settings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);

        mWebView.loadUrl("file:///android_asset/www/index.html");
        return myView;
    }
}
