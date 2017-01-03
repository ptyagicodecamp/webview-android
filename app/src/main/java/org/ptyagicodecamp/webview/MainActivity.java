package org.ptyagicodecamp.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.ptyagicodecamp.webview_lib.WebViewHelper;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    WebViewHelper webViewHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void initStaticWebview() {
        webView = (WebView) findViewById(R.id.webView);
        //initialize WebViewHelper
        webViewHelper = new WebViewHelper(webView);
    }

    private void initDynamicWebview() {
        webViewHelper = new WebViewHelper(this);
    }

    public void loadUrl(View view) {
        webViewHelper = new WebViewHelper(getApplicationContext());
        webViewHelper.openWebviewActivity("https://ptyagicodecamp.github.io/");
        //webViewHelper.loadUrl("https://ptyagicodecamp.github.io/");
//        initDynamicWebview();
    }

    public void loadData(View view) {
        webViewHelper.loadData("<html><a href=\"https://ptyagicodecamp.github.io/\">Click Here to visit my Blog</html>");
    }

    public void toggleJavaScript(View view) {

        if (((ToggleButton)view).isChecked()) {
            webViewHelper.enableJS();
            Toast.makeText(this, "Javascript is enabled", Toast.LENGTH_LONG).show();
        } else {
            webViewHelper.disableJS();
            Toast.makeText(this, "Javascript is disabled", Toast.LENGTH_LONG).show();
        }
    }

    public void enableJavaScript(View view) {
        webViewHelper.enableJS();
    }

    public void disableJavaScript(View view) {
        webViewHelper.disableJS();
    }
}
