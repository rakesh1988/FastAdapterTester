package com.rakesh1988.fastadaptertester;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikepenz.fastadapter.items.GenericAbstractItem;
import com.mikepenz.fastadapter.utils.ViewHolderFactory;
import com.rakesh1988.fastadaptertester.model.GithubUser;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rakesh on 01-Jan-17.
 */
public class GithubUserItem extends GenericAbstractItem<GithubUser, GithubUserItem, GithubUserItem.ViewHolder>

{

    public GithubUserItem(GithubUser githubUser)
    {
        super(githubUser);
    }

    @Override
    public int getType()
    {
        return R.id.cv_github_user_holder;
    }

    @Override
    public int getLayoutRes()
    {
        return R.layout.item_github_user;
    }


    @Override
    public void bindView(ViewHolder holder, List<Object> payloads)
    {
        super.bindView(holder, payloads);

        Picasso.with(holder.itemView.getContext())
                .load(getModel().getAvatarUrl())
                //.placeholder(R.drawable.image_loading_place_holder)
                .into(holder.imgUser);

        holder.txtUserName.setText(getModel().getLogin());
    }


    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.img_user)
        ImageView imgUser;
        @BindView(R.id.btn_share_user)
        ImageButton btnShareUser;
        @BindView(R.id.txt_user_name)
        TextView txtUserName;
       /* @BindView(R.id.progress_bar_for_img_item_store_offer)
        ProgressBar progressBar;*/

        public ViewHolder(View itemView)
        {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    //the static ViewHolderFactory which will be used to generate the ViewHolder for this Item
    private static final ViewHolderFactory<? extends ViewHolder> FACTORY = new ItemFactory();

    /**
     * our ItemFactory implementation which creates the ViewHolder for our adapter.
     * It is highly recommended to implement a ViewHolderFactory as it is 0-1ms faster for ViewHolder creation,
     * and it is also many many times more efficient if you define custom listeners on views within your item.
     */
    protected static class ItemFactory implements ViewHolderFactory<ViewHolder> {
        public ViewHolder create(View v) {
            return new ViewHolder(v);
        }
    }

    /**
     * return our ViewHolderFactory implementation here
     *
     * @return
     */
    @Override
    public ViewHolderFactory<? extends ViewHolder> getFactory() {
        return FACTORY;
    }
}
