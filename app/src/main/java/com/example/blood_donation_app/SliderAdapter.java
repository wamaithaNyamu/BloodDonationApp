package com.example.blood_donation_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

public class SliderAdapter extends PagerAdapter {
    Context context;
    List<SliderModel> sliderModelList;
    LayoutInflater inflater;

    public SliderAdapter(Context context, List<SliderModel> sliderModelList) {
        this.context = context;
        this.sliderModelList = sliderModelList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return sliderModelList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager)container ).removeView((View)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = inflater.inflate(R.layout.slide_layout, container, false);

        TextView hospitalName = (TextView)view.findViewById(R.id.slider_hospital_name);
        SeekBar Apositive = (SeekBar)view.findViewById(R.id.seekAPositive);
        SeekBar ANegative = (SeekBar)view.findViewById(R.id.seekANegative);

        SeekBar Bpositive = (SeekBar)view.findViewById(R.id.seekBPositive);
        SeekBar BNegative = (SeekBar)view.findViewById(R.id.seekBNegative);

        SeekBar ABpositive = (SeekBar)view.findViewById(R.id.seekABPositive);
        SeekBar ABNegative = (SeekBar)view.findViewById(R.id.seekABNegative);

        SeekBar Opositive = (SeekBar)view.findViewById(R.id.seekOPositive);
        SeekBar ONegative = (SeekBar)view.findViewById(R.id.seekONegative);


        hospitalName.setText(sliderModelList.get(position).getHospitalName());
        Apositive.setProgress(sliderModelList.get(position).getAPositive());
        ANegative.setProgress(sliderModelList.get(position).getANegative());

        Bpositive.setProgress(sliderModelList.get(position).getBPositive());
        BNegative.setProgress(sliderModelList.get(position).getBNegative());

        ABpositive.setProgress(sliderModelList.get(position).getABPositive());
        ABNegative.setProgress(sliderModelList.get(position).getABNegative());

        Opositive.setProgress(sliderModelList.get(position).getOPositive());
        ONegative.setProgress(sliderModelList.get(position).getONegative());
        container.addView(view);
        return view;
    };
}
