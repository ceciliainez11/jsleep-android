package com.CeciliaInezRevaJSleepRJ.jsleep_android;

import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.Account;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.Room;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import android.content.Intent;
import android.view.Menu;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.google.gson.Gson;
import java.util.List;


public class MainActivity extends AppCompatActivity{

    protected static Account requestLog;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InputStream filepath = null;
        ArrayList<Room> ListRoom = new ArrayList<>();
        ArrayList<String> listId = new ArrayList<>();
        Gson json = new Gson();

        try{
            filepath = getAssets().open("randomRoomList.json");
            BufferedReader readfile = new BufferedReader(new InputStreamReader(filepath));
            Room[] buff = json.fromJson(readfile, Room[].class);
            Collections.addAll(ListRoom, buff);
        }catch (IOException ex){
            ex.printStackTrace();
        }
        for (Room r : ListRoom){
            listId.add(r.name);
        }
        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listId);
        ListView listView = findViewById(R.id.listView_id);
        listView.setAdapter(adapt);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public String loadJSONFromAsset(){
        try {
            InputStream is = MainActivity.this.getAssets().open("randomRoomList.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String gson = new String(buffer, "UTF-8");
            return gson;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch(item.getItemId()){
            case R.id.people_button:
                Intent move = new Intent(MainActivity.this, AboutMe.class);
                startActivity(move);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}