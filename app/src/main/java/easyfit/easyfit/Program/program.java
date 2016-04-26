package easyfit.easyfit.Program;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import easyfit.easyfit.BaseDrawerActivity;
import easyfit.easyfit.R;

public class program extends BaseDrawerActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.program_layout);
        getLayoutInflater().inflate(R.layout.program_layout, frame,true);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static class PlaceholderFragment extends Fragment {
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.program_fragment, container,false);

            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            switch(getArguments().getInt(ARG_SECTION_NUMBER))
            {
                case 1:
                    textView.setText("Programmes débutants\n\n" +
                            "\n" +
                            "    -Développé couché : 4*12 (4 séries de 12 répétitions) \n: Pectoraux, épaules, triceps.\n" +
                            "    -Tractions (ou tirage devant) : 4*12 \n: Dorsaux, biceps.\n" +
                            "    -Développé haltères : 4*12 \n: Epaules, triceps.\n" +
                            "    -Squat barre nuque (ou presse à cuisses) : 4*12 \n: Cuisses et fessiers.\n" +
                            "    -Crunch au sol : 4*10 + Planche 3*1 minute \n: Abdominaux\n" +
                            "    -Banc à lombaires 3*1 min \n: Lombaires\n");
                    break;
                case 2:
                    textView.setText("Programmes avancés\n"+
                            "\n" +
                            "Lundi : Force max haut du corps\n" +
                            "Mardi : Efforts dynamiques bas du corps\n" +
                            "Mercredi : Repos\n" +
                            "Jeudi : Force endurante haut du corps\n" +
                            "Vendredi : Force max bas du corps\n" +
                            "Samedi : Repos\n" +
                            "Dimanche : Repos.\n");
                    break;
                default:
                    break;
            }
            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Exercices Débutant";
                case 1:
                    return "Exercice Avancées";
            }
            return null;
        }
    }
}
