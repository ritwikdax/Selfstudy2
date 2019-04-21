package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.selfstudy.selfstudy.R;

import java.util.List;

import interfaces.SubjectItemClickListener;
import model.Subject;

public class SubjectsAdapter extends RecyclerView.Adapter<SubjectsAdapter.SubViewHolder> {

    private Context mCtx;
    private List<Subject> mSubList;
    private SubjectItemClickListener subjectItemClickListener;

    public SubjectsAdapter(Context mCtx, List<Subject> mSubList) {
        this.mCtx = mCtx;
        this.mSubList = mSubList;
    }

    @NonNull
    @Override
    public SubjectsAdapter.SubViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(mCtx).inflate(R.layout.row_item_subjects, viewGroup,false);
        return new SubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SubjectsAdapter.SubViewHolder subViewHolder, int i) {
        Subject subject = mSubList.get(i);
        float progress = subject.getProgressPersent();

        if (isAnInt(progress)){
            String progressVal = (int)(progress) + "%";
            subViewHolder.progressPer.setText(progressVal);
        }
        else {
            String progressVala = progress + "%";
            subViewHolder.progressPer.setText(progressVala);
        }


        subViewHolder.subName.setText(subject.getSubjectName());
        subViewHolder.subIcon.setImageResource(subject.getSubIcon());
        subViewHolder.subProgress.setProgress((int) subject.getProgressPersent());

    }

    @Override
    public int getItemCount() {
        return mSubList.size();
    }

    public class SubViewHolder extends RecyclerView.ViewHolder {

        private ImageView subIcon;
        private TextView subName, progressPer;
        private ProgressBar subProgress;

        public SubViewHolder(@NonNull View itemView) {
            super(itemView);

            subIcon = itemView.findViewById(R.id.iv_row_subject_icon);
            subName = itemView.findViewById(R.id.tv_row_subName);
            progressPer = itemView.findViewById(R.id.tv_row_proPer);
            subProgress = itemView.findViewById(R.id.pb_row_progress);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    subjectItemClickListener.onSubjectItemClicked(getAdapterPosition());
                }
            });
        }
    }

    public void setOnSubjectItemClickListener(SubjectItemClickListener listener){
        this.subjectItemClickListener = listener;
    }

    private boolean isAnInt(float num){
        if (Math.floor(num)== num){
            return true;
        }
        return false;

    }

}
