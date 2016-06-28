package com.example.mahmoud.rxandroid.commentsView.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mahmoud.rxandroid.R;
import com.example.mahmoud.rxandroid.commentsView.model.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mahmoud on 6/28/16.
 */
public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder>{

    List<Comment>commentsList;

    public CommentsAdapter(){
        commentsList = new ArrayList<>();
    }
    @Override
    public CommentsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_comment_item, parent, false);

        return new CommentsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CommentsViewHolder holder, int position) {
        holder.textViewCommentName.setText(commentsList.get(position).name);
        holder.textViewCommentEmail.setText(commentsList.get(position).email);
        holder.textViewCommentBody.setText(commentsList.get(position).body);
    }

    @Override
    public int getItemCount() {
        return commentsList.size();
    }

    public class CommentsViewHolder extends RecyclerView.ViewHolder {
        TextView textViewCommentName, textViewCommentEmail, textViewCommentBody;
        public CommentsViewHolder(View view) {
            super(view);
            textViewCommentBody = (TextView)view.findViewById(R.id.textViewCommentBody);
            textViewCommentEmail = (TextView)view.findViewById(R.id.textViewCommentEmail);
            textViewCommentName = (TextView)view.findViewById(R.id.textViewCommentName);
        }
    }

    public void addItems(List<Comment>commentList){
        commentsList.addAll(commentList);
        notifyDataSetChanged();
    }
}
