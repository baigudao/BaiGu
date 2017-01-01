package com.jackie.baigu.json.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jackie.baigu.R;
import com.jackie.baigu.json.entity.DataInfo;
import com.jackie.baigu.json.entity.FilmInfo;
import com.jackie.baigu.json.entity.ShopInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/1.
 */
public class NativeJsonPraseActivity extends Activity implements View.OnClickListener {

    private Button btn_native_tojavaobject;
    private Button btn_native_tojavaolist;
    private Button btn_native_complex;
    private Button btn_native_special;
    private TextView tv_title;
    private TextView tv_native;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initListener();
    }

    private void initListener() {
        btn_native_tojavaobject.setOnClickListener(this);
        btn_native_tojavaolist.setOnClickListener(this);
        btn_native_complex.setOnClickListener(this);
        btn_native_special.setOnClickListener(this);

    }

    private void initData() {
        tv_title.setText("NativeJsonPrase");
    }

    private void initView() {
        setContentView(R.layout.activity_native_json_prase);
        btn_native_tojavaobject = (Button) findViewById(R.id.btn_native_tojavaobject);
        btn_native_tojavaolist = (Button) findViewById(R.id.btn_native_tojavaolist);
        btn_native_complex = (Button) findViewById(R.id.btn_native_complex);
        btn_native_special = (Button) findViewById(R.id.btn_native_special);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_native = (TextView) findViewById(R.id.tv_native);
        tv_result = (TextView) findViewById(R.id.tv_result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_native_tojavaobject:
                jsonToJavaObjectByNative();
                break;
            case R.id.btn_native_tojavaolist:
                jsonToJavaListByNative();
                break;
            case R.id.btn_native_complex:
                jsonToJavaOfcomplex();
                break;
            case R.id.btn_native_special:
                jsonToJavaOfSpecial();
                break;
            default:
                break;
        }
    }

    /**
     * 特殊json数据的解析
     */
    private void jsonToJavaOfSpecial() {
        String json = "{\n" +
                "    \"code\": 0,\n" +
                "    \"list\": {\n" +
                "        \"0\": {\n" +
                "            \"aid\": \"6008965\",\n" +
                "            \"author\": \"哔哩哔哩番剧\",\n" +
                "            \"coins\": 170,\n" +
                "            \"copyright\": \"Copy\",\n" +
                "            \"create\": \"2016-08-25 21:34\"\n" +
                "        },\n" +
                "        \"1\": {\n" +
                "            \"aid\": \"6008938\",\n" +
                "            \"author\": \"哔哩哔哩番剧\",\n" +
                "            \"coins\": 404,\n" +
                "            \"copyright\": \"Copy\",\n" +
                "            \"create\": \"2016-08-25 21:33\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        // 创建封装的Java对象
        FilmInfo filmInfo = new FilmInfo();

        // 2 解析json
        try {
            JSONObject jsonObject = new JSONObject(json);

            // 第一层解析
            int code = jsonObject.optInt("code");
            JSONObject list = jsonObject.optJSONObject("list");

            // 第一层封装
            filmInfo.setCode(code);
            List<FilmInfo.FilmBean> lists = new ArrayList<>();
            filmInfo.setList(lists);

            // 第二层解析
            for (int i = 0; i < list.length(); i++) {
                JSONObject jsonObject1 = list.optJSONObject(i + "");

                if (jsonObject1 != null) {
                    String aid = jsonObject1.optString("aid");

                    String author = jsonObject1.optString("author");

                    int coins = jsonObject1.optInt("coins");

                    String copyright = jsonObject1.optString("copyright");

                    String create = jsonObject1.optString("create");

                    // 第二层数据封装
                    FilmInfo.FilmBean filmBean = new FilmInfo.FilmBean();
                    filmBean.setAid(aid);
                    filmBean.setAuthor(author);
                    filmBean.setCoins(coins);
                    filmBean.setCopyright(copyright);
                    filmBean.setCreate(create);

                    lists.add(filmBean);
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        tv_native.setText(json);
        tv_result.setText(filmInfo.toString());
    }

    /**
     * 复杂json数据的解析
     */
    private void jsonToJavaOfcomplex() {
        String json = "{\n" +
                "    \"data\": {\n" +
                "        \"count\": 5,\n" +
                "        \"items\": [\n" +
                "            {\n" +
                "                \"id\": 45,\n" +
                "                \"title\": \"坚果\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 132,\n" +
                "                \"title\": \"炒货\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 166,\n" +
                "                \"title\": \"蜜饯\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 195,\n" +
                "                \"title\": \"果脯\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 196,\n" +
                "                \"title\": \"礼盒\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"rs_code\": \"1000\",\n" +
                "    \"rs_msg\": \"success\"\n" +
                "}";
        //封装Java对象
        DataInfo dataInfo = new DataInfo();
        try {
            JSONObject jsonObject = new JSONObject(json);
            //第一层解析
            JSONObject jsonObject1 = jsonObject.optJSONObject("data");
            String string = jsonObject.optString("rs_code");
            String string1 = jsonObject.optString("rs_msg");
            //第一层封装
            dataInfo.setRs_code(string);
            dataInfo.setRs_msg(string1);
            DataInfo.DataBean dataBean = new DataInfo.DataBean();
            dataInfo.setData(dataBean);
            //第二层解析
            int count = jsonObject1.optInt("count");
            JSONArray jsonArray = jsonObject1.optJSONArray("items");
            //第二层的封装
            dataBean.setCount(count);
            List<DataInfo.DataBean.ItemsBean> items = new ArrayList<>();
            dataBean.setItems(items);
            //第三层解析
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject2 = jsonArray.optJSONObject(i);
                int id = jsonObject2.optInt("id");
                String string2 = jsonObject2.optString("title");
                //第三层封装
                DataInfo.DataBean.ItemsBean itemsBean = new DataInfo.DataBean.ItemsBean();
                itemsBean.setId(id);
                itemsBean.setTitle(string2);
                items.add(itemsBean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        tv_native.setText(json);
        tv_result.setText(dataInfo.toString());
    }

    /**
     * 将json数组解析成Java集合
     */
    private void jsonToJavaListByNative() {
        List<ShopInfo> shopInfoList = null;
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
        try {
            JSONArray jsonArray = new JSONArray(json);
            shopInfoList = new ArrayList<>();
            int i = jsonArray == null ? 0 : jsonArray.length();
            for (int j = 0; j < i; j++) {
                JSONObject jsonObjects = jsonArray.getJSONObject(j);
                if (jsonObjects != null) {
                    int id = jsonObjects.optInt("id");
                    String string = jsonObjects.optString("imagePath");
                    String string1 = jsonObjects.optString("name");
                    double price = jsonObjects.optDouble("price");
                    ShopInfo shopInfo = new ShopInfo(id, string1, price, string);
                    shopInfoList.add(shopInfo);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        tv_native.setText(json);
        tv_result.setText(shopInfoList.toString());
    }

    /**
     * 将json对象解析成Java对象
     */
    private void jsonToJavaObjectByNative() {
        ShopInfo shopInfo = null;
        String json = "{\n" +
                "\t\"id\":2, \"name\":\"大虾\", \n" +
                "\t\"price\":12.3, \n" +
                "\t\"imagePath\":\"http://192.168.10.165:8080/L05_Server/images/f1.jpg\"\n" +
                "}\n";
        try {
            JSONObject jsonObject = new JSONObject(json);
            int id = jsonObject.optInt("id");
            String string = jsonObject.optString("name");
            double price = jsonObject.optDouble("price");
            String string1 = jsonObject.optString("imagePath");

            shopInfo = new ShopInfo(id, string, price, string1);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        tv_native.setText(json);
        tv_result.setText(shopInfo.toString());
    }
}
