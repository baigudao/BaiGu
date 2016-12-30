package com.jackie.baigu.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.jackie.baigu.R;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.BitmapCallback;
import com.zhy.http.okhttp.callback.FileCallBack;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/12/30.
 */
public class OKHttpActivity extends Activity implements View.OnClickListener {

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    private static final int GET = 1;
    private static final int POST = 2;
    private static final String TAG = OKHttpActivity.class.getSimpleName();
    private Button btn_get_post;
    private Button btn_get_post_ok;
    private Button btn_downLoadFile;
    private Button btn_upLoadFile;
    private Button btn_downLoadImage;
    private Button btn_downLoadListImage;
    private ProgressBar mProgressBar;
    private TextView tv_result;
    private TextView tv_title;
    private ImageView iv_image;
    private OkHttpClient client = new OkHttpClient();

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case GET:
                    tv_result.setText((String) msg.obj);
                    break;
                case POST:
                    tv_result.setText((String) msg.obj);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化视图
        initView();
        //设置点击事件
        setListener();
    }

    private void initView() {
        setContentView(R.layout.activity_okhttp);
        btn_get_post = (Button) findViewById(R.id.btn_get_post);
        btn_get_post_ok = (Button) findViewById(R.id.btn_get_post_ok);
        btn_downLoadFile = (Button) findViewById(R.id.btn_downLoadFile);
        btn_upLoadFile = (Button) findViewById(R.id.btn_upLoadFile);
        btn_downLoadImage = (Button)findViewById(R.id.btn_downLoadImage);
        btn_downLoadListImage = (Button)findViewById(R.id.btn_downLoadListImage);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        iv_image = (ImageView)findViewById(R.id.iv_image);
        tv_result = (TextView) findViewById(R.id.tv_result);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("OKHttp");
    }

    private void setListener() {
        btn_get_post.setOnClickListener(this);
        btn_get_post_ok.setOnClickListener(this);
        btn_downLoadFile.setOnClickListener(this);
        btn_upLoadFile.setOnClickListener(this);
        btn_downLoadImage.setOnClickListener(this);
        btn_downLoadListImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_get_post://get和post请求
                getDataFromPost();
                break;
            case R.id.btn_get_post_ok:
                getDataFromGetByOKHttpUtils();
                break;
            case R.id.btn_downLoadFile:
                downLoadFile();
                break;
            case R.id.btn_upLoadFile:
                multiFileUpload();
                break;
            case R.id.btn_downLoadImage:
                downLoadImage();
                break;
            case R.id.btn_downLoadListImage:
                startActivity(new Intent(OKHttpActivity.this,OKHttpListActivity.class));
                break;
        }
    }

    /**
     * 请求单张图片
     */
    private void downLoadImage() {
        tv_result.setText("");
        String url = "http://images.csdn.net/20150817/1.jpg";
        OkHttpUtils
                .get()//
                .url(url)//
                .tag(this)//
                .build()//
                .connTimeOut(20000)
                .readTimeOut(20000)
                .writeTimeOut(20000)
                .execute(new BitmapCallback()
                {
                    @Override
                    public void onError(Call call, Exception e, int id)
                    {
                        tv_result.setText("onError:" + e.getMessage());
                    }

                    @Override
                    public void onResponse(Bitmap bitmap, int id)
                    {
                        Log.e("TAG", "onResponse：complete");
                        iv_image.setImageBitmap(bitmap);
                    }
                });
    }

    /**
     * 多文件上传
     */
    public void multiFileUpload() {
        //File file = new File(Environment.getExternalStorageDirectory(), "messenger_01.png");
        File file2 = new File(Environment.getExternalStorageDirectory(), "480.mp4");
        if (!file2.exists()) {
            Toast.makeText(OKHttpActivity.this, "文件不存在，请修改文件路径", Toast.LENGTH_SHORT).show();
            return;
        }
        Map<String, String> params = new HashMap<>();
        params.put("username", "jackie");
        params.put("password", "123");

        String url = "http://169.254.163.31:8080/FileUpload/FileUploadServlet";
        OkHttpUtils.post()//
                //.addFile("mFile", "messenger_01.png", file)//
                .addFile("mFile", "dahua.mp4", file2)//
                .url(url)
                .params(params)//
                .build()//
                .execute(new MyStringCallback());
    }

    /**
     * 使用OKHttp-Utils下载大文件
     */
    private void downLoadFile() {
        String url = "http://vfx.mtime.cn/Video/2016/12/27/mp4/161227204134063682_480.mp4";
        OkHttpUtils//
                .get()//
                .url(url)//
                .build()//
                .execute(new FileCallBack(Environment.getExternalStorageDirectory().getAbsolutePath(), "480.mp4")//
                {

                    @Override
                    public void onBefore(Request request, int id) {
                        mProgressBar.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void inProgress(float progress, long total, int id) {
                        mProgressBar.setProgress((int) (100 * progress));
                        Log.e(TAG, "inProgress :" + (int) (100 * progress));
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e(TAG, "onError :" + e.getMessage());
                    }

                    @Override
                    public void onResponse(File file, int id) {
                        Log.e(TAG, "onResponse :" + file.getAbsolutePath());
                        tv_result.setText("完成下载：" + file.getAbsolutePath());
                        mProgressBar.setVisibility(View.GONE);
                    }
                });
    }

    /**
     * 使用OKHttp-Utils的GET请求
     */
    private void getDataFromGetByOKHttpUtils() {
        String url = "http://www.zhiyun-tech.com/App/Rider-M/changelog-zh.txt";
        //url="http://www.391k.com/api/xapi.ashx/info.json?key=bd_hyrzjjfb4modhj&size=10&page=1";
        url = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";
        OkHttpUtils
                .get()
                .url(url)
                .id(100)
                .build()
                .execute(new MyStringCallback());
    }

    /**
     * 使用get请求网络
     */
    private void getDataFromGet() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                String url = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";
                try {
                    String result = get(url);
                    Message message = Message.obtain();
                    message.what = GET;
                    message.obj = result;
                    handler.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    /**
     * 使用post请求网络
     */
    private void getDataFromPost() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                String url = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";
                try {
                    String result = post(url, "");
                    Message message = Message.obtain();
                    message.what = POST;
                    message.obj = result;
                    handler.sendMessage(message);
                } catch (IOException | NullPointerException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    /**
     * get请求
     *
     * @param url
     * @return
     * @throws IOException
     */
    private String get(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    /**
     * post请求
     *
     * @param url
     * @param json
     * @return
     * @throws IOException
     */
    private String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder().url(url).post(body).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public class MyStringCallback extends StringCallback {
        @Override
        public void onBefore(Request request, int id) {
            setTitle("loading...");
        }

        @Override
        public void onAfter(int id) {
            setTitle("Sample-okHttp");
        }

        @Override
        public void onError(Call call, Exception e, int id) {
            e.printStackTrace();
            tv_result.setText("onError:" + e.getMessage());
        }

        @Override
        public void onResponse(String response, int id) {
            Log.e(TAG, "onResponse：complete");
            tv_result.setText("onResponse:" + response);

            switch (id) {
                case 100:
                    Toast.makeText(OKHttpActivity.this, "http", Toast.LENGTH_SHORT).show();
                    break;
                case 101:
                    Toast.makeText(OKHttpActivity.this, "https", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

        @Override
        public void inProgress(float progress, long total, int id) {
            Log.e(TAG, "inProgress:" + progress);
            mProgressBar.setProgress((int) (100 * progress));
        }
    }
}
