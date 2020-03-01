package io.github.mortuzahossain.recyclertest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mortuza Hossain on 29-Feb-2020
 * Email : mortuzahossain1997@gmail.com
 **/
public class NavigationModel {
    int id;
    String title;

    public NavigationModel(int imageId, String title) {
        this.id = imageId;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static List<NavigationModel> getData(){
        List<NavigationModel> navigationModels = new ArrayList<>();

        navigationModels.add(new NavigationModel(R.drawable.ic_android_black_24dp,"Android"));
        navigationModels.add(new NavigationModel(R.drawable.ic_attach_money_black_24dp,"Money"));
        navigationModels.add(new NavigationModel(R.drawable.ic_beach_access_black_24dp,"Beach"));
        navigationModels.add(new NavigationModel(R.drawable.ic_hotel_black_24dp,"Hotel"));

        return navigationModels;
    }
}
