package com.danhnh.project2609;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.danhnh.project2609.adapter.cart.CartAdapter;
import com.danhnh.project2609.model.Book;

import java.util.ArrayList;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment  {
    ArrayList<Book> lsBook;
    CartAdapter cartAdapter;

    public CartFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        lsBook = new ArrayList<>();
        FakeCart();
        cartAdapter = new CartAdapter(lsBook, this);
        final RecyclerView cartRecycle = view.findViewById(R.id.CartBook);
        cartRecycle.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayout.VERTICAL, false));
        cartRecycle.setAdapter(cartAdapter);

        return view;
    }

    private void FakeCart() {
        lsBook = new ArrayList<Book>();

        lsBook.add(new Book("isbn1", "Nanh Trang", "Description1", new ArrayList<String>(), "English", new Date(), "Romantic", new ArrayList<String>(), 123, R.drawable.nanhbac));
        lsBook.add(new Book("isbn1", "Titile2", "Description1", new ArrayList<String>(), "English", new Date(), "Romantic", new ArrayList<String>(), 123, R.drawable.ic_person_ic));
        lsBook.add(new Book("isbn1", "Titile3", "Description1", new ArrayList<String>(), "English", new Date(), "Romantic", new ArrayList<String>(), 12, R.drawable.ic_notification_ic));
        lsBook.add(new Book("isbn1", "Titile4", "Description1", new ArrayList<String>(), "English", new Date(), "Romantic", new ArrayList<String>(), 12, R.drawable.ic_person_ic));
        lsBook.add(new Book("isbn1", "Titile5", "Description1", new ArrayList<String>(), "English", new Date(), "Romantic", new ArrayList<String>(), 12, R.drawable.ic_notification_ic));
        lsBook.add(new Book("isbn1", "Titile6", "Description1", new ArrayList<String>(), "English", new Date(), "Romantic", new ArrayList<String>(), 12, R.drawable.ic_person_ic));

    }

}
