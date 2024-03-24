package com.example.myapplication;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.RVViewHolderClass> {

  /*  private final Context context;*/
    ArrayList<AddRawMaterialDetails> addRawMaterialDetailsArrayList;
    ImageView imageView;
   /* private final RecyclerViewInterface recyclerViewInterface;*/

   public RVAdapter(ArrayList<AddRawMaterialDetails> addRawMaterialDetailsArrayList){
        this.addRawMaterialDetailsArrayList=addRawMaterialDetailsArrayList;
        /*this.recyclerViewInterface=recyclerViewInterface;*/
    }
/*public RVAdapter(Context context,ArrayList<AddRawMaterialDetails> addRawMaterialDetailsArrayList,
                 RecyclerViewInterface recyclerViewInterface){
    this.context=context;
    this.addRawMaterialDetailsArrayList=addRawMaterialDetailsArrayList;
    this.recyclerViewInterface=recyclerViewInterface;
}*/

    public RVAdapter(ArrayList<AddRawMaterialDetails> allImagesData, ViewRawMaterialActivity viewRawMaterialActivity) {
    }


    @NonNull
    @Override
    public RVViewHolderClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
/*LayoutInflater inflater=LayoutInflater.from(context);
View view=inflater.inflate(R.layout.single_row,viewGroup,false);*/
        return new RVViewHolderClass(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_single_row,viewGroup,false));
        /*return new RVAdapter.RVViewHolderClass(view,recyclerViewInterface);*/
    }

    @Override
    public void onBindViewHolder(@NonNull RVViewHolderClass rvViewHolderClass, int i) {

        AddRawMaterialDetails addRawMaterialDetails=addRawMaterialDetailsArrayList.get(i);
        rvViewHolderClass.rawMaterialNameTV.setText(addRawMaterialDetails.getRawmaterialname());
        rvViewHolderClass.priceTV.setText(addRawMaterialDetails.getPrice());
        rvViewHolderClass.quantityTV.setText(addRawMaterialDetails.getQuantity());
        rvViewHolderClass.imageTV.setImageBitmap(addRawMaterialDetails.getImage());



    }

    @Override
    public int getItemCount() {
        return addRawMaterialDetailsArrayList.size();
    }

   /* @Override
    public void onItemClick(int position) {

       Intent intent=new Intent(RVAdapter.this,ProductDetailsActivity.class);
       intent.putExtra("Product Name",addRawMaterialDetailsArrayList.get(position).getRawmaterialname());
        intent.putExtra("Price",addRawMaterialDetailsArrayList.get(position).getPrice());
        intent.putExtra("Quantity",addRawMaterialDetailsArrayList.get(position).getQuantity());
    }*/

    public static class RVViewHolderClass extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView rawMaterialNameTV,priceTV,quantityTV;
        ImageView imageTV;

        public RVViewHolderClass(@NotNull View itemView){
            super(itemView);
            rawMaterialNameTV=itemView.findViewById(R.id.sr_imageDetailsTV);
            priceTV=itemView.findViewById(R.id.sr_priceTV);
            quantityTV=itemView.findViewById(R.id.sr_quantityTV);
            imageTV=itemView.findViewById(R.id.sr_imageTV);
            itemView.setOnClickListener(this);

            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(imageTV !=null){
                        int i=getAdapterPosition();
                        if(i!=RecyclerView.NO_POSITION){
                            imageTV.onItemClick(i);
                        }

                    }
                }
            });*/
        }



        @Override
        public void onClick(View view) {
            int i =getAdapterPosition();
            if(i ==0)
            {

                Intent intent=new Intent(itemView.getContext(),PaymentActivity.class);
                itemView.getContext().startActivity(intent);
               /* intent.putExtra("rawMaterialNameTV", i);
                intent.putExtra("priceTV",i);*/
            }
        }
    }
}
