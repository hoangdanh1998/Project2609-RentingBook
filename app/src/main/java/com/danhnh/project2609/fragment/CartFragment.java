package com.danhnh.project2609.fragment;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.danhnh.project2609.R;
import com.danhnh.project2609.adapter.cart.CartAdapter;
import com.danhnh.project2609.model.book.Book;
import com.danhnh.project2609.model.book.BookRenting;
import com.danhnh.project2609.model.book.bookdetails.Cover;

import java.util.ArrayList;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment  {
    ArrayList<BookRenting> lsBook;
    CartAdapter cartAdapter;

    public CartFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FakeCart();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        lsBook = new ArrayList<>();
        cartAdapter = new CartAdapter(lsBook, this);
        final RecyclerView cartRecycle = view.findViewById(R.id.CartBook);
        cartRecycle.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayout.VERTICAL, false));
        cartRecycle.setAdapter(cartAdapter);

        return view;
    }

        private void FakeCart() {
            lsBook = new ArrayList<BookRenting>();

            Book book1, book2, book3, book4, book5;
            book1 = new Book(); book1.setTitle("Book1");
            book2 = new Book(); book1.setTitle("Book2");
            book3 = new Book(); book1.setTitle("Book3");
            book4 = new Book(); book1.setTitle("Book4");
            book5 = new Book(); book1.setTitle("Book5");

            ArrayList<String> imgList = new ArrayList<String>();
            imgList.add("https://cdn0.fahasa.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/i/m/image_145265.jpg");
            ArrayList<String> imgList1 = new ArrayList<String>();
            imgList1.add("https://cdn0.fahasa.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/d/a/dac_nhan_tam_kho_lon_tai_ban_2016_1_2018_07_05_14_30_27.jpg");
        lsBook.add(new BookRenting("123456789",book1, 120000,20,imgList,10,3,20,200, Cover.Hardcover));
        lsBook.add(new BookRenting("123456789",book2, 110000,20,imgList1,10,3,20,200, Cover.Pagerback));
        lsBook.add(new BookRenting("123456789",book3, 130000,20,imgList,10,3,20,200, Cover.Hardcover));
        lsBook.add(new BookRenting("123456789",book4, 140000,20,imgList1,10,3,20,200, Cover.Hardcover));
        lsBook.add(new BookRenting("123456789",book5, 150000,20,imgList,10,3,20,200, Cover.Hardcover));


    }

}
