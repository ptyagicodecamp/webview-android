## WebViewHelper Library

WebViewHelper library for Android platform and sample app to demonstrate the use of convenience class [WebViewHelper](https://github.com/ptyagicodecamp/webview-android/blob/master/webview-android/src/main/java/org/ptyagicodecamp/webview_lib/WebViewHelper.java)

#### Integrating from Android Studio ####
```
compile 'org.ptyagicodecamp:webview-android:0.0.2'
```

#### Setting up ####

Initialize with other initialization code and pass `WebView` widget reference to it.
```
WebViewHelper webViewHelper = new WebViewHelper(webView);
```

#### Using it ####

Loading URLs. It does URL validation internally.
```
webViewHelper.loadUrl("https://ptyagicodecamp.github.io/");
```

Convenience method for loading Data in "html/text" MIME type and "UTF-8" encoding.
```
webViewHelper.loadData("<html><a href=\"https://ptyagicodecamp.github.io/\">Click Here to visit my Blog</html>");
```
Convenience methods for enabling and disabling Javascript:
```
webViewHelper.enableJS();
webViewHelper.disableJS();
```

Please refer to [this article](https://ptyagicodecamp.github.io/webviewhelper-utility-library.html) for more details


