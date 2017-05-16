package com.test.exhttp_0515;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView txtMsg;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        txtMsg = (TextView) findViewById(R.id.txtMsg);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUrl = editText.getText().toString();

                Thread thread = new Thread(new ConnectRunnable(strUrl));
                thread.start();
            }
        });
    }

    class ConnectRunnable implements Runnable {
        String strUrl;

        StringBuilder sb = new StringBuilder();
        public ConnectRunnable(String strUrl) {
            this.strUrl = strUrl;
        }

        @Override
        public void run() {
            try {
                URL url = new URL(strUrl);
                // URL 객체가 가진 문자열이 http로 시작하면
                // openConnection() 호출로 HttpURLConnection 객체를 얻을 수 있음.
                HttpURLConnection huc = (HttpURLConnection) url.openConnection();
                if (huc != null) {
                    huc.setConnectTimeout(10000); // 10초
                    huc.setRequestMethod("GET"); // "GET" 또는 "POST"
                    huc.setDoInput(true); // 입력이 가능하게 만듦
                    huc.setDoOutput(true); // 출력이 가능하게 만듦

                    // 내부적으로 웹서버에 페이지를 요청하는 과정을 수행함.
                    int resCode = huc.getResponseCode();
                   if(resCode == HttpURLConnection.HTTP_OK){

                       // 입력스트림 준비
                       InputStream is = huc.getInputStream();
                       InputStreamReader isReader = new InputStreamReader(is);
                       BufferedReader bReader = new BufferedReader(isReader);

                       String strLine = null;
                       while(true){
                           strLine = bReader.readLine();
                           if(strLine == null){
                               break;
                           }

                           sb.append(strLine + "\n");
                       }
                        bReader.close();
                        huc.disconnect(); // URLConnection 연결끊기
                   }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            txtMsg.setText(sb.toString());
                        }
                    });
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
