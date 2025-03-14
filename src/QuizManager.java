import java.awt.*;
import java.util.Scanner;
public class QuizManager implements QuizMethod {
    String quizName;
    Scanner input=new Scanner(System.in);
    int Points=0; // Points de bonne réponse
    int badResponse=0; // indice de mauvase réponse

    //Histoire
    protected  final String [] HistoireQCM= {
                    "En quelle année la Révolution française a-t-elle commencé ?",
                    "Qui était le premier empereur de France ?",
                    "Quelle civilisation a construit les pyramides de Gizeh ?",
                    "Qui a dit « Je pense, donc je suis » ?",
                    "Quelle guerre a opposé les Alliés aux forces de l'Axe ?"
    };

    //Science
    protected final String [] SciencesQCM={
            "Quel est l’élément chimique le plus abondant dans l’univers ?",
            "Quel est l’organe le plus grand du corps humain ?",
            "Combien de planètes composent notre système solaire ?",
            "Quel est le symbole chimique de l’or ?",
            "Quelle est la valeur de π (Pi) approximativement ?"
    };

    //Géographie
    protected final String [] GeographieQCM={
            "Quel est le plus grand océan du monde ?",
            "Quel pays a la plus grande superficie ?",
            "Quelle est la capitale du Japon ?",
            "Quelle est la plus haute montagne du monde ?",
            "Quelle est la mer qui borde l’Égypte ?"
    };

    //Sport
    protected final String[] SportQCM={
            "Combien de joueurs composent une équipe de football sur le terrain ?",
            "Qui a remporté la Coupe du Monde de la FIFA en 2018 ?",
            "Dans quel sport utilise-t-on un volant ?",
            "Quelle est la durée normale d’un match de basket en NBA ?",
            "Quel est le nom du plus grand tournoi de tennis sur terre battue ?"
    };
    //Ciné && Pop
    protected final String [] CinePopQCM={
            "Qui est le réalisateur du film « Titanic » ?",
            "Dans quel film trouve-t-on la célèbre phrase « Je suis ton père » ?",
            "Quel acteur joue le rôle de Tony Stark (Iron Man) dans le MCU ?",
            "Quel est le vrai nom de Spider-Man ?",
            "Dans quelle saga cinématographique trouve-t-on la Maison Gryffondor ?"
    };


    public QuizManager(String quizName) {
        // Constructor
        this.quizName = quizName;
    }

    public void welcome() {
        System.out.println("\uD83C\uDF89 Bienvenue dans le Quiz "+quizName+" ! \uD83C\uDF89\n");
        System.out.println("Prépare-toi à tester tes connaissances sur une multitude de sujets passionnants ! \uD83D\uDCDA\n" );
        System.out.println("1\uFE0F⃣ Sélectionne un thème parmi ceux disponibles.");
        System.out.println("2\uFE0F⃣ Réponds aux questions en choisissant l’option correcte parmi les propositions.");
        System.out.println("3\uFE0F⃣ À la fin du quiz, découvre ton score et vois si tu es un véritable expert du sujet !\n");
        System.out.println("\uD83C\uDFAF Serez-vous capable d’obtenir un score parfait ? Lancez le quiz et testez vos connaissances ! \uD83D\uDE80\n");
    }
    /**
     * Set botName
     * @param quizName
     */
    public void setQuizName(String quizName){
        this.quizName = quizName;
    }

    private void displaySubject(String[]data){
        int index;
        for (int i=0;i<data.length;i++){
            index=(i==0)?1:i+1;
            System.out.println(index+ "."+data[i]+",");
        }
        System.out.println("\n");
    }



    public void dialogue(){
        System.out.println("\uD83D\uDD0D Choisissez votre domaine de prédilection : \n");
        String [] Subject={"Histoire \uD83C\uDFDB ","Sciences \uD83D\uDD2C","Géographie \uD83C\uDF0D","Sport ⚽\uD83C\uDFC0","Cinéma & Culture Pop \uD83C\uDFAC\uD83D\uDCFA"};
        this.displaySubject(Subject);
        System.out.print("\uD83D\uDE0A Saississez votre choix :");

        int userChoice=input.nextInt();
        input.nextLine();// vider le buffer...
        this.displayQcmBaseOnUserChoice(userChoice); // affichage des questionnaires du QCM
        System.out.println("Votre score final: "+this.Points+"\n");

        this.feedBackQuiz(this.Points); // feedbacj du quiz...
    }

    private String checkUserChoice(int userChoice){
        switch (userChoice){
            case 1:
                return "Histoire";
            case 2:
                return "Sciences";
            case 3:
                return "Géographie";
            case 4:
                return "Sport";
            case 5:
                return "Cinéma & Culture Pop";
            default:
                return "Not choice";
        }
    }

    private void responseProposition(String subject, int index){
        switch (subject){
            case "Histoire":
                switch (index){
                    case 0:
                        System.out.println("A. 1776");
                        System.out.println("B. 1789");
                        System.out.println("C. 1804");
                        System.out.println("D. 1848\n");
                        break;
                    case 1:
                        System.out.println("A. Louis XIV");
                        System.out.println("B. Charlemagne");
                        System.out.println("C. Napoléon Bonaparte");
                        System.out.println("D. François Ier\n");
                        break;
                    case 2:
                        System.out.println("A. Les Mayas");
                        System.out.println("B. Les Romains");
                        System.out.println("C. Les Égyptiens");
                        System.out.println("D. Les Perses\n");
                        break;
                    case 3:
                        System.out.println("A. Voltaire");
                        System.out.println("B. Descartes");
                        System.out.println("C. Platon");
                        System.out.println("D. Aristote\n");
                        break;
                    case 4:
                        System.out.println("A. Première Guerre mondiale");
                        System.out.println("B. Guerre froide");
                        System.out.println("C. Seconde Guerre mondiale");
                        System.out.println("D. Guerre des Cent Ans\n");
                        break;
                }
                break;
            case "Sciences":
                switch (index){
                    case 0:
                        System.out.println("A. L’oxygène");
                        System.out.println("B. Le carbone");
                        System.out.println("C. L’hydrogène");
                        System.out.println("D. L’azote\n");
                        break;
                    case 1:
                        System.out.println("A. Le foie");
                        System.out.println("B. Le cœur");
                        System.out.println("C. La peau");
                        System.out.println("D. Les poumons\n");
                        break;
                    case 2:
                        System.out.println("A. 7");
                        System.out.println("B. 8");
                        System.out.println("C. 9");
                        System.out.println("D. 10\n");
                        break;
                    case 3:
                        System.out.println("A. O");
                        System.out.println("B. Au");
                        System.out.println("C. Ag");
                        System.out.println("D. Fe\n");
                        break;
                    case 4:
                        System.out.println("A. 2.14");
                        System.out.println("B. 3.14");
                        System.out.println("C. 4.14");
                        System.out.println("D. 5.14\n");
                        break;
                }
                break;
            case "Géographie":
                switch (index){
                    case 0:
                        System.out.println("A. Océan Atlantique");
                        System.out.println("B. Océan Indien");
                        System.out.println("C. Océan Pacifique");
                        System.out.println("D. Océan Arctique\n");
                        break;
                    case 1:
                        System.out.println("A. États-Unis");
                        System.out.println("B. Russie");
                        System.out.println("C. Canada");
                        System.out.println("D. Chine\n");
                        break;
                    case 2:
                        System.out.println("A. Séoul");
                        System.out.println("B. Pékin");
                        System.out.println("C. Tokyo");
                        System.out.println("D. Bangkok\n");
                        break;
                    case 3:
                        System.out.println("A. Mont Kilimandjaro");
                        System.out.println("B. Mont McKinley");
                        System.out.println("C. Mont Everest");
                        System.out.println("D. Mont Fuji\n");
                        break;
                    case 4:
                        System.out.println("A. Mer Noire");
                        System.out.println("B. Mer Rouge");
                        System.out.println("C. Mer Caspienne");
                        System.out.println("D. Mer Méditerranée\n");
                        break;
                }
                break;
            case "Sport":
                switch (index){
                    case 0:
                        System.out.println("A. 9");
                        System.out.println("B. 10");
                        System.out.println("C. 11");
                        System.out.println("D. 12\n");
                        break;
                    case 1:
                        System.out.println("A. Brésil");
                        System.out.println("B. France");
                        System.out.println("C. Allemagne");
                        System.out.println("D. Espagne\n");
                        break;
                    case 2:
                        System.out.println("A. Tennis");
                        System.out.println("B. Golf");
                        System.out.println("C. Badminton");
                        System.out.println("D. Squash\n");
                        break;
                    case 3:
                        System.out.println("A. 40 minutes");
                        System.out.println("B. 48 minutes");
                        System.out.println("C. 60 minutes");
                        System.out.println("D. 90 minutes\n");
                        break;
                    case 4:
                        System.out.println("A. Wimbledon");
                        System.out.println("B. Roland-Garros");
                        System.out.println("C. Open d’Australie");
                        System.out.println("D. US Open\n");
                        break;
                }
                break;
            case "Cinéma & Culture Pop":
                switch (index){
                    case 0:
                        System.out.println("A. Steven Spielberg");
                        System.out.println("B. Quentin Tarantino");
                        System.out.println("C. James Cameron");
                        System.out.println("D. Christopher Nolan\n");
                        break;
                    case 1:
                        System.out.println("A. Harry Potter");
                        System.out.println("B. Star Wars");
                        System.out.println("C. Le Seigneur des Anneaux");
                        System.out.println("D. Matrix\n");
                        break;
                    case 2:
                        System.out.println("A. Chris Evans");
                        System.out.println("B. Robert Downey Jr.");
                        System.out.println("C. Tom Holland");
                        System.out.println("D. Mark Ruffalo\n");
                        break;
                    case 3:
                        System.out.println("A. Clark Kent");
                        System.out.println("B. Bruce Wayne");
                        System.out.println("C. Peter Parker");
                        System.out.println("D. Tony Stark\n");
                        break;
                    case 4:
                        System.out.println("A. Star Wars");
                        System.out.println("B. Harry Potter");
                        System.out.println("C. Le Seigneur des Anneaux");
                        System.out.println("D. Game of Thrones\n");
                        break;
                }
                break;
        }
    }

    private void getQCM(String[]data, String subject){
        int index;
        System.out.println("\uD83D\uDCCC QUIZ : "+subject+" \uD83D\uDCCC");
        this.messageAboutUserChoice(subject); // Message custom en fonction du theme choisi

        for (int i=0;i<data.length;i++){
            index=(i==0)?1:i+1;
            System.out.println("➤ Question n°"+index+": "+data[i]+'\n');
            this.responseProposition(subject,i); //affichage des propositions des réponses
            System.out.print("\uD83D\uDC49 Votre réponse (A, B, C ou D) : ");
            String userResponse=input.nextLine(); //

            switch (subject){
                case "Histoire":
                    switch (i){
                        case 0:
                            if(userResponse.equals("B")){
                                this.Points+=20;
                                this.dynamicMessageAboutGoodAnswer(this.Points);
                                System.out.println("\n");
                            }else {
                                this.badResponse+=1;
                                this.dynamicMessageAboutBadAnswer(this.badResponse,"B");
                                System.out.println("\n");
                            }
                            break;
                        case 1:
                            if(userResponse.equals("C")){
                                this.Points+=20;
                                this.dynamicMessageAboutGoodAnswer(this.Points);
                                System.out.println("\n");
                            }else{
                                this.badResponse+=1;
                                this.dynamicMessageAboutBadAnswer(this.badResponse,"C");
                                System.out.println("\n");
                            }
                            break;
                        case 2:
                            if (userResponse.equals("C")){
                                this.Points+=20;
                                this.dynamicMessageAboutGoodAnswer(this.Points);
                                System.out.println("\n");
                            }else{
                                this.badResponse+=1;
                                this.dynamicMessageAboutBadAnswer(this.badResponse,"C");
                                System.out.println("\n");
                            }
                            break;
                        case 3:
                            if(userResponse.equals("B")){
                                this.Points+=20;
                                this.dynamicMessageAboutGoodAnswer(this.Points);
                                System.out.println("\n");
                            }else{
                                this.badResponse+=1;
                                this.dynamicMessageAboutBadAnswer(this.badResponse,"B");
                                System.out.println("\n");
                            }
                            break;
                        case 4:
                            if(userResponse.equals("C")){
                                this.Points+=20;
                                this.dynamicMessageAboutGoodAnswer(this.Points);
                                System.out.println("\n");
                            }else{
                                this.badResponse+=1;
                                this.dynamicMessageAboutBadAnswer(this.badResponse,"C");
                                System.out.println("\n");
                            }
                            break;
                    }
                    break;
                case "Sciences":
                    switch (i){
                        case 0:
                            if(userResponse.equals("C")){
                                this.Points+=20;
                                this.dynamicMessageAboutGoodAnswer(this.Points);
                                System.out.println("\n");
                            }else{
                                this.badResponse+=1;
                                this.dynamicMessageAboutBadAnswer(this.badResponse,"C");
                                System.out.println("\n");
                            }
                            break;
                        case 1:
                            if(userResponse.equals("C")){
                                this.Points+=20;
                                this.dynamicMessageAboutGoodAnswer(this.Points);
                                System.out.println("\n");
                            }else{
                                this.badResponse+=1;
                                this.dynamicMessageAboutBadAnswer(this.badResponse,"C");
                                System.out.println("\n");
                            }
                            break;
                        case 2:
                            if (userResponse.equals("B")){
                                this.Points+=20;
                                this.dynamicMessageAboutGoodAnswer(this.Points);
                                System.out.println("\n");
                            }else{
                                this.badResponse+=1;
                                this.dynamicMessageAboutBadAnswer(this.badResponse,"B");
                                System.out.println("\n");
                            }
                            break;
                        case 3:
                            if(userResponse.equals("B")){
                                this.Points+=20;
                                this.dynamicMessageAboutGoodAnswer(this.Points);
                                System.out.println("\n");
                            }else{
                                this.badResponse+=1;
                                this.dynamicMessageAboutBadAnswer(this.badResponse,"B");
                                System.out.println("\n");
                            }
                            break;
                        case 4:
                            if(userResponse.equals("B")){
                                this.Points+=20;
                                this.dynamicMessageAboutGoodAnswer(this.Points);
                                System.out.println("\n");
                            }else{
                                this.badResponse+=1;
                                this.dynamicMessageAboutBadAnswer(this.badResponse,"B");
                                System.out.println("\n");
                            }
                            break;
                    }
                    break;
                case "Géographie":
                    switch (i){
                        case 0:
                            if(userResponse.equals("C")){
                                this.Points+=20;
                                this.dynamicMessageAboutGoodAnswer(this.Points);
                                System.out.println("\n");
                            }else{
                                this.badResponse+=1;
                                this.dynamicMessageAboutBadAnswer(this.badResponse,"C");
                                System.out.println("\n");
                            }
                            break;
                        case 1:
                            if(userResponse.equals("B")){
                                this.Points+=20;
                                this.dynamicMessageAboutGoodAnswer(this.Points);
                                System.out.println("\n");
                            }else{
                                this.badResponse+=1;
                                this.dynamicMessageAboutBadAnswer(this.badResponse,"B");
                                System.out.println("\n");
                            }
                            break;
                        case 2:
                            if (userResponse.equals("C")){
                                this.Points+=20;
                                this.dynamicMessageAboutGoodAnswer(this.Points);
                                System.out.println("\n");
                            }else{
                                this.badResponse+=1;
                                this.dynamicMessageAboutBadAnswer(this.badResponse,"C");
                                System.out.println("\n");
                            }
                            break;
                        case 3:
                            if(userResponse.equals("C")){
                                this.Points+=20;
                                this.dynamicMessageAboutGoodAnswer(this.Points);
                                System.out.println("\n");
                            }else{
                                this.badResponse+=1;
                                this.dynamicMessageAboutBadAnswer(this.badResponse,"C");
                                System.out.println("\n");
                            }
                            break;
                        case 4:
                            if(userResponse.equals("B")){
                                this.Points+=20;
                                this.dynamicMessageAboutGoodAnswer(this.Points);
                                System.out.println("\n");
                            }else{
                                this.badResponse+=1;
                                this.dynamicMessageAboutBadAnswer(this.badResponse,"B");
                                System.out.println("\n");
                            }
                            break;
                    }
                    break;
                case "Sport":
                    switch (i){
                        case 0:
                            if(userResponse.equals("C")){
                                this.Points+=20;
                                this.dynamicMessageAboutGoodAnswer(this.Points);
                                System.out.println("\n");
                            }else{
                                this.badResponse+=1;
                                this.dynamicMessageAboutBadAnswer(this.badResponse,"C");
                                System.out.println("\n");
                            }
                            break;
                        case 1:
                            if(userResponse.equals("B")){
                                this.Points+=20;
                                this.dynamicMessageAboutGoodAnswer(this.Points);
                                System.out.println("\n");
                            }else{
                                this.badResponse+=1;
                                this.dynamicMessageAboutBadAnswer(this.badResponse,"B");
                                System.out.println("\n");
                            }
                            break;
                        case 2:
                            if (userResponse.equals("C")){
                                this.Points+=20;
                                this.dynamicMessageAboutGoodAnswer(this.Points);
                                System.out.println("\n");
                            }else{
                                this.badResponse+=1;
                                this.dynamicMessageAboutBadAnswer(this.badResponse,"C");
                                System.out.println("\n");
                            }
                            break;
                        case 3:
                            if(userResponse.equals("B")){
                                this.Points+=20;
                                this.dynamicMessageAboutGoodAnswer(this.Points);
                                System.out.println("\n");
                            }else{
                                this.badResponse+=1;
                                this.dynamicMessageAboutBadAnswer(this.badResponse,"B");
                                System.out.println("\n");
                            }
                            break;
                        case 4:
                            if(userResponse.equals("B")){
                                this.Points+=20;
                                this.dynamicMessageAboutGoodAnswer(this.Points);
                                System.out.println("\n");
                            }else{
                                this.badResponse+=1;
                                this.dynamicMessageAboutBadAnswer(this.badResponse,"B");
                                System.out.println("\n");
                            }
                            break;
                    }
                    break;
                case "Cinéma & Culture Pop":
                    switch (i){
                        case 0:
                            if(userResponse.equals("C")){
                                this.Points+=20;
                                this.dynamicMessageAboutGoodAnswer(this.Points);
                                System.out.println("\n");
                            }else{
                                this.badResponse+=1;
                                this.dynamicMessageAboutBadAnswer(this.badResponse,"C");
                                System.out.println("\n");
                            }
                            break;
                        case 1:
                            if(userResponse.equals("B")){
                                this.Points+=20;
                                this.dynamicMessageAboutGoodAnswer(this.Points);
                                System.out.println("\n");
                            }else{
                                this.badResponse+=1;
                                this.dynamicMessageAboutBadAnswer(this.badResponse,"B");
                                System.out.println("\n");
                            }
                            break;
                        case 2:
                            if (userResponse.equals("B")){
                                this.Points+=20;
                                this.dynamicMessageAboutGoodAnswer(this.Points);
                                System.out.println("\n");
                            }else{
                                this.badResponse+=1;
                                this.dynamicMessageAboutBadAnswer(this.badResponse,"B");
                                System.out.println("\n");
                            }
                            break;
                        case 3:
                            if(userResponse.equals("C")){
                                this.Points+=20;
                                this.dynamicMessageAboutGoodAnswer(this.Points);
                                System.out.println("\n");
                            }else{
                                this.badResponse+=1;
                                this.dynamicMessageAboutBadAnswer(this.badResponse,"C");
                                System.out.println("\n");
                            }
                            break;
                        case 4:
                            if(userResponse.equals("B")){
                                this.Points+=20;
                                this.dynamicMessageAboutGoodAnswer(this.Points);
                                System.out.println("\n");
                            }else{
                                this.badResponse+=1;
                                this.dynamicMessageAboutBadAnswer(this.badResponse,"B");
                                System.out.println("\n");
                            }
                            break;
                    }
                    break;
                default:
                    break;
            }

        }
    }

    private void userQCMChoice(String userChoice){
        switch (userChoice){
            case "Histoire":
                this.getQCM(HistoireQCM,"Histoire");
                break;
            case "Sciences":
                this.getQCM(SciencesQCM,"Sciences");
                break;
            case "Géographie":
                this.getQCM(GeographieQCM,"Géographie");
                break;
            case "Sport":
                this.getQCM(SportQCM,"Sport");
                break;
            case "Cinéma & Culture Pop":
                this.getQCM(CinePopQCM,"Cinéma & Culture Pop");
                break;
            default:
                this.getQCM(CinePopQCM,"Cinéma & Culture Pop");
        }
    }

    private void displayQcmBaseOnUserChoice(int userChoice){
        //Recuperation du choix de l'utilisateur...
        String getUserChoice=this.checkUserChoice(userChoice);
        this.userQCMChoice(getUserChoice);
    }

    /**
     * messageAbourUserChoice affiche les messages en fonctions du theme choisi
     * @param userChoice
     */
    private void messageAboutUserChoice(String userChoice){
        switch (userChoice){
            case "Histoire":
                System.out.println("Excellent choix ! Plongeons ensemble dans le passé et découvrons si vous êtes un véritable historien en herbe !\n");
                break;
            case "Sciences":
                System.out.println("Préparez-vous à explorer les mystères de la science ! De la physique aux découvertes médicales, c’est parti pour un voyage dans le savoir !\n");
                break;
            case "Géographie":
                System.out.println("Embarquement immédiat pour un tour du monde en questions ! Saurez-vous repérer chaque pays et capitale ?\n");
                break;
            case "Sport":
                System.out.println("À vos marques, prêts, partez ! Montrez-nous si vous avez l’étoffe d’un champion du savoir sportif !\n");
                break;
            case "Cinéma & Culture Pop":
                System.out.println("Action ! Plongeons dans l’univers du grand écran et des séries mythiques. Lumière, caméra… quiz !\n");
        }
    }

    /**
     * dynamicMessageAboutBadAnswer affiche des messages
     * dynamiquement en fonction des erreurs...
     * @param badResponse
     * @param goodResponse
     */

    private void dynamicMessageAboutBadAnswer(int badResponse, String goodResponse){
        switch (badResponse){
            case 1:
                System.out.println("❌ Oups… Ce n'était pas la bonne réponse. La bonne était "+goodResponse+" ");
                break;
            case 2:
                System.out.println("\uD83D\uDE2C Pas tout à fait… Mais ne vous inquiétez pas, vous ferez mieux à la prochaine !");
                break;
            case 3:
                System.out.println("\uD83D\uDEAB Raté ! Mais l’erreur est humaine, on continue !");
                break;
            case 4:
                System.out.println("\uD83D\uDCDA Dommage ! La bonne réponse était "+goodResponse+". Notez-la pour la prochaine fois.");
                break;
            case 5:
                System.out.println("\uD83E\uDD14 Ce n'est pas ça... mais ne perdez pas espoir, la prochaine sera peut-être la bonne !");
                break;
        }
    }

    /**
     * dynamicMessageAboutGoodAnswer affiche des messages
     * dynamiquement en fonction des reponses correcte...
     * @param Points
     */

    private void dynamicMessageAboutGoodAnswer(int Points){
        switch (Points){
            case 20:
                System.out.println("🎉 Bravo ! Vous avez vu juste, continuez comme ça !");
                break;
            case 40:
                System.out.println("✅ Exactement ! Vous êtes sur une belle lancée.");
                break;
            case 60:
                System.out.println("\uD83D\uDC4F Bonne réponse ! Vous semblez maîtriser le sujet.");
                break;
            case 80:
                System.out.println("\uD83D\uDD25 Parfait ! Vous avez l’œil d’un véritable expert.");
                break;
            case 100:
                System.out.println("\uD83D\uDCA1 C’est tout à fait ça ! Vous êtes incollable sur cette question.");
                break;
        }
    }

    /**
     * feedBackQuiz affiche un message
     * dynamiquement en fonction des points gagnés par
     * l'utilisateur...
     * @param Points
     */

    private void feedBackQuiz(int Points){
        switch (Points){
            case 0:
                System.out.println("🎉\uD83D\uDC80 "+Points+" point (0/5 corrects) - Échec total");
                System.out.println("Ouch... On ne peut pas être bon partout ! Il est peut-être temps de réviser un peu... \uD83D\uDCDA");
                break;
            case 20:
                System.out.println("\uD83D\uDE13"+Points+" points (1/5 corrects) - Peut mieux faire");
                System.out.println("C’est un début, mais il va falloir s’accrocher ! Vous pouvez faire mieux, j’en suis sûr ! \uD83D\uDCAA");
                break;
            case 40:
                System.out.println("\uD83D\uDE05"+Points+" points (2/5 corrects) - Pas mal, mais encore du chemin");
                System.out.println("Quelques bonnes réponses, mais encore du travail avant d’être un expert. Continuez comme ça ! \uD83D\uDE80");
                break;
            case 60:
                System.out.println(Points+" points (3/5 corrects) - Correct, mais pas encore parfait");
                System.out.println("Vous êtes sur la bonne voie ! Encore un petit effort et ce sera parfait. \uD83D\uDD25");
                break;
            case 80:
                System.out.println("\uD83D\uDE0E"+Points+" points (4/5 corrects) - Très bien joué !");
                System.out.println("Wow, presque parfait ! Un excellent score, vous connaissez bien votre sujet. \uD83C\uDF89");
                break;
            case 100:
                System.out.println("\uD83E\uDD29"+Points+" points (5/5 corrects) - Score parfait !");
                System.out.println("INCROYABLE ! Vous êtes un véritable expert ! \uD83C\uDFC6 Vous méritez les applaudissements ! \uD83D\uDC4F");
                break;
        }
    }





}
