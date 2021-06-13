package com.project.interview1.apiservice;



import com.project.interview1.apiservice.pojos.read_items_by_section.Response;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Endpoint {

 @FormUrlEncoded
 @POST("zpa/read_item_by_category_with_limit.php")
 Call<Response> read_item_by_category(@Field("apikey") String apikey, @Field ("category") String category, @Field ("from") int from, @Field ("count") int count);



 @FormUrlEncoded
 @POST("zpa/read_item_by_itemname_wth_lmt.php")
 Call<Response> read_item_by_itemname(@Field("apikey") String apikey, @Field ("itemname") String itemname,@Field ("from") int from,@Field ("count") int count);



}
