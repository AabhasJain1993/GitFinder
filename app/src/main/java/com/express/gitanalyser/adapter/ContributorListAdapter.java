package com.express.gitanalyser.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.express.gitanalyser.R;
import com.express.gitanalyser.model.Contributor;
import com.express.gitanalyser.model.RepositoryItem;
import com.express.gitanalyser.views.ContributorHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 5/12/17.
 */

public class ContributorListAdapter extends BaseAdapter {

    private List<Contributor> mContributorList;


    public ContributorListAdapter(List<Contributor> contributorList) {
        mContributorList = contributorList;
    }

    @Override
    public int getCount() {
        return mContributorList.size();
    }

    @Override
    public Object getItem(int position) {
        return getContributorList(position);
    }

    @Override
    public long getItemId(int position) {
        return position/5;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ContributorHolder contributorHolder;
        if(convertView == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.snippet_contributor_listivew, parent, false);
            contributorHolder= new ContributorHolder();

            contributorHolder.textView1 = (TextView) convertView.findViewById(R.id.contributor1);
            contributorHolder.textView2 = (TextView) convertView.findViewById(R.id.contributor2);
            contributorHolder.textView3 = (TextView) convertView.findViewById(R.id.contributor3);
            contributorHolder.textView4 = (TextView) convertView.findViewById(R.id.contributor4);
            contributorHolder.textView5 = (TextView) convertView.findViewById(R.id.contributor5);

            contributorHolder.imgView1 = (ImageView) convertView.findViewById(R.id.contributor1_image);
            contributorHolder.imgView2 = (ImageView) convertView.findViewById(R.id.contributor2_image);
            contributorHolder.imgView3 = (ImageView) convertView.findViewById(R.id.contributor3_image);
            contributorHolder.imgView4 = (ImageView) convertView.findViewById(R.id.contributor4_image);
            contributorHolder.imgView5 = (ImageView) convertView.findViewById(R.id.contributor5_image);
            view.setTag(contributorHolder);
        } else {
            contributorHolder = (ContributorHolder) view.getTag();
        }

        contributorHolder.bind(getContributorList(position), convertView.getContext());
        return view;
    }

    List<Contributor> getContributorList(int position) {
        int datapos = position * 5;
        List<Contributor> contributorList = new ArrayList<Contributor>();
        for(int i = 0; i< ContributorHolder.CONTRIBUTOR_IN_ROW;i++) {
            if(datapos + i < mContributorList.size()) {
                contributorList.add(mContributorList.get(datapos + i));
            }
        }
        return contributorList;
    }

}
