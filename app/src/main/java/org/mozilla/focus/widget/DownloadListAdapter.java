package org.mozilla.focus.widget;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import org.mozilla.focus.R;
import org.mozilla.focus.download.DownloadInfo;
import org.mozilla.focus.download.DownloadInfoManager;
import org.mozilla.focus.utils.IntentUtils;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * Created by anlin on 01/08/2017.
 */

public class DownloadListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
        implements DownloadInfoManager.AsyncQueryListener{

    private List<DownloadInfo> mDownloadInfo = new ArrayList<>();
    private static final int VIEW_TYPE_EMPTY = 0;
    private static final int VIEW_TYPE_NON_EMPTY = 1;
    private int mItemCount = 0;

    public DownloadListAdapter(){
        loadMore();
    }

    public void loadMore(){
        DownloadInfoManager.getInstance().query(mItemCount,50,this);
    }

    public void updateItem(DownloadInfo downloadInfo){

        for (int i = 0;i<mDownloadInfo.size();i++){
            if (mDownloadInfo.get(i).getDownloadId().equals(downloadInfo.getDownloadId())){
                mDownloadInfo.remove(i);
                mDownloadInfo.add(downloadInfo);

                this.notifyDataSetChanged();
                break;
            }
        }
    }

    private void remove(int position){
        long downloadId = mDownloadInfo.get(position).getDownloadId();
        DownloadInfoManager.getInstance().delete(downloadId,null);

        mDownloadInfo.remove(position);

        this.notifyDataSetChanged();
    }

    private void delete(int position){
        try {
            new File(URI.create(mDownloadInfo.get(position).getFileUri()).getPath()).delete();

        }catch (Exception e){
            Log.v(this.getClass().getSimpleName(),""+e.getMessage());
        }
        remove(position);
    }

    @Override
    public int getItemViewType(int position) {
        return mDownloadInfo.isEmpty() ? VIEW_TYPE_EMPTY : VIEW_TYPE_NON_EMPTY;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView;
        if (VIEW_TYPE_NON_EMPTY == viewType){
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.download_menu_cell,parent,false);
            return new DownloadViewHolder(itemView);
        }else {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.download_empty,parent,false);
            return new DownloadEmptyViewHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        if (viewHolder instanceof DownloadViewHolder){
            DownloadViewHolder holder = (DownloadViewHolder) viewHolder;
            DownloadInfo downloadInfo = mDownloadInfo.get(position);

            holder.title.setText(downloadInfo.getFileName());

            String subtitle="";
            if (DownloadInfo.STATUS_SUCCESSFUL.equalsIgnoreCase(downloadInfo.getStatus())) {
                subtitle = downloadInfo.getSize() + "," + downloadInfo.getDate();
            } else {
                subtitle = downloadInfo.getStatus();
            }

            holder.subtitle.setText(subtitle);

            holder.action.setTag(position);
            holder.action.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final int position = (int) view.getTag();
                    final PopupMenu popupMenu = new PopupMenu(view.getContext(),view);
                    popupMenu.getMenuInflater().inflate(R.menu.menu_delete,popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {

                            switch (menuItem.getItemId()){
                                case R.id.remove:
                                    remove(position);
                                    popupMenu.dismiss();
                                    return true;
                                case R.id.delete:
                                    delete(position);
                                    popupMenu.dismiss();
                                    return true;
                                default:
                                    break;
                            }
                            return false;
                        }
                    });

                    popupMenu.show();
                }
            });

            holder.itemView.setTag(downloadInfo);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DownloadInfo download = (DownloadInfo) view.getTag();
                    IntentUtils.intentOpenFile(view.getContext(),download.getMediaUri(),download.getMimeType());
                }
            });

        }else if (viewHolder instanceof DownloadEmptyViewHolder){
            DownloadEmptyViewHolder holder = (DownloadEmptyViewHolder) viewHolder;
            holder.imag.setBackgroundResource(R.color.colorPrimary);
        }
    }

    @Override
    public int getItemCount() {
        if (!mDownloadInfo.isEmpty()){
            return mDownloadInfo.size();
        }else {
            return 1;
        }
    }

    @Override
    public void onQueryComplete(List downloadInfoList) {
        mDownloadInfo.addAll(downloadInfoList);
        mItemCount = mDownloadInfo.size();
        this.notifyDataSetChanged();
    }

    public class DownloadViewHolder extends RecyclerView.ViewHolder{

        @SuppressFBWarnings("URF_UNREAD_FIELD")
        ImageView icon;
        TextView title;
        TextView subtitle;
        ImageView action;

        public DownloadViewHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.img);
            title = (TextView) itemView.findViewById(R.id.title);
            subtitle = (TextView) itemView.findViewById(R.id.subtitle);
            action = (ImageView) itemView.findViewById(R.id.menu_action);

        }
    }

    public class DownloadEmptyViewHolder extends RecyclerView.ViewHolder{

        @SuppressFBWarnings("URF_UNREAD_FIELD")
        ImageView imag;

        public DownloadEmptyViewHolder(View itemView) {
            super(itemView);
            imag = (ImageView) itemView.findViewById(R.id.img);
        }
    }
}
