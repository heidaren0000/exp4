package com.example.exp4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class FoodListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mListAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceStates) {
        View v = inflater.inflate(R.layout.fragment_food_list, container, false);
        return v;
    }

    private class FoodListHolder extends RecyclerView.ViewHolder{
        public FoodListHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.fragment_food_list_item, parent, false));
        }
    }

    public class FoodListAdapter extends RecyclerView.Adapter<FoodListHolder> {
        private List<Food> mFoodList;

    }

}
