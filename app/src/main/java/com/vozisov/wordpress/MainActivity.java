package com.vozisov.wordpress;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.vozisov.wordpress.model.categories.Categories;
import com.vozisov.wordpress.model.media.Media;
import com.vozisov.wordpress.model.posts.Posts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List<Posts> posts;
    List<Posts> all_posts = new ArrayList<>();
    List<Media> all_media = new ArrayList<>();
    int page = 1;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    int select_pos = 0;
    int cat_id = 0;
    private ProgressBar progressBar;
    ArrayList<Media> media = new ArrayList<>();
    private Toolbar toolbar;

    TextView cat_name;

    private ArrayList<String> groupList;
    private ArrayList<String> childList;
    private HashMap<String, List<String>> laptopCollection;
    private HashMap<Integer, List<Integer>> categoryIdList;
    private List<Categories> categories = new ArrayList<Categories>();
    private ArrayList<Integer> catList;
    private ExpandableListView expListView;
    private int lastExpandedPosition = -1;
    private int firstExpandedPosition = 0;
    private boolean isSearch = false;
    private String query_string = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //startService(new Intent(MainActivity.this, PostRefresh.class));

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.app_title);
        getSupportActionBar().setSubtitle(R.string.app_full_name);
        //toolbar.setNavigationIcon(android.R.drawable.ic_dialog_alert);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        cat_name = (TextView) findViewById(R.id.cat_name);
        cat_name.setText("Категория: " + getResources().getString(R.string.all_category));

        createGroupList();
        getPosts(page, cat_id);

        final TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("tag1");

        tabSpec.setContent(R.id.tab1);
        tabSpec.setIndicator("Все записи");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag2");
        tabSpec.setContent(R.id.tab2);
        tabSpec.setIndicator("Категории");
        tabHost.addTab(tabSpec);

        tabHost.setCurrentTab(0);

        tabHost.getTabWidget().getChildAt(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tabHost.getCurrentTabTag().equals("tag1")) {
                    progressBar.setVisibility(View.VISIBLE);
                    cat_name.setText("Категория: " + getResources().getString(R.string.all_category));
                    arrayList.clear();
                    all_posts.clear();
                    all_media.clear();
                    page = 1;
                    cat_id = 0;
                    select_pos = 0;
                    getPosts(page, cat_id);
                }

                if (tabHost.getCurrentTabTag().equals("tag2")) {
                    tabHost.setCurrentTab(0);
                }
            }
        });


    }

    public void setData() {

        final ListView lv = (ListView) findViewById(R.id.list_posts);

        HashMap<String, String> map;

        System.out.println(all_media.size());

        for (int i = 0; i < posts.size(); i++) {
            //System.out.println(media);
            map = new HashMap<>();
            map.put("Name", Html.fromHtml(posts.get(i).getTitle().getRendered()).toString());
            map.put("Desc", Html.fromHtml(posts.get(i).getExcerpt().getRendered()).toString());
            map.put("Id", Integer.toString(posts.get(i).getId()));
            //map.put("Media", url_image.get(i));
            System.out.println("-----------");
            System.out.println(all_media.get(i));
            System.out.println("-----------");
            //System.out.println("---");

            if (all_media.get(i) != null) {
                map.put("Media", all_media.get(i).getMediaDetails().getFile());
                System.out.println(all_media.get(i).getMediaDetails().getFile());
            } else {
                map.put("Media", "");
            }
            arrayList.add(map);

        }


        final MyAdapter adapter = new MyAdapter(getBaseContext(), arrayList, R.layout.list_posts,
                new String[]{"Name", "Desc", "Media"},
                new int[]{R.id.text1, R.id.text2, R.id.imageView});

        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        lv.setSelection(select_pos);
        progressBar.setVisibility(View.INVISIBLE);

        lv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == AbsListView.OnScrollListener.SCROLL_STATE_IDLE
                        && (lv.getLastVisiblePosition() - lv.getHeaderViewsCount() -
                        lv.getFooterViewsCount()) >= (adapter.getCount() - 1)) {
                    if (posts.size() == 10) {
                        progressBar.setVisibility(View.VISIBLE);

                        if (isSearch) {
                            searchPosts(++page, query_string);
                        } else {
                            getPosts(++page, cat_id);
                        }
                        select_pos = lv.getLastVisiblePosition();

                    }
                }
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {

            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailPost.class);
                intent.putExtra("post_id", all_posts.get(i).getId());
                startActivity(intent);
            }
        });
    }


    private void getPosts(final int page, int cat_id) {

        Call<List<Posts>> callp;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        if (cat_id != 0) {
            callp = api.loadPostsFromCategory(page, cat_id);
        } else {
            callp = api.loadPosts(page);
        }


        callp.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                if (response.isSuccessful()) {
                    posts = response.body(); // have your all data

                    //System.out.println(posts);
                    all_posts.addAll(posts);
                    isSearch = false;
                    getMedia(all_posts);
                }
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                System.out.println("fail");
            }
        });
    }

    private void searchPosts(final int page, String query) {

        query_string = query;
        Call<List<Posts>> callp;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        callp = api.searchPosts(page, query_string);


        callp.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                if (response.isSuccessful()) {
                    posts = response.body(); // have your all data
                    if (posts.size() > 0) {
                        //System.out.println(posts);
                        all_posts.addAll(posts);
                        isSearch = true;
                        setData();
                    } else {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Записей не найдено!", Toast.LENGTH_LONG);
                        toast.show();
                        progressBar = (ProgressBar) findViewById(R.id.progressBar);
                        progressBar.setVisibility(View.INVISIBLE);

                    }
                }
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                System.out.println("fail");
            }
        });
    }

    int j = 0;

    private void getMedia(final List<Posts> posts) {
        int i;
        for (i = 0; i < posts.size(); i++) {

            //System.out.println(featuredMedia);
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Config.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Api api = retrofit.create(Api.class);
            Call<Media> call = api.loadMedia(posts.get(i).getFeaturedMedia());

            call.enqueue(new Callback<Media>() {
                @Override
                public void onResponse(Call<Media> call, Response<Media> response) {
                    if (response.isSuccessful()) {
                        all_media.add(response.body());
                        //System.out.println("resp ok!!");
                    } else {
                        all_media.add(null);
                        //System.out.println("resp null!!");
                    }
                    if (j == posts.size() - 1) {
                        setData();
                    }
                    j++;
                }

                @Override
                public void onFailure(Call<Media> call, Throwable t) {
                    all_media.add(null);
                    //System.out.println("fail");
                    if (j == posts.size() - 1) {
                        setData();
                    }
                    j++;
                }
            });
        }
        j = 0;
    }


    private void createGroupList() {
        groupList = new ArrayList<String>();
        final HashMap<Integer, String> subs = new HashMap<Integer, String>();
        laptopCollection = new LinkedHashMap<String, List<String>>();
        categoryIdList = new LinkedHashMap<Integer, List<Integer>>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<Categories>> call = api.loadCategories();

        call.enqueue(new Callback<List<Categories>>() {
            public void onResponse(Call<List<Categories>> call, Response<List<Categories>> response) {
                if (response.isSuccessful()) {
                    categories = response.body();
                    //groupList.add(getResources().getString(R.string.all_category));
                    //subs.put(0, getResources().getString(R.string.all_category));
                    //put the id, and name of categories into a Map to be iterated for parent ID
                    for (int i = 0; i < categories.size(); i++) {
                        subs.put(categories.get(i).getId(), categories.get(i).getName());
                        if (categories.get(i).getParent() == 0) {
                            groupList.add(categories.get(i).getName()); //parent category list ArrayList<String>
                        }
                    }

                    //Iterate Map to extract the right parent ID for subcategories
                    for (Map.Entry<Integer, String> entry : subs.entrySet()) {
                        int key = entry.getKey();
                        ArrayList<String> nameArr = new ArrayList<String>();
                        int k = 0;
                        for (int i = 0; i < categories.size(); i++) {
                            if ((categories.get(i).getParent() == key)) {
                                if (k == 0) {
                                    nameArr.add(entry.getValue());
                                    k = 1;
                                }
                                nameArr.add(categories.get(i).getName());
                            }
                        }
                        String[] subCategory = nameArr.toArray(new String[nameArr.size()]);
                        childList = new ArrayList<String>();
                        for (String model : subCategory) {
                            childList.add(model);
                        }
                        laptopCollection.put(entry.getValue(), childList);
                    }


                    //Iterate through the Grouplist of categories
                    //Iterate through the Map to get Value stored and check against the Grouplist of categories
                    //If found in lowercase, add the Category ID to categoryId List.
                    int j = 0;
                    for (String grlist : groupList) {
                        for (Map.Entry<Integer, String> entry : subs.entrySet()) {
                            int key = entry.getKey();
                            if (entry.getValue().toLowerCase().equals(grlist.toLowerCase())) {
                                catList = new ArrayList<Integer>();
                                int k = 0;
                                for (int i = 0; i < categories.size(); i++) {
                                    if (categories.get(i).getParent() == key) {
                                        if (k == 0) {
                                            catList.add(categories.get(i).getParent());
                                            k = 1;
                                        }
                                        catList.add(categories.get(i).getId());
                                    }
                                }
                                categoryIdList.put(j, catList);
                                j++;
                            }
                        }
                    }


                    expListView = (ExpandableListView) findViewById(R.id.menu_list);
                    final ExpandableListAdapter expListAdapter = new ExpandableListAdapter(
                            MainActivity.this, groupList, laptopCollection, categoryIdList);
                    expListView.setAdapter(expListAdapter);
                    expListView.setFocusable(false);

                    expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
                        @Override
                        public void onGroupExpand(int groupPosition) {
                            System.out.println(categoryIdList);
                            if (categoryIdList.get(groupPosition).size() == 0) {

                                TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
                                tabHost.setCurrentTab(0);

                                progressBar = (ProgressBar) findViewById(R.id.progressBar);
                                progressBar.setVisibility(View.VISIBLE);

                                cat_name = (TextView) findViewById(R.id.cat_name);
                                cat_name.setText("Категория: " + groupList.get(groupPosition));

                                arrayList.clear();
                                all_posts.clear();
                                all_media.clear();
                                page = 1;
                                select_pos = 0;
                                int catid = 0;
                                for (int i = 0; i < categories.size(); i++) {
                                    if (categories.get(i).getName() == groupList.get(groupPosition)) {
                                        catid = categories.get(i).getId();
                                    }
                                }

                                getPosts(page, catid);

                            }

                            if (firstExpandedPosition == 0) {
                                lastExpandedPosition = firstExpandedPosition;
                                firstExpandedPosition = 99; //any random number apart from zero
                            }

                            if (lastExpandedPosition != -1
                                    && groupPosition != lastExpandedPosition) {
                                expListView.collapseGroup(lastExpandedPosition);
                            }

                            lastExpandedPosition = groupPosition;
                        }
                    });

                    expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                        public boolean onChildClick(ExpandableListView parent, View v,
                                                    int groupPosition, int childPosition, long id) {

                            int cat = categoryIdList.get(groupPosition).get(childPosition);
                            final String selected = (String) expListAdapter.getChild(
                                    groupPosition, childPosition);

                            TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
                            tabHost.setCurrentTab(0);

                            progressBar = (ProgressBar) findViewById(R.id.progressBar);
                            progressBar.setVisibility(View.VISIBLE);

                            cat_name = (TextView) findViewById(R.id.cat_name);
                            cat_name.setText("Категория: " + selected);
                            //System.out.println(cat);
                            arrayList.clear();
                            all_posts.clear();
                            all_media.clear();
                            page = 1;
                            select_pos = 0;
                            getPosts(page, cat);


                            return true;
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<List<Categories>> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem item = menu.findItem(R.id.app_bar_search);

        SearchView sv = (SearchView) item.getActionView();

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                if (s.length() > 3) {

                    TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
                    tabHost.setCurrentTab(0);

                    progressBar = (ProgressBar) findViewById(R.id.progressBar);
                    progressBar.setVisibility(View.VISIBLE);

                    arrayList.clear();
                    all_posts.clear();
                    all_media.clear();
                    page = 1;
                    select_pos = 0;
                    searchPosts(page, s);
                    cat_name = (TextView) findViewById(R.id.cat_name);
                    cat_name.setText("Результаты поиска по запросу \"" + s + "\"");
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Введите не менее 4 символов!", Toast.LENGTH_LONG);
                    toast.show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}