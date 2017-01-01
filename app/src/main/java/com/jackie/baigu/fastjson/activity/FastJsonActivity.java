package com.jackie.baigu.fastjson.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.jackie.baigu.R;
import com.jackie.baigu.json.entity.ShopInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/1.
 */
public class FastJsonActivity extends Activity implements View.OnClickListener {

    private Button btn_fastjson_tojavaobject;
    private Button btn_fastjson_tojavaolist;
    private Button btn_fastjson_javatojsonobject;
    private Button btn_fastjson_javatojsonarray;
    private TextView tv_title;
    private TextView tv_fastjson;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initListener();
    }

    private void initListener() {
        btn_fastjson_tojavaobject.setOnClickListener(this);
        btn_fastjson_tojavaolist.setOnClickListener(this);
        btn_fastjson_javatojsonobject.setOnClickListener(this);
        btn_fastjson_javatojsonarray.setOnClickListener(this);

    }

    private void initData() {
        tv_title.setText("FastJson");
    }

    private void initView() {
        setContentView(R.layout.activity_fastjson);
        btn_fastjson_tojavaobject = (Button) findViewById(R.id.btn_fastjson_tojavaobject);
        btn_fastjson_tojavaolist = (Button) findViewById(R.id.btn_fastjson_tojavaolist);
        btn_fastjson_javatojsonobject = (Button) findViewById(R.id.btn_fastjson_javatojsonobject);
        btn_fastjson_javatojsonarray = (Button) findViewById(R.id.btn_fastjson_javatojsonarray);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_fastjson = (TextView) findViewById(R.id.tv_fastjson);
        tv_result = (TextView) findViewById(R.id.tv_result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_fastjson_tojavaobject:
                jsonToJavaObjectByFastJson();
                break;
            case R.id.btn_fastjson_tojavaolist:
                jsonToJavaListByFastJson();
                break;
            case R.id.btn_fastjson_javatojsonobject:
                javaToJsonObjectByFastJson();
                break;
            case R.id.btn_fastjson_javatojsonarray:
                javaToJsonArrayByFastJson();
                break;
            default:
                break;
        }
    }

    /**
     * 将Java集合转换成json数组
     */
    private void javaToJsonArrayByFastJson() {
        List<ShopInfo> shopInfos = new ArrayList<>();
        ShopInfo shopInfo = new ShopInfo(8, "大鱼", 441.4, "http:slfs.jpg");
        ShopInfo shopInfo1 = new ShopInfo(9, "小鱼", 21.2, "www.baidu.com");
        shopInfos.add(shopInfo);
        shopInfos.add(shopInfo1);
        String string = JSON.toJSONString(shopInfos);
        tv_fastjson.setText(shopInfos.toString());
        tv_result.setText(string);
    }

    /**
     * 将java对象转换成json对象
     */
    private void javaToJsonObjectByFastJson() {
        ShopInfo shopInfo = new ShopInfo(5, "海带", 12.3, "http://alds.jpg");
        String string = JSON.toJSONString(shopInfo);
        tv_fastjson.setText(shopInfo.toString());
        tv_result.setText(string);
    }

    /**
     * 将json数组转换成Java集合
     */
    private void jsonToJavaListByFastJson() {
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
        List<ShopInfo> shopInfos = JSON.parseArray(json, ShopInfo.class);
        tv_fastjson.setText(json);
        tv_result.setText(shopInfos.toString());
    }

    /**
     * 将json对象转换成Java对象
     */
    private void jsonToJavaObjectByFastJson() {
        String json = "{\n" +
                "\t\"id\":2, \"name\":\"大虾\", \n" +
                "\t\"price\":12.3, \n" +
                "\t\"imagePath\":\"http://192.168.10.165:8080/L05_Server/images/f1.jpg\"\n" +
                "}\n";
        ShopInfo shopInfo = JSON.parseObject(json, ShopInfo.class);
        tv_fastjson.setText(json);
        tv_result.setText(shopInfo.toString());
    }

}
