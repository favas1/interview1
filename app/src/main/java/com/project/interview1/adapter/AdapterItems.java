package com.project.interview1.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.project.interview1.R;
import com.project.interview1.apiservice.ApiClient;
import com.project.interview1.apiservice.pojos.read_items_by_section.DetailsItem;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class AdapterItems extends RecyclerView.Adapter<AdapterItems.ViewHolderClass> {


    Context context;
    List<DetailsItem> list;


    Vibrator vibe;

    public AdapterItems(Context context, List<DetailsItem> list) {
        this.context = context;
        this.list = list;


    }

    @Override
    public ViewHolderClass onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.model_cart_item, parent, false);
        //   view.findViewById(R.id.txt1).setMinimumHeight(560);
        // view.setMinimumHeight(160);
        //   View rootView = LayoutInflater.from(context).inflate(R.layout.itemLayout, parent, false);
        return new ViewHolderClass(view);

    }

    @Override
    public void onBindViewHolder(ViewHolderClass holder, int position) {


        final DetailsItem cpr = list.get(position);
        holder.txt_label.setText(cpr.getItemname());
//


        String fname = cpr.getFname();


        String[] fnames = new String[100];

        if (!fname.equals("")) {
            if (fname.contains(",")) {
                fnames = fname.split(",");
            } else {

                fnames[0] = fname;
            }

        }
         String profilepic = ApiClient.BASE_URL + "zpa/images/images/" + fnames[0] + "th" + ".jpeg";
         Glide.with(context).load(profilepic)
                 .sizeMultiplier(1.0f)

                 .placeholder(R.drawable.blanc_pic)
                 .error(R.drawable.blanc_pic)
                 .fallback(R.drawable.blanc_pic)
                 .dontAnimate()
                 .into(holder.iv1);
//


        //  holder.txtold.setBackgroundResource(R.color.color1);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolderClass extends RecyclerView.ViewHolder {


        TextView txt_label;
        ImageView iv1;


        public ViewHolderClass(View itemView) {
            super(itemView);


            txt_label = itemView.findViewById(R.id.txt_label);
            iv1=itemView.findViewById(R.id.iv1);


        }
    }


}
