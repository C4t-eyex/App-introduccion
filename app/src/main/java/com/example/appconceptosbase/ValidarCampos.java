package com.example.appconceptosbase;

import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

public class ValidarCampos {

    public static boolean validarCampos(EditText... campo) {
        boolean todosLlenos = true;
        for (EditText editText : campo) {
            if (TextUtils.isEmpty(editText.getText().toString())) {
                todosLlenos = false;
                break;
            }
        }
        return todosLlenos;
    }
}
