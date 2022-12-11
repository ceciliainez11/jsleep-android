package com.CeciliaInezRevaJSleepRJ.jsleep_android.model;

import java.util.Date;

public class Payment extends Invoice {
    public Date to;
    public Date from;
    public PaymentStatus status;

    private int roomId;

    public int getRoomId()
    {
        return roomId;
    }

    public Payment(int id) {
        super(id);
    }
}
