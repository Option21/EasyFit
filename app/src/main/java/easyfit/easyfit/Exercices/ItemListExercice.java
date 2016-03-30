package easyfit.easyfit.Exercices;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ItemListExercice extends Activity{

    public static final List<Exercices> ITEMS = new ArrayList<Exercices>();
    public static final Map<String, Exercices> ITEM_MAP = new HashMap<String, Exercices>();

    static {
        addItem(createExerciceMuscu1(1));
        addItem(createExerciceMuscu2(2));
        addItem(createExerciceMuscu3(3));
        addItem(createExerciceMuscu4(4));
        addItem(createExerciceMuscu5(5));
    }

    private static void addItem(Exercices item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static Exercices createExerciceMuscu1(int position) {
        return new Exercices (String.valueOf(position), "Abdominaux-Exercice : 1 ", Exo1_Abdo(position),"Abdo");
    }
    private static Exercices createExerciceMuscu2(int position) {
        return new Exercices (String.valueOf(position), "Bras-Exercice : 1 ", Exo2_Bras(position),"Bras");
    }
    private static Exercices createExerciceMuscu3(int position) {
        return new Exercices (String.valueOf(position), "Dos-Exercice : 1", Exo3_Dos(position),"Dos");
    }
    private static Exercices createExerciceMuscu4(int position) {
           return new Exercices (String.valueOf(position), "Jambes-Exercice : 1 ", Exo4_Jambes(position),"Jambes");
    }
    private static Exercices createExerciceMuscu5(int position) {
        return new Exercices (String.valueOf(position), "Torse-Exercice : 1 ", Exo5_Torse(position),"Torse");
    }

    private static String Exo1_Abdo(int position)
    {
        StringBuilder builder = new StringBuilder();
        builder.append("\nLe crunch au sol\n\n");
        builder.append("Le crunch est un exercice simple et efficace pour muscler les abdominaux. Il affine et raffermit la taille si vous travaillez avec le poids du corps, et développe les abdominaux si vous utilisez un lest de plus en plus lourd. Il ne nécessite pas de matériel et peut être réalisé n’importe où.\n" +
                "Muscles ciblés\n" + "\n" + "Le crunch sollicite surtout le grand droit des abdominaux, la fameuse « tablette de chocolat », et secondairement les muscles obliques situés sur le côté de la taille. Le grand droit permet la flexion du tronc ; il rapproche le pubis du sternum par un enroulement vertébral lorsque le bassin est fixe. Il permet également la rétroversion du bassin quand le tronc est fixe.\n" +
                "\n" + "Le crunch a la réputation de plus solliciter la partie supérieure des abdominaux (au-dessus du nombril) par rapport aux relevés de bassin ou de jambes, qui feraient plutôt travailler la partie basse.\n" +
                "Exécution de l’exercice\n" + "\n" + "Position de départ allongé sur le sol ou sur un banc. Les mains peuvent être placées sur la tête au niveau des tempes, sur la poitrine, ou encore le long du corps (plus facile). Evitez de les positionner derrière la nuque.\n" +
                "\n" + "Les pieds peuvent être posés sur le sol, près des fesses, ou reposer sur un banc. On peut aussi placer les cuisses à la verticale, genoux fléchis et écartés, pieds croisés, de sorte à ne pas cambrer le bas du dos lors du mouvement. Attention, plus les jambes sont surélevées voire tendues, plus la difficulté augmente.\n" +
                "\n" + "Enrouler le buste vers l’avant en contractant les abdominaux. Les épaules ne décollent que de quelques centimètres du sol, et le bas du dos et les hanches restent fixes.");
        builder.append("Le retour à la position de départ doit être réalisé sans à-coups, en conservant la contraction et la tension dans le muscle. La vitesse d’exécution est lente et constante. On peut placer un lest sur la poitrine comme une rondelle de fonte ou un haltère, de sorte à ajouter de la difficulté à l’exercice. On peut aussi tendre les bras en arrière pour augmenter la résistance.\n" +
                "Respiration\n" + "\n" + "Inspiration en début de mouvement quand la cage thoracique est ouverte. Soufflez en exécutant le mouvement et contractez bien vos abdominaux. Le blocage respiratoire doit être évité.\n" +
                "Consignes de sécurité\n" + "\n" + "Évitez de placer vos mains derrière la tête, car souvent on s'aide de celle-ci pour faire l'exercice quand on bloque. Cela peut entraîner des problèmes aux cervicales. Le plus simple est de maintenir les mains sur les tempes ou sur la poitrine.\n" +
                "\n" + "Ne pas décoller le bas du dos, l'amplitude très réduite n’enlève pas d’efficacité à l’exercice.\n" +
                "\n" + "Le fait de travailler les pieds non bloqués, serrés et les genoux écartés, limite l'activité des fléchisseurs de la hanche, psoas-iliaque et droit antérieur, et évite bien des tensions et douleurs dans le bas du dos. Si vous avez mal au dos quand vous faites les exercices d'abdos, cet article devrait vous aider : Pourquoi ai-je mal au dos quand je fais les abdos ?\n" +
                "Conseils pour le crunch\n" + "\n" + "En tant que muscles posturaux, les abdominaux sont plutôt endurants et pourront être travaillés en séries assez longues. Nous vous suggérons des séries de 15 à 30 répétitions, mais si vous pouvez en faire plus, n'hésitez pas à durcir les exercices. Au niveau du planning, 3 séances complètes d'abdominaux pas semaine feront l'affaire. Mais n'oubliez pas de travailler tous les muscles qui composent ce groupe, pas seulement ceux qui sont visibles, en surface ! Je pense notamment au transverse, ne zappez pas le gainage !\n" +
                "On pourra faire les abdominaux en fin de séance, de sorte à ce qu'ils restent frais pour les exercices globaux où ils sont mis à contribution.\n" +
                "\n" + "Si vous trouvez l'exercice trop facile et que vous pouvez enchaîner des séries de plus de 50 répétitions, n'hésitez pas à durcir l'exercice en ajoutant de la résistance. Pour cela, vous pouvez éloigner les mains du buste et tendre les bras derrière la tête. Vous pouvez bien sûr utiliser des poids, disques ou haltère, à placer sur la poitrine ou derrière le cou. Cela est particulièrement valable si l'on souhaite gagner de la masse au niveau de la taille (personnes minces).\n" +
                "\n" + "Nous vous rappelons que pour obtenir des abdominaux secs et dessinés, faire des exercices ne sera pas suffisant. Les exercices permettent de muscler les abdominaux et aident à réduire le tour de taille, notamment par la pratique du gainage. Mais seule la diète vous débarassera de la couche de gras qui les recouvre. Pour cela, revoyez votre nutrition et pratiquez régulièrement une activité aérobie (cardio-training) en plus de la musculation.");
        return builder.toString();
    }

    private static String Exo2_Bras(int position)
    {
        StringBuilder builder = new StringBuilder();
        builder.append("\nCurl barre\n\n");
        builder.append("Cet exercice de musculation sollicite et développe les biceps. Le curl barre est l’exercice d’isolation de base pour les biceps.\n" + "Muscles ciblés\n" + "\n" + "Le biceps brachial, courte et longue portion, le brachial antérieur et le long supinateur.\n" +"Exécution de l’exercice\n" +"\n" + "En position de départ debout, le dos immobile et droit, les genoux fléchis ou une jambe avancée pour éviter de tricher en s'aidant de l'élan et les coudes prés du corps. Monter et descendre la barre sans à-coups. Vous pouvez varier l'écartement des mains en utilisant une prise large, moyenne ou serrée.");
        builder.append("Respiration\n" + "\n" + "Inspirez au début du mouvement quand les bras sont tendus, et soufflez lors de la flexion.\n" +
                "Consignes de sécurité\n" +"\n" + "Sur cet exercice, on constate souvent que les pratiquants trichent et s’aident de l’élan en se penchant en avant et en donnant une impulsion avec le bas du dos. Ensuite, ils avancent les coudes vers l’avant en s’aidant de l'avant de l'épaule (deltoïde antérieur) et du haut des pectoraux. En réalisant l'exercice de cette façon, le biceps n’est pas sollicité sur toute l’amplitude et le recrutement des fibres n’est pas maximum. La stimulation musculaire et donc le développement seront lésés.\n" +
                "Pour une bonne forme d’exécution, gardez les bras collés contre les flancs et perpendiculaires au sol.\n" +       "Pour éviter l’élan, gardez le dos immobile et droit, les genoux fléchis ou avancez une jambe pour stabiliser le corps. Il est aussi possible de réaliser l'exercice de façon encore plus stricte, en maintenant le dos contre un mur. Cela évite de tricher et c'est d'ailleurs de cette façon qu'il est exécuté lors de compétitions de curls à la barre.\n" +
                "Variantes\n" + "\n" + "Le curl barre peut être réalisé à la poulie basse en utilisant une barre droite, une barre coudée dite \"EZ\" ou encore avec la corde.\n" +
                "Il est possible, à la barre droite, de toucher plus ou moins intensément un des deux faisceaux du biceps brachial. La position de départ est classique, prise en supination (comme sur la vidéo plus haut), paumes des mains face au visage et genoux légèrement fléchis.\n" +
                "\n" + "- Si l'on veut porter le travail sur la longue portion du biceps brachial (à l'extérieur du bras), il faut prendre une prise serrée.\n" +
                "- Si l'on veut porter le travail sur la courte portion, il faut prendre une prise large.\n" +        "\n" +    "La prise en pronation de la barre (prise inverse), comme la prise marteau d'ailleurs (semi-pronation), fait porter une partie de l'effort sur le long supinateur, un muscle qui traverse tout l'avant-bras et rejoint l'humérus. Les muscles de l'avant-bras, les extenseurs du poignet, sont aussi mis à rude épreuve.\n" +
                "Dans les deux cas, le brachial antérieur sera sollicité par ces exercices ; le biceps brachial également, mais moins.");
        return builder.toString();
    }

    private static String Exo3_Dos(int position)
    {
        StringBuilder builder = new StringBuilder();
        builder.append("\nTractions à la barre fixe\n\n");
        builder.append("Cet exercice de musculation sollicite et développe les muscles du dos, surtout au niveau de la largeur. Les tractions à la barre fixe sont de formidables bâtisseuses de dorsaux. En tant que mouvement de base, nous vous conseillons de l'inclure dans votre routine de dos. Ceux qui ne peuvent pas faire de tractions avec le poids du corps pourront se diriger vers les tirages à la poulie haute.\n" +
                "Muscles ciblés\n" +  "\n" + "Principalement le grand dorsal, grand rond, petit rond et secondairement les muscles des bras (biceps brachial, brachial antérieur, long supinateur), les trapèzes, rhomboïdes et deltoïdes postérieurs.\n" +
                "Execution de l'exercice\n" +  "\n" +"En position de départ, vous êtes accroché à la barre, les bras tendus avec une prise plus grande que la largeur d'épaules et les pieds croisés ou parallèles. Monter en amenant le menton au niveau de la barre et redescendre sans à coup en gardant la tension dans les muscles.");
        builder.append("Vous pouvez marquer une pause au point le plus haut de l'exercice pour bien contracter les dorsaux.\n" + "Respiration\n" +     "\n" +      "Inspirez lors de la descente et expirez en position haute.\n" +       "Consignes de sécurité\n" +                "\n" +                "Gardez une vitesse d’exécution lente, ce n'est pas un marathon ! Pour éviter de vous balancer durant le mouvement, contractez les abdominaux et fessiers. Ne vous laissez pas tomber brutalement dans la phase de retour, gardez les coudes légèrement fléchis pour préserver vos articulations et tendons.\n" +
                "Pour bien travailler le dos plutôt que les biceps, sortez bien la poitrine an avant en cambrant légèrement le bas du dos, et amorçez le mouvements en tirant les coudes vers le bas comme si vos mains étaient des crochets. En position haute, contractez les dorsaux et revenez doucement à la position initiale sans tendre complètement les bras.\n" +
                "Si vous utilisez une barre à traction ou un repose barre, veillez à ce que l’ensemble soit solide car si vous tombez ce sont les genoux qui prendront.\n" +
                "Les tractions réalisées en amenant la barre derrière la nuque placent l’articulation de l’épaule dans une position néfaste, il vaut mieux les faire par devant.\n" +
                "Variantes\n" +   "\n" +  "En variant la prise des mains, on peut porter l’effort sur différentes parties du dos. La prise large sollicitera surtout le grand dorsal et la prise serrée, le petit rond, grand rond et bien sur les biceps. Il est possible de faire l'exercice avec un seul bras mais il faut être très fort !");
        return builder.toString();
    }

    private static String Exo4_Jambes(int position)
    {
        StringBuilder builder = new StringBuilder();
        builder.append("\nLes Squats\n\n");
        builder.append("Cet exercice de musculation sollicite et développe l’ensemble du corps mais vise principalement les muscles des cuisses et les fessiers. C'est l'exercice roi de la musculation. « Ceux qui ne font pas de squat, ne font pas de musculation » est une expression qu'on entend souvent de la bouche des culturistes. Assez technique, il demande un bon équilibre et une certaine souplesse. Efficace et rentable, il ne convient pas à toutes les morphologies qui tireront plus de bénéfices d'autres exercices.\n" +
                "Muscles ciblés\n" +"\n" + "Le grand fessier, quadriceps (droit antérieur, biceps crural, vaste externe et interne), arrière cuisses (demi membraneux, demi-tendineux), soléaire des mollets, les muscles fixateurs abdominaux, petit et moyen fessiers, adducteurs, dos (spinaux, lombaires) et dans une moindre mesure les muscles de la ceinture scapulaire (épaules, trapèzes) pour maintenir la barre.\n" +
                "Exécution de l'exercice\n" +  "\n" +  "Debout, la barre reposant sur les trapèzes, mains espacées de la largeur des épaules ou plus, pieds en canard - à dix heure dix - légèrement plus écartés que la largeur des épaules et placés dans l’axe des genoux. Fléchir les genoux et pousser les fesses en arrière avec le buste droit. Descendre théoriquement jusqu'à ce que vos cuisses soient parallèle au sol. Limitez l’amplitude si vous sentez que vous allez arrondir le dos ou si vos talons décollent du sol. La barre descend et remonte verticalement, sans arrêts en position haute et rebonds en position basse. L'équilibre peut être difficile au début, il faut du temps pour maîtriser l'exercice.");
        builder.append("Respiration\n" + "\n" +  "Inspirez lors de la descente de la barre et expirez lorsque vous revenez à la position de départ.\n" +
                "Il est conseillé de ne pas bloquer sa respiration quand on remonte. Cependant, cette manœuvre permet de minimiser le risque de blessure lombaire quand la charge est lourde. La respiration bloquée et les abdominaux contractés gainent le tronc dans la partie critique du mouvement et protègent la colonne vertébrale, à la condition de garder bien évidemment le dos droit.\n" +
                "Consignes de sécurité\n" +   "\n" +  "Travaillez en sécurité avec un repose barre ou une cage à squat. Cela sert à reposer la barre sur sur les supports (chandelles) entre les séries mais surtout à s'en débarasser au cas où vous resteriez coincé sous la charge en position basse.\n" +
                "Les débutants en musculation doivent apprendre ce mouvement en utilisant une barre légère et augmenter la charge une fois l’exercice maîtrisé. Il vaut mieux l’apprendre en salle, avec un coach professionnel diplômé d’état.\n" +
                "Variantes\n" + "\n" +  "Des variations sont possibles en jouant sur la position des pieds et l'écartement des cuisses.\n" +
                "Si les cuisses sont très écartées et les pieds placés en canard - à dix heure dix -, cela entraînera plus de travail pour l'intérieur des cuisses (les adducteurs).\n" +
                "Si les jambes sont serrées avec les pieds droits, cela sollicite plus le vaste externe situé sur le côté extérieur des cuisses.");
        return builder.toString();
    }

    private static String Exo5_Torse(int position)
    {
        StringBuilder builder = new StringBuilder();
        builder.append("\nLes Pompes au sol\n\n");
        builder.append("Tout le monde à déjà pratiqué cet exercice de musculation au moins une fois ! C'est un classique du genre qui permet de travailler l'ensemble du buste. On peut se construire de bons pectoraux avec seulement les pompes mais à condition de savoir s'y prendre pour bien développer toutes les parties de ce groupe musculaire. En effet, selon la position des mains et l'inclinaison, on pourra favoriser le haut, le bas ou même l'intérieur des pectoraux.\n" +
                "Muscles ciblés\n" + "\n" +"Il sollicite principalement le grand pectoral, le deltoïde antérieur et les triceps. D'autres muscles participent pour maintenir l'équilibre notamment les abdominaux.\n" +
                "Exécution de l'exercice\n" +  "\n" +"Position de départ au sol, écartement des mains supérieur à la largeur des épaules. Descendre le buste jusqu'à frôler le sol avec la tête en gardant les abdominaux sous tension. Revenir à la position de départ.");
        builder.append("Respiration\n" + "\n" + "Inspirez lors de la descente et expirez lorsque vous revenez à la position de départ.\n" +
                "Consignes de sécurité\n" + "\n" +  "Garder les abdominaux sous tension pendant le mouvement pour ne pas cambrer au niveau des lombaires (gainage).\n" +
                "Variantes\n" + "\n" + "Plusieurs variantes de cette exercice de musculation sont possibles. Il est possible de :\n" +
                "\n" + "Poser les genoux au sol pour rendre l'exercice moins difficile. Si vous n'êtes pas encore capable de faire des pompes, cette astuce vous facilitera l'exercice. Vous pourrez plus tard passer à la version normale.\n" +
                "    Rapprocher les mains pour plus solliciter les triceps et l'intérieur des pectoraux. L'exercice est alors beaucoup plus difficile et les triceps sont mis à rude épreuve.\n" +
                "    Surélever les pieds pour plus porter le travail sur le haut des pectoraux. Vous pouvez poser les pieds sur un support.\n" +
                "    Réaliser l'exercice avec un seul bras en écartant bien les cuisses pour maintenir l'équilibre. Cette version est particulièrement difficile car tout le poids repose alors sur un seul bras. Echauffez-vous avec quelques séries longues de pompes avant de passer à la version à un bras.\n");
        return builder.toString();
    }

    public ImageView getImage1(ImageView image)
    {
        //ImageView image = (ImageView) findViewById(R.id.imageView1);
        return image;
    }

    public static class Exercices {
        public final String id;
        public final String content;
        public final String details;
        public final String titre;

        public Exercices(String id, String content, String details,String titre) {
            this.id = id;
            this.content = content;
            this.details = details;
            this.titre = titre;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
