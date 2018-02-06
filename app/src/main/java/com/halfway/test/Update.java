package com.halfway.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import retrofit2.Response;

public class Update extends Fragment {

    public static RequestInterface requestInterface;
    RecyclerView recyclerView;
    List<Card> items;

    public Update() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update, container, false);
        requestInterface = Controller.getApi();

        items = new ArrayList<Card>();

        recyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        CardAdapter adapter = new CardAdapter(getActivity(), items);
        recyclerView.setAdapter(adapter);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d("myLogs", "Yes!");
                        final Response response =  requestInterface.getCard().execute();
                        if (response.code() == 200) {
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    for(int i = 0; i < 263; i++) {
                                        items.add((Card) response.body());
                                        recyclerView.getAdapter().notifyDataSetChanged();
                                    }
                                }
                            });
                        }


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 15, TimeUnit.SECONDS);

        return view;

    }

}
