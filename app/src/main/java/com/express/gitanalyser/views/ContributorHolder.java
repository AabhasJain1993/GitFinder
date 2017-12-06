package com.express.gitanalyser.views;

import android.content.Context;
import android.media.Image;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.express.gitanalyser.model.Contributor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aabhas_Jain on 12/5/2017.
 */

public class ContributorHolder{

    public static final int CONTRIBUTOR_IN_ROW = 5;

    public TextView textView1;
    public TextView textView2;
    public TextView textView3;
    public TextView textView4;
    public TextView textView5;

    public ImageView imgView1;
    public ImageView imgView2;
    public ImageView imgView3;
    public ImageView imgView4;
    public ImageView imgView5;


    public void bind(List<Contributor> contributorList, Context context) {
        if(contributorList.get(0)!= null) {
            textView1.setText(contributorList.get(0).getContributorName());
            Glide.with(context).load(contributorList.get(0).getContributorUrl()).into(imgView1);
        }

        if(contributorList.get(1)!= null) {
            textView2.setText(contributorList.get(1).getContributorName());
            Glide.with(context).load(contributorList.get(1).getContributorUrl()).into(imgView2);
        }

        if(contributorList.get(2)!= null) {
            textView3.setText(contributorList.get(2).getContributorName());
            Glide.with(context).load(contributorList.get(2).getContributorUrl()).into(imgView3);
        }

        if(contributorList.get(3)!= null) {
            textView4.setText(contributorList.get(3).getContributorName());
            Glide.with(context).load(contributorList.get(3).getContributorUrl()).into(imgView4);        }

        if(contributorList.get(4)!= null) {
            textView5.setText(contributorList.get(4).getContributorName());
            Glide.with(context).load(contributorList.get(4).getContributorUrl()).into(imgView5);
        }
    }
}
