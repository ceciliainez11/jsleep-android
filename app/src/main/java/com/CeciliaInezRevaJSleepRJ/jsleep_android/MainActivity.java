package com.CeciliaInezRevaJSleepRJ.jsleep_android;

import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.Account;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.Room;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class MainActivity extends AppCompatActivity{
    Gson json = new Gson();

    protected static Object accountLogin;
    protected static Account accountRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String jsonString = toStringJSON(getApplicationContext(), "randomRoomList.json");
        Type token = new TypeToken<ArrayList<Room>>() {
        }.getType();
        ArrayList<Room> room = json.fromJson(jsonString, token);

//        ArrayAdapter<Room> adapter = new ArrayAdapter<Room>(this, R.layout.roomlistview, room);
//        ListView listView = findViewById(R.id.room_list_view);
//        listView.setAdapter(adapter);
    }

    private static String toStringJSON(Context context, String nameFile) {
        String Json;
        try {
            InputStream is = context.getAssets().open(nameFile);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            Json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return Json;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch(item.getItemId()){
            case R.id.people_button:
            Toast.makeText(this, "Opening", Toast.LENGTH_SHORT).show();
            Intent aboutMi = new Intent(MainActivity.this, AboutMeActivity.class);
            startActivity(aboutMi);
            break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}