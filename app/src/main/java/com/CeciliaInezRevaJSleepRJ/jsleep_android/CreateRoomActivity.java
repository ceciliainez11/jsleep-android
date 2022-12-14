package com.CeciliaInezRevaJSleepRJ.jsleep_android;

import androidx.appcompat.app.AppCompatActivity;
<<<<<<< HEAD

=======
import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.BedType;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.City;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.Facility;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.Room;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.request.BaseApiService;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.request.UtilsApi;
>>>>>>> 360a270 (Update Proyek Reva - UI)
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
<<<<<<< HEAD

import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.BedType;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.City;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.Facility;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.Room;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.request.BaseApiService;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.request.UtilsApi;

import java.util.ArrayList;
import java.util.List;

=======
import java.util.ArrayList;
>>>>>>> 360a270 (Update Proyek Reva - UI)
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateRoomActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    BaseApiService mApiService;
    Context mContext;
<<<<<<< HEAD
    ArrayAdapter adapterCity, adapterBedType;
    Spinner city, bedType;
    EditText roomName, roomAddress, roomPrice, roomSize;
    Button create, cancel;
    CheckBox ac, refrigerator, wifi, bathtub, balcony, restaurant, swimmingPool, fitnessCenter;
=======


    ArrayAdapter adapterCity, adapterBedType;
    EditText roomName, roomAddress, roomPrice, roomSize;
    CheckBox ac, refrigerator, wifi, bathtub, balcony, restaurant, swimmingPool, fitnessCenter;
    Button create, cancel;
    Spinner city, bedType;

>>>>>>> 360a270 (Update Proyek Reva - UI)
    ArrayList<Facility> facilityList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_room);

<<<<<<< HEAD
=======
        facilityList = new ArrayList<>();

>>>>>>> 360a270 (Update Proyek Reva - UI)
        try {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        mApiService = UtilsApi.getApiService();
        mContext = this;

<<<<<<< HEAD
        facilityList = new ArrayList<>();

        city = findViewById(R.id.CreateFacilityCitySpinner);
        bedType = findViewById(R.id.CreateFacilityBedTypeSpinner);

        roomName = findViewById(R.id.createRoom_name);
        roomAddress = findViewById(R.id.createRoom_address);
        roomPrice = findViewById(R.id.createRoom_price);
        roomSize = findViewById(R.id.createRoom_size);

        create = findViewById(R.id.CreateButton);
        cancel = findViewById(R.id.CancelButton);
=======
        create = findViewById(R.id.buttonCreate);
        cancel = findViewById(R.id.buttonCancel);
>>>>>>> 360a270 (Update Proyek Reva - UI)

        ac = findViewById(R.id.checkBoxAC);
        refrigerator = findViewById(R.id.checkBoxRefrigerator);
        wifi = findViewById(R.id.checkBoxWifi);
        bathtub = findViewById(R.id.checkBoxBathub);
        balcony = findViewById(R.id.checkBoxBalcony);
        restaurant = findViewById(R.id.checkBoxRestaurant);
        swimmingPool= findViewById(R.id.checkBoxSwimmingPool);
        fitnessCenter= findViewById(R.id.checkBoxFitnessCenter);
<<<<<<< HEAD

=======
        city = findViewById(R.id.CreateFacilityCitySpinner);
        bedType = findViewById(R.id.CreateFacilityBedTypeSpinner);
        roomName = findViewById(R.id.createroomName);
        roomAddress = findViewById(R.id.createroomAddress);
        roomPrice = findViewById(R.id.createroomPrice);
        roomSize = findViewById(R.id.createroomSize);
>>>>>>> 360a270 (Update Proyek Reva - UI)


        adapterCity = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item , City.values());
//        adapterCity.setDropDownViewResource(R.layout.dropdown_item);
        city.setAdapter(adapterCity);

<<<<<<< HEAD
=======

>>>>>>> 360a270 (Update Proyek Reva - UI)
        adapterBedType = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, BedType.values());
//        adapterBedType.setDropDownViewResource(R.layout.dropdown_item);
        bedType.setAdapter(adapterBedType);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFacility();
                BedType bedTypeTemp = (BedType) bedType.getSelectedItem();
                System.out.println(facilityList);
                Room createRoom = createRoom();
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
    }
<<<<<<< HEAD
=======


>>>>>>> 360a270 (Update Proyek Reva - UI)
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

<<<<<<< HEAD
    public void addFacility(){
        if (ac.isChecked())
            facilityList.add(Facility.AC);
        if (refrigerator.isChecked())
            facilityList.add(Facility.Refrigerator);
        if (wifi.isChecked())
            facilityList.add(Facility.WiFi);
        if (bathtub.isChecked())
            facilityList.add(Facility.Bathtub);
        if (balcony.isChecked())
            facilityList.add(Facility.Balcony);
        if (restaurant.isChecked())
            facilityList.add(Facility.Restaurant);
        if (swimmingPool.isChecked())
            facilityList.add(Facility.SwimmingPool);
        if (fitnessCenter.isChecked())
            facilityList.add(Facility.FitnessCenter);
    }
=======
>>>>>>> 360a270 (Update Proyek Reva - UI)

    protected Room createRoom() {
        mApiService.createRoom(
                MainActivity.loginacc.id,
                roomName.getText().toString(),
                Integer.parseInt(roomSize.getText().toString()),
                Integer.parseInt(roomPrice.getText().toString()), facilityList,
                (City)(city.getSelectedItem()),
                roomAddress.getText().toString(),
                (BedType)(bedType.getSelectedItem())
        ).enqueue(new Callback<Room>() {
            @Override
            public void onResponse(Call<Room> call, Response<Room> response) {
                if(response.isSuccessful()){
                    System.out.println("Respon");
                    MainActivity.roomCookies = response.body();
                    Intent move = new Intent(CreateRoomActivity.this, MainActivity.class);
                    startActivity(move);
                    Toast.makeText(mContext, "Successfully Creating Room!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Room> call, Throwable t) {
                System.out.println("Fail");
                System.out.println(t.toString());
                Toast.makeText(mContext, "Creating Room Failed", Toast.LENGTH_SHORT).show();
            }
        });
        return null;
    }
<<<<<<< HEAD
=======

    public void addFacility(){
        if (ac.isChecked())
            facilityList.add(Facility.AC);
        if (refrigerator.isChecked())
            facilityList.add(Facility.Refrigerator);
        if (wifi.isChecked())
            facilityList.add(Facility.WiFi);
        if (bathtub.isChecked())
            facilityList.add(Facility.Bathtub);
        if (balcony.isChecked())
            facilityList.add(Facility.Balcony);
        if (restaurant.isChecked())
            facilityList.add(Facility.Restaurant);
        if (swimmingPool.isChecked())
            facilityList.add(Facility.SwimmingPool);
        if (fitnessCenter.isChecked())
            facilityList.add(Facility.FitnessCenter);
    }
>>>>>>> 360a270 (Update Proyek Reva - UI)
}