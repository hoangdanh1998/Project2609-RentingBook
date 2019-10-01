package com.danhnh.project2609.adapter.book_list;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


import com.danhnh.project2609.R;
import com.danhnh.project2609.fragment.DetailFragment;
import com.danhnh.project2609.model.book.BookRenting;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.BookHolder> {
    private ArrayList<BookRenting> BooksList;
    private Fragment fragment;

    public SectionListDataAdapter(Fragment fragment, ArrayList<BookRenting> BooksList) {
        this.BooksList = BooksList;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public BookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_book, null);
        BookHolder mh = new BookHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(@NonNull BookHolder bookHolder, int position) {

        BookRenting itemBook = BooksList.get(position);
        bookHolder.tvTitle.setText(itemBook.getBook().getTitle());
        System.out.println("Src: "+itemBook.getImageURLs().get(0));
        try {
            bookHolder.itemImage.setImageDrawable(Drawable.createFromStream((InputStream) new URL(itemBook.getImageURLs().get(0)).getContent(), null));
        } catch (IOException e) {
            e.printStackTrace();
        }
        bookHolder.txtPrice.setText(itemBook.getPrice()+" VND");

    }

    @Override
    public int getItemCount() {
        return (null != BooksList ? BooksList.size() : 0);
    }

    public class BookHolder extends RecyclerView.ViewHolder {
        protected TextView tvTitle;
        protected Button btnShowDetail;
        protected ImageView itemImage;
        protected TextView txtPrice;


        public BookHolder(View view) {
            super(view);
            this.tvTitle =  view.findViewById(R.id.tvTitle);
            this.itemImage =  view.findViewById(R.id.itemImage);
            this.btnShowDetail = view.findViewById(R.id.btnShowDetail);
            this.txtPrice = view.findViewById(R.id.txtPrice);

            itemImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment fragmentDetail = new DetailFragment();
                    fragment.getActivity()
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fgmHome,fragmentDetail)
                            .addToBackStack(null)
                            .commit();
                }
            });
            btnShowDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment fragmentDetail = new DetailFragment();
                    fragment.getActivity()
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fgmHome,fragmentDetail)
                            .addToBackStack(null)
                            .commit();
                }
            });

        }
    }
}
