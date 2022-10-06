package com.linex.google.assignment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.linex.google.assignment.R;
import com.linex.google.assignment.User.User;

import java.util.ArrayList;

public class usersAdapter extends RecyclerView.Adapter<usersAdapter.ViewHolder> {

    ArrayList<User> userArrayList;
    Context context;

    public usersAdapter(ArrayList<User> userArrayList, Context context) {
        this.userArrayList = userArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public usersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.staff_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull usersAdapter.ViewHolder holder, int position) {
        User user = userArrayList.get(position);
        holder.name.setText(user.getName());
        holder.dob.setText(user.getDob());
        holder.mobile.setText(user.getMobile());
        holder.address.setText(user.getAddress());
        holder.email.setText(user.getEmail());
    }



    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, dob, mobile, address, email;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textViewName);
           dob = itemView.findViewById(R.id.textViewDob);
            mobile = itemView.findViewById(R.id.textViewMobile);
          address = itemView.findViewById(R.id.textViewAddress);
            email = itemView.findViewById(R.id.textViewEmail);
        }
    }
}
