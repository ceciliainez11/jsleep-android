package com.CeciliaInezRevaJSleepRJ.jsleep_android;

import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.Account;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.Invoice;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.Payment;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.request.BaseApiService;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.request.UtilsApi;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BookingActivity extends AppCompatActivity {
    BaseApiService mApiService;
    Context mContext;

    protected TextView priceText;
    TextView book_balance;
    protected static String priceCurrency;
    private DatePickerDialog datePickerDialog;
    private Button book_dateFrom, book_dateTo, book_buttonBook, book_buttonPay, book_buttonCancel;
    private int index = 0;
    protected static String from, to, from2, to2;
    protected static String totalPay;
    double roomPrice = DetailRoomActivity.sessionRoom.price.price;
    double accountBalance;
    long numDays = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_booking);
        mApiService = UtilsApi.getApiService();
        mContext = this;

        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        book_dateFrom = findViewById(R.id.book_dateFrom);
        book_dateTo = findViewById(R.id.book_dateTo);
        book_buttonBook = findViewById(R.id.book_buttonBook);
        book_buttonPay = findViewById(R.id.book_buttonPay);
        book_buttonCancel = findViewById(R.id.book_buttonCancel);
        book_balance = findViewById(R.id.book_balance);

        book_buttonBook.setVisibility(Button.VISIBLE);
        book_buttonPay.setVisibility(Button.GONE);
        book_buttonCancel.setVisibility(Button.GONE);

        //Update Saldo
        accountBalance = MainActivity.loginacc.balance;
        System.out.println("Saldo : "+MainActivity.loginacc.balance);
        System.out.println(accountBalance);

        if((DetailRoomActivity.currentPayment != null) &&
                (DetailRoomActivity.currentPayment.status == Invoice.PaymentStatus.WAITING)){
            book_dateFrom.setText(simpleDateFormat(DetailRoomActivity.currentPayment.from));
            book_dateTo.setText(simpleDateFormat(DetailRoomActivity.currentPayment.to));


            book_dateTo.setEnabled(false);
            book_dateFrom.setEnabled(false);

            //Balance
            String balanceCurrency = NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(accountBalance);
            book_balance.setText(balanceCurrency);
            System.out.println(roomPrice);
            System.out.println(simpleCalcDays(DetailRoomActivity.currentPayment.from, DetailRoomActivity.currentPayment.to));


            //Price
            priceText = findViewById(R.id.book_price);
            priceCurrency = NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(roomPrice * simpleCalcDays(DetailRoomActivity.currentPayment.from, DetailRoomActivity.currentPayment.to));
            totalPay = priceCurrency;
            System.out.println(priceCurrency);
            priceText.setText(priceCurrency);


            book_buttonPay.setVisibility(Button.VISIBLE);
            book_buttonCancel.setVisibility(Button.VISIBLE);
            book_buttonBook.setVisibility(Button.GONE);


            book_buttonPay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    requestAcceptPayment(DetailRoomActivity.currentPayment.id);
                }
            });


            book_buttonCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    requestCancelPayment(DetailRoomActivity.currentPayment.id);
                }

            });
        }

        else{
            book_dateTo.setEnabled(true);
            book_dateFrom.setEnabled(true);



            initDatePicker();
            from = getTodaysDate(0);
            to = getTodaysDate(1);
            from2 = from;
            to2 = to;

            book_dateFrom.setText(from);
            book_dateTo.setText(to);



            book_dateFrom.setOnClickListener(view -> {
                index = 1;
                datePickerDialog.show();
            });
            book_dateTo.setOnClickListener(view -> {
                index = 2;
                datePickerDialog.show();
            });

            book_buttonBook.setOnClickListener(view -> {
                numDays = calcDays(from, to);

                requestBooking(MainActivity.loginacc.id,
                        MainActivity.loginacc.renter.id,
                        DetailRoomActivity.sessionRoom.id,
                        formatDate(from),
                        formatDate(to));
            });

            updatePrice();
            String balanceCurrency = NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(accountBalance);
            book_balance.setText(balanceCurrency);
        }
    }

    protected Account requestAccount(int id){
        mApiService.getAccount(id).enqueue(new Callback<Account>() {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {
                if(response.isSuccessful()){
                    Account account;
                    MainActivity.loginacc = response.body();
                    System.out.println("BERHASILL");
                    System.out.println(MainActivity.loginacc.toString());
                }
            }

            @Override
            public void onFailure(Call<Account> call, Throwable t){
                System.out.println("gagal");
                System.out.println(t.toString());
                Toast.makeText(mContext, "no Account id=0", Toast.LENGTH_SHORT).show();
            }
        });
        return null;
    }

    private String makeDateString(int day, int month, int year){
        return getMonthFormat(month) + " " + day + " " + year;
    }

    private String getTodaysDate(int offset) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, offset);
        int year =cal.get(Calendar.YEAR);
        int month =cal.get(Calendar.MONTH);
        month = month + 1;
        int day =cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    private String getMonthFormat(int month) {
        switch (month){
            case 1:
                return "JAN";
            case 2:
                return "FEB";
            case 3:
                return "MAR";
            case 4:
                return "APR";
            case 5:
                return "MAY";
            case 6:
                return "JUN";
            case 7:
                return "JUL";
            case 8:
                return "AUG";
            case 9:
                return "SEP";
            case 10:
                return "OCT";
            case 11:
                return "NOV";
            case 12:
                return "DEC";
        }
        return null;
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = makeDateString(day, month, year);
                if(index == 1){
                    from = date;
                    book_dateFrom.setText(from);
                    updatePrice();
                }

                else if(index == 2){
                    String tempTo = to;
                    to = date;
                    if(calcDays(from, to) >= 1 ){
                        book_dateTo.setText(to);
                        updatePrice();
                    }else{
                        to = tempTo;
                        Toast.makeText(mContext, "Min. 1 day of stay", Toast.LENGTH_LONG).show();
                    }
                }
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int style = AlertDialog.THEME_HOLO_LIGHT;
        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis() + 30L *24*60*60*1000);
    }

    public String formatDate(String date){
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy");
        Date fDate = null;
        try {
            fDate = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat sdfFormat = new SimpleDateFormat("yyyy-MM-dd");
        assert fDate != null;
        return sdfFormat.format(fDate);
    }


    public void updatePrice(){
        //Updating Price
        priceText = findViewById(R.id.book_price);
        priceCurrency = NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(roomPrice * calcDays(from, to));
        totalPay = priceCurrency;
        priceText.setText(priceCurrency);
    }



    public long calcDays(String before, String after){
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy");
        Date dateBefore = null;
        Date dateAfter = null;
        try {
            dateBefore = sdf.parse(before);
            dateAfter = sdf.parse(after);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long timeDiff = Math.abs(dateAfter.getTime() - dateBefore.getTime());
        long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
        return daysDiff;
    }


    public long simpleCalcDays(Date before, Date after){
        long timeDiff = Math.abs(after.getTime() - before.getTime());
        return TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
    }



    public String simpleDateFormat(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy");
        assert date != null;
        return sdf.format(date);
    }


    protected Payment requestBooking(int buyerId, int renterId, int roomId, String from, String to){
        mApiService.createPayment(buyerId, renterId, roomId,from, to).enqueue(new Callback<Payment>() {
            @Override
            public void onResponse(Call<Payment> call, Response<Payment> response) {
                System.out.println("Membuat Booking");
                if(response.isSuccessful()){
                    Payment payment;
                    payment = response.body();
                    System.out.println(payment.toString());
                    System.out.println("Payment Success");
                    Toast.makeText(mContext, "Booking Successful", Toast.LENGTH_LONG).show();
                    Intent move = new Intent(BookingActivity.this, MainActivity.class);
                    startActivity(move);
                    //MainActivity.loginacc.balance-= roomPrice * calcDays(from2, to2);
                    requestAccount(MainActivity.loginacc.id);
                }
            }


            @Override
            public void onFailure(Call<Payment> call, Throwable t) {
                if(roomPrice * numDays  > accountBalance){
                    Toast.makeText(mContext, "Please top up first", Toast.LENGTH_LONG).show();
                }else{
                    System.out.println(from);
                    System.out.println(to);
                    Toast.makeText(mContext, "Please book another date", Toast.LENGTH_LONG).show();
                }
                System.out.println("Membuat Booking Gagal");
                Intent move = new Intent(BookingActivity.this, MainActivity.class);
                startActivity(move);
            }
        });
        return null;
    }

    protected Boolean requestAcceptPayment(int id){
        mApiService.accept(id).enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if(response.isSuccessful()){
//                    Toast.makeText(mContext, "Payment Successful", Toast.LENGTH_LONG).show();
                    Toast.makeText(mContext, "Payment Successful", Toast.LENGTH_SHORT).show();
                    Intent move = new Intent(BookingActivity.this, SuccessPaymentActivity.class);
                    startActivity(move);
                }
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                System.out.println(t.toString());
                Toast.makeText(mContext, "Payment Failed", Toast.LENGTH_LONG).show();
            }
        });
        return null;
    }

    protected Boolean requestCancelPayment(int id){
        mApiService.cancel(id).enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if(response.isSuccessful()){
                    Toast.makeText(mContext, "Payment Canceled", Toast.LENGTH_LONG).show();
                    requestAccount(MainActivity.loginacc.id);
                    Intent move = new Intent(BookingActivity.this, CancelPaymentActivity.class);
                    startActivity(move);
                }
            }
            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                System.out.println(t.toString());
                Toast.makeText(mContext, "Error!!", Toast.LENGTH_LONG).show();
            }
        });
        return null;
    }
}