package fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.selfstudy.selfstudy.R;

import java.util.ArrayList;
import java.util.List;

import adapter.SubjectsAdapter;
import interfaces.SubjectItemClickListener;
import model.Subject;

public class HomeFragment extends Fragment {

    private TextView mUpgradeMsg;
    private List<Subject> mSubLists;
    private SubjectsAdapter adapter;
    private RecyclerView recyclerView;
    private Button mUpgradeBtn;
    private Context mContext;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mContext = getContext();
        mUpgradeMsg = view.findViewById(R.id.tv_upgrade_text);
        recyclerView = view.findViewById(R.id.rv_subjects);
        mUpgradeBtn = view.findViewById(R.id.btn_upgrade);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        prepareDummyText();

        adapter = new SubjectsAdapter(mContext, mSubLists);
        adapter.setOnSubjectItemClickListener(new SubjectItemClickListener() {
            @Override
            public void onSubjectItemClicked(int position) {
                Toast.makeText(mContext, "Item: "+ mSubLists.get(position).getSubjectName(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        //date is hardcoded.
        String s = "Your free trial expires on <font color='#00b8d2'><b>29 Jan 2019</b></font>" +
                " upgrade now to get uninterrupted access";
        mUpgradeMsg.setText(Html.fromHtml(s));

        //upgrade Button
        mUpgradeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Upgrade", Toast.LENGTH_SHORT).show();
            }
        });

        //recyclerview
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);


    }

    private void prepareDummyText(){

        mSubLists= new ArrayList<>();

        Subject ma = new Subject("Mental Ability",10, R.drawable.ic_mental_ability );
        mSubLists.add(ma);

        Subject ph = new Subject("Physics",0, R.drawable.ic_physics);
        mSubLists.add(ph);

        Subject chem = new Subject("Chemistry",40, R.drawable.ic_chemistry);
        mSubLists.add(chem);

        Subject math = new Subject("Math",0, R.drawable.ic_physics);
        mSubLists.add(math);

        mSubLists.add(ma);

    }
}
