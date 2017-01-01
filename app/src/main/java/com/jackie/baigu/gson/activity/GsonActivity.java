package com.jackie.baigu.gson.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jackie.baigu.R;
import com.jackie.baigu.json.entity.ShopInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/1.
 */
public class GsonActivity extends Activity implements View.OnClickListener {

    private Button btn_gson_tojavaobject;
    private Button btn_gson_tojavaolist;
    private Button btn_gson_javatojsonobject;
    private Button btn_gson_javatojsonarray;
    private TextView tv_title;
    private TextView tv_gson;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initListener();
    }

    private void initListener() {
        btn_gson_tojavaobject.setOnClickListener(this);
        btn_gson_tojavaolist.setOnClickListener(this);
        btn_gson_javatojsonobject.setOnClickListener(this);
        btn_gson_javatojsonarray.setOnClickListener(this);

    }

    private void initData() {
        tv_title.setText("Gson");
    }

    private void initView() {
        setContentView(R.layout.activity_gson);
        btn_gson_tojavaobject = (Button) findViewById(R.id.btn_gson_tojavaobject);
        btn_gson_tojavaolist = (Button) findViewById(R.id.btn_gson_tojavaolist);
        btn_gson_javatojsonobject = (Button) findViewById(R.id.btn_gson_javatojsonobject);
        btn_gson_javatojsonarray = (Button) findViewById(R.id.btn_gson_javatojsonarray);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_gson = (TextView) findViewById(R.id.tv_gson);
        tv_result = (TextView) findViewById(R.id.tv_result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_gson_tojavaobject:
                jsonToJavaObjectByGson();
                break;
            case R.id.btn_gson_tojavaolist:
                jsonToJavaListByGson();
                break;
            case R.id.btn_gson_javatojsonobject:
                javaToJsonObjectByGson();
                break;
            case R.id.btn_gson_javatojsonarray:
                javaToJsonArrayByGson();
                break;
            default:
                break;
        }
    }

    /**
     * 将Java集合转换成json数组
     */
    private void javaToJsonArrayByGson() {
        List<ShopInfo> shopInfos = new ArrayList<>();
        ShopInfo shopInfo = new ShopInfo(8, "大鱼", 441.4, "http:slfs.jpg");
        ShopInfo shopInfo1 = new ShopInfo(9, "小鱼", 21.2, "www.baidu.com");
        shopInfos.add(shopInfo);
        shopInfos.add(shopInfo1);
        Gson gson = new Gson();
        String s = gson.toJson(shopInfos);
        tv_gson.setText(shopInfos.toString());
        tv_result.setText(s);
    }

    /**
     * 将Java对象转换成json对象
     */
    private void javaToJsonObjectByGson() {
        ShopInfo shopInfo = new ShopInfo(3, "鱼翅", 88.3, "http:xxx.jpg");
        Gson gson = new Gson();
        String s = gson.toJson(shopInfo);
        tv_gson.setText(shopInfo.toString());
        tv_result.setText(s);
    }

    /**
     * 将json数组解析成Java集合
     */
    private void jsonToJavaListByGson() {
        String json = "[\n" +
                "    {\n" +
                "        \"id\": 1,\n" +
                "        \"imagePath\": \"http://192.168.10.165:8080/f1.jpg\",\n" +
                "        \"name\": \"大虾1\",\n" +
                "        \"price\": 12.3\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 2,\n" +
                "        \"imagePath\": \"http://192.168.10.165:8080/f2.jpg\",\n" +
                "        \"name\": \"大虾2\",\n" +
                "        \"price\": 12.5\n" +
                "    }\n" +
                "]";
        Gson gson = new Gson();
        List<ShopInfo> shopInfos = gson.fromJson(json, new TypeToken<List<ShopInfo>>() {
        }.getType());
        tv_gson.setText(json);
        tv_result.setText(shopInfos.toString());
    }

    /**
     * 将json对象解析成Java对象
     */
    private void jsonToJavaObjectByGson() {
        String json = "{\n" +
                "\t\"id\":2, \"name\":\"大虾\", \n" +
                "\t\"price\":12.3, \n" +
                "\t\"imagePath\":\"http://192.168.10.165:8080/L05_Server/images/f1.jpg\"\n" +
                "}\n";
        Gson gson = new Gson();
        ShopInfo shopInfo = gson.fromJson(json, ShopInfo.class);
        tv_gson.setText(json);
        tv_result.setText(shopInfo.toString());
    }

}
