package com.CeciliaInezRevaJSleepRJ.jsleep_android;

import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.Account;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.Room;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.request.BaseApiService;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.request.UtilsApi;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    public static Account loginacc;
    public static Room roomCookies;
    public static int roomIndex;

    BaseApiService mApiService;
    Context mContext;
//    static List<Room> allRooms = new ArrayList<Room>();
    public static List<Room> rooms;
    List<Room> roomActivity;
    public static int selectedPos;

    EditText inputList;
    Button buttonNext, buttonPrev, buttonGo;
    ListView list;
    int page = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mApiService = UtilsApi.getApiService();
        mContext = this;
        list = (ListView) findViewById(R.id.ListViewMain);

        getAllRooms(0,5);

        buttonNext = findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(i-> {
            page++;
            getAllRooms(0,5);
        });

        buttonPrev = findViewById(R.id.buttonPrev);
        buttonPrev.setOnClickListener(i -> {
            page = page == 0? 0 : page - 1;
            getAllRooms(0,5);
        });

        buttonGo = findViewById(R.id.buttonGo);
        buttonGo.setOnClickListener(i -> {
            getAllRooms(0,5);
        });


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                roomIndex = position;
                Intent move = new Intent(MainActivity.this, DetailRoomActivity.class);
                startActivity(move);
//                Intent move = new Intent(MainActivity.this, DetailRoomActivity.class);
//                startActivity(move);
            }
        });

    }

//    protected ArrayList<Room> getAllRooms() {
//
//        inputList = findViewById(R.id.inputList);
//        ListViewMain = findViewById(R.id.ListViewMain);
//
//        String pageSizeStr = inputList.getText().toString();
//        int pageSize = pageSizeStr.equals("") ? 12 : Integer.parseInt(pageSizeStr);
//        System.out.println("Page : " + pageSize + " " + page);
//
//        mApiService.getAllRoom(page, pageSize).enqueue(new Callback<List<Room>>() {
//            @Override
//            public void onResponse(Call<List<Room>> call, Response<List<Room>> response){
//                allRooms = response.body();
//
//                if(allRooms == null){
//                    Toast.makeText(mContext, "No Room Found", Toast.LENGTH_SHORT).show();
//                }else{
//                    ArrayAdapter<Room> adapter = new ArrayAdapter<Room>(mContext, R.layout.roomlistview, allRooms);
//                    ListViewMain.invalidateViews();
//                    ListViewMain.setAdapter(adapter);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Room>> call, Throwable t){
//                System.out.println(t.toString());
//                Toast.makeText(mContext, "Failed Room", Toast.LENGTH_SHORT).show();
//            }
//        });
//        return null;
//    }

    protected List<Room> getAllRooms(int page, int pageSize){
        mApiService.getAllRoom(page, pageSize).enqueue(new Callback<List<Room>>() {
            @Override
            public void onResponse(Call<List<Room>> call, Response<List<Room>> response) {
                if(response.isSuccessful()){
                    System.out.println("Success");
                    ArrayList<String> temporary = new ArrayList<>();
                    rooms = response.body();
                    for(Room i : rooms){
                        temporary.add(i.name);
                    }
                    ArrayAdapter<String> itemAdapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1,temporary);
                    list.setAdapter(itemAdapter);
                    Toast.makeText(mContext, "getRoomList successfull", Toast.LENGTH_SHORT).show();
                    System.out.println(rooms);
                }
            }

            @Override
            public void onFailure(Call<List<Room>> call, Throwable t) {
                System.out.println("Failed");
                System.out.println(t.toString());
                Toast.makeText(mContext, "Failed to getRoomList", Toast.LENGTH_SHORT).show();
            }
        });
        return null;
    }

//    public static Room getSelectedRoom () {
//        return allRooms.get(selectedPos);
//    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.people_button) {
            Toast.makeText(this, "Opening Profile", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, AboutMeActivity.class));
            return true;
        }
        else if(item.getItemId() == R.id.create_room) {
            Toast.makeText(this, "Opening Create Room", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, CreateRoomActivity.class));
            return true;
        }
        else if(item.getItemId() == R.id.search_button) {
            Toast.makeText(this, "Searching", Toast.LENGTH_SHORT).show();
            return true;
        }else{
            throw new IllegalStateException("Invalid button : " + item.getItemId());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        if (MainActivity.loginacc.renter == null) {
            menu.findItem(R.id.create_room).setVisible(false);
        }else{
            menu.findItem(R.id.create_room).setVisible(true);
        }
        return true;
    }
}