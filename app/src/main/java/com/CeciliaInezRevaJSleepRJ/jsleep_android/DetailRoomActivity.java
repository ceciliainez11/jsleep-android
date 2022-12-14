package com.CeciliaInezRevaJSleepRJ.jsleep_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

<<<<<<< HEAD
=======
import android.annotation.SuppressLint;
>>>>>>> 360a270 (Update Proyek Reva - UI)
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
<<<<<<< HEAD
=======
import android.widget.TextClock;
>>>>>>> 360a270 (Update Proyek Reva - UI)
import android.widget.TextView;

import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.Facility;
//import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.Payment;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.Invoice;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.Payment;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.Room;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.request.BaseApiService;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.request.UtilsApi;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailRoomActivity extends AppCompatActivity {
    protected static Room sessionRoom;
    protected static Payment currentPayment;
<<<<<<< HEAD
    List<Facility> facilityList = MainActivity.rooms.get(MainActivity.roomIndex).facility;
    CheckBox checkboxAC, checkboxBalcony, checkboxBathtub, checkboxFitnessCenter, checkboxRefrigerator, checkboxRestaurant, checkboxSwimPool, checkboxWifi;
    Button rentButton, payButton, cancelButton;
    CardView afterRent;
    TextView bookSuccess, bookFailed;
    BaseApiService mApiService;
    Context mContext;

=======
    BaseApiService mApiService;
    Context mContext;
    List<Facility> facilityList = MainActivity.rooms.get(MainActivity.roomIndex).facility;


    CheckBox checkboxAC, checkboxBalcony, checkboxBathtub, checkboxFitnessCenter;
    CheckBox checkboxRefrigerator, checkboxRestaurant, checkboxSwimPool, checkboxWifi;
    TextView detailName, detailBedType, sizeDetail, priceDetail, addressDetail;
    Button rentButton, payButton, cancelButton;
    CardView afterRent;
    TextView bookSuccess, bookFailed;


    @SuppressLint("MissingInflatedId")
>>>>>>> 360a270 (Update Proyek Reva - UI)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_room);
        mApiService = UtilsApi.getApiService();
        mContext = this;
<<<<<<< HEAD
=======


>>>>>>> 360a270 (Update Proyek Reva - UI)
        try {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        sessionRoom = MainActivity.rooms.get(MainActivity.roomIndex);
<<<<<<< HEAD
        //TextView
        TextView nameDetail = findViewById(R.id.detail_name);
        TextView bedDetail = findViewById(R.id.detail_bedType);
        TextView sizeDetail = findViewById(R.id.detail_size);
        TextView priceDetail = findViewById(R.id.detail_price);
        TextView addressDetail = findViewById(R.id.detail_address);
        bookSuccess = findViewById(R.id.detail_successBook);
        bookFailed = findViewById(R.id.detail_failedBook);
=======


        //TextView
        detailName = findViewById(R.id.detailName);
        detailBedType = findViewById(R.id.detailBedType);
        sizeDetail = findViewById(R.id.detailBedSize);
        priceDetail = findViewById(R.id.detailPrice);
        addressDetail = findViewById(R.id.buttonAddress);
        bookSuccess = findViewById(R.id.booksuccess);
        bookFailed = findViewById(R.id.bookfailed);
>>>>>>> 360a270 (Update Proyek Reva - UI)
        bookSuccess.setVisibility(TextView.INVISIBLE);
        bookFailed.setVisibility(TextView.INVISIBLE);

        //Checkbox
<<<<<<< HEAD
        checkboxAC = findViewById(R.id.cb_AC);
        checkboxBalcony = findViewById(R.id.cb_balcony);
        checkboxBathtub = findViewById(R.id.cb_bathtub);
        checkboxFitnessCenter = findViewById(R.id.cb_fitnessCenter);
        checkboxRefrigerator = findViewById(R.id.cb_refrigerator);
        checkboxRestaurant = findViewById(R.id.cb_restaurant);
        checkboxSwimPool = findViewById(R.id.cb_swimmingPool);
        checkboxWifi = findViewById(R.id.cb_wifi);
        fillCheckbox();

        afterRent = findViewById(R.id.detail_paymentCardView);
        afterRent.setVisibility(CardView.INVISIBLE);

        payButton = findViewById(R.id.detail_confirmPay);
        cancelButton = findViewById(R.id.detail_cancelButton);

        rentButton = findViewById(R.id.detail_rentButton);
=======
        checkboxAC = findViewById(R.id.cbAC);
        checkboxBalcony = findViewById(R.id.cbBalcony);
        checkboxBathtub = findViewById(R.id.cbBathtub);
        checkboxFitnessCenter = findViewById(R.id.cb_fitnessCenter);
        checkboxRefrigerator = findViewById(R.id.cbRefrigerator);
        checkboxRestaurant = findViewById(R.id.cbRestaurant);
        checkboxSwimPool = findViewById(R.id.cbSwimmingPool);
        checkboxWifi = findViewById(R.id.cbWifi);

        fillCheckbox();


        afterRent = findViewById(R.id.afterRent);
        afterRent.setVisibility(CardView.INVISIBLE);
        payButton = findViewById(R.id.buttonPay);
        cancelButton = findViewById(R.id.buttonCancelPay);
        rentButton = findViewById(R.id.buttonRentRoom);
>>>>>>> 360a270 (Update Proyek Reva - UI)
        rentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move = new Intent(DetailRoomActivity.this, BookingActivity.class);
                startActivity(move);
            }
        });
        System.out.println(MainActivity.loginacc.id);
        System.out.println(MainActivity.loginacc.renter.id);
        System.out.println(sessionRoom.id);
<<<<<<< HEAD

        currentPayment = requestGetPayment(MainActivity.loginacc.id, MainActivity.loginacc.renter.id, sessionRoom.id);

        String price = NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(sessionRoom.price.price);
        String address = sessionRoom.address + ", " + sessionRoom.city;

        System.out.println(sessionRoom);

        nameDetail.setText(sessionRoom.name);
        bedDetail.setText(sessionRoom.bedType.toString());
=======
        currentPayment = requestGetPayment(MainActivity.loginacc.id, MainActivity.loginacc.renter.id, sessionRoom.id);


        String price = NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(sessionRoom.price.price);
        String address = sessionRoom.address + ", " + sessionRoom.city;
        System.out.println(sessionRoom);


        detailName.setText(sessionRoom.name);
        detailBedType.setText(sessionRoom.bedType.toString());
>>>>>>> 360a270 (Update Proyek Reva - UI)
        sizeDetail.setText(sessionRoom.size + "m\u00B2");
        priceDetail.setText(price);
        addressDetail.setText(address);
    }

    public void mainLogic(){
        System.out.println(currentPayment);
        bookSuccess.setVisibility(TextView.INVISIBLE);
        bookFailed.setVisibility(TextView.INVISIBLE);
<<<<<<< HEAD
        if(currentPayment != null && currentPayment.status == Invoice.PaymentStatus.WAITING){

=======

        if(currentPayment != null && currentPayment.status == Invoice.PaymentStatus.WAITING){
            System.out.println("ASAL");
>>>>>>> 360a270 (Update Proyek Reva - UI)
            afterRent.setVisibility(CardView.VISIBLE);
            payButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent move = new Intent(DetailRoomActivity.this, BookingActivity.class);
                    startActivity(move);
//                    requestAcceptPayment(currentPayment.id);
                }
            });
            cancelButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    requestCancelPayment(currentPayment.id);
<<<<<<< HEAD
=======
                    Intent move = new Intent(DetailRoomActivity.this, MainActivity.class);
                    startActivity(move);
>>>>>>> 360a270 (Update Proyek Reva - UI)
                }
            });
        }
        else if(currentPayment != null && currentPayment.status == Invoice.PaymentStatus.SUCCESS){
            afterRent.setVisibility(CardView.INVISIBLE);
            rentButton.setVisibility(Button.INVISIBLE);
            bookSuccess.setVisibility(TextView.VISIBLE);
        }
<<<<<<< HEAD
//        else if(currentPayment != null && currentPayment.status == Invoice.PaymentStatus.FAILED){
//            afterRent.setVisibility(CardView.INVISIBLE);
//            rentButton.setVisibility(Button.INVISIBLE);
//            bookFailed.setVisibility(TextView.VISIBLE);
//        }


=======

    }

    protected Payment requestGetPayment(int buyerId, int renterId, int roomId){
        System.out.println("ASAL");
        mApiService.getPayment(buyerId, renterId, roomId).enqueue(new Callback<Payment>() {
            @Override
            public void onResponse(Call<Payment> call, Response<Payment> response) {
                if(response.isSuccessful()){
                    currentPayment = response.body();
                    System.out.println(currentPayment);
                    mainLogic();
                }
            }

            @Override
            public void onFailure(Call<Payment> call, Throwable t) {
                System.out.println(t.toString());
                mainLogic();
            }
        });
        return null;
>>>>>>> 360a270 (Update Proyek Reva - UI)
    }

    public void fillCheckbox(){
        System.out.println(facilityList);
        for(Facility facility: facilityList){
            if (facility == Facility.AC){
                checkboxAC.setChecked(true);
            }else if(facility == Facility.Balcony){
                checkboxBalcony.setChecked(true);
            }else if(facility == Facility.Bathtub) {
                checkboxBathtub.setChecked(true);
            }else if(facility == Facility.FitnessCenter){
                checkboxFitnessCenter.setChecked(true);
            }else if(facility == Facility.Refrigerator){
                checkboxRefrigerator.setChecked(true);
            }else if(facility == Facility.Restaurant){
                checkboxRestaurant.setChecked(true);
            }else if(facility == Facility.SwimmingPool){
                checkboxSwimPool.setChecked(true);
            }else if(facility == Facility.WiFi){
                checkboxWifi.setChecked(true);
            }
        }
    }
<<<<<<< HEAD

    protected Payment requestGetPayment(int buyerId, int renterId, int roomId){
        mApiService.getPayment(buyerId, renterId, roomId).enqueue(new Callback<Payment>() {
            @Override
            public void onResponse(Call<Payment> call, Response<Payment> response) {
                if(response.isSuccessful()){
                    currentPayment = response.body();
                    System.out.println(currentPayment);
                    mainLogic();
                }
            }

            @Override
            public void onFailure(Call<Payment> call, Throwable t) {
                System.out.println(t.toString());
                mainLogic();
            }
        });
        return null;
    }
=======
>>>>>>> 360a270 (Update Proyek Reva - UI)
}