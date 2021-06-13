package com.project.interview1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.project.interview1.adapter.AdapterItems;
import com.project.interview1.adapter.SliderAdapter;
import com.project.interview1.apiservice.ApiClient;
import com.project.interview1.apiservice.Endpoint;
import com.project.interview1.apiservice.pojos.read_items_by_section.DetailsBraItem;
import com.project.interview1.apiservice.pojos.read_items_by_section.DetailsItem;
import com.project.interview1.apiservice.pojos.read_items_by_section.Response;
import com.project.interview1.model.model_view_pager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    private ViewPager view_pager;
    private SliderAdapter adp;
    private List<model_view_pager> list;
    private TabLayout tab_layout;
    private RecyclerView recv;
    private List<DetailsItem> list_items;
    private EditText edt_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);


        init();

        tab_layout.setupWithViewPager(view_pager, true);
        list = new ArrayList<>();

        list.add(new model_view_pager("Men", R.drawable.dress));
        list.add(new model_view_pager("Women", R.drawable.women));
        list.add(new model_view_pager("Kids", R.drawable.kids));


        adp = new SliderAdapter(list);
        view_pager.setAdapter(adp);

        view_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                // Check if this is the page you want.

                Toast.makeText(getApplicationContext(), list.get(position).getItemname(), Toast.LENGTH_LONG).show();
                show_the_products( list.get(position).getItemname(),"");
            }
        });

        edt_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                show_the_products(s.toString(),"search");

            }
        });


    }


    private void init() {
        view_pager = findViewById(R.id.view_pager);
        tab_layout = findViewById(R.id.tab_layout);
        recv = findViewById(R.id.recv);
        edt_search=findViewById(R.id.edt_search);

    }

    private void show_the_products(String item_type,String search) {


        recv.setAdapter(null);
        list_items = new ArrayList<>();
        if (search.equals("")) {


            Endpoint apiService = ApiClient.getClient().create(Endpoint.class);

            Call<Response> call = apiService.read_item_by_category("100", "'" + item_type + "'", 0, 50);

            call.enqueue(new Callback<Response>() {
                @Override
                public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {

                    if (response.body() != null) {
                        if (response.body().getResult().equals("1")) {
                            list_items.addAll(response.body().getDetails());

                            AdapterItems adp = new AdapterItems(getApplicationContext(), list_items);

                            LinearLayoutManager lm = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                            recv.setLayoutManager(lm);
                            recv.setAdapter(adp);

                        }
                    }

                }

                @Override
                public void onFailure(Call<Response> call, Throwable t) {

                }
            });


        }
        else {
            Endpoint apiService = ApiClient.getClient().create(Endpoint.class);
            search="%"+ item_type + "%";
            Call<Response> call = apiService.read_item_by_itemname("100", "'" + search + "'", 0, 50);

            call.enqueue(new Callback<Response>() {
                @Override
                public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                    if(response.body()!=null)
                    {
                        if(response.body().getResult().equals("1"))
                        {
                            list_items.addAll(response.body().getDetails());

                            AdapterItems adp = new AdapterItems(getApplicationContext(), list_items);

                            LinearLayoutManager lm = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                            recv.setLayoutManager(lm);
                            recv.setAdapter(adp);
                        }
                    }
                }

                @Override
                public void onFailure(Call<Response> call, Throwable t) {

                }
            });
        }
    }




}