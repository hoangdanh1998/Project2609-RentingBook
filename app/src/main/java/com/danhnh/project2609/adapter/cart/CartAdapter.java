package com.danhnh.project2609.adapter.cart;

import android.app.Dialog;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.danhnh.project2609.R;
import com.danhnh.project2609.model.Book;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ItemHolder> {
    private ArrayList<Book> listBookInCart;
    private Fragment fragment;

    public CartAdapter(ArrayList<Book> listBookInCart, Fragment fragment) {
        this.listBookInCart = listBookInCart;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_cart_item, null);
        ItemHolder ih = new ItemHolder(view);
        return ih;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        Book myBook = listBookInCart.get(position);
        holder.txtTitle.setText(myBook.getTitle());
        holder.txtPrice.setText(myBook.getPrice() + " đ");
        holder.txtQuantity.setText(1 + "");
        holder.imgBook.setImageResource(myBook.getImage());

    }

    @Override
    public int getItemCount() {
        return listBookInCart.size();
    }



    public class ItemHolder extends RecyclerView.ViewHolder implements TextWatcher {
        protected ImageView imgBook;
        protected TextView txtPrice;
        protected TextView txtTitle;
        protected Button btnAdd, btnSub;
        protected TextView txtQuantity;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            this.imgBook = itemView.findViewById(R.id.imgBook);
            this.txtPrice = itemView.findViewById(R.id.txtPrice);
            this.txtQuantity = itemView.findViewById(R.id.txtQuantity);
            this.txtTitle = itemView.findViewById(R.id.txtTitle);
            this.btnAdd = itemView.findViewById(R.id.btnAdd);
            this.btnSub = itemView.findViewById(R.id.btnSub);

            txtQuantity.addTextChangedListener(this);
            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int quantity = Integer.parseInt(txtQuantity.getText() + "");
                    if (quantity < 15) {
                        quantity++;
//                        TextView total = fragment.getActivity().findViewById(R.id.totalPrice);
//                        float totalPrice = Float.parseFloat(total.getText()+"");
//                        System.out.println(totalPrice+ Float.parseFloat(txtPrice.getText()+""));
//                        total.setText(totalPrice+"");
                        txtQuantity.setText(quantity+"");

                    } else {
                        //Hiện thông báo không thể thuê nhiều hơn 15q
                    }
                    txtQuantity.setText(quantity+"");
                }
            });
            btnSub.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int quantity = Integer.parseInt(txtQuantity.getText() + "");
                    if (quantity > 1) {
                        quantity--;
                    }
                    txtQuantity.setText(quantity+"");
                }
            });
        }
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            
        }
    }

}
