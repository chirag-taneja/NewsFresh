package com.example.newsfresh;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsfresh.model.News;

import java.util.ArrayList;
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private ArrayList<News> arrayList;
    public NewsItemClicked newsItemClicked;
    //step 1: initilize the data set to adaptar
    //constructor
    public CustomAdapter(ArrayList<News> newsArrayList,NewsItemClicked newsItemClicked) {
        this.arrayList=newsArrayList;
        this.newsItemClicked = newsItemClicked;
        Log.d("constructor", "CustomAdapter: const");
    }
//    public void update_news(ArrayList<News> updatedNews)
//    {
//        arrayList.clear();
//        arrayList.addAll(updatedNews);
//        notifyDataSetChanged();
//        Log.d("update_news", "update_news: ");
//    }

    // step 2: Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_news, viewGroup, false);
        Log.d("oncreate", "onCreateViewHolder: ");
        return new ViewHolder(view);

    }
    // step 3: Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        News current= arrayList.get(position);
        viewHolder.title.setText(current.getTitle());
        viewHolder.author.setText(current.getAuthor());
        Glide.with(viewHolder.itemView.getContext()).load(
                current.getImage_url()
        ).into(viewHolder.image);
    }
    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
     class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView author;
        private final ImageView image;


        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            title = (TextView) view.findViewById(R.id.title);
            author=(TextView) view.findViewById(R.id.author);
            image=(ImageView) view.findViewById(R.id.img);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int x=getAdapterPosition();
                    newsItemClicked.onItemClicked(arrayList.get(x));
                }
            });
        }


    }
}