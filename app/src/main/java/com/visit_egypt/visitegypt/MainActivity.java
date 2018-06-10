package com.visit_egypt.visitegypt;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.visit_egypt.visitegypt.fragments.NavigationDrawerFragment;
import com.visit_egypt.visitegypt.server.Constants;
import com.visit_egypt.visitegypt.utils.MyContextWrapper;
import com.visit_egypt.visitegypt.utils.VisitEgyptApplication;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks, View.OnClickListener {
    public static final String KEY_IS_NOTIFICATION = "IsNotification";

    private NavigationDrawerFragment mNavigationDrawerFragment;
    private Fragment currentFragment;
    private int fragmentIndex = -2;

    private TextView textViewTitle;
    private TextView textViewLanguage;

    public DrawerLayout drawerLayout;

    public String userToken;

    boolean isNotification = false;

    private RelativeLayout relativeLayoutLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            int color;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                color = getResources().getColor(R.color.redTransparent, null);
            } else {
                // noinspection deprecation
                color = getResources().getColor(R.color.redTransparent);
            }
            getWindow().setStatusBarColor(color);
        }
        setContentView(R.layout.activity_main);
        setToolBar();
        replaceFragment(1);
        isNotification = getIntent().getBooleanExtra(KEY_IS_NOTIFICATION, false);


        relativeLayoutLoading = (RelativeLayout) findViewById(R.id.relativeLayoutLoading);
    }


    private void setToolBar() {

        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbar);
        View actionBarView = getLayoutInflater().inflate(R.layout.toolbar_customview, toolBar, false);

        setSupportActionBar(toolBar);

        mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);

        if (Build.VERSION.SDK_INT >= 21) {
            // Set the status bar to dark-semi-transparentish
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

            // Set paddingTop of toolbar to height of status bar.
            // Fixes statusbar covers toolbar issue
            int statusBarHeight = getStatusBarHeight();
            toolBar.setPadding(0, statusBarHeight, 0, 0);
            View view = mNavigationDrawerFragment.getView();
            assert view != null;
        }

        // Set up the drawer.
        ActionBar actionBar = mNavigationDrawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));

        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(actionBarView);
        actionBar.setDisplayShowTitleEnabled(false);


        textViewTitle = (TextView) findViewById(R.id.textViewTitle);
        textViewLanguage = (TextView) findViewById(R.id.textViewLanguage);
        textViewLanguage.setOnClickListener(this);

        if (Constants.isArabic()) {
            textViewLanguage.setText(R.string.ar);
        } else if (Constants.isFrench()) {
            textViewLanguage.setText(R.string.fr);
        } else if (Constants.isRussian()) {
            textViewLanguage.setText(R.string.ru);
        } else {
            textViewLanguage.setText(R.string.en);
        }


        setActivityTitle(R.string.news);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

//         Set up the drawer.
        mNavigationDrawerFragment.setUp(R.id.navigation_drawer, drawerLayout);
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = (int) getResources().getDimension(resourceId);
        }
        return result;
    }

    public void setActivityTitle(int title) {
        if (textViewTitle != null) {
            textViewTitle.setText(title);
        }
    }

    public void isLoading(boolean isLoading) {
        relativeLayoutLoading.setVisibility(isLoading ? View.VISIBLE : View.GONE);
    }


    // handles back press so that in exists only at home fragment
    @Override
    public void onBackPressed() {
        if (fragmentIndex == 1) {
            super.onBackPressed();
        } else {
            mNavigationDrawerFragment.selectItem(1);
        }
    }

    // handles the action to do when navigatin item is clicked
    @Override
    public void onNavigationDrawerItemSelected(int position) {
        replaceFragment(position);
    }

    //     replace fragment in the frame layout
    public void replaceFragment(int position) {
        if (position == fragmentIndex) {
            return;
        }
        // update the language_menu content by replacing fragments
//        Fragment fragment = new NewsFeedFragment();
        String[] slideMenuItems = getResources().getStringArray(R.array.slideMenuItems);
        String fragmentTitle = "";
        switch (position) {

//            case 0:
//                Intent intent = new Intent(MainActivity.this, ProfileDetailsActivity.class);
//                startActivity(intent);
//                return;
//            case 1:
//                fragment = new NewsFeedFragment();
//                fragmentTitle = slideMenuItems[0];
//                break;
//            case 2:
//                intent = new Intent(MainActivity.this, EventsActivity.class);
//                startActivity(intent);
//                break;
//            case 3:
//                fragment = new ScheduleFragment();
//                fragmentTitle = slideMenuItems[2];
//                break;
//            case 4:
//                fragment = new TopicsFragment();
//                fragmentTitle = slideMenuItems[3];
//                break;
//            case 5:
//                fragment = new MakersFragment();
//                fragmentTitle = slideMenuItems[4];
//                break;
//            case 6:
//                fragment = new SponsorsFragment();
//                fragmentTitle = slideMenuItems[5];
//                break;
//            case 7:
//                fragment = new FoodsFragment();
//                fragmentTitle = slideMenuItems[6];
//                break;
//            case 8:
//                fragment = new FavoritesFragment();
//                fragmentTitle = slideMenuItems[7];
//                break;
//            case 9:
//                fragment = new FaireInfoFragment();
//                fragmentTitle = slideMenuItems[8];
//                break;
//            case 10:
//                fragment = new NotificationsFragment();
//                fragmentTitle = slideMenuItems[9];
//                break;
//            case 11:
//                intent = new Intent(getApplicationContext(), AccountActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
//                finish();
//                new SettingsManager(this).setLoggedIn(false);
//                break;
        }

//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
//        setActivityTitle(fragmentTitle);
//
//        fragmentIndex = position;
//        currentFragment = fragment;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        //noinspection SimplifiableIfStatement
        if (mNavigationDrawerFragment.mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mNavigationDrawerFragment.mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            mNavigationDrawerFragment.mDrawerLayout.openDrawer(GravityCompat.START);
        }
        return true;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        Locale languageType = VisitEgyptApplication.getInstance().getLocale();
        super.attachBaseContext(MyContextWrapper.wrap(newBase, languageType));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (currentFragment != null) {
            currentFragment.onActivityResult(requestCode, resultCode, data);
        }
    }

    private class DialogHolder implements RadioGroup.OnCheckedChangeListener {

        private Dialog dialog;
        private RadioGroup radioGroup;


        public DialogHolder() {

            dialog = new Dialog(MainActivity.this, android.R.style.Theme_Translucent_NoTitleBar);

            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(true);

            @SuppressLint("InflateParams")
            View view = getLayoutInflater().inflate(R.layout.change_language_dialog_view, null, false);

            WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();

            dialog.getWindow().setGravity(Gravity.CENTER);
            dialog.getWindow().setDimAmount(0.3f);

            DisplayMetrics metrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(metrics);
            float windowX = metrics.widthPixels;
            lp.width = (int) (windowX * 3 / 4);
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

            dialog.setContentView(view, lp);

            radioGroup = (RadioGroup) view.findViewById(R.id.radio);
            radioGroup.clearCheck();
            radioGroup.setOnCheckedChangeListener(this);

        }

        void show() {
            dialog.show();
        }

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int selectedId) {
            if (selectedId == R.id.english) {
                textViewLanguage.setText(R.string.en);
                VisitEgyptApplication.getInstance().setLocale(VisitEgyptApplication.ENGLISH);
            } else if (selectedId == R.id.arabic) {
                textViewLanguage.setText(R.string.ar);
                VisitEgyptApplication.getInstance().setLocale(VisitEgyptApplication.ARABIC);
            } else if (selectedId == R.id.french) {
                textViewLanguage.setText(R.string.fr);
                VisitEgyptApplication.getInstance().setLocale(VisitEgyptApplication.FRENCH);
            } else if (selectedId == R.id.russian) {
                textViewLanguage.setText(R.string.ru);
                VisitEgyptApplication.getInstance().setLocale(VisitEgyptApplication.RUSSIAN);
            }
        }
    }


    @Override
    public void onClick(View v) {
        if (v == textViewLanguage) {
            new DialogHolder().show();
        }
    }
}
