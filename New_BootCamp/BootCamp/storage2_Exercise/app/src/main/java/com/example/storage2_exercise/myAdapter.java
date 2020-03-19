package com.example.storage2_exercise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

class myAdapter extends RecyclerView.Adapter<myAdapter.EmViewHolder> {
    private static final String TAG = "myAdapter";
    private  ListItemClickListener listener;
    private List<Employee> employees = new ArrayList<>();

    myAdapter(ListItemClickListener listener){
        this.listener = listener;
    }
    @NonNull
    @Override
    public EmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.mylayout,parent,false);
        return new EmViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull EmViewHolder holder, int position) {
        Employee m = employees.get(position);
        holder.bindData(m,listener,position);

    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    void setList(List<Employee> employees){
        this.employees =employees;
    }

    static class EmViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView phone;
        private TextView address;
        private ImageButton delete;
        private ImageButton update;

         EmViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            phone = itemView.findViewById(R.id.phone);
            address = itemView.findViewById(R.id.address);
            delete = itemView.findViewById(R.id.delete);
            update = itemView.findViewById(R.id.update);

        }


        /**
         * bindData to the Recycler view
         */


        public void bindData(final Employee employee, final ListItemClickListener listener,final int position) {

            name.setText("Employee Name: " + employee.getName());
            address.setText("Employee Address" + employee.getAddress());
            phone.setText("Employee Phone" + employee.getPhone());

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onDelete(employee,position);
                }
            });

            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onEdit(employee,position);
                }
            });


        }
    }
}
