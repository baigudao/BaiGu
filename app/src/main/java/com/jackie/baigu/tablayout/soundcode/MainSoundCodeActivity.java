package com.jackie.baigu.tablayout.soundcode;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.jackie.baigu.R;

/**
 * Created by Administrator on 2017/1/12.
 */
public class MainSoundCodeActivity extends Activity{


    private TextView textView;
    private String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sound_code_main_tablayout);
        textView = (TextView)findViewById(R.id.tv);
        initData();

    }

    private void initData() {
        str = "《布局》：" +
                "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<LinearLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" +
                "    xmlns:tools=\"http://schemas.android.com/tools\"\n" +
                "    android:layout_width=\"match_parent\"\n" +
                "    android:layout_height=\"match_parent\"\n" +
                "    android:orientation=\"vertical\"\n" +
                "    tools:context=\"com.jackie.baigu.tablayout.activity.TabLayoutMainActivity\">\n" +
                "\n" +
                "    <include layout=\"@layout/titlebar\" />\n" +
                "\n" +
                "    <android.support.design.widget.TabLayout\n" +
                "        android:id=\"@+id/tabLayout\"\n" +
                "        android:layout_width=\"match_parent\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        android:background=\"@android:color/holo_blue_bright\"\n" +
                "        app:tabIndicatorColor=\"@android:color/background_dark\"\n" +
                "        app:tabSelectedTextColor=\"@android:color/background_dark\"\n" +
                "        app:tabTextColor=\"@android:color/white\" />\n" +
                "\n" +
                "    <android.support.v4.view.ViewPager\n" +
                "        android:id=\"@+id/viewPager\"\n" +
                "        android:layout_width=\"match_parent\"\n" +
                "        android:layout_height=\"match_parent\" />\n" +
                "\n" +
                "</LinearLayout>" +"\n" +
                "《主界面》：import android.os.Bundle;\n" +
                "import android.support.design.widget.TabLayout;\n" +
                "import android.support.v4.app.FragmentActivity;\n" +
                "import android.support.v4.view.ViewPager;\n" +
                "import android.widget.TextView;\n" +
                "\n" +
                "import com.jackie.baigu.R;\n" +
                "import com.jackie.baigu.tablayout.adapter.ViewPagerAdapter;\n" +
                "import com.jackie.baigu.tablayout.fragment.MyFragment;\n" +
                "\n" +
                "import java.util.ArrayList;\n" +
                "\n" +
                "public class TabLayoutMainActivity extends FragmentActivity {\n" +
                "\n" +
                "    ViewPager viewPager;\n" +
                "    TextView tv_title;\n" +
                "    TabLayout tabLayout;\n" +
                "    ArrayList<MyFragment> fragments;\n" +
                "    ViewPagerAdapter adapter;\n" +
                "\n" +
                "    @Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "\n" +
                "        setContentView(R.layout.activity_tab_layout_main);\n" +
                "        viewPager = (ViewPager) findViewById(R.id.viewPager);\n" +
                "        tv_title = (TextView) findViewById(R.id.tv_title);\n" +
                "\n" +
                "        tabLayout = (TabLayout) findViewById(R.id.tabLayout);\n" +
                "        tv_title.setText(\"TabLayout的使用\");\n" +
                "\n" +
                "        //初始化数据\n" +
                "        fragments = new ArrayList<>();\n" +
                "        for (int i = 0; i < 12; i++) {\n" +
                "            fragments.add(new MyFragment(\"标题\" + i, \"内容\" + i));\n" +
                "        }\n" +
                "        //设置ViewPager的适配器\n" +
                "        adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);\n" +
                "        viewPager.setAdapter(adapter);\n" +
                "        //关联ViewPager\n" +
                "        tabLayout.setupWithViewPager(viewPager);\n" +
                "        //设置固定的\n" +
                "//        tabLayout.setTabMode(TabLayout.MODE_FIXED);\n" +
                "        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);\n" +
                "    }\n" +
                "}" +"\n" +
                "" +
                "《适配器》：" +
                "import android.support.v4.app.Fragment;\n" +
                "import android.support.v4.app.FragmentManager;\n" +
                "import android.support.v4.app.FragmentPagerAdapter;\n" +
                "\n" +
                "import com.jackie.baigu.tablayout.fragment.MyFragment;\n" +
                "\n" +
                "import java.util.ArrayList;\n" +
                "\n" +
                "/**\n" +
                " * 作用：xxxx\n" +
                " */\n" +
                "public class ViewPagerAdapter extends FragmentPagerAdapter {\n" +
                "\n" +
                "    private final ArrayList<MyFragment> fragments;\n" +
                "\n" +
                "    public ViewPagerAdapter(FragmentManager fm, ArrayList<MyFragment> fragments) {\n" +
                "        super(fm);\n" +
                "        this.fragments = fragments;\n" +
                "    }\n" +
                "\n" +
                "    /**\n" +
                "     * 根据位置返回对应的Fragment\n" +
                "     *\n" +
                "     * @param position\n" +
                "     * @return\n" +
                "     */\n" +
                "    @Override\n" +
                "    public Fragment getItem(int position) {\n" +
                "        return fragments.get(position);\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public int getCount() {\n" +
                "        return fragments.size();\n" +
                "    }\n" +
                "\n" +
                "    /**\n" +
                "     * 得到页面的标题\n" +
                "     *\n" +
                "     * @param position\n" +
                "     * @return\n" +
                "     */\n" +
                "    @Override\n" +
                "    public CharSequence getPageTitle(int position) {\n" +
                "        return fragments.get(position).getTitle();\n" +
                "    }\n" +
                "}\n" +
                "《MyFragment》：import android.content.Context;\n" +
                "import android.graphics.Color;\n" +
                "import android.os.Bundle;\n" +
                "import android.support.annotation.Nullable;\n" +
                "import android.support.v4.app.Fragment;\n" +
                "import android.view.Gravity;\n" +
                "import android.view.LayoutInflater;\n" +
                "import android.view.View;\n" +
                "import android.view.ViewGroup;\n" +
                "import android.widget.TextView;\n" +
                "\n" +
                "/**\n" +
                " * 作用：MyFragment\n" +
                " */\n" +
                "public class MyFragment extends Fragment {\n" +
                "\n" +
                "    /**\n" +
                "     * 标题\n" +
                "     */\n" +
                "    private  String title;\n" +
                "    /**\n" +
                "     * 内容\n" +
                "     */\n" +
                "    private  String content;\n" +
                "    Context mContext;\n" +
                "    TextView textView;\n" +
                "\n" +
                "    /**\n" +
                "     * 得到内容\n" +
                "     *\n" +
                "     * @return\n" +
                "     */\n" +
                "    public String getContent() {\n" +
                "        return content;\n" +
                "    }\n" +
                "\n" +
                "    /**\n" +
                "     * 得到标题\n" +
                "     *\n" +
                "     * @return\n" +
                "     */\n" +
                "    public String getTitle() {\n" +
                "        return title;\n" +
                "    }\n" +
                "\n" +
                "    public MyFragment(String title, String content) {\n" +
                "        super();\n" +
                "        this.title = title;\n" +
                "        this.content = content;\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "    @Override\n" +
                "    public void onCreate(@Nullable Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        //上下文\n" +
                "        mContext = getActivity();\n" +
                "    }\n" +
                "\n" +
                "    /**\n" +
                "     * 创建视图\n" +
                "     * @param inflater\n" +
                "     * @param container\n" +
                "     * @param savedInstanceState\n" +
                "     * @return\n" +
                "     */\n" +
                "    @Nullable\n" +
                "    @Override\n" +
                "    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {\n" +
                "        //创建视图\n" +
                "        textView = new TextView(mContext);\n" +
                "        textView.setTextColor(Color.RED);\n" +
                "        textView.setTextSize(25);\n" +
                "        textView.setGravity(Gravity.CENTER);\n" +
                "        return textView;\n" +
                "    }\n" +
                "\n" +
                "    /**\n" +
                "     * 绑定数据\n" +
                "     * @param savedInstanceState\n" +
                "     */\n" +
                "    @Override\n" +
                "    public void onActivityCreated(@Nullable Bundle savedInstanceState) {\n" +
                "        super.onActivityCreated(savedInstanceState);\n" +
                "        //设置内容\n" +
                "        textView.setText(content);\n" +
                "    }\n" +
                "}";
        textView.setText(str);
    }
}
