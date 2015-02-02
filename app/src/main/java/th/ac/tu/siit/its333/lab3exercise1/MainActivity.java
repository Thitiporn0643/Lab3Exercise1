package th.ac.tu.siit.its333.lab3exercise1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    int cr = 0;         // Credits
    double gp = 0.0;    // Grade points
    double gpa = 0.0;   // Grade point average

    List<String> listCodes;
    List<Integer> listCredits;
    List<String> listGrades;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listCodes = new ArrayList<String>();
        listCredits = new ArrayList<Integer>();
        listGrades = new ArrayList<String>();

        resultGrade();

        //Use listCodes.add("ITS333"); to add a new course code
        //Use listCodes.size() to refer to the number of courses in the list
    }


    public void buttonClicked(View v) {
        Intent a = new Intent(this, CourseListActivity.class);


        String data = "";

        for (int i=0; i<listCodes.size(); i++)
        {

            data += String.format("%s (%d credits) = %s \n", listCodes.get(i),listCredits.get(i),listGrades.get(i));


        }
        a.putExtra("value",data);

        startActivity(a);

    }

    public void buttonClickedadd(View v) {


        Intent i = new Intent(this,CourseActivity.class);
        startActivityForResult(i, 88);
    }
    public void resetClicked(View v) {

      resetall();

    }




    public void resetall(){

         cr = 0;         // Credits
         gp = 0.0;    // Grade points
         gpa = 0.0;   // Grade point average

        listCodes = new ArrayList<String>();
        listCredits = new ArrayList<Integer>();
        listGrades = new ArrayList<String>();


        resultGrade();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


            if (requestCode == 88) {
                if (resultCode == RESULT_OK) {

                    String code = data.getStringExtra("toListcode");
                    listCodes.add(code);
                    String credit = data.getStringExtra("toNumcode");
                    listCredits.add(Integer.parseInt(credit));
                    String grade =data.getStringExtra("toGrade");
                    listGrades.add(grade);


                    resultGrade();
                }
                else if (resultCode == RESULT_CANCELED) {
                    return;

                }
            }
       }


    public void resultGrade(){


        cr = 0;         // Credits
        gp = 0.0;    // Grade points
        gpa = 0.0;   // Grade point average

        for(int i=0; i< listGrades.size();i++){


           double credit = listCredits.get(i);
           String grade = listGrades.get(i);
            switch (grade){
                case "A":
                    gp += (4.00*credit);
                    break;
                case "B+":
                    gp += (3.50*credit);
                    break;
                case "B":
                    gp += (3.00*credit);
                    break;
                case "C+":
                    gp += (2.50*credit);
                    break;
                case "C":
                    gp += (2.00*credit);
                    break;
                case "D+":
                    gp += (1.50*credit);
                    break;
                case "D":
                    gp += (1.00*credit);
                    break;
                case "F" :
                    gp += 0.0;

           }

           cr+= credit;
        }

         gpa = gp/cr;

        TextView tvGP = (TextView)findViewById(R.id.tvGP);
        tvGP.setText(Double.toString(gp));

        TextView tvCR = (TextView)findViewById(R.id.tvCR);
        tvCR.setText(Integer.toString(cr));


        TextView tvGPA = (TextView)findViewById(R.id.tvGPA);
        tvGPA.setText(Double.toString(gpa));





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
