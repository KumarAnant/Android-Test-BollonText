package pro.anant.android.balloontext;

import android.content.Context;
import android.widget.TextView;

public class qnText extends TextView {


    public qnText(Context context) {
        super(context);
    }

    public qnText(Context context, String question) {
        super(context);
        this.setText(question);
    }
}

