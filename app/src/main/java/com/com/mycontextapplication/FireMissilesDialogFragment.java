package com.com.mycontextapplication;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;

public class FireMissilesDialogFragment extends DialogFragment {

    private static final String TAG = "FireMissilesDialog";
    
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("파일을 삭제하시겠습니까?")
                .setPositiveButton("넹",
                    (DialogInterface dialog, int id) -> {
                        Log.d(TAG, "onCreateDialog: 클릭쓰");
                        // FIRE ZE MISSILES!
                        Context context = getActivity(); // 구체적인 클래스를 쥐고 있으면 결합도가 높아짐
                        CharSequence text = "Hello toast!";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration); // context가 필요한 이유 : 메인엑티비티 위에 그리기 위해
                        toast.show();
                    } // 에로우 펑션으로 new 로 만들어지는 함수에서 교체하기
                )
                .setNegativeButton("아뇹",
                    (DialogInterface dialog, int id) -> {
                        Log.d(TAG, "onCreateDialog: 아뇹");
                        // User cancelled the dialog
                    }
                );
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
