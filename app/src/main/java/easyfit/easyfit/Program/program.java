package easyfit.easyfit.Program;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
                    textView.setText("ENTRAINEMENT DEBUTANT\n"+"\nDans le monde de la musculation, il y a deux façons d'aborder la mise en place d'un programme d'entraînement.\n" +
                            "Il y a ceux qui préfèrent travailler en Full-body, c'est-à-dire exercer tout le corps pendant la séance de musculation, en faisant deux ou trois séances complètes par semaine. Et d'autres qui préfèrent travailler en Split routine, c'est-à-dire diviser et répartir les exercices sur plusieurs séances. Par exemple, lundi le dos, mardi les pectoraux, mercredi les cuisses, vendredi les épaules et samedi les biceps et triceps.\n" +
                            "\n" +
                            "En général, on vous propose un programme en split quand vous débutez en salle de musculation mais ce n'est pas un bon choix ! Si vous êtes débutant, nous vous conseillons de faire du full-body. Ce type de routine vous permettra de progresser rapidement.\n" +
                            "\n" +
                            "Les débutants font souvent l'erreur de copier les programmes d'entraînement que l'on trouve dans les magasines de fitness ou sur internet. Ils espèrent obtenir les mêmes résultats que leur modèle fitness ou youtubers préférés. Il est naturel de penser que les programmes de ces personnalités sont au top, vu qu'ils sont extrèmement bien musclés et secs. Mais dans la plupart des cas, ces programmes ne vous conviendront pas." + "Ce sont souvent d'interminables splits qui contiennent beaucoup trop d'exercices et de séries pour chaque groupe musculaire, ou des programmes trop spécialisés. Pour vous citer un exemple, on peut croiser des séances pour les triceps de 18 séries !\n" +
                            "\n" +
                            "Ces programmes sont inadaptés aux débutants, trop lourds et trop peu fréquents pour progresser correctement. Ils s'adressent plutôt à des pratiquants avancés, doués voir dopés. Je ne dis pas que vous ne progresserez pas avec, mais il est plus adapté pour un débutant de faire un programme qui travaille tout le corps pendant la séance, plusieurs fois par semaine.\n"
                    + "\n" +
                            "    Développé couché : 4*12 (4 séries de 12 répétitions) - Pectoraux, épaules, triceps.\n" +
                            "    Tractions (ou tirage devant) : 4*12 - Dorsaux, biceps.\n" +
                            "    Développé haltères : 4*12 - Epaules, triceps.\n" +
                            "    Squat barre nuque (ou presse à cuisses) : 4*12 - Cuisses et fessiers.\n" +
                            "    Crunch au sol : 4*10 + Planche 3*1 minute - Abdominaux\n" +
                            "    Banc à lombaires 3*1 min - Lombaires\n" +
                            "\n" + "Nos conseils\n" +
                            "\n" +
                            "Après un échauffement général d'une dizaine de minutes sur un appareil de cardio-training, vous pourrez attaquer le programme en commençant avec 2 séries légères d'échauffement de 20 répétitions (2*20) au développé-couché.\n" +
                            "Ensuite, pour les exercices suivants, 1 série d'échauffement (1*15) sera suffisante.\n" +
                            "\n" +
                            "Comme mouvements alternatifs, pour le développé-couché vous pouvez faire des dips, du tirage devant pour remplacer les tractions, du développé devant à la place du développé haltères, et de la presse à cuisses si le squat ne vous convient pas. Si vous n'avez pas le matériel, il est toujours possible de trouver un exercice de remplacement.\n" +
                            "\n");
                    textView.setMovementMethod(new ScrollingMovementMethod());
                    break;
                case 2:
                    textView.setText("ENTRAINEMENT EXPERT\n"+"\nVous êtes de niveau intermédiaire, avancé ou même un expert de la musculation ? Vous envisagez de passer à un programme plus corsé afin de pousser votre corps dans ses retranchements et gagner toujours plus de muscles ? Vous êtes au bon endroit !\n" +
                            "Nous vous proposons dans cette rubrique des programmes de musculation pour niveaux intermédiaires et confirmés. Attention, ce ne sont pas des programmes conseillés aux débutants mais plutôt aux personnes qui ont de l'expérience, maîtrisent les exercices et ont une bonne connaissance de leur corps."
                    + "Joe DeFranco propose donc une adaptation du Westside sous le doux nom du « Westside for Skinny Bastard ». Ce programme est à mon sens idéal pour des sports tel que le rugby, le football américain et certains sports de combats lors d’une courte période de préparation où il faut, parfois en peu de temps, développer masse musculaire, force et puissance.\n" +
                            "Je vais donc ici simplement retranscrire pour vous comment DeFranco voit ce programme d’entraînement. Je donnerai simplement mon opinion et les modifications que j’y apporterai." + "Programme DeFranco\n" +
                            "\n" +
                            "Lundi : Force max haut du corps\n" +
                            "Mardi : Efforts dynamiques bas du corps\n" +
                            "Mercredi : Repos\n" +
                            "Jeudi : Force endurante haut du corps\n" +
                            "Vendredi : Force max bas du corps\n" +
                            "Samedi : Repos\n" +
                            "Dimanche : Repos." + "La force maximale est placée en début de semaine pour travailler sur un système nerveux frais. Inutile de dire qu’une montée progressive des charges doit être de rigueur pour arriver à son 3RM ou 5RM." + "Un exemple, si l’on vise 3 x 100 kg au développé couché à la trap barre :\n" +
                            "- Série 1 : 5 x 45 kg\n" +
                            "- Série 2 : 5 x 57 kg\n" +
                            "- Série 3 : 3 x 72 kg\n" +
                            "- Série 4 : 3 x 87 kg\n" +
                            "- Série 5 : 3 x 94 kg\n" +
                            "- Série 6 : 3 x 100 kg");
                    textView.setMovementMethod(new ScrollingMovementMethod());
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
