package th.ac.tu.siit.its333.lab3exercise1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class CourseActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
    }
    public void addCourseClick(View v){

        Intent code = new Intent();


        EditText etCode = (EditText)findViewById(R.id.etCode);
        code.putExtra("toListcode", etCode.getText().toString());


        EditText etCR = (EditText)findViewById(R.id.etCR);
        code.putExtra("toNumcode", etCR.getText().toString());


        RadioGroup rdC = (RadioGroup)findViewById(R.id.rdG);
        int grade= rdC.getCheckedRadioButtonId();
        RadioButton rb = (RadioButton)findViewById(grade);
        String s = rb.getText().toString();
        code.putExtra("toGrade", s);


        setResult(RESULT_OK, code);
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_course, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
