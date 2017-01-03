package org.ptyagicodecamp.webview_lib;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.RelativeLayout;

/**
 * Created by ptyagi on 12/29/16.
 */

public class WebviewActivity extends Activity {
    static final String URL = "URL";

    WebView mWebView;
    WebViewHelper webViewHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final RelativeLayout layout = new RelativeLayout(this);

        final RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                getWindowManager().getDefaultDisplay().getWidth(),
                getWindowManager().getDefaultDisplay().getHeight());

        layout.setLayoutParams(params);

        setContentView(layout);

        mWebView = new WebView(this);
        mWebView.getSettings().setJavaScriptEnabled(true);

        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setUseWideViewPort(true);
        mWebView.getSettings().setBuiltInZoomControls(true);

        layout.addView(mWebView, params);

        webViewHelper = new WebViewHelper(mWebView);

        String url = getIntent().getStringExtra("URL");

        webViewHelper.loadUrl(url);
    }
}
