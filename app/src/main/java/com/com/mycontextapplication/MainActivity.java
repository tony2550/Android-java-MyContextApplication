package com.com.mycontextapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private Button btnToast, btnAlert, btnSnackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initLr();
    }

    private void initLr() { // 리스너는 만들때마다 검색
        btnToast.setOnClickListener(v -> {
            Log.d(TAG, "initLr: 실행");
            Context context = getApplicationContext();
            CharSequence text = "Hello toast!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration); // context가 필요한 이유 : 메인엑티비티 위에 그리기 위해
            toast.show();
        });
        btnSnackbar.setOnClickListener(v -> {
            Snackbar mySnackbar = Snackbar.make(findViewById(R.id.lr),
                    "스낵바", Snackbar.LENGTH_SHORT);
            mySnackbar.show();
        });

        btnAlert.setOnClickListener(v -> {
            showNoticeDialog();
        });
    }
    // 빌더 패턴 : 객체를 만들어내는 방식
    private void init() {
        btnToast = findViewById(R.id.btnToast);
        btnAlert = findViewById(R.id.btnAlert);
        btnSnackbar = findViewById(R.id.btnSnackbar);
    }

    public void showNoticeDialog() {
        // Create an instance of the dialog fragment and show it
        DialogFragment dialog = new FireMissilesDialogFragment();
        dialog.show(getSupportFragmentManager(), "NoticeDialogFragment"); // 프레그먼트메니저가 쇼 해줌
    }
}