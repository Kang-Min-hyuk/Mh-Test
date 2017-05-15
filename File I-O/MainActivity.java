package com.test.exandroidsocket_0515;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;


public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText, editText2;

    Handler handler =new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);

        Button button = (Button) findViewById(R.id.btnConnect);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addr = editText.getText().toString();

                Thread thread =new Thread(new ConnectRunnable(addr));
                thread.start();

            }
        });

    }

    class ConnectRunnable implements Runnable {
        String hostname;

        public ConnectRunnable(String hostname) {
            this.hostname = hostname;
        }

        @Override
        public void run() {
            try {
                Socket socket = new Socket(hostname,5001);

                // 출력스트림 준비
                OutputStream os = socket.getOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(os);

                String strInput = editText2.getText().toString();
                oos.writeObject(strInput);
                oos.flush();

                // 입력스트림 준비
                InputStream is = socket.getInputStream();
                ObjectInputStream ois = new ObjectInputStream(is);
                final String str =  (String) ois.readObject();

               handler.post(new Runnable() {
                   @Override
                   public void run() {
                       textView.setText(str); // 작업스레드에서 UI객체 접근 불가.(핸들러객체이용)
                   }
               });

                ois.close();
                oos.close();
                socket.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
