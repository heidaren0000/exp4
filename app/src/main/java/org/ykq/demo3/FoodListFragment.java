package org.ykq.demo3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class FoodListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private FoodListAdapter mListAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceStates) {
        View v = inflater.inflate(R.layout.fragment_food_list, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.food_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();

        return v;
    }

    private class FoodListHolder extends RecyclerView.ViewHolder{
        private Food mFood;
        private ImageView mFoodImage;
        private TextView mName;
        private TextView mDescription;
        private TextView mAdd2cart;
        private TextView mFoodPrice;
        public FoodListHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.fragment_food_list_item, parent, false));
            mFoodImage = itemView.findViewById(R.id.food_image);
            mName = itemView.findViewById(R.id.food_name);
            mDescription = itemView.findViewById(R.id.food_desc);
            mAdd2cart = itemView.findViewById(R.id.add2cart);
            mAdd2cart.setText("加入购物车");
            mFoodPrice = itemView.findViewById(R.id.food_price);

        }
        public void bind(Food food) {
            mFood = food;
            mFoodPrice.setText("¥ "+mFood.getPrice().toString());
            mFoodImage.setImageResource(mFood.getImage());
            mName.setText(mFood.getName());
            mDescription.setText(mFood.getDescription());
            StringBuilder descString = new StringBuilder();
            descString.append(mName.getText());
            descString.append(mFoodPrice.getText());
            descString.append(mDescription.getText());
            mAdd2cart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(), descString.toString(), Toast.LENGTH_SHORT).show();
                }
            });
            mName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(), mName.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private class FoodListAdapter extends RecyclerView.Adapter<FoodListHolder> {
        private List<Food> mFoodList;

        public FoodListAdapter(List<Food> foods) {
            mFoodList = foods;
        }
        @Override
        public FoodListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new FoodListHolder(layoutInflater, parent);
        }
        @Override
        public void onBindViewHolder(FoodListHolder holder, int position) {
            Food food = mFoodList.get(position);
            holder.bind(food);
        }

        @Override
        public int getItemCount() {
            return mFoodList.size();
        }
    }
    private void updateUI() {
        FoodsSingleton foodsSingleton = FoodsSingleton.get();
        List<Food> foods = foodsSingleton.getmFoods();

        mListAdapter = new FoodListAdapter(foods);
        mRecyclerView.setAdapter(mListAdapter);
    }
}
