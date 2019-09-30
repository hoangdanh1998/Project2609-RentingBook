package com.danhnh.project2609.adapter.book_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.danhnh.project2609.model.Book;
import com.danhnh.project2609.R;

import java.util.ArrayList;

public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.BookHolder> {
    private ArrayList<Book> BooksList;
    private Context mContext;

    public SectionListDataAdapter(Context mContext, ArrayList<Book> BooksList) {
        this.BooksList = BooksList;
        this.mContext = mContext;
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
        Book itemBook = BooksList.get(position);
        bookHolder.tvTitle.setText(itemBook.getTitle());
        bookHolder.itemImage.setImageResource(itemBook.getImage());
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
                    Toast.makeText(v.getContext(), tvTitle.getText() , Toast.LENGTH_SHORT).show();


                }
            });
            btnShowDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), tvTitle.getText() , Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
