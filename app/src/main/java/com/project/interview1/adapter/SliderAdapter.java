package com.project.interview1.adapter;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.project.interview1.R;
import com.project.interview1.model.model_view_pager;

import java.util.List;

public class SliderAdapter extends PagerAdapter {

    List<model_view_pager> list;

    public SliderAdapter(List<model_view_pager> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view= LayoutInflater.from(container.getContext()).inflate(R.layout.image_layout,container,false);

        ImageView iv1=view.findViewById(R.id.iv1);
        iv1.setBackgroundResource(list.get(position).getPicture());
        container.addView(view);
       return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
    container.removeView((View)object);
    }
}
