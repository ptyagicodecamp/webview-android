## WebViewHelper Library

WebViewHelper library for Android platform and sample app to demonstrate the use of convenience class [WebViewHelper](https://github.com/ptyagicodecamp/webview-android/blob/master/webview-android/src/main/java/org/ptyagicodecamp/webview_lib/WebViewHelper.java)

#### Integrating from Android Studio ####
```
compile 'org.ptyagicodecamp:webview-android:0.0.1'
```

#### Setting up ####

Initialize with other initialization code and pass `WebView` widget reference to it.
```
WebViewHelper webViewHelper = new WebViewHelper(webView);
```

#### Using it ####
```
webViewHelper.loadUrl("https://ptyagicodecamp.github.io/");
```

Please refer to [this article](https://ptyagicodecamp.github.io/webviewhelper-utility-library.html) for more details


