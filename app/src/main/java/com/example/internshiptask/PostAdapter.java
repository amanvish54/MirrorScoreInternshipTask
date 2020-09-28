package com.example.internshiptask;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    List<Data> postList;
    Context context;
    Boolean isUpVote = true;

    String userId;
    String accessToken;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }



    public PostAdapter(List<Data> postList, Context context) {
        this.postList = postList;
        this.context = context;
    }

    public PostAdapter() {

    }

    public List<Data> getPostList() {
        return postList;
    }

    public void setPostList(List<Data> postList) {
        this.postList = postList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.post,parent,false);

        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Data data = postList.get(position);
        holder.userName.setText(data.getUserName());
        holder.time.setText(data.getUpdatedOn());
        holder.classBoard.setText(data.getStudentBoard()+ " " +data.getStudentClass()  );
        holder.question.setText("Q. "+ data.getText());

        setCounter(holder,data);

        holder.postHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,PostDetailsActivity.class);
                intent.putExtra("postId",String.valueOf(data.getPostId()));
                intent.putExtra("userId",String.valueOf(data.getUserId()));
                intent.putExtra("userName",data.getUserName());
                intent.putExtra("text",data.getText());
                intent.putExtra("image",data.getImage());
                intent.putExtra("createdOn",data.getCreatedOn());
                intent.putExtra("updatedOn",data.getUpdatedOn());
                intent.putExtra("studentClass",data.getStudentClass());
                intent.putExtra("studentBoard",data.getStudentBoard());
                intent.putExtra("subject",data.getSubject());
                intent.putExtra("answerCount",String.valueOf(data.getAnswerCount()));
                intent.putExtra("upvotedCount",String.valueOf(data.getUpvoteCount()));
                intent.putExtra("upvoted",data.getUpvoted());
                intent.putExtra("reportCount",String.valueOf(data.getReportCount()));
                intent.putExtra("reported",data.getReported());
                intent.putExtra("accesstoken",accessToken);
                context.startActivity(intent);


            }
        });

        holder.upVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.getUpvoted().matches("false")){
                    Call<PostResponseNew> postResponseNewCall = ApiClient.getInstance().getApi().UpVoteReport(
                            "discussionWall/postupvote?userId="+Integer.parseInt(userId),
                            "Bearer "+accessToken,
                            data.getPostId()
                    );

                    postResponseNewCall.enqueue(new Callback<PostResponseNew>() {
                        @Override
                        public void onResponse(Call<PostResponseNew> call, Response<PostResponseNew> response) {
                            holder.upvoteCount.setText("UpVotes("+(data.getUpvoteCount()+1)+")");
                            isUpVote = true;

                        }

                        @Override
                        public void onFailure(Call<PostResponseNew> call, Throwable t) {

                        }
                    });
                }
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void setCounter(ViewHolder holder, Data data) {

        holder.upvoteCount.setText("UpVotes("+data.getUpvoteCount()+")");
        holder.answersCount.setText("Answers("+data.getAnswerCount()+")");
        holder.reportsCount.setText("Reports("+data.getReportCount()+")");

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout upVote,answer,report,postHeader;
        TextView userName,time,classBoard,question,upvoteCount,answersCount,reportsCount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.post_username);
            time = itemView.findViewById(R.id.post_time);
            classBoard = itemView.findViewById(R.id.post_class_board);
            question = itemView.findViewById(R.id.post_question);
            upVote = itemView.findViewById(R.id.post_upvote);
            answer = itemView.findViewById(R.id.post_answers);
            report = itemView.findViewById(R.id.post_report);
            upvoteCount = itemView.findViewById(R.id.post_upvote_count);
            answersCount = itemView.findViewById(R.id.post_answers_count);
            reportsCount = itemView.findViewById(R.id.post_report_count);
            postHeader = itemView.findViewById(R.id.post_header);
        }
    }
}
