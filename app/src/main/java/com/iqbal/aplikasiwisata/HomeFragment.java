package com.aditya.natureexploresampleui;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aditya.natureexploresampleui.model.Places;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private PlaceAdapter placeAdapter;
    private ArrayList<Places> listPlace;
    private String[] arrayName, arrayLocation;
    private TypedArray dataImage;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prepare();
        init();
        placeAdapter = new PlaceAdapter();
        placeAdapter.setData(listPlace);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView rv = root.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(root.getContext(), LinearLayoutManager.HORIZONTAL, false));
        rv.setAdapter(placeAdapter);
        return root;
    }

    private void prepare() {
        arrayName = getResources().getStringArray(R.array.place_name);
        arrayLocation = getResources().getStringArray(R.array.place_location);
        dataImage = getResources().obtainTypedArray(R.array.data_image);
    }

    private void init() {
        listPlace = new ArrayList<>();

        for (int i = 0; i < arrayName.length; i++) {
            Places places = new Places();
            places.setNama(arrayName[i]);
            places.setJarak(arrayLocation[i]);
            places.setImage(dataImage.getResourceId(i, -1));
            listPlace.add(places);
        }
    }
}
