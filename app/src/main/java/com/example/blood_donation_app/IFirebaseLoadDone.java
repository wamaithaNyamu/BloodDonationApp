package com.example.blood_donation_app;

import java.util.List;

public interface IFirebaseLoadDone {
    void onFirebaseLoadSuccess(List<SliderModel> SliderModelList);
    void onFirebaseLoadFailed(String message);
}
