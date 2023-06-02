package pl.put.poznan.aplikacje.mobilne.cocktails;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

class SectionsPagerAdapter extends FragmentPagerAdapter {
    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public int getCount() {
        return 3;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TopFragment();
            case 1:
                return new Tab1Fragment();
            case 2:
                return new Tab2Fragment();
        }
        return null;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Lista Drinków";
            case 1:
                return "Kategorie";
            case 2:
                return "Stoper";
        }
        return null;
    }

}
