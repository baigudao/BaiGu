package com.jackie.baigu.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jackie.baigu.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/1/5.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {


    private final Context context;
    private ArrayList<String> datas;

    public MyRecyclerViewAdapter(Context context, ArrayList<String> datas) {
        this.context = context;
        this.datas = datas;
    }

    /**
     * 相当于于getView方法中创建View和ViewHolder
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(context, R.layout.item_recyclerview, null);
        return new ViewHolder(itemView);
    }

    /**
     * 相当于于getView绑定数据部分的代码
     * 数据和View绑定
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //根据位置得到对应的数据
        String data = datas.get(position);
        holder.tv_title.setText(data);
    }

    /**
     * 得到总条数
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return datas.size();
    }

    /**
     * 添加数据
     *
     * @param position
     * @param data
     */
    public void addData(int position, String data) {
        datas.add(position, data);
        //刷新适配器
        notifyItemInserted(position);
    }

    /**
     * 移除数据
     *
     * @param position
     */
    public void removeData(int position) {
        datas.remove(position);
        //刷新适配器
        notifyItemRemoved(position);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv_icon;
        private TextView tv_title;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);

            //点击某一条数据
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(v, datas.get(getLayoutPosition()));
                    }
                }
            });

            iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "我是图片==" + getLayoutPosition(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


    //下面这个牛x哄哄的东西很吊===>接口回传。我们通常所用的按钮点击事件，就是这样做的。button.setOnClickListener(new View.onClickListener{//重写onClick方法})
    /**
     * 利用接口回调
     * 点击RecyclerView某条的监听
     */
    public interface OnItemClickListener {
        /**
         * 当RecyclerView某个被点击的时候回调
         *
         * @param view 点击item的视图
         * @param data 点击得到的数据
         */
        void onItemClick(View view, String data);
    }

    private OnItemClickListener onItemClickListener;

    /**
     * 设置RecyclerView某个的监听
     *
     * @param onItemClickListener
     */
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}