package com.greencrosssolution.greencrosssolution;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class WebClient extends WebViewClient {
    private Activity activity = null;
    private ProgressBar pb;
    public WebClient(Activity activity,ProgressBar pb) {
        this.activity = activity;
        this.pb = pb;

    }


    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, String url) {
        if(url.indexOf("greencrosssolution.com") > -1 ) return false;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        activity.startActivity(intent);
        return true;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        this.pb.setVisibility(View.GONE);
    }
}
