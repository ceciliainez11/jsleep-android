package com.CeciliaInezRevaJSleepRJ.jsleep_android;

<<<<<<< HEAD
import androidx.appcompat.app.AppCompatActivity;

=======
import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.Account;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.Invoice;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.Payment;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.request.BaseApiService;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.request.UtilsApi;
import androidx.appcompat.app.AppCompatActivity;
>>>>>>> 360a270 (Update Proyek Reva - UI)
import android.annotation.SuppressLint;
import android.os.Bundle;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
<<<<<<< HEAD

=======
>>>>>>> 360a270 (Update Proyek Reva - UI)
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;
<<<<<<< HEAD

import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.Invoice;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.Payment;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.request.BaseApiService;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.request.UtilsApi;

=======
>>>>>>> 360a270 (Update Proyek Reva - UI)
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BookingActivity extends AppCompatActivity {
    BaseApiService mApiService;
    Context mContext;

<<<<<<< HEAD
    private DatePickerDialog datePickerDialog;
    private Button dateButtonFrom, dateButtonTo, saveBookButton, payButton, cancelButton;
=======
    protected TextView priceText;
    TextView book_balance;
    protected static String priceCurrency;
    private DatePickerDialog datePickerDialog;
    private Button book_dateFrom, book_dateTo, book_buttonBook, book_buttonPay, book_buttonCancel;
>>>>>>> 360a270 (Update Proyek Reva - UI)
    private int index = 0;
    protected static String from, to, from2, to2;
    protected static String totalPay;
    double roomPrice = DetailRoomActivity.sessionRoom.price.price;
    double accountBalance;
    long numDays = 0;

<<<<<<< HEAD
    protected TextView priceText;
    protected static String priceCurrency;

=======
>>>>>>> 360a270 (Update Proyek Reva - UI)
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

<<<<<<< HEAD
        dateButtonFrom = findViewById(R.id.booking_datePickerTo);
        dateButtonTo = findViewById(R.id.booking_datePickerFrom);
        saveBookButton = findViewById(R.id.booking_saveButton);
        payButton = findViewById(R.id.booking_payButton);
        cancelButton = findViewById(R.id.booking_cancelButton);

        TextView balanceText = findViewById(R.id.booking_balance);

        saveBookButton.setVisibility(Button.VISIBLE);
        payButton.setVisibility(Button.GONE);
        cancelButton.setVisibility(Button.GONE);

        //Update Saldo
        accountBalance = MainActivity.loginacc.balance;
        System.out.println("saldo asli : "+MainActivity.loginacc.balance);
        System.out.println(accountBalance);

        if((DetailRoomActivity.currentPayment != null) && (DetailRoomActivity.currentPayment.status == Invoice.PaymentStatus.WAITING)){
            dateButtonFrom.setText(simpleDateFormat(DetailRoomActivity.currentPayment.from));
            dateButtonTo.setText(simpleDateFormat(DetailRoomActivity.currentPayment.to));
            dateButtonTo.setEnabled(false);
            dateButtonFrom.setEnabled(false);

            //Update Balance
            String balanceCurrency = NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(accountBalance);
            balanceText.setText(balanceCurrency);

            System.out.println(roomPrice);
            System.out.println(simpleCalcDays(DetailRoomActivity.currentPayment.from, DetailRoomActivity.currentPayment.to));
            //Update Price
            priceText = findViewById(R.id.booking_price);
=======
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
>>>>>>> 360a270 (Update Proyek Reva - UI)
            priceCurrency = NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(roomPrice * simpleCalcDays(DetailRoomActivity.currentPayment.from, DetailRoomActivity.currentPayment.to));
            totalPay = priceCurrency;
            System.out.println(priceCurrency);
            priceText.setText(priceCurrency);

<<<<<<< HEAD
            saveBookButton.setVisibility(Button.GONE);
            payButton.setVisibility(Button.VISIBLE);
            cancelButton.setVisibility(Button.VISIBLE);

            payButton.setOnClickListener(new View.OnClickListener() {
=======

            book_buttonPay.setVisibility(Button.VISIBLE);
            book_buttonCancel.setVisibility(Button.VISIBLE);
            book_buttonBook.setVisibility(Button.GONE);


            book_buttonPay.setOnClickListener(new View.OnClickListener() {
>>>>>>> 360a270 (Update Proyek Reva - UI)
                @Override
                public void onClick(View view) {
                    requestAcceptPayment(DetailRoomActivity.currentPayment.id);
                }
            });
<<<<<<< HEAD
            cancelButton.setOnClickListener(new View.OnClickListener() {
=======


            book_buttonCancel.setOnClickListener(new View.OnClickListener() {
>>>>>>> 360a270 (Update Proyek Reva - UI)
                @Override
                public void onClick(View view) {
                    requestCancelPayment(DetailRoomActivity.currentPayment.id);
                }
<<<<<<< HEAD
=======

>>>>>>> 360a270 (Update Proyek Reva - UI)
            });
        }

        else{
<<<<<<< HEAD
            dateButtonTo.setEnabled(true);
            dateButtonFrom.setEnabled(true);
            //Default Value dari dateButton
            initDatePicker();
            from = getTodaysDate(0);
            to = getTodaysDate(1);

            from2 = from;
            to2 = to;

            dateButtonFrom.setText(from);
            dateButtonTo.setText(to);

            //dateButton ketika di klik
            dateButtonFrom.setOnClickListener(view -> {
                index = 1;
                datePickerDialog.show();
            });
            dateButtonTo.setOnClickListener(view -> {
=======
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
>>>>>>> 360a270 (Update Proyek Reva - UI)
                index = 2;
                datePickerDialog.show();
            });

<<<<<<< HEAD
            saveBookButton.setOnClickListener(view -> {
                numDays = calcDays(from, to);

//                System.out.println(MainActivity.cookies.id);
//                System.out.println(MainActivity.cookies.renter.id);
//                System.out.println(DetailRoomActivity.sessionRoom.id);
//                System.out.println(from);
//                System.out.println(formatDate(from));
//                System.out.println(formatDate(to));


=======
            book_buttonBook.setOnClickListener(view -> {
                numDays = calcDays(from, to);

>>>>>>> 360a270 (Update Proyek Reva - UI)
                requestBooking(MainActivity.loginacc.id,
                        MainActivity.loginacc.renter.id,
                        DetailRoomActivity.sessionRoom.id,
                        formatDate(from),
                        formatDate(to));
            });

            updatePrice();
            String balanceCurrency = NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(accountBalance);
<<<<<<< HEAD
            balanceText.setText(balanceCurrency);
        }


=======
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
>>>>>>> 360a270 (Update Proyek Reva - UI)
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

<<<<<<< HEAD
    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = makeDateString(day, month, year);
                if(index == 1){
                    from = date;
                    dateButtonFrom.setText(from);
                    updatePrice();
                }else if(index == 2){
                    String tempTo = to;
                    to = date;
                    if(calcDays(from, to) >= 1 ){
                        dateButtonTo.setText(to);
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
    private String makeDateString(int day, int month, int year){
        return getMonthFormat(month) + " " + day + " " + year;
    }

=======
>>>>>>> 360a270 (Update Proyek Reva - UI)
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

<<<<<<< HEAD
=======
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

>>>>>>> 360a270 (Update Proyek Reva - UI)
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

<<<<<<< HEAD
    public void updatePrice(){
        //Updating Price
        priceText = findViewById(R.id.booking_price);
=======

    public void updatePrice(){
        //Updating Price
        priceText = findViewById(R.id.book_price);
>>>>>>> 360a270 (Update Proyek Reva - UI)
        priceCurrency = NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(roomPrice * calcDays(from, to));
        totalPay = priceCurrency;
        priceText.setText(priceCurrency);
    }

<<<<<<< HEAD
=======


>>>>>>> 360a270 (Update Proyek Reva - UI)
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

<<<<<<< HEAD
=======

>>>>>>> 360a270 (Update Proyek Reva - UI)
    public long simpleCalcDays(Date before, Date after){
        long timeDiff = Math.abs(after.getTime() - before.getTime());
        return TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
    }

<<<<<<< HEAD
=======


>>>>>>> 360a270 (Update Proyek Reva - UI)
    public String simpleDateFormat(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy");
        assert date != null;
        return sdf.format(date);
    }


    protected Payment requestBooking(int buyerId, int renterId, int roomId, String from, String to){
<<<<<<< HEAD
        mApiService.createPayment(buyerId, renterId, roomId,from, to).enqueue(new Callback<Payment>() {
=======
        mApiService.createPayment(buyerId, renterId, roomId, from, to).enqueue(new Callback<Payment>() {
>>>>>>> 360a270 (Update Proyek Reva - UI)
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
<<<<<<< HEAD
                    MainActivity.loginacc.balance-= roomPrice * calcDays(from2, to2);
                }
            }

=======
                    //MainActivity.loginacc.balance-= roomPrice * calcDays(from2, to2);
                    requestAccount(MainActivity.loginacc.id);
                }
            }


>>>>>>> 360a270 (Update Proyek Reva - UI)
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
<<<<<<< HEAD
=======
                    requestAccount(MainActivity.loginacc.id);
>>>>>>> 360a270 (Update Proyek Reva - UI)
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