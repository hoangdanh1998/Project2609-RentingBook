package com.danhnh.project2609.fragment;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danhnh.project2609.R;
import com.danhnh.project2609.adapter.book_list.RecyclerViewAdapter;
import com.danhnh.project2609.adapter.ads.AdsImageAdapter;
import com.danhnh.project2609.model.ads.Advertisement;
import com.danhnh.project2609.model.book.Book;
import com.danhnh.project2609.model.SectionBook;
import com.danhnh.project2609.model.book.BookRenting;
import com.danhnh.project2609.model.book.bookdetails.Cover;

import java.util.ArrayList;
import java.util.Date;


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


        bookAdapter = new RecyclerViewAdapter(this, allOfBook);
        final RecyclerView my_recycler_view = v.findViewById((R.id.Recycler_View));
        my_recycler_view.setHasFixedSize(true);
        my_recycler_view.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        my_recycler_view.setAdapter(bookAdapter);

        adsImageAdapter = new AdsImageAdapter(allAds, this.getContext());
        final RecyclerView adsSlider = v.findViewById(R.id.adsSlider);
        adsSlider.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        adsSlider.setAdapter(adsImageAdapter);

        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(adsSlider);

//        v.findViewById(R.id.fgmHome).set(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);
//                imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
//                return true;
//            }
//        });

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                int nextView = 0;
                int countItem = adsImageAdapter.getItemCount();
                while (true) {
                    try {
                        if (nextView < countItem - 1) {
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
        ArrayList<BookRenting> lsBook = new ArrayList<>();
        ArrayList<BookRenting> lsBook1 = new ArrayList<>();
        ArrayList<BookRenting> lsBook2 = new ArrayList<>();
        ArrayList<BookRenting> lsBook3 = new ArrayList<>();


        Book book1, book2, book3, book4, book5;
        book1 = new Book();
        book1.setTitle("Nuôi con");
        book2 = new Book();
        book2.setTitle("Đắc nhân tâm");
        book3 = new Book();
        book3.setTitle("Book3");
        book4 = new Book();
        book4.setTitle("Book4");
        book5 = new Book();
        book5.setTitle("Book5");
        ArrayList<String> imgList = new ArrayList<String>();
        imgList.add("https://cdn0.fahasa.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/i/m/image_145265.jpg");
        ArrayList<String> imgList1 = new ArrayList<String>();
        imgList1.add("https://cdn0.fahasa.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/d/a/dac_nhan_tam_kho_lon_tai_ban_2016_1_2018_07_05_14_30_27.jpg");

        lsBook.add(new BookRenting("123456789", book1, 120000, 20, imgList, 10, 3, 20, 200, Cover.Hardcover));
        lsBook.add(new BookRenting("123456789", book2, 110000, 20, imgList1, 10, 3, 20, 200, Cover.Pagerback));
        lsBook.add(new BookRenting("123456789", book3, 130000, 20, imgList, 10, 3, 20, 200, Cover.Hardcover));
        lsBook.add(new BookRenting("123456789", book4, 140000, 20, imgList1, 10, 3, 20, 200, Cover.Hardcover));
        lsBook.add(new BookRenting("123456789", book5, 150000, 20, imgList, 10, 3, 20, 200, Cover.Hardcover));

        SectionBook listBook = new SectionBook("Romatic1", lsBook);
        SectionBook listBook1 = new SectionBook("Romatic", lsBook1);
        SectionBook listBook2 = new SectionBook("Romatic", lsBook2);
        SectionBook listBook3 = new SectionBook("Romatic", lsBook3);

        allOfBook.add(listBook);
        allOfBook.add(listBook1);
        allOfBook.add(listBook2);
        allOfBook.add(listBook3);

    }

    public void FakeDataAds() {
        allAds.add(new Advertisement(R.drawable.ic_home_1, "Ads1"));
        allAds.add(new Advertisement(R.drawable.ic_notification_ic, "Ads2"));
        allAds.add(new Advertisement(R.drawable.ic_person_ic, "Ads3"));
        allAds.add(new Advertisement(R.drawable.ic_dashboard_black_24dp, "Ads4"));

    }


    @Override
    public void onBackStackChanged() {
        if (getActivity().getSupportFragmentManager().getBackStackEntryCount() <= 1) {
//            ((MainActivity)getActivity()).hideUpButton();

        }
    }
}
