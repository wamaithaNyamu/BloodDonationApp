package com.example.blood_donation_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;


    public SliderAdapter(Context context){
        this.context = context;


    };

//    images
    public int[] slide_images = {
        R.drawable.acc1,
        R.drawable.donor2,
        R.drawable.donor1,
        R.drawable.blood

};

    //    images
    public String[] slide_desc = {


            "When people talk about disaster preparedness, they mention everything — defence, warning systems, medical supplies, refuge centres, emergency meals, and all else that comes to mind when the word disaster pops up, all else except the one thing that is most critical to disaster management: Blood.",
            "The shortage of blood during the crises in this country over the past few years is a sure reason to get anybody worried, and those concerned with ensuring that our blood banks are in order are even more worried",
            "60% of the blood collected in Kenya is from high school children.50 million is the total population of Kenya.1% of the population is the World Health Organization recommended percentage of the country's blood collection.250,000 -is the current units of blood collected annually in Kenya.",
            "You can make a difference. Your blood matters. Donate blood and save a life",


    };

    @Override
    public int getCount() {
        return slide_images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    public Object instantiateItem(ViewGroup container, int position){
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideDesc = (TextView) view.findViewById(R.id.slide_desc);


        slideImageView.setImageResource(slide_images[position]);
        slideDesc.setText(slide_desc[position]);
        container.addView(view);

        return view;
    }

     @Override
    public void destroyItem(ViewGroup container, int position, Object object){

        container.removeView((RelativeLayout) object);
     }

}
