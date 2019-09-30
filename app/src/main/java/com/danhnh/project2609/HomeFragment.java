package com.danhnh.project2609;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toolbar;

import com.danhnh.project2609.adapter.book_list.RecyclerViewAdapter;
import com.danhnh.project2609.adapter.ads.AdsImageAdapter;
import com.danhnh.project2609.model.Advertisement;
import com.danhnh.project2609.model.Book;
import com.danhnh.project2609.model.SectionBook;

import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import static android.content.Context.INPUT_METHOD_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements FragmentManager.OnBackStackChangedListener {
    private ArrayList<SectionBook> allOfBook;
    private ArrayList<Advertisement> allAds;
    private AdsImageAdapter adsImageAdapter;
    private RecyclerViewAdapter bookAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);


        bookAdapter = new RecyclerViewAdapter(getActivity(), allOfBook);
        final RecyclerView my_recycler_view = v.findViewById((R.id.Recycler_View));
        my_recycler_view.setHasFixedSize(true);
        my_recycler_view.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        my_recycler_view.setAdapter(bookAdapter);

        adsImageAdapter = new AdsImageAdapter(allAds,this.getContext());
        final RecyclerView adsSlider = v.findViewById(R.id.adsSlider);
        adsSlider.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        adsSlider.setAdapter(adsImageAdapter);

        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(adsSlider);

        v.findViewById(R.id.fgmHome).set(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
                return true;
            }
        });

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                int nextView = 0;
                int countItem = adsImageAdapter.getItemCount();
                while (true){
                    try {
                        if (nextView < countItem-1){
                           nextView++;
                        } else {
                            nextView = 0;
                        }
                        Thread.sleep(10000);
                        adsSlider.smoothScrollToPosition(nextView);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        thread.start();

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        allOfBook = new ArrayList<>();
        allAds = new ArrayList<>();

        FakeDataAds();
        FakeDataBook();



//        getActivity().getSupportFragmentManager().addOnBackStackChangedListener(this);

        //        circleIndicator = findViewById(R.id.circle);
//        circleIndicator.setViewPager(viewPager);

    }

    public void FakeDataBook() {
        ArrayList<Book> lsBook = new ArrayList<Book>();
        ArrayList<Book> lsBook1 = new ArrayList<Book>();
        ArrayList<Book> lsBook2 = new ArrayList<Book>();
        ArrayList<Book> lsBook3 = new ArrayList<Book>();


        lsBook.add(new Book("isbn1", "Nanh Trang", "Description1", new ArrayList<String>(), "English", new Date(), "Romantic", new ArrayList<String>(), 123, R.drawable.nanhbac));
        lsBook.add(new Book("isbn1", "Titile2", "Description1", new ArrayList<String>(), "English", new Date(), "Romantic", new ArrayList<String>(), 123, R.drawable.ic_person_ic));
        lsBook.add(new Book("isbn1", "Titile3", "Description1", new ArrayList<String>(), "English", new Date(), "Romantic", new ArrayList<String>(), 12, R.drawable.ic_notification_ic));
        lsBook.add(new Book("isbn1", "Titile4", "Description1", new ArrayList<String>(), "English", new Date(), "Romantic", new ArrayList<String>(), 12, R.drawable.ic_person_ic));
        lsBook.add(new Book("isbn1", "Titile5", "Description1", new ArrayList<String>(), "English", new Date(), "Romantic", new ArrayList<String>(), 12, R.drawable.ic_notification_ic));
        lsBook.add(new Book("isbn1", "Titile6", "Description1", new ArrayList<String>(), "English", new Date(), "Romantic", new ArrayList<String>(), 12, R.drawable.ic_person_ic));

        SectionBook listBook = new SectionBook("Romatic1", lsBook);

        lsBook1.add(new Book("isbn1", "Titilel1", "Description1", new ArrayList<String>(), "English", new Date(), "Romantic", new ArrayList<String>(), 12, R.drawable.ic_notification_ic));
        lsBook1.add(new Book("isbn1", "Titile22", "Description1", new ArrayList<String>(), "English", new Date(), "Romantic", new ArrayList<String>(), 12, R.drawable.ic_person_ic));
        lsBook1.add(new Book("isbn1", "Titile33", "Description1", new ArrayList<String>(), "English", new Date(), "Romantic", new ArrayList<String>(), 12, R.drawable.ic_notification_ic));
        lsBook1.add(new Book("isbn1", "Titile44", "Description1", new ArrayList<String>(), "English", new Date(), "Romantic", new ArrayList<String>(), 12, R.drawable.ic_person_ic));
        lsBook1.add(new Book("isbn1", "Titile55", "Description1", new ArrayList<String>(), "English", new Date(), "Romantic", new ArrayList<String>(), 12, R.drawable.ic_notification_ic));
        lsBook1.add(new Book("isbn1", "Titile66", "Description1", new ArrayList<String>(), "English", new Date(), "Romantic", new ArrayList<String>(), 12, R.drawable.ic_person_ic));

        SectionBook listBook1 = new SectionBook("Romatic", lsBook1);
        lsBook2.add(new Book("isbn1", "Titilel2", "Description1", new ArrayList<String>(), "English", new Date(), "Romantic", new ArrayList<String>(), 12, R.drawable.ic_person_ic));
        lsBook2.add(new Book("isbn1", "Titile23", "Description1", new ArrayList<String>(), "English", new Date(), "Romantic", new ArrayList<String>(), 12, R.drawable.ic_notification_ic));
        lsBook2.add(new Book("isbn1", "Titile34", "Description1", new ArrayList<String>(), "English", new Date(), "Romantic", new ArrayList<String>(), 12, R.drawable.ic_person_ic));
        lsBook2.add(new Book("isbn1", "Titile45", "Description1", new ArrayList<String>(), "English", new Date(), "Romantic", new ArrayList<String>(), 12, R.drawable.ic_notification_ic));
        lsBook2.add(new Book("isbn1", "Titile56", "Description1", new ArrayList<String>(), "English", new Date(), "Romantic", new ArrayList<String>(), 12, R.drawable.ic_person_ic));
        lsBook2.add(new Book("isbn1", "Titile67", "Description1", new ArrayList<String>(), "English", new Date(), "Romantic", new ArrayList<String>(), 12, R.drawable.ic_notification_ic));

        SectionBook listBook2 = new SectionBook("Romatic", lsBook2);

        lsBook3.add(new Book("isbn1", "Titilel2", "Description1", new ArrayList<String>(), "English", new Date(), "Romantic", new ArrayList<String>(), 12, R.drawable.ic_person_ic));
        lsBook3.add(new Book("isbn1", "Titile23", "Description1", new ArrayList<String>(), "English", new Date(), "Romantic", new ArrayList<String>(), 12, R.drawable.ic_notification_ic));
        lsBook3.add(new Book("isbn1", "Titile34", "Description1", new ArrayList<String>(), "English", new Date(), "Romantic", new ArrayList<String>(), 12, R.drawable.ic_person_ic));
        lsBook3.add(new Book("isbn1", "Titile45", "Description1", new ArrayList<String>(), "English", new Date(), "Romantic", new ArrayList<String>(), 12, R.drawable.ic_notification_ic));
        lsBook3.add(new Book("isbn1", "Titile56", "Description1", new ArrayList<String>(), "English", new Date(), "Romantic", new ArrayList<String>(), 12, R.drawable.ic_person_ic));
        lsBook3.add(new Book("isbn1", "Titile67", "Description1", new ArrayList<String>(), "English", new Date(), "Romantic", new ArrayList<String>(), 12, R.drawable.ic_notification_ic));

        SectionBook listBook3 = new SectionBook("Romatic", lsBook2);

        allOfBook.add(listBook);
        allOfBook.add(listBook1);
        allOfBook.add(listBook2);
        allOfBook.add(listBook3);

    }

    public void FakeDataAds() {
        allAds.add(new Advertisement(R.drawable.ic_home_1,"Ads1"));
        allAds.add(new Advertisement(R.drawable.ic_notification_ic,"Ads2"));
        allAds.add(new Advertisement(R.drawable.ic_person_ic,"Ads3"));
        allAds.add(new Advertisement(R.drawable.ic_dashboard_black_24dp,"Ads4"));

    }


    @Override
    public void onBackStackChanged() {
        if(getActivity().getSupportFragmentManager().getBackStackEntryCount() <= 1) {
//            ((MainActivity)getActivity()).hideUpButton();

        }
    }
}
