package com.vozisov.wordpress;

import com.vozisov.wordpress.model.categories.Categories;
import com.vozisov.wordpress.model.comments.Comments;
import com.vozisov.wordpress.model.media.Media;
import com.vozisov.wordpress.model.pages.Page;
import com.vozisov.wordpress.model.posts.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by enot on 14.11.17.
 */

public interface Api {
    @GET("categories?per_page=100&hide_empty=true")
    Call<List<Categories>> loadCategories();

    @GET("posts")
    Call<List<Posts>> loadPosts(@Query("page") int page);

    @GET("posts")
    Call<List<Posts>> searchPosts(@Query("page") int page, @Query("search") String query);

    @GET("posts/{Id}")
    Call<Posts> loadPost(@Path("Id") int id);

    @GET("media/{Id}")
    Call<Media> loadMedia(@Path("Id") int id);

    @GET("posts")
    Call<List<Posts>> loadPostsFromCategory(@Query("page") int page, @Query("categories") int cat_id);

    @GET("comments?order=asc")
    Call<List<Comments>> getComments(@Query("post") int post_id);

    @GET("pages/{id}")
    Call<Page> loadPage(@Path("id") int id);
}
