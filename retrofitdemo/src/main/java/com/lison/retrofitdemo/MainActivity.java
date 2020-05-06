package com.lison.retrofitdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lison.retrofitdemo.net.DataCallBack;
import com.lison.retrofitdemo.net.NetManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private RecyclerView recyclerView;
    private List<Repo> mdatas = null;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mdatas = new ArrayList<>();
        recyclerView = ((RecyclerView) findViewById(R.id.recyclerView));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerView.Adapter() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_git, parent, false);
                return new RecyclerView.ViewHolder(view) {
                    @Override
                    public String toString() {
                        return super.toString();
                    }
                };
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                ((TextView) holder.itemView.findViewById(R.id.tvShowgit)).setText(mdatas.get(position).getName());
            }

            @Override
            public int getItemCount() {
                return mdatas.size();
            }
        };
        recyclerView.setAdapter(adapter);
        findViewById(R.id.getNetMsg).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                NetManager.getInstance().listRepos("liyaxun520", new DataCallBack() {
                    @Override
                    public void callBackData(Object data) {
                        if (data instanceof List) {
                            List<Repo> repos = (List<Repo>) data;
                            mdatas.addAll(repos);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    adapter.notifyDataSetChanged();
                                }
                            });
                        }
                    }

                    @Override
                    public void callError(Throwable t) {

                    }
                });
            }
        }).start();

    }
}
