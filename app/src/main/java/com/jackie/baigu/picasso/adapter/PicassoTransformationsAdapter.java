package com.jackie.baigu.picasso.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jackie.baigu.R;
import com.jackie.baigu.picasso.utils.Utils;
import com.squareup.picasso.Picasso;

import java.util.List;

import jp.wasabeef.picasso.transformations.BlurTransformation;
import jp.wasabeef.picasso.transformations.ColorFilterTransformation;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;
import jp.wasabeef.picasso.transformations.CropSquareTransformation;
import jp.wasabeef.picasso.transformations.CropTransformation;
import jp.wasabeef.picasso.transformations.GrayscaleTransformation;
import jp.wasabeef.picasso.transformations.MaskTransformation;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;
import jp.wasabeef.picasso.transformations.gpu.BrightnessFilterTransformation;
import jp.wasabeef.picasso.transformations.gpu.ContrastFilterTransformation;
import jp.wasabeef.picasso.transformations.gpu.InvertFilterTransformation;
import jp.wasabeef.picasso.transformations.gpu.KuwaharaFilterTransformation;
import jp.wasabeef.picasso.transformations.gpu.PixelationFilterTransformation;
import jp.wasabeef.picasso.transformations.gpu.SepiaFilterTransformation;
import jp.wasabeef.picasso.transformations.gpu.SketchFilterTransformation;
import jp.wasabeef.picasso.transformations.gpu.SwirlFilterTransformation;
import jp.wasabeef.picasso.transformations.gpu.ToonFilterTransformation;
import jp.wasabeef.picasso.transformations.gpu.VignetteFilterTransformation;

/**
 * Created by Administrator on 2016/12/31.
 */
public class PicassoTransformationsAdapter extends BaseAdapter {

    private Context context;
    private List<String> datas;

    public PicassoTransformationsAdapter(Context context, List<String> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_picasso_transformations, null);
            viewHolder = new ViewHolder();
            viewHolder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.iv_picasso_item = (ImageView) convertView.findViewById(R.id.iv_picasso_item);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //名字
        viewHolder.tv_name.setText("item" + (position + 1));
        //加载图片
        int integer = Integer.parseInt(datas.get(position));

        switch (integer) {

            case 1: {
                int width = Utils.dip2px(context, 133.33f);
                int height = Utils.dip2px(context, 126.33f);
                Picasso.with(context)
                        .load(R.drawable.check)
                        .resize(width, height)
                        .centerCrop()
                        .transform((new MaskTransformation(context, R.drawable.mask_starfish)))
                        .into(viewHolder.iv_picasso_item);
                break;
            }
            case 2: {
                int width = Utils.dip2px(context, 150.0f);
                int height = Utils.dip2px(context, 100.0f);
                Picasso.with(context)
                        .load(R.drawable.check)
                        .resize(width, height)
                        .centerCrop()
                        .transform(new MaskTransformation(context, R.drawable.chat_me_mask))
                        .into(viewHolder.iv_picasso_item);
                break;
            }
            case 3:
                Picasso.with(context)
                        .load(R.drawable.demo)
                        .transform(new CropTransformation(300, 100, CropTransformation.GravityHorizontal.LEFT,
                                CropTransformation.GravityVertical.TOP))
                        .into(viewHolder.iv_picasso_item);
                break;
            case 4:
                Picasso.with(context).load(R.drawable.demo)
                        // 300, 100, CropTransformation.GravityHorizontal.LEFT, CropTransformation.GravityVertical.CENTER))
                        .transform(new CropTransformation(300, 100)).into(viewHolder.iv_picasso_item);
                break;
            case 5:
                Picasso.with(context)
                        .load(R.drawable.demo)
                        .transform(new CropTransformation(300, 100, CropTransformation.GravityHorizontal.LEFT,
                                CropTransformation.GravityVertical.BOTTOM))
                        .into(viewHolder.iv_picasso_item);
                break;
            case 6:
                Picasso.with(context)
                        .load(R.drawable.demo)
                        .transform(new CropTransformation(300, 100, CropTransformation.GravityHorizontal.CENTER,
                                CropTransformation.GravityVertical.TOP))
                        .into(viewHolder.iv_picasso_item);
                break;
            case 7:
                Picasso.with(context)
                        .load(R.drawable.demo)
                        .transform(new CropTransformation(300, 100))
                        .into(viewHolder.iv_picasso_item);
                break;
            case 8:
                Picasso.with(context)
                        .load(R.drawable.demo)
                        .transform(new CropTransformation(300, 100, CropTransformation.GravityHorizontal.CENTER,
                                CropTransformation.GravityVertical.BOTTOM))
                        .into(viewHolder.iv_picasso_item);
                break;
            case 9:
                Picasso.with(context)
                        .load(R.drawable.demo)
                        .transform(new CropTransformation(300, 100, CropTransformation.GravityHorizontal.RIGHT,
                                CropTransformation.GravityVertical.TOP))
                        .into(viewHolder.iv_picasso_item);
                break;
            case 10:
                Picasso.with(context)
                        .load(R.drawable.demo)
                        .transform(new CropTransformation(300, 100, CropTransformation.GravityHorizontal.RIGHT,
                                CropTransformation.GravityVertical.CENTER))
                        .into(viewHolder.iv_picasso_item);
                break;
            case 11:
                Picasso.with(context)
                        .load(R.drawable.demo)
                        .transform(new CropTransformation(300, 100, CropTransformation.GravityHorizontal.RIGHT,
                                CropTransformation.GravityVertical.BOTTOM))
                        .into(viewHolder.iv_picasso_item);
                break;
            case 12:
                Picasso.with(context)
                        .load(R.drawable.demo)
                        .transform(new CropTransformation((float) 16 / (float) 9,
                                CropTransformation.GravityHorizontal.CENTER,
                                CropTransformation.GravityVertical.CENTER))
                        .into(viewHolder.iv_picasso_item);
                break;
            case 13:
                Picasso.with(context)
                        .load(R.drawable.demo)
                        .transform(new CropTransformation((float) 4 / (float) 3,
                                CropTransformation.GravityHorizontal.CENTER,
                                CropTransformation.GravityVertical.CENTER))
                        .into(viewHolder.iv_picasso_item);
                break;
            case 14:
                Picasso.with(context)
                        .load(R.drawable.demo)
                        .transform(new CropTransformation(3, CropTransformation.GravityHorizontal.CENTER,
                                CropTransformation.GravityVertical.CENTER))
                        .into(viewHolder.iv_picasso_item);
                break;
            case 15:
                Picasso.with(context)
                        .load(R.drawable.demo)
                        .transform(new CropTransformation(3, CropTransformation.GravityHorizontal.CENTER,
                                CropTransformation.GravityVertical.TOP))
                        .into(viewHolder.iv_picasso_item);
                break;
            case 16:
                Picasso.with(context)
                        .load(R.drawable.demo)
                        .transform(new CropTransformation(1, CropTransformation.GravityHorizontal.CENTER,
                                CropTransformation.GravityVertical.CENTER))
                        .into(viewHolder.iv_picasso_item);
                break;
            case 17:
                Picasso.with(context)
                        .load(R.drawable.demo)
                        .transform(new CropTransformation((float) 0.5, (float) 0.5,
                                CropTransformation.GravityHorizontal.CENTER,
                                CropTransformation.GravityVertical.CENTER))
                        .into(viewHolder.iv_picasso_item);
                break;
            case 18:
                Picasso.with(context)
                        .load(R.drawable.demo)
                        .transform(new CropTransformation((float) 0.5, (float) 0.5,
                                CropTransformation.GravityHorizontal.CENTER,
                                CropTransformation.GravityVertical.TOP))
                        .into(viewHolder.iv_picasso_item);
                break;
            case 19:
                Picasso.with(context)
                        .load(R.drawable.demo)
                        .transform(new CropTransformation((float) 0.5, (float) 0.5,
                                CropTransformation.GravityHorizontal.RIGHT,
                                CropTransformation.GravityVertical.BOTTOM))
                        .into(viewHolder.iv_picasso_item);
                break;
            case 20:
                Picasso.with(context)
                        .load(R.drawable.demo)
                        .transform(new CropTransformation((float) 0.5, 0, (float) 4 / (float) 3,
                                CropTransformation.GravityHorizontal.CENTER,
                                CropTransformation.GravityVertical.CENTER))
                        .into(viewHolder.iv_picasso_item);
                break;
            case 21:
                Picasso.with(context)
                        .load(R.drawable.demo)
                        .transform(new CropSquareTransformation())
                        .into(viewHolder.iv_picasso_item);
                break;
            case 22:
                Picasso.with(context)
                        .load(R.drawable.demo)
                        .transform(new CropCircleTransformation())
                        .into(viewHolder.iv_picasso_item);
                break;
            case 23:
                Picasso.with(context)
                        .load(R.drawable.demo)
                        .transform(new ColorFilterTransformation(Color.argb(80, 255, 0, 0)))
                        .into(viewHolder.iv_picasso_item);
                break;
            case 24:
                Picasso.with(context)
                        .load(R.drawable.demo)
                        .transform(new GrayscaleTransformation())
                        .into(viewHolder.iv_picasso_item);
                break;
            case 25:
                Picasso.with(context)
                        .load(R.drawable.demo)
                        .transform(new RoundedCornersTransformation(30, 0,
                                RoundedCornersTransformation.CornerType.BOTTOM_LEFT))
                        .into(viewHolder.iv_picasso_item);
                break;
            case 26:
                Picasso.with(context)
                        .load(R.drawable.check)
                        .transform(new BlurTransformation(context, 25, 1))
                        .into(viewHolder.iv_picasso_item);
                break;
            case 27:
                Picasso.with(context)
                        .load(R.drawable.demo)
                        .transform(new ToonFilterTransformation(context))
                        .into(viewHolder.iv_picasso_item);
                break;
            case 28:
                Picasso.with(context)
                        .load(R.drawable.check)
                        .transform(new SepiaFilterTransformation(context))
                        .into(viewHolder.iv_picasso_item);
                break;
            case 29:
                Picasso.with(context)
                        .load(R.drawable.check)
                        .transform(new ContrastFilterTransformation(context, 2.0f))
                        .into(viewHolder.iv_picasso_item);
                break;
            case 30:
                Picasso.with(context)
                        .load(R.drawable.check)
                        .transform(new InvertFilterTransformation(context))
                        .into(viewHolder.iv_picasso_item);
                break;
            case 31:
                Picasso.with(context)
                        .load(R.drawable.check)
                        .transform(new PixelationFilterTransformation(context, 20))
                        .into(viewHolder.iv_picasso_item);
                break;
            case 32:
                Picasso.with(context)
                        .load(R.drawable.check)
                        .transform(new SketchFilterTransformation(context))
                        .into(viewHolder.iv_picasso_item);
                break;
            case 33:
                Picasso.with(context)
                        .load(R.drawable.check)
                        .transform(new SwirlFilterTransformation(context, 0.5f, 1.0f, new PointF(0.5f, 0.5f)))
                        .into(viewHolder.iv_picasso_item);

                break;
            case 34:
                Picasso.with(context)
                        .load(R.drawable.check)
                        .transform(new BrightnessFilterTransformation(context, 0.5f))
                        .into(viewHolder.iv_picasso_item);
                break;
            case 35:
                Picasso.with(context)
                        .load(R.drawable.check)
                        .transform(new KuwaharaFilterTransformation(context, 25))
                        .into(viewHolder.iv_picasso_item);
                break;
            case 36:
                Picasso.with(context)
                        .load(R.drawable.check)
                        .transform(new VignetteFilterTransformation(context, new PointF(0.5f, 0.5f),
                                new float[]{0.0f, 0.0f, 0.0f}, 0f, 0.75f))
                        .into(viewHolder.iv_picasso_item);
                break;
        }


        return convertView;
    }

    static class ViewHolder {
        ImageView iv_picasso_item;
        TextView tv_name;
    }
}
