package kr.hs.emirim.young111.simplediary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    DatePicker datePick;
    EditText editDiary;
    Button butsave;
    String fileName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datePick = (DatePicker)findViewById(R.id.date_picker);
        editDiary = (EditText)findViewById(R.id.edit_content);
        butsave = (Button)findViewById(R.id.but_save);

        //현재 날짜 구하기
        Calendar calendar = Calendar.getInstance();
        int nowYear = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH)+1;
        final int date = calendar.get(Calendar.DATE);

        //DatePicker에 현재 날짜 설정
        datePick.init(nowYear, month, date, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                fileName = year+"_"+(monthOfYear+1)+"_"+dayOfMonth+".txt";
                String content = readDiary(fileName);
                editDiary.setText(content);
                butsave.setEnabled(true);
            }
        });
    }
    String readDiary(String fileName){
        return null;
    }
}
