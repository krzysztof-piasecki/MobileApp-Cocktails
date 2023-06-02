package pl.put.poznan.aplikacje.mobilne.cocktails;

import androidx.fragment.app.Fragment;

public class SunsetActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return SunsetFragment.newInstance();
    }
}