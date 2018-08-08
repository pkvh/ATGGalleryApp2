package com.shilpa.ATGGalleryApp.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.shilpa.ATGGalleryApp.R;
import com.shilpa.ATGGalleryApp.adapters.GalleryRecyclerAdapter;
import com.shilpa.ATGGalleryApp.adapters.GridSpacingItemDecoration;
import com.shilpa.ATGGalleryApp.adapters.SpacesItemDecoration;
import com.shilpa.ATGGalleryApp.base.activty.BaseActivity;
import com.shilpa.ATGGalleryApp.home.HomePresenter;
import com.shilpa.ATGGalleryApp.home.HomePresenterImpl;
import com.shilpa.ATGGalleryApp.home.HomeView;
import com.shilpa.ATGGalleryApp.model.Photo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, HomeView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.recycler_view)
    RecyclerView recycleView;
    HomePresenter homePresenter;
    @BindView(R.id.ed1)
    EditText serchText;
    @BindView(R.id.id1)
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        homePresenter = new HomePresenterImpl(this);
        showProgress();
        homePresenter.loadImages();

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.photos) {
            // Handle the action
            relativeLayout.setVisibility(View.GONE);
            showProgress();
            homePresenter.loadImages();


        }

        if (id == R.id.search) {
            // Handle the action
            relativeLayout.setVisibility(View.VISIBLE);

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onSearchClicked(View v) {


        if (serchText.getText().toString().isEmpty()) {
            showToast("Please Enter Search Data");
        } else {
            showProgress();
            homePresenter.searchImage(serchText.getText().toString());
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onRequestFailure(String message) {
        hideProgress();
    }

    @Override
    public void onRequestSuccess() {

    }

    @Override
    public void onRequestSuccess(ArrayList<Photo> photos) {
        if (photos.size() == 0) {
            showToast("No Photos Found!");
            GalleryRecyclerAdapter mAdapter = new GalleryRecyclerAdapter(photos, this, getApplicationContext());
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
            gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recycleView.setLayoutManager(gridLayoutManager);
            recycleView.setItemAnimator(new DefaultItemAnimator());
            recycleView.setAdapter(mAdapter);
            recycleView.addItemDecoration(new SpacesItemDecoration(8));
            hideProgress();
        } else {

            GalleryRecyclerAdapter mAdapter = new GalleryRecyclerAdapter(photos, this, getApplicationContext());
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
            gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recycleView.setLayoutManager(gridLayoutManager);
            recycleView.setItemAnimator(new DefaultItemAnimator());
            recycleView.setAdapter(mAdapter);
            recycleView.addItemDecoration(new SpacesItemDecoration(8));
            hideProgress();
        }

    }


}
