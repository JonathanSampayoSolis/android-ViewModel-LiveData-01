package com.example.jjsampayo.livedata;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import android.os.Handler;
import android.util.Log;

/**
 * Created by
 *      jjsampayo on 19/03/2018.
 */

public class ViewModelMain extends ViewModel {
    private final String TAG  = ViewModelMain.class.getSimpleName().toUpperCase();

    private MutableLiveData<ArrayList<GodModel>> godsList;

    public LiveData<ArrayList<GodModel>> getGodsList() {
        if (godsList == null) {
            godsList = new MutableLiveData<>();
            loadData();
        }
        return  godsList;
    }

    private void loadData() {
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            ArrayList<GodModel> mData = new ArrayList<>();
            mData.add(new GodModel("Thanatos", "Roman"));
            mData.add(new GodModel("Zeus", "Greek"));
            mData.add(new GodModel("Thot", "Egyptian"));
            mData.add(new GodModel("Jing Wei", "Chinese"));
            mData.add(new GodModel("Amaterasu", "Japanese"));
            mData.add(new GodModel("Neith", "Egyptian"));
            mData.add(new GodModel("Ra", "Egyptian"));
            mData.add(new GodModel("Kepri", "Egyptian"));
            mData.add(new GodModel("Thor", "Nordic"));
            mData.add(new GodModel("Kukulkan", "Mayan"));

            long seed = System.nanoTime();
            Collections.shuffle(mData, new Random(seed));

            //TODO: The LiveData().setValue() only can be called within the main thread.
            godsList.setValue(mData);
        }, 5000);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "Data has been cleared...");
    }
}
