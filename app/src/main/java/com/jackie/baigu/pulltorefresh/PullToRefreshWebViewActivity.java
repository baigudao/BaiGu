/*******************************************************************************
 * Copyright 2011, 2012 Chris Banes.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.jackie.baigu.pulltorefresh;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshWebView;
import com.jackie.baigu.R;

public final class PullToRefreshWebViewActivity extends Activity {

    PullToRefreshWebView mPullRefreshWebView;
    WebView mWebView;
    private TextView tv_title;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ptr_webview);

        mPullRefreshWebView = (PullToRefreshWebView) findViewById(R.id.pull_refresh_webview);
        mWebView = mPullRefreshWebView.getRefreshableView();

        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("PullToRefreshWebView");

        mWebView.getSettings().setJavaScriptEnabled(true);
        //设置WebViewClient
        mWebView.setWebViewClient(new SampleWebViewClient());
        mWebView.loadUrl("https://www.baidu.com");

    }

    private static class SampleWebViewClient extends WebViewClient {
        //		@Override
//		public boolean shouldOverrideUrlLoading(WebView view, String url) {
//			view.loadUrl(url);
//			return true;
//		}
    }
}
