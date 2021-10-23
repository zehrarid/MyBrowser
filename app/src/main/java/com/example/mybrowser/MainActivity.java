package com.example.mybrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = (WebView) findViewById(R.id.webview);
        Button btnGo = (Button) findViewById(R.id.go);
        EditText txtAddress = (EditText) findViewById(R.id.adress);

        webView.setWebViewClient(new WebViewClient());

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadUrl("http://"+ txtAddress.getText());

            }
        });


        if (getIntent() != null && getIntent().getData() != null){
            txtAddress.setText(getIntent().getData().toString());
            webView.loadUrl(getIntent().getData().toString());
        }

    }
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
                return super.onCreateOptionsMenu(menu);
    }
}