package com.example.exp4;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FoodsSingleton {

    private static FoodsSingleton sFoodsSingleton;

    private static List<Food> mFoods;

    public static FoodsSingleton get() {
        if(sFoodsSingleton == null) {
            sFoodsSingleton = new FoodsSingleton();
        }
        return sFoodsSingleton;
    }

    private FoodsSingleton() {
        mFoods = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            Food food = new Food();
            food.setDescription("精品鸭脖选择六和品牌的一级樱桃谷鸭 , 无淤血、无表皮破损 , 有我们的专业采购员精选为 : 重量 40-50g , 每千克为6根 , 长度为 24cm 每根 , 比普通鸭脖含肉量更多. \n");
            food.setPrice(23.0);
            food.setImage(R.drawable.duck_neck);
            food.setName("麻辣鸭脖"+i);
            mFoods.add(food);
        }
    }

    public List<Food> getmFoods() {
        return mFoods;
    }

    public Food getFood(UUID id) {
        for(Food food : mFoods) {
            if(food.getId().equals(id)) {
                return food;
            }
        }

        return null;
    }
}
