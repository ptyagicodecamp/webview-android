package org.ptyagicodecamp.webview_lib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.RelativeLayout;

/**
 * Created by ptyagi on 12/15/16.
 */

public class WebViewHelper {
    private static final String TAG = "webview-helper";

    private WebView mWebView;
    private Context mContext;

    /**
     * Opens Webview in a new Activity
     * @param context
     */
    public WebViewHelper(Context context) {
        mContext = context;
    }

    /**
     * Generates webview dynamically, if no webview is passed.
     * This will replace current content view with a dynamically generated webview within the
     * same Activity. Pressing on "back" menu/button will exit the app, same as would happen on
     * clicking "back" on Activity.
     */
    public WebViewHelper(Activity activity) {
        final RelativeLayout layout = new RelativeLayout(activity);

        final RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                activity.getWindowManager().getDefaultDisplay().getWidth(),
                activity.getWindowManager().getDefaultDisplay().getHeight());

        layout.setLayoutParams(params);

        activity.setContentView(layout);

        mWebView = new WebView(activity);
        mWebView.getSettings().setJavaScriptEnabled(true);

        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setUseWideViewPort(true);
        mWebView.getSettings().setBuiltInZoomControls(true);

        layout.addView(mWebView, params);
    }

    public WebViewHelper(WebView webView) {
        mWebView = webView;
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setUseWideViewPort(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
    }

    /**
     * Opens webview in a new activity
     */
    public void openWebviewActivity(String url) {
        Intent webviewIntent = new Intent(mContext, WebviewActivity.class);
        webviewIntent.putExtra(WebviewActivity.URL, url);
        mContext.startActivity(webviewIntent);
    }

    public void loadUrl(String url) {
        if (URLUtil.isValidUrl(url)) {
            mWebView.loadUrl(url);
        } else {
            Log.e(TAG, "Loaded invalid url in webview");
        }
    }
    public void loadUrl(WebView webView, String url) {
        mWebView = webView;
        if (URLUtil.isValidUrl(url)) {
            webView.loadUrl(url);
        } else {
            Log.e(TAG, "Loaded invalid url in webview");
        }
    }

    /**
     * Utility method to enable Javascript in current WebView
     */
    public void enableJS() {
        mWebView.getSettings().setJavaScriptEnabled(true);
    }

    /**
     * Utility method to disable Javascript in current WebView
     */
    public void disableJS() {
        mWebView.getSettings().setJavaScriptEnabled(false);
    }

    /**
     * Utility method to enable Javascript in a given WebView
     * @param webView
     */
    public void enableJS(WebView webView) {
        mWebView = webView;
        webView.getSettings().setJavaScriptEnabled(true);
    }

    /**
     * Utility method to disable Javascript in a given WebView
     * @param webView
     */
    public void disableJS(WebView webView) {
        mWebView = webView;
        webView.getSettings().setJavaScriptEnabled(false);
    }

    /**
     * Returns current active WebView
     * @return
     */
    public WebView getWebView() {
        return mWebView;
    }

    /**
     * Display data in WebView in "text/html" MIIME-type and
     * UTF-8 encoding
     * @param data
     */
    public void loadData(String data) {
        if (mWebView instanceof WebView) {
            mWebView.loadData(data, "text/html", "UTF-8");
        } else {
            Log.e(TAG, "WebView not found");
        }
    }
}
