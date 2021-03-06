package com.akvone.dlcifmo.MainModule;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import com.akvone.dlcifmo.Constants;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created on 21.08.2016.
 */
public class GetRatingAndMoreTask extends AsyncTask<Void,Void,Void> {

    public static final String TAG = "Get Rating More Task";

    public static ArrayList<OneYearRating> fullRating;

    private MainActivity mainActivity;

    public GetRatingAndMoreTask(MainActivity mainActivity){
        this.mainActivity = mainActivity;
        fullRating = new ArrayList<>();
    }

    @Override
    protected Void doInBackground(Void... params) {

        Log.d(TAG, "doInBackground: begin");
        Document doc = null;//Здесь хранится будет разобранный html документ
        //Запрос делаем для получения названия фаультета, номера курса и места в рейтинге
        String queryString = "https://de.ifmo.ru/servlet/distributedCDE?Rule=REP_SHOWREPPARAMFORMPRINT&REP_ID=1441&IN_ADMIN=0";
        try {
            doc = Jsoup.connect(queryString).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Elements elements = doc.select("tbody div.d_text table.d_table tbody tr td");
            String facultyName = elements.get(elements.size() - 3).text();
            String courseNumber = elements.get(elements.size() - 2).text();
            String positionInRatingInformation = elements.get(elements.size() - 1).text();

            for (int i = 0;i<elements.size(); i+=3 ){
                if (i+3<=elements.size()) {
                    OneYearRating oneYearRating = new OneYearRating();
                    oneYearRating.facultyName = elements.get(i).text();
                    oneYearRating.courseNumber = elements.get(i+1).text();
                    oneYearRating.positionInRating = elements.get(i+2).text();
                    fullRating.add(oneYearRating);
                }
            }

            SharedPreferences sharedPref = mainActivity.
                    getSharedPreferences(Constants.PREF_CURRENT_USER_DATA_FILE, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString(Constants.PREF_FACULTY_NAME, facultyName);
            editor.putString(Constants.PREF_COURSE_NUMBER, courseNumber);
            editor.putString(Constants.PREF_POSITION_RATING_INFORMATION, positionInRatingInformation);
            editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d(TAG, "doInBackground: finish");
        return null;
    }



    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        mainActivity.updateDrawer();
    }

    public class OneYearRating{
        public String facultyName;
        public String courseNumber;
        public String positionInRating;
    }
}
