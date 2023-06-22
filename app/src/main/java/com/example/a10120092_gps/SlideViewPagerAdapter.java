package com.example.a10120092_gps;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
/*   Nama  : Alfandi Khaerul Rahman
 *   NIM   : 10120092
 *   Kelas : IF-3
 */
public class SlideViewPagerAdapter extends PagerAdapter {

    Context ctx;

    public SlideViewPagerAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater= (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_screen,container,false);


        ImageView logo=view.findViewById(R.id.logo);
        ImageView idn1=view.findViewById(R.id.idn1);
        ImageView idn2=view.findViewById(R.id.idn2);
        ImageView idn3=view.findViewById(R.id.idn3);

        TextView txt_judul=view.findViewById(R.id.txt_judul);
        TextView txt_desc=view.findViewById(R.id.txt_desc);
        TextView txt_deskripsi=view.findViewById(R.id.txt_deskripsi);

        ImageView next=view.findViewById(R.id.img_next);
        ImageView back=view.findViewById(R.id.img_back);


        Button btnGetStarted=view.findViewById(R.id.btnGetStarted);
        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                ctx.startActivity(intent);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SlideActivity.viewPager.setCurrentItem(position+1);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SlideActivity.viewPager.setCurrentItem(position-1);
            }
        });

        switch (position)
        {
            case 0:
                logo.setImageResource(R.drawable.map);
                idn1.setImageResource(R.drawable.selected);
                idn2.setImageResource(R.drawable.unselected);
                idn3.setImageResource(R.drawable.unselected);

                txt_judul.setText("Restaurant");
                txt_desc.setText("Rekomendasi Restaurant");
                txt_deskripsi.setText("Kamu bisa melihat beberapa rekomendasi restaurant terdekat");
                back.setVisibility(View.GONE);
                next.setVisibility(View.VISIBLE);
                break;
            case 1:
                logo.setImageResource(R.drawable.restourant);
                idn1.setImageResource(R.drawable.unselected);
                idn2.setImageResource(R.drawable.selected);
                idn3.setImageResource(R.drawable.unselected);

                txt_judul.setText("Restaurant");
                txt_desc.setText("Pilih Restaurant");
                txt_deskripsi.setText("Kamu dapat memilihi restaurant yang diinginkan, dan dapatkan informasinya");
                back.setVisibility(View.VISIBLE);
                next.setVisibility(View.VISIBLE);
                break;
            case 2:
                logo.setImageResource(R.drawable.image_makan);
                idn1.setImageResource(R.drawable.unselected);
                idn2.setImageResource(R.drawable.unselected);
                idn3.setImageResource(R.drawable.selected);

                txt_judul.setText("Restaurant");
            txt_desc.setText("Let's Have Fun");
                txt_deskripsi.setText("");
                next.setVisibility(View.GONE);
                break;
        }
        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
