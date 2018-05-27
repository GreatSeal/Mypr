package com.example.waifuproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Word2_Activity extends AppCompatActivity {

        MyDatabase myDatabase;
        private ArrayList<Poses> posesArrayList;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

           /* ListView listView = (ListView)findViewById(R.id.listView);
            final String[] Japan = new String[];

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, Japan);
            listView.setAdapter(adapter);
*/

            myDatabase=new MyDatabase(Word2_Activity.this);

            posesArrayList=myDatabase.getPoses();

            Log.e("poses list",posesArrayList.size()+"");

            for(int i=0;i<posesArrayList.size();i++){
                Log.e(" category filter",posesArrayList.get(i).name+"");
            }

            ArrayAdapter<String> wordAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1,(ArrayList)posesArrayList);
            ListView lv = (ListView) findViewById(R.id.listView);
            lv.setAdapter(wordAdapter);

        }
    }


  /*  Word2_Activity word2_activity = new Word2_Activity();

    public enum Fields {
        Japan(0),
        Russian(1);
        Fields(int i) {
            this.fieldCode = i ;
        }
        public int getFieldCode()
        {
            return fieldCode;
        }
        private int fieldCode;
    }

    public class DbRepository {
        private SQLiteDatabase db;
        private Context cont;
        public DbRepository(Context context) {
            db = new DbHelper(context).getWritableDatabase();
            cont=context;
        }
        public ArrayList<String> getData() {
            Fields field = Fields.Japan;
            ArrayList<String> list = new ArrayList<String>();
            Cursor cursor = db.query("Japan"
                    , null, null, null,
                    null, null, null);
            if ((cursor != null) && (cursor.getCount() > 0)) {
                cursor.moveToFirst();
                do {
                    list.add(cursor.getString(field.getFieldCode()));
                } while (cursor.moveToNext());
            }
            return list;

        }
        public ArrayList<String> getAllRussian(){
            Fields fields = Fields.Russian;
            ArrayList<String> list = new ArrayList<String>();
            Cursor cursor = db.query("Russian",
                    null,null,null,
                    null,null,null,null);
            if ((cursor != null) && (cursor.getCount() > 0)){
                cursor.moveToFirst();
                do{
                    list.add((cursor.getString(fields.getFieldCode())));
                }while (cursor.moveToNext());
            }
            return list;
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word2_);
    }
}*/






