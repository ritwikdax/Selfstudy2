package fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.selfstudy.selfstudy.R;

public class HomeFragment extends Fragment {

    TextView mUpgradeMsg;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mUpgradeMsg = view.findViewById(R.id.tv_upgrade_text);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String s = "Your free trial expires on <font color='#00b8d2'><b>27 Apr 2019</b></font> upgrade now to get uninterrupted access";
        mUpgradeMsg.setText(Html.fromHtml(s));
    }
}
